package graphique;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import connection.DaoMail;
import connection.DaoUser;
import messagerie.Mail;
import messagerie.Utilisateur;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Messagerie extends JFrame {
	private static final long serialVersionUID = 1L;
	Authentification authentification;
	private JTable table;
	private JButton btnNewButton_1;
	private JButton btnSupprimerCeMail;
	private AbstractButton btnConsulterCeMail;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JPanel panel_5;
	private JButton btnMailsRecus;
	private JButton btnMailsEnvoyes;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	String email;
	int id;
	
	public Messagerie(Authentification ui, String email, int id) {

		this.id = id;
		this.email = email;
		this.authentification = ui;
		
		setTitle("AMAIL");
		setSize(new Dimension(945, 795));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 11, 910, 56);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AMAIL, Messagerie s\u00FBre et fiable");
		lblNewLabel.setBounds(10, 11, 890, 34);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(235, 112, 685, 634);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 665, 612);
		panel_2.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Expediteur", "Objet"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		try {
			lister();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(10, 261, 215, 114);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		btnNewButton = new JButton("Nouveau mail");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnvoiMail ui = new EnvoiMail(email, null, "Nouveau mail", 0, null);
				ui.run();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 11, 195, 23);
		panel_3.add(btnNewButton);
		
		btnConsulterCeMail = new JButton("Consulter ce mail");
		btnConsulterCeMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onConsultClicked();
			}
		});
		btnConsulterCeMail.setFont(new Font("Arial", Font.PLAIN, 15));
		btnConsulterCeMail.setBounds(10, 45, 195, 23);
		panel_3.add(btnConsulterCeMail);
		
		btnSupprimerCeMail = new JButton("Supprimer ce mail");
		btnSupprimerCeMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onDeleteClicked();
			}
		});
		btnSupprimerCeMail.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSupprimerCeMail.setBounds(10, 79, 195, 23);
		panel_3.add(btnSupprimerCeMail);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(10, 691, 215, 55);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		btnNewButton_1 = new JButton("D\u00E9connection");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onExitClicked();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 17));
		btnNewButton_1.setBounds(10, 11, 195, 33);
		panel_4.add(btnNewButton_1);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBounds(10, 157, 215, 80);
		panel.add(panel_5);
		lblNewLabel_2 = new JLabel("Bo\u00EEte de r\u00E9ception");
		btnMailsRecus = new JButton("Mails re\u00E7us");
		btnMailsRecus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onReceptionClicked();
			}
		});
		btnMailsRecus.setFont(new Font("Arial", Font.PLAIN, 15));
		btnMailsRecus.setBounds(10, 11, 195, 23);
		panel_5.add(btnMailsRecus);
		
		btnMailsEnvoyes = new JButton("Mails envoy\u00E9s");
		btnMailsEnvoyes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSendListClicked();
			}
		});
		btnMailsEnvoyes.setFont(new Font("Arial", Font.PLAIN, 15));
		btnMailsEnvoyes.setBounds(10, 45, 195, 23);
		panel_5.add(btnMailsEnvoyes);
		
		naming();
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(10, 78, 338, 23);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_2.setBounds(394, 78, 369, 23);
		panel.add(lblNewLabel_2);
	}
	
	protected void onDeleteClicked() {
		int i = table.getSelectedRow();
		if(i < 0) {
			JOptionPane.showMessageDialog(null, "Aucun mail selectionné !");
		} else {
			int reponse = JOptionPane.showConfirmDialog(null, "Sure ?");
			if(reponse == JOptionPane.YES_OPTION) {
				try {
					Utilisateur user = DaoUser.read(id);
					String destinataire = user.getEmail();
					String expediteur = model.getValueAt(i, 0).toString();
					String objet = model.getValueAt(i, 1).toString();
					Mail mail = new Mail(destinataire, expediteur, objet);
					DaoMail.delete(DaoMail.checkMail(mail));
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Supprimé avec succès !");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		}	
	}

	protected void onExitClicked() {
		int rep = JOptionPane.showConfirmDialog(null, "Etes-vous sûre de vouloir vous déconnecter ?");
		if(rep == JOptionPane.YES_OPTION) {
			dispose();
			authentification.run();
		}
	}

	protected void onReceptionClicked() {
		lblNewLabel_2.setText("Bo\u00EEte de r\u00E9ception");
		viderTable();
		try {
			lister();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	protected void onSendListClicked() {
		lblNewLabel_2.setText("Bo\u00EEte d'envoie");
		viderTable();
		try {
			listerSend();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void onConsultClicked() {
		int i = table.getSelectedRow();
		if(i < 0) {
			JOptionPane.showMessageDialog(null, "Aucun mail selectionné !");
		} else {
			try {
				Utilisateur user = DaoUser.read(id);
				String destinataire = user.getEmail();
				String expediteur = model.getValueAt(i, 0).toString();
				String objet = model.getValueAt(i, 1).toString();
				Mail mail = new Mail(destinataire, expediteur, objet);
				Mail mailRead = DaoMail.read(DaoMail.checkMail(mail));
				Consultation ui = new Consultation(mailRead);
				ui.run();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public void run() {
		setVisible(true);
	}
	
	public void close() {
		setVisible(false);
	}
	protected void lister() throws Exception {
		final Object[] row = new Object[2];
		List<Mail> mails = DaoMail.list(email);
		for(Mail mail:mails) {
			row[0] = mail.getExpediteur();
			row[1] = mail.getObjet();
			model.addRow(row);
		}
	}
	protected void listerSend() throws Exception {
		final Object[] row = new Object[2];
		List<Mail> mails = DaoMail.listSend(email);
		for(Mail mail:mails) {
			row[0] = mail.getExpediteur();
			row[1] = mail.getObjet();
			model.addRow(row);
		}
	}
	protected void viderTable() {
		for(int i = model.getRowCount(); i > 0; --i)
			model.removeRow(i-1);
	}
	
	protected void naming() {
		try {
			Utilisateur usr = DaoUser.read(id);
			lblNewLabel_1 = new JLabel("Bonjour, " + usr.getPrenom() + " " + usr.getNom());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
