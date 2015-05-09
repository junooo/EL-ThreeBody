package ui;

import javax.swing.JFrame;

public class SophonFinderFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public SophonFinderFrame(){
		//设置标题
		this.setTitle("智子");
    	//设置窗口大小
    	this.setSize(450,200);
    	//不允许用户改变窗口大小
    	this.setResizable(false);
    	//窗口居中
    	FrameUtil.setFrameCenter(this);
//    	this.setContentPane(panel);
    	//默认窗口为显示
    	this.setVisible(true);
	}
}
