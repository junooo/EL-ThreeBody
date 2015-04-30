package model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Room implements Serializable{
    
    /**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Account> accounts;
	private Account creater;
	private String name;
    /*
     * 是否开始
     */
	private boolean state;
    /*
     * 每位玩家是否准备好
     */
	private Map<Player,Boolean> ready;
    /*
     * 房间人数上限
     */
	private int size;
	
	/*
	 * getters
	 */
	public List<Account> getAccounts() {
		return accounts;
	}
	public Account getCreater() {
		return creater;
	}
	public String getName() {
		return name;
	}
	public boolean isState() {
		return state;
	}
	public Map<Player, Boolean> getReady() {
		return ready;
	}
	public int getSize() {
		return size;
	}

}
