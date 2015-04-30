package io;

import java.io.*;
import java.util.ArrayList;

import dto.PreferenceDTO;
import model.Account;
/**
 * 
 * ���������������˺Ż��棬���ϲ�����ã����ݻ���
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
