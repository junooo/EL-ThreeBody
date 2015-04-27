package server.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import util.R;
import model.Account;
import model.Room;

public interface RMILobby extends Remote {

	List<Room> getRooms() throws RemoteException;

	R.info enterRoom(Account account, Room room) throws RemoteException;

	R.info createRoom(Room room) throws RemoteException;

}
