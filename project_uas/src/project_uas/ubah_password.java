package project_uas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ubah_password extends JFrame 
{
	private static final int lebar = 400;
	private static final int tinggi = 200;
	private static final int posisi_x = 150;
	private static final int posisi_y = 250;
	
	private JLabel password_lama = new JLabel("Password Lama");
	private JLabel password_baru = new JLabel("Password Baru");
	private JPasswordField pass_lama = new JPasswordField();
	private JPasswordField pass_baru = new JPasswordField();
	
	private JButton save = new JButton("Save");
	private JButton cancel = new JButton("Cancel");
		
	private JOptionPane jop = new JOptionPane();
	public ubah_password(String judul)
	{
		super(judul);
		setSize(lebar,tinggi);
		setLocation(posisi_x,posisi_y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Container kontainer = getContentPane();
		kontainer.setLayout(null);
		
		password_lama.setBounds(20, 30, 100, 20);
		pass_lama.setBounds(130, 30, 100,20);
		password_baru.setBounds(20, 55, 100, 20);
		pass_baru.setBounds(130, 55, 100,20);
		save.setBounds(40,90,80,20);
		cancel.setBounds(130,90,80,20);
		
		kontainer.add(password_lama);
		kontainer.add(pass_lama);		
		kontainer.add(password_baru);
		kontainer.add(pass_baru);
		kontainer.add(save);
		kontainer.add(cancel);
		
		save.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					menu_login ml = new menu_login("Login");
					run_karyawan uk = new run_karyawan();
					karyawan k = uk.password(ml.log_user);
					
					if(pass_lama.getText().equalsIgnoreCase(k.getPassword()))
					{
						String p_new = pass_baru.getText();
						if(p_new.length() != 0)
						{
							uk.update_pass(k.getKode_kar(), pass_baru.getText());
							pass_lama.setText("");
							pass_baru.setText("");
							
							jop.showConfirmDialog(null, "Data Berhasil Dirubah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
						}
						else
						{
							jop.showConfirmDialog(null, "Password Tidak Boleh Kosong", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
						}
					}
					else
					{
						jop.showConfirmDialog(null, "Password Lama Salah", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
					}
				}
				catch(Exception a)
				{
					jop.showConfirmDialog(null, "Data Tidak Valid", "Information Message", jop.DEFAULT_OPTION, jop.INFORMATION_MESSAGE);
				}
			}
		}
		);
		
		cancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					pass_lama.setText("");
					pass_baru.setText("");
				}
				catch(Exception a)
				{
					System.out.println("Data tidak ada");
				}
			}
		}
		);
	}
	public static void main(String [] args)
	{
		ubah_password up =new ubah_password("");
		up.setVisible(true);
	}
}