package Functional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class UserUnloader {
	public static void UnloadUser(String type,String Username,String Password) throws IOException {
	      File myObj = new File(type+".txt");
	      FileWriter myWriter;
	      try {
	      myWriter = new FileWriter(myObj,true);
	      myWriter.write(Username);
	      myWriter.write("\n");
	      myWriter.write(Password);
	      myWriter.write("\n");
	      myWriter.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
}
	}
