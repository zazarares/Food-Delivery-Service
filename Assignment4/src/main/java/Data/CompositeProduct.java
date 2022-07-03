package Data;

import java.util.ArrayList;
import java.util.HashMap;

public class CompositeProduct extends MenuItem{
	HashMap<Integer,MenuItem> A;
	String Title;
	public int timesOrdered=0;
	float rating;
	float calories;
	float protein;
	float fat;
	float sodium;
	float price;
	public CompositeProduct(String Title,HashMap<Integer,MenuItem> A) {
		this.A=A;
		this.Title=Title;
	}
	public float ComputePrice()
	{
		float toReturn=0;
		for(int i=0;i<A.size();i++)
			toReturn=toReturn+A.get(i).ComputePrice();
		return toReturn;
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return Title;
	}
	@Override
	public float getRating() {
		// TODO Auto-generated method stub
		float toReturn=0;
		for(int i=0;i<A.size();i++)
			toReturn=toReturn+A.get(i).getRating();
		return toReturn;
	}
	@Override
	public float getCalories() {
		// TODO Auto-generated method stub
		float toReturn=0;
		for(int i=0;i<A.size();i++)
			toReturn=toReturn+A.get(i).getCalories();
		return toReturn;
	}
	@Override
	public float getProtein() {
		// TODO Auto-generated method stub
		float toReturn=0;
		for(int i=0;i<A.size();i++)
			toReturn=toReturn+A.get(i).getProtein();
		return toReturn;
	}
	@Override
	public float getFat() {
		// TODO Auto-generated method stub
		float toReturn=0;
		for(int i=0;i<A.size();i++)
			toReturn=toReturn+A.get(i).getFat();
		return toReturn;
	}
	@Override
	public float getSodium() {
		// TODO Auto-generated method stub
		float toReturn=0;
		for(int i=0;i<A.size();i++)
			toReturn=toReturn+A.get(i).getSodium();
		return toReturn;
	}
}
