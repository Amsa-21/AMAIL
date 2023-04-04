package graphique;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import connection.DaoUser;
import messagerie.Utilisateur;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CreationUtilisateur extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textPrenom;
	private JTextField textNom;
	private JTextField textEmail;
	private JTextField textTelephone;
	private JTextField textAdresse;
	private JPasswordField textPassword;
	private JComboBox<Object> comboBoxAnnee;
	private JComboBox<Object> comboBoxMois;
	private JComboBox<Object> comboBoxJour;
	private String[] jours;
	private String[] mois;
	private String[] annee;
	Authentification authentification;
	
	public CreationUtilisateur(Authentification ui) {
		
		this.authentification = ui;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cr\u00E9ation de compte");
		setSize(new Dimension(452, 388));
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Information de l'utilisateur");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnSave = new JButton("Enregistrer");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRegisterClicked();
			}
		});
		btnSave.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_2.add(btnSave);
		
		JButton btnBack = new JButton("    Retour    ");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onBackClicked();
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_2.add(btnBack);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_4.add(lblNewLabel_1);
		
		textPrenom = new JTextField();
		textPrenom.setToolTipText("Pr\u00E9nom");
		textPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		textPrenom.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_4.add(textPrenom);
		textPrenom.setColumns(20);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_3.add(panel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom : ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1);
		
		textNom = new JTextField();
		textNom.setToolTipText("Nom");
		textNom.setHorizontalAlignment(SwingConstants.LEFT);
		textNom.setFont(new Font("Arial", Font.PLAIN, 17));
		textNom.setColumns(20);
		panel_5.add(textNom);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_3.add(panel_6);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email : ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_6.add(lblNewLabel_1_2);
		
		textEmail = new JTextField();
		textEmail.setToolTipText("Email");
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setFont(new Font("Arial", Font.PLAIN, 17));
		textEmail.setColumns(13);
		panel_6.add(textEmail);
		
		JLabel lblNewLabel_1_2_1 = new JLabel(" @amail.sn ");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_6.add(lblNewLabel_1_2_1);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panel_3.add(panel_7);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mot de passe : ");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_7.add(lblNewLabel_1_3);
		
		textPassword = new JPasswordField();
		textPassword.setToolTipText("Mot de passe");
		textPassword.setFont(new Font("Arial", Font.PLAIN, 17));
		textPassword.setColumns(20);
		panel_7.add(textPassword);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_8.getLayout();
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		panel_3.add(panel_8);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date de naissance : ");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_8.add(lblNewLabel_1_4);
		
		jours = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		comboBoxJour = new JComboBox<Object>();
		comboBoxJour.setModel(new DefaultComboBoxModel<Object>(jours));
		comboBoxJour.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_8.add(comboBoxJour);
		
		JLabel lblNewLabel_2 = new JLabel("/");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_8.add(lblNewLabel_2);
		
		mois = new String[] {"Janvier", "F\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao\u00FBt", "Septembre", "Octobre", "Novembre", "D\u00E9cembre"};
		comboBoxMois = new JComboBox<Object>();
		comboBoxMois.setModel(new DefaultComboBoxModel<Object>(mois));
		comboBoxMois.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_8.add(comboBoxMois);
		
		JLabel lblNewLabel_2_1 = new JLabel("/");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_8.add(lblNewLabel_2_1);
		
		annee = new String[] {"2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960"};
		comboBoxAnnee = new JComboBox<Object>();
		comboBoxAnnee.setModel(new DefaultComboBoxModel<Object>(annee));
		comboBoxAnnee.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_8.add(comboBoxAnnee);
		
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_9.getLayout();
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		panel_3.add(panel_9);
		
		JLabel lblNewLabel_1_5 = new JLabel("T\u00E9l\u00E9phone : ");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_9.add(lblNewLabel_1_5);
		
		textTelephone = new JTextField();
		textTelephone.setToolTipText("T\u00E9l\u00E9phone");
		textTelephone.setHorizontalAlignment(SwingConstants.LEFT);
		textTelephone.setFont(new Font("Arial", Font.PLAIN, 17));
		textTelephone.setColumns(20);
		panel_9.add(textTelephone);
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_10.getLayout();
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		panel_3.add(panel_10);
		
		JLabel lblNewLabel_1_6 = new JLabel("Adresse : ");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_10.add(lblNewLabel_1_6);
		
		textAdresse = new JTextField();
		textAdresse.setToolTipText("Adresse");
		textAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		textAdresse.setFont(new Font("Arial", Font.PLAIN, 17));
		textAdresse.setColumns(20);
		panel_10.add(textAdresse);
	}

	public void run() {
		setVisible(true);
	}

	public void close() {
		setVisible(false);
	}
	public void onRegisterClicked() {
		String prenom = textPrenom.getText();
		String nom = textNom.getText();
		String email = textEmail.getText() + "@amail.sn";
		String password = String.valueOf(textPassword.getPassword());
		String birthday = (String)comboBoxJour.getSelectedItem() + " " + (String)comboBoxMois.getSelectedItem() + " " + (String)comboBoxAnnee.getSelectedItem();
		String telephone = textTelephone.getText();
		String adresse = textAdresse.getText();
		
		try {
			if(prenom.isEmpty() || nom.isEmpty() || email.isEmpty() || password.isEmpty() || birthday.isEmpty() || telephone.isEmpty() || adresse.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Veuillez remplir toutes les cases !");
			}
			else if(password.length() < 6) {
				textPassword.setText(null);
				JOptionPane.showMessageDialog(null, "Mot de passe trop court !");
			}
			else if((int)Double.parseDouble((String)comboBoxAnnee.getSelectedItem()) > 2004) {
				JOptionPane.showMessageDialog(null, "Vous êtes mineur !");
			}
			else if(DaoUser.checkEmail(email)) {
				textEmail.setText(null);
				JOptionPane.showMessageDialog(null, "Adresse email déjà utilisée !");
			}
			else {
				Utilisateur usr = new Utilisateur(prenom, nom, email, password, birthday, telephone, adresse);
				DaoUser.create(usr);
				dispose();
				JOptionPane.showMessageDialog(null, "Compte créé avec succès !");
				authentification.run();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void onBackClicked() {
		dispose();
		authentification.run();
	}
}