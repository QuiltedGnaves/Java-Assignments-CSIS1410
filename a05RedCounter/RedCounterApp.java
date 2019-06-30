/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 */
package a05RedCounter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * App designed to count the number of time the button turns red
 * 
 * @author Dax Allen
 *
 */
public class RedCounterApp extends JFrame {

	private JPanel contentPane;
	int redCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedCounterApp frame = new RedCounterApp();
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
	public RedCounterApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panelCounterBtnHolder = new JPanel();
		panelCounterBtnHolder.setMaximumSize(new Dimension(32767, 200));
		contentPane.add(panelCounterBtnHolder);
		panelCounterBtnHolder.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelCounter = new JPanel();
		panelCounter.setBorder(null);
		panelCounter.setBackground(Color.GRAY);
		panelCounterBtnHolder.add(panelCounter);
		panelCounter.setLayout(null);
		
		JLabel labelRedCounter = new JLabel("Red Counter:");
		labelRedCounter.setBounds(27, 41, 144, 26);
		labelRedCounter.setBorder(null);
		labelRedCounter.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 20));
		panelCounter.add(labelRedCounter);
		
		JLabel labelCount = new JLabel("00");
		labelCount.setBounds(183, 41, 24, 26);
		labelCount.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 20));
		panelCounter.add(labelCount);
		
		Button btnClickMe = new Button("Click Me");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = randColor();
				btnClickMe.setBackground(color);
				if (color == Color.RED) {
					redCount++;
					labelCount.setText(String.format("%02d", redCount)); //Formatted to have leading zero if <= 9
				}
			}
		});
		btnClickMe.setName("btnClickMe");
		btnClickMe.setForeground(Color.WHITE);
		btnClickMe.setFont(new Font("Source Code Pro Semibold", Font.PLAIN, 30));
		btnClickMe.setBackground(Color.BLACK);
		panelCounterBtnHolder.add(btnClickMe);
		
		JPanel panelName = new JPanel();
		panelName.setBackground(Color.LIGHT_GRAY);
		panelName.setMinimumSize(new Dimension(10, 50));
		panelName.setMaximumSize(new Dimension(32767, 100));
		contentPane.add(panelName);
		panelName.setLayout(null);
		
		JLabel labelNameGui = new JLabel("Dax's GUI");
		labelNameGui.setFont(new Font("Sylfaen", Font.BOLD, 18));
		labelNameGui.setBounds(195, 11, 86, 24);
		labelNameGui.setVerticalTextPosition(SwingConstants.BOTTOM);
		labelNameGui.setVerticalAlignment(SwingConstants.BOTTOM);
		labelNameGui.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelName.add(labelNameGui);
	}
	
	/**
	 * Function used to randomly choose a color from an array of color objects
	 * COLORS[] = red, blue, green, orange, magenta
	 * 
	 * @return Color Object
	 */
	public Color randColor() {
		Color COLORS[] = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA};
		int randResults;
		Color returnColor;
		
		randResults = (int) (Math.random()*5) + 1;
		
		switch (randResults) {
		case 1:
			returnColor = COLORS[randResults - 1]; //RED
			break;
		case 2:
			returnColor = COLORS[randResults - 1]; //BLUE
			break;
		case 3:
			returnColor = COLORS[randResults - 1]; //GREEN
			break;
		case 4:
			returnColor = COLORS[randResults - 1]; //ORANGE
			break;
		case 5:
			returnColor = COLORS[randResults - 1]; //MAGENTA
			break;
		default:
			returnColor = Color.GRAY;
		}
		
		return returnColor;	
	}
}
