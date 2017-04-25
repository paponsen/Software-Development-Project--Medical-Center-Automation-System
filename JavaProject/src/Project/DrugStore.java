package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DrugStore extends JFrame implements ActionListener {
	
	JLabel ds,ima;
	JButton indrug,updrug,inou,tokn,back;
	BackgroundContainer backgroundContainer;
	
	public DrugStore()
	{
		backgroundContainer=new BackgroundContainer();
		backgroundContainer.setLayout(null);
		add(backgroundContainer);
		//setLayout(null);
		setTitle("Drug Store");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200,10,1020,725);
		ds=new JLabel("KUET Medical Drug Store");
		ds.setFont(new Font("arial", Font.ITALIC, 36));
		ds.setForeground(Color.green);
		ds.setHorizontalAlignment(SwingConstants.CENTER);
		ds.setBounds(220,40,660,153);
		//getContentPane().add(ds);
		backgroundContainer.add(ds);
		
		
		ima=new JLabel(" ");
		ima.setFont(new Font("arial", Font.BOLD, 35) );
		ima.setIcon(new ImageIcon("G:\\java programming\\PC\\workspace\\images1.jpg"));;
		ima.setBounds(290,210,450,360);
		ima.setHorizontalAlignment(SwingConstants.CENTER);
		//getContentPane().add(ima);
		backgroundContainer.add(ima);
		
		
		indrug=new JButton("Insert Drugs");
		indrug.setBackground(Color.gray);
		indrug.setFont(new Font("arial", Font.BOLD, 30));
		indrug.setForeground(Color.blue);
		indrug.setBounds(80,200,280,70);
		indrug.setToolTipText("Press to enter the drugs");
		indrug.addActionListener(this);
		//getContentPane().add(indrug);
		backgroundContainer.add(indrug);
		
		
		updrug=new JButton("Update Drugs");
		updrug.setBackground(Color.gray);
		updrug.setFont(new Font("arial", Font.BOLD, 30));
		updrug.setForeground(Color.blue);
		updrug.setBounds(80,300,280,70);
		updrug.setToolTipText("Press to update the drugs");
		updrug.setHorizontalAlignment(SwingConstants.CENTER);
		updrug.addActionListener(this);
		//getContentPane().add(updrug);
		backgroundContainer.add(updrug);
		
		
		inou=new JButton("About Stock");
		inou.setBackground(Color.gray);
		inou.setFont(new Font("arial", Font.BOLD, 30));
		inou.setForeground(Color.blue);
		inou.setBounds(80, 400, 280, 70);
		inou.setHorizontalAlignment(SwingConstants.CENTER);
		inou.setToolTipText("Press to show the stock");
		inou.addActionListener(this);
		//getContentPane().add(inou);
		backgroundContainer.add(inou);
		
		back=new JButton("Back");
		back.setBackground(Color.gray);
		back.setFont(new Font("arial", Font.BOLD, 30));
		back.setForeground(Color.blue);
		back.setToolTipText("Press for returning to home page");
		back.addActionListener(this);
		back.setBounds(80,500,280,70);
		//getContentPane().add(back);
		backgroundContainer.add(back);
		
		//setResizable(false);
		setVisible(true);

	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrugStore dStore=new DrugStore();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Back"))
		{
			dispose();
		}
		
		else if (e.getActionCommand().equals("Insert Drugs")) {
			
			InsertDrugs iDrugs=new InsertDrugs();
			
		}
		
		else if (e.getActionCommand().equals("Update Drugs")) {
			UpdateDrug uDrug=new UpdateDrug();
			
		}
		
		else if (e.getActionCommand().equals("About Stock")) {
			AboutStock aStock=new AboutStock();
			
		}
		
	}
	class BackgroundContainer extends JPanel{
		
		private Image image;
		public BackgroundContainer() {
			image = (new ImageIcon(DrugStore.class.getResource("/resources/image8.jpg"))).getImage();
		}
		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0	, 0, getSize().width, getSize().height	, this);
		}
	}

}
