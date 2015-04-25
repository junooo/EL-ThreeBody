package model;

import java.awt.Image;

public class Account {
    
    private String id;
    /*
     * 头像
     */
    private Image head;
    /*
     * 积分
     */
    private int point;
    private int rank;
    /*
     * 除了输和赢还有强退的
     */
    private int totalGames;
    private int wins;
    private int losts;
    private String country;

}
