package labCoin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setPreferredSize(new Dimension(500, 300));
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
		
		JButton btnCent = btnCoin("Cent", Coin.CENT);
		panelControl.add(btnCent);
		
		JButton btnNickel = btnCoin("Nickel", Coin.NICKEL);
		panelControl.add(btnNickel);
		
		JButton btnDime = btnCoin("Dime", Coin.DIME);
		panelControl.add(btnDime);
		
		JButton btnQuarter = btnCoin("Quarter", Coin.QUARTER);
		panelControl.add(btnQuarter);
		
		return panelControl;
	}

	private JButton btnCoin(String denom, Coin coin) {
		JButton btnCent = new JButton("");
		btnCent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblData.setText(coin.toString());
			}
		});
		btnCent.getModel().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (btnCent.getModel().isRollover()) {
					btnCent.setBorderPainted(true);
				} else {
					btnCent.setBorderPainted(false);
				}	
			}	
		});
		btnCent.setOpaque(false);
		btnCent.setBorderPainted(false);
		btnCent.setFocusPainted(false);
		btnCent.setContentAreaFilled(false);
		btnCent.setIcon(new ImageIcon(CoinAppGui.class.getResource("/labCoin/Us" + denom + ".png")));
		return btnCent;
	}

}
