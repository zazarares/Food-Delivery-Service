package Functional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import Data.MenuItem;
import Data.Product;

public class CSVImporter {
public static HashMap<Integer,MenuItem> H=new HashMap<Integer,MenuItem>();
public static String[] Title= {"Default Title","Default rating","Default calories","Default protein","Default fat","Default sodium","Default price"};

public static HashMap<Integer,MenuItem> ImportCSV(File f) throws IOException
{
	H.clear();
	FileReader sc=new FileReader(f);
	BufferedReader br=new BufferedReader(sc);
	//sc.useDelimiter(",|\\n");
	int index=0;
	String initialstring;
	initialstring=br.readLine();
	String[] Split1=initialstring.split(",",-1);
	Title=Split1;
	while((initialstring=br.readLine())!=null)
	{
	String[] Split=initialstring.split(",",-1);
	String s=Split[0];
	float f1=Float.parseFloat(Split[1]);
	float f2=Float.parseFloat(Split[2]);
	float f3=Float.parseFloat(Split[3]);
	float f4=Float.parseFloat(Split[4]);
	float f5=Float.parseFloat(Split[5]);
	String f6=Split[6];
	f6=f6.replaceAll("\\r", "");
	Product M=new Product(s,f1,f2,f3,f4,f5,Float.parseFloat(f6));
	H.put(index, M);
	//System.out.println(H.get(index).Title);
	index++;
	}
	//for(int i=0;i<index;i++)
		//System.out.println(H.get(i).Title);
	sc.close();
	return H;
}
}
