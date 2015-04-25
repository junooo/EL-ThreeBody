package model;

public class Operation {
    
    public enum Type{
        CARD_USE,
        TECH_CHANGE,
        RSR_CHANGE,
        BROCAST,
        LOSE,
        CHARACTER_CHANGE,
        COORDINATE_GET,
        PRIVILEGE_USE,
        TURN_CHANGE
    }

    private Player from;
    private Player to;
    private Type type;
    private String extra;
    private boolean operable;

}
