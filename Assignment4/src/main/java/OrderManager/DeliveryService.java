package OrderManager;

import java.awt.Component;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JTable;

import Data.MenuItem;
import Data.Pair;
import Functional.CSVImporter;
import Functional.HashMapProcessor;
import Functional.Serialization;

public class DeliveryService implements DeliveryServiceProcessing{
	static HashMap<Order,HashMap<Integer,Data.MenuItem>> T=new HashMap<Order,HashMap<Integer,Data.MenuItem>>();
	static HashMap<Order,HashMap<Integer,Data.MenuItem>> TCopy=new HashMap<Order,HashMap<Integer,Data.MenuItem>>();

	static HashMap<Integer,MenuItem> Products;
	static int index=0;
	public static void LoadOrder() throws ClassNotFoundException, IOException
	{
		T=Serialization.serializeRead();
		//Set<Order>o=T.keySet();
		//for(Order j:o)
		//System.out.println(T.get(j).get(0).getTitle());
		index=T.size();
	}
	public static void WriteOrder() throws ClassNotFoundException, IOException
	{
		Serialization.serializeWrite(T);
	}
	public static void WriteProduct() throws ClassNotFoundException, IOException
	{
		Serialization.serializeWriteProduct(CSVImporter.H);
	}
	public static void LoadProduct() throws ClassNotFoundException, IOException
	{
		Products=Serialization.serializeReadProduct();
		CSVImporter.H=Products;
	}
	public static HashMap<Integer,MenuItem> Filter(int mincalories,int maxcalories,int minprotein,int maxprotein,int minfat,int maxfat,int minsodium,int maxsodium,int minrating,int maxrating,int minprice,int maxprice) {
		@SuppressWarnings("unchecked")
		HashMap<Integer,MenuItem>fMenuItems=(HashMap<Integer,MenuItem>)CSVImporter.H
				.entrySet()
				.stream()
				.filter(c->c.getValue().getCalories()>= mincalories && c.getValue().getCalories()<=maxcalories)
				.filter(c->c.getValue().getProtein()>= minprotein && c.getValue().getProtein()<=maxprotein)
				.filter(c->c.getValue().getFat()>= minfat && c.getValue().getFat()<=maxfat)
				.filter(c->c.getValue().getSodium()>= minsodium && c.getValue().getSodium()<=maxsodium)
				.filter(c->c.getValue().getRating()>= minrating && c.getValue().getRating()<=maxrating)
				.filter(c->c.getValue().ComputePrice()>= minprice && c.getValue().ComputePrice()<=maxprice)
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		return fMenuItems;
		
	}
	public static JTable GenerateRaportno1(int starttime,int endtime) {
		List<Order>fMenuItems= (ArrayList<Order>) T
				.keySet()
				.stream()
				.filter(c->c.Time.getHour()>=starttime && c.Time.getHour()<=endtime)
				.collect(Collectors.toList());
		ArrayList<Order> toReturn=new ArrayList<Order>(fMenuItems);
		String Title[]= {"Client","Id","Time"};
		String Data[][]=new String[1000][3];
		for(int i=0;i<toReturn.size();i++)
		{
			Data[i][0]=toReturn.get(i).ClientId.user;
			Data[i][1]=Integer.toString(toReturn.get(i).id);
			Data[i][2]=toReturn.get(i).Time.toString();
		}
		return new JTable(Data,Title);
	}
	public static JTable GenerateRaportno2(int count) {
		HashMap<Integer,MenuItem>fMenuItems=(HashMap<Integer,MenuItem>)CSVImporter.H
				.entrySet()
				.stream()	
				.filter(c->c.getValue().timesOrdered>=count)
				.collect(Collectors.toMap(map->map.getKey(),map->map.getValue()));
		String Title[]= {"Title","Rating","Calories","Protein","Fat","Sodium","Price"};
		String Data[][]=HashMapProcessor.ProcessHashMapBrute(fMenuItems);
		return new JTable(Data,Title);
	}
	public static JTable GenerateRaportno3(int count,int price) {
		List<Order>fMenuItems= (ArrayList<Order>) T
				.keySet()
				.stream()
				.filter(c->c.Price>=price && c.ClientId.orders>=count)
				.collect(Collectors.toList());
		ArrayList<Order> toReturn=new ArrayList<Order>(fMenuItems);
		String Title[]= {"Client","Id","Time","Price"};
		String Data[][]=new String[1000][4];
		for(int i=0;i<toReturn.size();i++)
		{
			Data[i][0]=toReturn.get(i).ClientId.user;
			Data[i][1]=Integer.toString(toReturn.get(i).id);
			Data[i][2]=toReturn.get(i).Time.toString();
			Data[i][3]=Float.toString(toReturn.get(i).Price);
		}
		return new JTable(Data,Title);
	}
	public static JTable GenerateRaportno4(LocalDateTime L) {
		System.out.println("debug");
		List<Order>fMenuItems= (List<Order>) T
				.keySet()
				.stream()
				.filter(c->c.Time.getDayOfYear()==L.getDayOfYear())
				.collect(Collectors.toList());
		ArrayList<Order> toReturn=new ArrayList<Order>(fMenuItems);

		String Title[]= {"Client","Id","Time","Times ordered"};
		String Data[][]=new String[1000][4];
		int index=0;
		for(int i=0;i<toReturn.size();i++)
		{
				for(int j=0;j<T.get(toReturn.get(i)).size();j++)
					{
					Data[index][0]=toReturn.get(i).ClientId.user;
					Data[index][1]=Integer.toString(toReturn.get(i).id);
					Data[index][2]=toReturn.get(i).Time.toString();
					Data[index][3]=Integer.toString(T.get(toReturn.get(i)).get(j).timesOrdered);index++;
					}

		}
		return new JTable(Data,Title);
	}
	public static HashMap<Integer,MenuItem> FilterText(String Name,HashMap<Integer,MenuItem>Entry){
		@SuppressWarnings("unchecked")
		HashMap<Integer,MenuItem>fMenuItems=(HashMap<Integer,MenuItem>)Entry
				.entrySet()
				.stream()
				.filter(c->c.getValue().getTitle().contains(Name))
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		return fMenuItems;
		
	}
	public static void ProcessOrder(HashMap<Integer,MenuItem> O,Pair client) throws ClassNotFoundException, IOException {
		Order temp=new Order(index,client,LocalDateTime.now());
		HashMap<Integer,MenuItem> OCopy=new HashMap<Integer,MenuItem>(O);
		T.put(temp, OCopy);
		for(int i=0;i<T.get(temp).size();i++)
			{
			T.get(temp).get(i).timesOrdered++;
			temp.Price+=T.get(temp).get(i).ComputePrice();
			}
		client.orders++;
		index++;
		TCopy=T;
	}
}
