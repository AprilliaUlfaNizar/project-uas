package project_uas;

import java.sql.*;
import java.util.Date;

public class run_karyawan 
{
	private Connection koneksi;
	
	public run_karyawan()
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
	
	public karyawan password(String username)
	{
		karyawan search_user = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM KARYAWAN WHERE NAMA_KARYAWAN = '" + username + "'");
			while(rs.next())
			{
				String id = rs.getString(1);
				String alamat = rs.getString(3);
				Date tgl = rs.getDate(4);
				String pass = rs.getString(5);
				String divisi = rs.getString(6);
				search_user = new karyawan(id, username, alamat, tgl, pass, divisi);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Username tidak ada");
		}
		return search_user;
	}
	
	public karyawan id()
	{
		karyawan gen_id = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*)+1 FROM KARYAWAN");
			while(rs.next())
			{
				String id = rs.getString(1);
				gen_id = new karyawan(id);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
		return gen_id;
	}
	
	public void insert(String id_kar, String nama_kar, String alamat, String tgl, String id_div)
	{
		try
		{
			String pass = id_kar;
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO KARYAWAN (ID_KARYAWAN, NAMA_KARYAWAN, ALAMAT, TANGGAL_LAHIR, PASSWORD, ID_DIVISI) VALUES ('" + id_kar + "','" + nama_kar + "','" + alamat + "','" + tgl + "','" + pass + "','" + id_div + "')");
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
	
	public karyawan search_kode(String kode_kar)
	{
		karyawan search_id = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM KARYAWAN WHERE ID_KARYAWAN = '" + kode_kar + "'");
			while(rs.next())
			{
				String nama = rs.getString(2);
				String alamat = rs.getString(3);
				Date tgl = rs.getDate(4);
				String pass = rs.getString(5);
				String kode_div = rs.getString(6);
				search_id = new karyawan(kode_kar, nama, alamat, tgl, pass, kode_div);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
		return search_id;
	}
	
	public void update(String kode_kar, String nama_kar, String alamat, String tgl, String id_div)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE KARYAWAN SET ID_KARYAWAN = '" + kode_kar + "', NAMA_KARYAWAN = '" + nama_kar + "', ALAMAT = '" + alamat + "', TANGGAL_LAHIR = '" + tgl + "', ID_DIVISI = '" + id_div + "' WHERE ID_KARYAWAN = '" + kode_kar + "'");
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
	
	public void delete(String kode_kar)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM KARYAWAN WHERE ID_KARYAWAN = '" + kode_kar + "'");
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
	
	public void update_pass(String kode_kar, String pass)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("UPDATE KARYAWAN SET PASSWORD = '" + pass + "' WHERE ID_KARYAWAN = '" + kode_kar + "'");
			while(rs.next())
			{
				System.out.println("Data berhasil dirubah");
			}
		}
		catch(Exception a)
		{
			
		}
	}
	
	public karyawan search_nama(String nama)
	{
		karyawan search_nm = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM KARYAWAN WHERE NAMA_KARYAWAN = '" + nama + "'");
			while(rs.next())
			{
				String kode_kar = rs.getString(1);
				String alamat = rs.getString(3);
				Date tgl = rs.getDate(4);
				String pass = rs.getString(5);
				String kode_div = rs.getString(6);
				search_nm = new karyawan(kode_kar, nama, alamat, tgl, pass, kode_div);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Data Tidak Valid");
		}
		return search_nm;
	}
}