package Presentation;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import Data.Product;
import Functional.CSVImporter;
import Functional.HashMapProcessor;
import OrderManager.DeliveryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
public class AdminView extends JFrame implements ActionListener{
	public static JFrame AdminFrame=new JFrame("Admin View");
	JFrame F;
	JPanel ProductView=new JPanel();
	JFrame EditProductFrame=new JFrame();
	Raport R=new Raport();
	JFrame AddProductFrame=new JFrame();
	JPanel EditProduct=new JPanel();
	JButton FinishEditing=new JButton("submit");
	JButton FinishAdding=new JButton("submit");
	JPanel AddProduct=new JPanel();
	JButton StartEditing=new JButton("edit");
	JButton StartAdding=new JButton("add");
	JButton DeleteProduct=new JButton("delete");
	JButton CompositeProduct=new JButton("Add composite product");
	JButton FinishCProduct=new JButton("Finish");
	JTextField ProductName=new JTextField();
	HashMap<Integer,Data.MenuItem>CP=new HashMap<Integer,Data.MenuItem>();
	int i=0;

	JTextField Title=new JTextField("");
	JTextField Calories=new JTextField("");
	JTextField Proteins=new JTextField("");
	JTextField Fats=new JTextField("");
	JTextField Sodium=new JTextField("");
	JTextField Rating=new JTextField("");
	JTextField Price=new JTextField("");
	JLabel TitleL=new JLabel("Title");
	JLabel CaloriesL=new JLabel("Calories");
	JLabel ProteinsL=new JLabel("Proteins");
	JLabel FatsL=new JLabel("Fats");
	JLabel SodiumL=new JLabel("Sodium");
	JLabel RatingL=new JLabel("Rating");
	JLabel PriceL=new JLabel("Price");
	JButton Reports=new JButton("Raport");
	JTextField AddTitle=new JTextField("");
	JTextField AddCalories=new JTextField("");
	JTextField AddProteins=new JTextField("");
	JTextField AddFats=new JTextField("");
	JTextField AddSodium=new JTextField("");
	JTextField AddRating=new JTextField("");
	JTextField AddPrice=new JTextField("");
	JLabel AddTitleL=new JLabel("Title");
	JLabel AddCaloriesL=new JLabel("Calories");
	JLabel AddProteinsL=new JLabel("Proteins");
	JLabel AddFatsL=new JLabel("Fats");
	JLabel AddSodiumL=new JLabel("Sodium");
	JLabel AddRatingL=new JLabel("Rating");
	JLabel AddPriceL=new JLabel("Price");
	JPanel ButtonView=new JPanel();
	JButton Import=new JButton("Import");
	JButton Done=new JButton("Logout");
	JTable T=new JTable();
	JTable C=new JTable();
	JScrollPane J=new JScrollPane(C);
	JScrollPane P=new JScrollPane(T);
	File selectedFile;
	public AdminView() {
		AdminFrame.setSize(1000,800);
		EditProductFrame.setSize(1000,800);
		AddProductFrame.setSize(1000,800);
		AdminFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		EditProductFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		AddProductFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		ButtonView.add(Done);
		ButtonView.add(StartEditing);
		ButtonView.add(Import);
		ButtonView.add(StartAdding);
		ButtonView.add(DeleteProduct);
		ButtonView.add(CompositeProduct);
		ButtonView.add(FinishCProduct);
		ButtonView.add(Reports);
		ProductView.add(P);
		ProductView.add(J);
		ButtonView.add(ProductName);
		ProductName.setPreferredSize(new Dimension(100,50));
		AdminFrame.add(BorderLayout.NORTH,ProductView);
		AdminFrame.add(BorderLayout.SOUTH,ButtonView);
		Done.addActionListener(this);
		Import.addActionListener(this);
		StartEditing.addActionListener(this);
		FinishEditing.addActionListener(this);
		FinishAdding.addActionListener(this);
		StartAdding.addActionListener(this);
		DeleteProduct.addActionListener(this);
		CompositeProduct.addActionListener(this);
		FinishCProduct.addActionListener(this);
		Reports.addActionListener(this);
		///editing GUI
		Title.setBounds(100,0,200,30);
		Calories.setBounds(100,100,200,30);
		Proteins.setBounds(100,200,200,30);
		Fats.setBounds(100,300,200,30);
		Sodium.setBounds(100,400,200,30);
		Rating.setBounds(100,500,200,30);
		Price.setBounds(100,600,200,30);
		TitleL.setBounds(0,0,100,30);
		CaloriesL.setBounds(0,100,100,30);
		ProteinsL.setBounds(0,200,100,30);
		FatsL.setBounds(0,300,100,30);
		SodiumL.setBounds(0,400,100,30);
		RatingL.setBounds(0,500,100,30);
		PriceL.setBounds(0,600,100,30);
		FinishEditing.setBounds(300,700,100,30);
		EditProduct.add(Title);
		EditProduct.add(Calories);
		EditProduct.add(Sodium);
		EditProduct.add(Price);
		EditProduct.add(Rating);
		EditProduct.add(Fats);
		EditProduct.add(Proteins);
		EditProduct.add(TitleL);
		EditProduct.add(CaloriesL);
		EditProduct.add(SodiumL);
		EditProduct.add(PriceL);
		EditProduct.add(RatingL);
		EditProduct.add(FatsL);
		EditProduct.add(ProteinsL);
		EditProduct.add(FinishEditing);
		EditProduct.setLayout(null);
		EditProductFrame.setContentPane(EditProduct);
		///ADD product
		AddTitle.setBounds(100,0,200,30);
		AddCalories.setBounds(100,100,200,30);
		AddProteins.setBounds(100,200,200,30);
		AddFats.setBounds(100,300,200,30);
		AddSodium.setBounds(100,400,200,30);
		AddRating.setBounds(100,500,200,30);
		AddPrice.setBounds(100,600,200,30);
		AddTitleL.setBounds(0,0,100,30);
		AddCaloriesL.setBounds(0,100,100,30);
		AddProteinsL.setBounds(0,200,100,30);
		AddFatsL.setBounds(0,300,100,30);
		AddSodiumL.setBounds(0,400,100,30);
		AddRatingL.setBounds(0,500,100,30);
		AddPriceL.setBounds(0,600,100,30);
		FinishAdding.setBounds(300,700,100,30);
		AddProduct.add(AddTitle);
		AddProduct.add(AddCalories);
		AddProduct.add(AddSodium);
		AddProduct.add(AddPrice);
		AddProduct.add(AddRating);
		AddProduct.add(AddFats);
		AddProduct.add(AddProteins);
		AddProduct.add(AddTitleL);
		AddProduct.add(AddCaloriesL);
		AddProduct.add(AddSodiumL);
		AddProduct.add(AddPriceL);
		AddProduct.add(AddRatingL);
		AddProduct.add(AddFatsL);
		AddProduct.add(AddProteinsL);
		AddProduct.add(FinishAdding);
		AddProduct.setLayout(null);
		AddProductFrame.setContentPane(AddProduct);
		
	}
	public void SetVisible(boolean t,JFrame F) {
		if(CSVImporter.H!=null)
		{
			T=new JTable(HashMapProcessor.ProcessHashMap(CSVImporter.H),CSVImporter.Title);
			P.getViewport().add(T);
		}
			F.setVisible(!t);
			this.F=F;
			AdminFrame.setVisible(t);

	}
	public void SetOnlyVisible(boolean t) {
		AdminFrame.setVisible(t);

}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Done)
		{
			this.SetVisible(false,F);
			
		}
		if(e.getSource()==Import)
		{
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(AdminFrame);
			selectedFile = fileChooser.getSelectedFile();
			try {
				T=new JTable(HashMapProcessor.ProcessHashMap(CSVImporter.ImportCSV(selectedFile)),CSVImporter.Title);
				P.getViewport().add(T);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			AdminFrame.invalidate();
			AdminFrame.repaint();
			AdminFrame.validate();
			
		}
		if(e.getSource()==StartEditing)
		{
			Title.setText(T.getValueAt(T.getSelectedRow(), 0).toString());
			Rating.setText(T.getValueAt(T.getSelectedRow(), 1).toString());
			Calories.setText(T.getValueAt(T.getSelectedRow(), 2).toString());
			Proteins.setText(T.getValueAt(T.getSelectedRow(), 3).toString());
			Fats.setText(T.getValueAt(T.getSelectedRow(), 4).toString());
			Sodium.setText(T.getValueAt(T.getSelectedRow(), 5).toString());
			Price.setText(T.getValueAt(T.getSelectedRow(), 6).toString());
			AdminFrame.setVisible(false);
			EditProductFrame.setVisible(true);
		}
		if(e.getSource()==FinishEditing)
		{
			T.setValueAt(Title.getText(),T.getSelectedRow() , 0);
			T.setValueAt(Rating.getText(),T.getSelectedRow() , 1);
			T.setValueAt(Calories.getText(),T.getSelectedRow() , 2);
			T.setValueAt(Proteins.getText(),T.getSelectedRow() , 3);
			T.setValueAt(Fats.getText(),T.getSelectedRow() , 4);
			T.setValueAt(Sodium.getText(),T.getSelectedRow() , 5);
			T.setValueAt(Price.getText(),T.getSelectedRow() , 6);
			CSVImporter.H.put(T.getSelectedRow(),new Product(Title.getText(),Float.parseFloat(Rating.getText()),Float.parseFloat(Calories.getText()),Float.parseFloat(Proteins.getText()),Float.parseFloat(Fats.getText()),Float.parseFloat(Sodium.getText()),Float.parseFloat(Price.getText())));
			AdminFrame.setVisible(true);
			EditProductFrame.setVisible(false);
		}
		if(e.getSource()==StartAdding)
		{
			AdminFrame.setVisible(false);
			AddProductFrame.setVisible(true);
		}
		if(e.getSource()==FinishAdding)
		{
			System.out.println("here");
			CSVImporter.H.put(CSVImporter.H.size(),new Product(AddTitle.getText(),Float.parseFloat(AddRating.getText()),Float.parseFloat(AddCalories.getText()),Float.parseFloat(AddProteins.getText()),Float.parseFloat(AddFats.getText()),Float.parseFloat(AddSodium.getText()),Float.parseFloat(AddPrice.getText())));
			T=new JTable(HashMapProcessor.ProcessHashMap(CSVImporter.H),CSVImporter.Title);
			P.getViewport().add(T);
			AdminFrame.setVisible(true);
			AddProductFrame.setVisible(false);
		}
		if(e.getSource()==DeleteProduct)
		{
			CSVImporter.H.remove(T.getSelectedRow());
			T=new JTable(HashMapProcessor.ProcessHashMap(CSVImporter.H),CSVImporter.Title);
			P.getViewport().add(T);
			AdminFrame.invalidate();
			AdminFrame.repaint();
			AdminFrame.validate();
		}
		if(e.getSource()==CompositeProduct)
		{
			CP.put(i,new Product(T.getValueAt(T.getSelectedRow(), 0).toString(),Float.parseFloat(T.getValueAt(T.getSelectedRow(), 1).toString()),Float.parseFloat(T.getValueAt(T.getSelectedRow(), 2).toString()),Float.parseFloat(T.getValueAt(T.getSelectedRow(), 3).toString()),Float.parseFloat(T.getValueAt(T.getSelectedRow(), 4).toString()),Float.parseFloat(T.getValueAt(T.getSelectedRow(), 5).toString()),Float.parseFloat(T.getValueAt(T.getSelectedRow(), 6).toString())));
			C=new JTable(HashMapProcessor.ProcessHashMap(CP),CSVImporter.Title);
			J.getViewport().add(C);
			i++;
			AdminFrame.invalidate();
			AdminFrame.repaint();
			AdminFrame.validate();
		}
		if(e.getSource()==FinishCProduct)
		{
			Data.MenuItem Jeff=new Data.CompositeProduct(ProductName.getText(),CP);
			CSVImporter.H.put(CSVImporter.H.size(),Jeff);
			T=new JTable(HashMapProcessor.ProcessHashMap(CSVImporter.H),CSVImporter.Title);
			P.getViewport().add(T);
			CP.clear();
			C=new JTable();
			J.getViewport().add(C);
			AdminFrame.invalidate();
			AdminFrame.repaint();
			AdminFrame.validate();
		}
		if(e.getSource()==Reports)
		{
			AdminFrame.setVisible(false);
			R.Raport.setVisible(true);
		}
	}
}
