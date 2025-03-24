
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


public class SignUp extends javax.swing.JFrame {

    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Hashing h = new Hashing();
    
    
    
    public SignUp() {
        initComponents();
        con = DbConnection.connectionDB();
    }
    
    @SuppressWarnings("unchecked")
    
    private boolean isValidStrongPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    private boolean isValidEmail(String password) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[_A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        //String r = isValidEmail
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        signUpUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        signUpPassword = new javax.swing.JPasswordField();
        signUpSignUp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
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

        Right.setBackground(new java.awt.Color(0, 102, 102));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/vnv_140px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("A V A    Corporation");

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jPanel1.add(Right);
        Right.setBounds(0, 0, 400, 500);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("SIGN UP");
        jLabel1.setAlignmentX(0.5F);

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Username");

        signUpUserName.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        signUpUserName.setForeground(new java.awt.Color(0, 102, 102));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Password");

        signUpPassword.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        signUpPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpPasswordActionPerformed(evt);
            }
        });

        signUpSignUp.setBackground(new java.awt.Color(0, 102, 102));
        signUpSignUp.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        signUpSignUp.setForeground(new java.awt.Color(255, 255, 255));
        signUpSignUp.setText("Sign Up");
        signUpSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpSignUpActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        jLabel4.setText("I don't have an account ");

        signUpLogin.setBackground(new java.awt.Color(254, 254, 254));
        signUpLogin.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        signUpLogin.setForeground(new java.awt.Color(0, 102, 102));
        signUpLogin.setText("Login");
        signUpLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpLoginActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Email");

        signUpEmail.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        signUpEmail.setForeground(new java.awt.Color(0, 102, 102));

        quitSignUp.setBackground(new java.awt.Color(254, 254, 254));
        quitSignUp.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        quitSignUp.setForeground(new java.awt.Color(0, 102, 102));
        quitSignUp.setText("Quiter");
        quitSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(signUpSignUp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LeftLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signUpLogin)
                                .addGap(18, 18, 18)
                                .addComponent(quitSignUp))
                            .addComponent(signUpPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(signUpEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signUpUserName, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUpUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signUpSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(signUpLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void signUpPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signUpPasswordActionPerformed

    private void signUpLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpLoginActionPerformed
        
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_signUpLoginActionPerformed

    private void signUpSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpSignUpActionPerformed
        
        String mail = signUpEmail.getText();
        String usernom = signUpUserName.getText();
        String pass = signUpPassword.getText();
        
        
        
        int b=0;
        if(usernom.matches("[a-zA-Z]+")){
            b=1;
        }
        else{
            JOptionPane.showMessageDialog(null, "Username NOT Valide!");
        }
        
        
        int c=0;
        if(isValidEmail(mail)){
            c=1;
        }
        else{
            JOptionPane.showMessageDialog(null, "Email NOT Valide!");
        }
        
        
        int a=0;
        if(isValidStrongPassword(pass)){
            a=1;
        }
        else{
            JOptionPane.showMessageDialog(null, "Password NOT Valide!");
        }
        
       
        if(!(mail == null || mail.trim().isEmpty() || usernom == null || usernom.trim().isEmpty() || pass.trim().isEmpty() || a == 0 || b == 0 || c == 0)){
            try{
                String sql = "INSERT INTO Accounts VALUES (?,?,?);";
                pst = con.prepareStatement(sql);


                pst.setString(1, signUpEmail.getText());
                pst.setString(2, signUpUserName.getText());
                //pst.setString(3, signUpPassword.getText());
                pst.setString(3, h.doHashing(signUpPassword.getText()));
                pst.execute();
                JOptionPane.showMessageDialog(null, "New User registered Susccessfully");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, " Registration failed try an over Username !!");
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                //JOptionPane.showMessageDialog(null, "Fermeture avec succe!!");
                //this.dispose();
                return;
            }

            try {
                con.close();
                //JOptionPane.showMessageDialog(null, "Fermeture avec succe!!");
                Welcome welcom = new Welcome(signUpEmail.getText());
                welcom.setVisible(true);
                welcom.pack();
                welcom.setLocationRelativeTo(null);
                this.dispose();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture !!");
            }

        }
        
        
    }//GEN-LAST:event_signUpSignUpActionPerformed

    private void quitSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitSignUpActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_quitSignUpActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton quitSignUp;
    private javax.swing.JTextField signUpEmail;
    private javax.swing.JButton signUpLogin;
    private javax.swing.JPasswordField signUpPassword;
    private javax.swing.JButton signUpSignUp;
    private javax.swing.JTextField signUpUserName;
    // End of variables declaration//GEN-END:variables
}
