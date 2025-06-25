import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Aliment {
    String nom;
    String type;
    LocalDate dateFabrication;
    LocalDate datePeremption;
    double prixBase;

    public Aliment(String nom, String type, LocalDate fabrication, LocalDate peremption, double prixBase) {
        this.nom = nom;
        this.type = type;
        this.dateFabrication = fabrication;
        this.datePeremption = peremption;
        this.prixBase = prixBase;
    }

    public boolean estPerime() {
        return LocalDate.now().isAfter(datePeremption);
    }

    public boolean perimeBientot() {
        long joursRestants = ChronoUnit.DAYS.between(LocalDate.now(), datePeremption);
        return joursRestants <= 3 && joursRestants >= 0;
    }

    public boolean estConsommable() {
        return !estPerime();
    }

    public double getPrixActuel() {
        if (estPerime()) return 0.0;
        if (perimeBientot()) return prixBase * 0.8; // -20%
        return prixBase;
    }

    public String statut() {
        if (estPerime()) return "Périmée";
        if (perimeBientot()) return "Consommable (Périme bientôt !!!)";
        return "Consommable";
    }

    public void afficher(int index) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("(%d) Nom : %s\n", index, nom);
        System.out.printf("Type : %s | Date de fabrication : %s | Date de péremption : %s | %s\n",
                type, dateFabrication.format(fmt), datePeremption.format(fmt), statut());

        if (estPerime()) {
            System.out.println("Prix : Aucun (Article périmé)\n");
        } else {
            System.out.printf("Prix : %.2f€", getPrixActuel());
            if (perimeBientot()) System.out.print(" (Après réduction de 20%)");
            System.out.print("\n\n");
        }
    }
}

public class inventaire {
    static ArrayList<Aliment> stock = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static String[] typesAliments = {
        "Viande", "Légume", "Féculant", "Fruit", "Laitage",
        "Poisson", "Dessert", "Pâtisserie", "Boulangerie"
    };

    public static void ajouterProduit() {
        try {
            System.out.print("Nom : ");
            String nom = scanner.nextLine();

            System.out.println("Choisissez un type :");
            for (int i = 0; i < typesAliments.length; i++) {
                System.out.printf("(%d) %s\n", i, typesAliments[i]);
            }
            int typeIndex = Integer.parseInt(scanner.nextLine());
            if(typeIndex < 0 || typeIndex >= typesAliments.length){
                System.out.println("Type invalide.");
                return;
            }
            String type = typesAliments[typeIndex];

            System.out.print("Date de fabrication (AAAA-MM-JJ) : ");
            LocalDate fabrication = LocalDate.parse(scanner.nextLine());

            System.out.print("Date de péremption (AAAA-MM-JJ) : ");
            LocalDate peremption = LocalDate.parse(scanner.nextLine());

            if(peremption.isBefore(fabrication)) {
                System.out.println("La date de péremption doit être après la date de fabrication.");
                return;
            }

            System.out.print("Prix (€) : ");
            double prix = Double.parseDouble(scanner.nextLine());
            if(prix < 0) {
                System.out.println("Le prix ne peut pas être négatif.");
                return;
            }

            Aliment aliment = new Aliment(nom, type, fabrication, peremption, prix);
            stock.add(aliment);
            System.out.println("Produit ajouté avec succès.\n");
        } catch(Exception e) {
            System.out.println("Erreur lors de la saisie. Veuillez réessayer.\n");
        }
    }

    public static void supprimerProduit() {
        if(stock.isEmpty()){
            System.out.println("Aucun produit à supprimer.\n");
            return;
        }
        afficherProduits();
        System.out.print("Entrez l'index du produit à supprimer : ");
        try {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index < stock.size()) {
                stock.remove(index);
                System.out.println("Produit supprimé.\n");
            } else {
                System.out.println("Index invalide.\n");
            }
        } catch(Exception e){
            System.out.println("Saisie invalide.\n");
        }
    }

    public static void rechercherProduit() {
        System.out.print("Entrez le nom du produit à chercher : ");
        String nomRecherche = scanner.nextLine().toLowerCase();
        boolean trouve = false;
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).nom.toLowerCase().contains(nomRecherche)) {
                stock.get(i).afficher(i);
                trouve = true;
            }
        }
        if (!trouve) System.out.println("Aucun produit trouvé.\n");
    }

    public static void afficherProduits() {
        if (stock.isEmpty()) {
            System.out.println("Aucun produit dans l'inventaire.\n");
            return;
        }
        for (int i = 0; i < stock.size(); i++) {
            stock.get(i).afficher(i);
        }
    }

    public static void menu() {
        while (true) {
            System.out.println("========= MENU INVENTAIRE =========");
            System.out.println("(1) Afficher tous les produits");
            System.out.println("(2) Ajouter un produit");
            System.out.println("(3) Supprimer un produit");
            System.out.println("(4) Rechercher un produit");
            System.out.println("(0) Quitter");
            System.out.print("Choix : ");
            String choix = scanner.nextLine();

            switch (choix) {
                case "1": afficherProduits(); break;
                case "2": ajouterProduit(); break;
                case "3": supprimerProduit(); break;
                case "4": rechercherProduit(); break;
                case "0": System.out.println("Au revoir !"); return;
                default: System.out.println("Choix invalide.\n");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}