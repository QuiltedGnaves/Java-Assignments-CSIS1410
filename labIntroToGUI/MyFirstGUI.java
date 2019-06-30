package labIntroToGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFirstGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JLabel lblHi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFirstGUI frame = new MyFirstGUI();
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
	public MyFirstGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("West");
		contentPane.add(btnNewButton, BorderLayout.WEST);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.BLUE);
		contentPane.add(topPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("My First GUI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		topPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblName);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHi.setText(lblHi.getText() + " " + textField.getText());
				textField.setText("");
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField);
		textField.setColumns(16);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.RED);
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblHi = new JLabel("Hi");
		lblHi.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblHi.setForeground(Color.ORANGE);
		lblHi.setFont(new Font("Ink Free", Font.BOLD, 77));
		lblHi.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblHi);
	}

}
