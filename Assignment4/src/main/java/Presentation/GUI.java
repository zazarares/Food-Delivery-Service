package Presentation;

import javax.swing.JFrame;

import Data.Pair;
import Functional.Serialization;
import Functional.UserLoader;
import Functional.UserUnloader;
import OrderManager.DeliveryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
public class GUI extends JFrame implements ActionListener {
	JFrame Frame=new JFrame("Product Management");
	JFrame CreateAccountFrame=new JFrame("Create Account");
	JButton Exit=new JButton("Exit");
	AdminView A=new AdminView();
	ClientView C=new ClientView();
	JPanel LoginPanel=new JPanel();
	JPanel UserPanel=new JPanel();
	JPanel CreateAcc=new JPanel();
	JPanel PasswordPanel=new JPanel();
	JButton Done=new JButton("Done");
	JButton LoginButton=new JButton("Login");
	JButton CreateAccount=new JButton("Create Account");
	JTextField Username=new JTextField("");
	JPasswordField Password=new JPasswordField("");
	JTextField NewUser=new JTextField("");
	JTextField NewPass=new JTextField("");
	String[] Types= {"admin","employee","user"};
	JComboBox typeSelector=new JComboBox(Types);
	JLabel UsernameLabel=new JLabel("Username:");
	JLabel PasswordLabel=new JLabel("Password:");
	JLabel NewUsernameLabel=new JLabel("Username:");
	JLabel NewPasswordLabel=new JLabel("Password:");
	JLabel ErrorLabel=new JLabel("");
	ArrayList<Pair> admin=new ArrayList<Pair>();
	ArrayList<Pair> employee=new ArrayList<Pair>();
	public static ArrayList<Pair> client=new ArrayList<Pair>();
	private void LoadData()
	{
		String s[][]=UserLoader.LoadUser("admin");
		admin.clear();
		client.clear();
		employee.clear();
		int i=0;
		while(s[0][i]!=null) {
			admin.add(new Pair(s[0][i],s[1][i]));
			i++;
		}
		s=UserLoader.LoadUser("client");
		i=0;
		while(s[0][i]!=null) {
			client.add(new Pair(s[0][i],s[1][i]));
			i++;
		}
		 s=UserLoader.LoadUser("employee");
		i=0;
		while(s[0][i]!=null) {
			employee.add(new Pair(s[0][i],s[1][i]));
			i++;
		}
		
	}
	public GUI() {
		Frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		CreateAccountFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		Raport R=new Raport();
		Frame.setSize(400,300);
		CreateAccountFrame.setSize(400,800);
		Frame.setLocationRelativeTo(null);
		LoginPanel.add(ErrorLabel);
		Done.setBounds(150,700,100,50);
		LoginPanel.add(LoginButton);
		LoginPanel.add(Exit);
		UserPanel.add(UsernameLabel);
		UserPanel.add(Username);
		PasswordPanel.add(PasswordLabel);
		PasswordPanel.add(Password);
		CreateAcc.add(CreateAccount);
		LoginPanel.add(CreateAccount);
		typeSelector.setBounds(150,50,100,30);
		NewUser.setBounds(100,150,200,30);
		NewPass.setBounds(100,250,200,30);
		NewUsernameLabel.setBounds(100,120,200,30);
		NewPasswordLabel.setBounds(100,220,200,30);
		Username.setPreferredSize(new Dimension(200,20));
		Password.setPreferredSize(new Dimension(200,20));
		LoginButton.addActionListener(this);
		CreateAccountFrame.add(Done);
		CreateAccountFrame.add(NewUser);
		CreateAccountFrame.add(NewPass);
		CreateAccountFrame.add(NewPasswordLabel);
		CreateAccountFrame.add(NewUsernameLabel);
		Exit.addActionListener(this);
		CreateAccount.addActionListener(this);
		Done.addActionListener(this);
		//Frame.setContentPane(LoginPanel);
		//System.out.println(admin.get(0).user+" "+admin.get(0).password);
		LoginPanel.setLayout(new BoxLayout(LoginPanel, BoxLayout.Y_AXIS));
		CreateAccountFrame.add(typeSelector);
		Frame.add(BorderLayout.SOUTH,LoginPanel);
		//Frame.add(BorderLayout.PAGE_END,CreateAcc);
		CreateAccountFrame.setLayout(null);
		Frame.add(BorderLayout.NORTH,UserPanel);
		Frame.add(BorderLayout.CENTER,PasswordPanel);
		Frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==LoginButton)
		{
			try {
				admin=Serialization.ReadUser("admin");
				client=Serialization.ReadUser("client");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ErrorLabel.setText("");
			ErrorLabel.setForeground(Color.RED);
			int i=0;
			while(i!=admin.size())
			{
				if(Username.getText().equals(admin.get(i).user))
					if(Password.getText().equals(admin.get(i).password))
						{
						A.SetVisible(true,Frame);
						C.SetOnlyVisible(false);
						return;
						}
					else
						{
						ErrorLabel.setText("invalid password");
						}
				else
					ErrorLabel.setText("invalid username");
				i++;
			}			
			i=0;
			while(i!=employee.size())
			{
				if(Username.getText().equals(employee.get(i).user))
					if(Password.getText().equals(employee.get(i).password))
						{
						ErrorLabel.setText("employee login");
						A.SetOnlyVisible(false);
						C.SetOnlyVisible(false);
						return;
						}
					else
						{
						ErrorLabel.setText("invalid password");
						return;
						}
				else
					ErrorLabel.setText("invalid username");
				i++;
			}
			i=0;
			while(i!=client.size())
			{
				if(Username.getText().equals(client.get(i).user))
					if(Password.getText().equals(client.get(i).password))
						{
						A.SetOnlyVisible(false);
						C.SetVisible(true, Frame,client.get(i));
						return;
						}
					else
						{
						ErrorLabel.setText("invalid password");
						return;
						}
				else
					ErrorLabel.setText("invalid username");
				i++;
			}	
		}
		if(e.getSource()==CreateAccount)
		{
			Frame.setVisible(false);
			
			CreateAccountFrame.setVisible(true);
		}
		if(e.getSource()==Done)
		{
			if(NewUser.getText().equals("") || NewPass.getText().equals(""))
				throw new RuntimeException("stringuri invalide");
			if(typeSelector.getSelectedIndex()==0)
				admin.add(new Pair(NewUser.getText(), NewPass.getText()));
				if(typeSelector.getSelectedIndex()==1)
					employee.add(new Pair(NewUser.getText(), NewPass.getText()));
				if(typeSelector.getSelectedIndex()==2)
					client.add(new Pair(NewUser.getText(), NewPass.getText()));
				try {
					Serialization.writeUsers(admin, "admin");
					Serialization.writeUsers(client, "client");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			Frame.setVisible(true);
			CreateAccountFrame.setVisible(false);
		}
		if(e.getSource()==Exit)
		{
			try {
				DeliveryService.WriteOrder();
				DeliveryService.WriteProduct();
				Serialization.writeUsers(admin, "admin");
				Serialization.writeUsers(client, "client");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		}
			
	}

}
