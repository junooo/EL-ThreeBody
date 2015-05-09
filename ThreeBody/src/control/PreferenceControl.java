package control;

import io.UserData;

import java.io.IOException;

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
