package saver;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class ShowMessageListener implements ActionListener 
{
  TrayIcon trayIcon;
  String title;
  String message;
  TrayIcon.MessageType messageType;
  ShowMessageListener(
      TrayIcon trayIcon,
      String title,
      String message,
      TrayIcon.MessageType messageType) {
    this.trayIcon = trayIcon;
    this.title = title;
    this.message = message;
    this.messageType = messageType;
  }
  public void actionPerformed(ActionEvent e) {
    trayIcon.displayMessage(title, message, messageType);
  }
}

class ReportGenerator extends TimerTask {
	  public void run() {
	  	System.out.println("Generating report");
	  	    //TODO generate report
	  	    MainTray.s.startSearch();
	  	  }
	  	 
	  }


public class MainTray 
{
	
  public static ConfigWrapper currConfig = new ConfigWrapper();
  public static OptDialog optionsDialog;
  public static Searcher s = new Searcher();
  
  public static void main(String args[]) 
  {
	currConfig.readProp();
	optionsDialog = new OptDialog();
	
	Runnable runner = new Runnable() 
	{
    public void run() {
    	  
    	  optionsDialog.setSize(626, 497);
    	  Timer timer = new Timer();
    	    Calendar date = Calendar.getInstance();
    	    //System.out.println(Calendar.SUNDAY);
    	    date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    	    date.set(Calendar.HOUR_OF_DAY, 0);
    	    date.set(Calendar.MINUTE, 0);
    	    date.set(Calendar.SECOND, 0);
    	    date.set(Calendar.MILLISECOND, 0);
    	    // Schedule to run every Sunday in midnight
    	    timer.schedule(
    	      new ReportGenerator(),
    	      date.getTime(),
    	      1000 * 60 * 60 * 24 * 7
    	    );
    	  if (SystemTray.isSupported()) {
          final SystemTray tray = SystemTray.getSystemTray();
          Image image = Toolkit.getDefaultToolkit().getImage("TrayIcon.gif");
          PopupMenu popup = new PopupMenu();
          final TrayIcon trayIcon = new TrayIcon(image, "Password Notificator Running", popup);
 
          MenuItem options = new MenuItem("Options");
          options.addActionListener(new ActionListener()
        		  {
          			
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						optionsDialog.setVisible(true);	
					};
          		  });
          popup.add(options);
          
          MenuItem item = new MenuItem("Error");
          item = new MenuItem("Info");
          item.addActionListener(new ShowMessageListener(trayIcon,
            "Password notificator is running", "by Dmitry Myasnikov, saver_is_not@bk.ru \nhttp:\\\\adpassnotif.sourceforge.net", TrayIcon.MessageType.INFO));
          popup.add(item);
          item = new MenuItem("Exit");
          item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              tray.remove(trayIcon);
              System.exit(0);
            }
          });
          popup.add(item);
          try {
            tray.add(trayIcon);
          } catch (AWTException e) {
            System.err.println("Can't add to tray");
          }
        } else {
          System.err.println("Tray unavailable");
        }
      }
    };
    EventQueue.invokeLater(runner);
    

  }
 }
