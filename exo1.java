/* EXO1 : A l'aide de Scanner et Print, me faire afficher le résultat d'une addition de deux entiers        
 * 
 * 
* **********************AFFICHAGE ATTENDU ****************:
 * 
 * a = 2
 * b = 3
 * 
 * resultat = a + b
 * 
 * resulat vaut 5
 * 
 * 
 * 
*/



import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */

    /***--------Donner un nom à votre class -------------------****/

public class exo1 { /* ATTENTION LA CLASSE DOIT AVOIR LE MÊME NOM QUE LE FICHIER ! */


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

        clavier.close();

        /***--------  Fin du code  -------------------****/

    }

}