package project_uas;

public class pelanggan 
{
	private String kode_pel;
	private String nama_pel;
	private String alamat_pel;
	
	
	
	public pelanggan(String id_pel) 
	{
		super();
		this.kode_pel = id_pel;
	}

	public pelanggan(String id_pel, String nama_pel, String alamat_pel) 
	{
		super();
		this.kode_pel = id_pel;
		this.nama_pel = nama_pel;
		this.alamat_pel = alamat_pel;
	}

	@Override
	public String toString() 
	{
		return kode_pel + nama_pel + alamat_pel;
	}

	public String getId_pel() 
	{
		return kode_pel;
	}

	public void setId_pel(String id_pel) 
	{
		this.kode_pel = id_pel;
	}

	public String getNama_pel() 
	{
		return nama_pel;
	}

	public void setNama_pel(String nama_pel) 
	{
		this.nama_pel = nama_pel;
	}

	public String getAlamat_pel() 
	{
		return alamat_pel;
	}

	public void setAlamat_pel(String alamat_pel) 
	{
		this.alamat_pel = alamat_pel;
	}
}