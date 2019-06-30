package labCoin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoinAppGui extends JFrame {

	private JPanel contentPane;
	JLabel lblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoinAppGui frame = new CoinAppGui();
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
	public CoinAppGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setPreferredSize(new Dimension(500, 500));
		setContentPane(contentPane);
		
		JPanel panelControl = controlPanel();
		contentPane.add(panelControl, BorderLayout.NORTH);
		
		JPanel panelData = dataPanel();
		contentPane.add(panelData, BorderLayout.CENTER);
	}

	private JPanel dataPanel() {
		JPanel panelData = new JPanel();
		panelData.setLayout(new BorderLayout(0, 0));
		
		lblData = new JLabel("Choose a coin");
		lblData.setFont(new Font("Alef", Font.PLAIN, 35));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		panelData.add(lblData);
		
		return panelData;
	}

	private JPanel controlPanel() {
		JPanel panelControl = new JPanel();
		
		JButton btnCent = new JButton("");
		btnCent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblData.setText(Coin.CENT.toString());
			}
		});
		btnCent.setOpaque(false);
		btnCent.setIcon(new ImageIcon(CoinAppGui.class.getResource("/labCoin/UsCent.png")));
		panelControl.add(btnCent);
		
		JButton btnNickel = new JButton("");
		btnNickel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblData.setText(Coin.NICKEL.toString());
			}
		});
		btnNickel.setIcon(new ImageIcon(CoinAppGui.class.getResource("/labCoin/UsNickel.png")));
		panelControl.add(btnNickel);
		
		JButton btnDime = new JButton("");
		btnDime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblData.setText(Coin.DIME.toString());
			}
		});
		btnDime.setIcon(new ImageIcon(CoinAppGui.class.getResource("/labCoin/UsDime.png")));
		panelControl.add(btnDime);
		
		JButton btnQuarter = new JButton("");
		btnQuarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblData.setText(Coin.QUARTER.toString());
			}
		});
		btnQuarter.setIcon(new ImageIcon(CoinAppGui.class.getResource("/labCoin/UsQuarter.png")));
		panelControl.add(btnQuarter);
		
		return panelControl;
	}

}
