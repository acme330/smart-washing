import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class InterfaceControleurCapteurs {
	

	
	public static void main(String[] args) {
		InterfaceControleurCapteurs test = new InterfaceControleurCapteurs();
		test.ChangerNiveauEau(15);
	}
	
	/**
	 * 
	 * @param temperature 
	 */
	public void ChangerTemperature(int temperature) {
		
	}
	
	/**
	 * Permet de changer le niveau d'eau à l'aide d'une valeur entre 0 et 15.
	 * @param niveauEau
	 */
	public void ChangerNiveauEau(int niveauEau) {
		String niveauBinaire = Integer.toBinaryString(niveauEau);
		String niveauBinaireParsed = niveauBinaire;
		//Ajoute les 0 devant la chaine de binaire si la chaine n'a pas une longueur de 4 bits
		if(niveauBinaire.length() < 4) {
			for(int i = 0; i < 4 - niveauBinaire.length(); i++) {
				niveauBinaireParsed = "0" + niveauBinaireParsed;
			}
		}
		//Renverse le sens des bits pour ajouter plus facilement dans le commutateur.
		String reverseBinary = new StringBuilder(niveauBinaireParsed).reverse().toString();
		//Écris la valeur dans le bon commutateur aux bonnes adresses.
		for(int i = 0; i < 4; i++) {
			this.write("0x0200", i, Character.toString(reverseBinary.charAt(i)));
		}
		
	}
	
	/**
	 * 
	 * @param vitesse
	 */
	public void ChangerVitesseRotation(int vitesse) {
		
	}
	
	/**
	 * 
	 * @param cadence
	 */
	public void ChangerCadence(int cadence) {
		
	}
	
	/**
	 * 
	 * @param dureeMinutes
	 */
	public void ChangerDureeLavage(int dureeMinutes) {
		
	}
	
	/**
	 * 
	 */
	public void AjouterSavon() {
		
	}
	
	/**
	 * 
	 */
	public void AjouterAssouplisseur() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public int ObtenirTemperature() {
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int ObtenirCadence() {
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int ObtenirVitesse() {
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int ObtenirNiveauEau() {
		return 0;
	}
	
	public void EvacuerEauUsee() {
		
	}

	public boolean Arreter()
	{
		
		// Logique pour arreter la machine a laver.
		
		return true;
	}
	
	public boolean Demarrer(Cycle cycleActuel)
	{
		
		// Logique pour demarrer la machine a laver
		
		return true;
	}
	
	/**
	 * Va lire le bit à l'adresse demandé sur le commutateur demandé
	 * @param commutateur
	 * @param adresse
	 * @return
	 */
	public String read(String commutateur, int adresse) { 
		String valeur = null;
		try {
			FileReader fr = new FileReader(commutateur + ".txt");
			for(int i = 0; i < adresse; i++)
				fr.read();
			valeur = String.valueOf(Character.toChars(fr.read()));
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valeur;
	}
	
	/**
	 * Va écrire le bit à l'adresse demandé sur le commutateur demandé
	 * @param commutateur
	 * @param adresse
	 * @param valeur
	 */
	public void write(String commutateur, int adresse, String valeur) {
		try {
			FileReader fr = new FileReader(commutateur + ".txt");
			char[] content = new char[8];
			fr.read(content);
			fr.close();
			
			content[adresse] = valeur.charAt(0);
			FileWriter fw = new FileWriter(commutateur + ".txt");
			fw.write(content);
			fw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
