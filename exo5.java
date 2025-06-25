/* EXO5 : A l'aide de Scanner et Print, créer une équation  A multiplier par B diviser par C (tous types entiers) , récupérer le résultat et vérifier si elle inférieur ou supérieur à 10
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * equation = (EQUATION)
 * 
 * equation = 15
 * 
 * 
 * equation est superieur
 * 
*/

import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */

    /***--------Donner un nom à votre class -------------------****/

public class exo5 { /* ATTENTION LA CLASSE DOIT AVOIR LE MÊME NOM QUE LE FICHIER ! */


    public static void main(String[] args) { /* Toujours le mettre pour tester votre code */

          /***--------  Début du code  -------------------****/


          /* Déclaration des variables */
          double a;
          double b;
          double c;
          double equation;

          Scanner clavier = new Scanner(System.in); // Déclaration du scanner Instance de l'Objet Scanner 

          System.out.println("La valeur de a"); // Affiche un message
          a = clavier.nextDouble(); // On affecte une valeur Scanner de type entier à A
          System.out.println("La valeur de b");// Affiche un message
          b = clavier.nextDouble();// On affecte une valeur Scanner de type entier à B
          System.out.println("La valeur de c");// Affiche un message
          c = clavier.nextDouble();// On affecte une valeur Scanner de type entier à B


          equation = a*b/c; //calcul l'équation

          System.out.println("a x b / c= "+equation); /* Afficher votre instruction , concaténation pour la phrase dynamique */
           if(equation<10){ /* Condition où l'instruction est si la equation est inférieur à 10 */

          System.out.println("Le résultat est inférieur à 10"); /* VRAI */
  
        }else if(equation==10){ /* Si la première condition est fausse alors on lance cette condition */
  
          System.out.println("Le résultat est égale à 10"); /* VRAI */
  
        }     
        
        else{
  
          System.out.println("Le résultat est supérieur à 10"); /* FAUX */
  
        }
  



        clavier.close();

        /***--------  Fin du code  -------------------****/

    }

}
