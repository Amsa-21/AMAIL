package graphique;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import messagerie.Mail;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consultation extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldExpediteur;
	private JTextField textFieldObjet;
	private JTextArea textMail;
	private JButton btnretour;
	private JButton btnRepondre;
	private Mail mail;
	
	public Consultation(Mail mail) {
		this.mail = mail;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("AMAIL");
		setSize(new Dimension(695, 595));
		getContentPane().setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Arial", Font.PLAIN, 15));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email de l'exp\u00E9diteur : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 167, 27);
		panel_2.add(lblNewLabel);
		
		textFieldExpediteur = new JTextField();
		textFieldExpediteur.setEditable(false);
		textFieldExpediteur.setFont(new Font("Arial", Font.PLAIN, 17));
		textFieldExpediteur.setBounds(179, 10, 490, 27);
		panel_2.add(textFieldExpediteur);
		textFieldExpediteur.setColumns(10);
		textFieldObjet = new JTextField();
		textFieldObjet.setEditable(false);
		textFieldObjet.setFont(new Font("Arial", Font.PLAIN, 17));
		textFieldObjet.setColumns(10);
		textFieldObjet.setBounds(179, 50, 490, 27);
		panel_2.add(textFieldObjet);
		
		JLabel lblObjetDuMail = new JLabel("Objet du mail : ");
		lblObjetDuMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObjetDuMail.setFont(new Font("Arial", Font.PLAIN, 17));
		lblObjetDuMail.setBounds(10, 50, 167, 27);
		panel_2.add(lblObjetDuMail);
		
		JLabel lblMessage = new JLabel("Message : ");
		lblMessage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMessage.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMessage.setBounds(10, 88, 167, 27);
		panel_2.add(lblMessage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(179, 88, 490, 424);
		panel_2.add(scrollPane);
		
		textMail = new JTextArea();
		textMail.setEditable(false);
		scrollPane.setViewportView(textMail);
		textMail.setFont(new Font("Arial", Font.PLAIN, 17));
		textMail.setLineWrap(true);
		textMail.setWrapStyleWord(true);
		
		textFieldExpediteur.setText(mail.getExpediteur());
		textFieldObjet.setText(mail.getObjet());
		textMail.setText(mail.getMessage());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_1, BorderLayout.SOUTH);
		
		btnRepondre = new JButton("R\u00E9pondre");
		btnRepondre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAnswerClicked();
			}
		});
		btnRepondre.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_1.add(btnRepondre);
		
		btnretour = new JButton("Retour");
		btnretour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnretour.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_1.add(btnretour);
		
	}
	
	public void run() {
		setVisible(true);
	}

	public void onAnswerClicked() {
		dispose();
		EnvoiMail ui = new EnvoiMail(mail.getDestinataire(), mail.getExpediteur(), "Répondre", 1, mail.getObjet());
		ui.run();
	}
}
