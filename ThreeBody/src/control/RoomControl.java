package control;

import java.rmi.RemoteException;

import model.Room;
import server.interfaces.RMIRoom;
import util.R;
import dto.AccountDTO;

public class RoomControl {
	
	RMIRoom rmir;
	String id = AccountDTO.getInstance().getId();
	
	public RoomControl(RMIRoom rmir) {
		this.rmir = rmir;
	}

	public R.info ready(){
		try {
			return rmir.ready(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public R.info cancelReady(){
		try {
			return rmir.cancelReady(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public R.info start(){
		try {
			return rmir.start();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public R.info exit(){
		try {
			return rmir.exit(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Room refresh(){
		try {
			return rmir.refresh();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public GameControl getGameService(){
		try {
			return new GameControl(rmir.getGameServer());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
