import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class shopping_website {

	private JFrame frame;
	private JTextField txtuid;
	private JTextField txtWname;
	private JTextField txtWurl;
	private JTextField txtType;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shopping_website window = new shopping_website();
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
	public shopping_website() {
		initialize();
		Connect();
		table_load();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	

	public void Connect()
	{
	    try
	    {
	        Class.forName("com.mysql.cj.jdbc.Driver");
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
	public void table_load() {
	    try {
	        //how to download the file form the rs2xml.jar
	        pst = con.prepareStatement("select * from shopping wepsite");
	        rs = pst.executeQuery();
	        table.setModel(DbUtils.resultSetToTableModel(rs));
	    } catch (SQLException e) {
	        e.getMessage();
	    }
	
	
}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 853, 618);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "website information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 73, 409, 305);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("UserId");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 35, 95, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("website name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(10, 99, 177, 37);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("website url");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(10, 165, 129, 37);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("typeOfWebsite");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(10, 237, 177, 37);
		panel.add(lblNewLabel_1_3);
		
		txtuid = new JTextField();
		txtuid.setBounds(198, 35, 143, 34);
		panel.add(txtuid);
		txtuid.setColumns(10);
		
		txtWname = new JTextField();
		txtWname.setColumns(10);
		txtWname.setBounds(197, 102, 143, 34);
		panel.add(txtWname);
		
		txtWurl = new JTextField();
		txtWurl.setColumns(10);
		txtWurl.setBounds(198, 168, 143, 34);
		panel.add(txtWurl);
		
		txtType = new JTextField();
		txtType.setColumns(10);
		txtType.setBounds(197, 240, 143, 34);
		panel.add(txtType);
		
		JLabel lblNewLabel = new JLabel("shopping website");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
		lblNewLabel.setBounds(245, 11, 310, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Uid,Wname,Wurl,Wtype;
				Uid=txtuid.getText();
				Wname=txtWname.getText();
				Wurl=txtWurl.getText();
				Wtype=txtType.getText();
				try {
					    PreparedStatement pat = con.prepareStatement("insert into shopping wepsite (website_name, website_url, typeOfWebsite,Admin) values (?,?,?,?)");
					 
					  pat.setString(4, Uid);
					  pat.setString(1, Wname);
					  pat.setString(2, Wurl);
					  pat.setString(3, Wtype);
					  pat.executeUpdate();
					  
					  JOptionPane.showMessageDialog(null, "Record has been added");
					  table_load();
					 
					  txtuid.setText("");
					  txtWname.setText("");
					  txtWurl.setText("");
					  txtType.setText("");
					  //here check
					  txtuid.requestFocus();
					} catch (SQLException el) {
					  
					  el.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(20, 389, 137, 70);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String websitename;
				websitename=txtWname.getText();
				
				try {
					    PreparedStatement pat = con.prepareStatement("delete from shopping wepsite where website_name =?");
					 
					  pat.setString(1, websitename);
					 
					  pat.executeUpdate();
					  
					  JOptionPane.showMessageDialog(null, "Record has been deleted");
					  table_load();
					 
					  txtuid.setText("");
					  txtWname.setText("");
					  txtWurl.setText("");
					  txtType.setText("");
					  //txtWname.requestFocus();
					  txtuid.requestFocus();
					} catch (SQLException el) {
					  
					  el.printStackTrace();
					}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(167, 389, 137, 70);
		frame.getContentPane().add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 470, 600, 90);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("website name");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(50, 11, 156, 53);
		panel_1.add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
 try {
                     
                     String wName = txtWname.getText();
                     //here i should the same attrbuit of the table in mysql 
                     pst = con.prepareStatement("select adminid,website_name,website_url,typeOfWebsite from shopping wepsite where website_name = ?");
                         pst.setString(1, wName);
                         ResultSet rs = pst.executeQuery();
                     if(rs.next()==true)
                     {
                       
                         String Uid= rs.getString(1);
                         String Wname = rs.getString(2);
                         String Wurl = rs.getString(3);
                         String Wtype = rs.getString(4);
                        txtuid.setText(Uid);
   					  	txtWname.setText(Wname);
   					  	txtWurl.setText(Wurl);
   					  	txtType.setText(Wtype);
                         
 
                     }   
                     else
                     {
                    	 txtuid.setText("");
   					  	txtWname.setText("");
   					  	txtWurl.setText("");
   					  	txtType.setText("");
                     }
                 } 
             
              catch (SQLException ex) {
                    
                 }
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(231, 11, 250, 53);
		panel_1.add(textField_4);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Uid,Wname,Wurl,Wtype;
				Uid=txtuid.getText();
				Wname=txtWname.getText();
				Wurl=txtWurl.getText();
				Wtype=txtType.getText();
				try {
					    PreparedStatement pat = con.prepareStatement("update shopping wepsite set adminid=?, website_name=?, website_url=?,typeOfWebsite=? ");
					 
					  pat.setString(1, Uid);
					  pat.setString(2, Wname);
					  pat.setString(3, Wurl);
					  pat.setString(4, Wtype);
					  pat.executeUpdate();
					  
					  JOptionPane.showMessageDialog(null, "Record has been updated");
					  table_load();
					 
					  txtuid.setText("");
					  txtWname.setText("");
					  txtWurl.setText("");
					  txtType.setText("");
					  //here check
					  txtuid.requestFocus();
					} catch (SQLException el) {
					  
					  el.printStackTrace();
					}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(334, 389, 137, 70);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(669, 479, 137, 70);
		frame.getContentPane().add(btnExit);
		
		table = new JTable();
		table.setBounds(452, 73, 354, 305);
		frame.getContentPane().add(table);
	}
}
