package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RegisterHome extends JFrame implements ActionListener {
	
	JLabel head,shead,label;
	
	JButton insert,view,reset;
	BackgroundContainer backgroundContainer;
	public RegisterHome()
	{
		backgroundContainer=new BackgroundContainer();
		backgroundContainer.setLayout(null);
		add(backgroundContainer);
		//setLayout(null);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registration of Patient");
		setBounds(200,10,1020,725);
		
		head=new JLabel("Kuet Medical Center,Kuet");
		head.setFont(new Font("arail narrow", Font.ITALIC, 36));
		head.setForeground(Color.green);
		head.setHorizontalAlignment(SwingConstants.CENTER);
		head.setBounds(210,24,520,60);
		backgroundContainer.add(head);
		
		shead=new JLabel("Registration Record");
		shead.setFont(new Font("arial narrow", Font.ITALIC,30 ));
		shead.setForeground(Color.green);
		shead.setHorizontalAlignment(SwingConstants.CENTER);
		shead.setBounds(210,100,510,50);
		backgroundContainer.add(shead);
		
		
		label=new JLabel("");
		label.setFont(new Font("arail narrow", Font.ITALIC, 24));
		label.setForeground(Color.yellow);
		label.setIcon(new ImageIcon("C:\\Users\\PC\\workspace\\reg.jpg"));
		label.setBounds(480,250,440,400);
		backgroundContainer.add(label);
		
		
		insert=new JButton("INSERT");
		insert.setBackground(Color.DARK_GRAY);
		insert.setFont(new Font("arail narrow", Font.ITALIC,26 ));
		insert.setBounds(80,230,250,80);
		insert.setForeground(Color.WHITE);
		//insert.setMnemonic(KeyEvent.VK_S);
		//insert.setToolTipText("press to enter new details");
		insert.addActionListener(this);
		backgroundContainer.add(insert);
		
		view=new JButton("VIEW");
		view.setBackground(Color.DARK_GRAY);
		view.setFont(new Font("arail narrow", Font.ITALIC, 26));
		view.setForeground(Color.WHITE);
		view.setBounds(80,400,250,80);
		//view.setToolTipText("Press to enter new detials");
		view.addActionListener(this);
		backgroundContainer.add(view);
		
		
		reset=new JButton("RESET");
		reset.setBackground(Color.DARK_GRAY);
		reset.setFont(new Font("arail narrow", Font.ITALIC, 26));
		reset.setForeground(Color.white);
		reset.setBounds(80,570,250,80);
		reset.setToolTipText("");
		reset.addActionListener(this);
		backgroundContainer.add(reset);
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
		

		
		
		
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegisterHome rs=new RegisterHome();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("RESET"))
		{
			dispose();
			
		}
		else if (e.getActionCommand().equals("INSERT")) {
			
			//todo
			RegistrationForm rf=new RegistrationForm();
			
		}
		else if (e.getActionCommand().equals("VIEW")) {
			
			//todo
			Register rs=new Register();
		}
		
	}
	class BackgroundContainer extends JPanel{
		
		private Image image;
		public BackgroundContainer() {
			image = (new ImageIcon(RegisterHome.class.getResource("/resources/image4.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
