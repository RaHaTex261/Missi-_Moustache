package Admin;
import javax.swing.GroupLayout.Alignment;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import Crud.DbConnection;
import Crud.Hashing;
<<<<<<< HEAD
=======
import user.InterfaceUser;
import user.SignupUser;
>>>>>>> 784c5544ee9715468946d9f4d4d767259fb2ea52

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
<<<<<<< HEAD
=======
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> 784c5544ee9715468946d9f4d4d767259fb2ea52
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
<<<<<<< HEAD
=======
import java.awt.event.MouseEvent;
>>>>>>> 784c5544ee9715468946d9f4d4d767259fb2ea52
import javax.swing.JTextField;
import javax.swing.JLabel;


public class AdminInterface extends javax.swing.JFrame {
	private javax.swing.JButton AddBtnAdminInterface;
	private javax.swing.JButton ModifyBtnAdminInterface;
	private javax.swing.JButton DeleteBtnAdminInterface;
	private javax.swing.JButton CancelBtnAdminInterface;
	private javax.swing.JButton jButton7;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPasswordField PasswordAdminInterface;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tbl;
	private javax.swing.JTextField NameAdminInterface;
	private javax.swing.JTextField EmailAdminInterface;
	
	public static int select = -1;

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Hashing h = new Hashing();

	private static final long serialVersionUID = -8617446149346172461L;
	
	
	
	DefaultTableModel defaultTableMode = new DefaultTableModel();
	private JTextField RoleAdminInterface;
	


	public AdminInterface() {
		initComponents();
		con = DbConnection.connectionDB();
		Object columns[] = {"Id", "Username", "Email", "Password", "Role"};
		defaultTableMode.setColumnIdentifiers(columns);
		tbl.setModel(defaultTableMode);
		
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Disable Auto-commit failed :" + e);
		}
		LoadData();
	}
	
	
	public void LoadData() {

		//Object columns[] = {"Id", "Username", "Email", "Password", "Role"};
		//defaultTableMode.setColumnIdentifiers(columns);
		//tbl.setModel(defaultTableMode);
		 ClearData();
		
		
		String sql = "Select Id, Username, Email, Password, Role from Accounts";
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			Object[] columnData = new Object[5];
			while(rs.next()) {
				columnData[0] = rs.getInt("Id");
				columnData[1] = rs.getString("Username");
				columnData[2] = rs.getString("Email");
				columnData[3] = rs.getString("Password");
				columnData[4] = rs.getString("Role");
				defaultTableMode.addRow(columnData);
			}
			JOptionPane.showMessageDialog(null, " Loadding Data Ok!!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, " Loadding Data failed!!");;
		}
		
	}
	
	public void ClearData() {
		defaultTableMode.setRowCount(0);
		
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

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jPanel2 = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tbl = new javax.swing.JTable();
		jPanel3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		NameAdminInterface = new javax.swing.JTextField();
		EmailAdminInterface = new javax.swing.JTextField();
		PasswordAdminInterface = new javax.swing.JPasswordField();
		AddBtnAdminInterface = new javax.swing.JButton();
		jScrollPane1.addMouseListener(new MouseAdapter() {
			
			private void tblMouseClicked(java.awt.event.MouseEvent evt) {
<<<<<<< HEAD

			}
			
=======
				//int currentRow = tbl.getSelectedRow();
				//System.out.println(currentRow);
				
				//NameAdminInterface.setText(tbl.getValueAt(currentRow, 1).toString()); 
				//EmailAdminInterface.setText(tbl.getValueAt(currentRow, 2).toString());
				//PasswordAdminInterface.setText(tbl.getValueAt(currentRow, 3).toString());
			}
			
			/*
			@Override
			
			public void mouseClicked(MouseEvent e) {
				int currentRow = tbl.getSelectedRow();

				NameAdminInterface.setText(tbl.getValueAt(currentRow, 1).toString()); 
				EmailAdminInterface.setText(tbl.getValueAt(currentRow, 2).toString());
				PasswordAdminInterface.setText(tbl.getValueAt(currentRow, 3).toString());
				
				if(currentRow != -1 )
					JOptionPane.showMessageDialog(null, "OK");
				
				//System.out.println(currentRow);
				//JOptionPane.showMessageDialog(null, "row = " + currentRow);
				//jLabel1.setText(""+currentRow);
			}
			*/
>>>>>>> 784c5544ee9715468946d9f4d4d767259fb2ea52
		});
		
		
		
		AddBtnAdminInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				
		        String mail = EmailAdminInterface.getText();
		        String usernom = NameAdminInterface.getText();
		        String pass = PasswordAdminInterface.getText();
		        
		        
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
		        
		       
		        if (!(usernom == null || usernom.trim().isEmpty() || mail == null || mail.trim().isEmpty() || pass.trim().isEmpty() || a == 0 || b == 0 || c == 0)) {
		            try{
		            	JOptionPane.showMessageDialog(null, " Essay 1");
		                String sql = "INSERT INTO Accounts VALUES (?,?,?,?,?);";
		                pst = con.prepareStatement(sql);
		                	
		                

		                pst.setString(2, NameAdminInterface.getText());
		                pst.setString(3, EmailAdminInterface.getText());
		                pst.setString(4, h.doHashing(PasswordAdminInterface.getText()));
		                
		                // Pour les Utilisateur 
		                pst.setString(5, "User"); 
		                
		                // Pour les Admin
		                //pst.setString(5, "Admin");
		                
		                pst.execute();
		                JOptionPane.showMessageDialog(null, "Nouvel utilisateur enregistré avec succès");
		                con.commit();
		                ClearData();
		                LoadData();
		            }
		            catch(Exception e1){
		                JOptionPane.showMessageDialog(null, " L'inscription a échoué!!");
		                /*
		                try {
		                    con.close();
		                } catch (SQLException ex) {
		                    Logger.getLogger(SignupUser.class.getName()).log(Level.SEVERE, null, ex);
		                }
		                return;
		                */
		            }
		            /*
		            try {
		                con.close();
		            } catch (SQLException ex) {
		                JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture !!");
		            }
		            */
		        }
				
				
		        
		        
				////////////////////////////////////////////////////////////////////////////////////////////////////////
			
	}
		});
		ModifyBtnAdminInterface = new javax.swing.JButton();
		ModifyBtnAdminInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String sql = "UPDATE Accounts set Email=? ,Username=? , Password=? WHERE  Email =?;";
                pst = con.prepareStatement(sql);


                pst.setString(1, signUpEmail.getText());
                pst.setString(2, signUpUserName.getText());
                //pst.setString(3, signUpPassword.getText());
                pst.setString(3, h.doHashing(signUpPassword.getText()));
                pst.setString(4, nom);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Modification successfull!!");
                */
				
////////////////////////////////////////////////////////////////////////////////////////////////////////
								
								
				String mail = EmailAdminInterface.getText();
				String usernom = NameAdminInterface.getText();
				String pass = PasswordAdminInterface.getText();
				
				
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
				
				
				if (!(usernom == null || usernom.trim().isEmpty() || mail == null || mail.trim().isEmpty() || pass.trim().isEmpty() || a == 0 || b == 0 || c == 0)) {
					try{
						JOptionPane.showMessageDialog(null, " Essay 1");
						
						String sql = "UPDATE Accounts set Username=?, Email=? , Password=?, Role=? WHERE  Id =?;";
		                pst = con.prepareStatement(sql);

		                pst.setString(1, NameAdminInterface.getText());
		                pst.setString(2, EmailAdminInterface.getText());
		                pst.setString(3, h.doHashing(PasswordAdminInterface.getText()));
		                pst.setString(4, RoleAdminInterface.getText());
		                pst.setLong(5, select);
						
						
						
						
						//////////////////////////////////////////////////////////////////////////
						//String sql = "INSERT INTO Accounts VALUES (?,?,?,?,?);";
						/*
		                pst = con.prepareStatement(sql);
						pst.setString(2, NameAdminInterface.getText());
						pst.setString(3, EmailAdminInterface.getText());
						pst.setString(4, h.doHashing(PasswordAdminInterface.getText()));
						*/
						// Pour les Utilisateur 
						//pst.setString(5, "User"); 
						
						// Pour les Admin
						//pst.setString(5, "Admin");
						
						pst.execute();
						JOptionPane.showMessageDialog(null, "Nouvel utilisateur enregistré avec succès");
						con.commit();
						ClearData();
						LoadData();
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null, " L'inscription a échoué!!");
					/*
					try {
					con.close();
					} catch (SQLException ex) {
					Logger.getLogger(SignupUser.class.getName()).log(Level.SEVERE, null, ex);
					}
					return;
					*/
					}
				/*
				try {
				con.close();
				} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture !!");
				}
				*/
				}
				
				


////////////////////////////////////////////////////////////////////////////////////////////////////////
			}
		});
		DeleteBtnAdminInterface = new javax.swing.JButton();
		DeleteBtnAdminInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///////////////////////////////////////////////////////////////////////////////////////////////////////
				String nom = EmailAdminInterface.getText();
				
		        try{
		            String sql = "DELETE FROM Accounts WHERE Email = ?;";
		            pst = con.prepareStatement(sql);
		            pst.setString(1, EmailAdminInterface.getText());
		            //pst.setString(2, txtPassRegister.getText());
		            pst.execute();
		            JOptionPane.showMessageDialog(null, nom + " Delete Susccessfully");
		            con.commit();
		            ClearData();
	                LoadData();
	                /*
		            try {
		                con.close();
		                //JOptionPane.showMessageDialog(null, "Fermeture avec succe!!");
		                //this.dispose();
		                //Login login = new Login();
		                //login.setVisible(true);
		                //login.pack();
		                //login.setLocationRelativeTo(null);
		            } catch (SQLException ex) {
		                JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture !!");
		            }
		            */
		        }
		        catch(Exception el){
		            JOptionPane.showMessageDialog(null, "DEleteing Failed " + el);
		        }
		        /*
		        try {
		            con.close();
		            //JOptionPane.showMessageDialog(null, "Fermeture avec succe!!");
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Erreur lors de la fermeture !!");
		        }                                               
				*/
				
		        
				////////////////////////////////////////////////////////////////////////////////////////////////////////
			}
		});
		CancelBtnAdminInterface = new javax.swing.JButton();
		/*
		CancelBtnAdminInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ferme uniquement cette fenêtre sans quitter complètement l'application
				try {
					con.commit();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		*/
		CancelBtnAdminInterface.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});
		jButton7 = new javax.swing.JButton();
		jButton7.setFont(new Font("Tahoma", Font.PLAIN, 18));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(0, 102, 102));
		setUndecorated(true);

		jPanel2.setPreferredSize(new java.awt.Dimension(1400, 500));

		jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

		jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 36));
		jLabel1.setText("ADMINISTRATEUR");
        tbl.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String [] {
                    "ID", "NAME", "EMAIL", "PASSWORD", "ROLE"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            tbl.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblMouseClicked(evt);
                }
            });
            jScrollPane1.setViewportView(tbl);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel1)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 760, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addComponent(jLabel1)
					.addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		jPanel1.setLayout(jPanel1Layout);

		jPanel3.setPreferredSize(new java.awt.Dimension(600, 500));

		jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18));
		jLabel3.setText("NAME");

		jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18));
		jLabel4.setText("EMAIL");

		jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18));
		jLabel5.setText("PASSWORD");

		NameAdminInterface.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18));

		EmailAdminInterface.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18));

		PasswordAdminInterface.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18));

		AddBtnAdminInterface.setFont(new java.awt.Font("Segoe UI", 0, 18));
		AddBtnAdminInterface.setText("ADD");

		ModifyBtnAdminInterface.setFont(new java.awt.Font("Segoe UI", 0, 18));
		ModifyBtnAdminInterface.setText("MODIFY");

		DeleteBtnAdminInterface.setFont(new java.awt.Font("Segoe UI", 0, 18));
		DeleteBtnAdminInterface.setText("DELETE");

		CancelBtnAdminInterface.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24));
		CancelBtnAdminInterface.setText("EXIT");

		jButton7.setText("X");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});
		
		JButton SaveBtnAdminInterface = new JButton();
		SaveBtnAdminInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.commit();
					ClearData();
	                LoadData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Saving Failed " + e1);
				}
			}
		});
		SaveBtnAdminInterface.setText("SAVE");
		SaveBtnAdminInterface.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 24));
		
		RoleAdminInterface = new JTextField();
		RoleAdminInterface.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));
		
		JLabel lblRole = new JLabel();
		lblRole.setText("ROLE");
		lblRole.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 18));

		// Création d'un layout manager GroupLayout pour jPanel3
		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3Layout.setHorizontalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addContainerGap(513, Short.MAX_VALUE)
					.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addGap(16)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel3)
								.addComponent(jLabel4)
								.addComponent(jLabel5))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addComponent(RoleAdminInterface, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
									.addComponent(NameAdminInterface, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
									.addComponent(EmailAdminInterface, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
									.addComponent(PasswordAdminInterface, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
								.addGroup(jPanel3Layout.createSequentialGroup()
									.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
										.addComponent(SaveBtnAdminInterface, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
										.addComponent(AddBtnAdminInterface, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
										.addGroup(jPanel3Layout.createSequentialGroup()
											.addComponent(ModifyBtnAdminInterface)
											.addGap(18)
											.addComponent(DeleteBtnAdminInterface))
										.addComponent(CancelBtnAdminInterface, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))))
							.addGap(40))))
		);
		jPanel3Layout.setVerticalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addComponent(jButton7)
					.addGap(74)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel3)
						.addComponent(NameAdminInterface, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel4)
						.addComponent(EmailAdminInterface, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel5)
						.addComponent(PasswordAdminInterface, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addComponent(RoleAdminInterface, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
							.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(AddBtnAdminInterface, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(ModifyBtnAdminInterface, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(DeleteBtnAdminInterface, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(SaveBtnAdminInterface, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(CancelBtnAdminInterface, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
							.addGap(29))
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		jPanel3.setLayout(jPanel3Layout);

		// Définition du layout pour jPanel2 (contient jPanel1 et jPanel3)
		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
		    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(jPanel2Layout.createSequentialGroup()
		            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		            .addGap(0, 0, Short.MAX_VALUE))
		);
		jPanel2Layout.setVerticalGroup(
		    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(jPanel2Layout.createSequentialGroup()
		            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		            .addGap(0, 0, Short.MAX_VALUE))
		);

		// Définition du layout principal de la fenêtre
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
		    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(layout.createSequentialGroup()
		            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		            .addGap(0, 0, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
		    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		        .addGroup(layout.createSequentialGroup()
		            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		            .addGap(0, 0, Short.MAX_VALUE))
		);

		pack(); // Ajuste automatiquement la taille de la fenêtre en fonction du contenu

	}
	
	
	// Méthode exécutée lorsqu'on clique sur le bouton "X" (fermeture de la fenêtre)
	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt){
		
		this.dispose();// Ferme uniquement cette fenêtre sans quitter complètement l'application
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
    	int currentRow = tbl.getSelectedRow();
		//System.out.println(currentRow);
		select = (int) tbl.getValueAt(currentRow, 0);
		System.out.println(select);
		NameAdminInterface.setText(tbl.getValueAt(currentRow, 1).toString()); 
		EmailAdminInterface.setText(tbl.getValueAt(currentRow, 2).toString());
		PasswordAdminInterface.setText(tbl.getValueAt(currentRow, 3).toString());
		RoleAdminInterface.setText(tbl.getValueAt(currentRow, 4).toString());
    }//GEN-LAST:event_tblMouseClicked

	
	

	public static void main(String args[]) {

	    // Appliquer le look & feel "Nimbus" si disponible
	    try {
	        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) { // Vérifie si le thème "Nimbus" est disponible
	                javax.swing.UIManager.setLookAndFeel(info.getClassName()); // Applique le thème
	                break; // Sort de la boucle après avoir trouvé Nimbus
	            }
	        }
	    } catch (ClassNotFoundException ex) {
	        // Gère l'exception si la classe du look & feel n'est pas trouvée
	        java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (InstantiationException ex) {
	        // Gère l'exception si une instance du look & feel ne peut pas être créée
	        java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (IllegalAccessException ex) {
	        // Gère l'exception si l'accès au look & feel est interdit
	        java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	        // Gère l'exception si le look & feel n'est pas supporté
	        java.util.logging.Logger.getLogger(AdminInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    }

	    // Démarrage de l'application sur le thread de l'interface graphique (EDT - Event Dispatch Thread)
	    java.awt.EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            new AdminInterface().setVisible(true); // Création et affichage de la fenêtre principale
	        }
	    });
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 784c5544ee9715468946d9f4d4d767259fb2ea52
