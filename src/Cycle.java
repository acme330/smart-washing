
public class Cycle 
{
	private double TemperatureMin;
	private double TemperatureMax;
	private int Niveau;
	private double VitesseRotation;
	private double Cadence;
	private int DureeLavage;
	private int DureeEssorage;
	public TypeCycle Type;
	
	/**
	 * Default constructor
	 */
	public Cycle()
	{
		
	}
	
	/**
	 * Constructor with parameters
	 */
	public Cycle(TypeCycle typeOfCycle, double temperatureMin, double temperatureMax, int niveauEau, double vitesseRotation, double cadence, int dureeLavage, int dureeEssorage)
	{
		this.Type = typeOfCycle;
		
		AppliquerParametresDeLavage(temperatureMin, temperatureMax, niveauEau, vitesseRotation, cadence, dureeLavage,dureeEssorage);
	}
	
	/**
	 * 
	 * @param Temperature
	 * @param NiveauEau
	 * @param VitesseRotation
	 * @param Cadence
	 * @param Duree
	 */
	public void AppliquerParametresDeLavage(double TemperatureMin,double TemperatureMax, int NiveauEau, double VitesseRotation, double Cadence, int DureeLavage, int DureeEssorage)
	{
		this.TemperatureMin = TemperatureMin;
		this.TemperatureMax = TemperatureMax;
		this.Niveau = NiveauEau;
		this.Cadence = Cadence;
		this.VitesseRotation = VitesseRotation;
		this.DureeLavage = DureeLavage;
		this.DureeEssorage = DureeEssorage;
	}
	
	
	
}
