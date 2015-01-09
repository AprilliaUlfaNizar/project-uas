package project_uas;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class menu_laporan_penjualan extends JFrame
{
	private static final int lebar = 700;
	private static final int tinggi = 350;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	private JLabel tahun = new JLabel("Tahun");
	private JLabel bulan = new JLabel("Bulan");
	private JLabel tanggal = new JLabel("Tanggal");
	private JTextField thn = new JTextField();
	private JTextField bln = new JTextField();
	private JTextField tgl = new JTextField();
	
	private JTable d_tra;
	private DefaultTableModel dtm;
	private String header[] = {"ID Transaksi", "Tanggal Transaksi", "ID Karyawan", "ID Pelanggan"};
	
	private JButton view = new JButton("View");
	
	public menu_laporan_penjualan(String judul)
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
		
		tahun.setBounds(500,10,100,20);
		thn.setBounds(560,10,100,20);
		bulan.setBounds(500,35,100,20);
		bln.setBounds(560,35,100,20);
		tanggal.setBounds(500,60,100,20);
		tgl.setBounds(560,60,100,20);
		view.setBounds(570,85,80,20);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		kontainer.add(scroll);
		kontainer.add(tahun);
		kontainer.add(thn);
		kontainer.add(bulan);
		kontainer.add(bln);
		kontainer.add(tanggal);
		kontainer.add(tgl);
		kontainer.add(view);
		
		view.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					int month = 0;
					String moon = null;
					
					if(bln.getText().equalsIgnoreCase(""))
					{
						month = 0;
					}
					else
					{
						month = Integer.parseInt(bln.getText());
					}
					
					switch(month)
					{
						case 0:
							moon = "";
							break;
						case 1:
							moon = "Jan";
							break;
						case 2:
							moon = "Feb";
							break;
						case 3:
							moon = "Mar";
							break;
						case 4:
							moon = "Apr";
							break;
						case 5:
							moon = "May";
							break;
						case 6:
							moon = "Jun";
							break;
						case 7:
							moon = "Jul";
							break;
						case 8:
							moon = "Aug";
							break;
						case 9:
							moon = "Sep";
							break;
						case 10:
							moon = "Oct";
							break;
						case 11:
							moon = "Nov";
							break;
						case 12:
							moon = "Dec";
							break;
					}
					
					String year = thn.getText();
					String day = tgl.getText();
					
					run_transaksi rt = new run_transaksi();
					
					
					int baris = dtm.getRowCount();
					if(baris >= 0)
					{
						for(int a=0; a < baris; a++)
						{
							dtm.removeRow(0);
						}
					}
					
					if(year.length() != 0)
					{
						if(moon.length() != 0)
						{
							if(day.length() != 0)
							{
								List <transaksi> hasilAll = rt.lihat_tanggal(String.valueOf(year),moon,String.valueOf(day));
								for(transaksi t:hasilAll)
								{
									Object obj[] = new Object[4];
									obj[0] = t.getKode_transaksi();
									obj[1] = t.getTanggal();
									obj[2] = t.getKode_karyawan();
									obj[3] = t.getKode_pelanggan();
									
									dtm.addRow(obj);
								}
							}
							else
							{
								List <transaksi> hasilAll = rt.lihat_bulan(String.valueOf(year), moon);
								for(transaksi t:hasilAll)
								{
									Object obj[] = new Object[4];
									obj[0] = t.getKode_transaksi();
									obj[1] = t.getTanggal();
									obj[2] = t.getKode_karyawan();
									obj[3] = t.getKode_pelanggan();
									
									dtm.addRow(obj);
								}
							}
						}
						else
						{
							List <transaksi> hasilAll = rt.lihat_tahun(String.valueOf(year));
							for(transaksi t:hasilAll)
							{
								Object obj[] = new Object[4];
								obj[0] = t.getKode_transaksi();
								obj[1] = t.getTanggal();
								obj[2] = t.getKode_karyawan();
								obj[3] = t.getKode_pelanggan();
								
								dtm.addRow(obj);
							}
						}
					}
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
		menu_laporan_penjualan mlp = new menu_laporan_penjualan("");
		mlp.setVisible(true);
	}
}
