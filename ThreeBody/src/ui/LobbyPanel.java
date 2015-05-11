package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.MainControl;

public class LobbyPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private MainControl mc;
	private JButton lobby1;
	private JButton lobby2;
	private JButton lobby3;
	private JButton lobby4;
	private JButton lobby5;
	private JButton lobby6;
	private JButton createRoom;
	private JButton lobbyReturn;
	
	private JButton[] rooms =new JButton[6];
	private int numOfRoom=6;
	private ArrayList<int[]> location = new ArrayList<int[]>(6);
	
	public LobbyPanel(MainControl mc){
		this.setLayout(null);
		//this.ShowPeopleNum();
		this.mc = mc;
		initRoomLocation();
		createRoom();
		this.initComonent();
	}
	
	private void initRoomLocation() {
		int[] x0 = {50,100,300,125};
		int[]  x1 = {400,100,300,125};
		int[]	x2= {750,100,300,125};
		int[]	x3 = {50,300,300,125};
		int[]	x5 = {400,300,300,125};
		int[]	x6 = {750,300,300,125};
		location.add(x0);
		location.add(x1);
		location.add(x2);
		location.add(x3);
		location.add(x5);
		location.add(x6);
	}
	private void createRoom() {
		for (int i = 0; i < numOfRoom; i++) {
			rooms[i] = new JButton();
			rooms[i].setIcon(new ImageIcon(""));
			int[] locationi=location.get(i%6);
			rooms[i].setBounds(locationi[0],locationi[1],locationi[2],locationi[3]);
			rooms[i].setContentAreaFilled(false);
			this.add(rooms[i]);
		}
	}
	public void initComonent(){
	 //lobby room 3*2
	    rooms[0].addMouseListener(new EnterListener());
	    rooms[1].addMouseListener(new EnterListener());
	    rooms[2].addMouseListener(new EnterListener());
	    rooms[3].addMouseListener(new EnterListener());
	    rooms[4].addMouseListener(new EnterListener());
	    rooms[5].addMouseListener(new EnterListener());
	  	  
	  	  
	    
	    this.createRoom=new JButton();
	    this.createRoom.setIcon(new ImageIcon(""));
	    this.createRoom.setContentAreaFilled(false);
	  	this.createRoom.setBounds(650,500,100,50);
	  	this.createRoom.setVisible(true);  
	  	this.createRoom.addMouseListener(new CreateRoomListener());
	    this.add(createRoom);
	    
	    
	    this.lobbyReturn=new JButton();
	    this.lobbyReturn.setIcon(new ImageIcon(""));
	    this.lobbyReturn.setContentAreaFilled(false);
	  	this.lobbyReturn.setBounds(850,500,100,50);
	  	this.lobbyReturn.setVisible(true);  
	  	this.lobbyReturn.addMouseListener(new ReturnListener());
	    this.add(lobbyReturn);
	}
	
	
	
	
//	public void ShowPeopleNum(){
//	
//		if(totalNum==4){
//        
//		}
//		if(totalNum==6)){
//			SixPerRoom();
//		}
//        if(totalNum==8)){
//			EightRoom();
//		}
//	}  
	
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

		@Override
		public void mouseClicked(MouseEvent e) {
			mc.toGame();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
class CreateRoomListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
}		
		
		
class ReturnListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		mc.toSelect();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
}
