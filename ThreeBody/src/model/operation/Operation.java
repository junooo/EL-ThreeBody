package model.operation;

import java.io.Serializable;

public abstract class Operation implements Visible,Serializable{
    
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	
//    public enum Type{
//        CARD_USE,
//        TECH_CHANGE,
//        RSR_CHANGE,
//        BROCAST,
//        LOSE,
//        CHARACTER_CHANGE,
//        COORDINATE_GET,
//		  COORDINATE_GET_FAIL
//        PRIVILEGE_USE,
//        TURN_CHANGE
//    }

    protected String operator;
    protected String receiver;
    
    public Operation(String operator,String receiver){
    	this.operator = operator;
    	this.receiver = receiver;
    }

}
