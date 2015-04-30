package model;

import java.util.Map;

public class Player {
    /*
     * 关联的账户
     */
    private Account account;
    private Character character;
    private Coordinate coordinate;
    /*
     * 是否已使用特权
     */
    private boolean privilegeUsed;
    /*
     * 是否是AI
     */
    private boolean AI;
    /*
     * 是否已经败北
     */
    private boolean lost;
    /*
     * 已经获知的其他玩家的坐标
     */
    private Map<Player,Coordinate> foundCoordinates;
    /*
     * 已经获知的其他玩家的身份
     */
    private Map<Player,Character> foundCharacters;
    /*
     * 资源，科技点
     */
    private int resource;
    private int techPoint;
    
    /*
     * getters and setters
     */
    public int getResource() {
		return resource;
	}
	public int getTechPoint() {
		return techPoint;
	}
	public void setResource(int resource) {
		this.resource = resource;
	}
	public void setTechPoint(int techPoint) {
		this.techPoint = techPoint;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Character getCharacter() {
		return character;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public boolean isPrivilegeUsed() {
		return privilegeUsed;
	}
	public boolean isAI() {
		return AI;
	}
	public boolean isLost() {
		return lost;
	}
	public Map<Player, Coordinate> getFoundCoordinates() {
		return foundCoordinates;
	}
	public Map<Player, Character> getFoundCharacters() {
		return foundCharacters;
	}
}
