/* EXO4 : A l'aide de Scanner et Print, tester si une valeur(type entier) est divisible par 2   
 * 
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * 
 * a = 14
 * 
 * 
 * a est bien divisible par 2
 * 
 * 
*/



import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */

    /***--------Donner un nom à votre class -------------------****/

public class exo4 { /* ATTENTION LA CLASSE DOIT AVOIR LE MÊME NOM QUE LE FICHIER ! */


    public static void main(String[] args) { /* Toujours le mettre pour tester votre code */

          /***--------  Début du code  -------------------****/


          /* Déclaration des variables */
          int a;

          Scanner clavier = new Scanner(System.in); // Déclaration du scanner Instance de l'Objet Scanner 

          System.out.println("La valeur de a"); // Affiche un message
          a = clavier.nextInt(); // On affecte une valeur Scanner de type entier à A

        if(a%2==0){ // Modulo permet de retourner le reste d'une division, 
        //donc là on retourne le reste de la division par 2, donc si le reste est égale
        // à 0 donc a est divisible par 2 sinon il ne l'est pas.

            System.out.println(a+" est divisible par 2");
        }else{
  System.out.println(a+" n'est pas divisible par 2");
        }


        clavier.close();

        /***--------  Fin du code  -------------------****/

    }

}
