
package loginapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;


public class SignUp extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton quitSignUp;
    private javax.swing.JTextField signUpEmail;
    private javax.swing.JButton signUpLogin;
    private javax.swing.JPasswordField signUpPassword;
    private javax.swing.JButton signUpSignUp;
    private javax.swing.JTextField signUpUserName;
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Hashing h = new Hashing();
    
    
    
    public SignUp() {
        initComponents();
        con = DbConnection.connectionDB();
    }
    
    
    private boolean isValidStrongPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    private boolean isValidEmail(String password) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[_A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBackground(SystemColor.inactiveCaptionText);
        jLabel2 = new javax.swing.JLabel();
        signUpUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        signUpPassword = new javax.swing.JPasswordField();
        signUpSignUp = new javax.swing.JButton();
        signUpLogin = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        signUpEmail = new javax.swing.JTextField();
        quitSignUp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(SystemColor.textHighlight);
        Right.setPreferredSize(new java.awt.Dimension(400, 500));
        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        RightLayout.setHorizontalGroup(
        	RightLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(RightLayout.createSequentialGroup()
        			.addContainerGap(121, Short.MAX_VALUE)
        			.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
        			.addGap(62))
        );
        RightLayout.setVerticalGroup(
        	RightLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(RightLayout.createSequentialGroup()
        			.addGap(257)
        			.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(212, Short.MAX_VALUE))
        );
        Right.setLayout(RightLayout);

        jPanel1.add(Right);
        Right.setBounds(0, 0, 400, 500);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 36));
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Inscription Utilisateur");
        jLabel1.setAlignmentX(0.5F);

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18));
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Nom d'utilisateur");

        signUpUserName.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14));
        signUpUserName.setForeground(new java.awt.Color(0, 102, 102));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18));
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Mot de passe");

        signUpPassword.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14));
        signUpPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpPasswordActionPerformed(evt);
            }
        });

        signUpSignUp.setBackground(new java.awt.Color(0, 102, 102));
        signUpSignUp.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18));
        signUpSignUp.setForeground(new java.awt.Color(255, 255, 255));
        signUpSignUp.setText("Enregistrer");
        signUpSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpSignUpActionPerformed(evt);
            }
        });

        signUpLogin.setBackground(new java.awt.Color(254, 254, 254));
        signUpLogin.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14));
        signUpLogin.setForeground(new java.awt.Color(0, 102, 102));
        signUpLogin.setText("Login");
        signUpLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpLoginActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18));
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Email");

        signUpEmail.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14));
        signUpEmail.setForeground(new java.awt.Color(0, 102, 102));

        quitSignUp.setBackground(new java.awt.Color(254, 254, 254));
        quitSignUp.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14));
        quitSignUp.setForeground(new java.awt.Color(0, 102, 102));
        quitSignUp.setText("Quiter");
        quitSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        LeftLayout.setHorizontalGroup(
        	LeftLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(LeftLayout.createSequentialGroup()
        			.addGroup(LeftLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(LeftLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel1))
        				.addGroup(LeftLayout.createSequentialGroup()
        					.addGap(33)
        					.addGroup(LeftLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(Alignment.TRAILING, LeftLayout.createSequentialGroup()
        							.addComponent(signUpLogin)
        							.addPreferredGap(ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
        							.addComponent(quitSignUp))
        						.addGroup(LeftLayout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
        							.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
        							.addComponent(signUpPassword, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        							.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
        							.addComponent(signUpSignUp, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        							.addGroup(LeftLayout.createSequentialGroup()
        								.addGap(10)
        								.addComponent(signUpUserName))
        							.addComponent(signUpEmail, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)))))
        			.addContainerGap())
        );
        LeftLayout.setVerticalGroup(
        	LeftLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(LeftLayout.createSequentialGroup()
        			.addGap(54)
        			.addComponent(jLabel1)
        			.addGap(18)
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(signUpUserName, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(signUpEmail, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(signUpPassword, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(signUpSignUp, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addGap(37)
        			.addGroup(LeftLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(quitSignUp, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(signUpLogin, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
        			.addGap(29))
        );
        Left.setLayout(LeftLayout);

        jPanel1.add(Left);
        Left.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void signUpPasswordActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void signUpLoginActionPerformed(java.awt.event.ActionEvent evt) {
        LoginUser LoginFrame = new LoginUser();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }

    @SuppressWarnings("deprecation")
	private void signUpSignUpActionPerformed(java.awt.event.ActionEvent evt) {
        
        String mail = signUpEmail.getText();
        String usernom = signUpUserName.getText();
        String pass = signUpPassword.getText();
        
        
        
        int a=0;
        if(usernom.matches("[a-zA-Z]+")){
            a=1;
        }
        else{
            JOptionPane.showMessageDialog(null, "Nom d'utilisateur non valide!");
        }
        
        
        int b=0;
        if(isValidEmail(mail)){
            b=1;
        }
        else{
            JOptionPane.showMessageDialog(null, "Email non valide!");
        }
        
        
        int c=0;
        if(isValidStrongPassword(pass)){
            c=1;
        }
        else{
            JOptionPane.showMessageDialog(null, "Mot de passe non valide!");
        }
        
       
        if (!(usernom == null || usernom.trim().isEmpty() ||
             mail == null || mail.trim().isEmpty() ||
             pass.trim().isEmpty() || a == 0 || b == 0 || c == 0)) {
            try{
                String sql = "INSERT INTO Accounts VALUES (?,?,?);";
                pst = con.prepareStatement(sql);


                pst.setString(2, signUpUserName.getText());
<<<<<<< HEAD
                pst.setString(3, signUpEmail.getText());
                pst.setString(4, h.doHashing(signUpPassword.getText()));
                pst.setString(5, "User");                      
                
               
                
=======
                //pst.setString(3, signUpPassword.getText());
                pst.setString(3, h.doHashing(signUpPassword.getText()));
>>>>>>> 8072c267fc94a2d2e17c95f0cafe49a58c70ab75
                pst.execute();
                JOptionPane.showMessageDialog(null, "Nouvel utilisateur enregistré avec succès");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, " L'inscription a échoué, essayez un autre nom d'utilisateur !!");
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                return;
            }

            try {
                con.close();
                
                Welcome welcom = new Welcome(signUpEmail.getText());
                welcom.setVisible(true);
                welcom.pack();
                welcom.setLocationRelativeTo(null);
                this.dispose();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture !!");
            }

        }
        
        
    }

    private void quitSignUpActionPerformed(java.awt.event.ActionEvent evt) {
        LoginUser LoginFrame = new LoginUser();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }

    

}
