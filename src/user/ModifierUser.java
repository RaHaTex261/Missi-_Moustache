package user;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ModifierUser extends JFrame {
    private static final long serialVersionUID = 4947909569890578869L;

    public ModifierUser() {
        // Paramètres de la fenêtre de modification
        setTitle("Modifier le Profil");
        setSize(400, 400); // Augmenté pour ajouter des champs supplémentaires
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Positionne la fenêtre au centre de l'écran
        setResizable(false);

        // Panel pour les champs de modification
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 15, 15)); // 6 lignes, 2 colonnes, espacement entre les composants
        panel.setBackground(new Color(245, 245, 245)); // Couleur de fond douce (gris clair)

        // Création des labels et des champs
        JLabel nameLabel = new JLabel("Nom:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(new Color(60, 60, 60)); // Couleur des labels
        JTextField nameField = new JTextField();
        styleTextField(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        emailLabel.setForeground(new Color(60, 60, 60));
        JTextField emailField = new JTextField();
        styleTextField(emailField);

        JLabel passwordLabel = new JLabel("Mot de passe actuel:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setForeground(new Color(60, 60, 60));
        JPasswordField currentPasswordField = new JPasswordField();
        stylePasswordField(currentPasswordField);

        JLabel newPasswordLabel = new JLabel("Nouveau mot de passe:");
        newPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        newPasswordLabel.setForeground(new Color(60, 60, 60));
        JPasswordField newPasswordField = new JPasswordField();
        stylePasswordField(newPasswordField);

        JLabel confirmPasswordLabel = new JLabel("Confirmer le mot de passe:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        confirmPasswordLabel.setForeground(new Color(60, 60, 60));
        JPasswordField confirmPasswordField = new JPasswordField();
        stylePasswordField(confirmPasswordField);

     // Bouton de sauvegarde avec un peu de style amélioré
        JButton saveButton = new JButton("Enregistrer");
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.setBackground(new Color(0, 123, 255)); // Couleur bleue par défaut
        saveButton.setForeground(Color.WHITE); // Texte en blanc
        saveButton.setFocusPainted(false); // Supprime la bordure de focus
        saveButton.setOpaque(true);
        saveButton.setBorderPainted(false);
        saveButton.setMargin(new java.awt.Insets(10, 20, 10, 20)); // Espacement interne du bouton
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // Effet de survol : le bouton change de couleur lorsqu'on passe la souris dessus
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveButton.setBackground(new Color(0, 102, 204)); // Couleur légèrement plus foncée au survol
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveButton.setBackground(new Color(0, 123, 255)); // Retour à la couleur initiale
            }
        });


        // Ajouter des éléments au panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(currentPasswordField);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(new JLabel()); // Cellule vide pour l'alignement
        panel.add(saveButton);

        // Ajouter le panel à la fenêtre (au centre)
        add(panel);

        // Action pour le bouton de sauvegarde
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer les valeurs des champs
                String name = nameField.getText();
                String email = emailField.getText();
                String currentPassword = new String(currentPasswordField.getPassword());
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Vérification des champs
                if (name.isEmpty() || email.isEmpty() || currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(ModifierUser.this, "Tous les champs doivent être remplis !", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(ModifierUser.this, "Les mots de passe ne correspondent pas !", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Sauvegarder les informations et afficher un message de succès
                    JOptionPane.showMessageDialog(ModifierUser.this, "Informations sauvegardées: \nNom: " + name + "\nEmail: " + email);
                }
            }
        });

        // Afficher la fenêtre de modification
        setVisible(true);
    }
    
    

    // Méthode pour styliser les champs texte
    private void styleTextField(JTextField textField) {
        textField.setBackground(Color.WHITE);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Bordure douce
    }

    // Méthode pour styliser les champs mot de passe
    private void stylePasswordField(JPasswordField passwordField) {
        passwordField.setBackground(Color.WHITE);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Bordure douce
    }

    public static void main(String[] args) {
        new ModifierUser();
    }
}
