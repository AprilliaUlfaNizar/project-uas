package project_uas;

public class data_transaksi 
{
	private String kode_tra;
	private String kode_pro;
	private int jumlah;
	private int sub_total;
	
	public data_transaksi(String kode_tra, String kode_pro, int jumlah,	int sub_total) 
	{
		super();
		this.kode_tra = kode_tra;
		this.kode_pro = kode_pro;
		this.jumlah = jumlah;
		this.sub_total = sub_total;
	}

	@Override
	public String toString() {
		return kode_tra + kode_pro + jumlah + sub_total;
	}

	public String getKode_tra() 
	{
		return kode_tra;
	}

	public void setKode_tra(String kode_tra) 
	{
		this.kode_tra = kode_tra;
	}

	public String getKode_pro() 
	{
		return kode_pro;
	}

	public void setKode_pro(String kode_pro) 
	{
		this.kode_pro = kode_pro;
	}

	public int getJumlah() 
	{
		return jumlah;
	}

	public void setJumlah(int jumlah) 
	{
		this.jumlah = jumlah;
	}

	public int getSub_total() 
	{
		return sub_total;
	}

	public void setSub_total(int sub_total) 
	{
		this.sub_total = sub_total;
	}
}