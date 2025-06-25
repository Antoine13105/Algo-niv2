/* EXO20 : Avec PRINT & SCANNER : 
 * 
 * Vous allez créer un algo de sondage pour des élections, 
 * la candidate Joseline Inutile et le candidat Vincent Escreau pour la mairie de Mulhouse.
 * Vous avez 150 000 votants, donnez le nombre de votant pour Escreau et pour Inutile, et le nombre de vote blanc
 * Si le total des votes n'est pas atteint, les votes manquants seront comptés blanc
 * Si le total de vote est supérieur aux nombres de votants alors il y a une erreur
 * Puis calculez en pourcentage en fonction du nombres de votants ( ceux qui n'ont pas voter blanc)
 * Le score en pourcentage, le gagnant doit avoir plus de 60% sinon il devra y avoir un second tour :
 * 
 *  *  * **********************AFFICHAGE ATTENDU ****************:
 * 
* Combien de gens ont voté pour Joseline Inutile ?
 * 
 * 100 000
 * 
* Combien de gens ont voté pour Vincent Escreau ?
 * 
 * 20 000
 * 
* Vous avez 30 000 d'abstentions, ils seront compté nul
 * 
 * 
 * Joseline Inutile : 66.7%
 * 
 * Vincent Escreau : 33.3%
 * 
 * 
 * Joseline Inutile est la nouvelle maire de Mulhouse
 * 
 * 
*/
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class exo20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int totalVotants = 150000;

        System.out.println("Combien de gens ont voté pour Joseline Inutile ?");
        int votesInutile = lireEntier(scanner);

        System.out.println("Combien de gens ont voté pour Vincent Escreau ?");
        int votesEscreau = lireEntier(scanner);

        int totalVotes = votesInutile + votesEscreau;

        if (totalVotes > totalVotants) {
            System.out.println("Erreur : le total des votes dépasse le nombre de votants !");
            scanner.close();
            return;
        }

        int votesAbstention = totalVotants - totalVotes;
        System.out.println("Vous avez " + formatNombre(votesAbstention) + " d'abstentions, ils seront comptés nul");

        // Calcul des pourcentages sur les votes exprimés (hors blancs/abstentions)
        double totalExprimes = votesInutile + votesEscreau;

        double pctInutile = 0;
        double pctEscreau = 0;

        if (totalExprimes > 0) {
            pctInutile = (votesInutile * 100.0) / totalExprimes;
            pctEscreau = (votesEscreau * 100.0) / totalExprimes;
        }

        // Formatage des pourcentages à 1 décimale
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.FRANCE);
        DecimalFormat df = new DecimalFormat("0.0", symbols);

        System.out.println();
        System.out.println("Joseline Inutile : " + df.format(pctInutile) + "%");
        System.out.println("Vincent Escreau : " + df.format(pctEscreau) + "%");
        System.out.println();

        // Détermination du gagnant ou second tour
        if (pctInutile > 60) {
            System.out.println("Joseline Inutile est la nouvelle maire de Mulhouse");
        } else if (pctEscreau > 60) {
            System.out.println("Vincent Escreau est le nouveau maire de Mulhouse");
        } else {
            System.out.println("Il y aura un second tour !");
        }

        scanner.close();
    }

    // Méthode pour lire un entier avec gestion simple d'erreur
    private static int lireEntier(Scanner scanner) {
        int valeur = -1;
        while (valeur < 0) {
            try {
                String input = scanner.nextLine().replace(" ", "");
                valeur = Integer.parseInt(input);
                if (valeur < 0) {
                    System.out.println("Veuillez entrer un nombre positif ou nul :");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide, veuillez entrer un nombre entier :");
            }
        }
        return valeur;
    }

    // Méthode pour formater les nombres avec un espace tous les 3 chiffres
    private static String formatNombre(int nombre) {
        return String.format("%,d", nombre).replace(',', ' ');
    }
}
