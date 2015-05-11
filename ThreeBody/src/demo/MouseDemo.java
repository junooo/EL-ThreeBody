package demo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MouseDemo extends JFrame  implements MouseListener,MouseWheelListener{
    static int chang=400,kuang=400;
    public MouseDemo(){
    JPanel j=new JPanel();
    JButton jb=new JButton("click");
    j.add(jb);
    this.add(j);
    this.setVisible(true);
    this.setSize(chang,kuang);
    jb.addMouseListener(this);
    this.addMouseWheelListener(this);
    }
    public   void mouseClicked(MouseEvent e){
        //左击事件
        if(e.getButton()==MouseEvent.BUTTON1)
            System.out.println("zuo ji shi jian ....");
        //滑轮按下事件
        if(e.getButton()==MouseEvent.BUTTON2)
            System.out.println("zhong  ji shi jian ....");
        //右击事件
        if(e.getButton()==MouseEvent.BUTTON3)
            System.out.println("you ji shi jian ....");
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MouseDemo();
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    //利用滚轮事件将窗口放大和缩小
    public void mouseWheelMoved(MouseWheelEvent e) {
        // TODO Auto-generated method stub
        if(e.getWheelRotation()==1){
            chang+=10;
            kuang+=10;
            this.setSize(chang,kuang);
            this.validate();
            System.out.println("滑轮向前。。。。");
        }
        if(e.getWheelRotation()==-1){
            chang-=10;
            kuang-=10;
            this.setSize(chang,kuang);
            this.validate();
            System.out.println("滑轮向后....");
        }
    }
}
