package project_uas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insert_karyawan extends JFrame 
{
	//public static String log_pass;
	private static final int lebar = 280;
	private static final int tinggi = 220;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	// label 
	private JLabel id_karyawan = new JLabel("ID Karyawan");
	private JLabel nama_karyawan = new JLabel("Nama");
	private JLabel alamat_karyawan = new JLabel("Alamat");
	private JLabel tgl_karyawan = new JLabel("Tanggal Lahir");
	private JLabel id_divisi = new JLabel("ID Divisi");
	
	// textfield
	private JTextField id_kar = new JTextField();
	private JTextField nama_kar = new JTextField();
	private JTextField alamat_kar = new JTextField();
	private JTextField tgl_kar = new JTextField();
	private JTextField id_div = new JTextField();
	
	// button
	private JButton save = new JButton("Save");
	private JButton cancel = new JButton("Cancel");

	private JOptionPane jop = new JOptionPane();
	public insert_karyawan(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		id_karyawan.setBounds(20,20,100,20);
		id_kar.setBounds(130,20,100,20);
		nama_karyawan.setBounds(20,45,100,20);
		nama_kar.setBounds(130,45,100,20);
		alamat_karyawan.setBounds(20,70,100,20);
		alamat_kar.setBounds(130,70,100,20);
		tgl_karyawan.setBounds(20,95,100,20);
		tgl_kar.setBounds(130,95,100,20);
		id_divisi.setBounds(20,120,100,20);
		id_div.setBounds(130,120,100,20);
		save.setBounds(50,150,80,20);
		cancel.setBounds(140,150,80,20);
		
		kontainer.add(id_karyawan);
		kontainer.add(id_kar);
		kontainer.add(nama_karyawan);
		kontainer.add(nama_kar);
		kontainer.add(alamat_karyawan);
		kontainer.add(alamat_kar);
		kontainer.add(tgl_karyawan);
		kontainer.add(tgl_kar);
		kontainer.add(id_divisi);
		kontainer.add(id_div);
		kontainer.add(save);
		kontainer.add(cancel);
		
		run_karyawan rk = new run_karyawan();
		karyawan k = rk.id();
		id_kar.setText("K-" + k.getKode_kar());
		
		save.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					run_karyawan rk = new run_karyawan();
					rk.insert(id_kar.getText(), nama_kar.getText(), alamat_kar.getText(), tgl_kar.getText(), id_div.getText());
					id_kar.setText("");
					nama_kar.setText("");
					alamat_kar.setText("");
					tgl_kar.setText("");
					id_div.setText("");	
					karyawan k = rk.id();
					id_kar.setText("K-" + k.getKode_kar());
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
					nama_kar.setText("");
					alamat_kar.setText("");
					tgl_kar.setText("");
					id_div.setText("");			
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
		insert_karyawan ik = new insert_karyawan("Insert");
		ik.setVisible(true);
	}
}