package Functional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import Data.MenuItem;
import Data.Product;

public class HashMapProcessor {
	public static String[][] ProcessHashMap(HashMap<Integer,MenuItem>H)
	{
		String S[][] = new String[H.size()][7];
		int index=0;
		for(int i=0;i<H.size();i++)
		{
			if(H.get(i)!=null) {
			S[index][0]=H.get(i).getTitle();
			S[index][1]=Float.toString(H.get(i).getRating());
			S[index][2]=Float.toString(H.get(i).getCalories());
			S[index][3]=Float.toString(H.get(i).getProtein());
			S[index][4]=Float.toString(H.get(i).getFat());
			S[index][5]=Float.toString(H.get(i).getSodium());
			S[index][6]=Float.toString(H.get(i).ComputePrice());index++;}
		}
		return S;
	}
	public static String[][] ProcessHashMapBrute(HashMap<Integer,MenuItem>H)
	{
		String S[][] = new String[H.size()][7];
		int index=0;
		for (Entry<Integer, MenuItem> e : H.entrySet())
		{
			 {
			S[index][0]=e.getValue().getTitle();
			S[index][1]=Float.toString(e.getValue().getRating());
			S[index][2]=Float.toString(e.getValue().getCalories());
			S[index][3]=Float.toString(e.getValue().getProtein());
			S[index][4]=Float.toString(e.getValue().getFat());
			S[index][5]=Float.toString(e.getValue().getSodium());
			S[index][6]=Float.toString(e.getValue().ComputePrice());index++;}
		}
		return S;
	}
	
}
