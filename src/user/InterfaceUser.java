package user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class InterfaceUser extends JFrame {
    private static final long serialVersionUID = 8158150333830397406L;
    
    /**
     * Zone de texte pour afficher les messages du chat.
     */
    private JTextArea chatArea;
    
    /**
     * Champ de texte pour saisir les messages à envoyer.
     */
    private JTextField messageField;

    /**
     * Constructeur principal qui initialise l'interface du chat.
     * Configure la fenêtre, les panneaux et tous les composants UI.
     * @param string 
     */
    public InterfaceUser(String string) {
        setTitle("Chat Application");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        
        // ================== Panel Gauche (Liste des contacts) ==================
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(30, 144, 255));
        leftPanel.setPreferredSize(new Dimension(300, getHeight())); // Augmenté à 300px
        
        // Barre de recherche
        JTextField searchField = new JTextField("Search...");
        searchField.setPreferredSize(new Dimension(300, 30));
        leftPanel.add(searchField, BorderLayout.NORTH);
        
        // Liste des contacts
        DefaultListModel<String> contactsModel = new DefaultListModel<>();
        contactsModel.addElement("Teddy");
        contactsModel.addElement("Test");
        contactsModel.addElement("Test1");
        contactsModel.addElement("Test2");
        contactsModel.addElement("David");
        JList<String> contactList = new JList<>(contactsModel);
        contactList.setBackground(new Color(200, 220, 255));
        JScrollPane scrollPane = new JScrollPane(contactList);
        leftPanel.add(scrollPane, BorderLayout.CENTER);
        
        // ============ Panel utilisateur en bas ============
        JPanel bottomLeftPanel = new JPanel(new BorderLayout());
        bottomLeftPanel.setPreferredSize(new Dimension(250, 50));
        bottomLeftPanel.setBackground(new Color(50, 130, 200)); // Couleur de fond
        
        // Nom de l'utilisateur
        JLabel userLabel = new JLabel("👤 Nom Utilisateur");
        userLabel.setForeground(Color.WHITE);
        userLabel.setHorizontalAlignment(SwingConstants.LEFT);
        userLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        
        // Bouton du menu
        JButton menuButton = new JButton("⚙️");
        menuButton.setPreferredSize(new Dimension(50, 30));
        
        // Menu déroulant
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem settingsItem = new JMenuItem("⚙️ Options");
        JMenuItem logoutItem = new JMenuItem("🚪 Déconnexion");
        popupMenu.add(settingsItem);
        popupMenu.add(logoutItem);
        
        // Action pour afficher le menu au clic du bouton
        menuButton.addActionListener(e -> popupMenu.show(menuButton, 0, menuButton.getHeight()));
        
        // Ajout des éléments au panel utilisateur
        bottomLeftPanel.add(userLabel, BorderLayout.CENTER);
        bottomLeftPanel.add(menuButton, BorderLayout.EAST);
        
        // Ajout du panel utilisateur en bas du leftPanel
        leftPanel.add(bottomLeftPanel, BorderLayout.SOUTH);
        
        // ================== Panel Droite (Zone de chat) ==================
        JPanel chatPanel = new JPanel(new BorderLayout());
        
        // Zone des messages
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(Color.WHITE);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatPanel.add(chatScrollPane, BorderLayout.CENTER);
        
        // ================== Panel Haut (Boutons d'action) ==================
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        // Ajouter les boutons directement au panneau
        topPanel.add(new JButton("📞 Appel Vocal"));
        topPanel.add(new JButton("📹 Appel Vidéo"));
        chatPanel.add(topPanel, BorderLayout.NORTH);
        
        // ================== Bas : Saisie message ==================
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        // Sous-panel pour les boutons (Emoji + Image)
        JPanel leftButtonsPanel = new JPanel();
        leftButtonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JButton emojiButton = new JButton("😊");
        JButton imageButton = new JButton("📸");
        JButton vocalButton = new JButton("V");
        leftButtonsPanel.add(emojiButton);
        leftButtonsPanel.add(imageButton);
        leftButtonsPanel.add(vocalButton);
        
        // Champ de message + Bouton d'envoi
        messageField = new JTextField();
        JButton sendButton = new JButton("Envoyer");
        inputPanel.add(leftButtonsPanel, BorderLayout.WEST);
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        chatPanel.add(inputPanel, BorderLayout.SOUTH);
        
        // ================== Ajouter les panels à la fenêtre ==================
        getContentPane().add(leftPanel, BorderLayout.WEST);
        getContentPane().add(chatPanel, BorderLayout.CENTER);
        
        // ================== Actions des boutons ==================
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        
        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertImage();
            }
        });
        
        setVisible(true);
    }
    
    /**
     * Méthode pour envoyer un message dans le chat.
     * Vérifie si le message n'est pas vide avant de l'ajouter à la zone de chat.
     */
    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            chatArea.append("Vous : " + message + "\n");
            messageField.setText("");
        }
    }
    
    /**
     * Méthode pour insérer une image dans le chat.
     * Ouvre une boîte de dialogue pour sélectionner une image.
     */
    private void insertImage() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            chatArea.append("📷 Image envoyée: " + filePath + "\n");
        }
    }
    
    /**
     * Point d'entrée principal de l'application.
     * Crée et affiche la fenêtre de chat.
     * 
     * @param args Les arguments de la ligne de commande (non utilisés)
     */

}