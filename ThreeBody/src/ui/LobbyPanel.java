package ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ui.GamePanel.CardListener1;
import ui.GamePanel.CardListener2;
import ui.GamePanel.CardListener3;
import ui.GamePanel.CardListener4;
import ui.GamePanel.CardListener5;
import ui.GamePanel.CardListener6;
import control.MainControl;

public class LobbyPanel extends JPanel{
	 private static final long serialVersionUID = 1L;
	   private MainControl mainControl;
	
	private JButton btnReturn;
	private JButton room1;
	private JButton room2;
	private JButton room3;
	private JButton room4;
	private JButton room5;
	private JButton room6;
	
	public LobbyPanel(MainControl mainControl) {
		this.setLayout(null);
		this.mainControl = mainControl;
		this.initComonent();
	}
	private void initComonent() {
		this.room1 = new JButton("����");
		this.room1.setContentAreaFilled(false);
		this.room1.setBounds(1070, 30, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		room1.addMouseListener(new RoomListener1());
		this.add(room1);
		
		
		this.room2 = new JButton("��������");
		this.room2.setContentAreaFilled(false);
		this.room2.setBounds(1070, 60, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		room2.addMouseListener(new RoomListener2());
		this.add(room2);
		
		this.room3 = new JButton("��������");
		this.room3.setContentAreaFilled(false);
		this.room3.setBounds(1070, 90, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		room3.addMouseListener(new RoomListener3());
		this.add(room3);
		
		this.room4 = new JButton("��������");
		this.room4.setContentAreaFilled(false);
		this.room4.setBounds(1070, 120, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		room4.addMouseListener(new RoomListener4());
		this.add(room4);
		
		this.room5 = new JButton("��������");
		this.room5.setContentAreaFilled(false);
		this.room5.setBounds(1070, 150, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		room5.addMouseListener(new RoomListener5());
		this.add(room5);
		
		this.room6 = new JButton("��������");
		this.room6.setContentAreaFilled(false);
		this.room6.setBounds(1070, 180, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		room6.addMouseListener(new RoomListener6());
		this.add(room6);
	}
	class RoomListener1 implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent e) {
			//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class RoomListener2 implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent e) {
			//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class RoomListener3 implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent e) {
			//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class RoomListener4 implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent e) {
			//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class RoomListener5 implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent e) {
			//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class RoomListener6 implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent e) {
			//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	
}
