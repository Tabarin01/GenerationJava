package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		//Leggere il contenuto di File.txt e poi:
		// -Scheda ordinata dei singoli alcolici;
		// -Il nome dell'alcolico con gradazione minore;
		Scanner file;
		String tipoAlcolico, nomeAlcolico, risposta, nomeAlcolicoMinore, nomeAlcolicoMaggiore;
		double gradazione,minoreGradazione, maggioreGradazione;
		String percorsoAssoluto;
		String percorsoRelativo;

		nomeAlcolicoMaggiore = "";
		nomeAlcolicoMinore = "";
		percorsoAssoluto = "C:\\Users\\catti\\Desktop\\Generation Modulo Tecnico\\workspace\\JAITA112\\18-Lettura_Da_File\\src\\res\\File.txt";
		percorsoRelativo = "src/res/File.txt";
		risposta = "";
		minoreGradazione = Integer.MAX_VALUE; // oppure 100
		maggioreGradazione = Integer.MIN_VALUE;

		file = new Scanner(new File(percorsoRelativo));

		while(file.hasNextLine()) {

			tipoAlcolico = file.nextLine();
			nomeAlcolico = file.nextLine();
			gradazione = Double.parseDouble(file.nextLine());

			risposta +=
					"\nTipo di alcolico: "+tipoAlcolico + "\n"+
							"\nNome Alcolico: "+ nomeAlcolico +"\n"+
							"\nGradazione alcolica: "+ gradazione +"%"+
							"\n-----------------------------\n";

			if(gradazione < minoreGradazione) {
				minoreGradazione = gradazione;
				nomeAlcolicoMinore = nomeAlcolico;
			}else if(gradazione > maggioreGradazione) {
				maggioreGradazione = gradazione;
				nomeAlcolicoMaggiore = nomeAlcolico;
			}

		}

		file.close();

		System.out.println(
				"\tELENCO ALCOLICI: "+risposta +
				"\nL'alcolico con gradazione minore: "+nomeAlcolicoMinore+
				" con " + minoreGradazione+ "%"+
				"\nL'alcolico con gradazione maggiore: "+ nomeAlcolicoMaggiore +
				" con " + maggioreGradazione +"%");
	}
}
