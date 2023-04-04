package graphique;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import connection.DaoMail;
import connection.DaoUser;
import messagerie.Mail;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnvoiMail extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldDestinataire;
	private JTextField textFieldObjet;
	private JTextArea textMail;
	private JButton btnSend;
	private JButton btnCancel;
	private String expediteur;
	
	
	public EnvoiMail(String expediteur,String destinataire, String title, int a, String objet) {
		this.expediteur = expediteur;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMaximumSize(new Dimension(695, 595));
		setMinimumSize(new Dimension(695, 595));
		setSize(new Dimension(695, 595));
		setTitle(title);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Arial", Font.PLAIN, 15));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_1, BorderLayout.SOUTH);
		
		btnSend = new JButton("Envoyer");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSendClicked();
			}
		});
		btnSend.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_1.add(btnSend);
		btnSend.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_1.add(btnSend);
		
		btnCancel = new JButton("Annuler");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 17));
		panel_1.add(btnCancel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email du destinataire : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 10, 167, 27);
		panel_2.add(lblNewLabel);
		
		textFieldDestinataire = new JTextField();
		textFieldObjet = new JTextField();
		if(a == 1) {
			textFieldDestinataire.setEditable(false);
			textFieldDestinataire.setText(destinataire);
			textFieldObjet.setText("Réponse à : " + objet);
		}
		
		textFieldDestinataire.setToolTipText("Destinataire");
		textFieldDestinataire.setFont(new Font("Arial", Font.PLAIN, 17));
		textFieldDestinataire.setBounds(179, 10, 490, 27);
		panel_2.add(textFieldDestinataire);
		textFieldDestinataire.setColumns(10);
		
		
		textFieldObjet.setToolTipText("objet");
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
		scrollPane.setBounds(179, 88, 490, 420);
		panel_2.add(scrollPane);
		
		textMail = new JTextArea();
		scrollPane.setViewportView(textMail);
		textMail.setToolTipText("Message");
		textMail.setFont(new Font("Arial", Font.PLAIN, 17));
		textMail.setLineWrap(true);
		textMail.setWrapStyleWord(true);
	}


	public void run() {
		setVisible(true);
	}
	public void close() {
		setVisible(false);
	}
	public void onSendClicked() {
		String destinataire = textFieldDestinataire.getText();
		String objet = textFieldObjet.getText();
		String message = textMail.getText();
		try {
			if(destinataire.isEmpty() || objet.isEmpty() || message.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Veuillez renseigner tous les champs !");
			} else if(DaoUser.checkEmail(destinataire) == false) {
				JOptionPane.showMessageDialog(null, "Ce destinataire n'existe pas !");	
			} else {
				Mail mail = new Mail(destinataire, expediteur, objet, message);
				DaoMail.create(mail);
				dispose();
				JOptionPane.showMessageDialog(null, "Mail envoyé !");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}