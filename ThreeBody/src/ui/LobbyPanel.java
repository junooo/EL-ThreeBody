package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.MainControl;

public class LobbyPanel extends JPanel implements MouseWheelListener{
	private static final long serialVersionUID = 1L;
	private MainControl mc;
	private JButton createRoom;
	private JButton lobbyReturn;
	
	private JButton[] rooms;
	private int numOfRoom;
	private ArrayList<int[]> location = new ArrayList<int[]>(6);
	private ArrayList<JButton> roomFamily = new ArrayList<>();
	
	public LobbyPanel(MainControl mc){
		this.setLayout(null);
		//this.ShowPeopleNum();
		this.mc = mc;
		numOfRoom=6;
		rooms =new JButton[numOfRoom];
		createRoom();
		this.initComonent();
		this.addMouseWheelListener(this);
	}
	

	
	private void createRoom() {
		for (int i = 0; i < numOfRoom; i++) {
			rooms[i] = new JButton();
			rooms[i].setIcon(new ImageIcon(""));
			rooms[i].setBounds(50+350*i,200,300,125);
			rooms[i].setContentAreaFilled(false);
			rooms[i].addMouseListener(new EnterListener(i));
			roomFamily.add(rooms[i]);
		}
		addRoom();
	}
	private void addRoom() {
		for (int i = 0; i < roomFamily.size(); i++) {
			this.add(roomFamily.get(i));
		}
		
	}



	public void initComonent(){
	 //lobby room 3*2
	  	  
	  	  
	    
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


@Override
public void mouseWheelMoved(MouseWheelEvent e) {
	
	if(e.getWheelRotation()==1){
      //往左跑
        for (int i = 0; i <roomFamily.size(); i++) {
        	Rectangle rec = roomFamily.get(i).getBounds();
        	rec.x = rec.x-30;
        	roomFamily.get(i).setBounds(rec);
		}
    }
    if(e.getWheelRotation()==-1){
        //往左跑
        for (int i = 0; i <roomFamily.size(); i++) {
        	Rectangle rec = roomFamily.get(i).getBounds();
        	rec.x = rec.x+30;
        	roomFamily.get(i).setBounds(rec);
		}
    }
	
}
}
