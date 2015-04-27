package model;

import java.awt.Image;
import java.io.Serializable;

public class Account implements Serializable{
    
    /**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
    /*
     * 头像
     */
    private Image head;
    /*
     * 积分
     */
    private int point;
    /*
     * 排名
     */
    private int rank;
    /*
     * 总游戏次数，除了输和赢还有强退的
     */
    private int totalGames;
    private int wins;
    private int losts;
    private String regions;

}
