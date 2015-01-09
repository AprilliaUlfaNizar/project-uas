package project_uas;

import java.sql.*;

public class run_suplier 
{
	private Connection koneksi;
	
	public run_suplier()
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
	
	public suplier id()
	{
		suplier gen_id = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*)+1 FROM SUPLIER");
			while(rs.next())
			{
				String id = rs.getString(1);
				gen_id = new suplier(id);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
		return gen_id;
	}
	
	public void insert(String kode_sup, String nama_sup)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO SUPLIER(ID_SUPLIER, NAMA_SUPLIER) VALUES('" + kode_sup + "','" + nama_sup + "')");
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
	
	public suplier search_kode(String kode_sup)
	{
		suplier search_id = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SUPLIER WHERE ID_SUPLIER = '" + kode_sup + "'");
			while(rs.next())
			{
				String nama = rs.getString(2);
				search_id = new suplier(kode_sup, nama);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
		return search_id;
	}
	
	public void update(String kode_sup, String nama_sup)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE SUPLIER SET ID_SUPLIER = '" + kode_sup + "', NAMA_SUPLIER = '" + nama_sup + "' WHERE ID_SUPLIER = '" + kode_sup + "'");
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
	
	public void delete(String kode_sup)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM SUPLIER WHERE ID_SUPLIER = '" + kode_sup + "'");
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