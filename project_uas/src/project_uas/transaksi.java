package project_uas;

import java.util.Date;

public class transaksi 
{
	private String kode_tra;
	private Date tanggal;
	private String kode_kar;
	private String kode_pel;
	private int total;
	
	@Override
	public String toString() {
		return kode_tra + tanggal + kode_kar + kode_pel;
	}

	public transaksi() 
	{
		super();
	}
	
	public transaksi(Date tanggal, int total) 
	{
		super();
		this.tanggal = tanggal;
		this.total = total;
	}

	public transaksi(String kode_transaksi) 
	{
		super();
		this.kode_tra = kode_transaksi;
	}

	public transaksi(String kode_transaksi, Date tanggal, String kode_karyawan, String kode_pelanggan) 
	{
		super();
		this.kode_tra = kode_transaksi;
		this.tanggal = tanggal;
		this.kode_kar = kode_karyawan;
		this.kode_pel = kode_pelanggan;
	}

	public String getKode_transaksi() 
	{
		return kode_tra;
	}

	public void setKode_transaksi(String kode_transaksi) 
	{
		this.kode_tra = kode_transaksi;
	}

	public Date getTanggal()
	{
		return tanggal;
	}

	public void setTanggal(Date tanggal) 
	{
		this.tanggal = tanggal;
	}

	public String getKode_karyawan() 
	{
		return kode_kar;
	}

	public void setKode_karyawan(String kode_karyawan) 
	{
		this.kode_kar = kode_karyawan;
	}

	public String getKode_pelanggan() 
	{
		return kode_pel;
	}

	public void setKode_pelanggan(String kode_pelanggan) 
	{
		this.kode_pel = kode_pelanggan;
	}
	
	public int getTotal() 
	{
		return total;
	}

	public void setTotal(int total) 
	{
		this.total = total;
	}
}