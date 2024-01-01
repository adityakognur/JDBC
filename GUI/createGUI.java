package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import MainPackage.Main;


public  class createGUI {
	public static JTextField nameField,usnField,ageField,MarksField;
	public void show() {
		
		final JFrame frame=new JFrame("student database");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        
        JLabel namelabel=new JLabel("name:");
        namelabel.setBounds(50, 60, 100, 20);
        nameField=new JTextField();
        nameField.setBounds(100, 60, 200, 20);
        
        
        JLabel usnlabel=new JLabel("usn:");
        usnlabel.setBounds(50, 90, 100, 20);
        usnField=new JTextField();
        usnField.setBounds(100, 90, 200, 20);
        
        JLabel agelabel=new JLabel("age:");
        agelabel.setBounds(50, 120, 100, 20);
        ageField=new JTextField();
        ageField.setBounds(100, 120, 200, 20);
        
        JLabel Markslabel=new JLabel("Marks:");
        Markslabel.setBounds(50, 150, 100, 20);
        MarksField=new JTextField();
        MarksField.setBounds(100, 150, 200, 20);
        
        
        
        
        JButton submitButton=new JButton("submit");
        submitButton.setBounds(100, 180, 100, 30);
        submitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Main.insert(frame,nameField,usnField,ageField,MarksField);
        		}
        		catch (ClassNotFoundException e1) {
        			System.out.println(e1);
        		}
        	}
        });
        
        
        
        JButton displayButton=new JButton("display");
        displayButton.setBounds(200, 180, 100, 30);
        displayButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Main obj=new Main(); 
        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			obj.display(frame);
        		}
        		catch (ClassNotFoundException e1) {
        			System.out.println(e1);
        		}
        	}
        });
        
        frame.add(namelabel);
        frame.add(nameField);
        
        frame.add(agelabel);
        frame.add(ageField);
        
        frame.add(usnlabel);
        frame.add(usnField);
        
        frame.add(Markslabel);
        frame.add(MarksField);
        
        frame.add(submitButton);
        frame.add(displayButton);
        
  
        frame.setVisible(true);
	}

}
