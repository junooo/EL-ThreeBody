package model.card;

import java.io.Serializable;
import model.Player;
import dto.GameDTO;

public abstract class Card implements Serializable{
    
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	
	protected String name;
	protected int requiredResource;
    protected int requiredTechPoint;
    protected int lifetime;
       
    //ID
    protected String operator;
    protected String receiver;
    
    public Card(String operator,String receiver){
    	this.operator = operator;
    	this.receiver = receiver;

    }
    
    
    
    
    public abstract void process();
    
    public String getName() {
		return name;
	}

	public int getResource() {
		return requiredResource;
	}

	public int getTechPoint() {
		return requiredTechPoint;
	}
	
	
	public int getLifetime() {
		return lifetime;
	}

	
	
	/*
	 * 建议可以在父类加些通用的代码,比如消耗资源部分的代码，根据String找到相应Player的代码
	 */
	
	
	public Player findOperator(GameDTO dto){
		
		Player pOperator=null;
		for(Player player:dto.getPlayers()){
			if(player.getAccount().getId().equals(this.operator)){
				pOperator=player;
			}

		}
		return pOperator;
	}
	
	public Player findReceiver(GameDTO dto){
		
		Player pReceiver=null;
		for(Player player:dto.getPlayers()){
			if(player.getAccount().getId().equals(this.receiver)){
				pReceiver=player;
			}

		}
		return pReceiver;
	}
	

}
