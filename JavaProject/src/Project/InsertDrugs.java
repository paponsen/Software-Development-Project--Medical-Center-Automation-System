package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.prefs.BackingStoreException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class InsertDrugs extends JFrame implements ActionListener {
	
	
	static final String JDBC_URL="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/health_care_management";
	static final String userName="root";
	static final String user_Password="root";
	
	
	
	String date1,date2;
	String drugName,expDate,mfgDate;
	int inStock,totalDrugs;
	JLabel shead,ssub,dname,inStocklLabel,expDatelLabel,mfgDatelLabel,warn1,warn2,warn3;
	JTextField dTextField,dInstock,dExpDate,dMfgDate;
	JButton submit,back;
	//JLabel image;
	UtilDateModel model2,model;
	JDatePanelImpl datePanel,datePanel2;
	JDatePickerImpl datePicker,datePicker2;
	BackgroundContainer backgroundContainer;
	
	public InsertDrugs()
	{
		backgroundContainer=new BackgroundContainer();
		backgroundContainer.setLayout(null);
		add(backgroundContainer);
		
		//setLayout(null);
		setTitle("Drugs");
		setBounds(200,10,1020,725);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setResizable(false);
		//image=new JLabel();
		//image.setIcon(new ImageIcon("C:\\Users\\papon\\Desktop\\New folder (2)\\~_Project_HealthCare Management System-Enggroom.Com\\he-ca-ma\\1\\code\\img.jpg"));
		//image.setBounds(0,0,1020,725);
		
		//getContentPane().add(image);
		
		
		
		shead=new JLabel("INSERT THE DRUGS");
		shead.setFont(new Font("arial", Font.BOLD, 35));
		shead.setForeground(Color.blue);
		shead.setHorizontalAlignment(SwingConstants.CENTER);
		shead.setBounds(250,20,360,60);
		//getContentPane().add(shead);
		backgroundContainer.add(shead);
		
	
		ssub=new JLabel("_ _ _ _ _ _ _ _ _ _ _ _ _ ");
		ssub.setFont(new Font("arial", Font.BOLD, 35));
		ssub.setForeground(Color.blue);
		ssub.setHorizontalAlignment(SwingConstants.CENTER);
		ssub.setBounds(240,15,400,100);
		//getContentPane().add(ssub);
		backgroundContainer.add(ssub);
		
		
		dname=new JLabel("DRUG NAME");
		dname.setFont(new Font("arial", Font.BOLD, 24));
		dname.setForeground(Color.green);
		dname.setHorizontalAlignment(SwingConstants.CENTER);
		dname.setBounds(70,130,180,40);
		//getContentPane().add(dname);
		backgroundContainer.add(dname);
		
		
		inStocklLabel=new JLabel("IN-STOCK");
		inStocklLabel.setFont(new Font("arial", Font.BOLD, 24));
		inStocklLabel.setForeground(Color.green);
		inStocklLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inStocklLabel.setBounds(80,214,140,40);
		//getContentPane().add(inStocklLabel);
		backgroundContainer.add(inStocklLabel);
//		warn1=new JLabel("(Enter only Integers)");
//		warn1.setFont(new Font("arial", Font.BOLD, 10));
//		warn1.setForeground(Color.red);
//		warn1.setHorizontalAlignment(SwingConstants.TRAILING);
//		warn1.setBounds(720,214,170,40);
//		getContentPane().add(warn1);
		
		mfgDatelLabel=new JLabel("MFG DATE");
		mfgDatelLabel.setFont(new Font("arial", Font.BOLD, 24));
		mfgDatelLabel.setForeground(Color.green);
		mfgDatelLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		mfgDatelLabel.setBounds(90,300,130,40);
		//getContentPane().add(mfgDatelLabel);
		backgroundContainer.add(mfgDatelLabel);
		
		
		expDatelLabel=new JLabel("EXP DATE");
		expDatelLabel.setFont(new Font("arial",Font.BOLD,24));
		expDatelLabel.setForeground(Color.green);
		expDatelLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		expDatelLabel.setBounds(90,370,130, 40);
		//getContentPane().add(expDatelLabel);
		backgroundContainer.add(expDatelLabel);
		
		
		dTextField=new JTextField(30);
		dTextField.setFont(new Font("arial", Font.BOLD, 18));
		dTextField.setBounds(250,130,430,40);
		//getContentPane().add(dTextField);
		backgroundContainer.add(dTextField);
		
		
		dInstock=new JTextField(30);
		dInstock.setFont(new Font("arial", Font.BOLD, 18));
		dInstock.setBounds(250,215,430,40);
		//getContentPane().add(dInstock);
		backgroundContainer.add(dInstock);
		
//		dMfgDate=new JTextField(30);
//		dMfgDate.setFont(new Font("arial", Font.BOLD, 18));
//		dMfgDate.setBounds(250,300,430,40);
//		getContentPane().add(dMfgDate);
		
		 model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
	    datePicker = new JDatePickerImpl(datePanel);
		
		//Date today=(Date) datePicker.getModel().getValue();
		datePicker.setBounds(250, 310, 200, 25);
		//getContentPane().add(datePicker);
		backgroundContainer.add(datePicker);
		//date1=(String) datePicker.getModel().getValue();
		
		
//		dExpDate=new JTextField(30);
//		dExpDate.setFont(new Font("arial", Font.BOLD, 18));
//		dExpDate.setBounds(250,370,430,40);
//		getContentPane().add(dExpDate);
		
		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2);
		datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.setBounds(250,380,200,25);

		//getContentPane().add(datePicker2);
		backgroundContainer.add(datePicker2);
		date2=(String) datePicker.getModel().getValue();
		
		
		

		
		
		submit=new JButton("SUBMIT");
		submit.setFont(new Font("arial", Font.BOLD, 20));
		submit.setForeground(Color.black);
		submit.setBounds(200,480,110,30);
		submit.setForeground(new Color(0,0,255));
		//submit.setBackground(new Color(0,255,255));
		submit.setBackground(Color.gray);
		submit.setToolTipText("Press to submit the details");
		submit.addActionListener(this);
		//getContentPane().add(submit);
		backgroundContainer.add(submit);
		
		
		back=new JButton("BACK");
		back.setFont(new Font("arial", Font.BOLD, 20));
		back.setBounds(470,480,100,30);
		back.setForeground(new Color(0,0,255));
		//back.setBackground(new Color(0,255,255));
		back.setBackground(Color.gray);
		back.setToolTipText("Press to return back");
		back.addActionListener(this);
		//getContentPane().add(back);
		backgroundContainer.add(back);
		
		
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertDrugs insertDrugs=new InsertDrugs();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getActionCommand().equals("BACK"))
		{
			dispose();
		}
		
		else if (event.getActionCommand().equals("SUBMIT")) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					
					Connection conn=DriverManager.getConnection(DB_URL,userName,user_Password);
					drugName=dTextField.getText();
					inStock=Integer.parseInt(dInstock.getText());
					//mfgDate=dMfgDate.getText();
					//Date 
					 java.util.Date  date=(java.util.Date) datePicker.getModel().getValue();
					 SimpleDateFormat dateFormat1  = new SimpleDateFormat("dd-mm-yyyy");
					 date1= dateFormat1.format(date).toString();
					//String date=
					 java.util.Date   today=(java.util.Date) datePicker2.getModel().getValue();
					 date2= dateFormat1.format(today).toString();
					 
					
					
					//expDate=dExpDate.getText();
					totalDrugs=inStock;
					
					PreparedStatement stmt=conn.prepareStatement("insert into drugs(drugname,istock,mfgdate,expdate,total) values (?,?,?,?,?)");
					
					stmt.setString(1, drugName);
					stmt.setInt(2, inStock);
					stmt.setString(3, date1);
					stmt.setString(4, date2);
					stmt.setInt(5, totalDrugs);
					//System.out.println(date1);
					
					stmt.executeUpdate();
					stmt.close();
					conn.close();
					JOptionPane.showMessageDialog(null, "Drug inserted","Success",JOptionPane.INFORMATION_MESSAGE);                 

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Drug is not inserted","Error",JOptionPane.ERROR_MESSAGE);     
					
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Drug is not inserted","Error",JOptionPane.ERROR_MESSAGE);     

				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//JOptionPane.showMessageDialog(null, "Drug is not inserted","Error",JOptionPane.ERROR_MESSAGE);     

				e.printStackTrace();
				
			}
			
		}
		
		
	}
	class BackgroundContainer extends JPanel{
		
		private Image image;
		public BackgroundContainer() {
			image = (new ImageIcon(InsertDrugs.class.getResource("/resources/image8.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
