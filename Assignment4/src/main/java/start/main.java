package start;

import java.io.IOException;

import Functional.CSVImporter;
import Functional.Serialization;
import Functional.UserLoader;
import OrderManager.DeliveryService;
import Presentation.GUI;
public class main {
	public static void main(String args[]) throws IllegalArgumentException, IllegalAccessException, IOException, ClassNotFoundException {
	//Serialization.serialize();
	GUI G=new GUI();
DeliveryService.LoadOrder();
DeliveryService.LoadProduct();
}
}
