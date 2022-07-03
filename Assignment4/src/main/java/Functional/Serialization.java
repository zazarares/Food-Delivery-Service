package Functional;
import Data.Pair;
import OrderManager.Order;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Serialization {
	static File f=new File("Serialize.txt");
	static File P=new File("Product.txt");
	static File Ua=new File("admin.txt");
	static File Uc=new File("client.txt");
	public static void serializeWrite(HashMap<Order,HashMap<Integer,Data.MenuItem>> T) throws IOException, ClassNotFoundException
	{
		FileOutputStream fout=new FileOutputStream(f);
		ObjectOutputStream oout=new ObjectOutputStream(fout);
		oout.writeObject(T);
		fout.close();
		oout.close();

	}
	public static HashMap<Order,HashMap<Integer,Data.MenuItem>> serializeRead() throws IOException, ClassNotFoundException
	{
		FileInputStream fin=new FileInputStream(f);
		ObjectInputStream oin=new ObjectInputStream(fin);
		HashMap<Order,HashMap<Integer,Data.MenuItem>> obj1=(HashMap<Order,HashMap<Integer,Data.MenuItem>>)oin.readObject();
		oin.close();
		fin.close();
		return obj1;
	}
	public static void serializeWriteProduct(HashMap<Integer,Data.MenuItem> T) throws IOException, ClassNotFoundException
	{
		FileOutputStream fout=new FileOutputStream(P);
		ObjectOutputStream oout=new ObjectOutputStream(fout);
		oout.writeObject(T);
		fout.close();
		oout.close();

	}
	public static HashMap<Integer,Data.MenuItem> serializeReadProduct() throws IOException, ClassNotFoundException
	{
		FileInputStream fin=new FileInputStream(P);
		ObjectInputStream oin=new ObjectInputStream(fin);
		HashMap<Integer,Data.MenuItem> obj1=(HashMap<Integer,Data.MenuItem>)oin.readObject();
		oin.close();
		fin.close();
		return obj1;
	}
	public static ArrayList<Pair> ReadUser(String type) throws ClassNotFoundException, IOException
	{
		ArrayList<Pair> toReturn;
		if(type.equals("admin")) {
		FileInputStream fin=new FileInputStream(Ua);
		ObjectInputStream oin=new ObjectInputStream(fin);
		toReturn=(ArrayList<Pair>)oin.readObject();
		}
		else
		{
			FileInputStream fin=new FileInputStream(Uc);
			ObjectInputStream oin=new ObjectInputStream(fin);
			toReturn=(ArrayList<Pair>)oin.readObject();
		}
		return toReturn;
	}
	public static void writeUsers(ArrayList<Pair> U,String type) throws IOException
	{
		if(type.equals("admin")) {
			FileOutputStream fin=new FileOutputStream(Ua);
			ObjectOutputStream oin=new ObjectOutputStream(fin);
			oin.writeObject(U);
			fin.close();
			oin.close();
			}
			else
			{
				FileOutputStream fin=new FileOutputStream(Uc);
				ObjectOutputStream oin=new ObjectOutputStream(fin);
				oin.writeObject(U);
				fin.close();
				oin.close();
			}
		
	}
	
}
