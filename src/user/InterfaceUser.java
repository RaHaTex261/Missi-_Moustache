package user;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;


/**
 * Classe représentant l'interface utilisateur pour la gestion d'un chat audio et textuel.
 * Elle hérite de JFrame pour créer une fenêtre d'application avec des composants graphiques.
 * Cette classe permet de saisir des messages texte, d'enregistrer des messages vocaux et de les lire.
 */
public class InterfaceUser extends JFrame {
    
    /**
     * Serial version UID pour garantir la compatibilité lors de la sérialisation de l'objet.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Zone de texte pour afficher le chat, où les messages texte seront montrés.
     */
    private JTextArea chatArea;
    
    /**
     * Champ de texte où l'utilisateur saisit ses messages.
     */
    private JTextField messageField;
    
    /**
     * Indicateur pour savoir si l'enregistrement audio est en cours.
     * Si 'true', un enregistrement audio est en cours.
     */
    private boolean isRecording = false;
    
    /**
     * Ligne de données cible utilisée pour l'enregistrement audio à partir du micro.
     */
    private TargetDataLine targetLine;
    
    /**
     * Fichier audio actuellement enregistré.
     * Il représente le dernier message vocal enregistré par l'utilisateur.
     */
    private File audioFile;
    
    /**
     * Liste des fichiers audio (messages vocaux) envoyés par l'utilisateur.
     */
    private List<File> vocalMessages = new ArrayList<>();
    
    /**
     * Liste des boutons de lecture associés aux messages vocaux.
     * Chaque bouton permet de lire un message vocal spécifique.
     */
    private List<JButton> playButtons = new ArrayList<>();
    
    /**
     * Dictionnaire associant chaque fichier audio à un clip audio en cours de lecture.
     * Utilisé pour gérer l'état de lecture des fichiers audio.
     */
    private Map<File, Clip> activeClips = new HashMap<>();
    
    /**
     * Fenêtre principale de l'interface utilisateur.
     */
    private JFrame frame;
    
    // D'autres méthodes et logiques de l'interface seraient ajoutées ici


	public InterfaceUser(String string) {
		// Paramètres de la fenêtre principale
		setTitle("Chat Application");
		setMinimumSize(new Dimension(800, 500));
		setPreferredSize(new Dimension(800, 500));
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		// ================== Panel Gauche ==================
		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.setBackground(new Color(30, 144, 255));
		leftPanel.setPreferredSize(new Dimension(200, getHeight()));

		JTextField searchField = new JTextField("Search...");
		searchField.setPreferredSize(new Dimension(300, 30));
		leftPanel.add(searchField, BorderLayout.NORTH);

		DefaultListModel<String> contactsModel = new DefaultListModel<>();
		contactsModel.addElement("Teddy");
		contactsModel.addElement("David");
		JList<String> contactList = new JList<>(contactsModel);
		contactList.setBackground(new Color(200, 220, 255));
		JScrollPane scrollPane = new JScrollPane(contactList);
		leftPanel.add(scrollPane, BorderLayout.CENTER);

		// ================== Panel utilisateur en bas ==================
		JPanel bottomLeftPanel = new JPanel(new BorderLayout());
		bottomLeftPanel.setPreferredSize(new Dimension(250, 50));
		bottomLeftPanel.setBackground(new Color(50, 130, 200));

		JLabel userLabel = new JLabel("👤 Nom Utilisateur");
		userLabel.setForeground(Color.WHITE);
		userLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

		// Création du JPopupMenu pour le menu déroulant
		JPopupMenu popupMenu = new JPopupMenu();

		// Création des éléments du menu
		JMenuItem modifyItem = new JMenuItem("Modifier");
		JMenuItem logoutItem = new JMenuItem("Déconnexion");

		// Ajout des éléments au menu
		popupMenu.add(modifyItem);
		popupMenu.addSeparator(); // Séparateur pour les options
		popupMenu.add(logoutItem);

		// Création du bouton du menu ⚙️
		JButton menuButton = new JButton("⚙️");
		menuButton.setPreferredSize(new Dimension(50, 30));

		// Ajouter un écouteur d'événements au bouton
		menuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				popupMenu.show(menuButton, 0, menuButton.getHeight()); // Affiche le menu sous le bouton
			}
		});

		modifyItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Ouvrir l'interface de modification
				new ModifierUser(); // Crée une nouvelle instance de la fenêtre de modification
			}
		});

		logoutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Afficher un message de déconnexion
				JOptionPane.showMessageDialog(InterfaceUser.this, "Déconnexion...");

				// Masquer et fermer la fenêtre actuelle (fenêtre principale de l'application de
				// chat)
				InterfaceUser.this.setVisible(false);
				InterfaceUser.this.dispose(); // Ferme la fenêtre actuelle

				// Ouvrir la fenêtre de connexion (LoginApp)
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new LoginApp(); // Crée une nouvelle instance de la fenêtre de connexion
					}
				});
			}
		});

		// Ajout du bouton au panel utilisateur en bas
		bottomLeftPanel.add(userLabel, BorderLayout.WEST);
		bottomLeftPanel.add(menuButton, BorderLayout.EAST);
		leftPanel.add(bottomLeftPanel, BorderLayout.SOUTH);

		// ================== Panel Chat ==================
		JPanel chatPanel = new JPanel(new BorderLayout());
		chatArea = new JTextArea();
		chatArea.setEditable(false);
		chatArea.setBackground(Color.WHITE);
		JScrollPane chatScrollPane = new JScrollPane(chatArea);
		chatPanel.add(chatScrollPane, BorderLayout.CENTER);

		// ================== Panel supérieur (Boutons d'appel) ==================
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		topPanel.setBackground(new Color(0, 102, 204));

		JButton callButton = new JButton("📞 Appel Vocal");
		JButton videoButton = new JButton("📹 Appel Vidéo");

		// Ajout des écouteurs d'événements
		callButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(InterfaceUser.this, "Démarrage de l'appel vocal...");
			}
		});

		videoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(InterfaceUser.this, "Démarrage de l'appel vidéo...");
			}
		});

		// Ajout des boutons au panel
		topPanel.add(callButton);
		topPanel.add(videoButton);

		// Ajout du panel supérieur au chat panel
		chatPanel.add(topPanel, BorderLayout.NORTH);

		// ================== Zone d'entrée de message ==================
		JPanel inputPanel = new JPanel(new BorderLayout());
		inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel leftButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
		JButton emojiButton = new JButton("😊");
		JButton imageButton = new JButton("📸");
		JButton vocalButton = new JButton("🎙️");
		leftButtonsPanel.add(emojiButton);
		leftButtonsPanel.add(imageButton);
		leftButtonsPanel.add(vocalButton);

		// Zone pour afficher l'image
		JLabel imageLabel = new JLabel();
		imageLabel.setHorizontalAlignment(JLabel.CENTER);

		// Action du bouton image
		imageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "jpeg", "gif"));

				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());

					// Redimensionner l'image
					Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
					imageLabel.setIcon(new ImageIcon(image));
				}
			}
		});

		messageField = new JTextField();
		JButton sendButton = new JButton("Envoyer");

		inputPanel.add(leftButtonsPanel, BorderLayout.WEST);
		inputPanel.add(messageField, BorderLayout.CENTER);
		inputPanel.add(sendButton, BorderLayout.EAST);

		JButton listenButton = new JButton("Écouter");
		inputPanel.add(listenButton, BorderLayout.SOUTH);
		chatPanel.add(inputPanel, BorderLayout.SOUTH);

		// ================== Ajout des panels à la fenêtre ==================
		getContentPane().add(leftPanel, BorderLayout.WEST);
		getContentPane().add(chatPanel, BorderLayout.CENTER);

		// ================== Écouteurs des boutons ==================
		sendButton.addActionListener(e -> sendMessage());
		imageButton.addActionListener(e -> insertImage());
		vocalButton.addActionListener(e -> toggleRecording(vocalButton));
		listenButton.addActionListener(e -> playAudio(audioFile));

		setVisible(true);
	}
	

	// Fonction d'envoi du message
	private void sendMessage() {
		String message = messageField.getText();
		if (!message.isEmpty()) {
			chatArea.append("Vous : " + message + "\n");
			messageField.setText("");
		}
	}

	// Méthode pour créer un nouveau composant contenant le bouton de lecture
	private Component createAudioComponent(File audioFile) {
	    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JButton playButton = new JButton("▶️ Écouter");
	    playButton.addActionListener(e -> playAudio(audioFile));

	    JLabel fileNameLabel = new JLabel(audioFile.getName());
	    fileNameLabel.setFont(new Font("Arial", Font.PLAIN, 10));

	    panel.add(playButton);
	    panel.add(fileNameLabel);
	    return panel;
	}

	// Méthode pour ajouter un message vocal à l'affichage
	@SuppressWarnings("unused")
	private void displayVocalMessage(File audioFile) {
		Component audioComponent = createAudioComponent(audioFile);
		chatArea.removeAll();
		for (Component existingComp : chatArea.getComponents()) {
			chatArea.add(existingComp);
		}
		chatArea.add(audioComponent);
		chatArea.revalidate();
		chatArea.repaint();
	}


	// Fonction pour démarrer l'enregistrement vocal
	private void toggleRecording(JButton vocalButton) {
		if (isRecording) {
			stopRecording();
			vocalButton.setText("🎙️ Enregistrer");
		} else {
			startRecording();
			vocalButton.setText("⏹️ Arrêter");
		}
	}

	// Fonction pour démarrer l'enregistrement
	private void startRecording() {
	    isRecording = true;
	    new Thread(() -> {
	        try {
	            // Définir le répertoire de stockage
	            File directory = new File("vocal");
	            if (!directory.exists()) {
	                directory.mkdir(); // Crée le dossier s'il n'existe pas
	            }

	            // Créer le fichier dans le dossier "vocal"
	            audioFile = new File(directory, "vocal_message_" + System.currentTimeMillis() + ".wav");

	            AudioFormat format = new AudioFormat(16000, 16, 2, true, true);
	            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
	            if (!AudioSystem.isLineSupported(info)) {
	                chatArea.append("⚠️ Enregistrement non supporté !\n");
	                isRecording = false;
	                return;
	            }
	            targetLine = (TargetDataLine) AudioSystem.getLine(info);
	            targetLine.open(format);
	            targetLine.start();
	            AudioInputStream ais = new AudioInputStream(targetLine);
	            AudioSystem.write(ais, AudioFileFormat.Type.WAVE, audioFile);
	            chatArea.append("🎙️ Enregistrement commencé...\n");
	        } catch (Exception e) {
	            chatArea.append("❌ Erreur d'enregistrement !\n");
	            isRecording = false;
	        }
	    }).start();
	}


	// Fonction pour jouer l'audio enregistré
	private void playAudio(File audioFile) {
	    if (audioFile.exists()) {
	        try {
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	            Clip clip = AudioSystem.getClip();
	            clip.open(audioStream);

	            // Arrêtez toute lecture en cours du même fichier
	            if (activeClips.containsKey(audioFile)) {
	                Clip oldClip = activeClips.get(audioFile);
	                oldClip.stop();
	            }

	            clip.start();
	            activeClips.put(audioFile, clip);

	            // Nettoyez le clip quand il finit de jouer
	            Thread cleanupThread = new Thread(() -> {
	                try {
	                    long sleepTime = (long) (audioStream.getFrameLength() / audioStream.getFormat().getFrameRate()
	                            * 1000 + 500);
	                    Thread.sleep(sleepTime);
	                    activeClips.remove(audioFile);
	                } catch (Exception e) {
	                    chatArea.append("❌ Erreur lors du nettoyage du clip audio\n");
	                }
	            });
	            cleanupThread.setDaemon(true);
	            cleanupThread.start();

	            chatArea.append("🎧 Lecture du message vocal...\n");
	        } catch (Exception e) {
	            chatArea.append("❌ Impossible de lire le message vocal !\n");
	        }
	    } else {
	        chatArea.append("❌ Aucun message vocal à écouter !\n");
	    }
	}

	private void stopRecording() {
	    isRecording = false;

	    if (targetLine != null) {
	        targetLine.stop();
	        targetLine.close();
	    }

	    try {
	        chatArea.append("✅ Message vocal enregistré : " + audioFile.getName() + " ");

	        // Lecture du fichier audio
	        @SuppressWarnings("unused")
	        byte[] audioContent = Files.readAllBytes(audioFile.toPath());

	        // Appel de la méthode pour sauvegarder le nom du fichier en BDD
	        saveAudioFileNameToDB(1, 2, audioFile);  // Remplace 1 et 2 par les vrais ID de l'expéditeur et du destinataire

	        // Création du bouton de lecture
	        JButton playButton = new JButton("▶️");
	        playButton.addActionListener(e -> playAudio(audioFile));

	        // Ajout du bouton à l'interface
	        chatArea.add(playButton);
	        chatArea.append("\n");

	        // Ajout du fichier audio à la liste des messages vocaux
	        vocalMessages.add(audioFile);

	        // Mise à jour de l'affichage
	        chatArea.revalidate();
	        chatArea.repaint();

	    } catch (IOException e) {
	        chatArea.append("❌ Erreur lors de l'enregistrement du message vocal.\n");
	        e.printStackTrace();
	    }
	}
	
	
	private void saveAudioFileNameToDB(int expediteurId, Integer destinataireId, File audioFile) {
	    String fileName = audioFile.getName();  // Récupère le nom du fichier

	    // Connexion à la base de données SQLite
	    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:loginSqlite.db")) { // Remplace "database.db" par ton fichier BDD
	        String sql = "INSERT INTO messages_audio (expediteur_id, destinataire_id, contenu_audio, hash_integrite, statut) " +
	                     "VALUES (?, ?, ?, ?, ?)";

	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, expediteurId);  // ID de l'expéditeur
	            pstmt.setObject(2, destinataireId); // ID du destinataire (peut être null)
	            pstmt.setString(3, fileName);  // Nom du fichier audio
	            pstmt.setString(4, Integer.toString(fileName.hashCode()));  // Hash de l'intégrité du fichier
	            pstmt.setString(5, "envoyé");  // Statut par défaut

	            pstmt.executeUpdate();  // Exécute la requête d'insertion
	            System.out.println("Nom du fichier audio sauvegardé dans la base de données !");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// Générer une clé secrète pour AES
	public static SecretKey generateSecretKey() throws Exception {
	    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	    keyGen.init(128); // Taille de la clé en bits
	    return keyGen.generateKey();
	}

	// Chiffrer le texte
	public static String encryptText(String plainText, SecretKey secretKey) throws Exception {
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	    byte[] encrypted = cipher.doFinal(plainText.getBytes());
	    return Base64.getEncoder().encodeToString(encrypted);
	}

	// Déchiffrer le texte
	public static String decryptText(String encryptedText, SecretKey secretKey) throws Exception {
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.DECRYPT_MODE, secretKey);
	    byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
	    return new String(decrypted);
	}
	

	@SuppressWarnings("unused")
	private int obtenirUtilisateurId(Object utilisateur) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Fonction d'insertion d'image (à compléter selon l'implémentation)
	private void insertImage() {
		// Implémentation pour insérer une image dans la conversation
	}

	public List<JButton> getPlayButtons() {
		return playButtons;
	}

	public void setPlayButtons(List<JButton> playButtons) {
		this.playButtons = playButtons;
	}

}