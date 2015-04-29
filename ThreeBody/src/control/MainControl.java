package control;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.*;
import ui.sound.*;

/*
 * ����ģ����ת��
 */
public class MainControl {

    static JPanel currentPanel;
    JFrame frame;
    JPanel startMainPanel;
    MainControl mainControl;
    
    public void toStartMenu() {
    	currentPanel.setVisible(false);
		currentPanel=new StartMenuPanel(this);
    	currentPanel.setVisible(true);
    }

    public void toAnimate() {
    	currentPanel.setVisible(false);
		currentPanel=new AnimatePanel();
    	currentPanel.setVisible(true);
    }

    public void toPreference() {
    	currentPanel.setVisible(false);
		currentPanel=new PreferencePanel();
    	currentPanel.setVisible(true);
    }

    public void toTutorial() {
    	currentPanel.setVisible(false);
		currentPanel=new TutorialPanel();
    	currentPanel.setVisible(true);
    }

    public void toGame() {
    	currentPanel.setVisible(false);
		currentPanel=new GamePanel();
    	currentPanel.setVisible(true);
    }

    public void toLobby() {
    	currentPanel.setVisible(false);
		currentPanel=new LobbyPanel();
    	currentPanel.setVisible(true);
    }

    public void toRoom() {
    	currentPanel.setVisible(false);
		currentPanel=new RoomPanel();
    	currentPanel.setVisible(true);
    }

    public void toAboutUs() {
    	currentPanel.setVisible(false);
		currentPanel=new AboutUsPanel();
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
    	currentPanel=new StartMenuPanel(mc);
	}
}
