package server.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import util.R;
import model.operation.Operation;

public interface RMIGame extends Remote{
	
	List<Operation> downloadOperation() throws RemoteException;
	
	R.info uploadOperation(List<Operation> unhandled) throws RemoteException;

}
