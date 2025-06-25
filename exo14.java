/* EXO14 : Avec PRINT & SCANNER : Tester l'expression algèbrique booléenne A OU B ET NON C
 * 
 * A , B ou C sont des booléens et ne peuvent être qu'égale à TRUE ou FALSE.
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Donner une valeur A OU B ET NON C
 * 
 * FALSE
 * TRUE
 * FALSE
 * 
 * Résultat : TRUE
 * 
 * 
 * 
 * 
 * 
*/
import java.util.Scanner;

public class exo14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Donner une valeur A OU B ET NON C");

        // Lecture des trois valeurs booléennes
        boolean A = Boolean.parseBoolean(scanner.nextLine());
        boolean B = Boolean.parseBoolean(scanner.nextLine());
        boolean C = Boolean.parseBoolean(scanner.nextLine());

        // Calcul de l'expression : A OU (B ET NON C)
        boolean resultat = A || (B && !C);

        // Affichage des valeurs saisies
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("C = " + C);

        // Affichage du résultat
        System.out.println("Résultat : " + resultat);

        scanner.close();
    }
}
