package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Creare una classe aggregatrice Scuola in cui vengono letti i dati da file in due AL. Scrivere poi i metodi:
//- String listaCompleta() -> lista completa insegnanti e studenti
//- String listaDocenti()  -> lista dei soli insegnanti
//- String listaStudenti() -> lista dei soli studenti
//- String listaPromossi() -> lista degli studenti promossi e il numero degli studenti bocciati
//- int nErasmus() -> numero degli studenti che possono andare in erasmus(ricordate i metodi già scritti!)
//- String pensionamento() -> lista di insegnanti prossimi alla pensione(entro a 5 anni dalla pensione)
//- double totaleStipendiIta() -> totale stipendio degli insegnanti di italiano
//- double mediaStipendi() -> media degli stipendi di tutti gli insegnanti
//- double mediaStipendiMate() -> media degli stipendi degli insegnanti di matematica
//
//PRO VERSION
//- String studenteBravo() -> nome e media dello studente con la media maggiore
//- String insegnanteVecchio() -> nome ed età dell'insegnante più vecchio
//- String insegnanteRicco() -> nome, materia e stipendio dell'insegnante più pagato
//- String studenteGiovane() -> nome, età e classe(2A) dello studente più giovane
//
//BONUS
//- String fuoriCorso() -> Ritorna il nome e gli anni fuori corso degli studenti, tenendo presente che
//						per essere in corso le combinazioni dovrebbero essere:  
//						CLASSE -> ANNI => 5->19-18, 4->18-17, 3->17-16, 2->16-15, 1->15,14
//- String studentiPerAula() -> Per ogni aula (ES 4C) voglio vedere il nome dell'aula e il numero di studenti presenti

public class Scuola {

	private ArrayList<Persona> persone;

	public Scuola(String path) throws FileNotFoundException
	{
		persone = new ArrayList<>();

		Scanner file = new Scanner(new File(path));

		while(file.hasNextLine()) 
		{
			String[] info = file.nextLine().split(",");

			switch(info[0].toLowerCase()) 
			{
			case "studente":
				persone.add(new Studente(
						info[1],
						info[2],
						Integer.parseInt(info[3]),
						info[4],
						parseVoti(info[5], info[6], info[7])

						));
				break;
			case "insegnante":
				persone.add(new Insegnante(
						info[1],
						info[2],
						info[3],
						Double.parseDouble(info[4])
						));
				break;
			default:
				System.out.println("Riga Errata nel file dati");
			}
		}
		file.close();
	}

	public static double[] parseVoti(String votoItaliano, String votoMatematica, String votoInglese) {
		double[] voti = new double[3];
		voti[0] = Double.parseDouble(votoItaliano);
		voti[1] = Double.parseDouble(votoMatematica);
		voti[2] = Double.parseDouble(votoInglese);
		return voti;
	}

	public String listaStudenti() {
		String ris = "";
		for (Persona persona : persone) {
			if (persona instanceof Studente) {
				ris += persona.toString();
			}
		}
		return ris;
	}

	public String listaInsegnanti() {
		String ris = "";
		for (Persona persona : persone) {
			if (persona instanceof Insegnante) {
				ris += persona.toString();
			}
		}
		return ris;
	}

	public String listaCompleta() {
		String ris = "";

		ris = listaStudenti() + listaInsegnanti();

		return ris;
	}

	//- String listaPromossi() -> lista degli studenti promossi e il numero degli studenti bocciati
	public String listaPromossi() {
		String ris = "";
		int contaStudentiBocciati = 0;

		for (Persona persona : persone) {
			if (persona instanceof Studente) {
				Studente studente = (Studente) persona;
				if (studente.esito().toLowerCase().equalsIgnoreCase("promosso")) {
					ris += studente.getNome() + ", ";
				} else {
					contaStudentiBocciati++;
				}
			}
		}

		return "\nStudenti promossi: " + ris.substring(0, ris.length() - 2) + "\nNumero studenti bocciati: " + contaStudentiBocciati;
	}

	//- int nErasmus() -> numero degli studenti che possono andare in erasmus(ricordate i metodi già scritti!)
	public int nErasmus() {
		int conta = 0;

		for (Persona persona : persone) {
			if (persona instanceof Studente) {
				Studente studente = (Studente) persona;
				if (studente.erasmus()) {
					conta++;
				}
			}
		}

		return conta;
	}

	//- String pensionamento() -> lista di insegnanti prossimi alla pensione(entro a 5 anni dalla pensione)

	public String pensionamento() {
		String ris = "";

		for (Persona persona : persone) {
			if (persona instanceof Insegnante) {
				Insegnante insegnante = (Insegnante) persona;
				if (insegnante.anniPensione() <= 5) {
					ris += insegnante.getNome() + ", ";
				}
			}
		}

		return ris.isEmpty() ? "Nessun insegnante prossimo alla pensione" : "Insegnanti prossimi alla pensione: \n" + ris.substring(0, ris.length() - 2);
	}

	//- double totaleStipendiIta() -> totale stipendio degli insegnanti di italiano

	public double totaleStipendiIta() {
		double totale = 0;

		for (Persona persona : persone) {
			if (persona instanceof Insegnante) {
				Insegnante insegnante = (Insegnante) persona;
				if (insegnante.getMateria().toLowerCase().equalsIgnoreCase("italiano")) {
					totale += insegnante.stipendio();
				}
			}
		}

		return totale;
	}

	//- double mediaStipendi() -> media degli stipendi di tutti gli insegnanti
	public double mediaStipendi() {
		double media = 0;
		int conta = 0;

		for (Persona persona : persone) {
			if (persona instanceof Insegnante) {
				Insegnante insegnante = (Insegnante) persona;
				media += insegnante.stipendio();
				conta++;
			}
		}

		return conta > 0 ? media / conta : 0;
	}

	public double mediaStipendiMate() {
		double media = 0;
		int conta = 0;

		for (Persona persona : persone) {
			if (persona instanceof Insegnante) {
				Insegnante insegnante = (Insegnante) persona;
				if (insegnante.getMateria().toLowerCase().equals("matematica")) {
					media += insegnante.stipendio();
					conta++;
				}
			}
		}

		return conta > 0 ? media / conta : 0;
	}

	//- String studenteBravo() -> nome e media dello studente con la media maggiore
	public String studenteBravo() {
		String ris = "";
		double max = 0;

		for (Persona persona : persone) {
			if (persona instanceof Studente) {
				Studente studente = (Studente) persona;
				if (studente.mediaStudenti() > max) {
					max = studente.mediaStudenti();
					ris = studente.getNome() + " con " + studente.mediaStudenti() + " \n";
				} else if (studente.mediaStudenti() == max) {
					ris += ", " + studente.getNome() + " con " + studente.mediaStudenti() + " \n";
				}
			}
		}

		return ris.isEmpty() ? "Nessuno studente bravo" : "Studenti migliori: \n-" + ris;
	}


	//- String insegnanteVecchio() -> nome ed età dell'insegnante più vecchio
	public String insegnanteVecchio() {
		String ris = "";
		double max = 0;

		for (Persona persona : persone) {
			if (persona instanceof Insegnante) {
				Insegnante insegnante = (Insegnante) persona;
				if (insegnante.eta() > max) {
					max = insegnante.eta();
					ris = insegnante.getNome() + " con " + insegnante.eta() + " anni\n";
				} else if (insegnante.eta() == max) {
					ris += ", " + insegnante.getNome() + " con " + insegnante.eta() + " anni\n";
				}
			}
		}

		return ris.isEmpty() ? "Nessun insegnante trovato" : "Docenti vecchi: " + ris;
	}

	//- String insegnanteRicco() -> nome, materia e stipendio dell'insegnante più pagato
	public String insegnanteRicco() {
		String ris = "";
		double max = 0;

		for (Persona persona : persone) {
			if (persona instanceof Insegnante) {
				Insegnante insegnante = (Insegnante) persona;
				if (insegnante.stipendio() > max) {
					max = insegnante.stipendio();
					ris = insegnante.getNome() + " insegna " + insegnante.getMateria() + " e guadagna " + insegnante.stipendio() + "$\n";
				} else if (insegnante.stipendio() == max) {
					ris += insegnante.getNome() + " insegna " + insegnante.getMateria() + " e guadagna " + insegnante.stipendio() + "$\n";
				}
			}
		}

		return ris;
	}

	//- String studenteGiovane() -> nome, età e classe(2A) dello studente più giovane
	public String studenteGiovane() {
		String ris = "";
		double min = 145;

		for (Persona persona : persone) {
			if (persona instanceof Studente) {
				Studente studente = (Studente) persona;
				if (studente.eta() < min) {
					min = studente.eta();
					ris = studente.getNome() + " con " + studente.eta() + " anni" + " e frequenta la " + studente.getClasse() + studente.getSezione() + " \n";
				} else if (studente.eta() == min) {
					ris += "-" + studente.getNome() + " con " + studente.eta() + " anni " + "e frequenta la " + studente.getClasse() + studente.getSezione() + " \n";
				}
			}
		}
		return ris.isEmpty() ? "Nessuno studente giovane" : "Studenti giovani: \n-" + ris;
	}


	//- String fuoriCorso() -> Ritorna il nome e gli anni fuori corso degli studenti, tenendo presente che
	//	per essere in corso le combinazioni dovrebbero essere:  
	//	CLASSE -> ANNI => 5->19-18, 4->18-17, 3->17-16, 2->16-15, 1->15,14	
	public String fuoriCorso() {
	    String ris = "";
	    int anniFuori;

	    for (Persona persona : persone) {
	        if (persona instanceof Studente) {
	            Studente studente = (Studente) persona;

	            switch (studente.getClasse()) {
	                case 5:
	                    anniFuori = 19 - studente.eta();
	                    break;
	                case 4:
	                    anniFuori = 18 - studente.eta();
	                    break;
	                case 3:
	                    anniFuori = 17 - studente.eta();
	                    break;
	                case 2:
	                    anniFuori = 16 - studente.eta();
	                    break;
	                case 1:
	                    anniFuori = 15 - studente.eta();
	                    break;
	                default:
	                    anniFuori = 0;
	                    break;
	            }

	            if (anniFuori < 0) {
	            	anniFuori = Math.abs(anniFuori);
	                ris += anniFuori > 1 ? studente.getNome() + " : " + anniFuori + " anni fuori corso\n" : studente.getNome() + " : " + anniFuori + " anno fuori corso\n";
	            }
	        }
	    }
	    return ris.isEmpty() ? "Nessuno studente fuori corso" : ris;
	}



	//- String studentiPerAula() -> Per ogni aula (ES 4C) voglio vedere il nome dell'aula e il numero di studenti presenti
	public String studentiPerAula() {
	    ArrayList<String> classi = new ArrayList<>();
	    ArrayList<Integer> contaStudenti = new ArrayList<>();
	    String lista = "LISTA CLASSI E NUMERO STUDENTI: \n";

	    for (Persona persona : persone) {
	        if (persona instanceof Studente) {
	            Studente studente = (Studente) persona;
	            String classe = studente.getClasse() + studente.getSezione();

	            if (!classi.contains(classe)) {
	                classi.add(classe);
	            }
	        }
	    }

	    for (String classe : classi) {
	        int conta = 0;
	        for (Persona persona : persone) {
	            if (persona instanceof Studente) {
	                Studente studente = (Studente) persona;
	                String classeStudente = studente.getClasse() + studente.getSezione();

	                if (classe.equals(classeStudente)) {
	                    conta++;
	                }
	            }
	        }
	        contaStudenti.add(conta);
	    }

	    for (int i = 0; i < classi.size(); i++) {
	        lista += "Classe: " + classi.get(i) + " | N. Studenti: " + contaStudenti.get(i) + "\n";
	    }

	    return lista.isEmpty() ? "Nessuno studente presente" : lista;
	}





	
	
}//class
