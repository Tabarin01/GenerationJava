package entities;

public class Insegnante extends Persona{

//	Creare la classe Insegnante, figlia di Persona, che avrà le proprietà:
//		String materiaInsegnata;
//		double stipendioBase;
//	e i metodi:
//		String toString();
//		double stipendio() -> Calcolato partendo da stipendioBase, a cui aggiungo:
//					- 300 se l'età è tra i 30 e i 40 anni
//					- 500 se l'età è tra i 40 compresi e i 50
//					- 800 se l'età è tra i 50 compresi e i 60
//					- 1000 se l'età è 60 o più, a cui aggiungo 50 per ogni 
//						anno che manca alla pensione
//	
//		int anniPensione() -> Ritorna quanti anni mancano alla pensione(Fissata a 70 anni)
	
	private String materia;
	double stipendioBase;
	
	public Insegnante(String nome, String dob, String materia, double stipendioBase) {
		super(nome, dob);
		
		setMateria(materia);
		setStipendioBase(stipendioBase);
		
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public double getStipendioBase() {
		return stipendioBase;
	}

	public void setStipendioBase(double stipendioBase) {
		this.stipendioBase = stipendioBase;
	}

	@Override
	public String toString() 
	{
		return 	super.toString().replace("\n\tPERSONA\n","\n\tDOCENTE\n")     +
			   "\nMateria: " + materia + 
			   "\nStipendio: " + stipendioBase + "$" +
			   "\n--------------------------------------------------\n";
	}
	
//	double stipendio() -> Calcolato partendo da stipendioBase, a cui aggiungo:
//		- 300 se l'età è tra i 30 e i 40 anni
//		- 500 se l'età è tra i 40 compresi e i 50
//		- 800 se l'età è tra i 50 compresi e i 60
//		- 1000 se l'età è 60 o più, a cui aggiungo 50 per ogni 
//			anno che manca alla pensione
	
	public double stipendio() 
	{
		if(eta() < 40 && eta() >= 30) 
		{
			stipendioBase += 300;
		}
		else if(eta() >= 40 && eta() < 50) 
		{
			stipendioBase += 500;
		}
		else if(eta() >= 50 && eta() < 60) 
		{
			stipendioBase += 800;
		}
		else if(eta() >60) 
		{
			stipendioBase += 1000 + (50 * anniPensione());
		}
		return stipendioBase;	
	}
	
//	int anniPensione() -> Ritorna quanti anni mancano alla pensione(Fissata a 70 anni)
	
	public int anniPensione() 
	{
		return 70 - eta();
	}
	

}
