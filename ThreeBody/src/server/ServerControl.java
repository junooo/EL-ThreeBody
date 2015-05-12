package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.interfaces.RMIServerControl;

public class ServerControl extends UnicastRemoteObject implements RMIServerControl{
	
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;


	protected ServerControl() throws RemoteException {
		super();
		try {
			accountCenter = new AccountCenter();
			lobbyServer = new LobbyServer(accountCenter);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	AccountCenter accountCenter;
	LobbyServer lobbyServer;
		

	public static void main(String[] args) {
		try {
			new ServerControl();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String command(String command) throws RemoteException {
		switch(command){
		case "shut down":
			try {
				Naming.unbind("AccountCenter");
				Naming.unbind("LobbyServer");
				System.exit(0);
			} catch (MalformedURLException | NotBoundException e) {
				e.printStackTrace();
			}
			return "shut down successfully";
		case "reboot":
			
		}
		return "INVALID";
	}


}
