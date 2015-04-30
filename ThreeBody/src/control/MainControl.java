package control;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.AboutUsPanel;
import ui.AnimatePanel;
import ui.BroadcastPanel;
import ui.GamePanel;
import ui.LobbyPanel;
import ui.MainFrame;
import ui.PreferencePanel;
import ui.RoomPanel;
import ui.SelectPanel;
import ui.StartMenuPanel;
import ui.TutorialPanel;
import ui.sound.Media;
import ui.sound.Sound;


/*
 * ����ģ����ת��
 */
public class MainControl {

    JPanel currentPanel;
    JFrame frame;
    JPanel startMainPanel;
    JPanel selectPanel;
    JPanel gamePanel;
    JPanel isOnlinePanel;
    JPanel broadcast;
    MainControl mainControl;
    
    public void toStartMenu() {
    	currentPanel.setVisible(false);
		currentPanel=new StartMenuPanel(this);
		frame.setContentPane(currentPanel);
    	currentPanel.setVisible(true);	
    }

    public void toAnimate() {
    	currentPanel.setVisible(false);
		currentPanel=new AnimatePanel();
		frame.setContentPane(currentPanel);
    	currentPanel.setVisible(true);
    }

    public void toPreference() {
    	currentPanel.setVisible(false);
		currentPanel=new PreferencePanel();
		frame.setContentPane(currentPanel);
    	currentPanel.setVisible(true);
    }

    public void toTutorial() {
    	currentPanel.setVisible(false);
		currentPanel=new TutorialPanel();
		frame.setContentPane(currentPanel);
    	currentPanel.setVisible(true);
    }
    
    public void toSelect(){
    	this.frame.getContentPane().setVisible(false);
    	this.selectPanel.setVisible(true);
    	this.frame.setContentPane(this.selectPanel);
    }

    public void toGame() {
    	currentPanel.setVisible(false);
		currentPanel=new GamePanel(this);
		frame.setContentPane(currentPanel);
    	currentPanel.setVisible(true);
    }

    public void toLobby() {
    	currentPanel.setVisible(false);
		currentPanel=new LobbyPanel();
		frame.setContentPane(currentPanel);
    	currentPanel.setVisible(true);
    }

    public void toRoom() {
    	currentPanel.setVisible(false);
		currentPanel=new RoomPanel();
		frame.setContentPane(currentPanel);
    	currentPanel.setVisible(true);
    }

    public void toAboutUs() {
    	currentPanel.setVisible(false);
		currentPanel=new AboutUsPanel();
		frame.setContentPane(currentPanel);
    	currentPanel.setVisible(true);
    }

    public void exit() {
    	System.exit(0);
    }
    public static void main(String[] args) {
    	MainControl mc = new MainControl();
    	mc.startMainPanel = new StartMenuPanel(mc);
    	mc.gamePanel = new GamePanel(mc);
    	mc.selectPanel = new SelectPanel(mc);
    	mc.broadcast = new BroadcastPanel(mc);
    	mc.broadcast.setBounds(0, 0, 400, 200);
    	mc.frame = new MainFrame();
    	mc.frame.setContentPane(mc.startMainPanel);
    	Sound.load("BGM1");
    	Media.playBGM(Sound.BGM);
    	mc.currentPanel=new StartMenuPanel(mc);
	}

	public void openBroadcast() {
    	this.broadcast.setVisible(true);
    	this.frame.add(this.broadcast);
		
	}

}
