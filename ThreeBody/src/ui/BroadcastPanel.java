package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import control.MainControl;

public class BroadcastPanel extends GamePanel {

	

	private JPanel panelBroadcast;
	private MainControl mainControl;

	public BroadcastPanel(MainControl mainControl) {
		super(mainControl);
	}

	private void initComonent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintComponent(Graphics g) {
		Image IMG_MAIN = new ImageIcon("img3.jpg").getImage();
		// 绘制游戏界面
		g.drawImage(IMG_MAIN, 0, 0, 1158, 650, null);
	}
}
