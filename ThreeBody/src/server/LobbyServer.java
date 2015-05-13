package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import model.Room;
import server.interfaces.RMILobby;
import server.interfaces.RMIRoom;
import util.R;
import util.R.info;

public class LobbyServer extends UnicastRemoteObject implements RMILobby{

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	
	private AccountCenter accountCenter;
	private Map<String,Room> rooms;
	private Map<String,RoomServer> actives;

	protected LobbyServer(AccountCenter ac) throws RemoteException {
		super();
		this.accountCenter = ac;
		rooms = new HashMap<String,Room>();
		actives = new HashMap<String,RoomServer>();
		
		try {
			Naming.rebind("LobbyServer",this);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public LinkedList<Room> getRooms() throws RemoteException {
		LinkedList<Room> rooms = new LinkedList<Room>();
		for (Room room : this.rooms.values()) {
			rooms.add(room);
		}
		return rooms;
	}

	/**
	 * 客户端的数据不一定是最新的，所以检查很重要
	 */
	@Override
	public info enterRoom(String id, String roomName) throws RemoteException {
		Room rm = rooms.get(roomName);
		// 房间不存在
		if(rm == null){
			return R.info.NOT_EXISTED;
		}
		return rm.enterRoom(accountCenter.getAccount(id));
	}

	@Override
	public info createRoom(String name,String createrID,int size) throws RemoteException {
		// 房间名已存在
		if(rooms.containsKey(name)){
			return R.info.ALREADY_EXISTED;
		}
		Room newRoom = new Room(accountCenter.getAccount(createrID),name,size);
		rooms.put(name, newRoom);
		actives.put(name, new RoomServer(this,newRoom));
		return R.info.SUCCESS;
	}

	@Override
	public RMIRoom getRoomService(String roomName) throws RemoteException {
		return actives.get(roomName);
	}
	
	Room rm1;
	Room rm2;
	
	@Override
	public info command(String command) throws RemoteException {
		switch(command){
		case "init":
			createRoom("Room1","Red",4);
			createRoom("Room2","Blue",2);
			rm1 = getRoomService("Room1").refresh();
			rm2 = getRoomService("Room2").refresh();
			return R.info.SUCCESS;
		case "clear":
			deleteRoom(rm1);
			deleteRoom(rm2);
			return R.info.SUCCESS;
		}
		return R.info.INVALID;
	}

	public void deleteRoom(Room room){
		rooms.remove(room.getName());
		actives.remove(room.getName());
	}

}
