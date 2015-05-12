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

	/**
	 * 
	 * @return SUCCESS：准备好
	 */
	public R.info ready(){
		try {
			return rmir.ready(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return SUCCESS：取消准备
	 */
	public R.info cancelReady(){
		try {
			return rmir.cancelReady(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return INVALID：有玩家没准备好
	 *         SUCCESS: 成功开始
	 */
	public R.info start(){
		try {
			return rmir.start();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return SUCCESS: 成功离开房间
	 */
	public R.info exit(){
		try {
			return rmir.exit(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return 刷新后的Room
	 */
	public Room refresh(){
		try {
			return rmir.refresh();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return GameControl对象
	 */
	public GameControl getGameService(){
		try {
			return new GameControl(rmir.getGameServer());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
