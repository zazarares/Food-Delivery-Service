package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.awt.*;

import Data.Pair;
import Data.Product;
import Functional.CSVImporter;
import Functional.HashMapProcessor;
import OrderManager.DeliveryService;

import javax.swing.*;
public class ClientView extends JFrame implements ActionListener{
	JFrame Frame=new JFrame("Client View");
	JFrame F;
	Pair Client;
	String[] Title= {"COL1"};
	static int first=0;
	String[][] data= {{"data"}};
	JTable J;
	int i=0;
	JTable T;
	JScrollPane P=new JScrollPane();
	JScrollPane S=new JScrollPane();
	HashMap<Integer, Data.MenuItem> H=CSVImporter.H;
	HashMap<Integer,Data.MenuItem> Order=new HashMap<Integer,Data.MenuItem>();
	JPanel SearchView=new JPanel();
	JButton Done=new JButton("Logout");
	JButton Add=new JButton("Add");
	JButton FinishOrder=new JButton("Order");
	JPanel TablePanel=new JPanel();
	JPanel DoneView=new JPanel();
	JButton Search=new JButton("Search");
	JLabel Calories=new JLabel("Calories:");
	JLabel Proteins=new JLabel("Proteins:");
	JLabel Fats=new JLabel("Fats:");
	JLabel Sodium=new JLabel("Sodium:");
	JLabel Price=new JLabel("Price:");
	JLabel Rating=new JLabel("Rating:");

	JTextField MinCalories=new JTextField();
	JTextField MaxCalories=new JTextField();
	JTextField MinProteins=new JTextField();
	JTextField MaxProteins=new JTextField();
	JTextField MinFats=new JTextField();
	JTextField MaxFats=new JTextField();
	JTextField MinSodium=new JTextField();
	JTextField MaxSodium=new JTextField();
	JTextField MinPrice=new JTextField();
	JTextField MaxPrice=new JTextField();
	JTextField MinRating=new JTextField();
	JTextField MaxRating=new JTextField();
	JTextField SearchBar=new JTextField();
	
	public ClientView() {	
	Frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	DoneView.add(Done);
	DoneView.add(Add);
	DoneView.add(FinishOrder);
	SearchView.add(Search);
	SearchView.add(Calories);
	MinCalories.setPreferredSize(new Dimension(50,30));
	SearchView.add(MinCalories);
	MaxCalories.setPreferredSize(new Dimension(50,30));
	SearchView.add(MaxCalories);
	SearchView.add(Proteins);
	MinProteins.setPreferredSize(new Dimension(50,30));
	SearchView.add(MinProteins);
	MaxProteins.setPreferredSize(new Dimension(50,30));
	SearchView.add(MaxProteins);
	SearchView.add(Fats);
	MinFats.setPreferredSize(new Dimension(50,30));
	SearchView.add(MinFats);
	MaxFats.setPreferredSize(new Dimension(50,30));
	SearchView.add(MaxFats);
	SearchView.add(Sodium);
	MinSodium.setPreferredSize(new Dimension(50,30));
	SearchView.add(MinSodium);
	MaxSodium.setPreferredSize(new Dimension(50,30));
	SearchView.add(MaxSodium);
	SearchView.add(Price);
	MinPrice.setPreferredSize(new Dimension(50,30));
	SearchView.add(MinPrice);
	MaxPrice.setPreferredSize(new Dimension(50,30));
	SearchView.add(MaxPrice);
	SearchView.add(Rating);
	MinRating.setPreferredSize(new Dimension(50,30));
	SearchView.add(MinRating);
	MaxRating.setPreferredSize(new Dimension(50,30));
	SearchView.add(MaxRating);
	SearchBar.setPreferredSize(new Dimension(100,30));
	SearchView.add(SearchBar);
	Frame.setSize(1200,800);
	Done.addActionListener(this);
	Add.addActionListener(this);
	FinishOrder.addActionListener(this);
	Search.addActionListener(this);
	TablePanel.add(S);
	TablePanel.add(P);
	Frame.add(BorderLayout.SOUTH,DoneView);
	Frame.add(BorderLayout.CENTER,SearchView);
	Frame.add(BorderLayout.NORTH,TablePanel);
	}
	public void SetVisible(boolean t,JFrame F,Pair Client) {
		F.setVisible(!t);
		this.F=F;
		Title=CSVImporter.Title;
		data=HashMapProcessor.ProcessHashMap(H);
		J=new JTable(data,Title);
		T=new JTable();
		if(CSVImporter.H!=null)
		{
			J=new JTable(HashMapProcessor.ProcessHashMap(CSVImporter.H),CSVImporter.Title);
		}
		P.getViewport().add(T);
		S.getViewport().add(J);
		//S=new JScrollPane(J);
		//TablePanel.add(S);
		Frame.setVisible(t);
		this.Client=Client;

}
	public void SetOnlyVisible(boolean t) {
		Title=CSVImporter.Title;
		data=HashMapProcessor.ProcessHashMap(H);
		Frame.setVisible(t);

}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Done)
		{
			this.SetVisible(false,F,Client);
			//TablePanel.remove(S);

		}	
		if(e.getSource()==Add)
		{
			Order.put(i,new Product(J.getValueAt(J.getSelectedRow(), 0).toString(),Float.parseFloat(J.getValueAt(J.getSelectedRow(), 1).toString()),Float.parseFloat(J.getValueAt(J.getSelectedRow(), 2).toString()),Float.parseFloat(J.getValueAt(J.getSelectedRow(), 3).toString()),Float.parseFloat(J.getValueAt(J.getSelectedRow(), 4).toString()),Float.parseFloat(J.getValueAt(J.getSelectedRow(), 5).toString()),Float.parseFloat(J.getValueAt(J.getSelectedRow(), 6).toString())));
			T=new JTable(HashMapProcessor.ProcessHashMap(Order),CSVImporter.Title);
			P.getViewport().add(T);
			CSVImporter.H.get(J.getSelectedRow()).timesOrdered++;
			i++;
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==Search)
		{
			H=DeliveryService.Filter(Integer.parseInt(MinCalories.getText()),Integer.parseInt(MaxCalories.getText()),Integer.parseInt(MinProteins.getText()),Integer.parseInt(MaxProteins.getText()),Integer.parseInt(MinFats.getText()),Integer.parseInt(MaxFats.getText()),Integer.parseInt(MinSodium.getText()),Integer.parseInt(MaxSodium.getText()),Integer.parseInt(MinRating.getText()),Integer.parseInt(MaxRating.getText()),Integer.parseInt(MinPrice.getText()),Integer.parseInt(MaxPrice.getText()));
			if(SearchBar.getText().equals(""))
			{
				
			}
			else
			{
				H=DeliveryService.FilterText(SearchBar.getText(),H);
			}
			J=new JTable(HashMapProcessor.ProcessHashMapBrute(H),CSVImporter.Title);
			S.getViewport().add(J);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==FinishOrder)
		{
			try {
				DeliveryService.ProcessOrder(Order,Client);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			i=0;
			Order.clear();
			T=new JTable();
			P.getViewport().add(T);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
			
		}
		}
	
}
