package control;

import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.operation.Operable;
import model.operation.Operation;
import server.interfaces.RMIGame;
import dto.GameDTO;

/*
 * 分发一个线程负责与服务器通信，检查GameDTO里面的unhandledOperations
 * 提供可以调用的方法
 */
public class GameControl {
	

	private RMIGame rmig;
	private GameDTO gameDTO;

	public GameControl(RMIGame rmig) {
		this.rmig = rmig;
		gameDTO = GameDTO.getInstance();
		
		// 启动同步线程
		new SyncThread().start();
	}
	
	private class SyncThread extends Thread{
		
		String id = gameDTO.getUser().getAccount().getId();

		@Override
		public void run() {
			while(!gameDTO.isGameOver()){
				if(!gameDTO.getUnhandledOperations().isEmpty()){
					try {
						rmig.uploadOperation(id, gameDTO.getUnhandledOperations());
						// handle 本地的 Operable
						for (Operation operation : gameDTO.getUnhandledOperations()){
							if(operation instanceof Operable){
								((Operable)operation).process();
							}
							// TODO make broadcast
						}
						// 存入historyOperations并清空unhandledOperations
						gameDTO.addToHistoryOperations(gameDTO.getUnhandledOperations());
						gameDTO.setHandled();
						
						// handle 同步过来的人家的 Operable
						for (Operation operation : rmig.downloadOperation(id)) {
							if(operation instanceof Operable){
								((Operable)operation).process();
							}
							// TODO make broadcast
						}
						// 存入historyOperations
						gameDTO.addToHistoryOperations(gameDTO.getUnhandledOperations());
						
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} //while
		} //run
		
	}
	
	

		
	class TimeThread extends Thread{

		private int seconds;
		private JPanel countDown;
		
		TimeThread(JPanel  countDown){
			this .countDown= countDown;
			this.seconds=60;
		}
		
		@Override
		public void run() {
			
			while(seconds>0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				countDown.repaint();
				seconds--;
			}
			
		}
	}
	


}
