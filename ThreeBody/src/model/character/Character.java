package model.character;

import model.card.Card;

public abstract class Character {
    
    private int initialTechPoint;
    private int initialResource;
    
    /*
     * 增加科技和资源的速度
     */
    public abstract int addTechPoint(int nowTechPoint);
    public abstract int addResource(int nowResource);
    
    /*
     * 判断这张牌是否能被Character所用
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
