package model.card;

import java.io.Serializable;

public abstract class Card implements Serializable{
    
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	
	protected String name;
	protected int resource;
    protected int techPoint;
    protected String operator;
    protected String receiver;
    
    public Card(String operator,String receiver){
    	this.operator = operator;
    	this.receiver = receiver;
    }
    
    public abstract void process();
    
<<<<<<< Updated upstream
    public String getName() {
		return name;
	}

	public int getResource() {
		return resource;
	}

	public int getTechPoint() {
		return techPoint;
	}
=======

>>>>>>> Stashed changes
}
