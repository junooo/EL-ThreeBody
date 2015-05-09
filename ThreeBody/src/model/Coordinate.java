package model;

public class Coordinate {
    
    public static final int UNKNOWN = 998;
    public static final int PROTECTED = 10086;
    
    private int[] sequence;
    private boolean[] isProtected;
    
    /**
     * 
     * @param position 坐标的第几个
     * @return 如果没有被保护，返回正常的坐标，否则返回PROTECTED
     */
    public int getCoordinateElement(int position){
    	if(isProtected[position]){
    		return PROTECTED;
    	}
    	return sequence[position];
    }
    
    public void setCoordinateElement(int position,int value){
    	sequence[position] = value;
    }
    
}
