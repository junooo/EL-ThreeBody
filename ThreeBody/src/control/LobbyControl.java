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
	private String id = AccountDTO.getInstance().getId();
	
	/**
	 * 
	 * @param room 进去了的房间的号码
	 * @return 进去了的房间的RoomService
	 */
	public RoomControl getRoomService(Room room){
		try {
			return new RoomControl(rmilb.getRoomService(room.getName()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @return 服务器大厅上的房间
	 */
	public List<Room> getRooms(){
		setUpRMILB();
        try {
			return rmilb.getRooms();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        return null;
    }
    
	/**
	 * 
	 * @param room 玩家点击想进去的房间
	 * @return NOT_EXISTED：房间不存在
	 * @return ROOM_FULL：房间满人
	 * @return SUCCESS：成功进入
	 */
    public R.info enterRoom(Room room){
    	setUpRMILB();
        try {
			return rmilb.enterRoom(id, room.getName());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    /**
     * 
     * @param roomName 玩家设定的房间名字
     * @param size 房间要求的玩家数 
     * @return ALREADY_EXISTED：房间名已存在
     * @return SUCCESS：成功创建
     */
    public R.info createRoom(String roomName,int size){
    	setUpRMILB();
    	try{
    		return rmilb.createRoom(roomName,id,size);
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
