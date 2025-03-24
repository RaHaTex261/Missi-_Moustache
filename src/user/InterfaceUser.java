package user;

import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InterfaceUser extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea chatArea;
    private JTextField messageField;
    private boolean isRecording = false;
    private TargetDataLine targetLine;
    private File audioFile;
    private List<File> vocalMessages = new ArrayList<>();
    private List<JButton> playButtons = new ArrayList<>();
    private Map<File, Clip> activeClips = new HashMap<>();

    public InterfaceUser(String string) {
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

        JButton menuButton = new JButton("⚙️");
        menuButton.setPreferredSize(new Dimension(50, 30));

        bottomLeftPanel.add(userLabel, BorderLayout.WEST);
        bottomLeftPanel.add(menuButton, BorderLayout.EAST);
        leftPanel.add(bottomLeftPanel, BorderLayout.SOUTH);

        JPanel chatPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(Color.WHITE);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatPanel.add(chatScrollPane, BorderLayout.CENTER);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.add(new JButton("📞 Appel Vocal"));
        topPanel.add(new JButton("📹 Appel Vidéo"));
        chatPanel.add(topPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel leftButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JButton emojiButton = new JButton("😊");
        JButton imageButton = new JButton("📸");
        JButton vocalButton = new JButton("🎙️");
        leftButtonsPanel.add(emojiButton);
        leftButtonsPanel.add(imageButton);
        leftButtonsPanel.add(vocalButton);

        messageField = new JTextField();
        JButton sendButton = new JButton("Envoyer");

        inputPanel.add(leftButtonsPanel, BorderLayout.WEST);
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        JButton listenButton = new JButton("Écouter");
        inputPanel.add(listenButton, BorderLayout.SOUTH);
        chatPanel.add(inputPanel, BorderLayout.SOUTH);

        getContentPane().add(leftPanel, BorderLayout.WEST);
        getContentPane().add(chatPanel, BorderLayout.CENTER);

        sendButton.addActionListener(e -> sendMessage());
        imageButton.addActionListener(e -> insertImage());
        vocalButton.addActionListener(e -> toggleRecording(vocalButton));
        listenButton.addActionListener(e -> playAudio(audioFile));

        setVisible(true);
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

    // Fonction d'envoi du message
    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            chatArea.append("Vous : " + message + "\n");
            messageField.setText("");
        }
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
                audioFile = new File("vocal_message_" + System.currentTimeMillis() + ".wav");
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
                    	long sleepTime = (long) (audioStream.getFrameLength() / audioStream.getFormat().getFrameRate() * 1000 + 500);
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
            
            chatArea.append("✅ Message vocal enregistré : " + audioFile.getName() + " ");
            
            // Créer un bouton de lecture
            JButton playButton = new JButton("▶️");
            playButton.addActionListener(e -> playAudio(audioFile));
            
            // Ajouter le bouton à la zone de chat
            chatArea.add(playButton);
            chatArea.append("\n");
            
            vocalMessages.add(audioFile);
        }
    }

    // Fonction d'insertion d'image (à compléter selon l'implémentation)
    private void insertImage() {
        // Implémentation pour insérer une image dans la conversation
    }

    public static void main(String[] args) {
        new InterfaceUser("Chat Application");
    }
    


}