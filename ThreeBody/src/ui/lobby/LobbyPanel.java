package ui.lobby;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Room;
import control.LobbyControl;
import control.MainControl;

public class LobbyPanel extends JPanel implements MouseWheelListener{
	private static final long serialVersionUID = 1L;
	private MainControl mc;
	private JButton createRoom;
	private JButton lobbyReturn;
	
	private int numOfRoom;
	private ArrayList<JButton> roomFamily = new ArrayList<>();
	private List<Room> roomList;
	private LobbyControl lobbyControl = new LobbyControl();
	public LobbyPanel(MainControl mc){
		this.setLayout(null);
		this.mc = mc;
		roomList=lobbyControl.getRooms();
		numOfRoom=roomList.size();
		numOfRoom=1;
		createRoom();
		this.initComonent();
		this.addMouseWheelListener(this);
		
	}
	
	

	private void createRoom() {
		for (int i = 0; i < numOfRoom; i++) {
			addRoom(i);
		}
		for (int i = 0; i < roomFamily.size(); i++) {
			this.add(roomFamily.get(i));
		}
	}
	
	
	//添加房间的按钮
	private void addRoom(int roomNumber) {
		JButton room = new JButton();
//		JPanel roomPanel = new ButtonPanel(this.roomList.get(roomNumber));
		JPanel roomPanel = new ButtonPanel(new Room(null, "南大花房", 3));
		if(roomNumber!=0){
			Rectangle rect = roomFamily.get(roomFamily.size()-1).getBounds();
			rect.x=rect.x+350;
			room.setBounds(rect);
			roomPanel.setBounds(rect);
		}else{
			room.setBounds(50,200,300,125);
			roomPanel.setBounds(50,200,300,125);
		}
		room.setContentAreaFilled(false);
		room.addMouseListener(new EnterListener(roomNumber));
		room.add(roomPanel);
		roomFamily.add(room);
	}

	private void refresh() {
		mc.toLobby();
	}
	public void initComonent(){
	 //lobby room 3*2
	    
	    this.createRoom=new JButton();
	    this.createRoom.setIcon(new ImageIcon("newroom.png"));
	    this.createRoom.setContentAreaFilled(false);
	  	this.createRoom.setBounds(650,500,100,50);
	  	this.createRoom.addMouseListener(new CreateRoomListener());
	    this.add(createRoom);
	    
	    
	    this.lobbyReturn=new JButton();
	    this.lobbyReturn.setIcon(new ImageIcon("roomreturn.png"));
	    this.lobbyReturn.setContentAreaFilled(false);
	  	this.lobbyReturn.setBounds(850,500,100,50);
	  	this.lobbyReturn.addMouseListener(new ReturnListener());
	    this.add(lobbyReturn);
	}

	
	public void FourPerRoom(){
	}
    public void SixPerRoom(){
	}
    public void EightPerRoom(){
    }
	
	
	public void paintComponent(Graphics g) {
		  Image background=new ImageIcon("模糊背景.jpg").getImage();
		  g.drawImage(background,0,0,null);
		 
	}
	
	class EnterListener implements MouseListener{
		int roomId;
		public EnterListener(int roomId){
			this.roomId=roomId;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			mc.toGame();
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
	}
	
	
class CreateRoomListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			JFrame createRoomFrame = new CreateRoomFrame();
			JPanel createRoomPanel = new CreateRoomPanel(createRoomFrame,lobbyControl);
			createRoomFrame.setContentPane(createRoomPanel);
			addRoom(roomFamily.size());
			add(roomFamily.get(roomFamily.size()-1));
			refresh();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		
}		
		
		
class ReturnListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		mc.toStartMenu();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
}


@Override
public void mouseWheelMoved(MouseWheelEvent e) {
	
	if(e.getWheelRotation()==1){
      //往左跑
        for (int i = 0; i <roomFamily.size(); i++) {
        	Rectangle rec = roomFamily.get(i).getBounds();
        	rec.x = rec.x-50;
        	roomFamily.get(i).setBounds(rec);
		}
    }
    if(e.getWheelRotation()==-1){
        //往左跑
        for (int i = 0; i <roomFamily.size(); i++) {
        	Rectangle rec = roomFamily.get(i).getBounds();
        	rec.x = rec.x+50;
        	roomFamily.get(i).setBounds(rec);
		}
    }
	
}
}
