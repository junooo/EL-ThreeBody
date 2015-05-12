package ui.lobby;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.LobbyControl;

public class CreateRoomPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private LobbyControl lobbyControl;
	private JFrame createRoomFrame;
	private JLabel idLabel;
	private JLabel numLabel;
	private JTextField idField;
	private JComboBox<String> select;
	private JButton btnOk;
	private JButton btnCancel;

	public CreateRoomPanel(JFrame createRoomFrame,LobbyControl lobbyControl) {
		this.lobbyControl = lobbyControl;
		
		this.setLayout(null);
		this.createRoomFrame=createRoomFrame;
		this.initComonent();
	}

	private void initComonent() {
		idLabel = new JLabel();
		idLabel.setBounds(30,60,60,30);
		idLabel.setIcon(new ImageIcon("images/roomname.png"));
		this.add(idLabel);
		
		numLabel = new JLabel();
		numLabel.setBounds(20,120,80,30);
		numLabel.setIcon(new ImageIcon("images/roomnumber.png"));
		this.add(numLabel);
		
		idField = new JTextField();
		idField.setBounds(100,60,240,30);
		this.add(idField);
		
		select = new JComboBox<String>();
		select.setBounds(140,120,100,40);
		select.addItem("3人房间");
		select.addItem("6人房间");
		select.addItem("8人房间");
		this.add(select);
		
		this.btnOk = new JButton(new ImageIcon("images/roomcreate.png"));
		this.btnOk.setBounds(100, 220, 80, 40);
		btnOk.setContentAreaFilled(false);
		btnOk.addMouseListener(new CreateListener());
		this.add(btnOk);
		
		this.btnCancel = new JButton(new ImageIcon("images/roomcancel.png"));
		this.btnCancel.setBounds(220, 220, 80, 40);
		btnCancel.setContentAreaFilled(false);
		btnCancel.addMouseListener(new CancelListener());
		this.add(btnCancel);
		
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("images/img1.jpg").getImage();
		g.drawImage(img, 0, 0, null);
		}
	
	class CreateListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// 创建房间
			
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
	class CancelListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			createRoomFrame.setVisible(false);
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
