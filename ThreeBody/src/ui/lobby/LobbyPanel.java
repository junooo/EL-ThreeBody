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
import control.LobbyControl;
import control.MainControl;

public class LobbyPanel extends JPanel implements MouseWheelListener {
	private static final long serialVersionUID = 1L;
	private MainControl mc;
	private JButton btn_createRoom;
	private JButton btn_lobbyReturn;

	private List<JButton> roomFamily = new ArrayList<JButton>();
	private List<Room> roomList;
	private LobbyControl lobbyControl;

	public LobbyPanel(MainControl mc) {
		this.setLayout(null);
		this.mc = mc;
		lobbyControl = mc.lobbyControl;
		this.initComonent();
		this.addMouseWheelListener(this);
		roomList = lobbyControl.getRooms();
		createRooms();
	}

	private void createRooms() {
		for (int i = 0; i < roomList.size(); i++) {
			addRoom(i);
		}
		for (int i = 0; i < roomFamily.size(); i++) {
			this.add(roomFamily.get(i));
		}
	}

	// 添加房间的按钮
	private void addRoom(int roomNumber) {
		JButton room = new JButton();
		JPanel roomPanel = new ButtonPanel(this.roomList.get(roomNumber));
		if (roomNumber != 0) {
			Rectangle rect = roomFamily.get(roomFamily.size() - 1).getBounds();
			rect.x = rect.x + 350;
			room.setBounds(rect);
			roomPanel.setBounds(rect);
		} else {
			room.setBounds(50, 200, 300, 125);
			roomPanel.setBounds(50, 200, 300, 125);
		}
		room.setContentAreaFilled(false);
		room.addMouseListener(new EnterListener(roomNumber));
		room.add(roomPanel);
		roomFamily.add(room);
	}

	public void refresh() {
		mc.toLobby();
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

	public void paintComponent(Graphics g) {
		Image background = new ImageIcon("images/模糊背景.jpg").getImage();
		g.drawImage(background, 0, 0, null);
	}

	class EnterListener extends MouseAdapter  {
		int roomId;
		public EnterListener(int roomId) {
			this.roomId = roomId;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			mc.toRoom(roomList.get(roomId));
		}
	}

	class CreateRoomListener extends MouseAdapter  {
		@Override
		public void mouseClicked(MouseEvent e) {
			JFrame createRoomFrame = new CreateRoomFrame();
			JPanel createRoomPanel = new CreateRoomPanel(createRoomFrame,
					lobbyControl);
			createRoomFrame.setContentPane(createRoomPanel);
//			addRoom(roomFamily.size());
//			add(roomFamily.get(roomFamily.size() - 1));
		}
	}

	class ReturnListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			mc.toStartMenu();
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() == 1) {
			// 往左跑
			for (int i = 0; i < roomFamily.size(); i++) {
				Rectangle rec = roomFamily.get(i).getBounds();
				rec.x = rec.x - 50;
				roomFamily.get(i).setBounds(rec);
			}
		}
		if (e.getWheelRotation() == -1) {
			// 往左跑
			for (int i = 0; i < roomFamily.size(); i++) {
				Rectangle rec = roomFamily.get(i).getBounds();
				rec.x = rec.x + 50;
				roomFamily.get(i).setBounds(rec);
			}
		}
	}
}
