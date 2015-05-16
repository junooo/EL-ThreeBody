package model.card;

import java.util.List;

import config.CardConfig;
import config.GameConfig;
import model.operation.ResourceChange;
import model.operation.ResourceChange.Type;
import model.operation.TechChange;
import dto.GameDTO;

/*
 * 科技药水
 * 通过消耗资源来增长科技
 */
public class TechPotion extends Card{

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	public TechPotion(String operator, String receiver) {
		super(operator, receiver);
		
		GameConfig gc = new GameConfig();
		List<CardConfig> cardList=gc.getCardsConfig();
		this.lifetime=cardList.get(5).getLifetime();
		this.requiredResource=cardList.get(5).getRequiredResource();
		this.requiredTechPoint=cardList.get(5).getRequiredTechPoint();
	}

	@Override
	public void process() {
		GameDTO dto=GameDTO.getInstance();
	
		//pay  resources
		ResourceChange rc=new ResourceChange(operator, receiver, Type.DECREASE, this.requiredResource);
		dto.depositOperation(rc);
		//get techPoint
		TechChange tc=new TechChange(operator, receiver, TechChange.Type.INCREASE, this.requiredTechPoint);
		dto.depositOperation(tc);
		

	}
	
}
