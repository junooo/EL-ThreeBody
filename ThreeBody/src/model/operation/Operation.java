package model.operation;

import model.Player;

public abstract class Operation implements Visible{
    
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
//    private Type type;
    private String extra;

}
