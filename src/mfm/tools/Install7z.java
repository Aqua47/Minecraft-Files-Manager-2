package mfm.tools;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Install7z extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton no,yes;

	public static void main() {
		Install7z dialog = new Install7z();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setModal(true);
		dialog.setSize(360, 100);
		dialog.setLayout(null);
		dialog.setVisible(true);
        //dialog.setLocationRelativeTo(null)
		
	}
	
	public Install7z() {
        setLayout(new FlowLayout());     
        
        JLabel txt = new JLabel("you need 7z to use this function would you like to install it?");
        txt.setBounds(5, 0, 360, 30);
        add(txt);
        
        no = new JButton();
        no.setBounds(3, 31, 50, 30);
        no.setText("no");
        no.addActionListener(this);
        add(no);
        
        yes = new JButton();
        yes.setBounds(283, 31, 60, 30);
        yes.setText("yes");
        yes.addActionListener(this);
        add(yes);
        
       
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == yes) {
			try {
				if (install7z()) {
					dispose();
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		dispose();
	}

	
	public static boolean install7z() throws IOException, InterruptedException {
		File f = new File("C:\\Program Files\\7-Zip\\7z.exe");
		boolean r = f.exists();
		if (!r) {
			Process gz = Runtime.getRuntime().exec("cmd /C start /wait winget install 7zip.7zip");
			gz.waitFor();
			r = true;
		}
		return r;
	}

}





/*
JDialog dialog = new JDialog(this, true);
dialog.setSize(200, 100);
dialog.setLocationRelativeTo(this);
dialog.setVisible(true);*/