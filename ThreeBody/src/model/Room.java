package model;

import java.util.List;
import java.util.Map;

public class Room {
    
    List<Account> accounts;
    String name;
    /*
     * 是否开始
     */
    boolean state;
    /*
     * 每位玩家是否准备好
     */
    Map<Player,Boolean> ready;
    /*
     * 房间人数上限
     */
    int size;

}
