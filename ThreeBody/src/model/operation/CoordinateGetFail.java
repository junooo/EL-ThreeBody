package model.operation;

public class CoordinateGetFail extends Operation{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CoordinateGetFail(String operator, String receiver) {
		super(operator, receiver);
	}


	@Override
	public String toOperator() {
		return "坐标获取失败";
	}

	@Override
	public String toReceiver() {
		return null;
	}

	@Override
	public String toOthers() {
		return null;
	}

}
