import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class GUI380CSC {

	private JFrame frame;
	private JTextField txtID;
	private JTextField txtPname;
	private JTextField txtPprice;
	private JTextField txtPqty;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI380CSC window = new GUI380CSC();
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
	public GUI380CSC() {
		Connect();
		initialize();
		table_load();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField textField;
	private JTextField textField_1;

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
	public void table_load() {
		    try {
		        //how to download the file form the rs2xml.jar
		        pst = con.prepareStatement("select * from Product");
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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1322, 859);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Online Shopping wepsite");
		lblNewLabel.setBounds(415, 11, 492, 45);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 37));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 74, 645, 502);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Product ID");
		lblNewLabel_1.setBounds(55, 130, 156, 53);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product name");
		lblNewLabel_1_1.setBounds(55, 225, 156, 53);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantity**");
		lblNewLabel_1_2.setBounds(55, 430, 156, 51);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Product price");
		lblNewLabel_1_3.setBounds(55, 325, 156, 51);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1_3);
		
		txtID = new JTextField();
		txtID.setBounds(235, 130, 167, 53);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtPname = new JTextField();
		txtPname.setBounds(235, 225, 167, 53);
		txtPname.setColumns(10);
		panel.add(txtPname);
		
		txtPprice = new JTextField();
		txtPprice.setBounds(235, 325, 167, 53);
		txtPprice.setColumns(10);
		panel.add(txtPprice);
		
		txtPqty = new JTextField();
		txtPqty.setBounds(235, 430, 167, 53);
		txtPqty.setColumns(10);
		panel.add(txtPqty);
		
		JLabel lblNewLabel_1_5 = new JLabel("Admin ID");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_5.setBounds(55, 44, 156, 53);
		panel.add(lblNewLabel_1_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(235, 44, 167, 53);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBounds(18, 600, 137, 70);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PId,Pname,Pprice,Pqty;
				PId=txtID.getText();
				Pname=txtPname.getText();
				Pprice=txtPprice.getText();
				Pqty=txtPqty.getText();
				try {
					    PreparedStatement pat = con.prepareStatement("insert into book (Id, Pname, price,qty) values (?,?,?,?)");
					 
					  pat.setString(1, PId);
					  pat.setString(2, Pname);
					  pat.setString(3, Pprice);
					  pat.setString(4, Pqty);
					  pat.executeUpdate();
					  
					  JOptionPane.showMessageDialog(null, "Record has been added");
					  table_load();
					 
					  txtID.setText("");
					  txtPname.setText("");
					  txtPprice.setText("");
					  txtPqty.setText("");
					  txtID.requestFocus();
					} catch (SQLException el) {
					  
					  el.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("CLEAR");
		btnUpdate.setBounds(332, 600, 137, 70);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 	txtID.setText("");
				 	txtPname.setText("");
				 	txtPprice.setText("");
				 	txtPqty.setText("");
			}
		});
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("EXIT");
		btnDelete.setBounds(173, 600, 137, 70);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(688, 100, 550, 488);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnUpdate_3 = new JButton("UPDATE");
		btnUpdate_3.setBounds(738, 604, 137, 63);
		btnUpdate_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PId,Pname,Pprice,Pqty;
				PId=txtID.getText();
				Pname=txtPname.getText();
				Pprice=txtPprice.getText();
				Pqty=txtPqty.getText();
				try {
					    PreparedStatement pat = con.prepareStatement("update Product set Pname=?,pprice=?,Pcatagory=? where Pid=?");
					 
					  
					  pat.setString(1, Pname);
					  pat.setString(2, Pprice);
					  pat.setString(3, Pqty);
					  pat.setString(4, PId);
					  pat.executeUpdate();
					  
					  JOptionPane.showMessageDialog(null, "Record has been updated");
					  table_load();
					 
					  txtID.setText("");
					  txtPname.setText("");
					  txtPprice.setText("");
					  txtPqty.setText("");
					  txtID.requestFocus();
					} catch (SQLException el) {
					  
					  el.printStackTrace();
					}
			}
		});
		btnUpdate_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnUpdate_3);
		
		JButton btnDelete_1 = new JButton("DELETE");
		btnDelete_1.setBounds(906, 604, 137, 63);
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PId;
				PId=txtID.getText();
				
				try {
					    PreparedStatement pat = con.prepareStatement("delete from Product where id =?");
					 
					  pat.setString(1, PId);
					 
					  pat.executeUpdate();
					  
					  JOptionPane.showMessageDialog(null, "Record has been deleted");
					  table_load();
					 
					  txtID.setText("");
					  txtPname.setText("");
					  txtPprice.setText("");
					  txtPqty.setText("");
					  txtID.requestFocus();
					} catch (SQLException el) {
					  
					  el.printStackTrace();
					}
			}
		});
		btnDelete_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnDelete_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 681, 600, 90);
		panel_1.setBorder(new TitledBorder(null, "search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("Product ID");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(50, 11, 156, 53);
		panel_1.add(lblNewLabel_1_4);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				 try {
                     
                     String id = txtID.getText();
                     //here i should the same attrbuit of the table in mysql 
                     pst = con.prepareStatement("select name,price,qty from Product where id = ?");
                         pst.setString(1, id);
                         ResultSet rs = pst.executeQuery();
                     if(rs.next()==true)
                     {
                       
                         String name = rs.getString(1);
                         String price = rs.getString(2);
                         String qty = rs.getString(3);
                         txtPname.setText(name);
                         txtPprice.setText(price);
                         txtPqty.setText(qty);
 
                     }   
                     else
                     {
                    	 txtPname.setText("");
                    	 txtPprice.setText("");
                    	 txtPqty.setText("");
                          
                     }
                 } 
             
              catch (SQLException ex) {
                    
                 }
         }
		});
		textField.setColumns(10);
		textField.setBounds(231, 11, 250, 53);
		panel_1.add(textField);
	}
}