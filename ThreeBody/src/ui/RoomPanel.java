package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Account;
import model.Room;
import ui.lobby.ButtonPanel;
import ui.lobby.CreateRoomFrame;
import ui.lobby.CreateRoomPanel;
import control.LobbyControl;
import control.MainControl;

public class RoomPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private MainControl mainControl;
	private JButton btn_ready;
	private JButton btn_lobbyReturn;
	private JButton btn_roomInfo;
	private JLabel psId;
	private JLabel labelId;
	private JLabel labelHead;
	private JLabel psPoint;
	private JLabel labelPoint;
	private JLabel psRank;
	private JLabel labelRank;
	private JLabel psTotalGames;
	private JLabel labelTotalGames;
	private JLabel psWins;
	private JLabel labelWins;
	private JLabel psLosts;
	private JLabel labelLosts;
	private Image opaque = new ImageIcon("images/coNothing.png").getImage();
	private LobbyControl lobbyControl;
	private List<Rectangle> locations = new ArrayList<Rectangle>(7);
	private JButton[] buttons = new JButton[7];
	private Room room;
	private List<Account> accounts;
	public RoomPanel(MainControl mc,Room room) {
		this.setLayout(null);
		this.room=room;
		this.mainControl = mc;
		this.accounts=room.getAccounts();
		this.initLocation();
		this.initComonent();
		this.initAccountsInfo();
	}
	public void refresh() {
		mainControl.toLobby();
	}
	private void initAccountsInfo() {
		for (int i = 0; i < accounts.size(); i++) {
			Rectangle rect=locations.get(i);
			
			psId = new JLabel();
			psId.setBounds(rect.x,rect.y,60,30);
			Image img_id=new ImageIcon("images/accountId.png").getImage();
			psId.setIcon(new ImageIcon(img_id.getScaledInstance(60, 30, Image.SCALE_SMOOTH)));
			this.add(psId);
			
			labelId = new JLabel();
			labelId.setBounds(rect.x,rect.y+30,120,30);
			labelId.setFont(new Font("宋体",Font.PLAIN,20));
			labelId.setForeground(Color.YELLOW);
			labelId.setText(accounts.get(i).getId());
			this.add(labelId);
			
			labelHead = new JLabel();
			labelHead.setBounds(rect.x+90,rect.y,30,30);
			if(accounts.get(i).getHead()!=null){
				Image headImage=accounts.get(i).getHead();
				headImage=headImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				labelHead.setIcon(new ImageIcon(headImage));
			}else{
				Image headImage = new ImageIcon("images/headtest.jpg").getImage();
				headImage=headImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				labelHead.setIcon(new ImageIcon(headImage));
			}
			this.add(labelHead);
			
			psPoint = new JLabel();
			psPoint.setBounds(rect.x+120,rect.y,60,30);
			Image img_point=new ImageIcon("images/accountpoint.png").getImage();
			psPoint.setIcon(new ImageIcon(img_point.getScaledInstance(60, 30, Image.SCALE_SMOOTH)));
			this.add(psPoint);
			
			labelPoint = new JLabel();
			labelPoint.setBounds(rect.x+180,rect.y,60,30);
			labelPoint.setFont(new Font("宋体",Font.PLAIN,30));
			labelPoint.setForeground(Color.YELLOW);
			labelPoint.setText(accounts.get(i).getPoint()+"");
			this.add(labelPoint);
			
			psRank = new JLabel();
			psRank.setBounds(rect.x+120,rect.y+30,60,30);
			Image img_rank=new ImageIcon("images/accountlevel.png").getImage();
			psRank.setIcon(new ImageIcon(img_rank.getScaledInstance(60, 30, Image.SCALE_SMOOTH)));
			this.add(psRank);
			
			labelRank = new JLabel();
			labelRank.setBounds(rect.x+230,rect.y+30,60,30);
			labelRank.setFont(new Font("宋体",Font.PLAIN,30));
			labelRank.setForeground(Color.YELLOW);
			labelRank.setText(accounts.get(i).getRank()+"");
			this.add(labelRank);
			
			
			psTotalGames = new JLabel();
			psTotalGames.setBounds(rect.x+300,rect.y+15,60,30);
			Image img_totalGames=new ImageIcon("images/accounttotalgames.png").getImage();
			psTotalGames.setIcon(new ImageIcon(img_totalGames.getScaledInstance(60, 30, Image.SCALE_SMOOTH)));
			this.add(psTotalGames);
			
			labelTotalGames = new JLabel();
			labelTotalGames.setBounds(rect.x+430,rect.y+15,60,30);
			labelTotalGames.setFont(new Font("宋体",Font.PLAIN,30));
			labelTotalGames.setForeground(Color.YELLOW);
			labelTotalGames.setText(accounts.get(i).getTotalGames()+"");
			this.add(labelTotalGames);
			
			
			psWins = new JLabel();
			psWins.setBounds(rect.x+480,rect.y,60,30);
			Image img_wins=new ImageIcon("images/accountwins.png").getImage();
			psWins.setIcon(new ImageIcon(img_wins.getScaledInstance(60, 30, Image.SCALE_SMOOTH)));
			this.add(psWins);
			
			labelWins = new JLabel();
			labelWins.setBounds(rect.x+590,rect.y,60,30);
			labelWins.setFont(new Font("宋体",Font.PLAIN,30));
			labelWins.setForeground(Color.YELLOW);
			labelWins.setText(accounts.get(i).getWins()+"");
			this.add(labelWins);
			
			
			psLosts = new JLabel();
			psLosts.setBounds(rect.x+480,rect.y+30,60,30);
			Image img_losts=new ImageIcon("images/accountloses.png").getImage();
			psLosts.setIcon(new ImageIcon(img_losts.getScaledInstance(60, 30, Image.SCALE_SMOOTH)));
			this.add(psLosts);
			
			
			labelLosts = new JLabel();
			labelLosts.setBounds(rect.x+590,rect.y+30,60,30);
			labelLosts.setFont(new Font("宋体",Font.PLAIN,30));
			labelLosts.setForeground(Color.YELLOW);
			labelLosts.setText(accounts.get(i).getLosts()+"");
			this.add(labelLosts);
		}
		
	}
	public void initLocation(){
		locations.add(new Rectangle(215,20,600,60));
		locations.add(new Rectangle(215,100,600,60));
		locations.add(new Rectangle(215,180,600,60));
		locations.add(new Rectangle(215,260,600,60));
		locations.add(new Rectangle(215,340,600,60));
		locations.add(new Rectangle(215,420,600,60));
		locations.add(new Rectangle(215,500,600,60));
	}
	public void initComonent() {
		for (int i = 0; i < room.getSize(); i++) {
			buttons[i]= new JButton();
			buttons[i].setBounds(locations.get(i));
			buttons[i].setContentAreaFilled(false);
			this.add(buttons[i]);
		}
		
		this.btn_roomInfo = new JButton();
		btn_roomInfo.setIcon(new ImageIcon(opaque.getScaledInstance(300, 125, Image.SCALE_SMOOTH)));
		JPanel roomPanel = new ButtonPanel(room);
		roomPanel.setBounds(850, 50, 300, 125);
		this.btn_roomInfo.setBounds(840, 50, 300, 125);
		btn_roomInfo.setContentAreaFilled(false);
		btn_roomInfo.setBorderPainted(false);
		btn_roomInfo.add(roomPanel);
		this.add(btn_roomInfo);
		
		this.btn_ready = new JButton();
		this.btn_ready.setIcon(new ImageIcon("images/newroom.png"));
		this.btn_ready.setContentAreaFilled(false);
		this.btn_ready.setBounds(840, 500, 100, 50);
		this.btn_ready.addMouseListener(new CreateRoomListener());
		this.add(btn_ready);

		this.btn_lobbyReturn = new JButton();
		this.btn_lobbyReturn.setIcon(new ImageIcon("images/roomreturn.png"));
		this.btn_lobbyReturn.setContentAreaFilled(false);
		this.btn_lobbyReturn.setBounds(1000, 500, 100, 50);
		this.btn_lobbyReturn.addMouseListener(new ReturnListener());
		this.add(btn_lobbyReturn);
		
		
	}

	public void paintComponent(Graphics g) {
		Image background = new ImageIcon("images/模糊背景.jpg").getImage();
		g.drawImage(background, 0, 0, null);
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
			mainControl.toLobby();
		}
	}
}
