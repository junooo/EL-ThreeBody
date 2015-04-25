package dto;

import java.util.List;

import model.Broadcast;
import model.Operation;
import model.Player;

public class GameDTO {
    
    private List<Player> players;
    /*
     * 谁的回合
     */
    private Player whoseTurn;
    /*
     * 本地的玩家 
     */
    private Player user;
    /*
     * 历史消息记录
     */
    private List<Broadcast> broadcasts;
    /*
     * 历史操作记录
     */
    private List<Operation> operations;
    /*
     * 未执行的操作
     */
    private List<Operation> unhandledOperations;
    
    public void depositOperation(Operation operation){
        
    }
}
