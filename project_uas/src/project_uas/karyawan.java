package project_uas;

import java.util.*;

public class karyawan 
{
	private String kode_kar;
	private String nama_kar;
	private String alamat_kar;
	private Date tgl ;
	private String password;
	private String kode_div;
	
	public karyawan(String kode_kar) 
	{
		super();
		this.kode_kar = kode_kar;
	}

	public karyawan(String kode_kar, String nama_kar, String alamat_kar, Date tgl, String password, String kode_div) 
	{
		super();
		this.kode_kar = kode_kar;
		this.nama_kar = nama_kar;
		this.alamat_kar = alamat_kar;
		this.tgl = tgl;
		this.password = password;
		this.kode_div = kode_div;
	}

	@Override
	public String toString() 
	{
		return kode_kar + nama_kar + alamat_kar + tgl + kode_div;
	}

	public String getKode_kar() 
	{
		return kode_kar;
	}

	public void setKode_kar(String kode_kar) 
	{
		this.kode_kar = kode_kar;
	}

	public String getNama_kar() 
	{
		return nama_kar;
	}

	public void setNama_kar(String nama_kar) 
	{
		this.nama_kar = nama_kar;
	}

	public String getAlamat_kar() 
	{
		return alamat_kar;
	}

	public void setAlamat_kar(String alamat_kar) 
	{
		this.alamat_kar = alamat_kar;
	}

	public Date getTgl() 
	{
		return tgl;
	}

	public void setTgl(Date tgl) 
	{
		this.tgl = tgl;
	}
	
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getKode_div() 
	{
		return kode_div;
	}

	public void setKode_div(String kode_div) 
	{
		this.kode_div = kode_div;
	}	
}