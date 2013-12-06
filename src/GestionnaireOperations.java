import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;


public class GestionnaireOperations
{
	private ArrayList<Cycle> ListeCyclesDisponibles;
	private int TempsRestantAuLavage;
	private int TemperatureCourante;
	private Cycle CycleSelectionne;
	private InterfaceControleurCapteurs InstanceControleur;
	private int NiveauEauSelectionne;
	private GUI gui;
	
	public GestionnaireOperations()
	{
		InstanceControleur = new InterfaceControleurCapteurs();
		
		// Creation des plusieurs cycles
		
		Cycle coton = new Cycle(TypeCycle.Cotton, 40, 50, getNiveauEauSelectionne(), 20,10,45,10);
		Cycle synthetique = new Cycle(TypeCycle.Synthetique, 50, 60, getNiveauEauSelectionne(), 10,15,30,5);
		Cycle rugueux = new Cycle(TypeCycle.Rugueux, 30, 40, getNiveauEauSelectionne(), 20,8,45,10);
		Cycle desinfection = new Cycle(TypeCycle.Desinfection, 40, 50, getNiveauEauSelectionne(), 20,10,45,10);
		Cycle trempage = new Cycle(TypeCycle.Trempage, 20, 30, getNiveauEauSelectionne(), 20,10,45,10);
		
		ListeCyclesDisponibles = new ArrayList<Cycle>();
		
		ListeCyclesDisponibles.add(coton);
		ListeCyclesDisponibles.add(synthetique);
		ListeCyclesDisponibles.add(rugueux);
		ListeCyclesDisponibles.add(desinfection);
		ListeCyclesDisponibles.add(trempage);	
	}
	
	public void ChoisirCycle(TypeCycle cycleSelectionne)
	{
	
		for (Cycle cycleCourant : ListeCyclesDisponibles)
		{
			if(cycleCourant.Type == cycleSelectionne)
			{
				this.setCycleSelectionne(cycleCourant);
			}
		}
	}
	
	public void Demarre()
	{
		if(this.getCycleSelectionne() != null)
		{
			InstanceControleur.Demarrer(this.getCycleSelectionne());
			
			//Timer timer = new Timer();
	        //timer.schedule(new TimerTask() {

	        //    @Override
	        //    public void run() {
	        //        test.doStuff();
	        //    }
	        //}, 0, test.myLong);
		}		
	}
	
	public void Arreter()
	{
		InstanceControleur.Arreter();
	}
	
	public void ChangerTempsRestant(int minutes)
	{
		this.setTempsRestantAuLavage(minutes);
	}
	
	public void AjusterNiveauEau(int niveau)
	{
		InstanceControleur.ChangerNiveauEau(niveau);
		setNiveauEauSelectionne(niveau);
	}
	
	public void MettreAJourTemperature()
	{
		this.setTemperatureCourante(InstanceControleur.ObtenirTemperature());
	}
	
	public ArrayList<Cycle> ObtenirCycles()
	{
		return ListeCyclesDisponibles;
	}

	
	public void setGUI(GUI gui)
	{
		this.gui = gui;
	}
	//ACCESSEURS
	public int getNiveauEauSelectionne() {
		NiveauEauSelectionne = InstanceControleur.ObtenirNiveauEau();
		return NiveauEauSelectionne;
	}

	public void setNiveauEauSelectionne(int niveauEauSelectionne) {
		NiveauEauSelectionne = niveauEauSelectionne;
	}

	public Cycle getCycleSelectionne() {
		return CycleSelectionne;
	}

	public void setCycleSelectionne(Cycle cycleSelectionne) {
		CycleSelectionne = cycleSelectionne;
	}

	public int getTemperatureCourante() {
		return TemperatureCourante;
	}

	public void setTemperatureCourante(int temperatureCourante) {
		TemperatureCourante = temperatureCourante;
	}

	public int getTempsRestantAuLavage() {
		return TempsRestantAuLavage;
	}

	public void setTempsRestantAuLavage(int tempsRestantAuLavage) {
		TempsRestantAuLavage = tempsRestantAuLavage;
	}
	
	

	
}
