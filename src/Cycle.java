
public class Cycle 
{
	private double Temperature;
	private int Niveau;
	private double VitesseRotation;
	private double Cadence;
	private int Duree;
	
	/**
	 * Default constructor
	 */
	public Cycle()
	{
		
	}
	
	/**
	 * 
	 * @param Temperature
	 * @param NiveauEau
	 * @param VitesseRotation
	 * @param Cadence
	 * @param Duree
	 */
	public void AppliquerParametresDeLavage(double Temperature, int NiveauEau, double VitesseRotation, double Cadence, int Duree)
	{
		this.Temperature = Temperature;
		this.Niveau = NiveauEau;
		this.Cadence = Cadence;
		this.VitesseRotation = VitesseRotation;
		this.Duree = Duree;
	}
	
	
	
}
