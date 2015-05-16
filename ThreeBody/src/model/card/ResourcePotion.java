package model.card;

import java.util.List;

import config.CardConfig;
import config.GameConfig;
import ui.game.GamblePanel;
import model.operation.ResourceChange;
import model.operation.TechChange;
import dto.GameDTO;



/*
 *资源药水 
 *通过消耗科技来增长资源
 */
public class ResourcePotion extends Card {

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	public ResourcePotion(String operator, String receiver) {
		super(operator, receiver);
		
		GameConfig gc=new GameConfig();
		List<CardConfig> cardList=gc.getCardsConfig();
		this.lifetime=cardList.get(2).getLifetime();
		this.requiredResource=cardList.get(2).getRequiredResource();
		this.requiredTechPoint=cardList.get(2).getRequiredTechPoint();
	}

	@Override
	public void process() {
		GameDTO dto=GameDTO.getInstance();
		
		//pay techPoint
		TechChange tc=new TechChange(operator, receiver, TechChange.Type.DECREASE, this.requiredTechPoint);
		dto.depositOperation(tc);
		//get resources
		ResourceChange rc=new ResourceChange(operator, receiver, ResourceChange.Type.INCREASE, this.requiredResource);
		dto.depositOperation(rc);
		
	}
	
	
}
