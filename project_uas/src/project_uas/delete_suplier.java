package project_uas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class delete_suplier extends JFrame 
{
	//public static String log_pass;
	private static final int lebar = 350;
	private static final int tinggi = 220;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// label 
	private JLabel id_suplier = new JLabel("ID Suplier");
	private JLabel nama_suplier = new JLabel("Nama");
	
	// textfield
	private JTextField id_sup = new JTextField();
	private JTextField nama_sup = new JTextField();
	
	// button
	private JButton delete = new JButton("Delete");
	private JButton cancel = new JButton("Cancel");
	private JButton search = new JButton("Search");
	
	private JOptionPane jop = new JOptionPane();
	public delete_suplier(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		id_suplier.setBounds(20,20,100,20);
		id_sup.setBounds(130,20,100,20);
		search.setBounds(240,20,80,20);
		nama_suplier.setBounds(20,45,100,20);
		nama_sup.setBounds(130,45,100,20);
		delete.setBounds(50,150,80,20);
		cancel.setBounds(140,150,80,20);
		
		kontainer.add(id_suplier);
		kontainer.add(id_sup);
		kontainer.add(search);
		kontainer.add(nama_suplier);
		kontainer.add(nama_sup);
		kontainer.add(delete);
		kontainer.add(cancel);
		
		delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					run_suplier rs = new run_suplier();
					rs.delete(id_sup.getText());
					id_sup.setText("");
					nama_sup.setText("");
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
					id_sup.setText("");
					nama_sup.setText("");			
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
					nama_sup.setText("");
					run_suplier rs = new run_suplier();
					suplier s = rs.search_kode(id_sup.getText());
					nama_sup.setText(s.getNama_sup());			
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
		delete_suplier us = new delete_suplier("Insert");
		us.setVisible(true);
	}
}