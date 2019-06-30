/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 */
package labBalloon;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;

/**
 * App that randomly creates two Balloon objects and then compares them.
 * Displays if they are equal or not.
 * 
 * @author Dax Allen
 *
 */
public class BalloonApp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIsEquals;
	private JButton imgBalloonOne, imgBalloonTwo;
	private JLabel lblBalloonOne, lblBalloonTwo;
	
	Map<String, ImageIcon> balloonImgs = new HashMap<String, ImageIcon>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalloonApp frame = new BalloonApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BalloonApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelFooter = panelFooter();
		contentPane.add(panelFooter, BorderLayout.SOUTH);
		
		JPanel panelMain = panelMain();
		contentPane.add(panelMain, BorderLayout.CENTER);
		
		JPanel panelTitle = panelTitle();
		contentPane.add(panelTitle, BorderLayout.NORTH);
		
	}

	/**
	 * Creates the Title JPanel and content
	 * @return Jpanel for the title and content
	 */
	private JPanel panelTitle() {
		
		JPanel panelTitle = new JPanel();
		
		JLabel lblTitle = new JLabel("Balloon Demo");
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTitle.add(lblTitle);
		
		return panelTitle;
	}

	/**
	 * Creates the Main JPanel and content
	 * @return JPanel for the main area and content
	 */
	private JPanel panelMain() {
		
		JPanel panelMain = new JPanel();
		
		panelMain.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelMain.setLayout(new GridLayout(1, 0, 10, 0));
		
		JPanel panelBalloonLeft = new JPanel();
		panelMain.add(panelBalloonLeft);
		panelBalloonLeft.setLayout(new BorderLayout(0, 0));
		
		imgBalloonOne = new JButton("", new ImageIcon("D:\\School\\2019 Summer\\CSIS 1410\\Labs\\Labs\\src\\labBalloon\\balloon100.jpg"));
		imgBalloonOne.setBackground(Color.WHITE);
		imgBalloonOne.setVerticalTextPosition(SwingConstants.BOTTOM);
		imgBalloonOne.setFocusPainted(false);
		panelBalloonLeft.add(imgBalloonOne);
		
		lblBalloonOne = new JLabel("Air XS");
		lblBalloonOne.setForeground(Color.DARK_GRAY);
		lblBalloonOne.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblBalloonOne.setHorizontalAlignment(SwingConstants.CENTER);
		panelBalloonLeft.add(lblBalloonOne, BorderLayout.SOUTH);
		
		JPanel panelBalloonRight = new JPanel();
		panelMain.add(panelBalloonRight);
		panelBalloonRight.setLayout(new BorderLayout(0, 0));
		
		imgBalloonTwo = new JButton("");
		imgBalloonTwo.setBackground(Color.WHITE);
		imgBalloonTwo.setIcon(new ImageIcon("D:\\School\\2019 Summer\\CSIS 1410\\Labs\\Labs\\src\\labBalloon\\balloon20.jpg"));
		imgBalloonTwo.setFocusPainted(false);
		panelBalloonRight.add(imgBalloonTwo, BorderLayout.CENTER);
		
		lblBalloonTwo = new JLabel("Helium XS");
		lblBalloonTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalloonTwo.setForeground(Color.DARK_GRAY);
		lblBalloonTwo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panelBalloonRight.add(lblBalloonTwo, BorderLayout.SOUTH);
		
		return panelMain;
	}

	/**
	 * Creates the Footer JPanel and content
	 * @return JPanel for the footer and content
	 */
	private JPanel panelFooter() {
		
		balloonImgs.put("XS", new ImageIcon(this.getClass().getResource("balloon20.jpg")));
		balloonImgs.put("S", new ImageIcon(this.getClass().getResource("balloon40.jpg")));
		balloonImgs.put("M", new ImageIcon(this.getClass().getResource("balloon60.jpg")));
		balloonImgs.put("L", new ImageIcon(this.getClass().getResource("balloon80.jpg")));
		balloonImgs.put("XL", new ImageIcon(this.getClass().getResource("balloon100.jpg")));
		
		JPanel panelFooter = new JPanel();
		
		JButton btnGetBalloons = new JButton("Get Random Balloons");
		btnGetBalloons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random rand = new Random();
				boolean isHelium1 = rand.nextBoolean();
				boolean isHelium2 = rand.nextBoolean();
				String size1 = Sizes.getRandomSize().toString();
				String size2 = Sizes.getRandomSize().toString();
				
				Balloon balloonOne = new Balloon(
						size1,
						(isHelium1) ? "Helium" : "Air",
						balloonImgs.get(size1)
						);
				Balloon balloonTwo = new Balloon(
						size2,
						(isHelium2) ? "Helium" : "Air",
						balloonImgs.get(size2)
						);
				
				lblBalloonOne.setText(balloonOne.getInflatedWith() + " " + balloonOne.getSize());
				imgBalloonOne.setIcon(balloonOne.getSizeImage());
				
				lblBalloonTwo.setText(balloonTwo.getInflatedWith() + " " + balloonTwo.getSize());
				imgBalloonTwo.setIcon(balloonTwo.getSizeImage());
				
				if (balloonOne.equals(balloonTwo)) {
					textFieldIsEquals.setText("Equal");
					textFieldIsEquals.setBackground(new Color(144, 238, 144));
				} else {
					textFieldIsEquals.setText("Not Equal");
					textFieldIsEquals.setBackground(new Color(250, 128, 114));
				}
				
			}
		});
		panelFooter.add(btnGetBalloons);
		
		textFieldIsEquals = new JTextField();
		textFieldIsEquals.setEditable(false);
		textFieldIsEquals.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIsEquals.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldIsEquals.setBackground(new Color(250, 128, 114));
		textFieldIsEquals.setText("Not Equal");
		textFieldIsEquals.setColumns(10);
		panelFooter.add(textFieldIsEquals);
		
		
		return panelFooter;
	}

}
