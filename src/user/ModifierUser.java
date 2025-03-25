package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModifierUser extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4947909569890578869L;

	public ModifierUser() {
        // Paramètres de la fenêtre de modification
        setTitle("Modifier le Profil");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel pour les champs de modification
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Nom:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JButton saveButton = new JButton("Sauvegarder");

        // Ajouter des éléments au panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(saveButton);

        // Ajouter le panel à la fenêtre
        add(panel, BorderLayout.CENTER);

        // Action pour le bouton de sauvegarde
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour sauvegarder les informations modifiées
                String name = nameField.getText();
                String email = emailField.getText();
                JOptionPane.showMessageDialog(ModifierUser.this, "Informations sauvegardées: \nNom: " + name + "\nEmail: " + email);
            }
        });

        // Afficher la fenêtre de modification
        setVisible(true);
    }

    public static void main(String[] args) {
        new ModifierUser();
    }
}
