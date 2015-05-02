package model.character;

import model.card.Card;

/*
 * 角色：三体
 * 目标： 获得地球的坐标，侵占地球，侵占后坐标仍是原来的坐标，但是其他属性会变为地球类，
 *		      此时的敌对方为其他的三体以及归一者
 * 科技值：初始值：中（高于地球，低于三体） 增长率：较慢
 * 资源值：初始值：最少	增长率：与地球归一者相同
 * 技能限制：无限制
 * 广播：只能获得坐标，可以发送（结果是侵占，玩家点击确认发送）
 * 
 */
public class ThreeBody extends Character{

	@Override
	public void addTechPoint() {
		this.setTechPoint(getTechPoint()+10);
	}

	@Override
	public void addResource() {
		this.setResource(getResource()+10);
	}

	@Override
	public boolean isAvailable(Card card) {
		// TODO Auto-generated method stub
		return false;
	}

}
