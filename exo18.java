/* EXO18 : Avec PRINT & SCANNER : 
 * 
 * 
 * Vous souvenez de l'exercice d'algèbre de Boole de la banque ? Une banque vous accorde un prêt immobilier 
 * si vous répondez aux critères suivants :
 * 
 * condition 1 : Avoir un CDI avec un salaire de plus 3000€
 * 
 * condition 2 : Avoir un apport de 25% de la somme demandé
 * 
 * condition 3 (Si la condition 1 n'est pas rempli ) : Avoir une autre propriété 
 * valant minimum 75% du prêt demandé
 * 
 * 
 *  *  * **********************AFFICHAGE ATTENDU ****************:
 * 
    * Quel est le montant de votre prêt ?
 * 
 * 150000
 * 
 * Êtes-vous en CDI ?
 * 
 * TRUE
 * 
 * Combien avez-vous d'abord ?
 * 
 * 1500
 * 
 * Vous ne pouvez pas hélas obtenir de prêt !

 * 
*/
import java.util.Scanner;

public class exo18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel est le montant de votre prêt ?");
        double montantPret = 0;
        try {
            montantPret = Double.parseDouble(scanner.nextLine().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Montant invalide !");
            scanner.close();
            return;
        }

        System.out.println("Êtes-vous en CDI ? (TRUE/FALSE)");
        boolean estCDI = false;
        String cdiInput = scanner.nextLine().trim().toUpperCase();
        if (cdiInput.equals("TRUE")) {
            estCDI = true;
        } else if (cdiInput.equals("FALSE")) {
            estCDI = false;
        } else {
            System.out.println("Réponse invalide !");
            scanner.close();
            return;
        }

        System.out.println("Combien avez-vous d'abord ?");
        double apport = 0;
        try {
            apport = Double.parseDouble(scanner.nextLine().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Montant invalide !");
            scanner.close();
            return;
        }

        // Si condition 1 est remplie (CDI + salaire > 3000) : on a besoin salaire (non demandé dans l'exo)
        // Dans l'exo, le salaire n'est pas demandé, on suppose que CDI seul ne suffit pas
        // Donc on adapte et pose question salaire aussi :

        // Pour coller à l'énoncé, on demande aussi le salaire
        System.out.println("Quel est votre salaire ?");
        double salaire = 0;
        try {
            salaire = Double.parseDouble(scanner.nextLine().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Salaire invalide !");
            scanner.close();
            return;
        }

        // Vérification condition 1 : CDI + salaire > 3000
        boolean condition1 = estCDI && (salaire > 3000);

        // Vérification condition 2 : apport >= 25% du prêt
        boolean condition2 = apport >= (0.25 * montantPret);

        // Condition 3 (si condition1 fausse) : avoir une autre propriété valant au moins 75% du prêt
        boolean condition3 = false;
        if (!condition1) {
            System.out.println("Avez-vous une autre propriété valant au moins 75% du prêt demandé ? (TRUE/FALSE)");
            String propInput = scanner.nextLine().trim().toUpperCase();
            if (propInput.equals("TRUE")) {
                condition3 = true;
            } else if (propInput.equals("FALSE")) {
                condition3 = false;
            } else {
                System.out.println("Réponse invalide !");
                scanner.close();
                return;
            }
        }

        // Validation finale :
        // La banque accorde le prêt si :
        // condition 1 + condition 2 sont vraies
        // OU
        // (condition 1 fausse) et (condition 3 vraie)

        boolean pretAccorde = (condition1 && condition2) || (!condition1 && condition3);

        if (pretAccorde) {
            System.out.println("Félicitations, votre prêt est accordé !");
        } else {
            System.out.println("Vous ne pouvez pas hélas obtenir de prêt !");
        }

        scanner.close();
    }
}