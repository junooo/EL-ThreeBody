package server.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RMIServerControl extends Remote{
	
	String command(String command) throws RemoteException;

}
