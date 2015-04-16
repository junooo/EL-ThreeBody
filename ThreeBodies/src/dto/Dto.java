package dto;

import java.util.List;

import model.User;
import ui.BGM;

public class Dto {
    
    private List<Character> characters;
    private int whoseTurn;
    private int volume;
    private BGM bgm;
    /*
     * TODO 服务器端要改成User数组
     */
    private User user;

}
