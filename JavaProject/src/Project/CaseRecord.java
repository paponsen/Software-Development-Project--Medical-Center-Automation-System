package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Project.AboutStock.BackgroundContainer;

public class CaseRecord extends JFrame implements ActionListener {

	JLabel mts,ima;
 	
	JButton sinReg,ouReg,einReg,back;
	BackgroundContainer backgroundContainer;

	public CaseRecord()
	{
		
		backgroundContainer=new BackgroundContainer();
		backgroundContainer.setLayout(null);
		add(backgroundContainer);
		
		   //setLayout(null);
		   setTitle(" CASE RECORD");
		   setDefaultCloseOperation(EXIT_ON_CLOSE);
	       setBounds(200,10,1020,725);
	       
		   mts=new JLabel(" CASE RECORDS OF IN & OUT PATIENT ");
		   mts.setFont(new Font("Arial Narrow",Font.BOLD,36));
		   mts.setForeground(Color.red);
	       mts.setHorizontalAlignment(SwingConstants.CENTER);
	       mts.setBounds(10,20,580,110);
	       backgroundContainer.add(mts);
	       
	       
		   ima=new JLabel("  ");
		   ima.setFont(new Font("Arial Narrow",Font.BOLD,35));
		   ima.setIcon(new ImageIcon("G:\\java programming\\PC\\workspace\\Regist.jpg"));
	       ima.setHorizontalAlignment(SwingConstants.CENTER);
	       ima.setBounds(500,50,560,530);
	       backgroundContainer.add(ima);
	       
	       
	       

           sinReg=new JButton("InStu Record");
           sinReg.setFont(new Font("Arial Narrow",Font.BOLD,25));
           sinReg.setBounds(100,160,180,40);
           sinReg.setForeground(new Color(51,153,255));
           sinReg.setBackground(new Color(204,255,204));
           sinReg.addActionListener(this);
           sinReg.setToolTipText("Press to Register Student as the In-Paitent ");
           backgroundContainer.add(sinReg);
           
           
           einReg=new JButton("InEmp Record");
       	   einReg.setFont(new Font("Arial Narrow",Font.BOLD,25));
       	   einReg.setForeground(new Color(51,153,255));
           einReg.setBackground(new Color(204,255,204));
           einReg.setBounds(100,300,180,40);
           einReg.addActionListener(this);
           einReg.setToolTipText("Press to Register the Student of SvUniversity");
           backgroundContainer.add(einReg);
           
           
       	   ouReg=new JButton("OutP-Record");
           ouReg.setFont(new Font("Arial Narrow",Font.BOLD,25));
       	   ouReg.setForeground(new Color(51,153,255));
           ouReg.setBackground(new Color(236,233,216));
       	   ouReg.setBounds(100,430,180,40);
           ouReg.addActionListener(this);
       	   ouReg.setToolTipText("Press to Register the Student of SvUniversity");
       	backgroundContainer.add(ouReg);
           
           
    	   back=new JButton("BACK");
           back.setFont(new Font("Arial Narrow",Font.BOLD,25));
    	   back.setForeground(new Color(0,0,0));
           back.setBackground(new Color(255,153,153));	   
     	   back.setBounds(430,580,120,40);
           back.addActionListener(this);
           back.setToolTipText("Press for returning to Home Page");
           backgroundContainer.add(back);
           setVisible(true);


           
           
           setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaseRecord cs=new CaseRecord();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		

        if(ae.getActionCommand().equals("BACK"))
  	       {
          	        dispose();
   	       }
  	      else if(ae.getActionCommand().equals("InStu Record"))
  	      {
  	    	  InRecord inRecord=new InRecord();
  	    	  
  	      }

		   else if(ae.getActionCommand().equals("InEmp Record"))
		   {
			   
			   InRecord inRecord=new InRecord();
			   
		   }
	      else if(ae.getActionCommand().equals("OutP-Record"))

	      {
	    	  OutRecord oRecord=new OutRecord();
	    	  
	      }
	    	  
            
		
	}
	
	class BackgroundContainer extends JPanel{
		
		private Image image;
		public BackgroundContainer() {
			image = (new ImageIcon(CaseRecord.class.getResource("/resources/image2.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
