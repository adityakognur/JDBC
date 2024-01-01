package MainPackage;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import GUI.createGUI;
public class Main {
	private static final String url="jdbc:mysql://localhost:3306/mydb";
	private static final String username="root";
	private static final String password="Mysql@6913";
	
	public static void insert(JFrame frame,JTextField nameField,JTextField usnField,JTextField ageField,JTextField marksField) {
		
		try {
			Connection connection =DriverManager.getConnection(url,username,password);
			Statement statement=connection.createStatement();
			String name = nameField.getText();
			String USN =  usnField.getText();
			int age =  Integer.parseInt( ageField.getText());
			int marks=Integer.parseInt(	ageField.getText());

			String query = "INSERT INTO STUDENT VALUES('" + USN + "','" + name + "'," + marks + "," + age+ ");";
			int res=statement.executeUpdate(query);
			if(res>0){
	            JOptionPane.showMessageDialog(frame,"Succesfully inserted");
			}
		} 
		catch (NumberFormatException e) {
			System.out.println("exception occured");
            JOptionPane.showMessageDialog(frame,"please insert the data");
		}
		catch (Exception e) {
			System.out.println(e);
            JOptionPane.showMessageDialog(frame,"data already exists");
		}
	
		
	}
	public void display(JFrame frame) {
		try {
			String query="Select *from student";

			Connection connection =DriverManager.getConnection(url,username,password);
			Statement statement=connection.createStatement();
			ResultSet res=statement.executeQuery(query);
			
			JFrame newFrame=new JFrame("student table");

	        JPanel panel = new JPanel();
	        panel.setPreferredSize(new Dimension(400, 300)); // Width 400 pixels, height 300 pixels

			

	        newFrame.add(panel);
	        newFrame.pack();
	        newFrame.setVisible(true);
			
			
			
			
			
			while(res.next()) {
				String name=res.getString("name");
				String usn=res.getString("usn");
				int age=res.getInt("age");
				double marks=res.getDouble("marks");
				
		        JTextArea descriptionText = new 				
		        JTextArea("name:"+name+"\nusn:"+usn+"\nage:"+age+"\nmarks:"+marks+"\n");
		        descriptionText.setEditable(false);
		        descriptionText.setPreferredSize(new Dimension(250, 100));

		        // Create layout and add components
		        panel.add(descriptionText);

		        // Add panel to frame and configure
				
			}
			
		}catch (Exception e) {
			
		}
	}

	public static void main(String[] args) {
		
		createGUI obj=new createGUI();
		obj.show();
	}

}
