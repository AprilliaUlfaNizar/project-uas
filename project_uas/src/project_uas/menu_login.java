package project_uas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class menu_login extends JFrame 
{
	public static String log_user;
	public static String log;
	
	//public static String log_pass;
	private static final int lebar = 300;
	private static final int tinggi = 350;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// bag menu
	private JLabel username = new JLabel("Username");
	private JLabel password = new JLabel("Password");
	private JTextField user = new JTextField(10);
	private JPasswordField pass = new JPasswordField(10);
	private JButton login = new JButton("Login");
	private JButton cancel = new JButton("Cancel");
	
	// bag judul
	private JLabel header = new JLabel("Apotek Herbal");
	
	private JOptionPane jop = new JOptionPane();
	
	public menu_login(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		header.setBounds(100,50,150,20);
		username.setBounds(60, 150, 100, 20);
		user.setBounds(140,150,100,20);
		password.setBounds(60,180,100,20);
		pass.setBounds(140,180,100,20);
		login.setBounds(65,210,80,20);
		cancel.setBounds(150,210,80,20);
		
		kontainer.add(header);
		kontainer.add(username);
		kontainer.add(user);
		kontainer.add(password);
		kontainer.add(pass);
		kontainer.add(login);
		kontainer.add(cancel);
		
		login.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					run_karyawan uk = new run_karyawan();
					karyawan k = uk.password(user.getText());
					if(pass.getText().equalsIgnoreCase(k.getPassword()))
					{
						if(k.getKode_div().equalsIgnoreCase("DV-1"))
						{
							menu_admin ma = new menu_admin("Admin");
							ma.setVisible(true);
							log_user = user.getText();
							log = "admin";
							dispose();
						}
						else
						{
							menu_kasir mk = new menu_kasir("Kasir");
							mk.setVisible(true);
							log_user = user.getText();
							log = "kasir";
							dispose();
						}
					}
					else
					{
						jop.showConfirmDialog(null, "Username & Password Salah ", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
					}
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Ada", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);				}
			}
		}
		);
		
		cancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					dispose();
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
	}
	public static void main(String [] args)
	{
		menu_login ml = new menu_login("Login");
		ml.setVisible(true);
	}
}
