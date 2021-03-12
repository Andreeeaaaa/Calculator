package andrealanocita.calcolatore;


public class Espressioni {

    static String primaEspressione;
    static String risultato;

    static int nParentesiAperte;
    static int nParentesiChiuse;


    static String Es(String In) {

        primaEspressione = In;      //la segnalo come copia di In prima dei loop in modo da poterla usare nella prima istanza dei blocchi for


        for (int i = 0; i < In.length(); i++) {             //Inizio a controllare tutti i caratteri dell'espressione

            if (In.contains("(") || In.contains(")")) {             //controllo se nell'espressione sono presenti delle parentesi

                nParentesiAperte = Methods.countChar(In, "(".charAt(0));  //conto le parantesi
                nParentesiChiuse = Methods.countChar(In, ")".charAt(0)); //conto le parentesi chiuse

                if (nParentesiAperte != nParentesiChiuse) {       //se ci sono parentesi non chiuse ritorna un errore
                    return "Errore! Espressione invalida";
                }

                for (int l = 0; l < In.length(); l++) {             //cerco parentesi nei caratteri delle espressione e delineo la parte di espressione tra le parentesi più interne

                    System.out.println(primaEspressione + " Espressione prima del controllo parentesi");

                    if (primaEspressione.charAt(l) == "(".charAt(0)) {        //se trovo una parentesi aperta faccio una substring con tutto ciò che viene dopo la parentesi

                        primaEspressione = primaEspressione.substring(l + 1);     //substring con tutto ciò che viene dopo la parentesi
                        l = -1;          //ricomincio il ciclo da zero nella sottostringa che parte con la parentesi

                        System.out.println(primaEspressione + "Espressione dopo parentesiaperta");

                    } else if (primaEspressione.charAt(l) == ")".charAt(0)) {         //se trovo una parentesi chiusa faccio una substring con tutto ciò che viene prima della parentesi

                        primaEspressione = primaEspressione.substring(0, l);

                        System.out.println(primaEspressione + "Espressione dopo parentesichiusa");

                        break;
                    }

                }

                if (primaEspressione.contains("V")) {           //controllo se ci sono radici

                    risultato = Methods.radici(primaEspressione);               //chiamo il metodo del calcolatore e rimpiazzo la substring
                    In = In.replace("(" + primaEspressione + ")", risultato);               //rimpiazzo l'espressione calcolata nelle parentesi con il risultato ottenuto

                }


                if (primaEspressione.contains("^")) {           //controllo se sono presenti degli elevamenti a potenza
                    risultato = Methods.elevamentoPotenza(primaEspressione, "^".charAt(0));         //chiamo il metodo del calcolatore e rimpiazzo la substring
                    In = In.replace("(" + primaEspressione + ")", risultato);           //rimpiazzo l'espressione calcolata nelle parentesi con il risultato ottenuto

                }


                if (primaEspressione.contains("*") || primaEspressione.contains("/")) {         //controllo se nella espressione dentro alla parentesi sono presenti * o /

                    risultato = Methods.piuMenoPerDiviso(primaEspressione, "*".charAt(0), "/".charAt(0));         //chiamo il metodo del calcolatore e rimpiazzo la substring
                    In = In.replace("(" + primaEspressione + ")", risultato);           //rimpiazzo l'espressione calcolata nelle parentesi con il risultato ottenuto

                }

                if (primaEspressione.contains("+") || primaEspressione.contains("-")) {         //controllo se nella espressione dentro alla parentesi sono presenti + o -

                        risultato = Methods.piuMenoPerDiviso(primaEspressione, "+".charAt(0), "-".charAt(0));         //chiamo il metodo del calcolatore e rimpiazzo la substring
                        In = In.replace("(" + primaEspressione + ")", risultato);           //rimpiazzo l'espressione calcolata nelle parentesi con il risultato ottenuto

                } else {            //se non c'è niente nella parentesi aparte un numero tolgo le parentesi

                    In = In.replace("(" + primaEspressione + ")", primaEspressione);           //tolgo le parentesi

                }

                primaEspressione = In;      //la segnalo come copia di In prima di rifare il loop in modo da poterla usare nella prima istanza dei blocchi for
                i = 0;      //rinizio il ciclo

            }




            else {        //calcolo l'ultima espressione senza parentesi

                if (In.contains("V")) {
                    In = Methods.radici(In);
                    i = 0;
                }

                if (In.contains("^")) {           //controllo se sono presenti degli elevamenti a potenza
                    In = Methods.elevamentoPotenza(In, "^".charAt(0));         //chiamo il metodo del calcolatore e rimpiazzo la substring
                    i = 0;      //rinizio il ciclo
                }


                if (In.contains("*") || In.contains("/")) {         //controllo se nella espressione dentro alla parentesi sono presenti * o /

                    In = Methods.piuMenoPerDiviso(In, "*".charAt(0), "/".charAt(0));         //chiamo il metodo del calcolatore e rimpiazzo la substring
                    i = 0;      //rinizio il ciclo

                }

                if ((In.contains("+") || In.contains("-")) && (In.charAt(0) != "-".charAt(0) || In.contains("+") || Methods.countChar(In, "-".charAt(0)) != 1)) {         //controllo se nella espressione dentro alla parentesi sono presenti + o -

                    System.out.println("if finale triggered :)");

                    In = Methods.piuMenoPerDiviso(In, "+".charAt(0), "-".charAt(0));         //chiamo il metodo del calcolatore e rimpiazzo la substring
                    i = 0;      //rinizio il ciclo

                } else {

                    break;      //se non ci sono parentesi o segni chiudo il ciclo e ritorno il risultato

                }
            }

        }


        return In;
    }
}

