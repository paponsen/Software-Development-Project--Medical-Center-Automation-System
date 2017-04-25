package Project;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FacilitesPanel extends JPanel {
	
	JLabel label;
	Image image = (new ImageIcon(ProjectMembers.class.getResource("/resources/pic2.jpg"))).getImage();

	
	public FacilitesPanel()
	{
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getSize().width, getSize().height, this);
	}

}
