package ui.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Coordinate;
import model.Player;
import model.card.Card;
import model.card.ResourcePotion;
import model.card.TechPotion;
import model.card.WholeBlock;
import model.operation.CardUse;
import model.operation.Operation;
import model.operation.TurnChange;
import model.role.Role;
import ui.FrameUtil;
import ui.InformFrame;
import ui.block.PatialBlockFrame;
import ui.block.PatialBlockPanel;
import ui.sophon.SophonFinderFrame;
import ui.sophon.SophonFinderPanel;
import control.GameControl;
import control.MainControl;
import dto.AccountDTO;
import dto.GameDTO;

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
	private boolean isAbleToPress = true;
	private JButton btnBroadcast;
	private JButton btnHistory;
	private JButton btnMessage;
	private JLabel labelRole;
	private JLabel numOfBout;
	private JLabel numOfRound;
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
	
	private JLabel[] enemyLabels = new JLabel[7];
	private JLabel[] coordinateOfEnemies = new JLabel[7];
	private JLabel[] promptLabels = new JLabel[9];
	private ImageIcon[] prompts = new ImageIcon[9];
	private List<Rectangle> location = new ArrayList<Rectangle>(7);
	
	private List<Player> enemies = new ArrayList<Player>();
	private Player user = GameDTO.getInstance().getUser();
	private GameControl gameControl;
	private GameDTO gameDTO;
	
	public GamePanel(MainControl mainControl,int NumOfPlayer,GameControl gameControl) {
		this.gameControl = gameControl;
		this.gameDTO = GameDTO.getInstance();
		// 初始化对方玩家
		for (Player player : gameDTO.getPlayers()) {
			if(!player.getAccount().getId().equals(user.getAccount().getId())){
				enemies.add(player);
			}
		}
		
		this.setLayout(null);
		this.mainControl = mainControl;
		this.NumOfPlayer=NumOfPlayer;
		this.initComonent();
		this.initEnemyLocation();
		this.initPrompt();
		this.createEnemy();
		this.createCoordinatePanel();
	}
	private void initPrompt() {
		prompts[0]=new ImageIcon("images/psSophonLabel.png");
		prompts[1]=new ImageIcon("images/psSillySophonLabel.png");
		prompts[2]=new ImageIcon("images/psWholeBlockLabel.png");
		prompts[3]=new ImageIcon("images/psPartialBlockLabel.png");
		prompts[4]=new ImageIcon("images/psNoBroadcastLabel.png");
		prompts[5]=new ImageIcon("images/psResourcePotionLabel.png");
		prompts[6]=new ImageIcon("images/psTechPotionLabel.png");
		prompts[7]=new ImageIcon("images/psGambleLabel.png");
		prompts[8]=new ImageIcon("images/psRoleGetLabel.png");
		for (int i = 0; i < prompts.length; i++) {
			promptLabels[i] = new JLabel();
			promptLabels[i].setIcon(prompts[i]);
			promptLabels[i].setVisible(false);
		}
	}

	/**
	 * 存放敌人的位置
	 */
	private void initEnemyLocation() {
		Rectangle  enemy1 = new Rectangle(350,100,100,100);
		Rectangle  enemy2 = new Rectangle(650,100,100,100);
		Rectangle  enemy3= new Rectangle(250,300,100,100);
		Rectangle  enemy4 =new Rectangle(500,300,100,100);
		Rectangle  enemy5 = new Rectangle(750,300,100,100);
		Rectangle  enemy6 =new Rectangle(100,100,100,100);
		Rectangle  enemy7 =new Rectangle(900,100,100,100);
		location.add(enemy1);
		location.add(enemy2);
		location.add(enemy3);
		location.add(enemy4);
		location.add(enemy5);
		location.add(enemy6);
		location.add(enemy7);
	}
	
	/**
	 * 添加敌人
	 */
	private void createEnemy() {
		for (int i = 0; i < NumOfPlayer-1; i++) {
			enemyLabels[i] = new JLabel();
			enemyLabels[i].setIcon(new ImageIcon("images/star07.gif"));
			enemyLabels[i].setBounds(location.get(i));
			enemyLabels[i].addMouseListener(new EnemyListener(i));
			this.add(enemyLabels[i]);
		}
	}
	
	private void coordinateShow(int i){
		Player pi = this.enemies.get(i);
		String role = user.getFoundRoles().get(pi) == null ? "未明" : pi.getRole().toString();
		coordinateOfEnemies[i].setText("<html>玩家："+pi.getAccount().getId()+"<br>"
				+"坐标："+user.getFoundCoordinates().get(pi).toString()+"<br>"
				+"角色："+role+"</html>");
		coordinateOfEnemies[i].setVisible(true);
	}
	
	private void createCoordinatePanel() {
		for (int i = 0; i < NumOfPlayer-1; i++) {
			coordinateOfEnemies[i] = new JLabel();
			coordinateOfEnemies[i].setFont(new Font("宋体",Font.PLAIN,20));
			coordinateOfEnemies[i].setForeground(Color.YELLOW);
			coordinateOfEnemies[i].setBackground(Color.DARK_GRAY);
			coordinateOfEnemies[i].setOpaque(true);
			Rectangle rec = location.get(i);
			rec.x-=25; rec.y+=85; rec.width+=50; rec.height=100;
			coordinateOfEnemies[i].setBounds(rec);
			coordinateOfEnemies[i].setVisible(false);
			this.add(coordinateOfEnemies[i]);
		}
	}
	/**
	 * 初始化
	 */
	private void initComonent() {
		this.btnReturn = new JButton("返回");
		this.btnReturn.setContentAreaFilled(false);
		this.btnReturn.setBounds(20, 565, 120, 30);
		this.btnReturn.setFont(new Font("黑体", Font.BOLD, 20));
		this.btnReturn.setForeground(Color.YELLOW);
		this.btnReturn.addMouseListener(new ReturnListener());
		this.add(btnReturn);
		
		this.btnBroadcast = new JButton("广播");
		this.btnBroadcast.setContentAreaFilled(false);
		this.btnBroadcast.setBounds(260, 600, 80, 20);
		this.btnBroadcast.setFont(new Font("黑体", Font.BOLD, 15));
		this.btnBroadcast.setForeground(Color.YELLOW);
		this.btnBroadcast.addMouseListener(new BroadcastListener());
		this.add(btnBroadcast);
		
		this.btnHistory = new JButton("历史记录");
		this.btnHistory.setContentAreaFilled(false);
		this.btnHistory.setBounds(523, 600, 100, 20);
		this.btnHistory.setFont(new Font("黑体", Font.BOLD, 15));
		this.btnHistory.setForeground(Color.YELLOW);
		this.btnHistory.addMouseListener(new HistoryListener());
		this.add(btnHistory);
		
		this.btnMessage = new JButton("留言");
		this.btnMessage.setContentAreaFilled(false);
		this.btnMessage.setBounds(816, 600, 80, 20);
		this.btnMessage.setFont(new Font("黑体", Font.BOLD, 15));
		this.btnMessage.setForeground(Color.YELLOW);
		this.btnMessage.addMouseListener(new MessageListener());
		this.add(btnMessage);
		
		this.btnTurnEnd = new JButton("回合结束");
		this.btnTurnEnd.setContentAreaFilled(false);
		this.btnTurnEnd.setBounds(1000, 500, 150, 30);
		this.btnTurnEnd.setFont(new Font("黑体", Font.BOLD, 15));
		this.btnTurnEnd.setForeground(Color.YELLOW);
		this.btnTurnEnd.addMouseListener(new EndListener());
		this.add(btnTurnEnd);
		
		this.btnCardSophon = new JButton("智子");
		this.btnCardSophon.setContentAreaFilled(false);
		this.btnCardSophon.setBounds(1070, 30, 150, 30);
		this.btnCardSophon.setFont(new Font("黑体", Font.BOLD, 15));
		this.btnCardSophon.setForeground(Color.YELLOW);
		this.btnCardSophon.addMouseListener(new CardSophonListener());
		this.add(btnCardSophon);
		
		
		this.btnCardSillySophon = new JButton("人造智子");
		this.btnCardSillySophon.setContentAreaFilled(false);
		this.btnCardSillySophon.setBounds(1070, 60, 150, 30);
		this.btnCardSillySophon.setForeground(Color.YELLOW);
		this.btnCardSillySophon.addMouseListener(new CardSillySophonListener());
		this.add(btnCardSillySophon);
		
		this.btnCardWholeBlock = new JButton("全局黑域");
		this.btnCardWholeBlock.setContentAreaFilled(false);
		this.btnCardWholeBlock.setBounds(1070, 90, 150, 30);
		this.btnCardWholeBlock.setForeground(Color.YELLOW);
		this.btnCardWholeBlock.addMouseListener(new CardWholeBlockListener());
		this.add(btnCardWholeBlock);
		
		this.btnCardPatialBlock = new JButton("局部黑域");
		this.btnCardPatialBlock.setContentAreaFilled(false);
		this.btnCardPatialBlock.setBounds(1070, 120, 150, 30);
		this.btnCardPatialBlock.setForeground(Color.YELLOW);
		this.btnCardPatialBlock.addMouseListener(new CardPatialBlockListener());
		this.add(btnCardPatialBlock);
		
		this.btnCardNoBroadcasting = new JButton("电波干扰");
		this.btnCardNoBroadcasting.setContentAreaFilled(false);
		this.btnCardNoBroadcasting.setBounds(1070, 150, 150, 30);
		this.btnCardNoBroadcasting.setForeground(Color.YELLOW);
		this.btnCardNoBroadcasting.addMouseListener(new CardNoBroadcastingListener());
		this.add(btnCardNoBroadcasting);
		
		this.btnCardTechPotion = new JButton("科技革命");
		this.btnCardTechPotion.setContentAreaFilled(false);
		this.btnCardTechPotion.setBounds(1070, 180, 150, 30);
		this.btnCardTechPotion.setForeground(Color.YELLOW);
		this.btnCardTechPotion.addMouseListener(new CardTechPotionListener());
		this.add(btnCardTechPotion);
		
		this.btnCardResourcePotion = new JButton("资源爆发");
		this.btnCardResourcePotion.setContentAreaFilled(false);
		this.btnCardResourcePotion.setBounds(1070, 210, 150, 30);
		this.btnCardResourcePotion.setForeground(Color.YELLOW);
		this.btnCardResourcePotion.addMouseListener(new CardResourcePotionListener());
		this.add(btnCardResourcePotion);
		
		this.btnCardResourceGambling = new JButton("资源赌博");
		this.btnCardResourceGambling.setContentAreaFilled(false);
		this.btnCardResourceGambling.setBounds(1070, 240, 150, 30);
		this.btnCardResourceGambling.setForeground(Color.YELLOW);
		this.btnCardResourceGambling.addMouseListener(new CardResourceGamblingListener());
		this.add(btnCardResourceGambling);
		
		this.btnPriviledgeGetRole = new JButton("特权");
		this.btnPriviledgeGetRole.setContentAreaFilled(false);
		this.btnPriviledgeGetRole.setBounds(1070, 270, 150, 30);
		this.btnPriviledgeGetRole.setForeground(Color.YELLOW);
		this.btnPriviledgeGetRole.addMouseListener(new PriviledgeGetRoleListener());
		this.add(btnPriviledgeGetRole);
		
		this.resourceString = new JLabel(new ImageIcon("images/resource.png"));
		this.resourceString.setBounds(100,480,60,30);
		this.add(resourceString);
		
		this.techString = new JLabel(new ImageIcon("images/tech.png"));
		this.techString.setBounds(100,510,60,30);
		this.add(techString);
		
		this.labelRole = new JLabel(new ImageIcon("images/img1.jpg"));
		this.labelRole.setBounds(100,375,100,100);
		this.initRoleImage();
		this.add(labelRole);
		
		this.numOfBout = new JLabel("现在回合数："+GameDTO.getInstance().getBout());
		this.numOfBout.setForeground(Color.YELLOW);
		this.numOfBout.setFont(new Font("黑体",Font.BOLD,20));
		this.numOfBout.setBounds(180, 40,500,30);
		this.add(numOfBout);
		
		this.numOfRound = new JLabel("现在轮次数："+GameDTO.getInstance().getRound());
		this.numOfRound.setForeground(Color.YELLOW);
		this.numOfRound.setFont(new Font("黑体",Font.BOLD,20));
		this.numOfRound.setBounds(180, 70,500,30);
		this.add(numOfRound);

		this.add(panelTech);
		this.add(panelResource);
		this.add(panelCountDown);
	}

	private void initRoleImage() {
		Role roleName = GameDTO.getInstance().getUser().getRole();
		if(roleName.toString().equals("地球")){
			Image Img_earth = new ImageIcon("images/earth.png").getImage();
			Img_earth = Img_earth.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			labelRole.setIcon(new ImageIcon(Img_earth));
			return;
		}
		if(roleName.toString().equals("三体")){
			Image Img_threeBody = new ImageIcon("images/threeBody.png").getImage();
			Img_threeBody = Img_threeBody.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			labelRole.setIcon(new ImageIcon(Img_threeBody));
			return;
		}
		if(roleName.toString().equals("归一者")){
			Image Img_unifier = new ImageIcon("images/unifier.png").getImage();
			Img_unifier = Img_unifier.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			labelRole.setIcon(new ImageIcon(Img_unifier));
			return;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		Image IMG_MAIN = new ImageIcon("images/gamebg.jpg").getImage();
		g.drawImage(IMG_MAIN, 0, 0, 1158, 650, null);
	}
	
	class ReturnListener extends MouseAdapter  {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 测试
			System.out.println(AccountDTO.getInstance().getId()+"端:");
			System.out.println("第"+gameDTO.getBout()+"回合");
			System.out.println("回合玩家："+gameDTO.getWhoseTurn().getAccount().getId());
			List<Player> players = gameDTO.getPlayers();
			for (Player player : players) {
				System.out.println("--"+player.getAccount().getId()+":");
				System.out.println("--"+player.getRole()+":");
				System.out.println("--"+"资源："+player.getResource());
				System.out.println("--"+"科技："+player.getTechPoint());
				System.out.println("--"+"坐标："+player.getCoordinate().toString());
				System.out.println("--"+"保护情况"+player.getCoordinate().getProtectingState());
				if(player.isPrivilegeAvailable()){
					System.out.println("--可以用特权");
				}else{
					System.out.println("--不可以用特权");
				}
				if(player.isBroadcastable()){
					System.out.println("--可以用广播");
				}else{
					System.out.println("--不能用广播");
				}
				if(player.isLost()){
					System.out.println("--已死");
				}else{
					System.out.println("--存活中");
				}
				System.out.println("----"+"发现坐标：");
				for(Entry<Player,Coordinate> entry:player.getFoundCoordinates().entrySet()){
					System.out.println("----"+entry.getKey().getAccount().getId()+":"+entry.getValue());
				}
				System.out.println("----"+"发现角色：");
				for(Entry<Player,Role> entry:player.getFoundRoles().entrySet()){
					System.out.println("----"+entry.getKey().getAccount().getId()+":"+entry.getValue());
				}
				System.out.println("---------------------------");
			}
			System.out.println("=======================================================================");
		}
	}
	/**
	 * 智子
	 * @author user
	 *
	 */
	class CardSophonListener implements MouseListener {
		int x = btnCardSophon.getX();
		int y = btnCardSophon.getY();
		Rectangle rec = btnCardSophon.getBounds();
		@Override
		public void mouseClicked(MouseEvent e) {
			initSophon();
		}
		private void initSophon() {
			JFrame sophonFinderFrame = new SophonFinderFrame("智子");
			JPanel finder = new SophonFinderPanel(sophonFinderFrame,gameControl);
			sophonFinderFrame.setContentPane(finder);
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
			promptLabels[0].setBounds(rec.x-prompts[0].getIconWidth()-40,rec.y,prompts[0].getIconWidth(),prompts[0].getIconHeight());
			promptLabels[0].setVisible(true);
			add(promptLabels[0]);
			repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardSophon.setLocation(x, y);
			btnCardSillySophon.setLocation(x, y+30);
			promptLabels[0].setVisible(false);
		}
	}
	/**
	 * 低级智子
	 * @author user
	 *
	 */
	class CardSillySophonListener implements MouseListener {
		int x = btnCardSillySophon.getX();
		int y = btnCardSillySophon.getY();
		Rectangle rec = btnCardSillySophon.getBounds();
		@Override
		public void mouseClicked(MouseEvent e) {
			initSillySophon();
			
		}
		private void initSillySophon() {
			JFrame sophonFinder = new SophonFinderFrame("人造智子");
			JPanel finder = new SophonFinderPanel(sophonFinder,gameControl);
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
			promptLabels[1].setBounds(rec.x-prompts[1].getIconWidth()-40,rec.y,prompts[1].getIconWidth(),prompts[1].getIconHeight());
			promptLabels[1].setVisible(true);
			add(promptLabels[1]);
			repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardSophon.setLocation(x, y-30);
			btnCardSillySophon.setLocation(x, y);
			btnCardWholeBlock.setLocation(x, y+30);
			promptLabels[1].setVisible(false);
		}
	}
	/**
	 * 全局黑域
	 * @author user
	 *
	 */
	class CardWholeBlockListener implements MouseListener {
		int x = btnCardWholeBlock.getX();
		int y = btnCardWholeBlock.getY();
		Rectangle rec = btnCardWholeBlock.getBounds();
		@Override
		public void mouseClicked(MouseEvent e) {
			FrameUtil.sendMessageByFrame("全局黑域", "保护所有坐标一轮");
			String id = AccountDTO.getInstance().getId();
			Card wholeBlock = new WholeBlock(id, null);
			Operation cardUse = new CardUse(id,null,wholeBlock);
			GameControl.getInstance().doOperation(cardUse);
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
			promptLabels[2].setBounds(rec.x-prompts[2].getIconWidth()-40,rec.y,prompts[2].getIconWidth(),prompts[2].getIconHeight());
			promptLabels[2].setVisible(true);
			add(promptLabels[2]);
			repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardSillySophon.setLocation(x, y-30);
			btnCardWholeBlock.setLocation(x, y);
			btnCardPatialBlock.setLocation(x, y+30);
			promptLabels[2].setVisible(false);
		}
	}
	/**
	 * 局部黑域
	 * @author user
	 *
	 */
	class CardPatialBlockListener implements MouseListener {
		int x = btnCardPatialBlock.getX();
		int y = btnCardPatialBlock.getY();
		Rectangle rec = btnCardPatialBlock.getBounds();
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
			promptLabels[3].setBounds(rec.x-prompts[3].getIconWidth()-40,rec.y,prompts[3].getIconWidth(),prompts[3].getIconHeight());
			promptLabels[3].setVisible(true);
			add(promptLabels[3]);
			repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardWholeBlock.setLocation(x, y-30);
			btnCardPatialBlock.setLocation(x, y);
			btnCardNoBroadcasting.setLocation(x, y+30);
			promptLabels[3].setVisible(false);
		}
	}
	/**
	 * 电波干扰（禁广播）
	 * @author user
	 *
	 */
	class CardNoBroadcastingListener implements MouseListener {
		int x = btnCardNoBroadcasting.getX();
		int y = btnCardNoBroadcasting.getY();
		Rectangle rec = btnCardNoBroadcasting.getBounds();
		@Override
		public void mouseClicked(MouseEvent e) {
			JFrame iframe = new InformFrame("电波干扰", 300, 200);
			JPanel selectEnemyPanel = new SelectEnemyPanel(iframe,"选择要干扰的敌人");
			iframe.add(selectEnemyPanel);
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
			promptLabels[4].setBounds(rec.x-prompts[4].getIconWidth()-40,rec.y,prompts[4].getIconWidth(),prompts[4].getIconHeight());
			promptLabels[4].setVisible(true);
			add(promptLabels[4]);
			repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardPatialBlock.setLocation(x, y-30);
			btnCardNoBroadcasting.setLocation(x, y);
			btnCardTechPotion.setLocation(x, y+30);
			promptLabels[4].setVisible(false);
		}
	}
	/**
	 * 科技爆发
	 * @author Ann
	 *
	 */
	class CardTechPotionListener implements MouseListener {
		int x = btnCardTechPotion.getX();
		int y = btnCardTechPotion.getY();
		Rectangle rec = btnCardTechPotion.getBounds();
		@Override
		public void mouseClicked(MouseEvent e) {
			useTechPotion();
		}
		private void useTechPotion() {
			String id=user.getAccount().getId();
			TechPotion tp = new TechPotion(id, id);
			CardUse cardUseTp=new CardUse(id, id, tp);
			gameControl.doOperation(cardUseTp);
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
			promptLabels[5].setBounds(rec.x-prompts[5].getIconWidth()-40,rec.y,prompts[5].getIconWidth(),prompts[5].getIconHeight());
			promptLabels[5].setVisible(true);
			add(promptLabels[5]);
			repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardNoBroadcasting.setLocation(x, y-30);
			btnCardTechPotion.setLocation(x, y);
			btnCardResourcePotion.setLocation(x, y+30);
			promptLabels[5].setVisible(false);
		}
	}
	/**
	 * 资源爆发
	 * @author user
	 *
	 */
	class CardResourcePotionListener implements MouseListener {
		Rectangle rec = btnCardResourcePotion.getBounds();
		@Override
		public void mouseClicked(MouseEvent e) {
			String id = AccountDTO.getInstance().getId();
			Card resourcePotion = new ResourcePotion(id, null);
			Operation cardUse = new CardUse(id,null,resourcePotion);
			GameControl.getInstance().doOperation(cardUse);
			repaint();
		}
		@Override
		public void mousePressed(MouseEvent e) {
			btnCardTechPotion.setLocation(rec.x-10, rec.y-30);
			btnCardResourcePotion.setLocation(rec.x-40, rec.y);
			btnCardResourceGambling.setLocation(rec.x-10, rec.y+30);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			btnCardTechPotion.setLocation(rec.x-10, rec.y-30);
			btnCardResourcePotion.setLocation(rec.x-40, rec.y);
			btnCardResourceGambling.setLocation(rec.x-10, rec.y+30);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			btnCardTechPotion.setLocation(rec.x-10, rec.y-30);
			btnCardResourcePotion.setLocation(rec.x-40, rec.y);
			btnCardResourceGambling.setLocation(rec.x-10,rec. y+30);
			promptLabels[6].setBounds(rec.x-prompts[6].getIconWidth()-40,rec.y,prompts[6].getIconWidth(),prompts[6].getIconHeight());
			promptLabels[6].setVisible(true);
			add(promptLabels[6]);
			repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardTechPotion.setLocation(rec.x, rec.y-30);
			btnCardResourcePotion.setLocation(rec.x, rec.y);
			btnCardResourceGambling.setLocation(rec.x, rec.y+30);
			promptLabels[6].setVisible(false);
		}
	}
	/**
	 * 赌博
	 * @author Ann
	 *
	 */
	class CardResourceGamblingListener implements MouseListener {
		int x = btnCardResourceGambling.getX();
		int y = btnCardResourceGambling.getY();
		Rectangle rec = btnCardResourceGambling.getBounds();
		@Override
		public void mouseClicked(MouseEvent e) {
			JFrame iframe = new InformFrame("资源赌博", 300, 200);
			JPanel gamblePanel = new GamblePanel(iframe,"输入要赌博的资源");
			iframe.add(gamblePanel);
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
			promptLabels[7].setBounds(rec.x-prompts[7].getIconWidth()-40,rec.y,prompts[7].getIconWidth(),prompts[7].getIconHeight());
			promptLabels[7].setVisible(true);
			add(promptLabels[7]);
			repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardResourcePotion.setLocation(x, y-30);
			btnCardResourceGambling.setLocation(x, y);
			btnPriviledgeGetRole.setLocation(x, y+30);
			promptLabels[7].setVisible(false);
		}
	}
	/**
	 * 特权
	 * @author user
	 *
	 */
	class PriviledgeGetRoleListener implements MouseListener {
		int x = btnPriviledgeGetRole.getX();
		int y = btnPriviledgeGetRole.getY();
		Rectangle rec = btnPriviledgeGetRole.getBounds();
		@Override
		public void mouseClicked(MouseEvent e) {
			JFrame iframe = new InformFrame("特权_身份探知", 300, 200);
			JPanel selectEnemyPanel = new SelectEnemyPanel(iframe,"选择要探知的敌人");
			iframe.add(selectEnemyPanel);
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
			promptLabels[8].setBounds(rec.x-prompts[8].getIconWidth()-40,rec.y,prompts[8].getIconWidth(),prompts[8].getIconHeight());
			promptLabels[8].setVisible(true);
			add(promptLabels[8]);
			repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			btnCardResourceGambling.setLocation(x, y-30);
			btnPriviledgeGetRole.setLocation(x, y);
			promptLabels[8].setVisible(false);
		}
	}
	
	class BroadcastListener extends MouseAdapter  {
		@Override
		public void mouseReleased(MouseEvent e) {
			panelBroadcast.setVisible(true);
			panelMessage.setVisible(false);
			panelHistory.setVisible(false);
			add(panelBroadcast);
			repaint();
		}
	}
	
	class HistoryListener extends MouseAdapter  {
		@Override
		public void mouseReleased(MouseEvent e) {
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
		public void mouseEntered(MouseEvent e) {
			repaint();
		}
	}
	class MessageListener extends MouseAdapter  {
		@Override
		public void mouseReleased(MouseEvent e) {
			panelBroadcast.setVisible(false);
			panelHistory.setVisible(false);
			panelMessage.setVisible(true);
			add(panelMessage);
			repaint();
		}
	}
	
	class EnemyListener extends MouseAdapter {
		int number;
		public EnemyListener(int number) {
			this.number=number;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			coordinateShow(number);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			coordinateOfEnemies[number].setVisible(false);
		}
	}
	
	class EndListener extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			Operation turnChange = new TurnChange(null,null);
			GameControl.getInstance().doOperation(turnChange);
		}
	}

	/*
     * 被人广播时播放的特效
     */
    public void boom(){
        
    }
    
    /*
     * 被三体侵占时播放的特效
     */
    public void conquer(){
        
    }
}
