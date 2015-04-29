package control;

import java.io.IOException;
import java.util.ArrayList;

import io.UserData;

/*
 * Preference
 */
public class PreferenceControl {
    
	UserData userData=new UserData();
	
	
    public void savePreference() throws IOException{
 		userData.saveFile();
    }
    
    public void loadPreference() throws ClassNotFoundException, IOException{
        userData.readFile();
    }

}
