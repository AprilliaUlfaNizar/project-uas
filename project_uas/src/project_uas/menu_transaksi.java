package project_uas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.*;


public class menu_transaksi extends JFrame 
{
	private static final int lebar = 1000;
	private static final int tinggi = 520;
	private static final int posisi_x = 200;
	private static final int posisi_y = 100;
	
	private JLabel id_combo = new JLabel("ID Produk");
	private JComboBox id_box = new JComboBox();
	
	private JLabel id_produk = new JLabel("ID Produk");
	private JLabel nama_produk = new JLabel("Nama");
	private JLabel harga_produk = new JLabel("Harga");
	private JLabel jumlah_produk = new JLabel("Jumlah");
	private JTextField id_pro = new JTextField();
	private JTextField nama_pro = new JTextField();
	private JTextField harga_pro = new JTextField();
	private JTextField jumlah_pro = new JTextField();
	
	private JLabel id_transaksi = new JLabel("ID Transaksi");
	private JLabel tgl_transaksi = new JLabel("Tanggal Transaksi");
	private JLabel id_karyawan = new JLabel("ID Karyawan");
	private JLabel id_pelanggan = new JLabel("ID Pelanggan");
	private JTextField id_tra = new JTextField();
	private JTextField tgl_tra = new JTextField();
	private JTextField id_kar = new JTextField();
	private JTextField id_pel = new JTextField();
	
	private JLabel total = new JLabel("Total");
	private JLabel uang = new JLabel("Uang");
	private JLabel kembali = new JLabel("Kembalian");
	private JTextField tot = new JTextField();
	private JTextField uan = new JTextField();
	private JTextField kem = new JTextField();
	
	private JTable d_tra;
	private DefaultTableModel dtm;
	private String header[] = {"ID Produk", "Nama Produk", "Jumlah", "Harga", "Sub Total"};
	
	private JButton ok = new JButton("Ok");
	private JButton cek = new JButton("Cek");
	private JButton buy = new JButton("Buy");
	private JButton cancel = new JButton("Cancel");
	
	private Vector id = new Vector();
	private Vector nama = new Vector();
	private Vector harga = new Vector();
	private Vector jumlah = new Vector();
	private Vector sub_total = new Vector();

	private JOptionPane jop = new JOptionPane();
	public menu_transaksi(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		run_produk rp = new run_produk();
		List <produk> hasilAll = rp.viewAll();
		for(produk p:hasilAll)
		{
			id_box.addItem(p.getKode_pro());
		}
		
		dtm = new DefaultTableModel(null, header);
		d_tra = new JTable(dtm);
		d_tra.setModel(dtm);

		JScrollPane scroll = new JScrollPane(d_tra);
		scroll.setBounds(10,70,700,400);
		scroll.setViewportView(d_tra);
		
		scroll.setEnabled(false);
		id_pro.setEditable(false);
		nama_pro.setEditable(false);
		harga_pro.setEditable(false);
		id_tra.setEditable(false);
		tgl_tra.setEditable(false);
		id_kar.setEditable(false);
		tot.setEditable(false);
		kem.setEditable(false);
		
		id_combo.setBounds(10,10,100,20);
		id_box.setBounds(70,10,70,20);
		
		id_produk.setBounds(10,35,100,20);
		id_pro.setBounds(70,35,70,20);
		nama_produk.setBounds(150,35,100,20);
		nama_pro.setBounds(190,35,200,20);
		harga_produk.setBounds(400,35,100,20);
		harga_pro.setBounds(450,35,70,20);
		jumlah_produk.setBounds(530,35,100,20);
		jumlah_pro.setBounds(580,35,70,20);
		ok.setBounds(660,35,50,20);
		
		id_transaksi.setBounds(720,70,100,20);
		id_tra.setBounds(830,70,100,20);
		tgl_transaksi.setBounds(720,95,150,20);
		tgl_tra.setBounds(830,95,100,20);
		id_karyawan.setBounds(720,120,150,20);
		id_kar.setBounds(830,120,100,20);
		id_pelanggan.setBounds(720,145,150,20);
		id_pel.setBounds(830,145,100,20);
		
		total.setBounds(720,200,100,20);
		tot.setBounds(790,200,100,20);
		uang.setBounds(720,225,100,20);
		uan.setBounds(790,225,100,20);
		kembali.setBounds(720,250,100,20);
		kem.setBounds(790,250,100,20);
		cek.setBounds(900,250,60,20);
		
		buy.setBounds(720,300,80,20);
		cancel.setBounds(820,300,80,20);
		
		kontainer.add(id_combo);
		kontainer.add(id_box);
		
		kontainer.add(id_produk);
		kontainer.add(id_pro);
		kontainer.add(nama_produk);
		kontainer.add(nama_pro);
		kontainer.add(harga_produk);
		kontainer.add(harga_pro);
		kontainer.add(jumlah_produk);
		kontainer.add(jumlah_pro);
		kontainer.add(ok);
		
		kontainer.add(scroll);
		
		kontainer.add(id_transaksi);
		kontainer.add(id_tra);
		kontainer.add(tgl_transaksi);
		kontainer.add(tgl_tra);
		kontainer.add(id_karyawan);
		kontainer.add(id_kar);
		kontainer.add(id_pelanggan);
		kontainer.add(id_pel);
		
		kontainer.add(total);
		kontainer.add(tot);
		kontainer.add(uang);
		kontainer.add(uan);
		kontainer.add(kembali);
		kontainer.add(kem);
		kontainer.add(cek);
		
		kontainer.add(buy);
		kontainer.add(cancel);
		
		run_transaksi rt = new run_transaksi();
		transaksi t = rt.gen_id();
		id_tra.setText("TRX-" + t.getKode_transaksi());
		
		tanggal tgl = new tanggal();
		tgl_tra.setText(tgl.getDay());
		
		
		menu_login ml = new menu_login("");
		run_karyawan rk = new run_karyawan();
		karyawan k = rk.search_nama(ml.log_user);
		id_kar.setText(k.getKode_kar());
		
		id_box.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					run_produk rp = new run_produk();
					produk p = rp.search_kode(id_box.getSelectedItem().toString());
					
					id_pro.setText(p.getKode_pro());
					nama_pro.setText(p.getNama_pro());
					harga_pro.setText(String.valueOf(p.getHarga()));
					
					jumlah_pro.setText("");
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
		
		ok.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					int bayar = Integer.parseInt(harga_pro.getText()) * Integer.parseInt(jumlah_pro.getText());
					
					id.add(id_pro.getText());
					nama.add(nama_pro.getText());
					harga.add(harga_pro.getText());
					jumlah.add(jumlah_pro.getText());
					sub_total.add(bayar);
					
					Object obj[] = new Object[5];
					obj[0] = id_pro.getText();
					obj[1] = nama_pro.getText();
					obj[2] = harga_pro.getText();
					obj[3] = jumlah_pro.getText();
					obj[4] = bayar;
					
					dtm.addRow(obj);
					
					int hitung = 0;
					for(int a = 0; a < id.size(); a++)
					{
						hitung = hitung + Integer.parseInt(sub_total.elementAt(a).toString());
					}
					
					tot.setText(String.valueOf(hitung));
					
					id_pro.setText("");
					nama_pro.setText("");
					harga_pro.setText("");
					jumlah_pro.setText("");					
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		cek.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					int kembali = 0;
					kembali = Integer.parseInt(uan.getText()) - Integer.parseInt(tot.getText());
					kem.setText(String.valueOf(kembali));
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		buy.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if(Integer.parseInt(kem.getText()) >= 0)
					{
						run_transaksi rt = new run_transaksi();
						rt.insert(id_tra.getText(), tgl_tra.getText(), id_kar.getText(), id_pel.getText());
						
						for(int a = 0; a < id.size(); a++)
						{
							run_data_transaksi rdt = new run_data_transaksi();
							rdt.insert(id_tra.getText(), id.elementAt(a).toString(), Integer.parseInt(jumlah.elementAt(a).toString()), Integer.parseInt(sub_total.elementAt(a).toString()));
						}
						
						for(int a = 0; a < id.size(); a++)
						{
							run_produk rp = new run_produk();
							produk p = rp.search_kode(id.elementAt(a).toString());
							
							int stok = p.getStok() - Integer.parseInt(jumlah.elementAt(a).toString());
							
							rp.update_stok(id.elementAt(a).toString(), stok);
						}
						
						id = new Vector();
						nama = new Vector();
						harga = new Vector();
						jumlah = new Vector();
						sub_total = new Vector();
						
						id_pel.setText("");
						
						tot.setText("");
						uan.setText("");
						kem.setText("");
						
						int baris = dtm.getRowCount();
						for(int a=0; a < baris; a++)
						{
							dtm.removeRow(0);
						}
						
						run_transaksi rt1 = new run_transaksi();
						transaksi t = rt1.gen_id();
						id_tra.setText("TRX-" + t.getKode_transaksi());
						
						jop.showConfirmDialog(null, "Penjualan Berhasil Ditambah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
					}
					else
					{
						jop.showConfirmDialog(null, "Maaf Uang Anda Kurang", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
					}
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
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
					id = new Vector();
					nama = new Vector();
					harga = new Vector();
					jumlah = new Vector();
					sub_total = new Vector();
					
					id_pel.setText("");
					
					tot.setText("");
					uan.setText("");
					kem.setText("");
					
					id_pro.setText("");
					nama_pro.setText("");
					harga_pro.setText("");
					jumlah_pro.setText("");
					
					int baris = dtm.getRowCount();
					for(int a=0; a < baris; a++)
					{
						dtm.removeRow(0);
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
		menu_transaksi t = new menu_transaksi("");
		t.setVisible(true);
	}
}