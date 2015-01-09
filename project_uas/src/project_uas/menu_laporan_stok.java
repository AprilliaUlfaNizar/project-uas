package project_uas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class menu_laporan_stok extends JFrame
{
	private static final int lebar = 700;
	private static final int tinggi = 350;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	private JLabel id_pro = new JLabel("ID Produk");
	private JLabel jumlah_pro = new JLabel("Jumlah");
	private JTextField id = new JTextField();
	private JTextField jml = new JTextField();
	
	private JTable d_tra;
	private DefaultTableModel dtm;
	private String header[] = {"ID Produk", "Stok"};
	
	private JButton tambah = new JButton("ADD");
	
	private JOptionPane jop = new JOptionPane();
	public menu_laporan_stok(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		dtm = new DefaultTableModel(null, header);
		d_tra = new JTable(dtm);
		d_tra.setModel(dtm);

		JScrollPane scroll = new JScrollPane(d_tra);
		scroll.setBounds(10,10,470,300);
		scroll.setViewportView(d_tra);
		
		id_pro.setBounds(500,10,100,20);
		id.setBounds(560,10,100,20);
		jumlah_pro.setBounds(500,35,100,20);
		jml.setBounds(560,35,100,20);
		tambah.setBounds(570,60,80,20);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		kontainer.add(scroll);
		kontainer.add(id_pro);
		kontainer.add(id);
		kontainer.add(jumlah_pro);
		kontainer.add(jml);
		kontainer.add(tambah);
		
		run_produk rp = new run_produk();
		List <produk> hasilAll = rp.stok();
		for(produk p:hasilAll)
		{
			Object obj[] = new Object[2];
			obj[0] = p.getKode_pro();
			obj[1] = p.getStok();
			
			dtm.addRow(obj);
		}
		
		tambah.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					run_produk rp = new run_produk();
					produk p = rp.search_kode(id.getText());
					int stok = p.getStok() + Integer.parseInt(jml.getText());
					rp.update_stok(id.getText(), stok);
					
					int baris = dtm.getRowCount();
					if(baris >= 0)
					{
						for(int a=0; a < baris; a++)
						{
							dtm.removeRow(0);
						}
					}
					
					List <produk> hasilAll = rp.stok();
					for(produk pq:hasilAll)
					{
						Object obj[] = new Object[2];
						obj[0] = pq.getKode_pro();
						obj[1] = pq.getStok();
						
						dtm.addRow(obj);
					}
					
					id.setText("");
					jml.setText("");
					jop.showConfirmDialog(null, "Stok Berhasil Ditambah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
	}
	public static void main(String [] args)
	{
		menu_laporan_stok mlp = new menu_laporan_stok("");
		mlp.setVisible(true);
	}
}
