/* EXO17 : Avec PRINT & SCANNER : 
 * 
 * Créer un algo qui calcule les dépenses moyenne (en euros, en France) en carburant d'une voiture en fonction 
 * du type de carburant sur une distance en km. 
 * 
 * On consomme 6.5l / 100km pour l'essence
 * On consomme 5.5l / 100km pour le gazole
 * 
 * Les prix des carburants sont sur ce lien : https://carbu.com/france/prixmoyens
 * 
 * carburant par id
 * 
 * Gazole (B7) = 0
 * 
 * Sans Plomb 95 = 1
 * 
 * Sans Plomb 98 (E5) = 2
 * 
 *  *  * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Quel est le type de votre carburant ?
 * 
 * 0
 * 
 * Vous avez choisi : Gazole 
 * Quel est la distance à parcourir (en km) ?
 * 
 * 150
 * 
 * Pour 150 km, vous allez dépenser en moyenne 13.99€
 * 
 * /!\ ATTENTION : Le résultat doit être en décimal 2 chiffres après la virgules
 * 
*/
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class exo17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prix moyens au litre (exemple à adapter selon le lien fourni)
        // valeurs fictives à ajuster
        final double PRIX_GAZOLE = 1.26;   // en euros
        final double PRIX_SP95 = 1.52;
        final double PRIX_SP98 = 1.60;

        // Consommations (l / 100 km)
        final double CONSOMMATION_ESSENCE = 6.5;
        final double CONSOMMATION_GAZOLE = 5.5;

        System.out.println("Quel est le type de votre carburant ?");
        System.out.println("0 : Gazole (B7)");
        System.out.println("1 : Sans Plomb 95");
        System.out.println("2 : Sans Plomb 98 (E5)");

        int typeCarburant = -1;
        try {
            typeCarburant = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Type de carburant invalide !");
            scanner.close();
            return;
        }

        String carburantNom;
        double prixLitre = 0;
        double conso = 0;

        switch (typeCarburant) {
            case 0:
                carburantNom = "Gazole";
                prixLitre = PRIX_GAZOLE;
                conso = CONSOMMATION_GAZOLE;
                break;
            case 1:
                carburantNom = "Sans Plomb 95";
                prixLitre = PRIX_SP95;
                conso = CONSOMMATION_ESSENCE;
                break;
            case 2:
                carburantNom = "Sans Plomb 98";
                prixLitre = PRIX_SP98;
                conso = CONSOMMATION_ESSENCE;
                break;
            default:
                System.out.println("Type de carburant invalide !");
                scanner.close();
                return;
        }

        System.out.println("Vous avez choisi : " + carburantNom);

        System.out.println("Quel est la distance à parcourir (en km) ?");
        double distance = 0;
        try {
            distance = Double.parseDouble(scanner.nextLine().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Distance invalide !");
            scanner.close();
            return;
        }

        // Calcul de la dépense : (conso en L/100km) * distance / 100 * prix du litre
        double depense = (conso * distance / 100) * prixLitre;

        // Formatage avec 2 décimales et virgule
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.FRANCE);
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

        System.out.println("Pour " + (int)distance + " km, vous allez dépenser en moyenne " + df.format(depense) + "€");

        scanner.close();
    }
}