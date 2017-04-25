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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Project.RegisterHome.BackgroundContainer;

public class RegistrationForm extends JFrame implements ActionListener {
	
	static final String JDBC_URL="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/health_care_management";
	static final String userName="root";
	static final String user_Password="root";
	
	JLabel head,shead,name,age,pano,sex,occupation,address,fm;
	JTextField topno,tname,toccu,tage,tsex;
	JTextArea dadd,dfm;
	JScrollPane pdadd,pdfm;
	JButton submiButton,resetButton;
	String sname,soccu,sage,ssex,sadd,popno,sfm;
	JComboBox comboBox;
	JRadioButton rad1,rad2;
	ButtonGroup bgroup;
	BackgroundContainer backgroundContainer;
	String[] names={"Electrical and Electronic Engineering(EEE)","Mechanical Engineering(ME)","Civil Engineering(CE)","Computer Science and Engineering(CSE)","Electronics and Communication Engineering(ECE)","Industrial Engineering and Management(IEM)","Urban and Regional Planning(URP)","Leather Engineering(LE)","Textile Engineering(TE)","Building Engineering and Construction Management(BECM)","Biomedical Engineering(BME)","Energy Technology(ET)"," "};
	
	/**
	 * 
	 */
	public RegistrationForm()
	{
		backgroundContainer=new BackgroundContainer();
		backgroundContainer.setLayout(null);
		add(backgroundContainer);

		//setLayout(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registration Form");
		setBounds(200,10,1020,725);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		head=new JLabel("Kuet Medical Center,Khulna");
		head.setFont(new Font("arial narrow", Font.BOLD, 30));
		head.setForeground(Color.green);
		head.setHorizontalAlignment(SwingConstants.CENTER);
		head.setBounds(210,0,570,60);
		backgroundContainer.add(head);
		
		shead=new JLabel("Registration Record");
		shead.setFont(new Font("arial narrow", Font.BOLD, 24));
		shead.setForeground(Color.blue);
		shead.setBounds(370,40,250,30);
		shead.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundContainer.add(shead);
		
		pano=new JLabel("idNo");
		pano.setFont(new Font("arial narrow", Font.BOLD, 16));
		pano.setForeground(Color.black);
		pano.setHorizontalAlignment(SwingConstants.CENTER);
		pano.setBounds(230,80,70,30);
		backgroundContainer.add(pano);
		
		name=new JLabel("Name");
		name.setFont(new Font("arial narrow", Font.BOLD, 16));
		name.setBounds(240,130,60,30);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.black);
		backgroundContainer.add(name);
		
		
		age=new JLabel("Age");
		age.setFont(new Font("arial narrow", Font.BOLD, 16));
		age.setForeground(Color.black);
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setBounds(250,240,40,30);
		backgroundContainer.add(age);
		
		
		occupation=new JLabel("Dept");
		occupation.setFont(new Font("arial narrow", Font.BOLD, 16));
		occupation.setForeground(Color.black);
		occupation.setHorizontalAlignment(SwingConstants.CENTER);
		occupation.setBounds(240,180,60,30);
		backgroundContainer.add(occupation);
		
		
		sex=new JLabel("Sex");
		sex.setFont(new Font("arial narrow", Font.BOLD, 16));
		sex.setForeground(Color.black);
		sex.setBounds(250,300,50,30);
		sex.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundContainer.add(sex);
		
		
		address=new JLabel("Address");
		address.setFont(new Font("arial narrow", Font.BOLD, 16));
		address.setForeground(Color.black);
		address.setBounds(210, 350, 100, 30);
		address.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundContainer.add(address);
		
		
		fm=new JLabel("Symptoms");
		fm.setFont(new Font("arial narrow", Font.BOLD, 16));
		fm.setForeground(Color.black);
		fm.setHorizontalAlignment(SwingConstants.TRAILING);
		fm.setBounds(125,460,160,30);
		backgroundContainer.add(fm);
		
		
		tname=new JTextField(30);
		tname.setFont(new Font("arial narrow", Font.BOLD, 12));
		tname.setBounds(310,130,310,30);
		backgroundContainer.add(tname);
		
		
		tage=new JTextField(30);
		tage.setFont(new Font("arial narrow", Font.BOLD, 12));
		tage.setBounds(310,240,310,30);
		backgroundContainer.add(tage);
		
		
		topno=new JTextField(30);
		topno.setFont(new Font("arail narrow",Font.BOLD,12));
		topno.setBounds(310,80,100,30);
		backgroundContainer.add(topno);
		
//		
//		toccu=new JTextField(30);
//		toccu.setFont(new Font("arial narrow", Font.BOLD, 12));
//		toccu.setBounds(310,180,310,30);
//		getContentPane().add(toccu);
		
		comboBox=new JComboBox(names);
		comboBox.setSelectedIndex(12);
		comboBox.setMaximumRowCount(5);
		comboBox.setFont(new Font("arial", Font.BOLD, 12));
		comboBox.setBounds(310,180,310,30);
		backgroundContainer.add(comboBox);
		
//		tsex=new JTextField(30);
//		tsex.setFont(new Font("arial narrow", Font.BOLD, 12));
//		tsex.setBounds(310,300,310,30);
//		getContentPane().add(tsex);
		
        
  	    rad1=new JRadioButton("Male");
  	    rad1.setActionCommand("male");
  	    rad1.setBounds(310, 310, 85, 15);             
        backgroundContainer.add(rad1); 
        
        
        rad2=new JRadioButton("Female");
        rad2.setActionCommand("female");
  	    rad2.setBounds(400, 310, 85, 15);         
        backgroundContainer.add(rad2);

        bgroup=new ButtonGroup();
        bgroup.add(rad1);
        bgroup.add(rad2);
		
		
		dadd=new JTextArea(5,8);
	    pdadd=new JScrollPane(dadd);
		dadd.setBounds(310,380,330,80);
		//getContentPane().add(pdadd);
		backgroundContainer.add(dadd);
		
		
		dfm=new JTextArea(5,8);
		dfm.setBounds(310,500,330,80);
		pdfm=new JScrollPane(dfm);
		//getContentPane().add(pdfm);
		backgroundContainer.add(dfm);
		
		
		submiButton=new JButton("Submit");
		submiButton.setFont(new Font("arial", Font.BOLD, 18));
		submiButton.setBounds(350,625,110,30);
		submiButton.setForeground(Color.blue);
		submiButton.addActionListener(this);
		submiButton.setToolTipText("Press to submit");
		backgroundContainer.add(submiButton);
		
		
		resetButton=new JButton("Exit");
		resetButton.setFont(new Font("arial", Font.BOLD, 18));
		resetButton.setForeground(Color.blue);
		resetButton.addActionListener(this);
		resetButton.setToolTipText("");
		resetButton.setBounds(500,625,110,30);
		backgroundContainer.add(resetButton);
		
		
		

		
		setVisible(true);
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegistrationForm rg=new RegistrationForm();

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
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				
				Connection conn=DriverManager.getConnection(DB_URL,userName,user_Password);
			
				popno=topno.getText();
				sname=tname.getText();
				//ssex=tsex.getText();
				ssex=bgroup.getSelection().getActionCommand();
				//soccu=toccu.getText();
				soccu=(String) comboBox.getItemAt(comboBox.getSelectedIndex());
				sage=tage.getText();
				sadd=dadd.getText();
				sfm=dfm.getText();
				int r=0;
				
			
				PreparedStatement stmt=conn.prepareStatement("insert into registration (opno,name,dep,age,sex,address,symptom) values(?,?,?,?,?,?,?)");
				stmt.setString(1, popno);
				stmt.setString(2, sname);
				stmt.setString(3,soccu );
				stmt.setString(4, sage);
				stmt.setString(5, ssex);
				stmt.setString(6, sadd);
				stmt.setString(7, sfm);
				stmt.executeUpdate();
				stmt.close();
				conn.close();
			
					
				JOptionPane.showMessageDialog(null, "Registration is complete","Successful",JOptionPane.INFORMATION_MESSAGE);     
	
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,"Person is not added\nEnter all information","Error",JOptionPane.ERROR_MESSAGE );
				
				e1.printStackTrace();
			}

			
			
			
		}
	}
	class BackgroundContainer extends JPanel{
		
		private Image image;
		public BackgroundContainer() {
			image = (new ImageIcon(RegistrationForm.class.getResource("/resources/image2.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
