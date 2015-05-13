package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.rmi.PortableRemoteObject;

import model.Account;
import server.AccountServer.State;
import server.interfaces.RMIAccount;
import server.interfaces.RMIAccountCenter;
import util.R;
import util.R.info;

/**
 * 
 * @author Sissel
 * 
 *         这个类作为单一对象给客户端登陆，并分发各自的后续连接端口
 */
public class AccountCenter extends UnicastRemoteObject implements
		RMIAccountCenter {

	private static final long serialVersionUID = 1L;

	/*
	 * 对应整个服务器上的全部account
	 */
	private Map<String, Account> accounts;
	
	/*
	 * 账号密码对照
	 */
	private Map<String, String> passwords;
	
	/*
	 * 账号暂时登陆码对照
	 */
	private Map<String, String> transientIDs;
	
	/*
	 * 在运行的服务
	 */
	private Map<String, AccountServer> actives;
	
	/*
	 * 邀请码
	 */
	private Set<String> invitationIDs;
	
	/*
	 * 数据库交互
	 */
	private ServerDatabase database;

	protected AccountCenter() throws RemoteException {
		try {
			database = ServerDatabase.getInstance();
			database.openDB();
			database.loadData();
			
			this.accounts = database.getAccounts();
			this.passwords = database.getPasswords();
			this.transientIDs = database.getTransientIDs();
			this.invitationIDs = database.getInvitationIDs();
			this.actives = new HashMap<String, AccountServer>();
			
			Naming.rebind("AccountCenter", (RMIAccountCenter)this);
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 退出但不删除transientID
	 */
	@Override
	public info logout(String id) throws RemoteException {
		if(actives.containsKey(id)){
			this.informLogout(id);
			return R.info.SUCCESS;
		}else{
			return R.info.NOT_EXISTED;
		}
	}
	
	/**
	 * 退出且删除transientID
	 */
	@Override
	public info logoutAndClear(String id) throws RemoteException {
		if(actives.containsKey(id)){
			this.informLogout(id);
			transientIDs.remove(id);
			return R.info.SUCCESS;
		}else{
			return R.info.NOT_EXISTED;
		}
	}

	@Override
	public info login(String id, String password) throws RemoteException {
		Account account = accounts.get(id);
		if(actives.containsKey(id)){
			return R.info.ALREADY_IN;
		}
		if (account == null) {
			return R.info.NOT_EXISTED;
		} else if (!passwords.get(id).equals(password)) {
			return R.info.INVALID;
		}
		// 生成暂时登陆码
	    transientIDs.put(id, generateRandomTransientID());
	    // 分发远程对象
		this.dispatchAccountServer(account);
		return R.info.SUCCESS;
	}

	@Override
	public info logUp(String id, String password, String invitationID)
			throws RemoteException {
		if (accounts.containsKey(id)) {
			return R.info.ALREADY_EXISTED;
		} else if (!invitationIDs.contains(invitationID)) {
			return R.info.NOT_EXISTED;
		}
		// 移除已经使用的邀请码
		invitationIDs.remove(invitationID);
		// 生成账号
		Account newAccount = new Account(id);
		accounts.put(id, newAccount);
		passwords.put(id, password);
		// 生成暂时登陆码
		transientIDs.put(id, generateRandomTransientID());
		// 分发远程对象
		this.dispatchAccountServer(newAccount);
		return R.info.SUCCESS;
	}

	/**
	 * 使用transientID登陆
	 */
	@Override
	public info loginByTransientID(String id, String transientID)
			throws RemoteException {
		Account account = accounts.get(id);
		if(actives.containsKey(id)){
			return R.info.ALREADY_IN;
		}
		if (account == null) {
			return R.info.NOT_EXISTED;
		} else if (transientIDs.get(id) == null || !transientIDs.get(id).equals(transientID)) {
			return R.info.INVALID;
		}
		this.dispatchAccountServer(account);
		return R.info.SUCCESS;
	}

	@Override
	public String command(String command) {
		
		String[] parts = command.split(" ");
		StringBuffer sb;

		switch (parts[0]) {
		case "init":
			accounts.put("Red", new Account("Red"));
			accounts.put("Green", new Account("Green"));
			accounts.put("Blue", new Account("Blue"));
			accounts.put("Yellow", new Account("Yellow"));
			passwords.put("Red", "r1234");
			passwords.put("Green", "g1234");
			passwords.put("Blue", "b1234");
			passwords.put("Yellow", "y1234");
			invitationIDs.add("fffff1");
			invitationIDs.add("fffff2");
			invitationIDs.add("fffff3");
			invitationIDs.add("fffff4");
			return R.info.SUCCESS.name();
		case "clear":
			accounts.clear();
			passwords.clear();
			invitationIDs.clear();
			return R.info.SUCCESS.name();
		case "add_account":
			Account acc = new Account(parts[1]);
			accounts.put(parts[1], acc);
			passwords.put(parts[1], parts[2]);
			return "success";
		case "add_invitationID":
			invitationIDs.add(parts[1]);
			return "now size:"+invitationIDs.size();
		case "check_connections":
			sb = new StringBuffer();
			sb.append("connections:"+actives.size()+"\n");
			for (String name : actives.keySet()) {
				sb.append(name+"\n");
			}
			return sb.toString();
		case "check_invitationIDs":
			sb = new StringBuffer();
			sb.append("invitationIDs:"+invitationIDs.size()+"\n");
			for (String invitationID : invitationIDs) {
				sb.append(invitationID+"\n");
			}
			return sb.toString();
		case "check_accounts":
			sb = new StringBuffer();
			sb.append("accounts:"+accounts.size()+"\n");
			for (String name : accounts.keySet()) {
				sb.append(name+"\n");
			}
			return sb.toString();
		}

		return R.info.INVALID.name();
	}

	@Override
	public RMIAccount getService(String id) {
		return actives.get(id);
	}

	@Override
	public String getTransientID(String id) {
		return transientIDs.get(id);
	}
	
	public Account getAccount(String id){
		return accounts.get(id);
	}
	
	/**
	 * 生成暂时登陆码
	 */
	private static String generateRandomTransientID(){
		Random random = new Random();
		String result = "k";
		for (int i = 0; i < 10; i++) {
			result += random.nextInt(9);
		}
		return result;
	}
	
	private void dispatchAccountServer(Account account) {
		try {
			if(!actives.containsKey(account.getId())){
				AccountServer as = new AccountServer(this, account);
				actives.put(account.getId(), as);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void informLogout(String id) {
		actives.get(id).setState(State.FAIL);
	}
	
	public void unbindAccount(Account account){
		try {
			PortableRemoteObject.unexportObject(actives.get(account.getId()));
		} catch (NoSuchObjectException e) {
			e.printStackTrace();
		}
		actives.remove(account.getId());
	}
	
	// TODO 保存Account
	public void saveAccount(Account account) {
		accounts.put(account.getId(), account);
		
	}
	
}
