package control;

import io.NetClient;

import java.rmi.RemoteException;
import java.util.List;

import model.Room;
import server.interfaces.RMILobby;
import util.R;
import dto.AccountDTO;

/*
 * 游戏大厅的控制类
 */
public class LobbyControl {
	
	private RMILobby rmilb;
	
	public RoomControl getRoomService(Room room){
		try {
			return new RoomControl(rmilb.getRoomService(room.getName()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Room> getRooms(){
		setUpRMILB();
        try {
			return rmilb.getRooms();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public R.info enterRoom(Room room){
    	setUpRMILB();
        try {
			return rmilb.enterRoom(AccountDTO.getInstance().getId(), room.getName());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public R.info createRoom(Room room){
    	setUpRMILB();
    	try{
    		return rmilb.createRoom(room);
    	}catch(RemoteException e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    private void setUpRMILB(){
    	if(rmilb == null){
    		rmilb = NetClient.getInstance().getLobbyServer();
    	}
    }

}
