package model.card;

import java.io.Serializable;
import java.util.List;

import model.Player;
import model.operation.Operation;
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
   
    public abstract List<Operation> process(List<Operation> subOperations);
    
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
	
	protected Player findOperator(GameDTO dto){
		return dto.findPlayerByID(operator);
	}
	
	protected Player findReceiver(GameDTO dto){
		return dto.findPlayerByID(receiver);
	}
	
}
