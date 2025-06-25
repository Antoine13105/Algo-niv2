import java.util.Scanner;

public class ListeVille {

    // Tableau des villes
    static String[] villes = {"Paris", "Londres", "Madrid", "Lisbonne", "Berlin"};

    // Tableau des messages de bienvenue
    static String[] messages = {
        "Bienvenue à Paris !",
        "Welcome to London !",
        "Bienvenido a Madrid !",
        "Bem-vindo a Lisboa !",
        "Willkommen in Berlin !"
    };

    // Méthode pour afficher la liste des villes
    public static void afficherVilles() {
        System.out.println("\nBonjour, quelle ville voulez-vous visiter ?");
        for (int i = 0; i < villes.length; i++) {
            System.out.println(i + " - " + villes[i]);
        }
    }

    // Méthode pour afficher le message de bienvenue
    public static void afficherBienvenue(int index) {
        if (index >= 0 && index < villes.length) {
            System.out.println(messages[index]);
        } else {
            System.out.println("Désolé, cette ville n'est pas sur la liste !");
        }
    }

    // Point d'entrée principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            afficherVilles();
            System.out.print("\nEntrez le numéro de la ville : ");
            try {
                int choix = Integer.parseInt(scanner.nextLine());
                afficherBienvenue(choix);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide !");
            }

            System.out.print("\nVoulez-vous visiter une autre ville ? (O/N) : ");
            String reponse = scanner.nextLine().trim().toUpperCase();
            if (!reponse.equals("O")) {
                continuer = false;
                System.out.println("\nVotre voyage est terminé :) !");
            }
        }

        scanner.close();
    }
}