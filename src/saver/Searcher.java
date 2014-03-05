package saver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class Searcher 
{
	Vector<String> hist = new Vector<String>();
	Vector<UserData> users = new Vector<UserData>();
	Long maxPwdAgeDays = new Long(0) ;
	
	Session session = Session.getDefaultInstance(ConfigWrapper.prop);
	MimeMessage msgToAdmin = new MimeMessage(session);
	MimeMessage msgToUser = new MimeMessage(session);
	
	public void saveHistory()
	{
		try 
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("history.dat"));
			for(int i=0; i<hist.size();i++) 
			{
				bw.write(hist.get(i));
				if (i<hist.size()-1) bw.newLine();
			};
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void readHistory() //чтение файла history.dat, в котором содержится список ранее оповещённых пользователей
	{
		BufferedReader br;
		try 
		{
			br = new BufferedReader(new FileReader("history.dat"));
			String buf = "oloo";
			while(!(buf == null))
			{
				buf = br.readLine();
				if((buf!=null)&&!hist.contains(buf)) 
				hist.add(buf);
			};
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getDomainMaxPwdAge() //получение максимального срока действия пароля
	{
		Properties env = new Properties();	
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, ConfigWrapper.prop.get("domain")+"\\"+ConfigWrapper.prop.get("username"));
        env.put(Context.SECURITY_CREDENTIALS, ConfigWrapper.prop.get("password"));
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,"ldap://"+ConfigWrapper.prop.get("domaincontroler")+":"+ConfigWrapper.prop.get("ldapport"));        
        Long maxPwdAge = new Long(0) ;
        //пытаемся получить из домена информацию о максимальном сроке действия пароля
        //try 
		{
			/* get a handle to an Initial DSContext */
			DirContext ctx;
			try 
			{
				ctx = new InitialDirContext(env);
				SearchControls ctrls = new SearchControls();
		        ctrls.setReturningObjFlag(false);
		        ctrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
				NamingEnumeration results = ctx.search(ConfigWrapper.prop.getProperty("basedn"), "(objectClass=top)", ctrls);
				/* for each entry print out name + all attrs and values */
				String sMaxPwdAge = "0";
				while ((results != null) && (results.hasMoreElements())) 
				{
					SearchResult si = (SearchResult) results.nextElement();
					Attributes attrs = si.getAttributes();
						
					try {
						sMaxPwdAge = (String) attrs.get("maxPwdAge").get();
						System.out.println(sMaxPwdAge);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					maxPwdAge = Long.parseLong(sMaxPwdAge);
					Long hiPart = (maxPwdAge>>32);
					Long loPart = maxPwdAge-(hiPart<<32);
					if(hiPart<0) hiPart = -hiPart;
					maxPwdAgeDays = ((hiPart*4294967296l+loPart)/1440/600000000);
					break;
				}
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//System.out.println("domain maxPwdAge: "+maxPwdAgeDays);
		return maxPwdAgeDays.intValue();
	}
	
		
	@SuppressWarnings("unchecked")
	public void startSearch()
	{
		readHistory(); //получаем список тех, кого уже оповещали
		getDomainMaxPwdAge(); 
		System.out.println("domain maxPwdAge: "+maxPwdAgeDays);
		searchUsers();
		System.out.println("users with mail: "+users.size());
		for(int i = 0; i<users.size(); i++)
		{
			UserData d = users.get(i);
			System.out.println(d.name+" : "+d.mail+" : "+d.pwdAge);
		}
		sendMsgToAdmin();
		if(ConfigWrapper.prop.getProperty("sendtousers").equals("true"))
		{
			sendMsgsToUsers();
		}
		saveHistory();
		
	}

	private void sendMsgsToUsers() 
	{
		for(int i = 0; i<users.size(); i++)
		{
			UserData d = users.get(i);
			
			//if(!(hist.contains(d.mail)))
			{
				// if((maxPwdAgeDays-d.pwdAge)>(new Integer((String) ConfigWrapper.prop.get("expire"))).intValue())
				try {
					InternetAddress[] clientAddress = {new InternetAddress (d.mail)};
					Transport tr = session.getTransport("smtp");
					tr.connect();
					String usrtxt = ConfigWrapper.prop.getProperty("usertext");
					usrtxt = usrtxt.replaceAll("%username%", d.mail);
					usrtxt = usrtxt.replaceAll("%days%", ""+(maxPwdAgeDays-d.pwdAge));
					msgToUser.setText(usrtxt, "koi8-r");
					msgToUser.setSubject(ConfigWrapper.prop.getProperty("clientsubject"), "koi8-r");
					msgToUser.setSentDate(new Date());
					System.out.println(usrtxt);
					if((maxPwdAgeDays-d.pwdAge)>(new Integer((String) ConfigWrapper.prop.get("expire"))).intValue())
					{
						if(hist.contains(d.mail))
						{
							hist.remove(d.mail);
							System.out.println("NOT SENT. CHANGED OK.");
						}
						else
						{
							System.out.println("NOT SENT. OK.");
						}
						
					}
					else
					if(!(hist.contains(d.mail))&&((maxPwdAgeDays-d.pwdAge)>0))
					{
					   tr.sendMessage(msgToUser, clientAddress);
					   System.out.println("SENT");
					   hist.add(d.mail);
					}
					else
					{
						System.out.println("NOT SENT. IN HISTORY.");
					}
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchProviderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		  
		
	/*	if ((!(hist.contains(clientmail)))&&ConfigWrapper.prop.getProperty("sendtousers").equals("true"))
    	   {	
    		  // hist.
    		  hist.add(clientmail);
    		  System.out.println(clientmail+" "+ hist.contains(clientmail));
    		  adminmsgtxt=adminmsgtxt+clientmail+" "+Long.toString(-1111)+" (User changed his password "+newDateString+" - "+currPwdTime+" days ago) notification sent"+System.getProperty("line.separator")+'\r';
    		  //Отсылаем письмо юзеру
    		  try 
    		  {
				//Раскомментировать!
				//InternetAddress[] clientAddress = {new InternetAddress (clientmail)};
    			InternetAddress[] clientAddress = {new InternetAddress ((String) ConfigWrapper.prop.get("postmaster"))};
				Transport tr = session.getTransport("smtp");
				tr.connect();
				String usrtxt = ConfigWrapper.prop.getProperty("usertext");
				usrtxt = usrtxt.replaceAll("%username%", clientmail);
				usrtxt = usrtxt.replaceAll("%days%", ""+(maxPwdAge-currPwdTime));
				msgToUser.setText(usrtxt, "koi8-r");
				msgToUser.setSubject(ConfigWrapper.prop.getProperty("clientsubject"), "koi8-r");
				msgToUser.setSentDate(new Date());
				System.out.println(usrtxt);
			//	tr.sendMessage(msgToUser, clientAddress);
				//System.out.println(clientmail+" "+ hist.contains(clientmail));
    		  } catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
    		  } catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
    		  }
    	   }
    	   else adminmsgtxt=adminmsgtxt+clientmail+" "+Long.toString(-1111)+" (User changed his password "+newDateString+") notification has been sent earlier"+System.getProperty("line.separator")+'\r';
   		//hist.put(clientmail);
    	   
    	   //System.out.println(clientmail+" "+useracc);
   	}
   	else
   	{
   		if (hist.contains(clientmail))
   		{
   			adminmsgtxt=adminmsgtxt+clientmail+" "+Long.toString(-1111)+" (User has changed his password "+newDateString+") nice =)"+System.getProperty("line.separator")+'\r';
   			hist.remove(clientmail);
   		}
   		//adminmsgtxt=adminmsgtxt+"GOOD: "+clientmail+"	"+Long.toString(must)+" (Password changed "+newDateString+")"+'\n';
   	};
		*/
	}

	private void sendMsgToAdmin() 
	{
		try {
			InternetAddress[] adminAddress = {new InternetAddress ((String) ConfigWrapper.prop.get("postmaster"))};
			Transport tr = session.getTransport("smtp");
			tr.connect();					
			String adminmsgtxt = new String();
			adminmsgtxt = "Domain max password age: "+maxPwdAgeDays+ "\n";
			adminmsgtxt = adminmsgtxt+"Total users with mail: "+users.size()+ "\n";
			for(int i = 0; i<users.size(); i++)
			{
				String userinfo = "";
				UserData d = users.get(i);
				if(hist.contains(d.mail))
				{
					userinfo = "User was notified earlier.";
					if((maxPwdAgeDays-d.pwdAge)>(new Integer((String) ConfigWrapper.prop.get("expire"))).intValue())
					{
						userinfo = "User has changed his password "+d.pwdLastChangedDate+". OK :3";
					}
				}
				else if((maxPwdAgeDays-d.pwdAge)>(new Integer((String) ConfigWrapper.prop.get("expire"))).intValue())
				{
					userinfo = "User doesn't need notification.";
				}
				else
				{
					userinfo = "User needs notification! If checkbox is on, message will be sent.";
					if((maxPwdAgeDays-d.pwdAge)<0)
					{
						userinfo = "It is too late to send notification =(";
						hist.add(d.mail);
					}
				}
				adminmsgtxt = adminmsgtxt+d.name+": "+(maxPwdAgeDays-d.pwdAge)+" days before expiration. "+userinfo+"\n";
			}
			System.out.println(adminmsgtxt);
			msgToAdmin.setText(adminmsgtxt, "koi8-r");
			msgToAdmin.setSubject("Users' passwords report", "koi8-r");
			msgToAdmin.setSentDate(new Date());	
			
			tr.sendMessage(msgToAdmin, adminAddress);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void searchUsers() //заполнение вектора Users данными из домена
	{
		try 
		{
			users = new Vector<UserData>();
			String MY_FILTER = "(&(objectClass=person)(!(objectclass=computer))(sAMAccountType=805306368))";
			Properties env = new Properties();	
			env.put(Context.SECURITY_AUTHENTICATION, "simple");
	        env.put(Context.SECURITY_PRINCIPAL, ConfigWrapper.prop.get("domain")+"\\"+ConfigWrapper.prop.get("username"));
	        env.put(Context.SECURITY_CREDENTIALS, ConfigWrapper.prop.get("password"));
	        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	        env.put(Context.PROVIDER_URL,"ldap://"+ConfigWrapper.prop.get("domaincontroler")+":"+ConfigWrapper.prop.get("ldapport"));
			DirContext ctx = new InitialDirContext(env);
			SearchControls ctrls = new SearchControls();
	        ctrls.setReturningObjFlag(false);
	        ctrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(ConfigWrapper.prop.getProperty("basedn"), MY_FILTER, ctrls);
			while ((results != null) && (results.hasMoreElements())) 
			{
				//System.out.println("User found");
				SearchResult si = (SearchResult) results.nextElement();
				Attributes attrs = si.getAttributes();
				try 
				{
					//String clientmail = (String) attrs.get("mail").get();
					String clientmail = (String) attrs.get("mail").get();
					String usrname = (String) attrs.get("name").get(); //!!!!!!!!!!!!!!!!!!!!!
					String pwdLastSet = (String) attrs.get("pwdLastSet").get();
					String useracc = (String) attrs.get("userAccountControl").get();  //if equals "514", account disabled
					
					long pw = Long.parseLong(pwdLastSet);
	    		    // Формат записи windows в наносекундах от JAN 01 1601
	    			// Формат записи java в микроскекундах  от January 1, 1970
	    		    long javaTime = pw - 0x19db1ded53e8000L;
	    		    // конвертируем из микросекунд в милисекунды
	    			javaTime /= 10000;
	    	 		Date theDate = new Date(javaTime);
	    	  		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	    	        // интервал времени от последнего обновления пароля до настоящего времени
	    	  		long currPwdTime =(Calendar.getInstance().getTimeInMillis() - javaTime)/86400000; 
	    	  		// меняем время
	    	  		
	    	  		String newDateString = formatter.format(theDate);
	    	  		
	    	  		if(!(useracc.equals("514")))
	    	  		{
	    	  			UserData d = new UserData();
	    	  		    d.name = usrname;
	    	  		    d.mail = clientmail;
	    	  		    d.pwdAge = currPwdTime;
	    	  		    d.pwdLastChangedDate = newDateString;
	    	  		    users.add(d);
	    	  		}
				} 
				catch (RuntimeException e) 
				{
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}				
			};
			
		
		}
		catch (NamingException e) 
		{
			System.err.println("Search example failed");
			e.printStackTrace();
		};
	}
}

/*
 * 
 * Properties env = new Properties();
		//String MY_FILTER = "(&(objectClass=person)(!(objectclass=computer))(sAMAccountType=805306368))";	
		env.put(Context.SECURITY_AUTHENTICATION,"simple");
        env.put(Context.SECURITY_PRINCIPAL, ConfigWrapper.prop.get("domain")+"\\"+ConfigWrapper.prop.get("username"));
        env.put(Context.SECURITY_CREDENTIALS, ConfigWrapper.prop.get("password"));
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,"ldap://"+ConfigWrapper.prop.get("domaincontroler")+":"+ConfigWrapper.prop.get("ldapport"));        
        //Сначала получаем время действия пароля
       // Long pwdAge=new Long(0); 
        Long maxPwdAge = new Long(0) ;
        Long maxPwdAgeDays = new Long(0) ;
        //пытаемся получить из домена информацию о максимальном сроке действия пароля
        //try 
		{
		
			DirContext ctx;
			try {
				ctx = new InitialDirContext(env);
				SearchControls ctrls = new SearchControls();
		        ctrls.setReturningObjFlag(false);
		        ctrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
				NamingEnumeration results = ctx.search(ConfigWrapper.prop.getProperty("basedn"), "(objectClass=top)", ctrls);
				
				String sMaxPwdAge = "0";
				while ((results != null) && (results.hasMoreElements())) 
				{
					SearchResult si = (SearchResult) results.nextElement();
					Attributes attrs = si.getAttributes();
				
					try 
					{
						sMaxPwdAge = (String) attrs.get("maxPwdAge").get();
					} catch (Exception e) 
					{
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					maxPwdAge = Long.parseLong(sMaxPwdAge);
					Long hiPart = (maxPwdAge>>32);
					Long loPart = maxPwdAge-(hiPart<<32);
					if(hiPart<0) hiPart = -hiPart;
					maxPwdAgeDays = ((hiPart*4294967296l+loPart)/1440/600000000);
				}
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		}
		
		---------------------------------------
		
		try 
		{
			Properties env = new Properties();	
			DirContext ctx = new InitialDirContext(env);
			SearchControls ctrls = new SearchControls();
	        ctrls.setReturningObjFlag(false);
	        ctrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
	        //ctrls.setSearchScope(SearchControls.OBJECT_SCOPE);
			NamingEnumeration results = ctx.search(ConfigWrapper.prop.getProperty("basedn"), MY_FILTER, ctrls);
			while ((results != null) && (results.hasMoreElements())) 
			{
				System.out.println("User found");
				SearchResult si = (SearchResult) results.nextElement();
				Attributes attrs = si.getAttributes();
				try 
				{
					//String clientmail = (String) attrs.get("mail").get();
					String clientmail = "ololo";
					String usrname = (String) attrs.get("name").get(); //!!!!!!!!!!!!!!!!!!!!!
					String pwdLastSet = (String) attrs.get("pwdLastSet").get();
					String useracc = (String) attrs.get("userAccountControl").get();  //if equals "514", account disabled
					System.out.println("User data found");
					
					//clientmail = clientmail.substring(6, clientmail.length());
					//System.out.println(clientmail);
					//pwdLastSet = pwdLastSet.substring(12, pwdLastSet.length());
					//useracc = useracc.substring(20, useracc.length());
					long pw = Long.parseLong(pwdLastSet);
	    		    // Формат записи windows в наносекундах от JAN 01 1601
	    			// Формат записи java в микроскекундах  от January 1, 1970
	    		    long javaTime = pw - 0x19db1ded53e8000L;
	    		    // конвертируем из микросекунд в милисекунды
	    			javaTime /= 10000;
	    	 		Date theDate = new Date(javaTime);
	    	  		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	    	        // интервал времени от последнего обновления пароля до настоящего времени
	    	  		long currPwdTime =(Calendar.getInstance().getTimeInMillis() - javaTime)/86400000; 
	    	  		// меняем время
	    	  		System.out.println(usrname+": "+currPwdTime+" days");
	    		    String newDateString = formatter.format(theDate);
	    	     	//if(debug) System.out.println(mail + "  " + newDateString);
	    	        //максимальный интервал времени в микросекундах, после которого нужно предупредить пользователя.
	    	 
	    	     	//long must= may - pwdAge;	    	   
	    	     	//System.out.println(clientmail+"	"+Long.toString(must));
	    	    	//must=must-may;
	    	    	//if((must<=Long.parseLong(ConfigWrapper.prop.getProperty("expire")))&&!(useracc.equals("514")))
	    		    if(true)
	    	    	{ 
	    	     	   //adminmsgtxt=adminmsgtxt+clientmail+" "+Long.toString(must)+'\n';
	    	    		//System.out.println(clientmail+" "+ hist.contains(clientmail));
	    	     	   //ЗДЕСЬ РЕАЛИЗУЕМ ОТСЫЛКУ ПИСЬМА ЮЗЕРУ!!!
	    	     	   if ((!(hist.contains(clientmail)))&&ConfigWrapper.prop.getProperty("sendtousers").equals("true"))
	    	     	   {	
	    	     		  // hist.
	    	     		  hist.add(clientmail);
	    	     		  System.out.println(clientmail+" "+ hist.contains(clientmail));
	    	     		  adminmsgtxt=adminmsgtxt+clientmail+" "+Long.toString(-1111)+" (User changed his password "+newDateString+" - "+currPwdTime+" days ago) notification sent"+System.getProperty("line.separator")+'\r';
	    	     		  //Отсылаем письмо юзеру
	    	     		  try 
	    	     		  {
	    	 				//Раскомментировать!
	    	 				//InternetAddress[] clientAddress = {new InternetAddress (clientmail)};
	    	     			InternetAddress[] clientAddress = {new InternetAddress ((String) ConfigWrapper.prop.get("postmaster"))};
	    	 				Transport tr = session.getTransport("smtp");
	    	 				tr.connect();
	    	 				String usrtxt = ConfigWrapper.prop.getProperty("usertext");
	    	 				usrtxt = usrtxt.replaceAll("%username%", clientmail);
	    	 				usrtxt = usrtxt.replaceAll("%days%", ""+(maxPwdAge-currPwdTime));
	    	 				msgToUser.setText(usrtxt, "koi8-r");
	    	 				msgToUser.setSubject(ConfigWrapper.prop.getProperty("clientsubject"), "koi8-r");
	    	 				msgToUser.setSentDate(new Date());
	    	 				System.out.println(usrtxt);
	    	 			//	tr.sendMessage(msgToUser, clientAddress);
	    	 				//System.out.println(clientmail+" "+ hist.contains(clientmail));
	    	     		  } catch (NoSuchProviderException e) {
	    	 				// TODO Auto-generated catch block
	    	 				e.printStackTrace();
	    	     		  } catch (MessagingException e) {
	    	 				// TODO Auto-generated catch block
	    	 				e.printStackTrace();
	    	     		  }
	    	     	   }
	    	     	   else adminmsgtxt=adminmsgtxt+clientmail+" "+Long.toString(-1111)+" (User changed his password "+newDateString+") notification has been sent earlier"+System.getProperty("line.separator")+'\r';
	    	    		//hist.put(clientmail);
	    	     	   
	    	     	   //System.out.println(clientmail+" "+useracc);
	    	    	}
	    	    	else
	    	    	{
	    	    		if (hist.contains(clientmail))
	    	    		{
	    	    			adminmsgtxt=adminmsgtxt+clientmail+" "+Long.toString(-1111)+" (User has changed his password "+newDateString+") nice =)"+System.getProperty("line.separator")+'\r';
	    	    			hist.remove(clientmail);
	    	    		}
	    	    		//adminmsgtxt=adminmsgtxt+"GOOD: "+clientmail+"	"+Long.toString(must)+" (Password changed "+newDateString+")"+'\n';
	    	    	};
	   
				} 
				catch (RuntimeException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			};
			//Пишем письмо админу
			try 
			{
			
				System.out.println(ConfigWrapper.prop.getProperty("admintext").replaceAll("%information%", adminmsgtxt));
				
				InternetAddress[] adminAddress = {new InternetAddress ((String) ConfigWrapper.prop.get("postmaster"))};
				Transport tr = session.getTransport("smtp");
				tr.connect();					
				msgToAdmin.setText(ConfigWrapper.prop.getProperty("admintext").replaceAll("%information%", adminmsgtxt), "koi8-r");
			//	try {
					
			//	} catch (IOException e) {
					// TODO Auto-generated catch block
			//		e.printStackTrace();
			//	}
				msgToAdmin.setSubject(ConfigWrapper.prop.getProperty("Users' passwords report"), "koi8-r");
				msgToAdmin.setSentDate(new Date());		
				tr.sendMessage(msgToAdmin, adminAddress);
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (NamingException e) 
		{
			System.err.println("Search example failed");
			e.printStackTrace();
		};
		
		

		try 
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("history.dat"));
			//String line;
			for(int i=0; i<hist.size();i++) 
			{
	//		
	//			hist.keySet().toString();
			//	System.out.println(hist.size()+" "+i+" "+hist.get(i));
				//System.out.println();
			//	bw.write(hist.keySet().toArray()[i]);
				bw.write(hist.get(i));
				if (i<hist.size()-1) bw.newLine();
				//System.out.println(hist.keySet().toArray()[i]);
			};
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 * */
