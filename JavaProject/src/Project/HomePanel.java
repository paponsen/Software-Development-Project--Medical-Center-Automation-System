package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	
	JLabel mtsJLabel;
	Image image = (new ImageIcon(ProjectMembers.class.getResource("/resources/kuet3.jpg"))).getImage();
	public HomePanel()
	{
		
//		mtsJLabel=new JLabel("");
//		mtsJLabel.setFont(new Font("arail narrow", Font.BOLD, 24));
//		mtsJLabel.setForeground(Color.blue);
//		mtsJLabel.setIcon(new ImageIcon(""));
		
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getSize().width, getSize().height, this);
	}
}
