package ui.game;

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
	
	private JButton btnCard1;
	private JButton btnCard2;
	private JButton btnCard3;
	private JButton btnCard4;
	private JButton btnCard5;
	private JButton btnCard6;
	private JButton btnCard7;
	private JButton btnCard8;
	private JButton btnCard9;
	
	private JButton btnBroadcast;
	private JButton btnHistory;
	private JButton btnMessage;
	
	private JButton btnTurnEnd;
	private JButton btnPriviledge;
	
	private int NumOfPlayer;
	
	private JPanel panelBroadcast= new BroadcastPanel();
	private JPanel panelMessage= new MessagePanel();
	private JPanel panelHistory= new HistoryPanel();
	private JPanel countDown = new CountDownPanel();
	
	private JLabel[] enemies = new JLabel[7];
	private ArrayList<int[]> location = new ArrayList<int[]>(7);
	
	public GamePanel(MainControl mainControl,int NumOfPlayer) {
		this.setLayout(null);
		this.mainControl = mainControl;
		this.NumOfPlayer=NumOfPlayer;
		this.initComonent();
		this.initLocation();
		this.createEnemy();
	}
	private void initLocation() {
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
			enemies[i].setIcon(new ImageIcon("star06.gif"));
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
		// this.btnMultyPlay.setBorderPainted(false);
//		btnTurnEnd.addMouseListener(new CardListener1());
		this.add(btnTurnEnd);
		
		
		this.btnCard1 = new JButton("智子");
		this.btnCard1.setContentAreaFilled(false);
		this.btnCard1.setBounds(1070, 30, 150, 30);
		btnCard1.setFont(new Font("黑体", Font.BOLD, 15));
		// this.btnMultyPlay.setBorderPainted(false);
		btnCard1.addMouseListener(new CardListener1());
		this.add(btnCard1);
		
		
		this.btnCard2 = new JButton("人造智子");
		this.btnCard2.setContentAreaFilled(false);
		this.btnCard2.setBounds(1070, 60, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCard2.addMouseListener(new CardListener2());
		this.add(btnCard2);
		
		this.btnCard3 = new JButton("全局黑域");
		this.btnCard3.setContentAreaFilled(false);
		this.btnCard3.setBounds(1070, 90, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCard3.addMouseListener(new CardListener3());
		this.add(btnCard3);
		
		this.btnCard4 = new JButton("局部黑域");
		this.btnCard4.setContentAreaFilled(false);
		this.btnCard4.setBounds(1070, 120, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCard4.addMouseListener(new CardListener4());
		this.add(btnCard4);
		
		this.btnCard5 = new JButton("��������");
		this.btnCard5.setContentAreaFilled(false);
		this.btnCard5.setBounds(1070, 150, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCard5.addMouseListener(new CardListener5());
		this.add(btnCard5);
		
		this.btnCard6 = new JButton("��������");
		this.btnCard6.setContentAreaFilled(false);
		this.btnCard6.setBounds(1070, 180, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCard6.addMouseListener(new CardListener6());
		this.add(btnCard6);
		
		
		this.btnCard7 = new JButton("��������");
		this.btnCard7.setContentAreaFilled(false);
		this.btnCard7.setBounds(1070, 210, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCard7.addMouseListener(new CardListener7());
		this.add(btnCard7);
		
		
		this.btnCard8 = new JButton("��������");
		this.btnCard8.setContentAreaFilled(false);
		this.btnCard8.setBounds(1070, 240, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCard8.addMouseListener(new CardListener8());
		this.add(btnCard8);
		
		this.btnCard9 = new JButton("特权");
		this.btnCard9.setContentAreaFilled(false);
		this.btnCard9.setBounds(1070, 270, 150, 30);
		// this.btnMultyPlay.setBorderPainted(false);
		btnCard9.addMouseListener(new CardListener9());
		this.add(btnCard9);

	}
	@Override
	public void paintComponent(Graphics g) {
		Image IMG_MAIN = new ImageIcon("gamebg.jpg").getImage();
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
	
	class CardListener1 implements MouseListener {
		int x = btnCard1.getX();
		int y = btnCard1.getY();
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
			btnCard1.setLocation(x-40, y);
			btnCard2.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCard1.setLocation(x-40, y);
			btnCard2.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCard1.setLocation(x-40, y);
			btnCard2.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCard1.setLocation(x, y);
			btnCard2.setLocation(x, y+30);
		}
	}
	class CardListener2 implements MouseListener {
		int x = btnCard2.getX();
		int y = btnCard2.getY();


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
			btnCard1.setLocation(x-10, y-30);
			btnCard2.setLocation(x-40, y);
			btnCard3.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCard1.setLocation(x-10, y-30);
			btnCard2.setLocation(x-40, y);
			btnCard3.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCard1.setLocation(x-10, y-30);
			btnCard2.setLocation(x-40, y);
			btnCard3.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCard1.setLocation(x, y-30);
			btnCard2.setLocation(x, y);
			btnCard3.setLocation(x, y+30);
		}
	}
	class CardListener3 implements MouseListener {
		int x = btnCard3.getX();
		int y = btnCard3.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCard2.setLocation(x-10, y-30);
			btnCard3.setLocation(x-40, y);
			btnCard4.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCard2.setLocation(x-10, y-30);
			btnCard3.setLocation(x-40, y);
			btnCard4.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCard2.setLocation(x-10, y-30);
			btnCard3.setLocation(x-40, y);
			btnCard4.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCard2.setLocation(x, y-30);
			btnCard3.setLocation(x, y);
			btnCard4.setLocation(x, y+30);
		}
	}
	class CardListener4 implements MouseListener {
		int x = btnCard4.getX();
		int y = btnCard4.getY();


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
			btnCard3.setLocation(x-10, y-30);
			btnCard4.setLocation(x-40, y);
			btnCard5.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCard3.setLocation(x-10, y-30);
			btnCard4.setLocation(x-40, y);
			btnCard5.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCard3.setLocation(x-10, y-30);
			btnCard4.setLocation(x-40, y);
			btnCard5.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCard3.setLocation(x, y-30);
			btnCard4.setLocation(x, y);
			btnCard5.setLocation(x, y+30);
		}
	}
	class CardListener5 implements MouseListener {
		int x = btnCard5.getX();
		int y = btnCard5.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCard4.setLocation(x-10, y-30);
			btnCard5.setLocation(x-40, y);
			btnCard6.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCard4.setLocation(x-10, y-30);
			btnCard5.setLocation(x-40, y);
			btnCard6.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCard4.setLocation(x-10, y-30);
			btnCard5.setLocation(x-40, y);
			btnCard6.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCard4.setLocation(x, y-30);
			btnCard5.setLocation(x, y);
			btnCard6.setLocation(x, y+30);
		}
	}
	class CardListener6 implements MouseListener {
		int x = btnCard6.getX();
		int y = btnCard6.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCard5.setLocation(x-10, y-30);
			btnCard6.setLocation(x-40, y);
			btnCard7.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCard5.setLocation(x-10, y-30);
			btnCard6.setLocation(x-40, y);
			btnCard7.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCard5.setLocation(x-10, y-30);
			btnCard6.setLocation(x-40, y);
			btnCard7.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCard5.setLocation(x, y-30);
			btnCard6.setLocation(x, y);
			btnCard7.setLocation(x, y+30);
		}
	}
	class CardListener7 implements MouseListener {
		int x = btnCard7.getX();
		int y = btnCard7.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
			//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCard6.setLocation(x-10, y-30);
			btnCard7.setLocation(x-40, y);
			btnCard8.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCard6.setLocation(x-10, y-30);
			btnCard7.setLocation(x-40, y);
			btnCard8.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCard6.setLocation(x-10, y-30);
			btnCard7.setLocation(x-40, y);
			btnCard8.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCard6.setLocation(x, y-30);
			btnCard7.setLocation(x, y);
			btnCard8.setLocation(x, y+30);
		}
	}
	class CardListener8 implements MouseListener {
		int x = btnCard8.getX();
		int y = btnCard8.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
//TODO
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCard7.setLocation(x-10, y-30);
			btnCard8.setLocation(x-40, y);
			btnCard9.setLocation(x-10, y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCard7.setLocation(x-10, y-30);
			btnCard8.setLocation(x-40, y);
			btnCard9.setLocation(x-10, y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCard7.setLocation(x-10, y-30);
			btnCard8.setLocation(x-40, y);
			btnCard9.setLocation(x-10, y+30);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCard7.setLocation(x, y-30);
			btnCard8.setLocation(x, y);
			btnCard9.setLocation(x, y+30);
		}
	}
	class CardListener9 implements MouseListener {
		int x = btnCard9.getX();
		int y = btnCard9.getY();


		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCard8.setLocation(x-10, y-30);
			btnCard9.setLocation(x-40, y);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCard8.setLocation(x-10, y-30);
			btnCard9.setLocation(x-40, y);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCard8.setLocation(x-10, y-30);
			btnCard9.setLocation(x-40, y);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCard8.setLocation(x, y-30);
			btnCard9.setLocation(x, y);
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
