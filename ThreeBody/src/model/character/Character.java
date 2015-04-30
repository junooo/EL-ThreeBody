package model.character;

import model.card.Card;

public abstract class Character {
    
    private int initialTechPoint;
    private int initialResource;
    
    /*
     * 每回合数值增加时调用 
     */
    public abstract int addTechPoint(int nowTechPoint);
    public abstract int addResource(int nowResource);
    
    /*
     * 判断某个技能是否可用 
     */
    public abstract boolean isAvailable(Card card);
    
    /*
     * getters
     */
    public int getInitialTechPoint() {
        return this.initialTechPoint;
    }
    public int getInitialResource() {
        return this.initialResource;
    }
}
