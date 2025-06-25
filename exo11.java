/* EXO11 : Avec PRINT & Scanner , vous allez simuler un distributeur de banque :
 * 
 * Vous avez 3000€ sur votre compte, créer un algo qui retire un montant sur votre compte banquaire
 * votre solde ne peut pas être négatif
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Bonjour, combien voulez-vous retirer ?
 * 
 * 3500
 * 
 * Opération refusée, fond insuffissant !
 * 
 * 
*/
import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */

    /***--------Donner un nom à votre class -------------------****/

public class exo11 { /* ATTENTION LA CLASSE DOIT AVOIR LE MÊME NOM QUE LE FICHIER ! */


    public static void main(String[] args) { /* Toujours le mettre pour tester votre code */

          int solde = 3000; /*  Déclaration d'une variable de Type Entier */

          int retrait; /*  Déclaration d'une variable de Type Entier */

          Scanner clavier = new Scanner(System.in); /* Déclaration du scanner Instance de l'Objet Scanner */ 

          System.out.println("Bonjour, combien voulez-vous retirer ?"); /* Afficher votre instruction */
          
          retrait = clavier.nextInt(); 

          if(retrait > solde){

           
          System.out.println("Opération refusée, fond insuffissant !"); /* Afficher votre instruction */
           

          }else{

            solde -= retrait;

            System.out.println("Opération accepté votre solde restant est de "+solde+" euros"); /* Afficher votre instruction */
           
          }

          clavier.close();

        /***--------  Fin du code  -------------------****/

    }

}

