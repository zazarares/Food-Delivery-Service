package Functional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserLoader {
	public static String[][] LoadUser(String type) {
	String toReturn[][]= new String[2][100];
	 try {
		  String users[]=new String[100];
		  String passwords[]=new String[100];

	      File myObj = new File(type+".txt");
	      Scanner myReader = new Scanner(myObj);
	      int i=0;
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        if(i%2==0)
	        	users[i/2]=data;
	        else
	        	passwords[i/2]=data;
	    	i++;
	      }
	      toReturn[0]=users;
	      toReturn[1]=passwords;
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
     return toReturn;

}
	}
