package project_uas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insert_produk extends JFrame 
{
	//public static String log_pass;
	private static final int lebar = 280;
	private static final int tinggi = 220;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// label 
	private JLabel id_produk = new JLabel("ID Produk");
	private JLabel nama_produk = new JLabel("Nama");
	private JLabel harga_produk = new JLabel("Harga");
	private JLabel stok_produk = new JLabel("Stok");
	private JLabel id_suplier = new JLabel("ID Suplier");
	
	// textfield
	private JTextField id_pro = new JTextField();
	private JTextField nama_pro = new JTextField();
	private JTextField harga_pro = new JTextField();
	private JTextField stok_pro = new JTextField();
	private JTextField id_sup = new JTextField();
	
	// button
	private JButton save = new JButton("Save");
	private JButton cancel = new JButton("Cancel");

	private JOptionPane jop = new JOptionPane();
	public insert_produk(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		id_produk.setBounds(20,20,100,20);
		id_pro.setBounds(130,20,100,20);
		nama_produk.setBounds(20,45,100,20);
		nama_pro.setBounds(130,45,100,20);
		harga_produk.setBounds(20,70,100,20);
		harga_pro.setBounds(130,70,100,20);
		stok_produk.setBounds(20,95,100,20);
		stok_pro.setBounds(130,95,100,20);
		id_suplier.setBounds(20,120,100,20);
		id_sup.setBounds(130,120,100,20);
		save.setBounds(50,150,80,20);
		cancel.setBounds(140,150,80,20);
		
		kontainer.add(id_produk);
		kontainer.add(id_pro);
		kontainer.add(nama_produk);
		kontainer.add(nama_pro);
		kontainer.add(harga_produk);
		kontainer.add(harga_pro);
		kontainer.add(stok_produk);
		kontainer.add(stok_pro);
		kontainer.add(id_suplier);
		kontainer.add(id_sup);
		kontainer.add(save);
		kontainer.add(cancel);
		
		run_produk rp = new run_produk();
		produk p = rp.id();
		id_pro.setText("PR-" + p.getKode_pro());
		
		save.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					run_produk rp = new run_produk();
					rp.insert(id_pro.getText(), nama_pro.getText(),  id_sup.getText(), Integer.parseInt(harga_pro.getText()), Integer.parseInt(stok_pro.getText()));
					id_pro.setText("");
					nama_pro.setText("");
					harga_pro.setText("");
					stok_pro.setText("");
					id_sup.setText("");	
					produk p = rp.id();
					id_pro.setText("PR-" + p.getKode_pro());
					jop.showConfirmDialog(null, "Data Berhasil Disimpan", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
					nama_pro.setText("");
					harga_pro.setText("");
					stok_pro.setText("");
					id_sup.setText("");			
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
		insert_produk ip = new insert_produk("Insert");
		ip.setVisible(true);
	}
}