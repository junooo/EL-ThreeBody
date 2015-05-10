package ui;

import javax.swing.JFrame;

public class LoginFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public LoginFrame(){
		JFrame loginFrame = new JFrame();
		loginFrame.setSize(400, 300);
		FrameUtil.setFrameCenter(loginFrame);
		loginFrame.setTitle("登陆");
		loginFrame.setVisible(true);
	}
}
