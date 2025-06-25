/* EXO19 : Avec PRINT & SCANNER : 
 * 
 * 
 * Me créer un convertisseur de secondes au format heures : minutes : secontes
 * 
 * 
 * 
 *  *  * **********************AFFICHAGE ATTENDU ****************:
 * 
* Combien de secondes ?
 * 
 * 156000
 * 
 * 156 000 secondes correspond à 43 heures, 20 minutes et 0 seconde
 * 
 * 
 * 
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class exo19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Combien de secondes ?");
        int totalSecondes = 0;
        try {
            totalSecondes = Integer.parseInt(scanner.nextLine().replace(" ", ""));
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide !");
            scanner.close();
            return;
        }

        int heures = totalSecondes / 3600;
        int resteSecondes = totalSecondes % 3600;
        int minutes = resteSecondes / 60;
        int secondes = resteSecondes % 60;

        // Formatage du nombre total de secondes avec espace comme séparateur de milliers
        DecimalFormat df = new DecimalFormat("#,###");
        String secondesFormat = df.format(totalSecondes).replace(',', ' ');

        System.out.println(secondesFormat + " secondes correspond à " + heures + " heures, " + minutes + " minutes et " + secondes + " seconde" + (secondes > 1 ? "s" : ""));
        
        scanner.close();
    }
}
