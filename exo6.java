/* EXO6 : A l'aide de Scanner et Print, donnez moi votre prénom et votre âge, pour l'affichage sous la forme d'une phrase dynamique
 * 
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * prenom = "Eudes"
 * 
 * age = 32
 * 
 * Je m'appelle Eudes , j'ai 32 ans
 * 
 * 
 * 
*/

import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */

    /***--------Donner un nom à votre class -------------------****/

public class exo6 { /* ATTENTION LA CLASSE DOIT AVOIR LE MÊME NOM QUE LE FICHIER ! */


    public static void main(String[] args) { /* Toujours le mettre pour tester votre code */

          /***--------  Début du code  -------------------****/

          /* Déclaration des variables */
          String prenom;
          int age;


          Scanner clavier = new Scanner(System.in); // Déclaration du scanner Instance de l'Objet Scanner 

          System.out.println("Quel est votre prénom ?"); // Affiche un message
          prenom = clavier.nextLine(); // On affecte une valeur Scanner de type text à prénom
          System.out.println("Quel est votre âge");// Affiche un message
          age = clavier.nextInt();// On affecte une valeur Scanner de type entier à âge
          
          System.out.println("Bonjour, je m'appelle "+prenom+" j'ai "+age+" ans"); /* Afficher votre instruction , concaténation pour la phrase dynamique */

        clavier.close();

        /***--------  Fin du code  -------------------****/

    }

}
