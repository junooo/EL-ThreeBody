package model.card;

import java.util.List;

import model.operation.Operation;
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
;
	}

	@Override
	public List<Operation> process(List<Operation> subOperations) {
		
		//pay techPoint
		TechChange tc=new TechChange(operator, receiver, TechChange.Type.DECREASE, this.requiredTechPoint);
		subOperations.add(tc);
		
		//get resources
		ResourceChange rc=new ResourceChange(operator, receiver, ResourceChange.Type.INCREASE, this.requiredResource);
		subOperations.add(rc);
		
		return subOperations;
	}
	
}
