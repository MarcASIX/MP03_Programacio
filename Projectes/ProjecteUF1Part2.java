/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecteuf1;

import java.util.Scanner;

/**
 *
 * @author UserA
 */
public class ProjecteUF1Part2 {

    //Declaració de constants int
    private static final int IDMIN = 111, IDMAX = 999, AGEMIN = 14, AGEMAX = 120, SELLTYPEMIN = 0,
            SELLTYPEMAX = 3, BUYIMPORTMIN = 0, BUYIMPORTMAX = 1000, PHONEMIN = 111111111, PHONEMAX = 999999999;

    //Declaració de constants string 
    private static final String MSG1 = "Introdueix el nombre d'usuaris que vols introduïr: ";
    private static final String MSG2 = "Ha de ser un nombre enter. ";
    private static final String MSG3 = "Usuari número ";
    private static final String MSG4 = "Introdueix la id. Valors vàlids de 111 a 999 (ambdós inclosos): ";
    private static final String MSG5 = "Error. ";
    private static final String MSG6 = "Introdueix l'edat. Valors vàlids de 14 a 120 (ambdós inclosos): ";
    private static final String MSG7 = "Introdueix el tipus de venda. Valors vàlids de 0 a 3 (ambdós inclosos): ";
    private static final String MSG8 = "Introdueix l'import de la compra. Valors vàlids de 0 a 1000 (ambdós inclosos): ";
    private static final String MSG9 = "Introdueix el telefon. Valors vàlids de 111111111 a 999999999 (ambdós inclosos): ";
    private static final String MSG10 = "Hi ha hagut 3 errors, vols seguir introduïnt les dades de l'usuari i no finalitzar l'introducció de dades? (no: 0 / si: 1)";
    private static final String MSG11 = "Id\tedat\ttipus\t\timport\ttelèfon";
    private static final String MSG12 = "\t";
    private static final String MSG13 = "V.lliure";
    private static final String MSG14 = "Pensionista";
    private static final String MSG15 = "C.jove";
    private static final String MSG16 = "Soci";
    private static final String MSG17 = "Vols consultar les dades per tipus de client? (no: 0 / si: 1)";
    private static final String MSG18 = "Quin tipus de client vols consultar?";
    private static final String MSG19 = "Vols veure un resum estadístic de les dades? (no: 0 / si: 1)";
    private static final String MSG20 = "Número de clients introduïts: ";
    private static final String MSG21 = "Mitjana d’edat: ";
    private static final String MSG22 = "Número de clients per tipus: ";
    private static final String MSG23 = ": ";
    private static final String MSG24 = "Histograma de número de clients per tipus: ";
    private static final String MSG25 = "-----------------------------------------";
    private static final String MSG26 = "Import total acumulat: ";

     
    public static void main(String[] args) {

        //Declaració de variables
        int count = 0, SIZE = 0, i = 0, lengthPhone = 0, lengthPhoneTemp = 0, usuarisOK = 0, consultar = 0, consultarTipus = 0, canvi = 0, avgAge = 0, allImport = 0;
        boolean numOK;

        Scanner sc = new Scanner(System.in);

        //Preguntem el nombre d'usuaris que es volen introduïr
        do {
            System.out.println(MSG1);
            numOK = sc.hasNextInt();
            if (numOK) {
                SIZE = sc.nextInt();
            } else {
                System.out.print(MSG2);
                sc.next();
            }
        } while (!numOK);

        //Declaració d'arrays segóns la variable SIZE d'usuaris
        int[] arrayId = new int[SIZE];
        int[] arrayAge = new int[SIZE];
        int[] arraySellType = new int[SIZE];
        int[] arrayBuyImport = new int[SIZE];
        int[] arrayPhone = new int[SIZE];

        //Es repetirà segons el nombre d'usuaris que es vulguin intrudïr
        for (i = 0; i < SIZE; i++) {

            //Mentre count sigui menor a 3
            if (count < 3) {
                System.out.println(MSG3 + (i + 1));

                //Preguntem ID amb validació de dades
                do {
                    System.out.println(MSG4);
                    numOK = sc.hasNextInt();
                    if ((numOK)) {
                        arrayId[i] = sc.nextInt();
                    } else {
                        System.out.print(MSG5);
                        count = count + 1;
                        sc.next();
                    }
                    if ((arrayId[i] < IDMIN || arrayId[i] > IDMAX) && (numOK)) {
                        System.out.print(MSG5);
                        numOK = false;
                        count = count + 1;
                    }
                } while (!numOK && count < 3);

                //Preguntem AGE amb validació de dades 
                if (count < 3 && numOK) {
                    count = 0;
                    do {
                        System.out.println(MSG6);
                        numOK = sc.hasNextInt();
                        if ((numOK)) {
                            arrayAge[i] = sc.nextInt();
                        } else {
                            System.out.print(MSG5);
                            count = count + 1;
                            sc.next();
                        }
                        if ((arrayAge[i] < AGEMIN || arrayAge[i] > AGEMAX) && (numOK)) {
                            System.out.print(MSG5);
                            numOK = false;
                            count = count + 1;
                        }
                    } while (!numOK && count < 3);
                }
                //Preguntem SELL TYPE amb validació de dades 
                if (count < 3 && numOK) {
                    count = 0;
                    do {
                        System.out.println(MSG7);
                        numOK = sc.hasNextInt();
                        if ((numOK)) {
                            arraySellType[i] = sc.nextInt();
                        } else {
                            System.out.print(MSG5);
                            count = count + 1;
                            sc.next();
                        }
                        if ((arraySellType[i] < SELLTYPEMIN || arraySellType[i] > SELLTYPEMAX) && (numOK)) {
                            System.out.print(MSG5);
                            numOK = false;
                            count = count + 1;
                        }
                    } while (!numOK && count < 3);
                }

                //Preguntem BUY IMPORT amb validació de dades 
                if (count < 3 && numOK) {
                    count = 0;
                    do {
                        System.out.println(MSG8);
                        numOK = sc.hasNextInt();
                        if ((numOK)) {
                            arrayBuyImport[i] = sc.nextInt();
                        } else {
                            System.out.print(MSG5);
                            count = count + 1;
                            sc.next();
                        }
                        if ((arrayBuyImport[i] < BUYIMPORTMIN || arrayBuyImport[i] > BUYIMPORTMAX) && (numOK)) {
                            System.out.print(MSG5);
                            numOK = false;
                            count = count + 1;
                        }
                    } while (!numOK && count < 3);
                }

                //Preguntem PHONE amb validació de dades, tot i que comprovem primer si phone es un nombre de 9 xifres com demana l'enunciat, 
                //de no ser així, ni es comprova si es troba o no dins del rang especificat
                if (count < 3 && numOK) {
                    count = 0;
                    do {
                        lengthPhone = 0;
                        System.out.println(MSG9);
                        numOK = sc.hasNextInt();
                        if ((numOK)) {
                            arrayPhone[i] = sc.nextInt();
                            lengthPhoneTemp = arrayPhone[i];
                        } else {
                            System.out.print(MSG5);
                            count = count + 1;
                            sc.next();
                        }
                        while (lengthPhoneTemp != 0 && (numOK)) {
                            lengthPhoneTemp = lengthPhoneTemp / 10;
                            lengthPhone = lengthPhone + 1;
                        }
                        if (lengthPhone != 9 && (numOK)) {
                            System.out.print(MSG5);
                            numOK = false;
                            count = count + 1;
                        } else {
                            if ((arrayPhone[i] < PHONEMIN || arrayPhone[i] > PHONEMAX) && (numOK)) {
                                System.out.print(MSG5);
                                numOK = false;
                                count = count + 1;
                            }
                        }
                    } while (!numOK && count < 3);
                }

                //Si es finalitza tota l'introducció de dades correctament contem 1 usuari correcte
                if (count < 3 && numOK) {
                    usuarisOK = usuarisOK + 1;
                    count = 0;
                } else {

                    //Si no es finalitza l'introducció de dades correctament i no és només un únic usuari o no es l'últim, es demana si es vol descartar l'usuari amb 3 
                    //errors i seguir introduïnt dades novament o finalitzar l'introducció de dades amb el usuaris ja introduïts independentment del SIZE original establert 
                    System.out.println();
                    if (count >= 3 && (i + 1 != SIZE)) {
                        do {
                            System.out.println(MSG10);
                            numOK = sc.hasNextInt();
                            if ((numOK)) {
                                consultar = sc.nextInt();
                            } else {
                                System.out.print(MSG5);
                                sc.next();
                            }
                            if ((consultar < 0 || consultar > 1) && (numOK)) {
                                System.out.print(MSG5);
                                numOK = false;
                            }
                        } while (!numOK);
                        if (consultar == 1) {
                            i = i - 1;
                            count = 0;
                        }
                    }
                }
            }
        }

        //Si hi ha un o més usuaris introduïts correctament mostrem les dades
        if (usuarisOK > 0) {

            //Dades en taula amb tabulacions
            System.out.println(MSG11);
            for (i = 0; i < usuarisOK; i++) {
                System.out.print(arrayId[i] + MSG12 + arrayAge[i] + MSG12);
                switch (arraySellType[i]) {
                    case 0:
                        System.out.print(MSG13 + MSG12);
                        break;
                    case 1:
                        System.out.print(MSG14 + MSG12);
                        break;
                    case 2:
                        System.out.print(MSG15 + MSG12);
                        break;
                    case 3:
                        System.out.print(MSG16 + MSG12 + MSG12);
                        break;
                    default:
                        System.out.print(MSG5 + MSG12 + MSG12);
                }
                System.out.print(arrayBuyImport[i] + MSG12 + arrayPhone[i]);
                System.out.println();
            }

            //Consultem si es volen les dades per tipus de client
            do {
                System.out.println(MSG17);
                numOK = sc.hasNextInt();
                if ((numOK)) {
                    consultar = sc.nextInt();
                } else {
                    System.out.print(MSG5);
                    sc.next();
                }
                if ((consultar < 0 || consultar > 1) && (numOK)) {
                    System.out.print(MSG5);
                    numOK = false;
                }
            } while (!numOK);

            //Si es volen consultar continuem
            if (consultar == 1) {

                //Demanem quin tipus de client es vol consultar
                do {
                    System.out.println(MSG18);
                    numOK = sc.hasNextInt();
                    if ((numOK)) {
                        consultarTipus = sc.nextInt();
                    } else {
                        System.out.print(MSG5);
                        sc.next();
                    }
                    if ((consultarTipus < 0 || consultarTipus > 3) && (numOK)) {
                        System.out.print(MSG5);
                        numOK = false;
                    }
                } while (!numOK);

                //Ordenem les arrays de menor a major segons l'edat, bubble sort
                for (i = 0; i < usuarisOK - 1; i++) {
                    for (int j = i + 1; j < usuarisOK; j++) {
                        if (arrayAge[i] > arrayAge[j]) {

                            canvi = arraySellType[i];
                            arraySellType[i] = arraySellType[j];
                            arraySellType[j] = canvi;

                            canvi = arrayId[i];
                            arrayId[i] = arrayId[j];
                            arrayId[j] = canvi;

                            canvi = arrayAge[i];
                            arrayAge[i] = arrayAge[j];
                            arrayAge[j] = canvi;

                            canvi = arrayBuyImport[i];
                            arrayBuyImport[i] = arrayBuyImport[j];
                            arrayBuyImport[j] = canvi;

                            canvi = arrayPhone[i];
                            arrayPhone[i] = arrayPhone[j];
                            arrayPhone[j] = canvi;
                        }
                    }
                }

                //Projectem taula amb tabulacions, ara ordenada
                for (i = 0; i < usuarisOK; i++) {

                    //Printem la primera linea de la taula sempre i quan el tipus de venda que es consulta existeix a l'array 
                    //i ho fem només la primera vegada que es comprovi que això es cert
                    if (arraySellType[i] == consultarTipus) {
                        numOK = true;
                        if (numOK) {
                            System.out.println(MSG11);
                        }
                        System.out.print(arrayId[i] + MSG12 + arrayAge[i] + MSG12);
                        switch (arraySellType[i]) {
                            case 0:
                                System.out.print(MSG13 + MSG12);
                                break;
                            case 1:
                                System.out.print(MSG14 + MSG12);
                                break;
                            case 2:
                                System.out.print(MSG15 + MSG12);
                                break;
                            case 3:
                                System.out.print(MSG16 + MSG12 + MSG12);
                                break;
                            default:
                                System.out.print(MSG5 + MSG12 + MSG12);
                        }
                        System.out.print(arrayBuyImport[i] + MSG12 + arrayPhone[i]);
                        System.out.println();
                    }
                }
            }

            //Demanem si es vol un resum estadístic
            do {
                System.out.println(MSG19);
                numOK = sc.hasNextInt();
                if ((numOK)) {
                    consultar = sc.nextInt();
                } else {
                    System.out.print(MSG5);
                    sc.next();
                }
                if ((consultar < 0 || consultar > 1) && (numOK)) {
                    System.out.print(MSG5);
                    numOK = false;
                }
            } while (!numOK);

            //Continuem si es vol el resum estadístic
            if (consultar == 1) {

                //Printem els clients introduïts
                System.out.println(MSG20 + usuarisOK);

                //Calculem i printem mitjana d'edat
                for (i = 0; i < usuarisOK; i++) {
                    avgAge = avgAge + arrayAge[i];
                }
                System.out.println(MSG21 + (avgAge) / usuarisOK);

//                Per tal de saber quina quantitat hi ha de cada tipus de venda he fet un codi que crea un for segons la mida de tipus de venda que tinguem, 
//                que ja es present com una constant. Seguidament escaneja tot l'array de sellType i aprofita la variable ja feta servir anteriorment count per tal de 
//                contar quants tipus de venda d'aquest tipus (j) s'han trobat, un cop finalitzat es realitza un for per assegurar no printar cap tipus amb un 
//                count menor a zero i s'escull el text a printar segons un siwitch-case basat en j (osigui el nombre actual de sellType fins arribar a j < SELLTYPEMAX). 
//                D'aquesta manera aquest codi te una escalabilitat excelent ja que no fa us de variables o constants que no es facin servir ja de per si per com es 
//                demana el programa, es compacte. L'objectiu era fer-ho sense variables poc rellevants i fer-ho més eficient.
                System.out.println(MSG22);
                for (int j = 0; j <= SELLTYPEMAX; j++) {
                    count = 0;
                    for (i = 0; i < usuarisOK; i++) {
                        if (arraySellType[i] == j) {
                            count = count + 1;
                        }
                    }
                    if (count > 0) {
                        switch (j) {
                            case 0:
                                System.out.println(MSG13 + MSG23 + count);
                                break;
                            case 1:
                                System.out.println(MSG14 + MSG23 + count);
                                break;
                            case 2:
                                System.out.println(MSG15 + MSG23 + count);
                                break;
                            case 3:
                                System.out.println(MSG16 + MSG23 + count);
                                break;
                            default:
                                System.out.print(MSG5);
                        }
                    }
                }

                //Metodología similar al segment anterior per tal de fer un histograma
                System.out.println(MSG24);
                System.out.println(MSG25);
                for (int j = 0; j <= SELLTYPEMAX; j++) {
                    count = 0;
                    for (i = 0; i < usuarisOK; i++) {
                        if (arraySellType[i] == j) {
                            count = count + 1;
                        }
                    }
                    if (count > 0) {
                        switch (j) {
                            case 0:
                                System.out.print(MSG13 + MSG23 + MSG12);
                                for (i = 0; i < count; i++) {
                                    System.out.print("*");
                                }
                                break;
                            case 1:
                                System.out.print(MSG14 + MSG23 + MSG12);
                                for (i = 0; i < count; i++) {
                                    System.out.print("*");
                                }
                                break;
                            case 2:
                                System.out.print(MSG15 + MSG23 + MSG12);
                                for (i = 0; i < count; i++) {
                                    System.out.print("*");
                                }
                                break;
                            case 3:
                                System.out.print(MSG16 + MSG23 + MSG12 + MSG12);
                                for (i = 0; i < count; i++) {
                                    System.out.print("*");
                                }
                                break;
                            default:
                                System.out.print(MSG5);
                        }
                        System.out.println();
                    }
                }

                //Calculem l'import total acumulat
                for (i = 0; i < usuarisOK; i++) {
                    allImport = allImport + arrayBuyImport[i];
                }
                System.out.println(MSG26 + (allImport));
            }
        }
    }
}
