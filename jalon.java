import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class jalon {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "avengers123";
    private static List<Vol> vols = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (!authentifierUtilisateur()) {
            System.out.println("Échec de l'authentification. Arrêt du programme.");
            return;
        }

        boolean quitter = false;
        while (!quitter) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    creerVol();
                    break;
                case 2:
                    listerVols();
                    break;
                case 3:
                    quitter = true;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }

        System.out.println("Merci d'avoir utilisé le système de réservation AIRMESS!");
    }

    private static boolean authentifierUtilisateur() {
        System.out.println("=== Connexion à AIRMESS ===");
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }
    
    private static void afficherMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Créer un nouveau vol");
        System.out.println("2. Lister tous les vols");
        System.out.println("3. Quitter");
        System.out.print("Votre choix: ");
    }

    private static void creerVol() {
        System.out.println("\n=== Création d'un nouveau vol ===");

        System.out.print("Ville de départ: ");
        String villeDepart = scanner.nextLine();
        System.out.print("Pays de départ: ");
        String paysDepart = scanner.nextLine();

        System.out.print("Ville d'arrivée: ");
        String villeArrivee = scanner.nextLine();
        System.out.print("Pays d'arrivée: ");
        String paysArrivee = scanner.nextLine();

        System.out.print("Date et heure de départ (AAAA-MM-JJ HH:MM): ");
        String dateHeureDepartStr = scanner.nextLine();
        LocalDateTime dateHeureDepart = LocalDateTime.parse(dateHeureDepartStr.replace(" ", "T"));

        System.out.print("Durée du vol (heures:minutes): ");
        String dureeStr = scanner.nextLine();
        String[] dureeParts = dureeStr.split(":");
        int heures = Integer.parseInt(dureeParts[0]);
        int minutes = Integer.parseInt(dureeParts[1]);
        long dureeMinutes = heures * 60 + minutes;

        System.out.print("Nombre de places (80-200): ");
        int nbPlaces = Integer.parseInt(scanner.nextLine());

        System.out.print("Prix initial du vol: ");
        double prixInitial = Double.parseDouble(scanner.nextLine());

        Vol nouveauVol = new Vol(villeDepart, paysDepart, villeArrivee, paysArrivee, 
                               dateHeureDepart, dureeMinutes, nbPlaces, prixInitial);
        vols.add(nouveauVol);

        System.out.println("Vol créé avec succès!");
    }

    private static void listerVols() {
        if (vols.isEmpty()) {
            System.out.println("Aucun vol disponible.");
            return;
        }

        System.out.println("\n=== LISTE DES VOLS ===");
        for (int i = 0; i < vols.size(); i++) {
            System.out.println("Vol #" + (i + 1));
            System.out.println(vols.get(i));
            System.out.println("----------------------");
        }
    }
}

class Vol {
    private String villeDepart;
    private String paysDepart;
    private String villeArrivee;
    private String paysArrivee;
    private LocalDateTime dateHeureDepart;
    private long dureeMinutes;
    private int nbPlaces;
    private double prixInitial;
    private double prixFinal;

    public Vol(String villeDepart, String paysDepart, String villeArrivee, String paysArrivee,
              LocalDateTime dateHeureDepart, long dureeMinutes, int nbPlaces, double prixInitial) {
        this.villeDepart = villeDepart;
        this.paysDepart = paysDepart;
        this.villeArrivee = villeArrivee;
        this.paysArrivee = paysArrivee;
        this.dateHeureDepart = dateHeureDepart;
        this.dureeMinutes = dureeMinutes;
        this.nbPlaces = nbPlaces;
        this.prixInitial = prixInitial;
        this.prixFinal = calculerPrixFinal();
    }

    private double calculerPrixFinal() {
        double prix = prixInitial;
        
        // Application des règles de date
        LocalDateTime maintenant = LocalDateTime.now();
        long joursAvantDepart = ChronoUnit.DAYS.between(maintenant, dateHeureDepart);
        
        if (joursAvantDepart < 7) {
            prix *= 1.4; // Augmentation de 40%
        } else if (joursAvantDepart > 180) { // 6 mois ≈ 180 jours
            prix *= 0.6; // Réduction de 40%
        }
        
        // Application des règles de places
        if (nbPlaces >= 150) {
            prix *= 0.9; // Réduction de 10%
        } else if (nbPlaces < 100) {
            prix *= 1.1; // Augmentation de 10%
        }
        
        return Math.round(prix * 100.0) / 100.0; // Arrondi à 2 décimales
    }

    public LocalDateTime getDateHeureArrivee() {
        return dateHeureDepart.plusMinutes(dureeMinutes);
    }

    public String getDureeFormatee() {
        long heures = dureeMinutes / 60;
        long minutes = dureeMinutes % 60;
        return String.format("%dh%02dm", heures, minutes);
    }

    @Override
    public String toString() {
        return "Départ: " + villeDepart + ", " + paysDepart + "\n" +
               "Arrivée: " + villeArrivee + ", " + paysArrivee + "\n" +
               "Date et heure de départ: " + dateHeureDepart + "\n" +
               "Durée du vol: " + getDureeFormatee() + "\n" +
               "Date et heure d'arrivée: " + getDateHeureArrivee() + "\n" +
               "Nombre de places: " + nbPlaces + "\n" +
               "Prix initial: " + prixInitial + " €\n" +
               "Prix final (après ajustements): " + prixFinal + " €";
    }

    // Getters
    public String getVilleDepart() { return villeDepart; }
    public String getPaysDepart() { return paysDepart; }
    public String getVilleArrivee() { return villeArrivee; }
    public String getPaysArrivee() { return paysArrivee; }
    public LocalDateTime getDateHeureDepart() { return dateHeureDepart; }
    public long getDureeMinutes() { return dureeMinutes; }
    public int getNbPlaces() { return nbPlaces; }
    public double getPrixInitial() { return prixInitial; }
    public double getPrixFinal() { return prixFinal; }
}