package util;

import java.io.Serializable;

public final class R {
    
    public static enum resolution{
        FULL_SCREEN,
        NORMAL
    }
    
    public static enum language{
        SIMPLIFIED_CHINESE,
        STANDALIZED_CHINESE
    }
    
    public static enum info implements Serializable{
    	SUCCESS,
    	ALREADY_EXISTED,
    	ALREADY_IN,
    	NOT_EXISTED,
    	INVALID,
    	ROOM_FULL
    }
    
    public static enum img_format implements Serializable{
    	PNG,
    	JPG
    }
    
    public static enum img_type implements Serializable{
    	HEAD,
    	ADVERTISEMENT,
    }
    
}
