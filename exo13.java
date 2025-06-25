/* EXO13 : Avec PRINT & SCANNER : Convertir du centimètre (Entier) au mètre (Double)
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Donner une taille en centimètre ?
 * 
 * 170
 * 
 * 170 cm vaut 1.70 m
 * 
 * 
 * 
 * 
 * 
*/

import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */

    /***--------Donner un nom à votre class -------------------****/

public class exo13 { /* ATTENTION LA CLASSE DOIT AVOIR LE MÊME NOM QUE LE FICHIER ! */


    public static void main(String[] args) { /* Toujours le mettre pour tester votre code */

          /***--------  Début du code  -------------------****/

          int cm; /*  Déclaration d'une variable de Type Entier */
          double m;

          Scanner clavier = new Scanner(System.in); // Déclaration du scanner Instance de l'Objet Scanner 

          System.out.println("Donner une taille en centimètre ?");

          cm = clavier.nextInt();  
          
          m = cm / 100.0; // Attention mettre 100.0 pour définir le résulat en décimal sans arrondir

          System.out.println(cm+" centimêtre en mêtre vaut :"+m); /* Afficher votre instruction */

        clavier.close();

        /***--------  Fin du code  -------------------****/

    }

}


