package mfm.run;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mfm.function.*;
import mfm.tools.*;


public class Jf extends JFrame implements ActionListener{

	private static final long serialVersionUID = 2L;
	
	private static final String version = "2.0";
	
	private static final String run = System.getProperty("user.dir");

	private static final String min = "C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Roaming\\.minecraft";
	
	private static String servLoc;
		
	private static String[] indexesSel, objectsSel, deleteSel, oldSel;
	private static String[] logsSel = {"game", "server"};
	private static String[] backupSel = {"game", "server"};
	private static String[] folderSel = {"mfm","minecraft","server"};
	
	private static JComboBox<String> indexes = new JComboBox<>(), objects = new JComboBox<>(), old = new JComboBox<>(),
			logs = new JComboBox<>(), backup = new JComboBox<>(), delete = new JComboBox<>(), folder = new JComboBox<>();
	
	private static JButton indexesButton = new JButton(), objectsButton = new JButton(), oldButton = new JButton(), logsButton = new JButton(),
			backupButton = new JButton(), deleteButton = new JButton(), folderButton = new JButton(), servButton = new JButton(),
			refreshButton = new JButton(), InstallButton = new JButton(), ExitButton = new JButton();
	
	private static JTextField serv = new JTextField();
	
	public static JTextArea print = new JTextArea(10, 30);
	public static JScrollPane scrollPane = new JScrollPane(print);
	
	
	public Jf() {
		super("Minecraft Files Manager "+version);
		
		JLabel background = new JLabel();
        background.setIcon(new ImageIcon(".jpg"));

        setContentPane(background);
        
        int len;
        
        JLabel indexesT = new JLabel("Indexes");
        indexesT.setBounds(23, 5, 80, 30);
        add(indexesT);
        indexes.setBounds(3, 31, 80, 30);
        add(indexes);
        indexesButton.setBounds(83, 31, 20, 30);
        indexesButton.addActionListener(this);
        add(indexesButton);
        
        JLabel objectsT = new JLabel("Objects");
        objectsT.setBounds(133, 5, 80, 30);
        add(objectsT);
        objects.setBounds(113, 31, 80, 30);
        add(objects);
        objectsButton.setBounds(193, 31, 20, 30);
        objectsButton.addActionListener(this);
        add(objectsButton);
        
        JLabel oldT = new JLabel("Old");
        oldT.setBounds(243, 5, 80, 30);
        //add(oldT);
        old.setBounds(223, 31, 80, 30);
        //add(old); TODO    
        oldButton.setBounds(303, 31, 20, 30);
        oldButton.addActionListener(this);
        //add(oldButton);
        
        
        JLabel logsT = new JLabel("Logs");
        logsT.setBounds(23, 65, 80, 30);
        add(logsT);
        len = logsSel.length;
		for (int i = 0; i != len; i++) {
			logs.addItem(logsSel[i]);
		}
        logs.setBounds(3, 91, 80, 30);
        add(logs);
        logsButton.setBounds(83, 91, 20, 30);
        logsButton.addActionListener(this);
        add(logsButton);
        
        JLabel backupT = new JLabel("Backup");
        backupT.setBounds(133, 65, 80, 30);
        add(backupT);
        len = backupSel.length;
		for (int i = 0; i != len; i++) {
			backup.addItem(backupSel[i]);
		}
        backup.setBounds(113, 91, 80, 30);
        add(backup); 
        backupButton.setBounds(193, 91, 20, 30);
        backupButton.addActionListener(this);
        add(backupButton);
        
        JLabel deleteT = new JLabel("Delete");
        deleteT.setBounds(243, 65, 80, 30);
        add(deleteT);
        delete.setBounds(223, 91, 80, 30);
        add(delete);
        deleteButton.setBounds(303, 91, 20, 30);
        deleteButton.addActionListener(this);
        add(deleteButton);
        
        
        JLabel folderT = new JLabel("Folder");
        folderT.setBounds(23, 125, 80, 30);
        add(folderT);
        len = folderSel.length;
		for (int i = 0; i != len; i++) {
			folder.addItem(folderSel[i]);
		}
        folder.setBounds(3, 151, 80, 30);
        add(folder);  
        folderButton.setBounds(83, 151, 20, 30);
        folderButton.addActionListener(this);
        add(folderButton);
        
        
        JLabel servT = new JLabel("serv location.txt");
        servT.setBounds(13, 185, 180, 30);
        add(servT);
        serv.setBounds(3, 211, 301, 30);
        add(serv);
        servButton.setBounds(303, 211, 20, 30);
        servButton.addActionListener(this);
        add(servButton);
        
        
        
        refreshButton.setBounds(3, 261, 80, 30);
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(this);
        add(refreshButton);
        
        InstallButton.setBounds(128, 261, 80, 30);
        InstallButton.setText("Install");
        InstallButton.addActionListener(this);
        //add(InstallButton); TODO
        
        ExitButton.setBounds(253, 261, 70, 30);
        ExitButton.setText("Exit");
        ExitButton.addActionListener(this);
        add(ExitButton);
      
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(scrollPane);
        //print.setBounds(340,10,300,270);
        //print.setEditable(false);
        //add(print);
        //add(scrollPane);
        
      
        
        refresh();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String sel;
		try {	
			if (event.getSource() == ExitButton) {
				dispose();
			} else if (event.getSource() == InstallButton) {
				Install.env(run);
			} else if (event.getSource() == indexesButton) {
				sel = (String) indexes.getSelectedItem();
				Indexes.main(min, sel);
			} else if (event.getSource() == objectsButton) {
				sel = (String) objects.getSelectedItem();
				if (sel != "all") {
					sel = Tools.removeLast(sel, 4);
				}
				Objects.main(min, sel);
			} else if (event.getSource() == oldButton) {
				sel = (String) old.getSelectedItem();
				System.out.println(sel);
				//Old.main(min, sel); TODO
			} else if (event.getSource() == logsButton) {
				if (zip7()) {
					sel = (String) logs.getSelectedItem();
        			if (sel == "game") {
        				Logs.main(min, false);
        			} else if (sel == "server") {
        				Logs.main(servLoc, true);
        			}
				}
			} else if (event.getSource() == backupButton) {
				if (zip7()) {
					sel = (String) backup.getSelectedItem();
					if (sel == "game") {
						Backup.main(min, "all", false);
					}
					else if (sel == "server") {
						Backup.main(servLoc, "all", true);
					}
				}
			} else if (event.getSource() == deleteButton) {
				sel = (String) delete.getSelectedItem();
				Delete.main(sel, false);
			} else if (event.getSource() == folderButton) {
				sel = (String) folder.getSelectedItem();
				if (sel == "mfm") { openFolder(run+"\\serv location.txt"); }
				else if (sel == "minecraft") { openFolder(min+"\\assets"); }
				else if (sel == "server") { openFolder(servLoc+"\\eula.txt"); }
			} else if (event.getSource() == servButton) {
				sel = (String) serv.getText();
				FileWriter servWriter = new FileWriter(run+"\\serv location.txt");
				servWriter.write(sel);
				Tools.print("serv location updated to : "+sel);
				servWriter.close();
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		refresh();
		System.gc();	
	}	
	
	private void refresh() {
		int len;
		new File("MFM").mkdirs();
		File floc = new File("serv location.txt");
		BufferedReader br;
		try {
			floc.createNewFile();
			br = new BufferedReader(new FileReader(floc));
			servLoc = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//new File("MFM").mkdirs();
		
		indexesSel = Tools.available(min+"\\assets\\indexes");
		if (new File("MFM\\indexes").exists()) { //if file in the folder 
			objectsSel = Tools.available("MFM\\indexes");
		} else {
			objectsSel = null;
		}
		deleteSel = Tools.available("MFM");
		oldSel = Tools.available(min+"\\versions");
		
		
		indexes.removeAllItems();
		len = indexesSel.length;
		for (int i = 0; i != len; i++) {
			indexes.addItem(indexesSel[i]);
		}
		indexes.addItem("all");
			
		objects.removeAllItems();
		len = indexesSel.length;
		
		for (int i = 0; i != len; i++) {
			//show if indexes exists
			if (objectsSel != null && Tools.ifStringInArray(indexesSel[i],objectsSel)) {
				objects.addItem(indexesSel[i]+" (T)");	
			} else {
				objects.addItem(indexesSel[i]+" (F)");
			}
		}
		objects.addItem("all");
		
		
		delete.removeAllItems();
		len = deleteSel.length;
		for (int i = 0; i != len; i++) {
			delete.addItem(deleteSel[i]);
		}
		if (len > 1) {
			delete.addItem("all");
		}
		
		old.removeAllItems();
		len = oldSel.length;
		for (int i = 0; i != len; i++) {
			old.addItem(oldSel[i]);
		}
		old.addItem("all");
		
		serv.setText(servLoc);
		
	}
	
	public static void main(String[] args) {
		Jf frame = new Jf();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 330);
        frame.setLayout(null);
        frame.setVisible(true);
	}
	
	private static void openFolder(String loc) {
		Tools.print(loc);
		try {
			Runtime.getRuntime().exec("explorer.exe /select,"+loc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	private static boolean zip7 () {
		File f = new File("C:\\Program Files\\7-Zip\\7z.exe");
		boolean zip7 = f.exists();
		if (!zip7) {
			Install7z.main();
		}
		zip7 = f.exists();
		return zip7;
	}
	
}