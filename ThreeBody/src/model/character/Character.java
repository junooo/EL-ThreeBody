package model.character;

import model.card.Card;

public abstract class Character {
    
    protected int initialTechPoint;
    protected int initialResource;
    protected int tchDevelopSpeed;
    protected int rsrRestoreSpeed;
    
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
    public int getTchDevelopSpeed() {
		return tchDevelopSpeed;
	}
	public int getRsrRestoreSpeed() {
		return rsrRestoreSpeed;
	}

	public String getName(){
    	return this.getClass().getName();
    }

	@Override
	public boolean equals(Object arg0) {
		return this.getName().equals(arg0.getClass().getName());
	}
    
}
