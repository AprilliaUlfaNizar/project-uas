package project_uas;

public class produk 
{
	private String kode_pro;
	private String nama_pro;
	private String kode_sup;
	private int harga;
	private int stok;
	
	public produk(String kode_pro) 
	{
		super();
		this.kode_pro = kode_pro;
	}
	
	public produk(String kode_pro, String nama_pro, String kode_sup, int harga, int stok) 
	{
		super();
		this.kode_pro = kode_pro;
		this.nama_pro = nama_pro;
		this.harga = harga;
		this.stok = stok;
		this.kode_sup = kode_sup;
	}

	@Override
	public String toString() 
	{
		return  kode_pro + nama_pro + harga + stok + kode_sup;
	}

	public String getKode_pro() 
	{
		return kode_pro;
	}

	public void setKode_pro(String kode_pro) 
	{
		this.kode_pro = kode_pro;
	}

	public String getNama_pro() 
	{
		return nama_pro;
	}

	public void setNama_pro(String nama_pro) 
	{
		this.nama_pro = nama_pro;
	}

	public int getHarga() 
	{
		return harga;
	}

	public void setHarga(int harga) 
	{
		this.harga = harga;
	}

	public int getStok() 
	{
		return stok;
	}

	public void setStok(int stok) 
	{
		this.stok = stok;
	}

	public String getKode_sup() 
	{
		return kode_sup;
	}

	public void setKode_sup(String kode_sup) 
	{
		this.kode_sup = kode_sup;
	}
}