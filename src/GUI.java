import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JProgressBar;


public class GUI extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					GestionnaireOperations gest = new GestionnaireOperations(frame);
					
					
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 592, 235);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton addWaterButton = new JButton("+");
		addWaterButton.setBounds(84, 38, 89, 23);
		panel.add(addWaterButton);
		
		JButton removeWaterButton = new JButton("-");
		removeWaterButton.setBounds(84, 60, 89, 23);
		panel.add(removeWaterButton);
		
		JButton cottonButton = new JButton("Coton");
		cottonButton.setBounds(10, 141, 89, 23);
		panel.add(cottonButton);
		
		JButton syntheticButton = new JButton("Synthetic");
		syntheticButton.setBounds(10, 175, 89, 23);
		panel.add(syntheticButton);
		
		JButton roughButton = new JButton("rough");
		roughButton.setBounds(10, 209, 89, 23);
		panel.add(roughButton);
		
		JButton startButton = new JButton("Start");
		startButton.setBounds(493, 38, 89, 23);
		panel.add(startButton);
		
		JLabel lblNewLabel = new JLabel("Water Level");
		lblNewLabel.setBounds(94, 23, 64, 14);
		panel.add(lblNewLabel);
		
		JLabel tempLabel = new JLabel("New label");
		tempLabel.setBounds(366, 42, 46, 14);
		panel.add(tempLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Washing cycle");
		lblNewLabel_2.setBounds(119, 116, 100, 14);
		panel.add(lblNewLabel_2);
		
		JLabel timeLabel = new JLabel("New label");
		timeLabel.setBounds(264, 23, 46, 14);
		panel.add(timeLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Time Management");
		lblNewLabel_4.setBounds(246, 47, 110, 14);
		panel.add(lblNewLabel_4);
		
		JProgressBar waterLevel = new JProgressBar();
		waterLevel.setBounds(21, 47, 40, 14);
		panel.add(waterLevel);
		
		JButton btnSpinDrying = new JButton("Spin Drying");
		btnSpinDrying.setBounds(223, 141, 110, 23);
		panel.add(btnSpinDrying);
		
		JButton DesinfectionButton = new JButton("Sanitize");
		DesinfectionButton.setBounds(109, 141, 89, 23);
		panel.add(DesinfectionButton);
	}
}
