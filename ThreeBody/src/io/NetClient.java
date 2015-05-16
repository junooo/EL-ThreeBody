package io;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.interfaces.RMIAccountCenter;
import server.interfaces.RMIImage;
import server.interfaces.RMILobby;


public class NetClient {
    
	private RMIAccountCenter rmiac;
	private RMILobby rmilb;
	private RMIImage rmii;
	private static NetClient instance;
	
	private NetClient(){
		try {
			rmiac = (RMIAccountCenter)Naming.lookup("rmi://104.236.174.190/AccountCenter");
			rmilb = (RMILobby)Naming.lookup("rmi://104.236.174.190/LobbyServer");
			rmii = (RMIImage) Naming.lookup("rmi://104.236.174.190/ImgService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static NetClient getInstance(){
		if(instance == null){
			instance = new NetClient();
		}
		return instance;
	}
	
	public RMIAccountCenter getAccountCenter(){
		return rmiac;
	}
	
    public RMILobby getLobbyServer(){
    	return rmilb;
    }
    
    public RMIImage getImageServer(){
    	return rmii;
    }

}
