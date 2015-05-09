package server;

import java.rmi.RemoteException;

public class ServerControl {
	
	AccountCenter accountCenter;
	LobbyServer lobbyServer;
	
	public ServerControl() {
		try {
			accountCenter = new AccountCenter();
			lobbyServer = new LobbyServer(accountCenter);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerControl();
	}

}
