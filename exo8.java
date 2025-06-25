/* EXO8 : A l'aide de Scanner et Print, créer un formulaire d'inscription, où on vous demande de renseignez, votre prénom, votre nom, adresse email,
 *  mot de passe et confirmer votre mot de passe (ils doivent être identiques). Si les mots de passes ne sont pas identiques, ceci affiche "inscription annulée"
 * Sinon vous affichez le message suivant ci-dessous :
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
 * Votre adresse email ?
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
*/

import java.util.Scanner; /* Importation de la bibliothèque Java Scanner */


public class exo8 { /* Nom de la classe */

    public static void main(String[] args) { /* Toujours le mettre pour tester votre code */

        /***--------  Début du code  -------------------****/

        String firstname,lastname,email,password,confirmpassword; //  Déclaration d'une variable a de Type Texte */
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

        }

        clavier.close();

      /***--------  Fin du code  -------------------****/

  }

}