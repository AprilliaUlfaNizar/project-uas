package project_uas;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class menu_kasir extends JFrame 
{
	private static final int lebar = 400;
	private static final int tinggi = 200;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// toolbars
	private JMenu edit = new JMenu("Edit");
	private JMenu transaksi = new JMenu("Transaksi");
	private JMenu logout = new JMenu("Logout");
	private JMenuItem out = new JMenuItem("Keluar");
	
	// isi edit
	private JMenuItem change_password = new JMenuItem("Change The Password");
	
	// isi transaksi
	private JMenuItem penjualan = new JMenuItem("Penjualan");
	
	
	public menu_kasir(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// toolbar
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
	
		menu.add(edit);
		menu.add(transaksi);
		menu.add(logout);
		
		logout.add(out);
		
		// isi menu edit
		edit.add(change_password);
		
		// isi menu transaksi
		transaksi.add(penjualan);
		
		change_password.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					ubah_password up =new ubah_password("Maintenance Password User");
					up.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		penjualan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					menu_transaksi mt = new menu_transaksi("Menu Penjualan");
					mt.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		out.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					dispose();
					menu_login ml = new menu_login("");
					ml.setVisible(true);
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
		menu_kasir ma = new menu_kasir("");
		ma.setVisible(true);
	}
}