package control;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.*;
import ui.sound.*;

/*
 * ����ģ����ת��
 */
public class MainControl {

    JPanel currentPanel;
    JFrame frame;
    JPanel startMainPanel;
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

    public void toGame() {
    	currentPanel.setVisible(false);
		currentPanel=new GamePanel();
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
    	mc.frame = new MainFrame();
    	mc.startMainPanel = new StartMenuPanel(mc);
    	mc.frame.setContentPane(mc.startMainPanel);
    	Sound.load("BGM1");
    	Media.playBGM(Sound.BGM);
    	mc.currentPanel=new StartMenuPanel(mc);
	}
}
