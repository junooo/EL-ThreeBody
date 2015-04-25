package model.character;

import model.card.Card;

public abstract class Character {
    
    private int techPoint;
    private int resource;
    
    /*
     * 每回合数值增加时调用 
     */
    public abstract void addTechPoint();
    public abstract void addResource();
    
    /*
     * 判断某个技能是否可用 
     */
    public abstract boolean isAvailable(Card card);
    
    /*
     * getters and setters
     */
    public int getTechPoint() {
        return techPoint;
    }
    public void setTechPoint(int techPoint) {
        this.techPoint = techPoint;
    }
    public int getResource() {
        return resource;
    }
    public void setResource(int resource) {
        this.resource = resource;
    }
    
}
