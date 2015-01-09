package project_uas;

import java.sql.*;

public class run_data_transaksi 
{
private Connection koneksi;
	
	public run_data_transaksi()
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
	public void insert(String kode_tra, String kode_pro, int jumlah, int sub_total)
	{
		try
		{
			Statement stmt = koneksi.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO DATA_TRANSAKSI(ID_TRANSAKSI, ID_PRODUK, JUMLAH, SUB_TOTAL) VALUES ('" + kode_tra + "','" + kode_pro + "','" + jumlah + "','" + sub_total + "')");
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
}