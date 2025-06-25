/* EXO12 : Avec PRINT & Scanner , vous allez me créer un algo 
 * qui applique une réduction (en pourcentage %) sur un prix (en décimal) donnée :
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Votre prix ?
 * 
 * 100.00
 * 
 * Votre réduction (en pourcentage %) ?
 * 
 * 20
 * 
 * 
 * Prix après réduction de 20% :
 * 
 * 80.00
 * 
 * 
 * 
*/

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class exo12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Votre prix ?");
        double prix = 0;
        try {
            prix = Double.parseDouble(scanner.nextLine().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Prix invalide !");
            scanner.close();
            return;
        }

        System.out.println("Votre réduction (en pourcentage %) ?");
        double reduction = 0;
        try {
            reduction = Double.parseDouble(scanner.nextLine().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Pourcentage invalide !");
            scanner.close();
            return;
        }

        double prixReduit = prix * (1 - reduction / 100);

        // Formatage avec 2 décimales et virgule
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.FRANCE);
        DecimalFormat df = new DecimalFormat("#0.00", symbols);

        System.out.println();
        System.out.println("Prix après réduction de " + reduction + "% :");
        System.out.println(df.format(prixReduit));

        scanner.close();
    }
}