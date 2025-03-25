package user;
/**
 * Classe principale de l'application de connexion.
 * 
 * Cette classe lance l'interface utilisateur de connexion en créant une instance
 * de la classe `LoginUser` et en la rendant visible. Elle définit également la taille
 * du cadre et le centre dans la fenêtre principale de l'écran.
 * 
 * @author Tex Beloha
 * @version 1.0
 */
public class LoginApp {

    /**
     * Méthode principale pour lancer l'application de connexion.
     * 
     * Cette méthode crée une instance de la fenêtre de connexion (`LoginUser`), 
     * l'affiche, ajuste sa taille automatiquement et la centre sur l'écran.
     * 
     * @param args Arguments en ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args) {
        LoginUser loginFrame = new LoginUser(); 
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }
}
