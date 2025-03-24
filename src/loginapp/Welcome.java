package loginapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Welcome extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    // Déclaration des composants de l'interface graphique
    private javax.swing.JButton btnDeletWelcome;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomUser;
    private javax.swing.JButton welcomLogOut;
    
    public String nom; // Stocke le nom de l'utilisateur connecté
    
    Connection con = null; // Connexion à la base de données
    PreparedStatement pst = null; // Requête SQL préparée
    
    public Welcome(String nom) {
        initComponents(); // Initialisation des composants UI
        this.nom = nom; // Stocke le nom passé en paramètre
        nomUser.setText(nom); // Affiche le nom de l'utilisateur
        con = DbConnection.connectionDB(); // Établit la connexion à la base de données
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomUser = new javax.swing.JLabel();
        welcomLogOut = new javax.swing.JButton();
        btnDeletWelcome = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true); // Supprime la bordure de la fenêtre

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/vnv_190px.png")));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 36));
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Welcome");

        nomUser.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
        nomUser.setForeground(new java.awt.Color(0, 102, 102));
        nomUser.setText("nom");

        // Bouton de déconnexion
        welcomLogOut.setBackground(new java.awt.Color(254, 254, 254));
        welcomLogOut.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14));
        welcomLogOut.setText("Log Out");
        welcomLogOut.addActionListener(evt -> welcomLogOutActionPerformed(evt));

        // Bouton de suppression du compte
        btnDeletWelcome.setBackground(new java.awt.Color(254, 254, 254));
        btnDeletWelcome.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14));
        btnDeletWelcome.setText("Delete Account");
        btnDeletWelcome.addActionListener(evt -> btnDeletWelcomeActionPerformed(evt));

        // Bouton de modification
        jButton3.setBackground(new java.awt.Color(254, 254, 254));
        jButton3.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14));
        jButton3.setText("Modify");
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));
    }

    // Méthode pour supprimer un compte utilisateur
    private void btnDeletWelcomeActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String sql = "DELETE FROM Accounts WHERE Email = ?;";
            pst = con.prepareStatement(sql);
            pst.setString(1, nom);
            pst.execute();
            JOptionPane.showMessageDialog(null, nom + " deleted successfully");
            
            con.close(); // Ferme la connexion
            this.dispose(); // Ferme la fenêtre actuelle
            
            // Redirection vers l'écran de connexion
            LoginUser login = new LoginUser();
            login.setVisible(true);
            login.pack();
            login.setLocationRelativeTo(null);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deletion failed: " + e.getMessage());
        }
    }

    // Méthode pour se déconnecter
    private void welcomLogOutActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose(); // Ferme la fenêtre actuelle
        
        LoginUser loginFrame = new LoginUser(); // Ouvre la page de connexion
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }

    // Méthode pour modifier un compte utilisateur
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        UpDate up = new UpDate(nom); // Ouvre la fenêtre de mise à jour du compte
        up.setVisible(true);
        up.pack();
        up.setLocationRelativeTo(null);
        this.dispose(); // Ferme la fenêtre actuelle
    }
}