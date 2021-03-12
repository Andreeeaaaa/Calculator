package andrealanocita.calcolatore;

import java.util.ArrayList;
import java.util.List;


public class Methods {

    static int countChar(String str, char c) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
        }

        return count;
    }

    static String radici(String str) {
        double res = 0;
        double segnoPrima = 0;
        double segnoDopo = 0;

        int posA = 0;
        int posB = 0;

        String risultato = "";

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == "V".charAt(0)) {

                if (i == 0) {               //se non c'è niente prima del radicale metto l'indice = 2

                    System.out.println("non c'è niente prima del radicale!");
                    segnoPrima = 2.00;

                }

                else {
                    for (int a = i - 1; true; a--) {           //trovo il segno precedente

                        if (str.charAt(a) == "+".charAt(0) | str.charAt(a) == "-".charAt(0) | str.charAt(a) == "*".charAt(0) | str.charAt(a) == "/".charAt(0) | str.charAt(a) == "^".charAt(0)) {

                            if (a == i-1) {             //se non c'è l'indice della radice lo metto == 2

                                System.out.println("C'è un segno subito prima del radicale!");

                                segnoPrima = 2.00;
                                posA = a + 1;           //mi segno la posizione del radicale in modo da poterlo sostituire col risultato
                                break;
                            }

                            if (str.charAt(a) == "-".charAt(0) && a == 0) {     //se il numero è negativo prendo in considerazione tutto prima del segno

                                segnoPrima = Double.parseDouble(str.substring(0, i));
                                break;

                            } else {
                                segnoPrima = Double.parseDouble(str.substring(a + 1, i));     //trovo la parte prima del segno interessato (uno dei due membri dell'operazione)

                                posA = a + 1;           //mi segno la posizione della stringa in cui inizia l'operazione in modo da poterla sostituire successivamente

                                break;
                            }



                        } else if (a == 0) {                        //prendo in considerazione tutta l'espressione prima del segno se non ci sono altri segni prima

                            System.out.println(str.substring(a, i));
                            segnoPrima = Double.parseDouble(str.substring(a, i));

                            posA = 0;
                            break;
                        }
                    }
                }







                for (int b = i + 1; true; b++) {           //trovo il segno successivo
                    if (str.charAt(b) == "+".charAt(0) | str.charAt(b) == "-".charAt(0) | str.charAt(b) == "*".charAt(0) | str.charAt(b) == "/".charAt(0) | str.charAt(b) == "^".charAt(0)) {

                        if ((str.charAt(i + 1) != "-".charAt(0) || b != i + 1) && (str.charAt(0) != "-".charAt(0) || b!= 0)) {                //skippo un eventuale segno davanti al numero (ad indicare un n negativo) e un indicativo all'inizio dell'espressione

                            System.out.println("Trovata parte dopo segno, b == " + b);
                            segnoDopo = Double.parseDouble(str.substring(i + 1, b));     //trovo la parte dopo al segno interessato (uno dei due membri dell'operazione)

                            posB = b;       //mi segno la posizione della stringa in cui finisce l'operazione in modo da poterla sostituire successivamente
                            break;

                        }

                    } else if (b == str.length() - 1) {     //prendo in considerazione tutta l'espressione dopo del segno se non ci sono altri segni dopo

                        System.out.println(str.substring(i + 1));
                        segnoDopo = Double.parseDouble(str.substring(i + 1));

                        posB = b+1;
                        break;
                    }
                }
            }


            res = Math.pow(segnoDopo, 1.0 / segnoPrima);            //eseguo una potenza per 1 / l'indice della frazione

            //creo substring operazione svolta e la rimpiazzo con il cast della double, poi la ritorno
            String s = str.substring(posA, posB);
            String p = "" + res;
            risultato = str.replace(s, p);

        }
        return risultato;
    }



    static String elevamentoPotenza(String str, char operazione) {

        double res = 0;
        double segnoPrima = 0;
        double segnoDopo = 0;

        int posA = 0;
        int posB = 0;

        String risultato = "";

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == operazione) {            //trovo la posizione del segno dell'operazione

                for (int a = i - 1; true; a--) {           //trovo il segno precedente

                    if (str.charAt(a) == "+".charAt(0) | str.charAt(a) == "-".charAt(0) | str.charAt(a) == "*".charAt(0) | str.charAt(a) == "/".charAt(0) | str.charAt(a) == "^".charAt(0)) {

                        if (str.charAt(a) == "-".charAt(0) && a == 0) {     //se il numero è negativo prendo in considerazione tutto prima del segno

                            segnoPrima = Double.parseDouble(str.substring(0, i));
                            break;

                        } else {
                            segnoPrima = Double.parseDouble(str.substring(a + 1, i));     //trovo la parte prima del segno interessato (uno dei due membri dell'operazione)

                            posA = a + 1;           //mi segno la posizione della stringa in cui inizia l'operazione in modo da poterla sostituire successivamente

                            break;
                        }



                    } else if (a == 0) {                        //prendo in considerazione tutta l'espressione prima del segno se non ci sono altri segni prima

                        System.out.println(str.substring(a, i));
                        segnoPrima = Double.parseDouble(str.substring(a, i));

                        posA = 0;
                        break;
                    }
                }




                for (int b = i + 1; true; b++) {           //trovo il segno successivo
                    if (str.charAt(b) == "+".charAt(0) | str.charAt(b) == "-".charAt(0) | str.charAt(b) == "*".charAt(0) | str.charAt(b) == "/".charAt(0) | str.charAt(b) == "^".charAt(0)) {

                        if ((str.charAt(i + 1) != "-".charAt(0) || b != i + 1) && (str.charAt(0) != "-".charAt(0) || b!= 0)) {                //skippo un eventuale segno davanti al numero (ad indicare un n negativo) e un indicativo all'inizio dell'espressione

                            System.out.println("Trovata parte dopo segno, b == " + b);
                            segnoDopo = Double.parseDouble(str.substring(i + 1, b));     //trovo la parte dopo al segno interessato (uno dei due membri dell'operazione)

                            posB = b;       //mi segno la posizione della stringa in cui finisce l'operazione in modo da poterla sostituire successivamente
                            break;

                        }

                    } else if (b == str.length() - 1) {     //prendo in considerazione tutta l'espressione dopo del segno se non ci sono altri segni dopo

                        System.out.println(str.substring(i + 1));
                        segnoDopo = Double.parseDouble(str.substring(i + 1));

                        posB = b+1;
                        break;
                    }
                }
                }

                if (operazione == "+".charAt(0)) {                  //Trovo il segno dell'operazione in un modo assolutamente poco comodo e la calcolo
                    res = segnoPrima + segnoDopo;
                } else if (operazione == "-".charAt(0)) {
                    res = segnoPrima - segnoDopo;
                } else if (operazione == "*".charAt(0)) {
                    res = segnoPrima * segnoDopo;
                } else if (operazione == "/".charAt(0)) {
                    res = segnoPrima / segnoDopo;
                } else if (operazione == "^".charAt(0)) {
                    res = Math.pow(segnoPrima, segnoDopo);
                } else {
                    System.out.println("Errore! Segno non riconosciuto");
                    System.exit(0);
                }

                //creo substring operazione svolta e la rimpiazzo con il cast della double, poi la ritorno
                String s = str.substring(posA, posB);
                String p = "" + res;
                risultato = str.replace(s, p);

            }
        return risultato;
        }






    static String piuMenoPerDiviso(String str, char operazione1, char operazione2) {                //ha un metodo diverso perchè due operazioni hanno lo stesso livello di precedenza

        double res = 0;
        double segnoPrima = 0;
        double segnoDopo = 0;

        int posA = 0;
        int posB = 0;

        for (int i = 0; i < str.length(); i++) {        //passo su tutti i caratteri della stringa

            if (str.contains(Character.toString(operazione1)) || str.contains(Character.toString(operazione2))) {       //controllo che ci siano i segni che ci servono


                if (operazione2 == "-".charAt(0) && countChar(str, "-".charAt(0)) == 1 && !str.contains(Character.toString(operazione1)) && str.charAt(0) == "-".charAt(0)) {     //se rimane solo un singolo numero negativo rompo il for
                    break;
                }


                if (str.charAt(i) == operazione1) {            //trovo la posizione del segno dell'operazione

                    for (int a = i - 1; true; a--) {           //trovo il segno precedente

                        if (str.charAt(a) == "+".charAt(0) | str.charAt(a) == "-".charAt(0) | str.charAt(a) == "*".charAt(0) | str.charAt(a) == "/".charAt(0) | str.charAt(a) == "^".charAt(0)) {

                            if (str.charAt(a) == "-".charAt(0) && a == 0) {     //se il numero è negativo prendo in considerazione tutto prima del segno

                                segnoPrima = Double.parseDouble(str.substring(0, i));
                                break;

                            } else {
                                segnoPrima = Double.parseDouble(str.substring(a + 1, i));     //trovo la parte prima del segno interessato (uno dei due membri dell'operazione)

                                posA = a + 1;           //mi segno la posizione della stringa in cui inizia l'operazione in modo da poterla sostituire successivamente

                                break;
                            }



                        } else if (a == 0) {                        //prendo in considerazione tutta l'espressione prima del segno se non ci sono altri segni prima

                            System.out.println(str.substring(a, i));
                            segnoPrima = Double.parseDouble(str.substring(a, i));

                            posA = 0;
                            break;
                        }
                    }




                    for (int b = i + 1; true; b++) {           //trovo il segno successivo
                        if (str.charAt(b) == "+".charAt(0) | str.charAt(b) == "-".charAt(0) | str.charAt(b) == "*".charAt(0) | str.charAt(b) == "/".charAt(0) | str.charAt(b) == "^".charAt(0)) {

                            if ((str.charAt(i + 1) != "-".charAt(0) || b != i + 1) && (str.charAt(0) != "-".charAt(0) || b!= 0)) {                //skippo un eventuale segno davanti al numero (ad indicare un n negativo) e un indicativo all'inizio dell'espressione

                                System.out.println("Trovata parte dopo segno, b == " + b);
                                segnoDopo = Double.parseDouble(str.substring(i + 1, b));     //trovo la parte dopo al segno interessato (uno dei due membri dell'operazione)

                                posB = b;       //mi segno la posizione della stringa in cui finisce l'operazione in modo da poterla sostituire successivamente
                                break;

                            }

                        } else if (b == str.length() - 1) {     //prendo in considerazione tutta l'espressione dopo del segno se non ci sono altri segni dopo

                            System.out.println(str.substring(i + 1));
                            segnoDopo = Double.parseDouble(str.substring(i + 1));

                            posB = b+1;
                            break;
                        }
                    }

                    if (operazione1 == "+".charAt(0)) {                  //Trovo il segno dell'operazione in un modo assolutamente poco comodo e la calcolo
                        res = segnoPrima + segnoDopo;
                    } else if (operazione1 == "-".charAt(0)) {
                        res = segnoPrima - segnoDopo;
                    } else if (operazione1 == "*".charAt(0)) {
                        res = segnoPrima * segnoDopo;
                    } else if (operazione1 == "/".charAt(0)) {
                        res = segnoPrima / segnoDopo;
                    } else if (operazione1 == "^".charAt(0)) {
                        res = Math.pow(segnoPrima, segnoDopo);
                    } else {
                        System.out.println("Errore! Segno non riconosciuto");
                        System.exit(0);
                    }

                    //creo substring operazione svolta e la rimpiazzo con il cast della double, poi la ritorno

                    System.out.println(res);

                    String s = str.substring(posA, posB);
                    String p = Double.toString(res);

                    System.out.println(p);
                    System.out.println(s);

                    str = str.replace(s, p);
                    i = 0;

                    System.out.println(str);

                }


                if (str.charAt(i) == operazione2 && (i != 0 || operazione2 != "-".charAt(0))) {            //trovo la posizione del segno dell'operazione e controllo che non sia un - davanti ad il primo numero (numero negativo)


                    for (int a = i - 1; true; a--) {           //trovo il segno precedente

                        if (str.charAt(a) == "+".charAt(0) | str.charAt(a) == "-".charAt(0) | str.charAt(a) == "*".charAt(0) | str.charAt(a) == "/".charAt(0) | str.charAt(a) == "^".charAt(0)) {

                            if (str.charAt(a) == "-".charAt(0) && a == 0) {     //se il numero è negativo prendo in considerazione tutto prima del segno

                                segnoPrima = Double.parseDouble(str.substring(0, i));
                                break;

                            } else {

                                segnoPrima = Double.parseDouble(str.substring(a + 1, i));     //trovo la parte prima del segno interessato (uno dei due membri dell'operazione)

                                posA = a + 1;           //mi segno la posizione della stringa in cui inizia l'operazione in modo da poterla sostituire successivamente

                                break;
                            }



                        } else if (a == 0) {                        //prendo in considerazione tutta l'espressione prima del segno se non ci sono altri segni prima

                            System.out.println(str.substring(a, i));
                            segnoPrima = Double.parseDouble(str.substring(a, i));

                            posA = 0;
                            break;
                        }
                    }

                    for (int b = i + 1; true; b++) {           //trovo il segno successivo
                        if (str.charAt(b) == "+".charAt(0) | str.charAt(b) == "-".charAt(0) | str.charAt(b) == "*".charAt(0) | str.charAt(b) == "/".charAt(0) | str.charAt(b) == "^".charAt(0)) {

                            if ((str.charAt(i + 1) != "-".charAt(0) || b != i + 1) && (str.charAt(0) != "-".charAt(0) || b!= 0)) {                //skippo un eventuale segno davanti al numero (ad indicare un n negativo) e un - all'inizio dell'espressione

                                System.out.println("trovata parte dopo segno!" + b);

                                segnoDopo = Double.parseDouble(str.substring(i + 1, b));     //trovo la parte dopo al segno interessato (uno dei due membri dell'operazione)

                                posB = b;       //mi segno la posizione della stringa in cui finisce l'operazione in modo da poterla sostituire successivamente
                                break;
                            }



                        } else if (b == str.length() - 1) {     //prendo in considerazione tutta l'espressione dopo del segno se non ci sono altri segni dopo

                            System.out.println(str.substring(i + 1));
                            segnoDopo = Double.parseDouble(str.substring(i + 1));

                            posB = b+1;
                            break;
                        }
                    }

                    if (operazione2 == "+".charAt(0)) {                  //Trovo il segno dell'operazione in un modo assolutamente poco comodo e la calcolo
                        res = segnoPrima + segnoDopo;
                    } else if (operazione2 == "-".charAt(0)) {
                        res = segnoPrima - segnoDopo;
                    } else if (operazione2 == "*".charAt(0)) {
                        res = segnoPrima * segnoDopo;
                    } else if (operazione2 == "/".charAt(0)) {
                        res = segnoPrima / segnoDopo;
                    } else if (operazione2 == "^".charAt(0)) {
                        res = Math.pow(segnoPrima, segnoDopo);
                    } else {
                        System.out.println("Errore! Segno non riconosciuto");
                        System.exit(0);
                    }

                    //creo substring operazione svolta e la rimpiazzo con il cast della double, poi la ritorno

                    System.out.println(res);

                    String s = str.substring(posA, posB);
                    String p = Double.toString(res);

                    System.out.println(p);
                    System.out.println(s);

                    str = str.replace(s, p);
                    i = 0;

                    System.out.println(str);

                }

            } else {            //se non ci sono i segni che ci servono fermiamo il for
                break;
            }



        }
        return str;
    }
}
