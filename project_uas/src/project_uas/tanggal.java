package project_uas;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class tanggal 
{
	
	private String day;

	public tanggal() 
	{
		super();
	}
	
	public String getDay()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		day = dateFormat.format(date);
		return day;
	}

	public void setDay(String day) 
	{
		this.day = day;
	}
}