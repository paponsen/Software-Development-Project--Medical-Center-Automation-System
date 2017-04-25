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
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class OutRecord extends JFrame implements ActionListener {
	
	static final String JDBC_URL="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/health_care_management";
	static final String userName="root";
	static final String user_Password="root";

    String pname,pdate,pdiag,psex,poccu;
    int page,popno;   
    JLabel head,shead,name,age,opno,date,sex,diag,occu;
    JTextField tname,tage,tdate,topno,toccu;
    JTextArea dtext;
    JButton but1,but2;
    JRadioButton rad1,rad2;
    ButtonGroup bgroup;
    java.util.Date today;
    UtilDateModel model ;
    JDatePanelImpl datePanel ;
    JDatePickerImpl datePicker ;
    BackgroundContainer backgroundContainer;
    
    public OutRecord()
    {
    	backgroundContainer=new BackgroundContainer();
    	backgroundContainer.setLayout(null);
    	add(backgroundContainer);
    	//setLayout(null);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setBounds(200,10,1020,725);
    	
    	head=new JLabel("KUET MEDICAL CENTER,KUET");
    	head.setFont(new Font("arial", Font.BOLD,40 ));
  	    head.setForeground(Color.green);
  	    head.setHorizontalAlignment(SwingConstants.CENTER);
        head.setBounds(150,50,660,60);
        backgroundContainer.add(head);
  	    
  	    
  	    shead=new JLabel("Out-Paitent Registration");
  	    shead.setFont(new Font("Arial Narrow",Font.BOLD,30));
  	    shead.setForeground(new Color(51,51,255));
  	    shead.setHorizontalAlignment(SwingConstants.CENTER);
        shead.setBounds(280,120,330,50);
        backgroundContainer.add(shead);
  	    
  	    
  	    name=new JLabel("Name");
  	    name.setFont(new Font("Arial Narrow",Font.BOLD,16));
  	    name.setForeground(Color.green);
  	    name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setBounds(120,200,80,30);
        backgroundContainer.add(name);
  	    
  	    
  	    age=new JLabel("Age");
  	    age.setFont(new Font("Arial Narrow",Font.BOLD,16));
  	    age.setForeground(Color.GREEN);
  	    age.setHorizontalAlignment(SwingConstants.CENTER); 
        age.setBounds(500,200,40,30);
        backgroundContainer.add(age);
  	    
  	    
  	    opno=new JLabel("I.D.No");
  	    opno.setFont(new Font("Arial Narrow",Font.BOLD,16));
  	    opno.setForeground(Color.GREEN);
  	    opno.setHorizontalAlignment(SwingConstants.CENTER);
        opno.setBounds(120,250,60,30);
        backgroundContainer.add(opno);
  	    
  	    date=new JLabel("Date");
  	    date.setFont(new Font("Arial Narrow",Font.BOLD,16));
  	    date.setForeground(Color.GREEN);
  	    date.setHorizontalAlignment(SwingConstants.LEADING);
        date.setBounds(530,250,40,30);
        backgroundContainer.add(date);
  	    
  	    
  	    sex=new JLabel("Sex");
	    sex.setFont(new Font("Arial Narrow",Font.BOLD,16));
	    sex.setForeground(Color.green);
	    sex.setHorizontalAlignment(SwingConstants.CENTER);
        sex.setBounds(120,310,60,30);
        backgroundContainer.add(sex);
	    
	    
	    occu=new JLabel("Occupation");
	 	occu.setFont(new Font("Arial Narrow",Font.BOLD,16));
	    occu.setForeground(Color.GREEN);
	 	occu.setHorizontalAlignment(SwingConstants.CENTER);
	    occu.setBounds(480,310,100,30);
	    backgroundContainer.add(occu);
	 	
	 	
        diag=new JLabel("Diagnosis");
	    diag.setFont(new Font("Arial Narrow",Font.BOLD,16));
	    diag.setForeground(Color.GREEN);
	    diag.setHorizontalAlignment(SwingConstants.CENTER);
        diag.setBounds(110,370,80,30);
        backgroundContainer.add(diag);
	    
	    model = new UtilDateModel();
	    datePanel = new JDatePanelImpl(model);
	    datePicker = new JDatePickerImpl(datePanel);
	    datePicker.setBounds(600,250,150,25);
	    backgroundContainer.add(datePicker);
	    today=(java.util.Date) datePicker.getModel().getValue();
	   
	    
        tname=new JTextField(30);
	    tname.setFont(new Font("Arial Narrow",Font.BOLD,12));
        tname.setBounds(200,200,240,30);
        backgroundContainer.add(tname);
        
  	    tage=new JTextField(30);
  	    tage.setFont(new Font("Arial Narrow",Font.BOLD,12));
        tage.setBounds(550,200,100,30);
        backgroundContainer.add(tage);
        
        
  	    topno=new JTextField(30);
  	    topno.setFont(new Font("Arial Narrow",Font.BOLD,12));
        topno.setBounds(200,250,240,30);
        backgroundContainer.add(topno);
        
        

  	    toccu=new JTextField(30);
  	    toccu.setFont(new Font("Arial Narrow",Font.BOLD,12));
        toccu.setBounds(590,310,250,30);
        backgroundContainer.add(toccu);



        dtext=new JTextArea(5,10);
	    dtext.setBounds(200,380,480,200);
	    backgroundContainer.add(dtext);
        
        
        but1=new JButton("Submit");
        but1.setFont(new Font("Arial Narrow",Font.BOLD,18));
        but1.setBounds(350,600,100,40);
	    but1.setForeground(Color.blue);
	    but1.setBackground(Color.gray);
        but1.addActionListener(this);
        but1.setToolTipText("Press to submit the detials");
        backgroundContainer.add(but1); 
        
        
        but2=new JButton("Exit");
        but2.setFont(new Font("Arial Narrow",Font.BOLD,18)); 
        but2.setBounds(500,600,100,40);
        but2.setForeground(Color.blue);
        but2.setBackground(Color.gray);
        but2.addActionListener(this);
        but2.setToolTipText("Press to Register Student as the In-Paitent ");
        backgroundContainer.add(but2);
        
  	    rad1=new JRadioButton("Male");
  	    rad1.setActionCommand("male");
  	    rad1.setBounds(200, 320, 85, 15);             
  	  backgroundContainer.add(rad1); 
        
        
        rad2=new JRadioButton("Female");
        rad2.setActionCommand("female");
  	    rad2.setBounds(330, 320, 85, 15);         
  	  backgroundContainer.add(rad2);

        bgroup=new ButtonGroup();
        bgroup.add(rad1);
        bgroup.add(rad2);
       


  	    
  	    
  	    setVisible(true);
  	    

    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutRecord outRecord=new OutRecord();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Exit"))
		{
			dispose();
		}
		else if (e.getActionCommand().equals("Submit")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					Connection conn=DriverManager.getConnection(DB_URL,userName,user_Password);
					
					pname=tname.getText();
					page=Integer.parseInt(tage.getText());
					popno=Integer.parseInt(topno.getText());
					java.util.Date  date=(java.util.Date) datePicker.getModel().getValue();
					pdate=date.toString();
					//System.out.println(bgroup.getSelection().getActionCommand());
					psex=bgroup.getSelection().getActionCommand();
					//ButtonModel b=bgroup.getSelection();
					//psex=b.getActionCommand();
					//psex=bgroup.getSelection().getActionCommand();
//					if(rad1.isSelected())
//					{
//						psex="male";
//					}
//					else if (rad2.isSelected()) {
//						psex="female";
//						
//					}
//					Enumeration<AbstractButton> allradiobutton=bgroup.getElements();
//					while(allradiobutton.hasMoreElements())
//					{
//						
//						JRadioButton temp=(JRadioButton) allradiobutton.nextElement();
//					
//						if (temp.isSelected()) {
//							psex=temp.getText();
//							
//						}
//					}
					poccu=toccu.getText();
					pdiag=dtext.getText();
					//System.out.println(bgroup.getSelection().getActionCommand());
					PreparedStatement stmt=(PreparedStatement) conn.prepareStatement("insert into registerout  values(?,?,?,?,?,?,?)");
					
					stmt.setString(1, pname);
					stmt.setInt(2, page);
					stmt.setInt(3, popno);
					stmt.setString(4, pdate);
					stmt.setString(5, psex);
					stmt.setString(6, poccu);
					stmt.setString(7, pdiag);
					
					stmt.executeUpdate();
					
					
					stmt.close();
					conn.close();
					JOptionPane.showMessageDialog(null, "Registration successful"," ",JOptionPane.INFORMATION_MESSAGE);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Please submit all information"," ",JOptionPane.ERROR_MESSAGE);
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
			image = (new ImageIcon(OutRecord.class.getResource("/resources/image2.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
