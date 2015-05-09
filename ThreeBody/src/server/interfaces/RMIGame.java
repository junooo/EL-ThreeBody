package server.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.Player;
import model.operation.Operation;
import util.R;

public interface RMIGame extends Remote{
	
	List<Operation> downloadOperation(String id) throws RemoteException;
	
	List<Player> getPlayers() throws RemoteException;
	
	R.info uploadOperation(String id,List<Operation> unhandled) throws RemoteException;

}
