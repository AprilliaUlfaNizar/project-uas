package project_uas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class insert_suplier extends JFrame 
{
	//public static String log_pass;
	private static final int lebar = 280;
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
	private JButton save = new JButton("Save");
	private JButton cancel = new JButton("Cancel");
	
	private JOptionPane jop = new JOptionPane();
	public insert_suplier(String judul)
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
		nama_suplier.setBounds(20,45,100,20);
		nama_sup.setBounds(130,45,100,20);
		save.setBounds(50,150,80,20);
		cancel.setBounds(140,150,80,20);
		
		kontainer.add(id_suplier);
		kontainer.add(id_sup);
		kontainer.add(nama_suplier);
		kontainer.add(nama_sup);
		kontainer.add(save);
		kontainer.add(cancel);
		
		run_suplier rs = new run_suplier();
		suplier s = rs.id();
		id_sup.setText("S-" + s.getKode_sup());
		
		save.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					run_suplier rs = new run_suplier();
					rs.insert(id_sup.getText(), nama_sup.getText());
					id_sup.setText("");
					nama_sup.setText("");
					suplier s = rs.id();
					id_sup.setText("S-" + s.getKode_sup());
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
					nama_sup.setText("");
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
		insert_suplier is = new insert_suplier("Insert");
		is.setVisible(true);
	}
}