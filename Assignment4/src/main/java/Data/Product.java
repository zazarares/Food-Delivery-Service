package Data;

public class Product extends MenuItem {
	public String Title;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public float getCalories() {
		return calories;
	}
	public void setCalories(float calories) {
		this.calories = calories;
	}
	public float getProtein() {
		return protein;
	}
	public void setProtein(float protein) {
		this.protein = protein;
	}
	public float getFat() {
		return fat;
	}
	public void setFat(float fat) {
		this.fat = fat;
	}
	public float getSodium() {
		return sodium;
	}
	public void setSodium(float sodium) {
		this.sodium = sodium;
	}
	public int timesOrdered;
	float rating;
	float calories;
	float protein;
	float fat;
	float sodium;
	float price;
	public Product(String Title,float rating,float calories,float protein,float fat,float sodium,float price)
	{
		timesOrdered=0;
		this.Title=Title;
		this.rating=rating;
		this.calories=calories;
		this.fat=fat;
		this.price=price;
		this.protein=protein;
		this.sodium=sodium;
	}
	public float ComputePrice() {
		return price;
	}
}
