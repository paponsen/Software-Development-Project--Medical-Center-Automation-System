package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class DrugServices extends JFrame implements ActionListener {

	static final String JDBC_URL = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/health_care_management";
	static final String userName = "root";
	static final String user_Password = "root";

	JLabel stop, sdown, Drug1, img, Drug2, Drug3, Drug4, Drug5, Drug6, Drug7,
			Drug8, Drug9, Drug10, opno3, date3;
	JLabel drugissued1, drugissued2, drugissued3, drugissued4, drugissued5,
			drugissued6, drugissued7, drugissued8, drugissued9, drugissued10;

	JButton submit, back;

	JTextField topno, tdrug1, tdrug2, tdrug3, tdrug4, tdrug5, tdrug6, tdrug7,
			tdrug8, tdrug9, tdrug10, tdate;
	JTextField tdrugissued1, tdrugissued2, tdrugissued3, tdrugissued4,
			tdrugissued5, tdrugissued6, tdrugissued7, tdrugissued8,
			tdrugissued9, tdrugissued10;

	String opno1, date1, drug1name, drug2name, drug3name, drug4name, drug5name,
			drug6name, drug7name, drug8name, drug9name, drug10name;

	int issued1, issued2, issued3, issued4, issued5, issued6, issued7, issued8,
			issued9, issued10;

	java.util.Date today;
	UtilDateModel model;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	BackgroundContainer backgroundContainer;

	public DrugServices() {
		backgroundContainer = new BackgroundContainer();
		backgroundContainer.setLayout(null);
		add(backgroundContainer);

		// setLayout(null);
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 10, 1020, 725);
		stop = new JLabel("KUET Medical Center,KUET");
		stop.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		stop.setForeground(new Color(255, 51, 255));
		stop.setHorizontalAlignment(SwingConstants.CENTER);
		stop.setBounds(120, 20, 590, 30);
		backgroundContainer.add(stop);

		sdown = new JLabel("Medicines");
		sdown.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		sdown.setForeground(Color.red);
		sdown.setHorizontalAlignment(SwingConstants.CENTER);
		sdown.setBounds(300, 60, 250, 20);
		backgroundContainer.add(sdown);

		opno3 = new JLabel("IdNo:");
		opno3.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		opno3.setForeground(Color.green);
		opno3.setHorizontalAlignment(SwingConstants.CENTER);
		opno3.setBounds(60, 85, 180, 40);
		backgroundContainer.add(opno3);

		date3 = new JLabel("DATE:");
		date3.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		date3.setForeground(Color.green);
		date3.setHorizontalAlignment(SwingConstants.CENTER);
		date3.setBounds(440, 85, 180, 40);
		backgroundContainer.add(date3);

		Drug1 = new JLabel("Drug1:");
		Drug1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		Drug1.setForeground(Color.green);
		Drug1.setHorizontalAlignment(SwingConstants.CENTER);
		Drug1.setBounds(60, 135, 180, 40);
		backgroundContainer.add(Drug1);

		Drug2 = new JLabel("Drug2:");
		Drug2.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		Drug2.setForeground(Color.green);
		Drug2.setHorizontalAlignment(SwingConstants.CENTER);
		Drug2.setBounds(60, 185, 180, 40);
		backgroundContainer.add(Drug2);

		Drug3 = new JLabel("Drug3:");
		Drug3.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		Drug3.setForeground(Color.green);
		Drug3.setHorizontalAlignment(SwingConstants.CENTER);
		Drug3.setBounds(60, 235, 180, 40);
		backgroundContainer.add(Drug3);

		Drug4 = new JLabel("Drug4:");
		Drug4.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		Drug4.setForeground(Color.green);
		Drug4.setHorizontalAlignment(SwingConstants.CENTER);
		Drug4.setBounds(60, 285, 180, 40);
		backgroundContainer.add(Drug4);

		Drug5 = new JLabel("Drug5:");
		Drug5.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		Drug5.setForeground(Color.green);
		Drug5.setHorizontalAlignment(SwingConstants.CENTER);
		Drug5.setBounds(60, 335, 180, 40);
		backgroundContainer.add(Drug5);

		Drug6 = new JLabel("Drug6:");
		Drug6.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		Drug6.setForeground(Color.green);
		Drug6.setHorizontalAlignment(SwingConstants.CENTER);
		Drug6.setBounds(60, 395, 180, 40);
		backgroundContainer.add(Drug6);

		Drug7 = new JLabel("Drug7:");
		Drug7.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		Drug7.setForeground(Color.green);
		Drug7.setHorizontalAlignment(SwingConstants.CENTER);
		Drug7.setBounds(60, 445, 180, 40);
		backgroundContainer.add(Drug7);

		Drug8 = new JLabel("Drug8:");
		Drug8.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		Drug8.setForeground(Color.green);
		Drug8.setHorizontalAlignment(SwingConstants.CENTER);
		Drug8.setBounds(60, 495, 180, 40);
		backgroundContainer.add(Drug8);

		Drug9 = new JLabel("Drug9:");
		Drug9.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		Drug9.setForeground(Color.green);
		Drug9.setHorizontalAlignment(SwingConstants.CENTER);
		Drug9.setBounds(60, 545, 180, 40);
		backgroundContainer.add(Drug9);

		Drug10 = new JLabel("Drug10:");
		Drug10.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		Drug10.setForeground(Color.green);
		Drug10.setHorizontalAlignment(SwingConstants.CENTER);
		Drug10.setBounds(60, 595, 180, 40);
		backgroundContainer.add(Drug10);

		drugissued1 = new JLabel("No.Of Drugs1:");
		drugissued1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		drugissued1.setForeground(Color.green);
		drugissued1.setHorizontalAlignment(SwingConstants.CENTER);
		drugissued1.setBounds(420, 135, 180, 40);
		backgroundContainer.add(drugissued1);

		drugissued2 = new JLabel("No.Of Drugs2:");
		drugissued2.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		drugissued2.setForeground(Color.green);
		drugissued2.setHorizontalAlignment(SwingConstants.CENTER);
		drugissued2.setBounds(420, 185, 180, 40);
		backgroundContainer.add(drugissued2);

		drugissued3 = new JLabel("No.Of Drugs3:");
		drugissued3.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		drugissued3.setForeground(Color.green);
		drugissued3.setHorizontalAlignment(SwingConstants.CENTER);
		drugissued3.setBounds(420, 235, 180, 40);
		backgroundContainer.add(drugissued3);

		drugissued4 = new JLabel("No.Of Drugs4:");
		drugissued4.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		drugissued4.setForeground(Color.green);
		drugissued4.setHorizontalAlignment(SwingConstants.CENTER);
		drugissued4.setBounds(420, 285, 180, 40);
		backgroundContainer.add(drugissued4);

		drugissued5 = new JLabel("No.Of Drugs5:");
		drugissued5.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		drugissued5.setForeground(Color.green);
		drugissued5.setHorizontalAlignment(SwingConstants.CENTER);
		drugissued5.setBounds(420, 335, 180, 40);
		backgroundContainer.add(drugissued5);

		drugissued6 = new JLabel("No.Of Drugs6:");
		drugissued6.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		drugissued6.setForeground(Color.green);
		drugissued6.setHorizontalAlignment(SwingConstants.CENTER);
		drugissued6.setBounds(420, 390, 180, 40);
		backgroundContainer.add(drugissued6);

		drugissued7 = new JLabel("No.Of Drugs7:");
		drugissued7.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		drugissued7.setForeground(Color.green);
		drugissued7.setHorizontalAlignment(SwingConstants.CENTER);
		drugissued7.setBounds(420, 440, 180, 40);
		backgroundContainer.add(drugissued7);

		drugissued8 = new JLabel("No.Of Drugs8:");
		drugissued8.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		drugissued8.setForeground(Color.green);
		drugissued8.setHorizontalAlignment(SwingConstants.CENTER);
		drugissued8.setBounds(420, 490, 180, 40);
		backgroundContainer.add(drugissued8);

		drugissued9 = new JLabel("No.Of Drugs9:");
		drugissued9.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		drugissued9.setForeground(Color.green);
		drugissued9.setHorizontalAlignment(SwingConstants.CENTER);
		drugissued9.setBounds(420, 540, 180, 40);
		backgroundContainer.add(drugissued9);

		drugissued10 = new JLabel("No.Of Drugs10:");
		drugissued10.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		drugissued10.setForeground(Color.green);
		drugissued10.setHorizontalAlignment(SwingConstants.CENTER);
		drugissued10.setBounds(420, 590, 180, 40);
		backgroundContainer.add(drugissued10);

		topno = new JTextField("");
		topno.setFont(new Font("Times New Roman", Font.BOLD, 18));
		topno.setForeground(new Color(55, 55, 153));
		topno.setBounds(180, 90, 180, 30);
		backgroundContainer.add(topno);

		// tdate=new JTextField("");
		// tdate.setFont(new Font("Times New Roman",Font.BOLD,18));
		// tdate.setForeground(new Color(55,55,153));
		// tdate.setBounds (580,90,180,30);
		// getContentPane().add(tdate);

		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setForeground(new Color(55, 55, 153));
		datePicker.setBounds(580, 90, 180, 25);
		backgroundContainer.add(datePicker);
		today = (java.util.Date) datePicker.getModel().getValue();

		tdrug1 = new JTextField("");
		tdrug1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrug1.setForeground(new Color(55, 55, 153));
		tdrug1.setBounds(180, 140, 230, 30);
		backgroundContainer.add(tdrug1);

		tdrug2 = new JTextField("");
		tdrug2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrug2.setForeground(new Color(55, 55, 153));
		tdrug2.setBounds(180, 190, 230, 30);
		backgroundContainer.add(tdrug2);

		tdrug3 = new JTextField("");
		tdrug3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrug3.setForeground(new Color(55, 55, 153));
		tdrug3.setBounds(180, 240, 230, 30);
		backgroundContainer.add(tdrug3);

		tdrug4 = new JTextField("");
		tdrug4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrug4.setForeground(new Color(55, 55, 153));
		tdrug4.setBounds(180, 290, 230, 30);
		backgroundContainer.add(tdrug4);

		tdrug5 = new JTextField("");
		tdrug5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrug5.setForeground(new Color(55, 55, 153));
		tdrug5.setBounds(180, 340, 230, 30);
		backgroundContainer.add(tdrug5);

		tdrug6 = new JTextField("");
		tdrug6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrug6.setForeground(new Color(55, 55, 153));
		tdrug6.setBounds(180, 400, 230, 30);
		backgroundContainer.add(tdrug6);

		tdrug7 = new JTextField("");
		tdrug7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrug7.setForeground(new Color(55, 55, 153));
		tdrug7.setBounds(180, 450, 230, 30);
		backgroundContainer.add(tdrug7);

		tdrug8 = new JTextField("");
		tdrug8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrug8.setForeground(new Color(55, 55, 153));
		tdrug8.setBounds(180, 500, 230, 30);
		backgroundContainer.add(tdrug8);

		tdrug9 = new JTextField("");
		tdrug9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrug9.setForeground(new Color(55, 55, 153));
		tdrug9.setBounds(180, 550, 230, 30);
		backgroundContainer.add(tdrug9);

		tdrug10 = new JTextField("");
		tdrug10.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrug10.setForeground(new Color(55, 55, 153));
		tdrug10.setBounds(180, 600, 230, 30);
		backgroundContainer.add(tdrug10);

		tdrugissued1 = new JTextField("0");
		tdrugissued1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrugissued1.setForeground(new Color(55, 55, 153));
		tdrugissued1.setBounds(580, 140, 180, 30);
		backgroundContainer.add(tdrugissued1);

		tdrugissued2 = new JTextField("0");
		tdrugissued2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrugissued2.setForeground(new Color(55, 55, 153));
		tdrugissued2.setBounds(580, 190, 180, 30);
		backgroundContainer.add(tdrugissued2);

		tdrugissued3 = new JTextField("0");
		tdrugissued3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrugissued3.setForeground(new Color(55, 55, 153));
		tdrugissued3.setBounds(580, 240, 180, 30);
		backgroundContainer.add(tdrugissued3);

		tdrugissued4 = new JTextField("0");
		tdrugissued4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrugissued4.setForeground(new Color(55, 55, 153));
		tdrugissued4.setBounds(580, 290, 180, 30);
		backgroundContainer.add(tdrugissued4);

		tdrugissued5 = new JTextField("0");
		tdrugissued5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrugissued5.setForeground(new Color(55, 55, 153));
		tdrugissued5.setBounds(580, 340, 180, 30);
		backgroundContainer.add(tdrugissued5);

		tdrugissued6 = new JTextField("0");
		tdrugissued6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrugissued6.setForeground(new Color(55, 55, 153));
		tdrugissued6.setBounds(580, 395, 180, 30);
		backgroundContainer.add(tdrugissued6);

		tdrugissued7 = new JTextField("0");
		tdrugissued7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrugissued7.setForeground(new Color(55, 55, 153));
		tdrugissued7.setBounds(580, 445, 180, 30);
		backgroundContainer.add(tdrugissued7);

		tdrugissued8 = new JTextField("0");
		tdrugissued8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrugissued8.setForeground(new Color(55, 55, 153));
		tdrugissued8.setBounds(580, 495, 180, 30);
		backgroundContainer.add(tdrugissued8);

		tdrugissued9 = new JTextField("0");
		tdrugissued9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrugissued9.setForeground(new Color(55, 55, 153));
		tdrugissued9.setBounds(580, 545, 180, 30);
		backgroundContainer.add(tdrugissued9);

		tdrugissued10 = new JTextField("0");
		tdrugissued10.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tdrugissued10.setForeground(new Color(55, 55, 153));
		tdrugissued10.setBounds(580, 595, 180, 30);
		backgroundContainer.add(tdrugissued10);

		submit = new JButton("Submit");
		submit.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		submit.setBounds(300, 645, 160, 40);
		submit.setForeground(new Color(0, 0, 255));
		submit.setBackground(Color.gray);
		submit.addActionListener(this);
		submit.setToolTipText("Press to submit the detials");
		backgroundContainer.add(submit);

		back = new JButton("Back");
		back.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		back.setBounds(480, 645, 160, 40);
		back.setForeground(new Color(0, 0, 255));
		back.setBackground(Color.gray);
		back.addActionListener(this);
		back.setToolTipText("PRESS TO DISPOSE");
		backgroundContainer.add(back);

		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrugServices drugServices = new DrugServices();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("Back")) {
			dispose();
		} else if (e.getActionCommand().equals("")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
		
		

					opno1 = topno.getText();

					// date1=tdate.getText();

					java.util.Date date = (java.util.Date) datePicker
							.getModel().getValue();
					date1 = date.toString();
					drug1name = tdrug1.getText();
					issued1 = Integer.parseInt(tdrugissued1.getText());
					drug2name = tdrug2.getText();
					issued2 = Integer.parseInt(tdrugissued2.getText());
					drug3name = tdrug3.getText();
					issued3 = Integer.parseInt(tdrugissued3.getText());
					drug4name = tdrug4.getText();
					issued4 = Integer.parseInt(tdrugissued4.getText());
					drug5name = tdrug5.getText();
					issued5 = Integer.parseInt(tdrugissued5.getText());
					drug6name = tdrug6.getText();
					issued6 = Integer.parseInt(tdrugissued6.getText());
					drug7name = tdrug7.getText();
					issued7 = Integer.parseInt(tdrugissued7.getText());
					drug8name = tdrug8.getText();
					issued8 = Integer.parseInt(tdrugissued8.getText());
					drug9name = tdrug9.getText();
					issued9 = Integer.parseInt(tdrugissued9.getText());
					drug10name = tdrug10.getText();
					issued10 = Integer.parseInt(tdrugissued10.getText());

					updateDrugAbount(drug1name, issued1);
					updateDrugAbount(drug2name, issued2);
					updateDrugAbount(drug3name, issued3);
					updateDrugAbount(drug4name, issued4);
					updateDrugAbount(drug5name, issued5);
					updateDrugAbount(drug6name, issued6);
					updateDrugAbount(drug7name, issued7);
					updateDrugAbount(drug8name, issued8);
					updateDrugAbount(drug9name, issued9);
					updateDrugAbount(drug10name, issued10);




			
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getActionCommand().equals("Submit")) {

			try {
				Class.forName("com.mysql.jdbc.Driver");

				try {
					Connection con = DriverManager.getConnection(DB_URL,
							userName, user_Password);

					opno1 = topno.getText();

					// date1=tdate.getText();

					java.util.Date date = (java.util.Date) datePicker
							.getModel().getValue();
					date1 = date.toString();
					drug1name = tdrug1.getText();
					issued1 = Integer.parseInt(tdrugissued1.getText());
					drug2name = tdrug2.getText();
					issued2 = Integer.parseInt(tdrugissued2.getText());
					drug3name = tdrug3.getText();
					issued3 = Integer.parseInt(tdrugissued3.getText());
					drug4name = tdrug4.getText();
					issued4 = Integer.parseInt(tdrugissued4.getText());
					drug5name = tdrug5.getText();
					issued5 = Integer.parseInt(tdrugissued5.getText());
					drug6name = tdrug6.getText();
					issued6 = Integer.parseInt(tdrugissued6.getText());
					drug7name = tdrug7.getText();
					issued7 = Integer.parseInt(tdrugissued7.getText());
					drug8name = tdrug8.getText();
					issued8 = Integer.parseInt(tdrugissued8.getText());
					drug9name = tdrug9.getText();
					issued9 = Integer.parseInt(tdrugissued9.getText());
					drug10name = tdrug10.getText();
					issued10 = Integer.parseInt(tdrugissued10.getText());
					PreparedStatement pstm = (PreparedStatement) con
							.prepareStatement("insert into medicineservice values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

					pstm.setString(1, opno1);
					pstm.setString(2, date1);
					pstm.setString(3, drug1name);
					pstm.setInt(4, issued1);
					pstm.setString(5, drug2name);
					pstm.setInt(6, issued2);
					pstm.setString(7, drug3name);
					pstm.setInt(8, issued3);
					pstm.setString(9, drug4name);
					pstm.setInt(10, issued4);
					pstm.setString(11, drug5name);
					pstm.setInt(12, issued5);
					pstm.setString(13, drug6name);
					pstm.setInt(14, issued6);
					pstm.setString(15, drug7name);
					pstm.setInt(16, issued7);
					pstm.setString(17, drug8name);
					pstm.setInt(18, issued8);
					pstm.setString(19, drug9name);
					pstm.setInt(20, issued9);
					pstm.setString(21, drug10name);
					pstm.setInt(22, issued10);

					pstm.executeUpdate();
					updateDrugAbount(drug1name, issued1);
					updateDrugAbount(drug2name, issued2);
					updateDrugAbount(drug3name, issued3);
					updateDrugAbount(drug4name, issued4);
					updateDrugAbount(drug5name, issued5);
					updateDrugAbount(drug6name, issued6);
					updateDrugAbount(drug7name, issued7);
					updateDrugAbount(drug8name, issued8);
					updateDrugAbount(drug9name, issued9);
					updateDrugAbount(drug10name, issued10);

					pstm.close();

					con.close();
					JOptionPane.showMessageDialog(null,
							"Ok!!!", "Success",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Not registered",
							"Error", JOptionPane.ERROR_MESSAGE);

				}

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	public void updateDrugAbount(String dname, int ammount) {
		try {
			Connection con = DriverManager.getConnection(DB_URL, userName,
					user_Password);
			PreparedStatement getTotalStatement = (PreparedStatement) con
					.prepareStatement("select total from drugs where drugname=?;");
			PreparedStatement updateStatement = (PreparedStatement) con
					.prepareStatement("update drugs set total=? where drugname=?;");

			getTotalStatement.setString(1, dname);
			ResultSet resultSet = getTotalStatement.executeQuery();
			if (resultSet.next()) {
				int newValue = resultSet.getInt(1) - ammount;
				updateStatement.setInt(1, newValue);
				updateStatement.setString(2, dname);
				updateStatement.executeUpdate();

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	class BackgroundContainer extends JPanel {

		private Image image;

		public BackgroundContainer() {
			image = (new ImageIcon(
					DrugServices.class.getResource("/resources/image2.jpg")))
					.getImage();
		}

		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paintComponent(arg0);
			arg0.drawImage(image, 0, 0, getSize().width, getSize().height, this);
		}
	}

}
