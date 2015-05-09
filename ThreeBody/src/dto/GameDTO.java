package dto;

import java.util.LinkedList;
import java.util.List;

import model.Broadcast;
import model.Player;
import model.operation.Operation;

public class GameDTO {
	
	/*
	 * singleton
	 */
	private static GameDTO dto;
    
    private List<Player> players;
 
	/*
     * 本回合操作者
     */
    private Player whoseTurn;
    /*
     * 本地玩家
     */
    private Player user;
    /*
     * 历史消息记录
     */
    private List<Broadcast> broadcasts;
    /*
     *历史操作记录
     */
    private List<Operation> historyOperations;
    /*
     * 待执行操作
     */
    private List<Operation> unhandledOperations;
    /*
     * 游戏是否结束
     */
    private boolean gameOver;
    
    public void setUp(List<Player> players){
    	dto = new GameDTO(players);
    }
    
    private GameDTO(List<Player> players){
    	this.players = players;
    	whoseTurn = players.get(0);
    	//TODO 本地账号
    	broadcasts = new LinkedList<Broadcast>();
    	historyOperations = new LinkedList<Operation>();
    	unhandledOperations = new LinkedList<Operation>();
    }
    
    public static GameDTO getInstance(){
    	return dto;
    }
    
    public void depositOperation(Operation operation){
        this.unhandledOperations.add(operation);
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

	public List<Operation> getHistoryOperations() {
		return historyOperations;
	}
	
	public void addToHistoryOperations(List<Operation> oprts){
		historyOperations.addAll(oprts);
	}

	public List<Operation> getUnhandledOperations() {
		return unhandledOperations;
	}
	
	public void setHandled(){
		unhandledOperations.clear();
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

}
