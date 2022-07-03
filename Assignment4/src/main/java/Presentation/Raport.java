package Presentation;
import javax.swing.*;

import OrderManager.DeliveryService;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;

public class Raport extends JFrame implements ActionListener{
		public JFrame Raport=new JFrame();
		JPanel RaportPanel=new JPanel();
		JPanel ButtonPanel=new JPanel();
		JPanel DataPanel=new JPanel();
		JTable R1=new JTable();
		JTable R2=new JTable();
		JTable R3=new JTable();
		JTable R4=new JTable();
		JTextField P1=new JTextField();
		JTextField P2=new JTextField();
		JTextField P3=new JTextField();
		JTextField P4=new JTextField();
		JTextField P5=new JTextField();
		JTextField P6=new JTextField();
		JScrollPane S1=new JScrollPane(R1);
		JScrollPane S2=new JScrollPane(R2);
		JScrollPane S3=new JScrollPane(R3);
		JScrollPane S4=new JScrollPane(R4);
		JButton GenerateR1=new JButton("GenerateR1");
		JButton GenerateR2=new JButton("GenerateR2");
		JButton GenerateR3=new JButton("GenerateR3");
		JButton GenerateR4=new JButton("GenerateR4");
		JButton Logout=new JButton("Logout");
		public Raport() {
			Raport.setSize(1400,800);
			Raport.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			S1.setPreferredSize(new Dimension(300,600));
			S2.setPreferredSize(new Dimension(300,600));
			S3.setPreferredSize(new Dimension(300,600));
			S4.setPreferredSize(new Dimension(300,600));
			P1.setPreferredSize(new Dimension(100,50));
			P2.setPreferredSize(new Dimension(100,50));
			P3.setPreferredSize(new Dimension(100,50));
			P4.setPreferredSize(new Dimension(100,50));
			P5.setPreferredSize(new Dimension(100,50));
			DataPanel.add(P1);
			DataPanel.add(P2);
			DataPanel.add(P3);
			DataPanel.add(P4);
			DataPanel.add(P5);
			RaportPanel.add(S1);
			RaportPanel.add(S2);
			RaportPanel.add(S3);
			RaportPanel.add(S4);
			ButtonPanel.add(GenerateR1);
			ButtonPanel.add(GenerateR2);
			ButtonPanel.add(Logout);
			ButtonPanel.add(GenerateR3);
			ButtonPanel.add(GenerateR4);
			GenerateR1.addActionListener(this);
			GenerateR2.addActionListener(this);
			GenerateR3.addActionListener(this);
			GenerateR4.addActionListener(this);
			Logout.addActionListener(this);
			Raport.add(BorderLayout.CENTER,DataPanel);
			Raport.add(BorderLayout.NORTH,RaportPanel);
			Raport.add(BorderLayout.SOUTH,ButtonPanel);

			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==Logout)
			{
				Raport.setVisible(false);
				try {
					AdminView.AdminFrame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getSource()==GenerateR1)
			{
				R1=DeliveryService.GenerateRaportno1(Integer.parseInt(P1.getText()), Integer.parseInt(P2.getText()));
				S1.getViewport().add(R1);
				Raport.invalidate();
				Raport.repaint();
				Raport.validate();
			}
			if(e.getSource()==GenerateR2)
			{
				R2=DeliveryService.GenerateRaportno2(Integer.parseInt(P3.getText()));
				S2.getViewport().add(R2);
				Raport.invalidate();
				Raport.repaint();
				Raport.validate();
			}
			if(e.getSource()==GenerateR3)
			{
				R3=DeliveryService.GenerateRaportno3(Integer.parseInt(P4.getText()),Integer.parseInt(P5.getText()));
				S3.getViewport().add(R3);
				Raport.invalidate();
				Raport.repaint();
				Raport.validate();
			}
			if(e.getSource()==GenerateR4)
			{
				R4=DeliveryService.GenerateRaportno4(LocalDateTime.now());
				S4.getViewport().add(R4);
				Raport.invalidate();
				Raport.repaint();
				Raport.validate();
			}
		}
}
