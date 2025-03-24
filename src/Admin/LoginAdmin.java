package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Crud.DbConnection;	
import Crud.Hashing;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import user.InterfaceUser;

public class LoginAdmin extends javax.swing.JFrame {

    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField loginEmail;
    private javax.swing.JButton loginLogin;
    private javax.swing.JPasswordField loginPassword;
    private javax.swing.JButton quitLogin;

	private static final long serialVersionUID = 1L;
	Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Hashing h = new Hashing();
    
    
    public LoginAdmin() {
        initComponents();
        con = DbConnection.connectionDB();
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginLogin = new javax.swing.JButton();
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
        RightLayout.setHorizontalGroup(
        	RightLayout.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 400, Short.MAX_VALUE)
        );
        RightLayout.setVerticalGroup(
        	RightLayout.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 500, Short.MAX_VALUE)
        );
        Right.setLayout(RightLayout);

        jPanel1.add(Right);
        Right.setBounds(0, 0, 400, 500);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 36)); 
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("ADMIN");
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
        LeftLayout.setHorizontalGroup(
        	LeftLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(LeftLayout.createSequentialGroup()
        			.addGroup(LeftLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(LeftLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel1))
        				.addGroup(LeftLayout.createSequentialGroup()
        					.addContainerGap(67, Short.MAX_VALUE)
        					.addGroup(LeftLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(loginEmail, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
        						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        						.addComponent(loginPassword)
        						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
        						.addComponent(loginLogin, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(LeftLayout.createSequentialGroup()
        					.addGap(133)
        					.addComponent(quitLogin)))
        			.addContainerGap())
        );
        LeftLayout.setVerticalGroup(
        	LeftLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(LeftLayout.createSequentialGroup()
        			.addGap(57)
        			.addComponent(jLabel1)
        			.addGap(18)
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(loginEmail, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(loginPassword, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(loginLogin, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addGap(58)
        			.addComponent(quitLogin, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(87, Short.MAX_VALUE))
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
    
    
    @SuppressWarnings("deprecation")
	private void loginLoginActionPerformed(java.awt.event.ActionEvent evt) {
        
        
        String mail = loginEmail.getText();
        String pass = loginPassword.getText();
        
        
        
        int c=0;
        if(isValidEmail(mail)){
            
            c=1;
        }
        else{
            JOptionPane.showMessageDialog(null, "Email non valide!");
        }
        
        
        int a=0;
        if(isValidStrongPassword(pass)){
            
            a=1;
        }
        else{
            JOptionPane.showMessageDialog(null, "Mot de passe non valide!");
        }
        
        if(!(mail == null || mail.trim().isEmpty() || pass.trim().isEmpty() || a == 0 || c == 0)){
            try{
                String sql = "SELECT * from Accounts WHERE Email LIKE ? AND  Password LIKE ?;";
                pst = con.prepareStatement(sql);
                pst.setString(1, loginEmail.getText());
                pst.setString(2, h.doHashing(loginPassword.getText()));

                rs = pst.executeQuery();

                if(rs.next()){
                   

                	InterfaceUser welcom = new InterfaceUser(loginEmail.getText());
                    welcom.setVisible(true);
                    welcom.pack();
                    welcom.setLocationRelativeTo(null);

                    this.dispose();
                    con.close();

                }
                else{
                    JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect !!!!!");
                    try {
                        con.close();
                        
                    } catch (SQLException ex) {
                       
                    }

                }
            }catch(Exception e){

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
