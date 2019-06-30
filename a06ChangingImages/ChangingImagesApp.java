/*
 * Dax Allen
 * CSIS 1410
 * Section 402
 */
package a06ChangingImages;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * App that draws a control area on the left and a totem on the right. Allows cycling of totem eye emotions when checkbox is check and button pressed. 
 * If no checkboxes are pressed then the background colors change.
 * @author Dax Allen
 *
 */
public class ChangingImagesApp extends JFrame {

	private JPanel contentPane;
	
	
	JLabel lblXCoord, lblYCoord;
	JCheckBox chckbxTopTotem, chckbxMiddleTotem, chckbxBottomTotem;
	int topCount = 0, midCount = 0, botCount = 0;
	CanvasPiece topCanvas, midCanvas, botCanvas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangingImagesApp frame = new ChangingImagesApp();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangingImagesApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelControl = controlPanel();
		panelControl.setLayout(null);
		
		chckbxTopTotem = chbxForCanvasSection("Top Totem", 34);
		panelControl.add(chckbxTopTotem);
		
		chckbxMiddleTotem = chbxForCanvasSection("Middle Totem", 68);
		panelControl.add(chckbxMiddleTotem);
		
		chckbxBottomTotem = chbxForCanvasSection("Bottom Totem", 101);
		panelControl.add(chckbxBottomTotem);
		
		JButton btnChangeTotems = changeTotem();
		panelControl.add(btnChangeTotems);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("full_totem.png")));
		lblNewLabel.setBounds(0, 207, 180, 314);
		panelControl.add(lblNewLabel);
		
		JLabel lblX = mouseLocationLabel("X:", 20, 18);
		panelControl.add(lblX);
		 
		JLabel lblY = mouseLocationLabel("Y:", 96, 18);
		panelControl.add(lblY);
		
		lblXCoord = mouseLocationLabel("", 40, 46);
		lblXCoord.setBounds(40, 193, 46, 14);
		panelControl.add(lblXCoord);
		
		lblYCoord = mouseLocationLabel("", 113, 46);
		lblYCoord.setBounds(113, 193, 46, 14);
		panelControl.add(lblYCoord);
		
		JPanel panelCanvas = new JPanel();
		contentPane.add(panelCanvas, BorderLayout.CENTER);
		panelCanvas.setLayout(new BoxLayout(panelCanvas, BoxLayout.Y_AXIS));
		
		topCanvas = new CanvasPiece("TOP");
		topCanvas.setBackground(Color.WHITE);
		panelCanvas.add(topCanvas);
		
		midCanvas = new CanvasPiece("MID");
		midCanvas.setBackground(Color.WHITE);
		panelCanvas.add(midCanvas);
		
		botCanvas = new CanvasPiece("BOT");
		botCanvas.setBackground(Color.WHITE);
		panelCanvas.add(botCanvas);
		
		addMouseMotionListener(new MyMouseAdapter());
		
	}

	/**
	 * Creates the button, actionListener, and logic for changing the totem's eyes
	 * @return JButton object
	 */
	private JButton changeTotem() {
		JButton btnChangeTotems = new JButton("Change Totems");
		btnChangeTotems.setFocusPainted(false);
		btnChangeTotems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxTopTotem.isSelected() || chckbxMiddleTotem.isSelected() || chckbxBottomTotem.isSelected()) {
					if (chckbxTopTotem.isSelected()) {
						if (topCount > 2) {
							topCount = 0;
						}
						topCanvas.allEyesFalse();
						switch (topCount) {
						case 0:
							topCanvas.happyEyes();
							break;
						case 1:
							topCanvas.normalEyes();
							break;
						case 2:
							topCanvas.angryEyes();
							break;
						}
						topCount++;
					}
					
					if (chckbxMiddleTotem.isSelected()) {
						if (midCount > 2) {
							midCount = 0;
						}
						midCanvas.allEyesFalse();
						switch (midCount) {
						case 0:
							midCanvas.happyEyes();
							break;
						case 1:
							midCanvas.normalEyes();
							break;
						case 2:
							midCanvas.angryEyes();
							break;
						}
						midCount++;
					}
					
					if (chckbxBottomTotem.isSelected()) {
						if (botCount > 2) {
							botCount = 0;
						}
						botCanvas.allEyesFalse();
						switch (botCount) {
						case 0:
							botCanvas.happyEyes();
							break;
						case 1:
							botCanvas.normalEyes();
							break;
						case 2:
							botCanvas.angryEyes();
							break;
						}
						botCount++;
					}
					
				} else {
					Random rand = new Random();
					// HSL color scheme
					topCanvas.setBackground(Color.getHSBColor(rand.nextFloat(), rand.nextInt(2000) + 1000 / 10000f, 0.9f));
					midCanvas.setBackground(Color.getHSBColor(rand.nextFloat(), rand.nextInt(2000) + 1000 / 10000f, 0.9f));
					botCanvas.setBackground(Color.getHSBColor(rand.nextFloat(), rand.nextInt(2000) + 1000 / 10000f, 0.9f));
				}
			}
		});
		btnChangeTotems.setBorder(new EmptyBorder(10, 12, 10, 12));
		btnChangeTotems.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		btnChangeTotems.setBounds(20, 140, 132, 30);
		btnChangeTotems.setAlignmentX(Component.CENTER_ALIGNMENT);
		return btnChangeTotems;
	}

	/**
	 * Creates labels for mouse location
	 * @param textValue Value for JLabel
	 * @param x int value for x coordinate
	 * @param width int value for width of JLabel
	 * @return JLabel Object
	 */
	private JLabel mouseLocationLabel(String textValue, int x, int width) {
		JLabel lbl = new JLabel(textValue);
		lbl.setBounds(x, 193, width, 14);
		return lbl;
	}

	/**
	 * Creates the JPanel that holds the controls
	 * @return JPanel Object for holding controls
	 */
	private JPanel controlPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(180, 10));
		contentPane.add(panel, BorderLayout.WEST);
		return panel;
	}

	/**
	 * Creates the check boxes in the control panel.
	 * @param whichSection Text title for check box
	 * @param y Y value for setting location
	 * @return JCheckBox 
	 */
	private JCheckBox chbxForCanvasSection(String whichSection, int y) {
		JCheckBox chckbx = new JCheckBox(whichSection, false);
		chckbx.setFocusPainted(false);
		chckbx.setOpaque(false);
		chckbx.setForeground(Color.DARK_GRAY);
		chckbx.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		chckbx.setBounds(20, y, 130, 23);
		return chckbx;
	}
	
	/**
	 * Creates canvas pieces and handles all repainting
	 * @author Dax Allen
	 *
	 */
	private class CanvasPiece extends JPanel {
		
		String section;
		boolean drawHappyEyes, drawNormalEyes  = true, drawAngryEyes;
		
		/**
		 * Set the canvas piece "section" top, middle, or bottom
		 * @param section
		 */
		public CanvasPiece(String section) {
			this.section = section;
		}
		
		/**
		 * Standard paintComponent override used to handle all painting
		 * 
		 * @param g
		 */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(3));
			
			g2.setColor(Color.BLACK);
			
			switch(section) {
			case "TOP":
				topCanvas(g2);
				break;
			case "MID":
				midCanvas(g2);
				break;
			case "BOT":
				botCanvas(g2);
				break;
			default:
				break;
			}
			
			g2.setColor(Color.BLACK);
			
			if (this.drawHappyEyes) {
				
				
				if (this.section == "TOP") {
					// Eye - TOP
					// Left Eye
					g2.drawArc(240, 50, 30, 30, 0, 180);
					// Right Eye
					g2.drawArc(300, 50, 30, 30, 0, 180);
				} else {
					// Eye - MID & BOT
					// Left Eye
					g2.drawArc(240, 40, 30, 30, 0, 180);
					// Right Eye
					g2.drawArc(300, 40, 30, 30, 0, 180);
				}
			}
			if (this.drawNormalEyes) {
				
				if (this.section == "TOP") {
					// Eyes - Top
					// Left Eye
					g2.drawOval(240, 50, 30, 30);
					// Right Eye
					g2.drawOval(300, 50, 30, 30);
				} else {
					// Eyes - Standard
					// Left Eye
					g2.drawOval(240, 40, 30, 30);
					// Right Eye
					g2.drawOval(300, 40, 30, 30);
				}
			}
			if (this.drawAngryEyes) {
				
				if (this.section == "TOP") {
					// Eyes - TOP
					// Left Eye
					g2.drawArc(240, 50, 30, 20, 130, 200);
					g2.drawLine(230, 43, 270, 65);
					// Right Eye
					g2.drawArc(300, 50, 30, 20, 50, -200);
					g2.drawLine(340, 43, 300, 65);
				} else {
					// Eyes - Mid & BOT
					// Left Eye
					g2.drawArc(240, 40, 30, 20, 130, 200);
					g2.drawLine(230, 33, 270, 55);
					// Right Eye
					g2.drawArc(300, 40, 30, 20, 50, -200);
					g2.drawLine(340, 33, 300, 55);
				}
				
			}
			
			
			
		}
		/**
		 * Method to create the fixed parts of the top canvas.
		 * @param g2T Graphics2D object
		 */
		private void topCanvas(Graphics2D g2T) {
			
			// Body
			g2T.drawRect(210, 10, 150, 167);
			
			// Left Wing
			g2T.drawLine(35, 50, 210, 50); // Top of wing
			
			g2T.drawLine(35, 50, 35, 70); // First vertical line
			g2T.drawArc(35, 50, 40, 40, 180, 90); // First arc
			g2T.drawLine(55, 90, 90, 90);// Horizontal Line after first arc
			
			g2T.drawLine(90, 90, 90, 110); // Second vertical line
			g2T.drawArc(90, 90, 40, 40, 180, 90); // Second arc
			g2T.drawLine(110, 130, 155, 130);// Horizontal Line after second arc
			
			g2T.drawLine(155, 130, 155, 150); // Third vertical line
			g2T.drawArc(155, 130, 40, 40, 180, 90); // Third arc
			g2T.drawLine(175, 170, 210, 170);// Horizontal Line after third arc
			
			// Right Wing
			g2T.drawLine(535, 50, 360, 50); // Top of wing
			
			g2T.drawLine(535, 50, 535, 70); // First vertical line
			g2T.drawArc(495, 50, 40, 40, 0, -90); // First arc
			g2T.drawLine(515, 90, 480, 90);// Horizontal Line after first arc
			
			g2T.drawLine(480, 90, 480, 110); // Second vertical line
			g2T.drawArc(440, 90, 40, 40, 0, -90); // Second arc
			g2T.drawLine(460, 130, 425, 130);// Horizontal Line after second arc
			
			g2T.drawLine(425, 130, 425, 150); // Third vertical line
			g2T.drawArc(385, 130, 40, 40, 0, -90); // Third arc
			g2T.drawLine(405, 170, 360, 170);// Horizontal Line after third arc
			
			// Nose
			g2T.drawLine(275, 100, 285, 160);
			g2T.drawLine(295, 100, 285, 160);
		}
		
		/**
		 * Method use to create the fixed parts of the middle canvas
		 * @param g2M Graphics2D object
		 */
		private void midCanvas(Graphics2D g2M) {
			
			// Body
			g2M.drawRect(210, 00, 150, 177);
			
			// Nose & Mouth
			g2M.drawLine(275, 100, 285, 120);
			g2M.drawLine(295, 100, 285, 120);
			g2M.drawLine(275, 100, 295, 100);
			g2M.drawArc(285, 105, 30, 30, 180, 180);
			g2M.drawArc(255, 105, 30, 30, 180, 180);
		}
		
		/**
		 * Method used to create the fixed parts of the bottom canvas
		 * @param g2B Graphics2D object
		 */
		private void botCanvas(Graphics2D g2B) {
			
			// Body
			g2B.drawRect(210, 00, 150, 177);
			
			// Nose
			g2B.fillOval(270, 85, 6, 6);
			g2B.fillOval(295, 85, 6, 6);
			
			// Mouth
			g2B.drawArc(235, 110, 100, 30, 0, 180);
			g2B.drawArc(235, 110, 100, 30, 180, 180);
			
			// Left Tooth
			
			int[][] lTPoints = { {250, 114}, {270, 110}, {260, 160}, {250, 114} };
			GeneralPath leftTooth = new GeneralPath();
			leftTooth.moveTo( lTPoints[0][0], lTPoints[0][1]);
			for (int k = 1; k < lTPoints.length; k++) {
				leftTooth.lineTo(lTPoints[k][0], lTPoints[k][1]);
			}
			leftTooth.closePath();
			g2B.setColor(Color.WHITE);
			g2B.fill(leftTooth);
			
			g2B.setColor(Color.BLACK);
			g2B.drawLine(250, 114, 260, 160);
			g2B.drawLine(270, 110, 260, 160);
			g2B.drawLine(250, 114, 270, 110);
			
			// Right Tooth
			
			int[][] rTPoints = { {300, 110}, {320, 114}, {310, 160}, {300, 110}};
			GeneralPath rightTooth = new GeneralPath();
			rightTooth.moveTo(rTPoints[0][0], rTPoints[0][1]);
			for (int k = 1; k < rTPoints.length; k++) {
				rightTooth.lineTo(rTPoints[k][0], rTPoints[k][1]);
			}
			rightTooth.closePath();
			g2B.setColor(Color.WHITE);
			g2B.fill(rightTooth);
			
			g2B.setColor(Color.BLACK);
			g2B.drawLine(320, 114, 310, 160);
			g2B.drawLine(300, 110, 310, 160);
			g2B.drawLine(300, 110, 320, 114);
		}
		
		/**
		 * Method for setting the boolean drawHappyEyes to true and calling a repaint
		 */
		private void happyEyes() {
			this.drawHappyEyes = true;
			repaint();
		}
		
		/**
		 * Method for setting the boolean drawNormalEyes to true and calling a repaint
		 */
		private void normalEyes() {
			this.drawNormalEyes = true;
			repaint();
		}
		
		/**
		 * Method for setting the boolean drawAngryEyes to true and calling a repaint
		 */
		private void angryEyes() {
			this.drawAngryEyes = true;
			repaint();
		}
		
		/**
		 * Method for setting all drawEyes booleans to false in order to reset before repainting the selected eyes
		 */
		private void allEyesFalse() {
			this.drawAngryEyes = false;
			this.drawHappyEyes = false;
			this.drawNormalEyes = false;
		}
	}
	
	/**
	 * Used to get the real time mouse coordinates and the add them to the selected labels.
	 * @author Dax Allen
	 *
	 */
	private class MyMouseAdapter extends MouseAdapter {
		
		/**
		 * Method for getting mouse location and then adding the location numbers to selected labels
		 */
		@Override
		public void mouseMoved(MouseEvent e) {
			int mX = e.getX();
			int mY = e.getY();
			
			lblXCoord.setText(String.valueOf(mX));
			lblYCoord.setText(String.valueOf(mY));
		}
	}
}
