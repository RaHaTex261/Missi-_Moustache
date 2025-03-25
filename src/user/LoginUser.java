package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import Crud.DbConnection;
import Crud.Hashing;


/**
 * Fenêtre de connexion utilisateur.
 * 
 * Cette classe représente l'interface utilisateur permettant à un utilisateur
 * de se connecter à l'application en saisissant son email et son mot de passe.
 * Elle gère les interactions avec les composants de l'interface, y compris les
 * champs de saisie pour l'email et le mot de passe, ainsi que les boutons pour
 * se connecter, s'inscrire, ou quitter l'application. Elle communique avec la
 * base de données pour valider les informations de connexion.
 * 
 * @author Tex Beloha
 * @version 1.0
 */
public class LoginUser extends javax.swing.JFrame {

	// Déclaration des composants graphiques de l'interface utilisateur
	// Déclaration des composants graphiques pour l'interface utilisateur

	/** Panneau gauche de la fenêtre de connexion. */
	private javax.swing.JPanel Left;

	/** Panneau droit de la fenêtre de connexion. */
	private javax.swing.JPanel Right;

	/** Label pour afficher un texte descriptif ou un titre. */
	private javax.swing.JLabel jLabel1;

	/** Label pour afficher un autre texte descriptif ou un sous-titre. */
	private javax.swing.JLabel jLabel2;

	/** Label pour afficher un texte supplémentaire ou une information. */
	private javax.swing.JLabel jLabel3;

	/** Panneau principal qui contient les autres composants. */
	private javax.swing.JPanel jPanel1;

	/** Champ de texte où l'utilisateur saisit son email pour se connecter. */
	private javax.swing.JTextField loginEmail;

	/** Bouton permettant à l'utilisateur de se connecter après avoir saisi ses informations. */
	private javax.swing.JButton loginLogin;

	/** Champ de texte masqué où l'utilisateur saisit son mot de passe. */
	private javax.swing.JPasswordField loginPassword;

	/** Bouton permettant à l'utilisateur de s'inscrire s'il n'a pas encore de compte. */
	private javax.swing.JButton loginSignUp;

	/** Bouton permettant à l'utilisateur de quitter la fenêtre de connexion. */
	private javax.swing.JButton quitLogin;

	/** ID de version pour garantir la compatibilité de la classe lors de la sérialisation. */
	private static final long serialVersionUID = 1L;


	// Déclaration des objets pour la connexion à la base de données
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	// Instance de la classe Hashing pour le traitement des mots de passe
	Hashing h = new Hashing();

	/**
	 * Constructeur de la classe LoginUser.
	 * 
	 * Initialise les composants graphiques de la fenêtre de connexion, établit la
	 * connexion avec la base de données, et prépare l'interface pour l'affichage.
	 */
	public LoginUser() {
		initComponents();
		con = DbConnection.connectionDB(); // Connexion à la base de données
	}

	/**
	 * Méthode pour initialiser les composants graphiques de la fenêtre.
	 * 
	 * Cette méthode configure et place les différents composants visuels de
	 * l'interface utilisateur (champs de texte, boutons, labels, etc.) et définit
	 * les actions associées à ces composants.
	 */
	private void initComponents() {
		// Initialisation et configuration des composants graphiques

		jPanel1 = new javax.swing.JPanel();
		Right = new javax.swing.JPanel();
		Left = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		loginEmail = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		loginLogin = new javax.swing.JButton();
		loginSignUp = new javax.swing.JButton();
		quitLogin = new javax.swing.JButton();
		loginPassword = new javax.swing.JPasswordField();

		setTitle("LOGIN");
		setUndecorated(true);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
		jPanel1.setLayout(null);

		Right.setBackground(new java.awt.Color(0, 102, 102));
		Right.setPreferredSize(new java.awt.Dimension(400, 500));

		javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
		RightLayout
				.setHorizontalGroup(RightLayout.createParallelGroup(Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		RightLayout
				.setVerticalGroup(RightLayout.createParallelGroup(Alignment.LEADING).addGap(0, 500, Short.MAX_VALUE));
		Right.setLayout(RightLayout);

		jPanel1.add(Right);
		Right.setBounds(0, 0, 400, 500);

		Left.setBackground(new java.awt.Color(255, 255, 255));
		Left.setPreferredSize(new java.awt.Dimension(400, 500));

		jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 36));
		jLabel1.setForeground(new java.awt.Color(0, 102, 102));
		jLabel1.setText("Connecter Utilisateur");
		jLabel1.setAlignmentX(0.5F);

		jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18));
		jLabel2.setForeground(new java.awt.Color(0, 102, 102));
		jLabel2.setText("Email");

		loginEmail.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14));
		loginEmail.setForeground(new java.awt.Color(0, 102, 102));

		jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18));
		jLabel3.setForeground(new java.awt.Color(0, 102, 102));
		jLabel3.setText("Mot de passe");

		loginLogin.setBackground(new java.awt.Color(0, 102, 102));
		loginLogin.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18));
		loginLogin.setForeground(new java.awt.Color(255, 255, 255));
		loginLogin.setText("Connexion");
		loginLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginLoginActionPerformed(evt);
			}
		});

		loginSignUp.setBackground(new java.awt.Color(254, 254, 254));
		loginSignUp.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14));
		loginSignUp.setForeground(new java.awt.Color(0, 102, 102));
		loginSignUp.setText("Inscription");
		loginSignUp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginSignUpActionPerformed(evt);
			}
		});

		quitLogin.setBackground(new java.awt.Color(254, 254, 254));
		quitLogin.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14));
		quitLogin.setForeground(new java.awt.Color(0, 102, 102));
		quitLogin.setText("Quiter");
		quitLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				quitLoginActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
		LeftLayout.setHorizontalGroup(LeftLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(LeftLayout.createSequentialGroup().addGroup(LeftLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(LeftLayout.createSequentialGroup().addContainerGap().addComponent(jLabel1))
						.addGroup(LeftLayout.createSequentialGroup().addGap(33).addGroup(LeftLayout
								.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING,
										LeftLayout.createSequentialGroup().addComponent(loginSignUp)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(quitLogin))
								.addComponent(loginEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 323,
										Short.MAX_VALUE)
								.addComponent(jLabel2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 114,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(loginPassword, Alignment.LEADING)
								.addComponent(jLabel3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 227,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(loginLogin, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 163,
										GroupLayout.PREFERRED_SIZE))))
						.addContainerGap()));
		LeftLayout.setVerticalGroup(LeftLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(LeftLayout.createSequentialGroup().addGap(57).addComponent(jLabel1).addGap(18)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(loginEmail, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(loginPassword, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(loginLogin, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(LeftLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(loginSignUp, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(quitLogin, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGap(47)));
		Left.setLayout(LeftLayout);

		jPanel1.add(Left);
		Left.setBounds(400, 0, 400, 500);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		pack();
	}

	private void loginSignUpActionPerformed(java.awt.event.ActionEvent evt) {
		SignupUser SignUpFrame = new SignupUser();
		SignUpFrame.setVisible(true);
		SignUpFrame.pack();
		SignUpFrame.setLocationRelativeTo(null);
		this.dispose();
	}

	private boolean isValidStrongPassword(String password) {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	private boolean isValidEmail(String password) {
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[_A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	@SuppressWarnings("deprecation")
	private void loginLoginActionPerformed(java.awt.event.ActionEvent evt) {

		String mail = loginEmail.getText();
		String pass = loginPassword.getText();

		int c = 0;
		if (isValidEmail(mail)) {

			c = 1;
		} else {
			JOptionPane.showMessageDialog(null, "Email non valide!");
		}

		int a = 0;
		if (isValidStrongPassword(pass)) {

			a = 1;
		} else {
			JOptionPane.showMessageDialog(null, "Mot de passe non valide!");
		}

		if (!(mail == null || mail.trim().isEmpty() || pass.trim().isEmpty() || a == 0 || c == 0)) {
			try {
				String sql = "SELECT * from Accounts WHERE Email LIKE ? AND  Password LIKE ?;";
				pst = con.prepareStatement(sql);
				pst.setString(1, loginEmail.getText());
				pst.setString(2, h.doHashing(loginPassword.getText()));

				rs = pst.executeQuery();

				if (rs.next()) {

					InterfaceUser welcom = new InterfaceUser(loginEmail.getText());
					welcom.setVisible(true);
					welcom.pack();
					welcom.setLocationRelativeTo(null);

					this.dispose();
					con.close();

				} else {
					JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect !!!!!");
					try {
						con.close();

					} catch (SQLException ex) {

					}

				}
			} catch (Exception e) {

			}

			try {
				con.close();

			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture !!");
			}
		}

	}

	private void quitLoginActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}
}
