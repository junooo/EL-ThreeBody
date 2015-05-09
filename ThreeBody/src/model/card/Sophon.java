package model.card;

import model.Coordinate;
import model.Player;
import model.operation.CoordinateGet;
import model.operation.CoordinateGetFail;
import model.operation.ResourceChange;
import dto.GameDTO;

/**
 * 
 * @author Sissel
 * 高级智子
 */
public class Sophon extends Card{

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	
	private int number;

	/**
	 * 
	 * @param operator
	 * @param receiver
	 * @param number 想要获取的玩家的第几个坐标
	 */
	public Sophon(String operator, String receiver,int number) {
		super(operator, receiver);
		this.techPoint = 30;
		this.resource = 80;
		this.number = number;
	}

	@Override
	public void process() {
		GameDTO dto = GameDTO.getInstance();
		Player pOperator = null;
		Player pReceiver = null;
		//找到对应的玩家
		for (Player player : dto.getPlayers()) {
			if(player.getAccount().getId().equals(this.operator)){
				pOperator = player;
			}
			if(player.getAccount().getId().equals(this.receiver)){
				pReceiver = player;
			}
		}
		//消耗相应的资源，通过放置新Operation来实现
		ResourceChange rc = new ResourceChange(operator, receiver, ResourceChange.Type.DECREASE, this.resource);
		dto.depositOperation(rc);
		//执行获取坐标操作
		Coordinate coordinate = pReceiver.getCoordinate();
		int result = coordinate.getCoordinateElement(number);
		if(result == Coordinate.UNKNOWN){
			CoordinateGetFail cgf = new CoordinateGetFail(operator,receiver);
			dto.depositOperation(cgf);
		}else{
			// 设定operator的已发现的坐标值
			pOperator.getFoundCoordinates().get(pReceiver).setCoordinateElement(number, result);
			CoordinateGet cg = new CoordinateGet(operator,receiver,number,result);
			dto.depositOperation(cg);
		}
	}

}
