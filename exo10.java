/* EXO10 : Créer un quizz de 5 questions, chaque question à deux réponses au choix VRAI OU FAUX, à chaque fois que vous répondez juste à une question vous gagnez un point
 * 
 * Après avoir répondez à vos 5 questions, vous avez le résultat final sur 5.
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Question 1 : L'informatique a besoin des mathématiques ? (V/F)
 * 
 * V
 * 
 * Question 2 : L'Algèbre de Boole a été inventé par Steve Jobs ? (V/F)
 * 
 * F
 * 
 * Question 3 : En numération, la base de 10 va de 0 à 10 ? (V/F)
 * 
 * F
 * 
 * Question 4 : Une table de vérité retourne l'expression algébrique (V/F)
 * 
 * V
 * 
 * Question 5 : Git permet de stocker à distance son travail (V/F)
 * 
 * 
 * V
 * 
 * 
 * Résultat du QUIZZ, vous avez 5 point(s) / 5
 * 
*/


import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */


public class exo10 { /* Nom de la classe */

    public static void main(String[] args) { /* Toujours le mettre pour tester votre code */

        /***--------  Début du code  -------------------****/


        boolean response1,response2,response3,response4,response5; //  Déclaration d'une variable a de Type Entier */
        int score = 0;
          
          Scanner clavier = new Scanner(System.in); // Déclaration du scanner Instance de l'Objet Scanner 
          System.out.println("Question 1 : Le Portugal a t-elle déjà été envahi par l'Espagne ? (Y/N)"); /* Afficher votre instruction */
             
          response1 = clavier.nextBoolean();

          if(!response1){

            score++; // Incrémentation c'est la même chose que score = score + 1
            System.out.println(" Bonne réponse : +1 point :) "); /* Afficher votre instruction */

             }else{

                System.out.println(" Mauvaise réponse :  0 point :( "); /* Afficher votre instruction */
             
            }

            System.out.println("Question 2 : Est ce que Louis XVI est le dernier roi de France ? (Y/N)"); /* Afficher votre instruction */
            response2 = clavier.nextBoolean();

            if(!response2){
                score++; // Incrémentation c'est la même chose que score = score + 1
                System.out.println(" Bonne réponse : +1 point :) "); /* Afficher votre instruction */
    
                 }else{
    
                    System.out.println(" Mauvaise réponse :  0 point :( "); /* Afficher votre instruction */
                 
                }


                System.out.println("Question 3 : la 5e république de France a été fondé en 1958 ? (Y/N)"); /* Afficher votre instruction */
                response3 = clavier.nextBoolean();
                
                if(response3){
                    score++; // Incrémentation c'est la même chose que score = score + 1
                    System.out.println(" Bonne réponse : +1 point :) "); /* Afficher votre instruction */
        
                     }else{
                        
                        System.out.println(" Mauvaise réponse :  0 point :( "); /* Afficher votre instruction */
                     
                    }

                /**** Ca se Répète */



          System.out.println("Score total :"+score+"/3"); /* Afficher votre instruction */
             



        clavier.close();

      /***--------  Fin du code  -------------------****/

  }

}