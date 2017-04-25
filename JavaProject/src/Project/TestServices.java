package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class TestServices extends JFrame implements ActionListener {
	
	static final String JDBC_URL="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/health_care_management";
	static final String userName="root";
	static final String user_Password="root";
	
	JLabel stop,sdown,test1,test2,test3,test4,test5,test6,test7,test8,test9,test10,opno,date;
	JButton submit,back;
	JTextField topno,ttest1,ttest2,ttest3,ttest4,ttest5,ttest6,ttest7,ttest8,ttest9,ttest10,tdate;
	String opno1,date1,test1name,test2name,test3name,test4name,test5name,test6name,test7name,test8name,test9name,test10name;

    java.util.Date today;
    UtilDateModel model ;
    JDatePanelImpl datePanel ;
    JDatePickerImpl datePicker ;
    BackgroundContainer backgroundContainer;
	public TestServices()
	{
		backgroundContainer=new BackgroundContainer();
		backgroundContainer.setLayout(null);
		add(backgroundContainer);
		
		

		//setLayout(null);
        setTitle("");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200,10,1020,725);
	    stop=new JLabel("KUET Medical Center,KUET");
	    stop.setFont(new Font("Arial Narrow",Font.BOLD,24));
	    stop.setForeground(new Color(255,51,255));
	    stop.setHorizontalAlignment(SwingConstants.CENTER);
        stop.setBounds(120,20,590,30);
        backgroundContainer.add(stop);

          
        sdown=new JLabel("Tests");
	    sdown.setFont(new Font("Arial Narrow",Font.BOLD,18));
	    sdown.setForeground(Color.red);
	    sdown.setHorizontalAlignment(SwingConstants.CENTER);
        sdown.setBounds(300,60,250,20);
        backgroundContainer.add(sdown);

		 
		opno=new JLabel("IdNo:");
		opno.setFont(new Font("Arial Narrow",Font.BOLD,18));
		opno.setForeground(Color.green);
		opno.setHorizontalAlignment(SwingConstants.CENTER);
		opno.setBounds(60,85,180,40);
		backgroundContainer.add(opno);


        date=new JLabel("DATE:");
		date.setFont(new Font("Arial Narrow",Font.BOLD,18));
		date.setForeground(Color.green);
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setBounds(440,85,180,40);
		backgroundContainer.add(date);

        
		test1=new JLabel("Test1:");
		test1.setFont(new Font("Arial Narrow",Font.BOLD,18));
		test1.setForeground(Color.green);
		test1.setHorizontalAlignment(SwingConstants.CENTER);
		test1.setBounds(60,135,180,40);
		backgroundContainer.add(test1);


		test2=new JLabel("Test2:");
		test2.setFont(new Font("Arial Narrow",Font.BOLD,18));
		test2.setForeground(Color.green);
		test2.setHorizontalAlignment(SwingConstants.CENTER);
		test2.setBounds(60,185,180,40);
		backgroundContainer.add(test2);


		test3=new JLabel("Test3:");
		test3.setFont(new Font("Arial Narrow",Font.BOLD,18));
		test3.setForeground(Color.green);
		test3.setHorizontalAlignment(SwingConstants.CENTER);
		test3.setBounds(60,235,180,40);
		backgroundContainer.add(test3);


		test4=new JLabel("Test4:");
		test4.setFont(new Font("Arial Narrow",Font.BOLD,18));
		test4.setForeground(Color.green);
		test4.setHorizontalAlignment(SwingConstants.CENTER);
		test4.setBounds(60,285,180,40);
		backgroundContainer.add(test4);


		test5=new JLabel("Test5:");
		test5.setFont(new Font("Arial Narrow",Font.BOLD,18));
		test5.setForeground(Color.green);
		test5.setHorizontalAlignment(SwingConstants.CENTER);
		test5.setBounds(60,335,180,40);
		backgroundContainer.add(test5);

	
		test6=new JLabel("Test6:");
		test6.setFont(new Font("Arial Narrow",Font.BOLD,18));
		test6.setForeground(Color.green);
		test6.setHorizontalAlignment(SwingConstants.CENTER);
		test6.setBounds(60,395,180,40);
		backgroundContainer.add(test6);

  
		test7=new JLabel("Test7:");
		test7.setFont(new Font("Arial Narrow",Font.BOLD,18));
		test7.setForeground(Color.green);
		test7.setHorizontalAlignment(SwingConstants.CENTER);
		test7.setBounds(60,445,180,40);
		backgroundContainer.add(test7);

		
		test8=new JLabel("Test8:");
		test8.setFont(new Font("Arial Narrow",Font.BOLD,18));
		test8.setForeground(Color.green);
		test8.setHorizontalAlignment(SwingConstants.CENTER);
		test8.setBounds(60,495,180,40);
		backgroundContainer.add(test8);


		test9=new JLabel("Test9:");
		test9.setFont(new Font("Arial Narrow",Font.BOLD,18));
		test9.setForeground(Color.green);
		test9.setHorizontalAlignment(SwingConstants.CENTER);
		test9.setBounds(60,545,180,40);
		backgroundContainer.add(test9);


		test10=new JLabel("Test10:");
		test10.setFont(new Font("Arial Narrow",Font.BOLD,18));
		test10.setForeground(Color.green);
		test10.setHorizontalAlignment(SwingConstants.CENTER);
		test10.setBounds(60,595,180,40);
		backgroundContainer.add(test10);
		
		

		topno=new JTextField("");
		topno.setFont(new Font("Times New Roman",Font.BOLD,18));
		topno.setForeground(Color.green);
		topno.setBounds (180,90,180,30);
		backgroundContainer.add(topno);

        
        
	    model = new UtilDateModel();
	    datePanel = new JDatePanelImpl(model);
	    datePicker = new JDatePickerImpl(datePanel);
	    datePicker.setForeground(Color.green);
	    datePicker.setBounds (580,90,180,25);
	    backgroundContainer.add(datePicker);
	    today=(java.util.Date) datePicker.getModel().getValue();


		ttest1=new JTextField("");
		ttest1.setFont(new Font("Times New Roman",Font.BOLD,18));
		ttest1.setForeground(Color.green);
		ttest1.setBounds (180,140,550,30);
		backgroundContainer.add(ttest1);

	
		ttest2=new JTextField("");
		ttest2.setFont(new Font("Times New Roman",Font.BOLD,18));
		ttest2.setForeground(Color.green);
		ttest2.setBounds (180,190,550,30);
		backgroundContainer.add(ttest2);


		ttest3=new JTextField("");
		ttest3.setFont(new Font("Times New Roman",Font.BOLD,18));
		ttest3.setForeground(Color.green);
		ttest3.setBounds (180,240,550,30);
		backgroundContainer.add(ttest3);


		ttest4=new JTextField("");
		ttest4.setFont(new Font("Times New Roman",Font.BOLD,18));
		ttest4.setForeground(Color.green);
		ttest4.setBounds (180,290,550,30);
		backgroundContainer.add(ttest4);

        
		ttest5=new JTextField("");
		ttest5.setFont(new Font("Times New Roman",Font.BOLD,18));
		ttest5.setForeground(Color.green);
		ttest5.setBounds (180,340,550,30);
		backgroundContainer.add(ttest5);


		ttest6=new JTextField("");
		ttest6.setFont(new Font("Times New Roman",Font.BOLD,18));
		ttest6.setForeground(Color.green);
		ttest6.setBounds (180,400,550,30);
		backgroundContainer.add(ttest6);


		ttest7=new JTextField("");
		ttest7.setFont(new Font("Times New Roman",Font.BOLD,18));
		ttest7.setForeground(Color.green);
		ttest7.setBounds (180,450,550,30);
		backgroundContainer.add(ttest7);

		
		ttest8=new JTextField("");
		ttest8.setFont(new Font("Times New Roman",Font.BOLD,18));
		ttest8.setForeground(Color.green);
		ttest8.setBounds (180,500,550,30);
		backgroundContainer.add(ttest8);


		ttest9=new JTextField("");
		ttest9.setFont(new Font("Times New Roman",Font.BOLD,18));
		ttest9.setForeground(Color.green);
		ttest9.setBounds (180,550,550,30);
		backgroundContainer.add(ttest9);


		ttest10=new JTextField("");
		ttest10.setFont(new Font("Times New Roman",Font.BOLD,18));
		ttest10.setForeground(Color.green);
		ttest10.setBounds (180,600,550,30);
		backgroundContainer.add(ttest10);
        
        
 	    submit=new JButton("Submit");
 	    submit.setFont(new Font("Arial Narrow",Font.BOLD,22));
        submit.setBounds(300,645,160,40);
 	    submit.setForeground(Color.green);
 	    submit.setBackground(Color.gray);
        submit.addActionListener(this);
        submit.setToolTipText("Press to submit the detials");
        backgroundContainer.add(submit); 

      
 	   
 	    back=new JButton("Back");
        back.setFont(new Font("Arial Narrow",Font.BOLD,22));
        back.setBounds(480,645,160,40);
 	    back.setForeground(Color.green);
 	    back.setBackground(Color.gray);
        back.addActionListener(this);
        back.setToolTipText("PRESS TO DISPOSE");
        backgroundContainer.add(back); 
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestServices tServices=new TestServices();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Back")) {
			dispose();
			
		}
		else if (e.getActionCommand().equals("Submit")) {
			

			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				try {
					Connection con=DriverManager.getConnection(DB_URL,userName,user_Password);

		              opno1=topno.getText();
		              

					  //date1=tdate.getText();
		              
					   java.util.Date  date=(java.util.Date) datePicker.getModel().getValue();
					   date1=date.toString();
					  test1name=ttest1.getText();
					  test2name=ttest2.getText();
					  test3name=ttest3.getText();
					  test4name=ttest4.getText();
					  test5name=ttest5.getText();
					  test6name=ttest6.getText();
					  test7name=ttest7.getText();
					  test8name=ttest8.getText();
					  test9name=ttest9.getText();
					  test10name=ttest10.getText();
					  PreparedStatement pstm=(PreparedStatement) con.prepareStatement("insert into testservice values(?,?,?,?,?,?,?,?,?,?,?,?)");
					  
		              pstm.setString(1,opno1);
					  pstm.setString(2,date1);
		              pstm.setString(3,test1name);
					  pstm.setString(4,test2name);
					  pstm.setString(5,test3name);
					  pstm.setString(6,test4name);
					  pstm.setString(7,test5name);
					  pstm.setString(8,test6name);
					  pstm.setString(9,test7name);
					  pstm.setString(10,test8name);
					  pstm.setString(11,test9name);
					  pstm.setString(12,test10name);
									
					  pstm.executeUpdate();
									
					  pstm.close();
									
					  con.close();
					                      

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Not registered","Error",JOptionPane.ERROR_MESSAGE);
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
			image = (new ImageIcon(TestServices.class.getResource("/resources/image2.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
