package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.PasswordAuthentication;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Start extends JFrame implements ActionListener,KeyListener {
	
	JLabel title,title1,title2,line,image;
	JButton admin,exit;
	JPanel p;
	int key;
	String b;
	BackgroundContainer backgroundContainer;
	public Start()
	{
		setTitle("Start");
		backgroundContainer = new BackgroundContainer();
		backgroundContainer.setLayout(null);
		
		add(backgroundContainer);
		setBounds(200,10,1020,725);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		title=new JLabel("KUET Medical Center");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("arial",Font.BOLD,30));
		title.setForeground(Color.red);
		title.setBounds(50,100,1000,70);
		title1=new JLabel("Khulna University Of Enginnering And Technology");
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		title1.setFont(new Font("arial", Font.BOLD, 30));
		title1.setForeground(Color.GREEN);
		//title1.setBounds(350,100,1000,70);
		title1.setBounds(100,50,1000,70);
		title1.setHorizontalAlignment(SwingConstants.CENTER);
		title2=new JLabel("Khulna");
		title2.setFont(new Font("arial", Font.BOLD, 30));
		title2.setForeground(Color.red);
		title2.setBounds(350, 150, 500, 60);
		line=new JLabel("-----------------");
		line.setHorizontalAlignment(SwingConstants.CENTER);
		line.setFont(new Font("arial", Font.BOLD, 45));
		line.setForeground(Color.blue);
		line.setBounds(350,200,1000,30);
		backgroundContainer.add(title);
		backgroundContainer.add(title1);
		//getContentPane().add(title1);
		//getContentPane().add(title2);
		//getContentPane().add(line);
		
//		p=new JPanel();
//		p.setLayout(new GridLayout(1,2));
//		p.setBounds(330, 650, 350, 30);
		admin=new JButton("Admin");
		//admin.setMnemonic(KeyEvent.VK_A);
		admin.setToolTipText("Press it and Enter Password");
		admin.setFont(new Font("arial", Font.BOLD, 20));
		admin.setBounds(400,600,100,30);
		admin.addActionListener(this);
		
		exit=new JButton("Exit");
		//exit.setMnemonic(KeyEvent.VK_E);
		exit.add(Box.createVerticalGlue());
		exit.setFont(new Font("arial", Font.BOLD, 20));
		exit.setToolTipText("Press it to go Back");
		exit.setBounds(550,600,100,30);
		exit.addActionListener(this);
		
		backgroundContainer.add(admin);
		backgroundContainer.add(exit);
		//getContentPane().add(p);
		
		admin.addKeyListener(this);
		exit.addActionListener(this);
		
		image=new JLabel(new ImageIcon(Start.class.getResource("/resources/kuet4.jpg")));
		image.setBounds(0, 100, 1080, 500);
		//backgroundContainer.add(image);
		
		// setContentPane(new JLabel(new ImageIcon("C:\\Users\\PC\\workspace\\kuet4.jpg")));
		
		
		setVisible(true);
	
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Start start=new Start();

	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		key=event.getKeyCode();
		if(key==KeyEvent.VK_A)
		{
			AdminPassword apw=new AdminPassword(this);
			
		}
		else if (key==KeyEvent.VK_E) {
			dispose();
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getActionCommand().equals("Admin"))
		{
			AdminPassword apw=new AdminPassword(this);
			
		}
		else if (event.getActionCommand().equals("Exit")) {
			dispose();
			
		}
		
	}
	class BackgroundContainer extends JPanel{
		
		private Image image;
		public BackgroundContainer() {
			image = (new ImageIcon(Start.class.getResource("/resources/Lazydaysii.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
