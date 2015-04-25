package dto;

import util.R;
import ai.AI;

public class Preference {
    
    /*
     * 用户设置,aiLevel,language,resolution数值含义参考R类
     */
    private boolean musicSwitch;
    private boolean effectSwitch;
    private AI.level aiLevel;
    private R.language language;
    private R.resolution resolution;
    private int volume;

}
