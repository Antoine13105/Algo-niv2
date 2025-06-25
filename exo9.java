/* EXO9 : La suite de l'EXO 8, une fois l'inscription terminé, essayez de vous connecter en donnant l'email et le mot de passe correspondant.
 * 
 * Si l'email ou le mot de passe n'est pas bon, vous affichez "connexion refusée"
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Votre prénom ?
 * 
 * Eudes
 * 
 * Votre nom ?
 * 
 * Konda
 * 
 * Votre adresse ?
 * 
 * ekonda@arfp.asso.fr
 * 
 * votre mot de passe ?
 * 
 * ekonda123&!
 * 
 * confirmer votre mot de passe ?
 * 
 * ekonda123&!
 * 
 * Merci Eudes KONDA , votre inscription a bien été effectuée, vous recevrez un mail de confirmation à l'adresse : ekonda@arfp.asso.fr
 * 
 * Pour vous connecter, renseignez votre email ?
 * 
 * ekonda@arfp.asso.fr
 * 
 * Renseignez votre mot de passe ?
 * 
 * ekonda123&!
 * 
 * 
 * 
*/


import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */


public class exo9 { /* Nom de la classe */

    public static void main(String[] args) { /* Toujours le mettre pour tester votre code */
        
        /***--------  Début du code  -------------------****/

        String firstname,lastname,email,password,confirmpassword,login; //  Déclaration d'une variable a de Type Texte */
        Scanner clavier = new Scanner(System.in); // Déclaration du scanner Instance de l'Objet Scanner 

        System.out.println("Votre prénom ?"); /* Afficher votre instruction */
    
        firstname = clavier.nextLine(); // Affection de la valeur Scanner tapé sur le clavier à la variable a

        System.out.println("Votre nom ?"); /* Afficher votre instruction */

        lastname = clavier.nextLine(); // Affection de la valeur Scanner tapé sur le clavier à la variable a

        System.out.println("Votre email ?"); /* Afficher votre instruction */

        email = clavier.nextLine(); // Affection de la valeur Scanner tapé sur le clavier à la variable a

        System.out.println("Votre mot de passe ?"); /* Afficher votre instruction */

        password = clavier.nextLine(); // Affection de la valeur Scanner tapé sur le clavier à la variable a

        System.out.println("Confirmez votre mot de passe ?"); /* Afficher votre instruction */

        confirmpassword = clavier.nextLine(); // Affection de la valeur Scanner tapé sur le clavier à la variable a

        if(!password.equals(confirmpassword)){ // Vérifier si les mots de passes ne sont pas identiques

            System.out.println("inscription annulée "); /* Afficher votre instruction */


        }else{

            System.out.println("Merci "+firstname+" "+lastname+", votre inscription a bien été effectuée, vous recevrez un mail de confirmation à l'adresse : "+email); /* Afficher votre instruction */
            System.out.println("Pour vous connecter, renseignez votre email ?"); /* Afficher votre instruction */
            login = clavier.nextLine();
            System.out.println("Renseignez votre mot de passe ?"); /* Afficher votre instruction */
            confirmpassword = clavier.nextLine();
             // des if dans un if c'est bien mais c'est pas PRO ! la prochaine fois on verra avec les méthodes

            if(confirmpassword.equals(password)){

                System.out.println("Connexion acceptée"); /* Afficher votre instruction */

            }else{

                System.out.println("Connexion refusée"); /* Afficher votre instruction */

            }
        }


        clavier.close();

      /***--------  Fin du code  -------------------****/

  }

}