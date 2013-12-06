import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI extends JFrame{

	private JPanel contentPane;
	private GestionnaireOperations gest;
	private JLabel timeLabel;
	private JLabel tempLabel;
	private JProgressBar waterLevel;
	private boolean demarre = false;
	private JButton startButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//initialize gui and Gestionnaire
					GestionnaireOperations gest = new GestionnaireOperations();
					GUI frame = new GUI(gest);
					gest.setGUI(frame);
					frame.setVisible(true);
					
					frame.update();
					//start file listener
					final Timer timer = new Timer(16, null);
					timer.addActionListener(new FileListener(frame));
					timer.start();
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Update View when file has changed
	 * 
	 */
	public void update() 
	{
		//time
		this.timeLabel.setText(Integer.toString(gest.getTempsRestantAuLavage()));
		
		//temp
		gest.MettreAJourTemperature();
		int temp = gest.getTemperatureCourante();
		if(temp == 1)
			temp = 90;
		else if(temp == 2)
			temp = 25;
		else if(temp == 3)
			temp = 50;
		this.tempLabel.setText(Integer.toString(temp));
		
		waterLevel.setValue(gest.getNiveauEauSelectionne());
	}
	
	/**
	 * Create the frame.
	 */
	public GUI(GestionnaireOperations gest) {
		this.gest = gest;
		this.setTitle("SmartWashing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 592, 400);
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
		
		JButton cottonButton = new CreateRoundButton("Coton");
		cottonButton.addActionListener(new CycleCotonListener(gest));
		cottonButton.setBounds(10, 141, 89, 23);
		cottonButton.setBackground(new Color(45,47,56));
		cottonButton.setForeground(Color.WHITE);
		panel.add(cottonButton);
		
		JButton syntheticButton = new CreateRoundButton("Synthetic");
		syntheticButton.addActionListener(new CycleSyntheticListener(gest));
		syntheticButton.setBounds(10, 175, 89, 23);
		syntheticButton.setBackground(new Color(45,47,56));
		syntheticButton.setForeground(Color.WHITE);
		panel.add(syntheticButton);
		
		JButton roughButton = new CreateRoundButton("Rough");
		roughButton.addActionListener(new CycleRugeuListener(gest));
		roughButton.setBounds(10, 209, 89, 23);
		roughButton.setBackground(new Color(45,47,56));
		roughButton.setForeground(Color.WHITE);
		panel.add(roughButton);
		
		JButton DesinfectionButton = new CreateRoundButton("Sanitize");
		DesinfectionButton.addActionListener(new CycleDesinfectionListener(gest));
		DesinfectionButton.setBounds(109, 141, 89, 23);
		DesinfectionButton.setBackground(new Color(45,47,56));
		DesinfectionButton.setForeground(Color.WHITE);
		panel.add(DesinfectionButton);
		
		JButton btnSpinDrying = new CreateRoundButton("Trempage");
		btnSpinDrying.addActionListener(new CycleSpinDryingListener(gest));
		btnSpinDrying.setBounds(223, 141, 110, 23);
		btnSpinDrying.setBackground(new Color(45,47,56));
		btnSpinDrying.setForeground(Color.WHITE);
		btnSpinDrying.setSize(120, 90);
		panel.add(btnSpinDrying);
		
		
		startButton = new JButton("Start");
		startButton.addActionListener(new StartListener(gest));
		startButton.setBounds(493, 38, 89, 23);
		panel.add(startButton);
		
		JLabel lblNewLabel = new JLabel("Water Level");
		lblNewLabel.setBounds(94, 23, 70, 14);
		lblNewLabel.setForeground(Color.white);
		panel.add(lblNewLabel);
		
		tempLabel = new JLabel("New label");
		tempLabel.setBounds(376, 47, 17, 14);
		tempLabel.setForeground(Color.white);
		panel.add(tempLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Washing cycle");
		lblNewLabel_2.setBounds(110, 110, 200, 20);
		lblNewLabel_2.setForeground(Color.white);
		Font font = new Font("Verdana", Font.BOLD,16);
		lblNewLabel_2.setFont(font);
		panel.add(lblNewLabel_2);
		
		timeLabel = new JLabel("New label");
		timeLabel.setBounds(243, 47, 46, 14);
		timeLabel.setForeground(Color.white);
		panel.add(timeLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Time Management");
		lblNewLabel_4.setBounds(206, 22, 130, 14);
		Font font1 = new Font("Verdana", Font.BOLD,12);
		lblNewLabel_4.setFont(font1);
		lblNewLabel_4.setForeground(Color.white);
		panel.add(lblNewLabel_4);
		
		waterLevel = new JProgressBar();
		waterLevel.setMinimum(0);
		waterLevel.setMaximum(15);
		waterLevel.setBounds(21, 47, 40, 14);
		waterLevel.setValue(5);
		panel.add(waterLevel);
		
		
		getContentPane().setBackground(new Color(54, 60, 87));
		panel.setBackground(new Color(54, 60, 87));
		
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setForeground(Color.WHITE);
		lblTemperature.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTemperature.setBounds(351, 23, 130, 14);
		panel.add(lblTemperature);
		
		JLabel lblNewLabel_1 = new JLabel("\u00B0C");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(395, 47, 24, 14);
		panel.add(lblNewLabel_1);

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
			if(gest.getNiveauEauSelectionne() < 15)
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
			if(gest.getNiveauEauSelectionne() > 0)
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
			
			if(demarre)
			{
				gest.Arreter();
				demarre = false;
				startButton.setText("Start");
			}
			else
			{
				gest.Demarre();
				demarre = true;
				startButton.setText("Stop");
			}
			
			
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
