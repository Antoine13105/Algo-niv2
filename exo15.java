/* EXO15 : Avec PRINT & SCANNER : Me créer un convertisseur de devise, Euros , Dollars et Livres Sterling
 * 
 * Vous devriez choisir votre devise en entrée et la devise en sortie
 * 
 * Attention on ne peut pas convertir les deux même devise !
 * 
 * EUR : Euros
 * USD : Dollars
 * GBP : Livres Sterling
 * 
 * le lien ci-dessous vous donne la valeur des monnaies : https://www.boursorama.com/bourse/devises
 * 
 * ATTENTION ! : Montant doivent être décimaux , 2 chiffres après la virgule.
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * 
 * Quel est votre monnaie ?
 * 
 * EUR
 * 
 * Quel est votre montant ?
 * 
 * 100.00
 * 
 * Vous voulez la convertir en quelle devise ?
 * 
 * USD
 * 
 * Résultat : 113,82 USD
 * 
 * 
*/
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class exo15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taux de change (exemple, à actualiser selon le site)
        // 1 EUR = 1.1382 USD, 1 EUR = 0.8792 GBP (valeurs fictives à ajuster)
        final double EUR_TO_USD = 1.1382;
        final double EUR_TO_GBP = 0.8792;

        System.out.println("Quel est votre monnaie ?");
        String deviseEntree = scanner.nextLine().toUpperCase();

        // Vérifier devise entrée correcte
        if (!deviseEntree.equals("EUR") && !deviseEntree.equals("USD") && !deviseEntree.equals("GBP")) {
            System.out.println("Devise non reconnue !");
            scanner.close();
            return;
        }

        System.out.println("Quel est votre montant ?");
        double montant = 0;
        try {
            montant = Double.parseDouble(scanner.nextLine().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Montant invalide !");
            scanner.close();
            return;
        }

        System.out.println("Vous voulez la convertir en quelle devise ?");
        String deviseSortie = scanner.nextLine().toUpperCase();

        // Vérifier devise sortie correcte et différente de l'entrée
        if (!deviseSortie.equals("EUR") && !deviseSortie.equals("USD") && !deviseSortie.equals("GBP")) {
            System.out.println("Devise non reconnue !");
            scanner.close();
            return;
        }

        if (deviseSortie.equals(deviseEntree)) {
            System.out.println("La devise d'entrée et de sortie doivent être différentes !");
            scanner.close();
            return;
        }

        // Conversion : d'abord on convertit en EUR puis vers la devise finale
        double montantEnEur;

        switch (deviseEntree) {
            case "EUR":
                montantEnEur = montant;
                break;
            case "USD":
                montantEnEur = montant / EUR_TO_USD;
                break;
            case "GBP":
                montantEnEur = montant / EUR_TO_GBP;
                break;
            default:
                montantEnEur = 0; // cas théorique
        }

        double montantConverti;

        switch (deviseSortie) {
            case "EUR":
                montantConverti = montantEnEur;
                break;
            case "USD":
                montantConverti = montantEnEur * EUR_TO_USD;
                break;
            case "GBP":
                montantConverti = montantEnEur * EUR_TO_GBP;
                break;
            default:
                montantConverti = 0; // cas théorique
        }

        // Formatage avec 2 décimales et virgule
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.FRANCE);
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

        System.out.println("Résultat : " + df.format(montantConverti) + " " + deviseSortie);

        scanner.close();
    }
}