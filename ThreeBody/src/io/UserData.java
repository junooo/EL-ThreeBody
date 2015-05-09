package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Account;
import dto.PreferenceDTO;
/**
 * 
 * 负责存读账户缓存，数据缓存（战报等），Preference
 *
 */
public class UserData {
    
    Account account;
    PreferenceDTO preferenceDto;
  
    public void readFile() throws IOException, IOException, ClassNotFoundException {
    	//create file
	  File file=new File("UserData");
	   if(!file.exists()){
		   try {
			   file.createNewFile();
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
	   }
	   //form file to PreferenceDTO
	   FileInputStream fis=new FileInputStream(new File("PreferenceDTO"));	   
	   ObjectInputStream ois=new ObjectInputStream(fis);
	   preferenceDto=(PreferenceDTO)ois.readObject();   
	   ois.close();
	   
   }
   
   public void saveFile() throws IOException{
	   //from PreferenceDTO to file
	   ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("PreferenceDTO")));
	   oos.writeObject(preferenceDto);
	   oos.flush();
	   oos.close();
   }
}
