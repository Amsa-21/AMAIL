package graphique;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.Dimension;
import connection.DaoUser;
import messagerie.Utilisateur;

import javax.swing.border.EtchedBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Authentification extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField emailField;
	private JPasswordField passwordField;
	private AbstractButton btnOK;
	private JButton btnCANCEL;
		
	public Authentification() {
		
		setSize(new Dimension(460, 319));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("AMAIL");
		getContentPane().setLayout(new GridLayout(3, 1, 0, 0));
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout_3 = (FlowLayout) panel.getLayout();
		flowLayout_3.setVgap(25);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Email : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(63, 9, 77, 21);
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1);
		
		emailField = new JTextField();
		emailField.setToolTipText("Email");
		emailField.setFont(new Font("Arial", Font.PLAIN, 17));
		emailField.setBounds(150, 7, 280, 26);
		panel_3.add(emailField);
		emailField.setColumns(20);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 9, 130, 21);
		lblNewLabel_2.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		panel_4.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Mot de passe");
		passwordField.setFont(new Font("Arial", Font.PLAIN, 17));
		passwordField.setBounds(150, 8, 280, 25);
		passwordField.setColumns(20);
		panel_4.add(passwordField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(25);
		getContentPane().add(panel_2);
		
		btnOK = new JButton("OK");
		btnOK.setFont(new Font("Arial", Font.PLAIN, 15));
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					onOkClick();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOK.setPreferredSize(new Dimension(100, 30));
		panel_2.add(btnOK);
		
		btnCANCEL = new JButton("CANCEL");
		btnCANCEL.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCANCEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCancelClick();
			}
		});
		btnCANCEL.setPreferredSize(new Dimension(100, 30));
		panel_2.add(btnCANCEL);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscription();
			}

			
		});
		btnSinscrire.setPreferredSize(new Dimension(100, 30));
		btnSinscrire.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_2.add(btnSinscrire);
	}
	
	protected void onOkClick() throws Exception {
		String email = emailField.getText();
		String password = String.valueOf(passwordField.getPassword());
		Utilisateur usr = new Utilisateur(email, password);
		int id = DaoUser.getDBId(usr);
		if(DaoUser.check(id) == true) {
			clear();
			close();
			Messagerie messagerie = new Messagerie(this, email, id);
			messagerie.run();
		}
		else {
			clear();
			JOptionPane.showMessageDialog(null, "Email ou Password erroné !");
		}
	}
	
	protected void onCancelClick() {
		clear();
		int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter ?");
		
		if (reponse == JOptionPane.YES_OPTION) {
			dispose();
			System.exit(0);
		}
	}
	
	protected void inscription() {
		close();
		CreationUtilisateur ui = new CreationUtilisateur(this);
		ui.run();
	}
	
	protected void clear () {
		//emailField.setText(null);
		passwordField.setText(null);
	}
	
	public void run () {
		setVisible(true);
	}
	
	public void close () {
		setVisible(false);
	}
}
