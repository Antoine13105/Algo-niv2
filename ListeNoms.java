import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListeNoms {

    // Fonction pour afficher la liste
    public static void afficherListe(List<String> liste) {
        System.out.println("Liste des noms :");
        for (String nom : liste) {
            System.out.println(nom);
        }
        System.out.println();
    }

    // Fonction pour supprimer un nom dans la liste s'il existe
    public static boolean supprimerNom(List<String> liste, String nomASupprimer) {
        Iterator<String> iterator = liste.iterator();
        while (iterator.hasNext()) {
            String nom = iterator.next();
            if (nom.equalsIgnoreCase(nomASupprimer)) {
                iterator.remove();
                return true;  // Nom supprimé
            }
        }
        return false;  // Nom non trouvé
    }

    public static void main(String[] args) {
        List<String> noms = new ArrayList<>();
        noms.add("jeremie");
        noms.add("Benjamin");
        noms.add("mamadou");
        noms.add("ilyana");

        afficherListe(noms);

        String nomAEnlever = "jeremie";
        if (supprimerNom(noms, nomAEnlever)) {
            System.out.println(nomAEnlever + " a été supprimé de la liste.\n");
        } else {
            System.out.println(nomAEnlever + " n'a pas été trouvé dans la liste.\n");
        }

        afficherListe(noms);
    }
}