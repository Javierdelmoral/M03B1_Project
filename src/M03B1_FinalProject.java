
import java.util.Scanner;

//Javier del Moral

public class M03B1_FinalProject {
//Dades constants

    private static final int NOIA = 1;
    private static final int NOI = 2;
    private static final int NO_RESPON = 3;
    private static final int INFANTIL = 0;
    private static final int JUVENIL = 1;
    private static final int SENIOR = 2;
    private static final int ALTRE_CIUTAT = 0;
    private static final int ALACANT = 1;
    private static final int BARCELONA = 2;
    private static final int CASTELLO = 3;
    private static final int MALAGA = 4;
    private static final int MURCIA = 5;
    private static final int MADRID = 6;
    private static final int MAXPARTICIPANTS = 10;
    //Dades constants de mins i maxs
    private static final int DORSAL_MIN = 30;
    private static final int DORSAL_MAX = 999;
    private static final int GEN_MIN = 1;
    private static final int GEN_MAX = 3;
    private static final int CAT_MIN = 0;
    private static final int CAT_MAX = 2;
    private static final int CIUTAT_MIN = 0;
    private static final int CIUTAT_MAX = 6;
    private static final int TEMPS_MIN = 0;
    private static final int TEMPS_MAX = 500;
    private static final int MAX_INTENTS = 3;
    //PROJECTE 4
    private static final int COLUMNES = 5;

    public static void main(String[] args) {

        //Variables a omplir per user
        int resposta = 0;
        int comptador = 0;
        int numParticipants = 0;
        int posicioArray = 0;
        int auxDorsal = 0;

        //Auxiliar per BubbleSort
        int aux = 0;

        //Strings a printar ordenats
        String genereToPrint = "";
        String categoriaToPrint = "";
        String ciutatToPrint = "";

        //Boolean per controlar errades
        boolean dadaCorrecte = true;
        boolean nouParticipant = false;
        boolean ordenats = false;
        boolean mostrarMitja = false;
        boolean error = false;

        //Variables mitjanes
        double tempsAltreCiutat = 0, tempsAlacant = 0, tempsBarcelona = 0, tempsCastello = 0, tempsMalaga = 0, tempsMurcia = 0, tempsMadrid = 0;
        double participantsAltreCiutat = 0, participantsAlacant = 0, participantsBarcelona = 0, participantsCastello = 0, participantsMalaga = 0, participantsMurcia = 0, participantsMadrid = 0;

        //PROJECTE 4
        int[][] participants = new int[MAXPARTICIPANTS][COLUMNES];
        int posicioArray2 = 0;

        //Scanner per a que user ompli camps
        Scanner sc = new Scanner(System.in);

        do {
            comptador = 0;

            do {
                error = false;
                //1a pregunta dorsal i input
                System.out.println("\nQuin dorsal tens? \nHa de ser entre 30 i 999, inclosos");
                System.out.println("Et queden " + (MAX_INTENTS - comptador) + " intents.");
                dadaCorrecte = sc.hasNextInt();

                if (dadaCorrecte) {
                    participants[posicioArray][0] = sc.nextInt();

                    //Si input dorsal incorrecte...
                    if (participants[posicioArray][0] < DORSAL_MIN || participants[posicioArray][0] > DORSAL_MAX) {
                        System.out.println("Dada de dorsal incorrecte");
                        dadaCorrecte = false;
                    }
                } else {
                    System.out.println("Has de ficar un numero!");
                }
                comptador++;
                sc.nextLine();
                //en bucle fins a que l'entrada sigui correcte o arribi a 3 intents
            } while ((!dadaCorrecte) && (comptador < MAX_INTENTS));

            //Si és correcte...
            if (dadaCorrecte) {
                comptador = 0;
                System.out.println("Nombre de dorsal correcte, proseguim...\n");
                do {
                    //2a pregunta de genere i input
                    System.out.println("Quin és el teu génere? \n1 per NOIA, 2 per NOI, 3 per NO RESPON");
                    System.out.println("Et queden " + (MAX_INTENTS - comptador) + " intents.");
                    dadaCorrecte = sc.hasNextInt();

                    if (dadaCorrecte) {
                        participants[posicioArray][1] = sc.nextInt();

                        //Si input genere incorrecte...
                        if (participants[posicioArray][1] < GEN_MIN || participants[posicioArray][1] > GEN_MAX) {
                            System.out.println("Dada de genere incorrecte");
                            dadaCorrecte = false;
                        }
                    } else {
                        System.out.println("Has de ficar un numero!");
                    }
                    comptador++;
                    sc.nextLine();
                } while ((!dadaCorrecte) && (comptador < MAX_INTENTS));
            }

            //Si és correcte
            if (dadaCorrecte) {
                comptador = 0;
                System.out.println("Dada de genere correcte, proseguim...\n");

                do {
                    //3a pregunta de categoria i input
                    System.out.println("A quina categoria participes? \n0 per INFANTIL, 1 per JUNIOR, 2 per SENIOR");
                    System.out.println("Et queden " + (MAX_INTENTS - comptador) + " intents.");
                    dadaCorrecte = sc.hasNextInt();

                    if (dadaCorrecte) {
                        participants[posicioArray][2] = sc.nextInt();

                        //Si input categoria és incorrecte
                        if (participants[posicioArray][2] < CAT_MIN || participants[posicioArray][2] > CAT_MAX) {
                            System.out.println("Dada de categoria incorrecte");
                            dadaCorrecte = false;
                        }
                    } else {
                        System.out.println("Has de ficar un numero!");
                    }
                    comptador++;
                    sc.nextLine();
                } while ((!dadaCorrecte) && (comptador < MAX_INTENTS));
            }

            //Si és correcte
            if (dadaCorrecte) {
                comptador = 0;
                System.out.println("Dada de categoria correcte, proseguim...\n");
                do {
                    //4a pregunta de ciutat procedencia i input
                    System.out.println("Quina és la teva ciutat de procedencia? \n1 per ALACANT, 2 per BARCELONA, "
                            + "3 per CASTELLÓ, 4 per MALAGA, 5 per MÚRCIA, 6 per MADRID, 0 per ALTRES");
                    System.out.println("Et queden " + (MAX_INTENTS - comptador) + " intents.");
                    dadaCorrecte = sc.hasNextInt();

                    if (dadaCorrecte) {
                        participants[posicioArray][3] = sc.nextInt();

                        //Si input ciutat és incorrecte...
                        if (participants[posicioArray][3] < CIUTAT_MIN || participants[posicioArray][3] > CIUTAT_MAX) {
                            System.out.println("Dada de ciutat incorrecte");
                            dadaCorrecte = false;
                        }
                    } else {
                        System.out.println("Has de ficar un numero!");
                    }
                    comptador++;
                    sc.nextLine();
                } while ((!dadaCorrecte) && (comptador < MAX_INTENTS));
            }

            //Si és correcte...
            if (dadaCorrecte) {
                comptador = 0;
                System.out.println("Dada de ciutat correcte, proseguim...\n");

                do {
                    //5a pregunta de temps i input
                    System.out.println("Quin ha sigut el teu temps? \nCom a mínim ha de ser de 0 i com a máxim ha de ser de 500");
                    System.out.println("Et queden " + (MAX_INTENTS - comptador) + " intents.");
                    dadaCorrecte = sc.hasNextInt();

                    if (dadaCorrecte) {
                        participants[posicioArray][4] = sc.nextInt();

                        //Si input temps és incorrecte...
                        if (participants[posicioArray][4] < TEMPS_MIN || participants[posicioArray][4] > TEMPS_MAX) {
                            System.out.println("Dada de temps incorrecte");
                            dadaCorrecte = false;
                        }
                    } else {
                        System.out.println("Has de ficar un numero!");
                    }
                    comptador++;
                    sc.nextLine();
                } while ((!dadaCorrecte) && (comptador < MAX_INTENTS));

            }

            //Si hi ha algún error printem...i finalitzem
            if (!dadaCorrecte) {
                System.out.println("\nAlguna de les dades s'ha introduït de manera incorrecte i per lo tant no introduim aquest usuari.");
                error = true;

                //Si no hi ha hagut cap error printem... i finalitzem
            } else {
                System.out.println("\nTotes les dades del participant han sigut introduides correctament!");
                //Sumem 1 al total de numParticipants
                numParticipants++;
            }

            //Demanem si es vol agregar un altre participant
            do {
                System.out.println("\nVols afegir un altre participant? Escriu (0) per NO i (1) per SI.");

                dadaCorrecte = sc.hasNextInt();

                //si el valor és numeric...
                if (dadaCorrecte) {

                    resposta = sc.nextInt();

                    if (resposta == 0) {
                        nouParticipant = false;
                    } else if (resposta == 1) {
                        nouParticipant = true;
                        if (!error) {
                            posicioArray++;
                            posicioArray2++;
                        }
                    } else {
                        dadaCorrecte = false;
                        System.out.println("\nError, has de escriure (0) per NO i (1) per SI.");
                    }
                } else {
                    //Error si introdueix un valor no numeric
                    System.out.println("Error, no t'entenc!");
                }
                sc.nextLine();

            } while (!dadaCorrecte);

        } while (nouParticipant);

        System.out.println("\nS'han afegit un total de " + numParticipants + " participants.");

        //Si és correcte...
        if (dadaCorrecte && numParticipants > 0) {

            System.out.println("\n\nA CONTINUACIÓ VEIEM TOTS ELS PARTICIPANTS: ");

            for (posicioArray = 0; posicioArray < numParticipants; posicioArray++) {

                //Si la entrada de dades no té errades procedim a anar printant per consola les dades proporcionades per user
                System.out.println("\n\nDADES USUARI NUMERO " + (posicioArray + 1) + " INTRODUÏDES: \n");

                //Printem dorsal escollit
                System.out.println("Dorsal: " + participants[posicioArray][0]);

                //Printem el genere escollit
                switch (participants[posicioArray][1]) {
                    case NOIA:
                        System.out.println("\nGenere: NOIA");
                        break;

                    case NOI:
                        System.out.println("\nGenere NOI");
                        break;

                    case NO_RESPON:
                        System.out.println("\nGenere PREFEREIX NO RERPONDRE");
                        break;
                }

                //Printem la categoria escollida
                switch (participants[posicioArray][2]) {
                    case INFANTIL:
                        System.out.println("\nCategoria: INFANTIL");
                        break;

                    case JUVENIL:
                        System.out.println("\nCategoria JUVENIL");
                        break;

                    case SENIOR:
                        System.out.println("\nCategoria SENIOR");
                        break;
                }

                //Printem la ciutat escollida
                switch (participants[posicioArray][3]) {
                    case ALTRE_CIUTAT:
                        System.out.println("\nCiutat de procedencia: Altre ciutat");
                        break;

                    case ALACANT:
                        System.out.println("\nCiutat de procedencia: Alacant");
                        break;

                    case BARCELONA:
                        System.out.println("\nCiutat de procedencia: Barcelona");
                        break;

                    case CASTELLO:
                        System.out.println("\nCiutat de procedencia: Castelló");
                        break;

                    case MALAGA:
                        System.out.println("\nCiutat de procedencia: Malaga");
                        break;

                    case MURCIA:
                        System.out.println("\nCiutat de procedencia: Múrcia");
                        break;

                    case MADRID:
                        System.out.println("\nCiutat de procedencia: Madrid");
                        break;
                }

                //Printem el temps escollit
                System.out.println("\nTemps realitzat en minuts: " + participants[posicioArray][4]);
            }
        }

        //Preguntem a usuari si vol veure ordenats als participants
        if (numParticipants > 0) {
            do {
                System.out.println("\n\nVOLS VEURE ALS PARTICIPANTS ORDENATS PEL SEU TEMPS? Escriu (0) per NO i (1) per SI.");

                dadaCorrecte = sc.hasNextInt();

                //si el valor és numeric...
                if (dadaCorrecte) {

                    resposta = sc.nextInt();

                    if (resposta == 0) {
                        ordenats = false;
                    } else if (resposta == 1) {
                        ordenats = true;
                    } else {
                        dadaCorrecte = false;
                        System.out.println("\nError, has de escriure (0) per NO i (1) per SI.");
                    }
                } else {
                    //Error si introdueix un valor no numeric
                    System.out.println("Error, no t'entenc!");
                }
                sc.nextLine();

            } while (!dadaCorrecte);
        }

        if (ordenats) {
            //Bubble per ordenar els temps i mostrar-ho realacionat amb cada dorsal
            for (int i = 0; i < numParticipants - 1; i++) {
                for (int j = i + 1; j < numParticipants; j++) {
                    if (participants[i][4] > (participants[j][4])) {
                        //Ordenem temps
                        aux = participants[i][4];
                        participants[i][4] = participants[j][4];
                        participants[j][4] = aux;
                        //Ordenem dorsal
                        aux = participants[i][0];
                        participants[i][0] = participants[j][0];
                        participants[j][0] = aux;
                        //Ordenem genere
                        aux = participants[i][1];
                        participants[i][1] = participants[j][1];
                        participants[j][1] = aux;
                        //Ordenem categoria
                        aux = participants[i][2];
                        participants[i][2] = participants[j][2];
                        participants[j][2] = aux;
                        //Ordenem ciutat
                        aux = participants[i][3];
                        participants[i][3] = participants[j][3];
                        participants[j][3] = aux;
                    }
                }
            }

            //Printem el resultat ordenat mostrant el temps i la resta de dades escollides
            System.out.println("\nLlista de participants ordenats per temps: ");
            for (int i = 0; i < numParticipants; i++) {

                switch (participants[i][1]) {
                    case NOIA:
                        genereToPrint = "Noia";
                        break;
                    case NOI:
                        genereToPrint = "Noi";
                        break;
                    case NO_RESPON:
                        genereToPrint = "No respon";
                        break;
                }

                switch (participants[i][2]) {
                    case INFANTIL:
                        categoriaToPrint = "Infantil";
                        break;
                    case JUVENIL:
                        categoriaToPrint = "Juvenil";
                        break;
                    case SENIOR:
                        categoriaToPrint = "Senior";
                        break;
                }

                switch (participants[i][3]) {
                    case ALTRE_CIUTAT:
                        ciutatToPrint = "Altre ciutat";
                        break;

                    case ALACANT:
                        ciutatToPrint = "Alacant";
                        break;

                    case BARCELONA:
                        ciutatToPrint = "Barcelona";
                        break;

                    case CASTELLO:
                        ciutatToPrint = "Castelló";
                        break;

                    case MALAGA:
                        ciutatToPrint = "Malaga";
                        break;

                    case MURCIA:
                        ciutatToPrint = "Múrcia";
                        break;

                    case MADRID:
                        ciutatToPrint = "Madrid";
                        break;
                }

                //Sortida de dades ordenades
                System.out.printf("%n %n Posició participant: %s" + "<<<<----------", i + 1);
                System.out.printf("%n %n %-15s %-15s %-15s %-15s %-15s", "Dorsal", "Genere", "Categoria", "Ciutat", "Temps");
                System.out.printf("%n %-15s %-15s %-15s %-15s %-15s", participants[i][0], genereToPrint, categoriaToPrint, ciutatToPrint, participants[i][4]);
            }

        }

        //APARTAT C, MOSTRAR MITJA PER CIUTATS
        if (numParticipants > 0) {

            do {
                System.out.println("\n\nVOLS VEURE EL TEMPS MITJÀ PER CIUTAT? Escriu (0) per NO i (1) per SI.");

                dadaCorrecte = sc.hasNextInt();

                if (dadaCorrecte) {

                    resposta = sc.nextInt();

                    if (resposta == 0) {
                        mostrarMitja = false;
                    } else if (resposta == 1) {
                        mostrarMitja = true;
                    } else {
                        dadaCorrecte = false;
                        System.out.println("\nError, has de escriure (0) per NO i (1) per SI.");
                    }
                } else {
                    //Error si introdueix un valor no numeric
                    System.out.println("Error, no t'entenc!");
                }
                sc.nextLine();

            } while (!dadaCorrecte);

            if (mostrarMitja) {
                for (int i = 0; i < numParticipants; i++) {

                    switch (participants[i][3]) {
                        case ALTRE_CIUTAT:
                            tempsAltreCiutat += participants[i][4];
                            participantsAltreCiutat++;
                            break;
                        case ALACANT:
                            tempsAlacant += participants[i][4];
                            participantsAlacant++;
                            break;
                        case BARCELONA:
                            tempsBarcelona += participants[i][4];
                            participantsBarcelona++;
                            break;
                        case CASTELLO:
                            tempsCastello += participants[i][4];
                            participantsCastello++;
                            break;
                        case MALAGA:
                            tempsMalaga += participants[i][4];
                            participantsMalaga++;
                            break;
                        case MURCIA:
                            tempsMurcia += participants[i][4];
                            participantsMurcia++;
                            break;
                        case MADRID:
                            tempsMadrid += participants[i][4];
                            participantsMadrid++;
                            break;
                    }
                }

                if (participantsAltreCiutat > 0) {
                    System.out.println("\n\nTemps total participants ALTRES CIUTATS: " + tempsAltreCiutat);
                    System.out.println("\nMitjana dels participants ALTRES CIUTATS: " + (tempsAltreCiutat / participantsAltreCiutat));
                }
                if (participantsAlacant > 0) {
                    System.out.println("\n\nTemps total participants Alacant: " + tempsAlacant);
                    System.out.println("\nMitjana dels participants Alacant: " + (tempsAlacant / participantsAlacant));
                }
                if (participantsBarcelona > 0) {
                    System.out.println("\n\nTemps total participants Barcelona: " + tempsBarcelona);
                    System.out.println("\nMitjana dels participants Barcelona: " + (tempsBarcelona / participantsBarcelona));
                }
                if (participantsCastello > 0) {
                    System.out.println("\n\nTemps total participants Castello: " + tempsCastello);
                    System.out.println("\nMitjana dels participants Castello: " + (tempsCastello / participantsCastello));
                }
                if (participantsMalaga > 0) {
                    System.out.println("\n\nTemps total participants Malaga: " + tempsMalaga);
                    System.out.println("\nMitjana dels participants Malaga: " + (tempsMalaga / participantsMalaga));
                }
                if (participantsMurcia > 0) {
                    System.out.println("\n\nTemps total participants Murcia: " + tempsMurcia);
                    System.out.println("\nMitjana dels participants Murcia: " + (tempsMurcia / participantsMurcia));
                }
                if (participantsMadrid > 0) {
                    System.out.println("\n\nTemps total participants Madrid: " + tempsMadrid);
                    System.out.println("\nMitjana dels participants Madrid: " + (tempsMadrid / participantsMadrid));
                }

            }

        } else {
            System.out.println("\nPROGRAMA FINALITZAT!");
        }
    }
}
