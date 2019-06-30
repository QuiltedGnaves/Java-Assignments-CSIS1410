package labGuiLayoutManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiLayoutManagerApp extends JFrame {

	private JPanel contentPane;
	int currentPanel = 1;
	JLabel[] labelCards = new JLabel[4];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLayoutManagerApp frame = new GuiLayoutManagerApp();
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
	public GuiLayoutManagerApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelControl = new JPanel();
		panelControl.setBorder(new EmptyBorder(40, 5, 40, 0));
		panelControl.setBackground(Color.WHITE);
		contentPane.add(panelControl, BorderLayout.WEST);
		panelControl.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelPreviousWrapper = new JPanel();
		panelPreviousWrapper.setOpaque(false);
		panelPreviousWrapper.setBorder(new EmptyBorder(5, 0, 5, 0));
		panelControl.add(panelPreviousWrapper);
		panelPreviousWrapper.setLayout(new BorderLayout(0, 0));
		
		JButton btnPrevious = new JButton("");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveColor("left");
			}
		});
		btnPrevious.setIcon(new ImageIcon(this.getClass().getResource("left-arrow.png")));
		btnPrevious.setFocusPainted(false);
		panelPreviousWrapper.add(btnPrevious);
		
		JPanel panelNextWrapper = new JPanel();
		panelNextWrapper.setBorder(new EmptyBorder(5, 0, 5, 0));
		panelNextWrapper.setOpaque(false);
		panelControl.add(panelNextWrapper);
		panelNextWrapper.setLayout(new BorderLayout(0, 0));
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveColor("right");
			}
		});
		btnNext.setIcon(new ImageIcon(this.getClass().getResource("right-arrow.png")));
		btnNext.setFocusPainted(false);
		panelNextWrapper.add(btnNext);
		
		JPanel panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(12, 5, 12, 5));
		panelMain.setBackground(Color.WHITE);
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new GridLayout(1, 0, 10, 10));
		
		JLabel labelCardOne = new JLabel("1");
		labelCardOne.setHorizontalAlignment(SwingConstants.CENTER);
		labelCardOne.setFont(new Font("Tahoma", Font.PLAIN, 40));
		labelCardOne.setForeground(Color.GRAY);
		labelCardOne.setOpaque(true);
		labelCardOne.setBackground(Color.ORANGE);
		panelMain.add(labelCardOne);
		
		JLabel labelCardTwo = new JLabel("2");
		labelCardTwo.setHorizontalAlignment(SwingConstants.CENTER);
		labelCardTwo.setForeground(Color.GRAY);
		labelCardTwo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		labelCardTwo.setBackground(Color.BLUE);
		labelCardTwo.setOpaque(true);
		panelMain.add(labelCardTwo);
		
		JLabel labelCardThree = new JLabel("3");
		labelCardThree.setHorizontalAlignment(SwingConstants.CENTER);
		labelCardThree.setForeground(Color.GRAY);
		labelCardThree.setFont(new Font("Tahoma", Font.PLAIN, 40));
		labelCardThree.setOpaque(true);
		labelCardThree.setBackground(Color.ORANGE);
		panelMain.add(labelCardThree);
		
		JLabel labelCardFour = new JLabel("4");
		labelCardFour.setHorizontalAlignment(SwingConstants.CENTER);
		labelCardFour.setForeground(Color.GRAY);
		labelCardFour.setFont(new Font("Tahoma", Font.PLAIN, 40));
		labelCardFour.setBackground(Color.ORANGE);
		labelCardFour.setOpaque(true);
		panelMain.add(labelCardFour);
		
		labelCards[0] = labelCardOne;
		labelCards[1] = labelCardTwo;
		labelCards[2] = labelCardThree;
		labelCards[3] = labelCardFour;
		
		JLabel lblTitle = new JLabel("Demo Layout");
		lblTitle.setOpaque(true);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setPreferredSize(new Dimension(63, 34));
		contentPane.add(lblTitle, BorderLayout.NORTH);
	}
	
	public void moveColor(String direction) {
		
		switch (direction) {
		case "left":
			if (currentPanel == 0) {
				currentPanel = 3;
			} else {
				currentPanel--;
			}
			break;
		case "right":
			if (currentPanel == 3) {
				currentPanel = 0;
			} else {
				currentPanel++;
			}
			break;
		}
		for (JLabel card : labelCards) {
			card.setBackground(Color.ORANGE);
		}
		labelCards[currentPanel].setBackground(Color.BLUE);
		
		
		
		
		
	}

}
