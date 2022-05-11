
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;
import java.sql.*;

public class StudentsApp extends JFrame implements ActionListener {
	public static void main(String args[]) {
		StudentsApp  stdapp = new StudentsApp();
	
	}

	private JPanel panel;
	private JLabel lName, lAdd, lEmail, lPhone, lDept, lCity;
	JTextField tName, tAdd, tEmail, tDept, tPhone, tCity;
	private JButton reset, submit;
	private Connection con;
	private PreparedStatement prep;
	
	public StudentsApp(){
		super("Student Manageent System");
		setUI();
	}
	
	public void setUI() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width)/3, (screenSize.height)/7);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		lName = new JLabel("Name:");
		lName.setBounds(100, 100, 150, 30);
		lName.setLocation(10, 10);
		panel.add(lName);
		
		tName = new JTextField();
		tName.setBounds(100, 100, 200, 30);
		tName.setLocation(100, 10);
		panel.add(tName);
		
		lAdd = new JLabel("Address:");
		lAdd.setBounds(100, 100, 150, 30);
		lAdd.setLocation(10, 50);
		panel.add(lAdd);
		
		tAdd = new JTextField();
		tAdd.setBounds(100, 100, 200, 30);
		tAdd.setLocation(100, 50);
		panel.add(tAdd);
		
		lEmail = new JLabel("Email:");
		lEmail.setBounds(100, 100, 150, 30);
		lEmail.setLocation(10, 90);
		panel.add(lEmail);
		
		tEmail = new JTextField();
		tEmail.setBounds(100, 100, 200, 30);
		tEmail.setLocation(100, 90);
		panel.add(tEmail);
		
		lPhone = new JLabel("Tel:");
		lPhone.setBounds(100, 100, 150, 30);
		lPhone.setLocation(10, 130);
		panel.add(lPhone);
		

		tPhone = new JTextField();
		tPhone.setBounds(100, 100, 200, 30);
		tPhone.setLocation(100, 130);
		panel.add(tPhone);
		
		
		lDept = new JLabel("Department:");
		lDept.setBounds(100, 100, 150, 30);
		lDept.setLocation(10, 170);
		panel.add(lDept);
		
		tDept = new JTextField();
		tDept.setBounds(100, 100, 200, 30);
		tDept.setLocation(100, 170);
		panel.add(tDept);
		
		
		lCity = new JLabel("City:");
		lCity.setBounds(100, 100, 150, 30);
		lCity.setLocation(10, 210);
		panel.add(lCity);
		
		tCity = new JTextField();
		tCity.setBounds(100, 100, 200, 30);
		tCity.setLocation(100, 210);
		panel.add(tCity);
		
		reset = new JButton("Reset");
		reset.setBounds(100, 100, 150, 40);
		reset.addActionListener(this);
		reset.setLocation(10, 260);
		panel.add(reset);
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		submit.setBounds(100, 100, 150, 40);
		submit.setLocation(180, 260);
		panel.add(submit);
		
		
		this.add(panel);
		
		this.setSize(500, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == reset) {
			tName.setText("");
			tEmail.setText("");
			tAdd.setText(" ");
			tPhone.setText(" ");
			tDept.setText("");
			tCity.setText("");
			JOptionPane.showMessageDialog(null, "Hi, Thank you for Cleaming My Fields!", "Fields Erased", JOptionPane.INFORMATION_MESSAGE);
			reset.setText("Hey! You Clicked Me");
		}
		
		if(ae.getActionCommand().equals("Submit")) {
			String path = "jdbc:mysql://localhost:3306/faculties";
			try {
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(path, "root", "bassanio");
			
			String name = tName.getText();
			String email = tEmail.getText();
			String add = tAdd.getText();
			String phone = tPhone.getText();
			String dept = tDept.getText();
			String city = tCity.getText();
			
			prep = con.prepareStatement("Insert into StudentDetails Values(?, ?, ?, ?, ?, ?)");
			prep.setString(1, name);
			prep.setString(2, email);
			prep.setString(3, add);
			prep.setString(4, phone);
			prep.setString(5, dept);
			prep.setString(6, city);
			
			int optionChosen = JOptionPane.showConfirmDialog(null,  "Are you sure you want to submit?", "Submit?", JOptionPane.YES_NO_OPTION);
			if(optionChosen == 0) {
			
			prep.executeUpdate();
			JOptionPane.showMessageDialog(null,  "Thank you, your Information has been submitted", "Info Submitted", JOptionPane.INFORMATION_MESSAGE);
			tName.setText("");
			tEmail.setText("");
			tAdd.setText("");
			tPhone.setText("");
			tDept.setText("");
			tCity.setText("");
			}
			}
			catch(Exception exc) {
			System.out.println("OOsp the connection was not successful!");
			}
		}
	}
}

