import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;


public class FileListener implements ActionListener
{
	String commutateur1 = "";
	String commutateur2 = "";
	String commutateur7 = "";
	GUI gui;
	public FileListener(GUI gui)
	{
		this.gui = gui;
		commutateur1 = read("0x0100");
		commutateur2 = read("0x0200");
		commutateur7 = read("0x0700");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(!(commutateur1.equals(read("0x0100")) && commutateur2.equals(read("0x0200")) && commutateur7.equals(read("0x0700"))))
		{
			gui.update();
			System.out.println("Something has changed");
		}
		commutateur1 = read("0x0100");
		commutateur2 = read("0x0200");
		commutateur7 = read("0x0700");
	}
	
	private String read(String comm)
	{
		String valeur = null;
		try {
			FileReader fr = new FileReader(comm + ".txt");
			char[] chars = new char[8];
			for(int i = 0; i < 8; i++)
				chars[i] = (char) fr.read();
			valeur = new String(chars);
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valeur;
	}

}
