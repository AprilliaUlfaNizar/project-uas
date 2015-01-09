package project_uas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class delete_pelanggan extends JFrame 
{
	//public static String log_pass;
	private static final int lebar = 350;
	private static final int tinggi = 220;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// label 
	private JLabel id_pelanggan = new JLabel("ID Pelanggan");
	private JLabel nama_pelanggan = new JLabel("Nama");
	private JLabel alamat_pelanggan = new JLabel("Alamat");
	
	// textfield
	private JTextField id_pel = new JTextField();
	private JTextField nama_pel = new JTextField();
	private JTextField alamat_pel = new JTextField();
	
	// button
	private JButton delete = new JButton("Delete");
	private JButton cancel = new JButton("Cancel");
	private JButton search = new JButton("Search");
	
	private JOptionPane jop = new JOptionPane();
	public delete_pelanggan(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		id_pelanggan.setBounds(20,20,100,20);
		id_pel.setBounds(130,20,100,20);
		search.setBounds(240,20,80,20);
		nama_pelanggan.setBounds(20,45,100,20);
		nama_pel.setBounds(130,45,100,20);
		alamat_pelanggan.setBounds(20,70,100,20);
		alamat_pel.setBounds(130,70,100,20);
		delete.setBounds(50,150,80,20);
		cancel.setBounds(140,150,80,20);
		
		kontainer.add(id_pelanggan);
		kontainer.add(id_pel);
		kontainer.add(search);
		kontainer.add(nama_pelanggan);
		kontainer.add(nama_pel);
		kontainer.add(alamat_pelanggan);
		kontainer.add(alamat_pel);
		kontainer.add(delete);
		kontainer.add(cancel);
		
		delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					run_pelanggan rp = new run_pelanggan();
					rp.delete(id_pel.getText());
					id_pel.setText("");
					nama_pel.setText("");
					alamat_pel.setText("");
					jop.showConfirmDialog(null, "Data Berhasil Dihapus", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);	
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Ada", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);	
				}
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
					id_pel.setText("");
					nama_pel.setText("");
					alamat_pel.setText("");			
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		search.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					nama_pel.setText("");
					alamat_pel.setText("");
					run_pelanggan rp = new run_pelanggan();
					pelanggan p = rp.search_kode(id_pel.getText());
					nama_pel.setText(p.getNama_pel());
					alamat_pel.setText(p.getAlamat_pel());			
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Ada", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);	
				}
			}
		}
		);
	}
	public static void main(String [] args)
	{
		delete_pelanggan ik = new delete_pelanggan("Insert");
		ik.setVisible(true);
	}
}