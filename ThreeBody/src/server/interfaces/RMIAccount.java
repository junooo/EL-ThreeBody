package server.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import util.R;
import model.Account;

public interface RMIAccount extends Remote {

	R.info logout(Account account) throws RemoteException;

	R.info login(String id, String password) throws RemoteException;

	R.info uploadChange(Account account) throws RemoteException;
	
	R.info downloadChange(Account account) throws RemoteException;

	R.info logUp(String id, String password, String invitationID)
			throws RemoteException;

	R.info loginByTransientID(String id, String transientID) throws RemoteException;
	
	R.info checkLink() throws RemoteException;
	
	//TODO ≤‚ ‘÷–
	R.info test(String command);
}
