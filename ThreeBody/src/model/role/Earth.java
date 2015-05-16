package model.role;

import model.card.Card;


/*
 * 角色：地球
 * 目标：获得三体以及归一者的坐标，广播出去，使其消灭
 * 科技值：初始值最低       增长值最快
 * 资源：初始值中 	增长值中
 * 技能限制：无限制
 * 广播：可以获取坐标，可以发送（玩家点击确认发送）
 * 
 */

public class Earth extends Role{
	
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	public Earth() {
		super();
		// 原60，10，测试用改成100，100
		this.initialResource=100;
		this.initialTechPoint=100;
		this.tchDevelopSpeed=20;
		this.rsrRestoreSpeed=30;
	}
	
	@Override
	public boolean isAvailable(Card card) {
		return true;
	}

}




	