package ui.game;

import java.awt.Graphics;

import javax.swing.JPanel;

import ui.FrameUtil;

public class ResourcePanel extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	
	
	public ResourcePanel() {
		this.setLayout(null);
		setBounds(110, 478, 140, 32);
		setOpaque(false);
	}	
	
	@Override
	public void paint(Graphics g) {
		FrameUtil.drawNumberLeftPad(60, 0, 12, 3, g);
	}
}
