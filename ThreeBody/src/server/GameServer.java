package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.Account;
import model.Player;
import model.operation.Operation;
import server.interfaces.RMIGame;
import util.R;
import util.R.info;
import util.RandomHelper;

public class GameServer extends UnicastRemoteObject implements RMIGame{
	
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String,List<Operation>> unhandledOperations;
	private List<Player> players;

	protected GameServer(List<Account> accounts) throws RemoteException {
		super();
		unhandledOperations = new HashMap<String,List<Operation>>();
		for (Account account : accounts) {
			unhandledOperations.put(account.getId(), new LinkedList<Operation>());
		}
	}
	
	// TODO 角色数量配置
	private void initGame(){
		RandomHelper rh = new RandomHelper(players.size());
	}

	@Override
	public List<Operation> downloadOperation(String id) throws RemoteException {
		List<Operation> result = unhandledOperations.get(id);
		unhandledOperations.put(id, new LinkedList<Operation>());
		return result;
	}

	@Override
	public info uploadOperation(String id, List<Operation> unhandled)
			throws RemoteException {
		for (Entry<String,List<Operation>> entries : unhandledOperations.entrySet()) {
			if(entries.getKey()!=id){
				entries.getValue().addAll(unhandled);
			}
		}
		return R.info.SUCCESS;
	}

	@Override
	public List<Player> getPlayers() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
