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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Project.UpdateDrug.BackgroundContainer;

public class AboutStock extends JFrame implements ActionListener{
	
	static final String JDBC_URL="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/health_care_management";
	static final String userName="root";
	static final String user_Password="root";
	
	String Dname,exdate,selectsString;
	int istock,ostock,total;
	JLabel shead,ssub,dname,instock,outstock,remain,exda;
	JTextField dText,dexda,dremain;
	JButton submit,back;
	BackgroundContainer backgroundContainer;
	
	public AboutStock()
	{
		backgroundContainer=new BackgroundContainer();
		backgroundContainer.setLayout(null);
		add(backgroundContainer);
		//setLayout(null);
		setTitle("Drugs");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200,10,1020,725);
		setVisible(true);
		
		shead=new JLabel("STOCK DETAILS");
		shead.setFont(new Font("arial",Font.BOLD,40));
		shead.setForeground(Color.blue);
		shead.setHorizontalAlignment(SwingConstants.CENTER);
		shead.setBounds(220,80,490,50);
		backgroundContainer.add(shead);
		
		
		ssub=new JLabel("_ _ _ _ _ _ _ _ _ _ _");
		ssub.setFont(new Font("arial", Font.BOLD, 40));
		ssub.setForeground(Color.red);
		ssub.setHorizontalAlignment(SwingConstants.CENTER);
		ssub.setBounds(260,65,420,100);
		backgroundContainer.add(ssub);
		
		
		dname=new JLabel("DRUG NAME");
		dname.setFont(new Font("arial", Font.BOLD, 24));
		dname.setForeground(Color.black);
		dname.setHorizontalAlignment(SwingConstants.CENTER);
		dname.setBounds(120,180,200,40);
		backgroundContainer.add(dname);
		

        remain=new JLabel("REMAINING");
        remain.setFont(new Font("Arial Narrow",Font.BOLD,24));
        remain.setForeground(Color.black);
        remain.setHorizontalAlignment(SwingConstants.CENTER);
        remain.setBounds(70,350,180,30);
       backgroundContainer.add(remain);
        
        
        exda=new JLabel("EX-DATE:");
        exda.setFont(new Font("Arial Narrow",Font.BOLD,24));
        exda.setForeground(Color.black);
        exda.setHorizontalAlignment(SwingConstants.TRAILING);
        exda.setBounds(440,350,100,30);
        backgroundContainer.add(exda);
        
        

        dText=new JTextField(30);
        dText.setFont(new Font("Arial Narrow",Font.BOLD,18));
        dText.setBounds(320,185,300,30);
        backgroundContainer.add(dText);
        
        
        dexda=new JTextField(30);
        dexda.setEditable(false);
  	    dexda.setFont(new Font("Arial Narrow",Font.BOLD,18));
        dexda.setBounds(550,350,140,30);
        backgroundContainer.add(dexda);
        
        
        dremain=new JTextField(30);
        dremain.setEditable(false);
        dremain.setFont(new Font("Arial Narrow",Font.BOLD,18));
        dremain.setBounds(230,350,120,30);
        backgroundContainer.add(dremain);
        
        

        submit=new JButton("SEARCH");
        submit.setFont(new Font("Arial Narrow",Font.BOLD,18));
        submit.setBounds(400,263,160,40);
        submit.setForeground(Color.blue);
        submit.setBackground(Color.orange);
        submit.addActionListener(this);
        submit.setToolTipText("Press to submit the detials");
        backgroundContainer.add(submit);
        
        

        back=new JButton("BACK");
        back.setFont(new Font("Arial Narrow",Font.BOLD,18));
        back.setBounds(410,440,160,40);
        back.setForeground(new Color(0,0,255));
        back.setBackground(new Color(0,255,255));
       
        back.addActionListener(this);
        back.setToolTipText("Press to return");
        backgroundContainer.add(back);
        
  
	}
	
	public static void main(String[] arg0)
	{
		AboutStock aStock=new AboutStock();
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getActionCommand().equals("BACK"))
		{
			dispose();
		}
		else if (event.getActionCommand().equals("SEARCH")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					Connection conn=DriverManager.getConnection(DB_URL,userName,user_Password);
				

                    Dname=dText.getText();
	                PreparedStatement pstmt=conn.prepareStatement("select expdate,total from Drugs where DrugName= ?");
                    pstmt.setString(1,Dname);

                    ResultSet rs=pstmt.executeQuery();

                     if(rs.next())
                            {
                                   dremain.setText(rs.getString(2));
                                   dexda.setText(rs.getString(1));
                            }
                     else {
						JOptionPane.showMessageDialog(null, Dname+" is not in stock","",JOptionPane.PLAIN_MESSAGE);
					}

                                   pstmt.close();
                                   conn.close();
				

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	class BackgroundContainer extends JPanel{
		
		private Image image;
		public BackgroundContainer() {
			image = (new ImageIcon(AboutStock.class.getResource("/resources/image8.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
