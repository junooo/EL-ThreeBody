package ui.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.block.PatialBlockFrame;
import ui.block.PatialBlockPanel;
import ui.sophon.SophonFinderFrame;
import ui.sophon.SophonFinderPanel;
import control.MainControl;

public class GamePanel  extends JPanel{
    private static final long serialVersionUID = 1L;
    private MainControl mainControl;
	
	private JButton btnReturn;
	
	private JButton btnCardSophon;
	private JButton btnCardSillySophon;
	private JButton btnCardWholeBlock;
	private JButton btnCardPatialBlock;
	private JButton btnCardNoBroadcasting;
	private JButton btnCardTechPotion;
	private JButton btnCardResourcePotion;
	private JButton btnCardResourceGambling;
	private JButton btnPriviledgeGetRole;
	
	private JButton btnBroadcast;
	private JButton btnHistory;
	private JButton btnMessage;
	
	private JButton btnTurnEnd;
	
	private int NumOfPlayer;
	
	private JPanel panelBroadcast= new BroadcastPanel();
	private JPanel panelMessage= new MessagePanel();
	private JPanel panelHistory= new HistoryPanel();
	
	private JPanel panelCountDown = new CountDownPanel();
	private JPanel panelTech = new TechPanel();
	private JPanel panelResource = new ResourcePanel();
	
	private JLabel resourceString;
	private JLabel techString;
	
	private JLabel[] enemies = new JLabel[7];
	private ArrayList<int[]> location = new ArrayList<int[]>(7);
	
	public GamePanel(MainControl mainControl,int NumOfPlayer) {
		this.setLayout(null);
		this.mainControl = mainControl;
		this.NumOfPlayer=NumOfPlayer;
		this.initComonent();
		this.initEnemyLocation();
		this.createEnemy();
	}
	private void initEnemyLocation() {
		int[] x0 = {350,100,300,200};
		int[]  x1 = {650,100,230,230};
		int[]	x2= {	250,300,230,230};
		int[]	x3 = {500,300,230,230};
		int[]	x4 = {750,300,230,230};
		int[]	x5 = {100,100,230,230};
		int[]	x6 = {900,100,230,230};
		location.add(x0);
		location.add(x1);
		location.add(x2);
		location.add(x3);
		location.add(x4);
		location.add(x5);
		location.add(x6);
	}
	private void createEnemy() {
		for (int i = 0; i < NumOfPlayer-1; i++) {
			enemies[i] = new JLabel();
			enemies[i].setIcon(new ImageIcon("images/star06.gif"));
			int[] locationi=location.get(i);
			enemies[i].setBounds(locationi[0],locationi[1],locationi[2],locationi[3]);
			this.add(enemies[i]);
		}
	}
	private void initComonent() {
		this.btnReturn = new JButton("返回");
		this.btnReturn.setContentAreaFilled(false);
		this.btnReturn.setBounds(-50, 615, 100, 30);
		btnReturn.setFont(new Font("黑体", Font.BOLD, 20));
		// this.btnMultyPlay.setBorderPainted(false);
		btnReturn.addMouseListener(new ReturnListener());
		this.add(btnReturn);
		
		this.btnBroadcast = new JButton("广播");
		this.btnBroadcast.setContentAreaFilled(false);
		this.btnBroadcast.setBounds(400, 600, 50, 15);
		btnBroadcast.setFont(new Font("黑体", Font.BOLD, 15));
		// this.btnMultyPlay.setBorderPainted(false);
		btnBroadcast.addMouseListener(new BroadcastListener());
		this.add(btnBroadcast);
		
		
		this.btnHistory = new JButton("历史记录");
		this.btnHistory.setContentAreaFilled(false);
		this.btnHistory.setBounds(600, 600, 50, 15);
		btnHistory.setFont(new Font("黑体", Font.BOLD, 15));
		// this.btnMultyPlay.setBorderPainted(false);
		btnHistory.addMouseListener(new HistoryListener());
		this.add(btnHistory);
		
		this.btnMessage = new JButton("留言");
		this.btnMessage.setContentAreaFilled(false);
		this.btnMessage.setBounds(800, 600, 50, 15);
		// this.btnMultyPlay.setBorderPainted(false);
		btnMessage.setFont(new Font("黑体", Font.BOLD, 15));
		btnMessage.addMouseListener(new MessageListener());
		this.add(btnMessage);
		
		
		this.btnTurnEnd = new JButton("回合结束");
		this.btnTurnEnd.setContentAreaFilled(false);
		this.btnTurnEnd.setBounds(1000, 500, 150, 30);
		btnTurnEnd.setFont(new Font("黑体", Font.BOLD, 15));
		btnTurnEnd.setForeground(Color.YELLOW);
		// this.btnMultyPlay.setBorderPainted(false);
//		btnTurnEnd.addMouseListener(new CardListener1());
		this.add(btnTurnEnd);
		
		
		this.btnCardSophon = new JButton("智子");
		this.btnCardSophon.setContentAreaFilled(false);
		this.btnCardSophon.setBounds(1070, 30, 150, 30);
		btnCardSophon.setFont(new Font("黑体", Font.BOLD, 15));
		btnCardSophon.setForeground(Color.YELLOW);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCardSophon.addMouseListener(new CardSophonListener());
		this.add(btnCardSophon);
		
		
		this.btnCardSillySophon = new JButton("人造智子");
		this.btnCardSillySophon.setContentAreaFilled(false);
		this.btnCardSillySophon.setBounds(1070, 60, 150, 30);
		btnCardSillySophon.setForeground(Color.YELLOW);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCardSillySophon.addMouseListener(new CardSillySophonListener());
		this.add(btnCardSillySophon);
		
		this.btnCardWholeBlock = new JButton("全局黑域");
		this.btnCardWholeBlock.setContentAreaFilled(false);
		this.btnCardWholeBlock.setBounds(1070, 90, 150, 30);
		btnCardWholeBlock.setForeground(Color.YELLOW);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCardWholeBlock.addMouseListener(new CardWholeBlockListener());
		this.add(btnCardWholeBlock);
		
		this.btnCardPatialBlock = new JButton("局部黑域");
		this.btnCardPatialBlock.setContentAreaFilled(false);
		this.btnCardPatialBlock.setBounds(1070, 120, 150, 30);
		btnCardPatialBlock.setForeground(Color.YELLOW);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCardPatialBlock.addMouseListener(new CardPatialBlockListener());
		this.add(btnCardPatialBlock);
		
		this.btnCardNoBroadcasting = new JButton("电波干扰");
		this.btnCardNoBroadcasting.setContentAreaFilled(false);
		this.btnCardNoBroadcasting.setBounds(1070, 150, 150, 30);
		btnCardNoBroadcasting.setForeground(Color.YELLOW);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCardNoBroadcasting.addMouseListener(new CardNoBroadcastingListener());
		this.add(btnCardNoBroadcasting);
		
		this.btnCardTechPotion = new JButton("科技革命");
		this.btnCardTechPotion.setContentAreaFilled(false);
		this.btnCardTechPotion.setBounds(1070, 180, 150, 30);
		btnCardTechPotion.setForeground(Color.YELLOW);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCardTechPotion.addMouseListener(new CardTechPotionListener());
		this.add(btnCardTechPotion);
		
		
		this.btnCardResourcePotion = new JButton("资源爆发");
		this.btnCardResourcePotion.setContentAreaFilled(false);
		this.btnCardResourcePotion.setBounds(1070, 210, 150, 30);
		btnCardResourcePotion.setForeground(Color.YELLOW);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCardResourcePotion.addMouseListener(new CardResourcePotionListener());
		this.add(btnCardResourcePotion);
		
		
		this.btnCardResourceGambling = new JButton("资源赌博");
		this.btnCardResourceGambling.setContentAreaFilled(false);
		this.btnCardResourceGambling.setBounds(1070, 240, 150, 30);
		btnCardResourceGambling.setForeground(Color.YELLOW);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCardResourceGambling.addMouseListener(new CardResourceGamblingListener());
		this.add(btnCardResourceGambling);
		
		this.btnPriviledgeGetRole = new JButton("特权");
		this.btnPriviledgeGetRole.setContentAreaFilled(false);
		this.btnPriviledgeGetRole.setBounds(1070, 270, 150, 30);
		btnPriviledgeGetRole.setForeground(Color.YELLOW);
		// this.btnMultyPlay.setBorderPainted(false);
		btnPriviledgeGetRole.addMouseListener(new PriviledgeGetRoleListener());
		this.add(btnPriviledgeGetRole);
		
		resourceString = new JLabel(new ImageIcon("images/resource.png"));
		resourceString.setBounds(110,480,60,30);
		this.add(resourceString);
		
		techString = new JLabel(new ImageIcon("images/tech.png"));
		techString.setBounds(110,510,60,30);
		this.add(techString);

		this.add(panelTech);
		this.add(panelResource);
		this.add(panelCountDown);
	}
	@Override
	public void paintComponent(Graphics g) {
		Image IMG_MAIN = new ImageIcon("images/gamebg.jpg").getImage();
		// ������Ϸ����
		g.drawImage(IMG_MAIN, 0, 0, 1158, 650, null);
	}
	
	
	
	class ReturnListener implements MouseListener {
		int x = btnReturn.getX();
		int y = btnReturn.getY();
		int w = btnReturn.getWidth();
		int h = btnReturn.getHeight();

		@Override
		public void mouseClicked(MouseEvent e) {
			mainControl.toStartMenu();
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnReturn.setBounds(x+40, y-40, w, h+40);
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnReturn.setBounds(x+40, y-40, w, h+40);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnReturn.setBounds(x+40, y-40, w, h+40);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnReturn.setLocation(x, y);
			
		}
	}
	
	class CardSophonListener implements MouseListener {
		int x = btnCardSophon.getX();
		int y = btnCardSophon.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			initSophon();
		}
		
		private void initSophon() {
			JFrame sophonFinder = new SophonFinderFrame("智子");
			JPanel finder = new SophonFinderPanel(sophonFinder);
			sophonFinder.setContentPane(finder);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCardSophon.setLocation(x-40, y);
			btnCardSillySophon.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCardSophon.setLocation(x-40, y);
			btnCardSillySophon.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCardSophon.setLocation(x-40, y);
			btnCardSillySophon.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardSophon.setLocation(x, y);
			btnCardSillySophon.setLocation(x, y+30);
		}
	}
	class CardSillySophonListener implements MouseListener {
		int x = btnCardSillySophon.getX();
		int y = btnCardSillySophon.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
			initSillySophon();
			
		}
		private void initSillySophon() {
			JFrame sophonFinder = new SophonFinderFrame("人造智子");
			JPanel finder = new SophonFinderPanel(sophonFinder);
			sophonFinder.setContentPane(finder);
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCardSophon.setLocation(x-10, y-30);
			btnCardSillySophon.setLocation(x-40, y);
			btnCardWholeBlock.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCardSophon.setLocation(x-10, y-30);
			btnCardSillySophon.setLocation(x-40, y);
			btnCardWholeBlock.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCardSophon.setLocation(x-10, y-30);
			btnCardSillySophon.setLocation(x-40, y);
			btnCardWholeBlock.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardSophon.setLocation(x, y-30);
			btnCardSillySophon.setLocation(x, y);
			btnCardWholeBlock.setLocation(x, y+30);
		}
	}
	class CardWholeBlockListener implements MouseListener {
		int x = btnCardWholeBlock.getX();
		int y = btnCardWholeBlock.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCardSillySophon.setLocation(x-10, y-30);
			btnCardWholeBlock.setLocation(x-40, y);
			btnCardPatialBlock.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCardSillySophon.setLocation(x-10, y-30);
			btnCardWholeBlock.setLocation(x-40, y);
			btnCardPatialBlock.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCardSillySophon.setLocation(x-10, y-30);
			btnCardWholeBlock.setLocation(x-40, y);
			btnCardPatialBlock.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardSillySophon.setLocation(x, y-30);
			btnCardWholeBlock.setLocation(x, y);
			btnCardPatialBlock.setLocation(x, y+30);
		}
	}
	class CardPatialBlockListener implements MouseListener {
		int x = btnCardPatialBlock.getX();
		int y = btnCardPatialBlock.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
			initPatialBlock();
			
		}
		private void initPatialBlock() {
			JFrame patialBlock = new PatialBlockFrame();
			JPanel block = new PatialBlockPanel(patialBlock);
			patialBlock.setContentPane(block);
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCardWholeBlock.setLocation(x-10, y-30);
			btnCardPatialBlock.setLocation(x-40, y);
			btnCardNoBroadcasting.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCardWholeBlock.setLocation(x-10, y-30);
			btnCardPatialBlock.setLocation(x-40, y);
			btnCardNoBroadcasting.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCardWholeBlock.setLocation(x-10, y-30);
			btnCardPatialBlock.setLocation(x-40, y);
			btnCardNoBroadcasting.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardWholeBlock.setLocation(x, y-30);
			btnCardPatialBlock.setLocation(x, y);
			btnCardNoBroadcasting.setLocation(x, y+30);
		}
	}
	class CardNoBroadcastingListener implements MouseListener {
		int x = btnCardNoBroadcasting.getX();
		int y = btnCardNoBroadcasting.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCardPatialBlock.setLocation(x-10, y-30);
			btnCardNoBroadcasting.setLocation(x-40, y);
			btnCardTechPotion.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCardPatialBlock.setLocation(x-10, y-30);
			btnCardNoBroadcasting.setLocation(x-40, y);
			btnCardTechPotion.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCardPatialBlock.setLocation(x-10, y-30);
			btnCardNoBroadcasting.setLocation(x-40, y);
			btnCardTechPotion.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardPatialBlock.setLocation(x, y-30);
			btnCardNoBroadcasting.setLocation(x, y);
			btnCardTechPotion.setLocation(x, y+30);
		}
	}
	class CardTechPotionListener implements MouseListener {
		int x = btnCardTechPotion.getX();
		int y = btnCardTechPotion.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCardNoBroadcasting.setLocation(x-10, y-30);
			btnCardTechPotion.setLocation(x-40, y);
			btnCardResourcePotion.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCardNoBroadcasting.setLocation(x-10, y-30);
			btnCardTechPotion.setLocation(x-40, y);
			btnCardResourcePotion.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCardNoBroadcasting.setLocation(x-10, y-30);
			btnCardTechPotion.setLocation(x-40, y);
			btnCardResourcePotion.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardNoBroadcasting.setLocation(x, y-30);
			btnCardTechPotion.setLocation(x, y);
			btnCardResourcePotion.setLocation(x, y+30);
		}
	}
	class CardResourcePotionListener implements MouseListener {
		int x = btnCardResourcePotion.getX();
		int y = btnCardResourcePotion.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
			//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCardTechPotion.setLocation(x-10, y-30);
			btnCardResourcePotion.setLocation(x-40, y);
			btnCardResourceGambling.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCardTechPotion.setLocation(x-10, y-30);
			btnCardResourcePotion.setLocation(x-40, y);
			btnCardResourceGambling.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCardTechPotion.setLocation(x-10, y-30);
			btnCardResourcePotion.setLocation(x-40, y);
			btnCardResourceGambling.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardTechPotion.setLocation(x, y-30);
			btnCardResourcePotion.setLocation(x, y);
			btnCardResourceGambling.setLocation(x, y+30);
		}
	}
	class CardResourceGamblingListener implements MouseListener {
		int x = btnCardResourceGambling.getX();
		int y = btnCardResourceGambling.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCardResourcePotion.setLocation(x-10, y-30);
			btnCardResourceGambling.setLocation(x-40, y);
			btnPriviledgeGetRole.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCardResourcePotion.setLocation(x-10, y-30);
			btnCardResourceGambling.setLocation(x-40, y);
			btnPriviledgeGetRole.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCardResourcePotion.setLocation(x-10, y-30);
			btnCardResourceGambling.setLocation(x-40, y);
			btnPriviledgeGetRole.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardResourcePotion.setLocation(x, y-30);
			btnCardResourceGambling.setLocation(x, y);
			btnPriviledgeGetRole.setLocation(x, y+30);
		}
	}
	class PriviledgeGetRoleListener implements MouseListener {
		int x = btnPriviledgeGetRole.getX();
		int y = btnPriviledgeGetRole.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCardResourceGambling.setLocation(x-10, y-30);
			btnPriviledgeGetRole.setLocation(x-40, y);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCardResourceGambling.setLocation(x-10, y-30);
			btnPriviledgeGetRole.setLocation(x-40, y);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCardResourceGambling.setLocation(x-10, y-30);
			btnPriviledgeGetRole.setLocation(x-40, y);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardResourceGambling.setLocation(x, y-30);
			btnPriviledgeGetRole.setLocation(x, y);
		}
	}
	
	
	class BroadcastListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			panelBroadcast.setVisible(true);
			panelMessage.setVisible(false);
			panelHistory.setVisible(false);
			add(panelBroadcast);
			repaint();
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
	
	class HistoryListener implements MouseListener {
		

		@Override
		public void mouseClicked(MouseEvent e) {
			/**
			 * 很HeHe的解决方式
			 */
			add(panelBroadcast);
			add(panelMessage);
			repaint();
			panelMessage.setVisible(false);
			panelBroadcast.setVisible(false);
			panelHistory.setVisible(true);
			add(panelHistory);
			repaint();
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class MessageListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			panelMessage.setVisible(true);
			panelBroadcast.setVisible(false);
			panelHistory.setVisible(false);
			add(panelMessage);
			repaint();
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

	 /*
     * ����ұ�ըʱ�����ؼ�
     */
    public void boom(){
        
    }
    
    /*
     * ����ұ�ռ��ʱ�����ؼ�
     */
    public void conquer(){
        
    }
    

}
