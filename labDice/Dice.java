/**
 * Dax Allen
 * CSIS 1410
 * Section 402
 */
package labDice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

/**
 * App that "rolls" a single die
 * 
 * @author Dax Allen
 *
 */
public class Dice extends JFrame {

	private JPanel contentPane;
	JLabel lblDieImage;
	Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dice frame = new Dice();
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
	public Dice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setDie();
			}
		});
		panel.setBounds(0, 0, 460, 331);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		lblDieImage = new JLabel(new ImageIcon(this.getClass().getResource("die-1.png")));
		lblDieImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setDie();
			}
		});
		lblDieImage.setBounds(129, 54, 203, 203);
		panel.add(lblDieImage);
		
		JLabel lblClickToRoll = new JLabel("Click To Roll");
		lblClickToRoll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setDie();
			}
		});
		lblClickToRoll.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 24));
		lblClickToRoll.setBounds(167, 275, 131, 45);
		panel.add(lblClickToRoll);
	}
	
	/**
	 * Used to randomly choose and return an ImageIcon of one of the sides of the die
	 * 
	 * @return An ImageIcon of one side of a die
	 */
	public ImageIcon selDieImage() {
		
		int roll = (int) (Math.random() * 6) + 1;;
		ImageIcon returnDie = new ImageIcon();
		ImageIcon dieSides[] = { 
			new ImageIcon(this.getClass().getResource("die-1.png")),
			new ImageIcon(this.getClass().getResource("die-2.png")),
			new ImageIcon(this.getClass().getResource("die-3.png")),
			new ImageIcon(this.getClass().getResource("die-4.png")),
			new ImageIcon(this.getClass().getResource("die-5.png")),
			new ImageIcon(this.getClass().getResource("die-6.png"))
		};
		
		rollingAnimation(dieSides);
		
		switch (roll) {
		
		case 1:
			returnDie = dieSides[0];
			break;
		case 2:
			returnDie = dieSides[1];
			break;
		case 3:
			returnDie = dieSides[2];
			break;
		case 4:
			returnDie = dieSides[3];
			break;
		case 5:
			returnDie = dieSides[4];
			break;
		case 6:
			returnDie = dieSides[5];
			break;
		}
		
		return returnDie;
			
	}
	
	/**
	 * Sets the label to the randomly selected die image.
	 * Used to simplify the code in the ActionListeners
	 */
	public void setDie() {
		
		ImageIcon die = selDieImage();
		lblDieImage.setIcon(die);
	}
	
	/**
	 * Runs "rolling" animation for the die
	 * 
	 * @param dieSides Array of ImageIcons of the sides of a die
	 */
	public void rollingAnimation(ImageIcon[] dieSides) {
		
		timer = new Timer(150, new ActionListener() {
			int tick = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon rollingDie = dieSides[(int) (Math.random() * 6)];
				lblDieImage.setIcon(rollingDie);
				tick++;
				if (tick >= 15) {
					timer.stop();
				}
				
			}
			
			
		});
		timer.start();
		
	}
}
