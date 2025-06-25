/* EXO3 : A l'aide de Scanner et Print, me faire afficher le résultat d'une addition (types entiers) et vérifier si elle est pair ou impaire     
 * 
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * 
 * a = 2
 * b = 3
 * 
 * resultat = a + b
 * 
 * resultat = 5
 * 
 * resultat est impaire
 * 
 * 
 * 
*/


import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */

    /***--------Donner un nom à votre class -------------------****/

public class exo3 { /* ATTENTION LA CLASSE DOIT AVOIR LE MÊME NOM QUE LE FICHIER ! */


    public static void main(String[] args) { /* Toujours le mettre pour tester votre code */

          /***--------  Début du code  -------------------****/


          /* Déclaration des variables */
          int a;
          int b;
          int addition;

          Scanner clavier = new Scanner(System.in); // Déclaration du scanner Instance de l'Objet Scanner 

          System.out.println("La valeur de a"); // Affiche un message
          a = clavier.nextInt(); // On affecte une valeur Scanner de type entier à A
          System.out.println("La valeur de b");// Affiche un message
          b = clavier.nextInt();// On affecte une valeur Scanner de type entier à B
             addition = a+b; //calcul la somme

          System.out.println("a+b= "+addition); /* Afficher votre instruction , concaténation pour la phrase dynamique */

        if(addition%2==0){ // Modulo permet de retourner le reste d'une division, 
        //donc là on retourne le reste de la division par 2, donc si le reste est égale
        // à 0 donc le résultat est pair sinon il sera impair.

            System.out.println(addition+" est pair");
        }else{

            System.out.println(addition+" est impair");
        }


        clavier.close();

        /***--------  Fin du code  -------------------****/

    }

}