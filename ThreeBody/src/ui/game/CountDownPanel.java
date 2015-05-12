package ui.game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.FrameUtil;

public class CountDownPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int time;
	
	public CountDownPanel() {
		this.setLayout(null);
		setBounds(20, 20, 125,125);
	}	
	
	@Override
	public void paint(Graphics g) {
		Image IMG_MAIN = new ImageIcon("images/timer.png").getImage();
		// 绘制游戏界面
		g.drawImage(IMG_MAIN, 0, 0, null);
		FrameUtil.drawNumberLeftPad(18, 44,time, 3, g);
	}
}
