package project_uas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class run_produk 
{
	private Connection koneksi;
	
	public run_produk()
	{
		try
		{
			Class.forName(config.database_driver).newInstance();
			koneksi = DriverManager.getConnection(config.url,config.username,config.password);
		}
		catch (Exception e)
		{
			System.out.println("Koneksi Gagal");
		}
	}
	
	public produk id()
	{
		produk gen_id = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*)+1 FROM PRODUK");
			while(rs.next())
			{
				String id = rs.getString(1);
				gen_id = new produk(id);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
		return gen_id;
	}
	
	public void insert(String kode_pro, String nama_pro, String kode_sup, int harga, int stok)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO PRODUK(ID_PRODUK, NAMA_PRODUK, ID_SUPLIER, HARGA, STOK) VALUES('" + kode_pro + "','" + nama_pro + "','" + kode_sup + "','" + harga + "','" + stok + "')");
			while(rs.next())
			{
				System.out.println("Data Berhasil dimasukan");
			}
		}
		catch(Exception a)
		{
			System.out.println("Data Tidak Valid");
		}
	}
	
	public produk search_kode(String kode_pro)
	{
		produk search_id = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUK WHERE ID_PRODUK = '" + kode_pro + "'");
			while(rs.next())
			{
				String nama = rs.getString(2);
				String kode_sup = rs.getString(3);
				int harga = rs.getInt(4);
				int stok = rs.getInt(5);
				search_id = new produk(kode_pro, nama,  kode_sup, harga, stok);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
		return search_id;
	}
	
	public void update(String kode_pro, String nama_pro, String kode_sup, int harga, int stok)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE PRODUK SET ID_PRODUK = '" + kode_pro + "', NAMA_PRODUK = '" + nama_pro + "', ID_SUPLIER = '" + kode_sup + "', HARGA = '" + harga + "', STOK = '" + stok + "' WHERE ID_PRODUK = '" + kode_pro + "'");
			while(rs.next())
			{
				System.out.println("Data Berhasil dimasukan");
			}
		}
		catch(Exception a)
		{
			System.out.println("Data Tidak Valid");
		}
	}
	
	public void delete(String kode_pro)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM PRODUK WHERE ID_PRODUK = '" + kode_pro + "'");
			while(rs.next())
			{
				System.out.println("Data Berhasil dihapus");
			}
		}
		catch(Exception a)
		{
			System.out.println("Data Tidak Valid");
		}
	}
	
	public void update_stok(String kode_pro, int stok)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE PRODUK SET STOK = '" + stok + "' WHERE ID_PRODUK = '" + kode_pro + "'");
			while(rs.next())
			{
				System.out.println("Data Berhasil dimasukan");
			}
		}
		catch(Exception a)
		{
			System.out.println("Data Tidak Valid");
		}
	}
	
	public List<produk> viewAll()
	{
		List <produk> daftarProduk = new ArrayList<produk>();
		try
		{
			Statement stmt=koneksi.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM PRODUK");
			while(rs.next())
			{
				daftarProduk.add(new produk(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return daftarProduk;
	}
	
	public List<produk> stok()
	{
		List <produk> daftarProduk = new ArrayList<produk>();
		try
		{
			Statement stmt=koneksi.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM PRODUK WHERE STOK < 100");
			while(rs.next())
			{
				daftarProduk.add(new produk(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return daftarProduk;
	}
}