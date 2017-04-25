package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ProjectMembers extends JPanel{
	
	JLabel label1,label2,label3,label4;
	Image image = (new ImageIcon(ProjectMembers.class.getResource("/resources/papon1.png"))).getImage();
	public ProjectMembers()
	{
		
//		setLayout(new GridBagLayout());
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.anchor = GridBagConstraints.WEST;
//        constraints.insets = new Insets(0,0,0,0);
//		label=new JLabel("");
//		label.setFont(new Font("arail narrow",Font.BOLD,24));
//		label.setForeground(Color.green);
//		label.setIcon(new ImageIcon("C:\\Users\\PC\\workspace\\kuet.jpg"));
//		label.setHorizontalAlignment(SwingConstants.CENTER);
//		label.setBounds(10,10,1000,500);

//		label1=new JLabel("PRIYABROTA SEN");
//		label1.setForeground(Color.blue);
//		label1.setFont(new Font("arial narrow", Font.BOLD, 20));
//		
//        constraints.gridx = 0;
//        constraints.gridy = 0;     
//        add(label1, constraints);
//	
//		
//		label2=new JLabel("Roll:1207024");
//		label2.setForeground(Color.blue);
//		label2.setFont(new Font("arial narrow", Font.BOLD, 20));
//        constraints.gridx = 0;
//        constraints.gridy = 1;     
//        add(label2, constraints);
//        
//        label3=new JLabel("TANMOY GHOSH");
//        label3.setForeground(Color.blue);
//        label3.setFont(new Font("arial narrow", Font.BOLD, 20));
//        constraints.gridx=1;
//        constraints.gridy=3;
//        add(label3,constraints);
//        
//        label4=new JLabel("Roll:1207028");
//        label4.setForeground(Color.blue);
//        label4.setFont(new Font("arial narrow", Font.BOLD, 20));
//        constraints.gridx=1;
//        constraints.gridy=4;
//        add(label4,constraints);

        
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getSize().width, getSize().height, this);
	}

}
