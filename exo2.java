      /* EXO2 : A l'aide de Scanner et Print, me faire afficher le résultat d'une soustraction (types entiers) et vérifier si elle est inférieur à 0    
 * 
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * a = 2
 * b = 3
 * 
 * resultat = a - b
 * 
 * resultat = -1
 * 
 * resutat est inférieur à 0
 * 
 * 
 * 
 */

 
import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */

/***--------Donner un nom à votre class -------------------****/

public class exo2 { /* ATTENTION LA CLASSE DOIT AVOIR LE MÊME NOM QUE LE FICHIER ! */


public static void main(String[] args) { /* Toujours le mettre pour tester votre code */
      
      
      /***--------  Début du code  -------------------****/

          /* Déclaration des variables */
          int a;
          int b;
          int soustraction;

          Scanner clavier = new Scanner(System.in); // Déclaration du scanner Instance de l'Objet Scanner 

          System.out.println("La valeur de a"); // Affiche un message
          a = clavier.nextInt(); // On affecte une valeur Scanner de type entier à A
          System.out.println("La valeur de b");// Affiche un message
          b = clavier.nextInt();// On affecte une valeur Scanner de type entier à B

          soustraction = a-b; //calcul la différence

          System.out.println("a+b="+soustraction); /* Afficher votre instruction , concaténation pour la phrase dynamique */



      System.out.println("a-b="+soustraction); /* Afficher votre instruction */


      if(soustraction<10){ /* Condition où l'instruction est si la soustraction est inférieur à 10 */

        System.out.println("Le résultat est inférieur à 10"); /* VRAI */

      }else if(soustraction==10){ /* Si la première condition est fausse alors on lance cette condition */

        System.out.println("Le résultat est égale à 10"); /* VRAI */

      }     
      
      else{

        System.out.println("Le résultat est supérieur à 10"); /* FAUX */

      }

      
      clavier.close();

    /***--------  Fin du code  -------------------****/

}

}