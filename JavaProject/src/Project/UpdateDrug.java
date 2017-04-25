package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;

import Project.InsertDrugs.BackgroundContainer;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class UpdateDrug extends JFrame implements ActionListener{
	
	static final String JDBC_URL="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/health_care_management";
	static final String userName="root";
	static final String user_Password="root";
	
	String drugnname,mfgdate,expdate,selectNameS,checkString;
	int inStock,oStock,total,rem;
	JLabel undLJLabel,sheadLabel,ssubLabel,drugNameLabel,inStockLabel,outStockLabel,remainLabel,mfgDateLabel,expDateLabel,dateLabel3,dateLabel4,drugNameLabel2;
	JTextField drugTextField1,drugTextField2,drugInstockTextField,drugOutstockTextField,dexda1,dstock,dremain,dexda2,dexda3,dexda4;
	JButton submit,back,details;
	JPanel panel1;
	
	String date1,date2;
	
	UtilDateModel model2,model;
	JDatePanelImpl datePanel,datePanel2;
	JDatePickerImpl datePicker,datePicker2;
	BackgroundContainer backgroundContainer;
	
	public UpdateDrug()
	{
		backgroundContainer=new BackgroundContainer();
		backgroundContainer.setLayout(null);
		add(backgroundContainer);
		//setLayout(null);
		setTitle("Drugs");
		setBounds(200,10,1020,725);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		sheadLabel=new JLabel("UPDATING DRUGS"); 
		sheadLabel.setFont(new Font("arial", Font.BOLD, 35));
		sheadLabel.setForeground(Color.blue);
		sheadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sheadLabel.setBounds(250,20,360,60);
		backgroundContainer.add(sheadLabel);
		
		
		ssubLabel=new JLabel("_ _ _ _ _ _ _ _ _ _ _ _ _ ");
		ssubLabel.setFont(new Font("arial", Font.BOLD, 35));
		ssubLabel.setForeground(Color.blue);
		ssubLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ssubLabel.setBounds(240,15,400,100);
		backgroundContainer.add(ssubLabel);
		
		
		panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBorder(BorderFactory.createTitledBorder( null, "Show the details", TitledBorder.LEFT, TitledBorder.TOP, new Font("arial", Font.ITALIC, 25), Color.green));
		panel1.setBounds(5,100,800,200);
		panel1.setBackground(Color.blue);
		backgroundContainer.add(panel1);
		
		
		drugNameLabel=new JLabel("DRUG NAME");
		drugNameLabel.setFont(new Font("arial", Font.BOLD, 20));
		drugNameLabel.setForeground(Color.CYAN);
		//drugNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		drugNameLabel.setBounds(40,30,180,40);
		panel1.add(drugNameLabel);
		
		
		remainLabel=new JLabel("TOTAL DRUGS");
		remainLabel.setFont(new Font("arial", Font.BOLD, 20));
		remainLabel.setForeground(Color.cyan);
		//remainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		remainLabel.setBounds(40,70,180,40);
		panel1.add(remainLabel);
		
		dateLabel3=new JLabel("MFG DATE");
		dateLabel3.setFont(new Font("arial", Font.BOLD, 20));
		dateLabel3.setForeground(Color.cyan);
		dateLabel3.setBounds(40,110,180,40);
		panel1.add(dateLabel3);
		
		
		dateLabel4=new JLabel("EXP DATE");
		dateLabel4.setFont(new Font("arial", Font.BOLD, 20));
		dateLabel4.setForeground(Color.cyan);
		dateLabel4.setBounds(40,150,180,40);
		panel1.add(dateLabel4);
		
		
		
		
		drugTextField1=new JTextField(30);
		drugTextField1.setFont(new Font("arial", Font.BOLD, 18));
		drugTextField1.setBounds(220,30,300,30);
		panel1.add(drugTextField1);
		
		
		dremain=new JTextField(30);
		dremain.setEditable(false);
		dremain.setFont(new Font("arial", Font.BOLD, 18));
		dremain.setBounds(220,70,300,30);
		panel1.add(dremain);
		
		dexda1=new JTextField(30);
		dexda1.setEditable(false);
		dexda1.setFont(new Font("arial", Font.BOLD, 18));
		dexda1.setBounds(220,110,300,30);
		panel1.add(dexda1);
		
		
		dexda2=new JTextField(30);
		dexda2.setEditable(false);
		dexda2.setFont(new Font("arial", Font.BOLD, 18));
		dexda2.setBounds(220,150,300,30);
		panel1.add(dexda2);
		
		
		details=new JButton("DETAILS");
//		details.setBackground(Color.blue);
//		details.setForeground(Color.red);
		details.setFont(new Font("arial", Font.BOLD, 20));
		details.addActionListener(this);
		details.setBounds(600,30,150,40);
		panel1.add(details);
		
		
		drugNameLabel2=new JLabel("DRUG NAME");
		drugNameLabel2.setFont(new Font("arial", Font.BOLD, 20));
		drugNameLabel2.setForeground(Color.blue);
		//drugNameLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		drugNameLabel2.setBounds(40,310,160,40);
		backgroundContainer.add(drugNameLabel2);
		
		
		inStockLabel=new JLabel("NEW-ISTOCK");
		inStockLabel.setFont(new Font("arial", Font.BOLD, 20));
		inStockLabel.setForeground(Color.blue);
		inStockLabel.setBounds(40,360,160,40);
		backgroundContainer.add(inStockLabel);
		
		
		outStockLabel=new JLabel("NEW-OSTOCK");
		outStockLabel.setFont(new Font("arial", Font.BOLD, 20));
		outStockLabel.setForeground(Color.blue);
		outStockLabel.setBounds(40,410,160,40);
		backgroundContainer.add(outStockLabel);
		
		
		mfgDateLabel=new JLabel("MFG DATE");
		mfgDateLabel.setFont(new Font("arial", Font.BOLD, 20));
		mfgDateLabel.setForeground(Color.blue);
		mfgDateLabel.setBounds(40,460,160,40);
		backgroundContainer.add(mfgDateLabel);
		
		
		expDateLabel=new JLabel("EXP DATE");
		expDateLabel.setFont(new Font("arial", Font.BOLD, 20));
		expDateLabel.setForeground(Color.blue);
		expDateLabel.setBounds(40,510,160,40);
		backgroundContainer.add(expDateLabel);
		
		
		drugTextField2=new JTextField(30);
		drugTextField2.setFont(new Font("arial", Font.BOLD, 18));
		drugTextField2.setBounds(225,310,300,30);
		backgroundContainer.add(drugTextField2);
		
		drugInstockTextField=new JTextField(30);
		drugInstockTextField.setFont(new Font("arial", Font.BOLD, 18));
		drugInstockTextField.setBounds(225,360,300,30);
		backgroundContainer.add(drugInstockTextField);
		
		
		drugOutstockTextField=new JTextField(30);
		drugOutstockTextField.setFont(new Font("arial", Font.BOLD, 18));
		drugOutstockTextField.setBounds(225,410,300,30);
		backgroundContainer.add(drugOutstockTextField);
		
		
//		dexda3=new JTextField(30);
//		dexda3.setFont(new Font("arial", Font.BOLD, 18));
//		dexda3.setBounds(225,460,300,30);
//		getContentPane().add(dexda3);
//		
//		dexda4=new JTextField(30);
//		dexda4.setFont(new Font("arial", Font.BOLD, 18));
//		dexda4.setBounds(225,510,300,30);
//		getContentPane().add(dexda4);
		 model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
	    datePicker = new JDatePickerImpl(datePanel);
		
		//Date today=(Date) datePicker.getModel().getValue();
		datePicker.setBounds(225, 470, 200, 25);
		backgroundContainer.add(datePicker);
		//date1=(String) datePicker.getModel().getValue();
		
		
//		dExpDate=new JTextField(30);
//		dExpDate.setFont(new Font("arial", Font.BOLD, 18));
//		dExpDate.setBounds(250,370,430,40);
//		getContentPane().add(dExpDate);
		
		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2);
		datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.setBounds(225,520,200,25);

		backgroundContainer.add(datePicker2);
		date2=(String) datePicker.getModel().getValue();
		
		submit=new JButton("SUBMIT");
		submit.setFont(new Font("arial", Font.BOLD, 22));
		submit.setBounds(300,600,160,40);
		submit.setToolTipText("Press it to submit");
		submit.addActionListener(this);
		backgroundContainer.add(submit);
		
		back=new JButton("BACK");
		back.setFont(new Font("arial", Font.BOLD, 22));
		back.setBounds(500,600,160,40);
		back.setToolTipText("Press it to return");
		back.addActionListener(this);
		backgroundContainer.add(back);
		
		

		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UpdateDrug updateDrug=new UpdateDrug();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("BACK"))
		{
			dispose();
		}
		else if (e.getActionCommand().equals("DETAILS")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				
				try {
					Connection conn=DriverManager.getConnection(DB_URL,userName,user_Password);
				
					drugnname=drugTextField1.getText();
					PreparedStatement stmt=conn.prepareStatement("select total,mfgdate,expdate from drugs where drugname=?");
					
					stmt.setString(1, drugnname);
					ResultSet rSet=stmt.executeQuery();
					if(rSet.next())
					{
						dremain.setText(rSet.getString(1));
						dexda1.setText(rSet.getString(2));
						dexda2.setText(rSet.getString(3));
					}
					else {
						JOptionPane.showMessageDialog(null,drugnname+ " is not found"," ",JOptionPane.PLAIN_MESSAGE);
					}
					stmt.close();
					conn.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "this medicane is not found", "not found",JOptionPane.PLAIN_MESSAGE);
					e1.printStackTrace();
				}
				

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
		}
		else if (e.getActionCommand().equals("SUBMIT")) {
			
			drugnname=drugTextField2.getText();
			inStock=total;
			inStock=Integer.parseInt(drugInstockTextField.getText());
			oStock=Integer.parseInt(drugOutstockTextField.getText());
//			mfgdate=dexda3.getText();
//			expdate=dexda4.getText();
			 java.util.Date  date= (java.util.Date) datePicker.getModel().getValue();
			 SimpleDateFormat dateFormat1  = new SimpleDateFormat("dd-mm-yyyy");
			 date1= dateFormat1.format(date).toString();
			 //date1=date.toString();
			//String date=
			 java.util.Date   today=(java.util.Date) datePicker2.getModel().getValue();
			 date2= dateFormat1.format(today).toString();
			 date2=dateFormat1.format(date).toString();
			 total=inStock-oStock;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					Connection conn=DriverManager.getConnection(DB_URL,userName,user_Password);
				
					PreparedStatement stmt=conn.prepareStatement("update drugs set istock=?,ostock=?,mfgdate=?,expdate=?,total=? where drugname=?");
					
					stmt.setString(6, drugnname);
					stmt.setInt(1, inStock);
					stmt.setInt(2, oStock);
					stmt.setString(3,date1);
					stmt.setString(4, date2);
					stmt.setInt(5,total);
					stmt.executeUpdate();
					conn.commit();
					stmt.close();

					conn.close();
					//JOptionPane.showMessageDialog(null, "Drug is updated","Successfull",JOptionPane.INFORMATION_MESSAGE);     

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			
			
		}
		
	}
	class BackgroundContainer extends JPanel{
		
		private Image image;
		public BackgroundContainer() {
			image = (new ImageIcon(UpdateDrug.class.getResource("/resources/image8.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
