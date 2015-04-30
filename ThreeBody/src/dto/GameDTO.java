package dto;

import java.util.List;

import model.Broadcast;
import model.Player;
import model.operation.Operation;

public class GameDTO {
	
	/*
	 * 单例模式
	 */
	private static GameDTO dto = new GameDTO();
    
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
    
    private GameDTO(){}
    
    public static GameDTO getInstance(){
    	return dto;
    }
    
    public void depositOperation(Operation operation){
        
    }

    /*
     * getters and setters
     */
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player getWhoseTurn() {
		return whoseTurn;
	}

	public void setWhoseTurn(Player whoseTurn) {
		this.whoseTurn = whoseTurn;
	}

	public Player getUser() {
		return user;
	}

	public void setUser(Player user) {
		this.user = user;
	}

	public List<Broadcast> getBroadcasts() {
		return broadcasts;
	}

	public void setBroadcasts(List<Broadcast> broadcasts) {
		this.broadcasts = broadcasts;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public List<Operation> getUnhandledOperations() {
		return unhandledOperations;
	}

	public void setUnhandledOperations(List<Operation> unhandledOperations) {
		this.unhandledOperations = unhandledOperations;
	}
    
    
}
