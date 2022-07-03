package Data;

import java.io.Serializable;

public abstract class MenuItem  implements Serializable{
	public abstract float ComputePrice();
	float rating;
	float calories;
	float protein;
	float fat;
	float sodium;
	float price;
	public int timesOrdered;
	public abstract String getTitle();

	public abstract float getRating();

	public abstract float getCalories();

	public abstract float getProtein();

	public abstract float getFat();

	public abstract float getSodium();


}
