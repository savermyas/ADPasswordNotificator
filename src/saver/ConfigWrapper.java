package saver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigWrapper 
{
	static File configfile = new File("config.xml");
	public static Properties prop = new Properties();
	
	@SuppressWarnings("deprecation")
	public static void changeProp()
	{
		prop.setProperty("domain", MainTray.optionsDialog.domainField.getText());
		prop.setProperty("domaincontroler",MainTray.optionsDialog.jTextField1.getText());
		prop.setProperty("username",MainTray.optionsDialog.jTextField2.getText());
		prop.setProperty("password",MainTray.optionsDialog.jPasswordField.getText());
		prop.setProperty("basedn",MainTray.optionsDialog.jTextField6.getText());
		prop.setProperty("sheduletype",Integer.toString(MainTray.optionsDialog.jComboBox.getSelectedIndex()));
		prop.setProperty("hour",Integer.toString(MainTray.optionsDialog.jComboBox1.getSelectedIndex()));
		prop.setProperty("dayofweek",Integer.toString(MainTray.optionsDialog.jComboBox2.getSelectedIndex()+1));
		prop.setProperty("postmaster",MainTray.optionsDialog.jTextField3.getText());
		prop.setProperty("expire",MainTray.optionsDialog.jTextField5.getText());
		prop.setProperty("sendtousers", Boolean.toString(MainTray.optionsDialog.jCheckBox.isSelected()));
		prop.setProperty("clientsubject",MainTray.optionsDialog.jTextField31.getText());
		prop.setProperty("usertext",MainTray.optionsDialog.jTextArea.getText());
	}
	
	public void readProp(){
		if(!configfile.exists()) 
			try 
			{
				configfile.createNewFile();
				prop.setProperty("enable", "true");
				prop.setProperty("domain", "ENTERYOURDOMAINNAME");
				prop.setProperty("basedn", "DC=TEST,DC=COM");
				prop.setProperty("domaincontroler","controllername.com");
				prop.setProperty("expire", "5");
				prop.setProperty("maximumPasswordAge","180");
				prop.setProperty("time", "03:00");
				prop.setProperty("date", "");
				prop.setProperty("postmaster", "postmaster@yourpostdomain.com");
				prop.setProperty("dayofweek", "1");
				prop.setProperty("adminsubject", "password of %users% expired");
				prop.setProperty("usertext"," Dear %users%! Your password expires in %day% days. To change your password go to <http://changepass.com> ");
				prop.setProperty("mail.host","mailhost.company.com");
				prop.setProperty("port","25");
				prop.setProperty("from","postmaster@yourpostdomain.com");
				prop.setProperty("clientsubject","Password notification");
				prop.setProperty("mailID","");
				prop.setProperty("username","username");
				prop.setProperty("password","password");
				prop.setProperty("ldapport","389"); 
				OutputStream  out = new FileOutputStream(configfile);
				prop.storeToXML(out, "AD Password Notificator");
			} 
			catch (IOException e){}
			else 
			try
			{
				InputStream in = new FileInputStream(configfile);
				prop.loadFromXML(in);
			}
			catch(IOException e) {};
		
	}
	
	public static void saveProp(){
		
		try 
		{
			configfile.createNewFile();				
			OutputStream  out = new FileOutputStream(configfile);
			prop.storeToXML(out, "AD Password Notificator");
		} 
		catch (IOException e){}
	
}
}
