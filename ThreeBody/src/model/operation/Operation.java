package model.operation;

import java.io.Serializable;

import model.Player;

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
//        PRIVILEGE_USE,
//        TURN_CHANGE
//    }

    private Player operator;
    private Player receiver;
    private String extra;

}
