package project_uas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class run_transaksi 
{
	private Connection koneksi;
	
	public run_transaksi()
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
	public transaksi gen_id()
	{
		transaksi id = null;
		try 
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*)+1 FROM TRANSAKSI");
			while(rs.next())
			{
				String id_new = rs.getString(1);
				id = new transaksi(id_new);	
			}
		}
		catch(SQLException e)
		{
			System.out.println("Username tidak ada");
		}
		return id;
	}
	
	public void insert(String kode_tra, String tanggal, String kode_kar, String kode_pel)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO TRANSAKSI(ID_TRANSAKSI, TANGGAL_TRANSAKSI, ID_KARYAWAN,ID_PELANGGAN) VALUES ('" + kode_tra + "','" + tanggal + "','" + kode_kar + "','" + kode_pel + "')");
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
	
	public List <transaksi> lihat_tahun(String tahun)
	{
		List <transaksi> daftarpenjualan = new ArrayList<transaksi>();
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TRANSAKSI WHERE SUBSTRING(TANGGAL_TRANSAKSI,25,4) = '" + tahun + "'");
			while(rs.next())
			{
				daftarpenjualan.add(new transaksi(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarpenjualan;
	}
	
	public List <transaksi> lihat_bulan(String tahun, String bulan)
	{
		List <transaksi> daftarpenjualan = new ArrayList<transaksi>();
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TRANSAKSI WHERE SUBSTRING(TANGGAL_TRANSAKSI,25,4) = '" + tahun + "' AND SUBSTRING(TANGGAL_TRANSAKSI,5,3) = '" + bulan + "'");
			while(rs.next())
			{
				daftarpenjualan.add(new transaksi(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarpenjualan;
	}
	public List <transaksi> lihat_tanggal(String tahun, String bulan, String tanggal)
	{
		List <transaksi> daftarpenjualan = new ArrayList<transaksi>();
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TRANSAKSI WHERE SUBSTRING(TANGGAL_TRANSAKSI,25,4) = '" + tahun + "' AND SUBSTRING(TANGGAL_TRANSAKSI,5,3) = '" + bulan + "' AND SUBSTRING(TANGGAL_TRANSAKSI,9,2) = '" + tanggal + "'");
			while(rs.next())
			{
				daftarpenjualan.add(new transaksi(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarpenjualan;
	}
	
	//
	public List <transaksi> pendapatan_tahun(String tahun)
	{
		List <transaksi> daftarpenjualan = new ArrayList<transaksi>();
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT TANGGAL_TRANSAKSI, SUM(SUB_TOTAL) FROM TRANSAKSI A, DATA_TRANSAKSI B WHERE SUBSTRING(TANGGAL_TRANSAKSI,25,4) = '" + tahun + "' AND A.ID_TRANSAKSI = B.ID_TRANSAKSI GROUP BY TANGGAL_TRANSAKSI");
			while(rs.next())
			{
				daftarpenjualan.add(new transaksi(rs.getDate(1),rs.getInt(2)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarpenjualan;
	}
	
	public List <transaksi> pendapatan_bulan(String tahun, String bulan)
	{
		List <transaksi> daftarpenjualan = new ArrayList<transaksi>();
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT TANGGAL_TRANSAKSI, SUM(SUB_TOTAL) FROM TRANSAKSI A, DATA_TRANSAKSI B WHERE SUBSTRING(TANGGAL_TRANSAKSI,25,4) = '" + tahun + "' AND SUBSTRING(TANGGAL_TRANSAKSI,5,3) = '" + bulan + "' AND A.ID_TRANSAKSI = B.ID_TRANSAKSI GROUP BY TANGGAL_TRANSAKSI");
			while(rs.next())
			{
				daftarpenjualan.add(new transaksi(rs.getDate(1),rs.getInt(2)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarpenjualan;
	}
	public List <transaksi> pendapatan_tanggal(String tahun, String bulan, String tanggal)
	{
		List <transaksi> daftarpenjualan = new ArrayList<transaksi>();
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT TANGGAL_TRANSAKSI, SUM(SUB_TOTAL) FROM TRANSAKSI A, DATA_TRANSAKSI B WHERE SUBSTRING(TANGGAL_TRANSAKSI,25,4) = '" + tahun + "' AND SUBSTRING(TANGGAL_TRANSAKSI,5,3) = '" + bulan + "' AND SUBSTRING(TANGGAL_TRANSAKSI,9,2) = '" + tanggal + "' AND A.ID_TRANSAKSI = B.ID_TRANSAKSI GROUP BY TANGGAL_TRANSAKSI");
			while(rs.next())
			{
				daftarpenjualan.add(new transaksi(rs.getDate(1),rs.getInt(2)));
			}
		}catch(SQLException e)
		{
			System.out.println("Data Tidak Ada");
		}
		return daftarpenjualan;
	}
}