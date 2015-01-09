package project_uas;

public class suplier 
{
	private String kode_sup;
	private String nama_sup;
	
	public suplier(String kode_sup) 
	{
		super();
		this.kode_sup = kode_sup;
	}

	public suplier(String kode_sup, String nama_sup) 
	{
		super();
		this.kode_sup = kode_sup;
		this.nama_sup = nama_sup;
	}

	@Override
	public String toString() 
	{
		return kode_sup + nama_sup;
	}

	public String getKode_sup() 
	{
		return kode_sup;
	}

	public void setKode_sup(String kode_sup) 
	{
		this.kode_sup = kode_sup;
	}

	public String getNama_sup() 
	{
		return nama_sup;
	}

	public void setNama_sup(String nama_sup) 
	{
		this.nama_sup = nama_sup;
	}
}