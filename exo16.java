/* EXO16 : Avec PRINT & SCANNER : 
 * 
 * 
 * Me faire un algo qui change le prix d'un vol selon les paramètres suivants :
 * 
 * Réduction de 20% si le passager est mineur
 * 
 * Réduction de 40% si le passager est senior de plus 60 ans
 * 
 * Réduction de 20% si il y a plus de 60 places disponibles
 * 
 * Augmentation de 20% si il y a moins de 20 places disponibles
 * 
 * Augmentation de 20% si le passager a choisit la classe business 
 * 
 * -----Vous définisserez vous même le prix initial du vol, le nombre de place disponible, l'âge du voyageur
 * 
 * Si le voyageur a choisi une classe business
 * 
 * 
 *  * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Quel est l'âge de votre passager ?
 * 
 * 15
 * 
 * Le passager veut-il une classe business (oui/non) ?
 * 
 * oui
 * 
 * Le prix du vol :
 * 
 * 1200
 * 
 * Nombre de places disponibles :
 * 
 * 50
 * 
 * Le prix du vol est de 1200 euros
 * 
 * 
*/

import java.util.Scanner;

public class exo16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prix initial du vol (vous pouvez changer cette valeur)
        double prixInitial = 1200.0;

        System.out.println("Quel est l'âge de votre passager ?");
        int age = 0;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Âge invalide !");
            scanner.close();
            return;
        }

        System.out.println("Le passager veut-il une classe business (oui/non) ?");
        String businessInput = scanner.nextLine().trim().toLowerCase();
        boolean classeBusiness = businessInput.equals("oui");

        System.out.println("Le prix du vol :");
        double prixVol = 0;
        try {
            prixVol = Double.parseDouble(scanner.nextLine().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Prix invalide !");
            scanner.close();
            return;
        }

        System.out.println("Nombre de places disponibles :");
        int placesDisponibles = 0;
        try {
            placesDisponibles = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Nombre de places invalide !");
            scanner.close();
            return;
        }

        double prixFinal = prixVol;

        // Appliquer les réductions selon l'âge
        if (age < 18) {
            prixFinal *= 0.8; // -20%
        } else if (age > 60) {
            prixFinal *= 0.6; // -40%
        }

        // Appliquer la réduction ou augmentation selon le nombre de places disponibles
        if (placesDisponibles > 60) {
            prixFinal *= 0.8; // -20%
        } else if (placesDisponibles < 20) {
            prixFinal *= 1.2; // +20%
        }

        // Augmentation de 20% si classe business
        if (classeBusiness) {
            prixFinal *= 1.2;
        }

        // Affichage du résultat avec 2 décimales
        System.out.printf("Le prix du vol est de %.2f euros%n", prixFinal);

        scanner.close();
    }
}