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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.mysql.jdbc.PreparedStatement;

public class InRecord extends JFrame implements ActionListener {
	
	
	
	static final String JDBC_URL="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/health_care_management";
	static final String userName="root";
	static final String user_Password="root";
	
	
    String pname,psex,poccu,pdoa,pdod,pdia,pda,ppc,pph,ppe,pi; 
    int page,popno;
    JLabel stop,sdown,name,age,opno,sex,diag,desg,doa,dod,drua,preCom,hpl,ph,pe,inve;
    JButton submit,Exit;
    JTextField tname,tage,tsex,tdesg,tdoa,topno,tdod;
    JTextArea  adia,ada,aprec,aph,ape,ai;
    JScrollPane jScrollPane1,jScrollPane2,jScrollPane3,jScrollPane4,jScrollPane5,jScrollPane6;
    JComboBox sexBox;
    String[] sexStrings={"","male","female"};
    JRadioButton rad1,rad2;
    ButtonGroup bgroup;
    BackgroundContainer backgroundContainer;
    
    
	String date1,date2;
	
	UtilDateModel model2,model;
	JDatePanelImpl datePanel,datePanel2;
	JDatePickerImpl datePicker,datePicker2;
    
    public InRecord()
    {
    	backgroundContainer=new BackgroundContainer();
    	backgroundContainer.setLayout(null);
    	add(backgroundContainer);
    	//setLayout(null);
    	setTitle("In-Patient Registration");
    	//setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setBounds(200,10,1020,725);
  	    stop=new JLabel("KUET MEDICAL CENTER,KUET");
  	    stop.setFont(new Font("Arial Narrow",Font.BOLD,24));
  	    stop.setForeground(new Color(255,51,255));
  	    stop.setHorizontalAlignment(SwingConstants.CENTER);
        stop.setBounds(120,20,590,30);
        backgroundContainer.add(stop);
  	    
  	    
        sdown=new JLabel("IN-PATIENT CASE RECORD");
	    sdown.setFont(new Font("Arial Narrow",Font.BOLD,18));
	    sdown.setForeground(new Color(0,0,153));
	    sdown.setHorizontalAlignment(SwingConstants.CENTER);
        sdown.setBounds(300,60,250,20);
        backgroundContainer.add(sdown);
	
        name=new JLabel("Name");
	    name.setFont(new Font("Arial Narrow",Font.BOLD,14));
	    name.setForeground(new Color(0,153,51));
	    name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setBounds(30,100,50,20);
        backgroundContainer.add(name);
	    
	    
		age=new JLabel("Age");
		age.setFont(new Font("Arial Narrow",Font.BOLD,14));
		age.setForeground(new Color(0,153,51));
		age.setHorizontalAlignment(SwingConstants.CENTER); 
	    age.setBounds(254,100,40,20);
	    backgroundContainer.add(age);
		
		
		opno=new JLabel("I.D.No");
		opno.setFont(new Font("Arial Narrow",Font.BOLD,14));
		opno.setForeground(new Color(0,153,51));
		opno.setHorizontalAlignment(SwingConstants.CENTER);
	    opno.setBounds(30,140,50,30);
	    backgroundContainer.add(opno);
		
		
		sex=new JLabel("Sex");
		sex.setFont(new Font("Arial Narrow",Font.BOLD,14));
		sex.setForeground(new Color(0,153,51));
		sex.setHorizontalAlignment(SwingConstants.CENTER);
	    sex.setBounds(410,100,40,20);
	    backgroundContainer.add(sex);


        desg=new JLabel("Occupation");
	    desg.setFont(new Font("Arial Narrow",Font.BOLD,14));
	    desg.setForeground(new Color(0,153,51));
	    desg.setHorizontalAlignment(SwingConstants.CENTER);
        desg.setBounds(630,100,80,20);
        backgroundContainer.add(desg);
	  
	    
	    
        doa=new JLabel("Date of Admission");
	    doa.setFont(new Font("Arial Narrow",Font.BOLD,14));
	    doa.setForeground(new Color(0,153,51));
	    doa.setHorizontalAlignment(SwingConstants.LEADING);
        doa.setBounds(240,140,110,20);
        backgroundContainer.add(doa);
	    
	    
		dod=new JLabel("Date Of DisCharge");
		dod.setFont(new Font("Arial Narrow",Font.BOLD,14));
		dod.setForeground(new Color(0,153,51));
		dod.setHorizontalAlignment(SwingConstants.CENTER);
	    dod.setBounds(580,140,130,20);
	    backgroundContainer.add(dod);
		
		
        diag=new JLabel("Diagnosis");
	    diag.setFont(new Font("Arial Narrow",Font.BOLD,14));
	    diag.setForeground(new Color(0,153,51));
	    diag.setHorizontalAlignment(SwingConstants.CENTER);
        diag.setBounds(30,180,60,20);
        backgroundContainer.add(diag);
	    
	    
        preCom=new JLabel("Present Compliant");
	    preCom.setFont(new Font("Arial Narrow",Font.BOLD,14));
	    preCom.setForeground(new Color(0,153,51));
	    preCom.setHorizontalAlignment(SwingConstants.CENTER);
        preCom.setBounds(10,240,120,20);
        backgroundContainer.add(preCom);
	    
	    
	    ph=new JLabel("Past History:");                          
		ph.setFont(new Font("Arial Narrow",Font.BOLD,14));
		ph.setForeground(new Color(0,153,51));
		ph.setHorizontalAlignment(SwingConstants.CENTER);
	    ph.setBounds(10,310,110,20);
	    backgroundContainer.add(ph);
	    
		
        pe=new JLabel("Phyiscal Examination:");
	    pe.setFont(new Font("Arial Narrow",Font.BOLD,14));
	    pe.setForeground(new Color(0,153,51));
	    pe.setHorizontalAlignment(SwingConstants.CENTER);
        pe.setBounds(10,400,120,30);
        backgroundContainer.add(pe);
	    
	    

        inve=new JLabel("Investigation:");
	    inve.setFont(new Font("Arial Narrow",Font.BOLD,14));
	    inve.setForeground(new Color(0,153,51));
	    inve.setHorizontalAlignment(SwingConstants.CENTER);
        inve.setBounds(10,510,110,20);
        backgroundContainer.add(inve);
	    
	    
        tname=new JTextField(30);
	    tname.setFont(new Font("Arial Narrow",Font.BOLD,12));
        tname.setBounds(90,100,140,20);
        backgroundContainer.add(tname);
        
        
        tage=new JTextField(30);
  	    tage.setFont(new Font("Arial Narrow",Font.BOLD,12));
        tage.setBounds(290,100,110,20);
        backgroundContainer.add(tage);
        
        
//        
//        sexBox=new JComboBox(sexStrings);
//        sexBox.setSelectedIndex(0);
//        sexBox.setMaximumRowCount(2);
//        sexBox.setBounds(460,100,140,20);
//        getContentPane().add(sexBox);
        
  	    rad1=new JRadioButton("Male");
  	    rad1.setActionCommand("male");
  	    rad1.setBounds(460, 105, 85, 15);             
  	  backgroundContainer.add(rad1); 
        
        
        rad2=new JRadioButton("Female");
        rad2.setActionCommand("female");
  	    rad2.setBounds(540, 105, 85, 15);         
  	  backgroundContainer.add(rad2);

        bgroup=new ButtonGroup();
        bgroup.add(rad1);
        bgroup.add(rad2);
       
        
        
        
        topno=new JTextField(30);
  	    topno.setFont(new Font("Arial Narrow",Font.BOLD,12));
        topno.setBounds(90,140,140,20);
        backgroundContainer.add(topno);
        
        
  	    tdesg=new JTextField(30);
  	    tdesg.setFont(new Font("Arial Narrow",Font.BOLD,12));
        tdesg.setBounds(720,100,150,20);
        backgroundContainer.add(tdesg);
        
        
//  	    tdoa=new JTextField(30);
//  	    tdoa.setFont(new Font("Arial Narrow",Font.BOLD,12));
//        tdoa.setBounds(360,140,210,20);
//        getContentPane().add(tdoa);
//        
//        
//  	    tdod=new JTextField(30);
//  	    tdod.setFont(new Font("Arial Narrow",Font.BOLD,12));
//        tdod.setBounds(720,140,150,20);
//        getContentPane().add(tdod);
        
        
        
		 model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
	    datePicker = new JDatePickerImpl(datePanel);
		
		//Date today=(Date) datePicker.getModel().getValue();
		datePicker.setBounds(360, 140, 200, 25);
		backgroundContainer.add(datePicker);
		//date1=(String) datePicker.getModel().getValue();
		
		
//		dExpDate=new JTextField(30);
//		dExpDate.setFont(new Font("arial", Font.BOLD, 18));
//		dExpDate.setBounds(250,370,430,40);
//		getContentPane().add(dExpDate);
		
		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2);
		datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.setBounds(720,140,200,25);

		backgroundContainer.add(datePicker2);
		date2=(String) datePicker.getModel().getValue();
        
  	    adia=new JTextArea(5,10);
  	    adia.setBounds(100, 180, 650, 50);
  	  backgroundContainer.add(adia);
  	    
  	    
        aprec=new JTextArea(5,10);
	    aprec.setBounds(100, 260, 650, 50);
	    backgroundContainer.add(aprec);
	   
        aph=new JTextArea(5,10);
	    aph.setBounds(100, 330, 650, 60);
	    backgroundContainer.add(aph);
  
        ape=new JTextArea(5,10);
	    ape.setBounds(100, 430, 650, 70);
	    backgroundContainer.add(ape);

  	    
        
        ai=new JTextArea(5,10);
    	ai.setBounds(100,530,650,60);
    	backgroundContainer.add(ai);
	    

        
        submit=new JButton("Submit");
        submit.setFont(new Font("Arial Narrow",Font.BOLD,18));
        submit.setBounds(300,620,100,40);
	    submit.setForeground(Color.blue);
	    submit.setBackground(Color.gray);
        submit.addActionListener(this);
        submit.setToolTipText("Press to submit the detials");
        backgroundContainer.add(submit); 
        
        
        Exit=new JButton("Exit");
        Exit.setFont(new Font("Arial Narrow",Font.BOLD,18));              
        Exit.setBounds(500,620,100,40);
	    Exit.setForeground(Color.blue);
	    Exit.setBackground(Color.gray);
        Exit.addActionListener(this);
        Exit.setToolTipText("Press to Register Student as the In-Paitent ");
        backgroundContainer.add(Exit); 

  	    
  	    setVisible(true);
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InRecord iRecord=new InRecord();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getActionCommand().equals("Exit")) {
			dispose();
			
		}
		
		else if (e.getActionCommand().equals("Submit")) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				try {
					Connection conn=DriverManager.getConnection(DB_URL,userName,user_Password);
				
					pname=tname.getText();
					page=Integer.parseInt(tage.getText());

					psex=bgroup.getSelection().getActionCommand();

					poccu=tdesg.getText();
					popno=Integer.parseInt(topno.getText());
//					pdoa=tdoa.getText();
//					pdod=tdod.getText();
					 java.util.Date  date=(java.util.Date) datePicker.getModel().getValue();
					 date1=date.toString();
					//String date=
					 java.util.Date   today=(java.util.Date) datePicker2.getModel().getValue();
					 date2=today.toString();
					pdia=adia.getText();
					ppc=aprec.getText();
					pph=aph.getText();
					ppe=ape.getText();
					pi=ai.getText();
					
					PreparedStatement psms=(PreparedStatement) conn.prepareStatement("insert into inpacaserec values(?,?,?,?,?,?,?,?,?,?,?,?)");
					psms.setString(1,pname);
					psms.setInt(2,page);
					psms.setString(3,psex);
					psms.setString(4,poccu);
					psms.setInt(5,popno);
					psms.setString(6,date1);
					psms.setString(7,date2);
					psms.setString(8,pdia);
					//psms.setString(9,pda);
					psms.setString(9,ppc);
					psms.setString(10,pph);
					psms.setString(11,ppe);
					psms.setString(12,pi);
			        psms.executeUpdate();
					psms.close();

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
			image = (new ImageIcon(InRecord.class.getResource("/resources/image2.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
