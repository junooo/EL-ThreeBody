package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import control.MainControl;

public class BroadcastPanel extends JPanel {

	

	private JPanel panelBroadcast;
	private MainControl mainControl;

	public BroadcastPanel() {

//		setBounds(0, 0, 400, 200);
	}

	private void initComonent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintComponent(Graphics g) {
		Image IMG_MAIN = new ImageIcon("img1.jpg").getImage();
		// 绘制游戏界面
		g.drawImage(IMG_MAIN, 100, 100,150,50, null);
	}
}
