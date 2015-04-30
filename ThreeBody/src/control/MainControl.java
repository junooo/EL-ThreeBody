package control;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.BroadcastPanel;
import ui.GamePanel;
import ui.MainFrame;
import ui.SelectPanel;
import ui.StartMenuPanel;
import ui.sound.Media;
import ui.sound.Sound;


/*
 * 负责模块间的转跳
 */
public class MainControl {

    JPanel currentPanel;
    JFrame frame;
    JPanel startMainPanel;
    JPanel selectPanel;
    JPanel gamePanel;
    JPanel isOnlinePanel;
    JPanel broadcast;
    
    public void toStartMenu() {
    	this.frame.getContentPane().setVisible(false);
    	this.startMainPanel.setVisible(true);
    	this.frame.setContentPane(this.startMainPanel);
    }

    public void toAnimate() {

    }

    public void toConfig() {

    }

    public void toTutorial() {

    }
    
    public void toSelect(){
    	this.frame.getContentPane().setVisible(false);
    	this.selectPanel.setVisible(true);
    	this.frame.setContentPane(this.selectPanel);
    }

    public void toGame() {
    	this.frame.getContentPane().setVisible(false);
    	this.gamePanel.setVisible(true);
    	this.frame.setContentPane(this.gamePanel);
    }

    public void toLobby() {

    }

    public void toRoom() {

    }

    public void toAboutUs() {

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
	}

	public void openBroadcast() {
    	this.broadcast.setVisible(true);
    	this.frame.add(this.broadcast);
		
	}

}
