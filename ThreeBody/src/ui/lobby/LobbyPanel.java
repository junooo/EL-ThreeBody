package ui.lobby;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Room;
import ui.FrameUtil;
import control.LobbyControl;
import control.MainControl;

public class LobbyPanel extends JPanel implements MouseWheelListener {
	private static final long serialVersionUID = 1L;
	private MainControl mainControl;
	private JButton btn_createRoom;
	private JButton btn_lobbyReturn;

	private List<JButton> roomFamily = new ArrayList<JButton>();
	private List<Room> roomList;
	private List<Rectangle> locationSave = new ArrayList<Rectangle>();
	private LobbyControl lobbyControl;
	//双缓冲机制
	private Image iBuffer;
	private Graphics gBuffer;
	public LobbyPanel(MainControl mc) {
		this.setLayout(null);
		this.mainControl = mc;
		this.lobbyControl = mc.lobbyControl;
		this.initLocation();
		this.initComonent();
		this.addMouseWheelListener(this);
		this.roomList = lobbyControl.getRooms();
		this.createRooms();
	}

	private void createRooms() {
		for (int i = 0; i < roomList.size(); i++) {
			this.addRoom(i);
		}
		for (int i = 0; i < roomFamily.size(); i++) {
			this.add(roomFamily.get(i));
		}
	}
	
	private void initLocation(){
		for (int i = 0; i < 97; i++) {
			this.locationSave.add(new Rectangle(50+350*i,200,300,125));
		}
	}
	
	public void refresh(){
		this.roomList = lobbyControl.getRooms();
		this.roomFamily.clear();
		for (int i = 0; i < roomList.size(); i++) {
			this.addRoom(i);
		}
		this.removeAll();
		this.initComonent();

		this.createRooms(locationSave);
		this.mainControl.frame.setContentPane(this);
	}
	
	private void createRooms(List<Rectangle> locationSave) {
		for (int i = 0; i < roomFamily.size(); i++) {
			this.roomFamily.get(i).setBounds(locationSave.get(i));
		}		
		for (int i = 0; i < roomFamily.size(); i++) {
			this.add(roomFamily.get(i));
		}
	}

	// 添加房间的按钮
	private void addRoom(int roomNumber) {
		JButton room = new JButton();
		JPanel roomPanel = new ButtonPanel(this.roomList.get(roomNumber));
	
		Rectangle rect = this.locationSave.get(roomNumber);
		room.setBounds(rect);
		roomPanel.setBounds(rect);

		room.setContentAreaFilled(false);
		room.addMouseListener(new EnterListener(roomList.get(roomNumber).getName()));
		room.add(roomPanel);
		this.roomFamily.add(roomNumber,room);
	}
	


	public void initComonent() {
		// lobby room 3*2
		this.btn_createRoom = new JButton();
		this.btn_createRoom.setIcon(new ImageIcon("images/newroom.png"));
		this.btn_createRoom.setContentAreaFilled(false);
		this.btn_createRoom.setBounds(650, 500, 100, 50);
		this.btn_createRoom.addMouseListener(new CreateRoomListener());
		this.add(btn_createRoom);

		this.btn_lobbyReturn = new JButton();
		this.btn_lobbyReturn.setIcon(new ImageIcon("images/roomreturn.png"));
		this.btn_lobbyReturn.setContentAreaFilled(false);
		this.btn_lobbyReturn.setBounds(850, 500, 100, 50);
		this.btn_lobbyReturn.addMouseListener(new ReturnListener());
		this.add(btn_lobbyReturn);
	}
	@Override
	public void update(Graphics scr)
	{
	    if(iBuffer==null)
	    {
	       iBuffer=createImage(this.getSize().width,this.getSize().height);
	       gBuffer=iBuffer.getGraphics();
	    }
	       gBuffer.setColor(getBackground());
	       gBuffer.fillRect(0,0,this.getSize().width,this.getSize().height);
	       paint(gBuffer);
	       scr.drawImage(iBuffer,0,0,this);
	}
	public void paintComponent(Graphics g) {
		Image background = new ImageIcon("images/模糊背景.jpg").getImage();
		g.drawImage(background, 0, 0, null);
	}

	class EnterListener extends MouseAdapter  {
		String roomName;
		public EnterListener(String roomName) {
			this.roomName = roomName;
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			switch(lobbyControl.enterRoom(roomName)){
			case SUCCESS:
				lobbyControl.changeEntered();
				mainControl.toRoom(roomName);
				break;
			case ROOM_FULL:
				FrameUtil.sendMessageByFrame("房间已满", "房间已满");
				break;
			case NOT_EXISTED:
				FrameUtil.sendMessageByFrame("房间不存在", "房间不存在");
				break;
			default:
				break;
			}
		}
	}

	class CreateRoomListener extends MouseAdapter  {
		@Override
		public void mouseReleased(MouseEvent e) {
			JFrame createRoomFrame = new CreateRoomFrame();
			JPanel createRoomPanel = new CreateRoomPanel(createRoomFrame,
					lobbyControl,mainControl);
			createRoomFrame.setContentPane(createRoomPanel);
		}
	}

	class ReturnListener extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			lobbyControl.changeEntered();
			mainControl.toStartMenu();
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() == 1) {
			// 往左跑
			for (int i = 0; i < roomFamily.size(); i++) {
				Rectangle rec =locationSave.get(i);
				rec.x = rec.x - 50;
				roomFamily.get(i).setBounds(rec);
			}
			for (int i = 0; i < 97; i++) {
				Rectangle rec =locationSave.get(i);
				rec.x = rec.x - 50;
				locationSave.set(i,rec);
			}
		}
		if (e.getWheelRotation() == -1) {
			// 往右跑
			for (int i = 0; i < roomFamily.size(); i++) {
				Rectangle rec =locationSave.get(i);
				rec.x = rec.x + 50;
				roomFamily.get(i).setBounds(rec);
			}
			for (int i = 0; i < 97; i++) {
				Rectangle rec =locationSave.get(i);
				rec.x = rec.x + 50;
				locationSave.set(i,rec);
			}
		}
	}
}
