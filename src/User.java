import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class User {

	private JFrame frame;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtphoneN;
	private JTextField txtemail;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User window = new User();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public User() {
		initialize();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	

	public void Connect()
	{
	    try
	    {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online shopping website", "root", "");
	    }
	    catch (ClassNotFoundException ex)
	    {		        ex.getMessage();


	    }
	    catch (SQLException ex)
	    {
	        ex.getMessage();

	    }
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 842, 604);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User interface");
		lblNewLabel.setBounds(0, 0, 826, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "user information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 44, 453, 331);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(2, 102, 132, 51);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("User id");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(2, 40, 132, 51);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("User phonenumber");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_2.setBounds(2, 179, 211, 51);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("User eamil");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_3.setBounds(2, 241, 132, 51);
		panel.add(lblNewLabel_1_3);
		
		txtid = new JTextField();
		txtid.setBounds(223, 56, 152, 30);
		panel.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(223, 122, 152, 30);
		panel.add(txtname);
		
		txtphoneN = new JTextField();
		txtphoneN.setColumns(10);
		txtphoneN.setBounds(223, 195, 152, 30);
		panel.add(txtphoneN);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(223, 273, 152, 30);
		panel.add(txtemail);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,name,phoneN,email;
				id=txtid.getText();
				name=txtname.getText();
				phoneN=txtphoneN.getText();
				email=txtemail.getText();
				try {
					    PreparedStatement pat = con.prepareStatement("insert into user (Id, Name, phonenumber,email) values (?,?,?,?)");
					 
					  pat.setString(1, id);
					  pat.setString(2, name);
					  pat.setString(3, phoneN);
					  pat.setString(4, email);
					  pat.executeUpdate();
					  
					  JOptionPane.showMessageDialog(null, "Record has been added");
					 // table_load();
					 
					 txtid.setText("");
					  txtname.setText("");
					  txtphoneN.setText("");
					  txtemail.setText("");
					  //here check
					  //txtuid.requestFocus();
					} catch (SQLException el) {
					  
					  el.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(20, 386, 136, 62);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(166, 386, 136, 62);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(310, 386, 136, 62);
		frame.getContentPane().add(btnUpdate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 459, 476, 95);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("User Id");
		lblNewLabel_1_4.setBounds(31, 23, 116, 43);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(157, 23, 278, 43);
		textField_4.setColumns(10);
		panel_1.add(textField_4);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(496, 480, 136, 62);
		frame.getContentPane().add(btnExit);
		
		table = new JTable();
		table.setBounds(473, 44, 343, 331);
		frame.getContentPane().add(table);
	}
}
