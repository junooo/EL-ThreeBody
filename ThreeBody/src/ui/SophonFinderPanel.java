package ui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dto.GameDTO;
import model.Player;
import model.card.Sophon;
import model.operation.CardUse;

public class SophonFinderPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JButton btnCoordinateOne;
	private JButton btnCoordinateTwo;
	private JButton btnCoordinateThree;
	private JButton btnCoordinateFour;
	private JButton btnOK;
	private JButton btnReturn;
	private JFrame sophonFinder;
	private JComboBox<String> select;
	private int cooperate;
	ArrayList<Player> players=null;
	Player user;
	
	public SophonFinderPanel(JFrame sophonFinder) {
		this.setLayout(null);
		players=(ArrayList<Player>) GameDTO.getInstance().getPlayers();
		user=GameDTO.getInstance().getUser();
		this.sophonFinder=sophonFinder;
		this.initComonent();
	}
	
	private void initComonent() {
		
		cooperate=1;
		
		this.btnCoordinateOne = new JButton();
		this.btnCoordinateOne.setBounds(12, 16, 99, 60);
		btnCoordinateOne.setFont(new Font("黑体", Font.BOLD, 60));
		btnCoordinateOne.setContentAreaFilled(false);
		this.add(btnCoordinateOne);
		
		this.btnCoordinateTwo = new JButton();
		this.btnCoordinateTwo.setBounds(123, 16, 99, 60);
		btnCoordinateTwo.setFont(new Font("黑体", Font.BOLD, 60));
		btnCoordinateTwo.setContentAreaFilled(false);
		this.add(btnCoordinateTwo);
		
		this.btnCoordinateThree = new JButton();
		this.btnCoordinateThree.setBounds(233, 16, 99, 60);
		btnCoordinateThree.setFont(new Font("黑体", Font.BOLD, 60));
		btnCoordinateThree.setContentAreaFilled(false);
		this.add(btnCoordinateThree);
		
		this.btnCoordinateFour = new JButton();
		this.btnCoordinateFour.setBounds(344, 16, 99, 60);
		btnCoordinateFour.setFont(new Font("黑体", Font.BOLD, 60));
		btnCoordinateFour.setContentAreaFilled(false);
		this.add(btnCoordinateFour);
		
		this.btnOK = new JButton(new ImageIcon("button.png"));
		this.btnOK.setContentAreaFilled(false);
		this.btnOK.setBounds(150, 105, 150, 60);
		this.btnOK.setBorderPainted(false);
//		btnOK.addMouseListener(new StartGameListener());
		this.add(btnOK);
		
		this.btnReturn = new JButton(new ImageIcon("exit.png"));
		this.btnReturn.setContentAreaFilled(false);
		this.btnReturn.setBounds(295, 105, 150, 60);
		this.btnReturn.setBorderPainted(false);
		btnReturn.addMouseListener(new ReturnListener());
		this.add(btnReturn);

		
		select = new JComboBox<String>();
		select.setFont(new Font("宋体", Font.PLAIN, 30));
		select.setBounds(50,105, 60, 30);
		//
		if (players != null) {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).equals(user)) {
					continue;
				} else {
					select.addItem(players.get(i).getAccount().getId());
				}
			}
		}

		select.addItem("aa");
		select.addItem("bb");
		this.add(select);
	}
	
	class ReturnListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			sophonFinder.setVisible(false);
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
	class FindListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			setVisible(false);
			useSophon();
		}
		private void useSophon() {
			Sophon sophon  =new Sophon(user.getAccount().getId(), select.getSelectedItem().toString(), cooperate);
			CardUse cardSophon = new CardUse(user.getAccount().getId(), select.getSelectedItem().toString(), sophon);
			GameDTO.getInstance().depositOperation(cardSophon);
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
