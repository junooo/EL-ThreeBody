package server.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIRoom extends Remote {

	String ready() throws RemoteException;

	String cancelReady() throws RemoteException;

	String start() throws RemoteException;

	String exit() throws RemoteException;

}
