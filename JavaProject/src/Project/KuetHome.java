package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class KuetHome extends JDialog implements ActionListener {
	
	JLabel stop,sdown,label;
	JButton back;
	JPanel panel;
	
	public KuetHome(Window window)
	{
		super(window, ModalityType.APPLICATION_MODAL);
		setLayout(null);
		setBounds(200,10,1020,725);
		panel=new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(1020,725));
		
		stop=new JLabel("Kuet Medical Center,Khulna");
		stop.setFont(new Font("arail narrow", Font.ITALIC, 36));
		stop.setForeground(Color.GREEN);
		stop.setHorizontalAlignment(SwingConstants.CENTER);
		stop.setBounds(120,50,650,30);
		//panel.add(stop);
		getContentPane().add(stop);
		
		sdown=new JLabel("----------------------------------------------");
		sdown.setFont(new Font("arail narrow", Font.BOLD, 36));
		sdown.setBounds(130,70,650,20);
		sdown.setForeground(Color.red);
		sdown.setHorizontalAlignment(SwingConstants.LEADING);
		//panel.add(sdown);
		getContentPane().add(sdown);
		
		label=new JLabel("");
		label.setFont(new Font("arail narrow", Font.ITALIC, 18));
		label.setForeground(Color.blue);
		label.setBounds(760,10,200,110);
		label.setHorizontalAlignment(SwingConstants.LEADING);
		label.setIcon(new ImageIcon("C:\\Users\\PC\\workspace\\cart.gif"));
		//panel.add(label);
		getContentPane().add(label);
		
		JTabbedPane jtp=new JTabbedPane();
		//jtp.addTab("Information", new HomePanel());
		jtp.addTab("Staff Pattern", new SpecialPanel());
		jtp.addTab("Beneficiaries", new FacilitesPanel());
		jtp.addTab("Project Members", new ProjectMembers());
		//jtp.addTab("Back", new backToHome());
		jtp.setBounds(10,110,1000,550);
		//panel.add(jtp);
		getContentPane().add(jtp);
		
		back=new JButton("<<BACK");
		back.setFont(new Font("arial", Font.BOLD, 12));
		back.setForeground(Color.red);
		back.setBounds(10,60,80,30);
		getContentPane().add(back);
		//panel.add(back);
		back.addActionListener(this);
		panel.setBounds(0,0,1020,725);
		//
		//add(panel);
		
		
		
		setVisible(true);
		
		
		
		
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		KuetHome kHome=new KuetHome();
//
//	}
	
	public class backToHome extends JLabel implements ActionListener{
		
		public backToHome()
		{
			//Home home=new Home();
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getActionCommand().equals("Back"))
			{
				Home home=new Home();
			}
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equals("<<BACK")) {
			dispose();
			
		}
		
	}

}


