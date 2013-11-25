import java.util.ArrayList;


public class GestionnaireOperations 
{
	private ArrayList<Cycle> ListeCyclesDisponibles;
	private int TempsRestantAuLavage;
	private int TemperatureCourante;
	private Cycle CycleSelectionne;
	private InterfaceControleurCapteurs InstanceControleur;
	private int NiveauEauSelectionne;
	
	public GestionnaireOperations()
	{
		InstanceControleur = new InterfaceControleurCapteurs();
		
		// Creation des plusieurs cycles
		
		Cycle coton = new Cycle(TypeCycle.Cotton, 40, 50, NiveauEauSelectionne, 20,10,45,10);
		Cycle synthetique = new Cycle(TypeCycle.Synthetique, 50, 60, NiveauEauSelectionne, 10,15,30,5);
		Cycle rugueux = new Cycle(TypeCycle.Rugueux, 30, 40, NiveauEauSelectionne, 20,8,45,10);
		Cycle desinfection = new Cycle(TypeCycle.Desinfection, 40, 50, NiveauEauSelectionne, 20,10,45,10);
		Cycle trempage = new Cycle(TypeCycle.Trempage, 20, 30, NiveauEauSelectionne, 20,10,45,10);
		
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
				this.CycleSelectionne = cycleCourant;
			}
		}
	}
	
	public void Demarre()
	{
		InstanceControleur.Demarrer();
	}
	
	public void Arreter()
	{
		InstanceControleur.Arreter();
	}
	
	public void ChangerTempsRestant(int minutes)
	{
	}
	
	public void AjusterNiveauEau(int niveau)
	{
		
	}
	
	public void MettreAJourTemperature()
	{
		this.TemperatureCourante = InstanceControleur.ObtenirTemperature();
	}
	
	public ArrayList<Cycle> ObtenirCycles()
	{
		return ListeCyclesDisponibles;
	}
	
	
}
