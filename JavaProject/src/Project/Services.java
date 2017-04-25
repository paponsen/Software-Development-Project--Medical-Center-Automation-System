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

public class Services extends JFrame implements ActionListener {
	
	JLabel mts,ima;
	JButton sinReg,ouReg,einReg,back;
	BackgroundContainer backgroundContainer;
	public Services()
	{
		
		backgroundContainer=new BackgroundContainer();
		backgroundContainer.setLayout(null);
		add(backgroundContainer);
		//setLayout(null);
		setTitle("Services");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setBounds(200,10,1020,725);
		mts=new JLabel("Services");
		mts.setFont(new Font("Arial Narrow",Font.BOLD,36));
		mts.setForeground(Color.red);
	    mts.setHorizontalAlignment(SwingConstants.CENTER);
	    mts.setBounds(0,20,580,110);
	    backgroundContainer.add(mts);
	    
		ima=new JLabel(" ");
		ima.setFont(new Font("arial", Font.BOLD, 35) );
		ima.setIcon(new ImageIcon("G:\\java programming\\PC\\workspace\\drug.jpg"));;
		ima.setBounds(450,150,500,360);
	    ima.setHorizontalAlignment(SwingConstants.CENTER);
	    backgroundContainer.add(ima);
		
        //setContentPane(new JLabel(new ImageIcon("G:\\java programming\\PC\\workspace\\drug.jpg")));

	    
//		ima=new JLabel("  ");
//		ima.setFont(new Font("Arial Narrow",Font.BOLD,35));
//	    ima.setHorizontalAlignment(SwingConstants.CENTER);
//	    ima.setBounds(500,50,560,530);
//	    getContentPane().add(ima);
	    
	    sinReg=new JButton("Drugs Service");
	    sinReg.setFont(new Font("Arial Narrow",Font.BOLD,25));
	    sinReg.setBounds(150,160,260,40);
	    sinReg.setForeground(new Color(51,153,255));
	    sinReg.setBackground(new Color(204,255,204));
	  	sinReg.addActionListener(this);
		sinReg.setToolTipText("Press to Enter  Drug Services ");
		backgroundContainer.add(sinReg);
	   	
//	   	
		ouReg=new JButton("Test Services");
		ouReg.setFont(new Font("Arial Narrow",Font.BOLD,25));
		ouReg.setForeground(new Color(51,153,255));
	    ouReg.setBackground(new Color(236,233,216));
	    ouReg.setBounds(150,250,260,40);
	  	ouReg.addActionListener(this);
		ouReg.setToolTipText("Press to Enter the Test services");
		backgroundContainer.add(ouReg);
//	    
		back=new JButton("BACK");
	    back.setFont(new Font("Arial Narrow",Font.BOLD,25));
		back.setForeground(new Color(0,0,0));
	    back.setBackground(new Color(255,153,153));	   
	  	back.setBounds(220,350,120,40);
	    back.addActionListener(this);
	    back.setToolTipText("Press for returning to Home Page");
	    backgroundContainer.add(back);
	    setVisible(true);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Services sv=new Services();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("BACK"))
		{
			dispose();
		}
		
		else if (arg0.getActionCommand().equals("Drugs Service")) {
			DrugServices drugServices=new DrugServices();
			
		}
		else if(arg0.getActionCommand().equals("Test Services"))
		{
			TestServices testServices=new TestServices();
			
		}
		
		
		
	}
	class BackgroundContainer extends JPanel{
		
		private Image image;
		public BackgroundContainer() {
			image = (new ImageIcon(Services.class.getResource("/resources/image2.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
