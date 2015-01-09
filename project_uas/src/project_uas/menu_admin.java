package project_uas;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class menu_admin extends JFrame 
{
	private static final int lebar = 400;
	private static final int tinggi = 200;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// toolbars
	private JMenu file = new JMenu("File");
	private JMenu edit = new JMenu("Edit");
	private JMenu transaksi = new JMenu("Transaksi");
	private JMenu laporan = new JMenu("Laporan");
	private JMenu logout = new JMenu("Logout");
	
	private JMenuItem out = new JMenuItem("Keluar");
	
	// isi file
	private JMenu insert = new JMenu("Insert");
	private JMenu update = new JMenu("Update");
	private JMenu delete = new JMenu("Delete");
	
	// isi insert
	private JMenuItem i_karyawan = new JMenuItem("Karyawan");
	private JMenuItem i_pelanggan = new JMenuItem("Pelanggan");
	private JMenuItem i_suplier = new JMenuItem("Suplier");
	private JMenuItem i_produk = new JMenuItem("Produk");
	
	// isi update
	private JMenuItem u_karyawan = new JMenuItem("Karyawan");
	private JMenuItem u_pelanggan = new JMenuItem("Pelanggan");
	private JMenuItem u_suplier = new JMenuItem("Suplier");
	private JMenuItem u_produk = new JMenuItem("Produk");
	
	// isi delete
	private JMenuItem d_karyawan = new JMenuItem("Karyawan");
	private JMenuItem d_pelanggan = new JMenuItem("Pelanggan");
	private JMenuItem d_suplier = new JMenuItem("Suplier");
	private JMenuItem d_produk = new JMenuItem("Produk");
	
	// isi edit
	private JMenuItem change_password = new JMenuItem("Change The Password");
	
	// isi transaksi
	private JMenuItem penjualan = new JMenuItem("Penjualan");
	
	// isi laporan
	private JMenuItem lap_penjualan = new JMenuItem("Laporan Penjualan");
	private JMenuItem lap_pendapatan = new JMenuItem("Laporan Pendapatan");
	private JMenuItem lap_stok = new JMenuItem("Laporan Stok");

	public menu_admin(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// toolbar
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		menu.add(file);
		menu.add(edit);
		menu.add(transaksi);
		menu.add(laporan);
		menu.add(logout);
		
		logout.add(out);
		
		// isi menu file
		file.add(insert);
		file.add(update);
		file.add(delete);
		
		// isi menu insert
		insert.add(i_karyawan);
		insert.add(i_pelanggan);
		insert.add(i_suplier);
		insert.add(i_produk);
		
		// isi menu update
		update.add(u_karyawan);
		update.add(u_pelanggan);
		update.add(u_suplier);
		update.add(u_produk);
		
		// isi menu delete
		delete.add(d_karyawan);
		delete.add(d_pelanggan);
		delete.add(d_suplier);
		delete.add(d_produk);
		
		// isi menu edit
		edit.add(change_password);
		
		// isi menu transaksi
		transaksi.add(penjualan);
		
		// isi menu laporan
		laporan.add(lap_penjualan);
		laporan.add(lap_pendapatan);
		laporan.add(lap_stok);
		
		// insert
		// karyawan
		i_karyawan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					insert_karyawan ik = new insert_karyawan("Insert Data Karyawan");
					ik.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		// pelanggan
		i_pelanggan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					insert_pelanggan ip = new insert_pelanggan("Insert Data Pelanggan");
					ip.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		// produk
		i_produk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					insert_produk ip = new insert_produk("Insert");
					ip.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		// suplier
		i_suplier.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{		
					insert_suplier is = new insert_suplier("Insert Data Suplier");
					is.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		// bag update
		// karyawan
		u_karyawan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					update_karyawan uk = new update_karyawan("Update Data Karyawan");
					uk.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		// pelanggan
		u_pelanggan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					update_pelanggan up = new update_pelanggan("Update Data Pelanggan");
					up.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		// produk
		u_produk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					update_produk up = new update_produk("Update Data Produk");
					up.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		// suplier
		u_suplier.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{		
					update_suplier us = new update_suplier("Update Data Suplier");
					us.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		// bagian delete
		// karyawan
		d_karyawan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					delete_karyawan dk = new delete_karyawan("Delete Data Karyawan");
					dk.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		// pelanggan
		d_pelanggan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					delete_pelanggan dp = new delete_pelanggan("Delete Data Pelanggan");
					dp.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		// produk
		d_produk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					delete_produk up = new delete_produk("Delete Data Produk");
					up.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		// suplier
		d_suplier.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{		
					delete_suplier us = new delete_suplier("Delete Data Suplier");
					us.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
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
		
		lap_penjualan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					menu_laporan_penjualan mlp = new menu_laporan_penjualan("Laporan Penjualan");
					mlp.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		lap_pendapatan.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					menu_laporan_pendapatan mlp = new menu_laporan_pendapatan("Laporan Penjualan");
					mlp.setVisible(true);
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		lap_stok.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					menu_laporan_stok mls = new menu_laporan_stok("Laporan Stok");
					mls.setVisible(true);
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
		menu_admin ma = new menu_admin("");
		ma.setVisible(true);
	}
}