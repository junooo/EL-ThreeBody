package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Account;
import control.MainControl;


public class AccountPanel extends JPanel{
	private static final long serialVersionUID = 1L;
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
	private JButton btnReturn;
	private Account account;
	private MainControl mainControl;
	public AccountPanel(MainControl mainControl, String id){
		this.setLayout(null);
		this.account=new Account(id);
		this.mainControl=mainControl;
		init();
	}
	private void init() {
		psId = new JLabel();
		psId.setBounds(30,110,60,30);
		psId.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(psId);
		
		labelId = new JLabel();
		labelId.setBounds(30,110,60,30);
		labelId.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(labelId);
		
		labelHead = new JLabel();
		labelHead.setBounds(30,110,60,30);
//		ImageIcon headImage = new ImageIcon(account.getHead());
//		labelHead.setIcon(headImage);
		this.add(labelHead);
		
		psPoint = new JLabel();
		psPoint.setBounds(30,110,60,30);
		psPoint.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(psPoint);
		
		labelPoint = new JLabel();
		labelPoint.setBounds(30,110,60,30);
		labelPoint.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(labelPoint);
		
		psRank = new JLabel();
		psRank.setBounds(30,110,60,30);
		psRank.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(psRank);
		
		labelRank = new JLabel();
		labelRank.setBounds(30,110,60,30);
		labelRank.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(labelRank);;
		
		psTotalGames = new JLabel();
		psTotalGames.setBounds(30,110,60,30);
		psTotalGames.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(psTotalGames);
		
		labelTotalGames = new JLabel();
		labelTotalGames.setBounds(30,110,60,30);
		labelTotalGames.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(labelTotalGames);
		
		
		psWins = new JLabel();
		psWins.setBounds(30,110,60,30);
		psWins.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(psWins);
		
		labelWins = new JLabel();
		labelWins.setBounds(30,110,60,30);
		labelWins.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(labelWins);
		
		
		psLosts = new JLabel();
		psLosts.setBounds(30,110,60,30);
		psLosts.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(psLosts);
		
		
		labelLosts = new JLabel();
		labelLosts.setBounds(30,110,60,30);
		labelLosts.setIcon(new ImageIcon("images/logpassword.png"));
		this.add(labelLosts);
		
		this.btnReturn = new JButton("返回");
		this.btnReturn.setContentAreaFilled(false);
		this.btnReturn.setBounds(50, 515, 100, 30);
		btnReturn.setFont(new Font("黑体", Font.BOLD, 20));
		btnReturn.setForeground(Color.YELLOW);
		btnReturn.addMouseListener(new ReturnListener());
		this.add(btnReturn);
		
	}
	@Override
	public void paintComponent(Graphics g) {
		Image IMG_MAIN = new ImageIcon("images/img1.jpg").getImage();
		// ������Ϸ����
		g.drawImage(IMG_MAIN, 0, 0, 1158, 650, null);
	}
	
	class ReturnListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			mainControl.toStartMenu();
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
