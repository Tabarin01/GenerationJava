package entities;

public class Persona {

	// Le proprieta' o i metodi che sono veri per la categoria e non per il caso specifico,
	// vengono definiti DI CLASSE
	// Sia le prorieta' che i metodi di classi in Java vengono riconosciuti grazie alla parola chiave STATIC
	
	// esempio:
	// public int etaMin = 0 ------> scritto cosi' appartiene solo all'oggetto, quindi prima del tipo si mette static
	public static int etaMin = 0;
	public static int etaMax = 120;
	// Spesso l'uso di proprieta' o metodi static si limita a fare controlli per prevenire la creazione di oggetti errati
	
	public static boolean valida(int eta) 
	{
		if(etaMin < eta && eta < etaMax) 
		{
			return true;
		}
		System.err.println("Eta' non valida");
		return false;
	}
	
	public static String[] provincie = {"MI","LO","MB","CO","VA","LC","BG","BS","SO"};
	
	public static boolean valida(String provincia) 
	{
		for(String s : provincie) 
			if(s.equalsIgnoreCase(provincia)) 
			{
				return true;
			}
			System.err.println("Provincia non valida");
			return false;
	}
	
	public static boolean valida(int eta, String provincia) 
	{
		return valida(eta) && valida(provincia);
	}
	
	
	// CONCETTO DI FINAL
	// Spesso static viene scritto insieme alla parola chiave FINAL
	// STATIC e FINAL esistono in modo indipendente l'uno dall'altro.
	
	// FINAL indica una proprieta' il cui valore non potra' mai essere sovrascritto 
	// se non nel codice originale, ovvero nella riga in cui e' dato il valore.
	
	public final String COMUNE_CAPOLUOGO = "ROMA";
	
	
	//Spesso sta associato a STATIC per rendere la proprieta' di classe e poterla usare anche senza oggetti
	//Per convenzione i final sono scritti di solito in CAPS e gli static hanno in automatico il corsivo.
	public static final String CAPOLUOGO = "Milano";
	
	
	
	
	
	
	
	// STATO DELL'OGGETTO
	// E' l'insieme dei valori delle proprieta' di un oggetto in un dato momento

	// Proprieta' dell'oggetto: perche' il loro valore ha senso solo in realzione con la creazione
	//							di un nuovo oggetto

	
	
	private String nome,cognome,provincia,comune;
	private int eta;


	public Persona(String nome, String cognome, String provincia, String comune, int eta) {
		super();
		setNome(nome);
		setCognome(cognome);
		setProvincia(provincia);
		setComune(comune);
		setEta(eta);
	}


	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) 
	{
		this.provincia = provincia;
	}
	public String getComune() 
	{
		return comune;
	}
	public void setComune(String comune)
	{
		this.comune = comune;
	}
	public int getEta() 
	{
		return eta;
	}
	public void setEta(int eta) 
	{
		this.eta = eta;
	}


	@Override
	public String toString() {
		return "Nominativo: " + nome + " " + cognome + 
				"\nProvincia: " + provincia + 
				"\nComune: " + comune +
				"\nEtà: " + eta;
	}




}
