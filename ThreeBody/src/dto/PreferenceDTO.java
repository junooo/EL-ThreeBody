package dto;

import util.R;
import ai.AI;

public class PreferenceDTO {
    
    /*
     * 用户设置,aiLevel,language,resolution数值含义参考R类
     */
    private boolean musicSwitch;
    private boolean effectSwitch;
    private AI.level aiLevel;
    private R.language language;
    /*
     * 分辨率
     */
    private R.resolution resolution;
    /*
     * 音量
     */
    private int volume;
    
	public boolean isMusicSwitch() {
		return musicSwitch;
	}
	public void setMusicSwitch(boolean musicSwitch) {
		this.musicSwitch = musicSwitch;
	}
	public boolean isEffectSwitch() {
		return effectSwitch;
	}
	public void setEffectSwitch(boolean effectSwitch) {
		this.effectSwitch = effectSwitch;
	}
	public AI.level getAiLevel() {
		return aiLevel;
	}
	public void setAiLevel(AI.level aiLevel) {
		this.aiLevel = aiLevel;
	}
	public R.language getLanguage() {
		return language;
	}
	public void setLanguage(R.language language) {
		this.language = language;
	}
	public R.resolution getResolution() {
		return resolution;
	}
	public void setResolution(R.resolution resolution) {
		this.resolution = resolution;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
    
    

}
