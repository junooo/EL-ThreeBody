package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.MainControl;
import ui.sound.Media;
import ui.sound.Sound;

public class AboutUsPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
  private JButton btnNextPage;
  private JLabel picture;
  private MainControl mc;
  
  
  public AboutUsPanel(MainControl mc){
	  this.setLayout(null);
	  this.initComonent();
	  this.mc = mc;
  }
  
  private void initComonent() {
	  this.btnNextPage=new JButton("下一页");
	  this.btnNextPage.setContentAreaFilled(false);
      this.btnNextPage.setBounds(0,0,200,50);
	  this.btnNextPage.setBorderPainted(false);
 
	  btnNextPage.addMouseListener(new NextPageListener());
	  btnNextPage.setVisible(true);
	  this.add(btnNextPage);
	  
	  Icon icon=new ImageIcon("929a10fa828ba61e3a1927a84134970a324e59f5.gif");
	  this.picture=new JLabel(icon);
	  this.picture.setBounds(0,0,200,200);
	  
	  this.picture.setVisible(true);
	  this.add(picture);
  }
  
  
  class NextPageListener implements MouseListener{
	  public void mouseClicked(MouseEvent arg0) {
		  Media.playSound(Sound.enter);
	  }

	  @Override
	  public void mouseEntered(MouseEvent arg0) {
		  Media.playSound(Sound.choose);
	  }

	  @Override
	  public void mouseExited(MouseEvent arg0) {
	  }

	  @Override
	  public void mousePressed(MouseEvent arg0) {
	  }

	  @Override
	  public void mouseReleased(MouseEvent arg0) {
	  }
}
  @Override
  //background picture
  public void paintComponent(Graphics g) {
	  Image AboutUs1=new ImageIcon("ABOUTUS1.jpg").getImage();
	  g.drawImage(AboutUs1,0,0,400,400,0,0,1024,512,null);
	}
}
