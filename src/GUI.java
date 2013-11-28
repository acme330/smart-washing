import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI extends JFrame{

	private JPanel contentPane;
	private GestionnaireOperations gest;
	private JLabel timeLabel;
	private JLabel tempLabel;
	private JProgressBar waterLevel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionnaireOperations gest = new GestionnaireOperations();
					GUI frame = new GUI(gest);
					gest.attachedGUI(frame);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public void update() 
	{
		this.timeLabel.setText(Integer.toString(gest.getTempsRestantAuLavage()));
		this.tempLabel.setText(Integer.toString(gest.getTemperatureCourante()));
		waterLevel.setValue(gest.getNiveauEauSelectionne());
	}
	
	/**
	 * Create the frame.
	 */
	public GUI(GestionnaireOperations gest) {
		this.gest = gest;
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
		addWaterButton.addActionListener(new AddWaterListener(gest));
		addWaterButton.setBounds(84, 38, 89, 23);
		panel.add(addWaterButton);
		
		JButton removeWaterButton = new JButton("-");
		removeWaterButton.addActionListener(new RemoveWaterListener(gest));
		removeWaterButton.setBounds(84, 60, 89, 23);
		panel.add(removeWaterButton);
		
		JButton cottonButton = new JButton("Coton");
		cottonButton.addActionListener(new CycleCotonListener(gest));
		cottonButton.setBounds(10, 141, 89, 23);
		panel.add(cottonButton);
		
		JButton syntheticButton = new JButton("Synthetic");
		syntheticButton.addActionListener(new CycleSyntheticListener(gest));
		syntheticButton.setBounds(10, 175, 89, 23);
		panel.add(syntheticButton);
		
		JButton roughButton = new JButton("rough");
		roughButton.addActionListener(new CycleRugeuListener(gest));
		roughButton.setBounds(10, 209, 89, 23);
		panel.add(roughButton);
		
		JButton DesinfectionButton = new JButton("Sanitize");
		DesinfectionButton.addActionListener(new CycleDesinfectionListener(gest));
		DesinfectionButton.setBounds(109, 141, 89, 23);
		panel.add(DesinfectionButton);
		
		JButton btnSpinDrying = new JButton("Trempage");
		btnSpinDrying.addActionListener(new CycleSpinDryingListener(gest));
		btnSpinDrying.setBounds(223, 141, 110, 23);
		panel.add(btnSpinDrying);
		
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new StartListener(gest));
		startButton.setBounds(493, 38, 89, 23);
		panel.add(startButton);
		
		JLabel lblNewLabel = new JLabel("Water Level");
		lblNewLabel.setBounds(94, 23, 64, 14);
		panel.add(lblNewLabel);
		
		tempLabel = new JLabel("New label");
		tempLabel.setBounds(366, 42, 46, 14);
		panel.add(tempLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Washing cycle");
		lblNewLabel_2.setBounds(119, 116, 100, 14);
		panel.add(lblNewLabel_2);
		
		timeLabel = new JLabel("New label");
		timeLabel.setBounds(264, 23, 46, 14);
		panel.add(timeLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Time Management");
		lblNewLabel_4.setBounds(246, 47, 110, 14);
		panel.add(lblNewLabel_4);
		
		waterLevel = new JProgressBar();
		waterLevel.setBounds(21, 47, 40, 14);
		panel.add(waterLevel);
		

		
	}
	
	
	//LISTENERS
	public class CycleCotonListener implements ActionListener
	{
		GestionnaireOperations gest;
		public CycleCotonListener(GestionnaireOperations gest)
		{
			this.gest = gest;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			gest.ChoisirCycle(TypeCycle.Cotton);
			
		}
		
	}
	
	public class CycleSyntheticListener implements ActionListener
	{
		GestionnaireOperations gest;
		public CycleSyntheticListener(GestionnaireOperations gest)
		{
			this.gest = gest;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			gest.ChoisirCycle(TypeCycle.Synthetique);			
		}
		
	}
	
	public class CycleRugeuListener implements ActionListener
	{
		GestionnaireOperations gest;
		public CycleRugeuListener(GestionnaireOperations gest)
		{
			this.gest = gest;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			gest.ChoisirCycle(TypeCycle.Rugueux);			
		}
		
	}
	
	public class CycleDesinfectionListener implements ActionListener
	{
		GestionnaireOperations gest;
		public CycleDesinfectionListener(GestionnaireOperations gest)
		{
			this.gest = gest;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			gest.ChoisirCycle(TypeCycle.Desinfection);			
		}
		
	}
	
	public class CycleSpinDryingListener implements ActionListener
	{
		GestionnaireOperations gest;
		public CycleSpinDryingListener(GestionnaireOperations gest)
		{
			this.gest = gest;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			gest.ChoisirCycle(TypeCycle.Trempage);			
		}
		
	}
	
	public class AddWaterListener implements ActionListener
	{
		GestionnaireOperations gest;
		public AddWaterListener(GestionnaireOperations gest)
		{
			this.gest = gest;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			gest.AjusterNiveauEau(gest.getNiveauEauSelectionne()+1);
			
		}
		
	}
	
	public class RemoveWaterListener implements ActionListener
	{
		GestionnaireOperations gest;
		public RemoveWaterListener(GestionnaireOperations gest)
		{
			this.gest = gest;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			gest.AjusterNiveauEau(gest.getNiveauEauSelectionne()-1);
		}
		
	}
	
	public class StartListener implements ActionListener
	{
		GestionnaireOperations gest;
		public StartListener(GestionnaireOperations gest)
		{
			this.gest = gest;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			gest.Demarre();
		}
		
	}


	public JLabel getTimeLabel() {
		return timeLabel;
	}
	public JLabel getTempLabel() {
		return tempLabel;
	}
	public JProgressBar getWaterLevel() {
		return waterLevel;
	}
}
