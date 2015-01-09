package project_uas;

import java.sql.*;

public class run_pelanggan 
{
	private Connection koneksi;
	
	public run_pelanggan()
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
	
	public pelanggan id()
	{
		pelanggan gen_id = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*)+1 FROM PELANGGAN");
			while(rs.next())
			{
				String id = rs.getString(1);
				gen_id = new pelanggan(id);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
		return gen_id;
	}
	
	public void insert(String id_pel, String nama_pel, String alamat)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO PELANGGAN(ID_PELANGGAN, NAMA_PELANGGAN, ALAMAT) VALUES('" + id_pel + "','" + nama_pel + "','" + alamat + "')");
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
	
	public pelanggan search_kode(String kode_pel)
	{
		pelanggan search_id = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PELANGGAN WHERE ID_PELANGGAN = '" + kode_pel + "'");
			while(rs.next())
			{
				String nama = rs.getString(2);
				String alamat = rs.getString(3);
				search_id = new pelanggan(kode_pel, nama, alamat);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
		return search_id;
	}
	
	public void update(String kode_pel, String nama_pel, String alamat)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE PELANGGAN SET ID_PELANGGAN = '" + kode_pel + "', NAMA_PELANGGAN = '" + nama_pel + "', ALAMAT = '" + alamat +  "' WHERE ID_PELANGGAN = '" + kode_pel + "'");
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
	
	public void delete(String kode_pel)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM PELANGGAN WHERE ID_PELANGGAN = '" + kode_pel + "'");
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
}