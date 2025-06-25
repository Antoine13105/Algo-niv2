/* EXO7 : A l'aide de Scanner et Print, créer un questionnaire, "Do you speak english ?", répondre yes ou no, puis retourner le messages suivants 
 * 
 * si FALSE "So learn english !"
 * 
 * Si TRUE "Nice to meet you"
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Do you speak english (Y/N)?
 * 
 * Y (Tapez Y)
 * 
 * "Nice to meet you"
 * 
 * 
 * 
*/

import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */


public class exo7 { /* Nom de la classe */

    public static void main(String[] args) { /* Toujours le mettre pour tester votre code */

        /***--------  Début du code  -------------------****/


        String response; //  Déclaration d'une variable a de Type String */


        System.out.println("Do you speak english ?"); /* Afficher le message pour votre question */
          
          Scanner clavier = new Scanner(System.in); // Déclaration du scanner Instance de l'Objet Scanner 

          response = clavier.nextLine(); // Affection de la valeur Scanner tapé sur le clavier à la variable response

        if(response.equalsIgnoreCase(("y"))){

            System.out.println("Nice to meet you");

        }

        else if(response.equalsIgnoreCase(("n"))){

            System.out.println("So learn english !");

        }
        else{
            
        System.out.println("Erreur : Veuillez répondre par Y (oui) ou N (non)");

        }

        clavier.close();

      /***--------  Fin du code  -------------------****/

  }

}
