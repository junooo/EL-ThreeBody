package control;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.AboutUsPanel;
import ui.AnimatePanel;
import ui.MainFrame;
import ui.PreferencePanel;
import ui.StartMenuPanel;
import ui.account.AccountPanel;
import ui.game.GamePanel;
import ui.lobby.LobbyPanel;
import ui.sound.Media;
import ui.sound.Sound;
import util.R;
import dto.AccountDTO;

public class MainControl {

	private JPanel currentPanel = null;
	private JFrame frame = null;
	private JPanel startMenuPanel = null;
	private JPanel gamePanel = null;
	private JPanel aboutUs = null;
	private JPanel lobbyPanel = null;
	private JPanel account=null;
	private JPanel preference=null;
	private AnimatePanel animate=null;
	public AccountControl ac;
	
	private boolean connected = false;
	
	
	public static void main(String[] args) {

		MainControl mc = new MainControl();
		
		mc.ac = new AccountControl(mc);
		String id = AccountDTO.getInstance().getId();
		if(!id.equals("本地玩家")){
			if (mc.ac.loginByTransientID(id) == R.info.SUCCESS) {
				mc.connected = true;
			}
			
		}
		//TODO
		mc.gamePanel = new GamePanel(mc, 3);
		mc.aboutUs = new AboutUsPanel(mc);
		mc.frame = new MainFrame(mc);
		mc.startMenuPanel = new StartMenuPanel(mc);
		mc.currentPanel = mc.startMenuPanel;
		mc.toStartMenu();
//		mc.toAnimate("opening");
		Sound.load("BGM1");
		Media.playBGM(Sound.BGM);
	}

	/*
	 * TESTED
	 */
	public void toStartMenu() {
		currentPanel.setVisible(false);
		if (this.startMenuPanel == null) {
			this.startMenuPanel = new StartMenuPanel(this);
		}
		currentPanel = this.startMenuPanel;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}

	public void toAnimate(String fileName) {
		currentPanel.setVisible(false);
		this.animate = new AnimatePanel(fileName,this);
		currentPanel = this.animate;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
		animate.run();
	}

	public void toPreference() {
		currentPanel.setVisible(false);
		if (this.preference == null) {
			this.preference = new PreferencePanel(this);
		}
		currentPanel = this.preference;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}

	public void toTutorial() {
	}

	

	/*
	 * TESTED
	 */
	public void toGame() {
		currentPanel.setVisible(false);
		this.gamePanel = new GamePanel(this, 3);
		currentPanel = this.gamePanel;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}

	public void toLobby() {
		currentPanel.setVisible(false);
		if (this.lobbyPanel == null) {
			this.lobbyPanel = new LobbyPanel(this);
		}
		currentPanel = this.lobbyPanel;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}

	public void toRoom() {
		
	}

	public void toAboutUs() {
		currentPanel.setVisible(false);
		this.aboutUs = new AboutUsPanel(this);
		currentPanel = this.aboutUs;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}
	
	public void toAccount(String id) {
		currentPanel.setVisible(false);
		//TODO 这里传了this.ac 不合适再调
		this.account = new AccountPanel(this,id,this.ac);
		currentPanel = this.account;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}

	public void exit() {
		if(connected){
			ac.logout();
		}
		System.exit(0);
	}
	
	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	

}
