package ui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.InformFrame;

public class SuccessPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JButton btnOK;
	private JLabel msgLabel;
	/**
	 * 
	 * @param i 1代表login，2代表logup
	 * @param successInformFrame 
	 */
	public SuccessPanel(int i, InformFrame successInformFrame) {
		this.setLayout(null);
		this.frame=successInformFrame;
		this.initComonent(1);
	}
	private void initComonent(int i) {
		this.btnOK = new JButton(new ImageIcon("images/btnOk.png"));
		this.btnOK.setContentAreaFilled(false);
		this.btnOK.setBounds(120, 132,60, 30);
		btnOK.addMouseListener(new OKListener());
		this.add(btnOK);
		
		msgLabel = new JLabel();
		msgLabel.setForeground(Color.YELLOW);
		msgLabel.setFont(new Font("宋体", Font.BOLD, 20));
		msgLabel.setBounds(100,10,180,80);
		this.add(msgLabel);
		if(i==1){
			msgLabel.setText("登录成功！");
		}
		if(i==2){
			msgLabel.setText("注册成功！");
		}
		
	}
	
	class OKListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			frame.setVisible(false);
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	}
	
	public void paintComponent(Graphics g) {
		Image IMG_MAIN = new ImageIcon("images/img1.jpg").getImage();
		// 绘制游戏界面
		g.drawImage(IMG_MAIN, 0, 0,695,215, null);
	}

}
