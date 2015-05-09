package model;

/*
 * 包括 坐标广播，系统广播，玩家的消息
 */
public class Broadcast {
    
    private Player from;
    private Player to;
    private String content;
    
	public Player getFrom() {
		return from;
	}
	public Player getTo() {
		return to;
	}
	public String getContent() {
		return content;
	}

    
}
