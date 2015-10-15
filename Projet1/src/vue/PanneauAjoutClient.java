package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Client;
import controller.Marque;
import controller.Telephone;

/**
 * @authors Ludovic CHEVRAUX & Axel GIRARD
 * 
 */
@SuppressWarnings("serial")
public class PanneauAjoutClient extends PanneauAjout{
	private JLabel lblClient;
	private JLabel lblNom;
	private final JTextField jtfNom;
	private JLabel lblPrenom;
	private final JTextField jtfPrenom;
	private JLabel lblTel;
	private JLabel lblRef;
	private final JTextField jtfRef;
	private JLabel lblIntitule;
	private final JTextField jtfIntitule;
	private JLabel lblPrix;
	private final JTextField jtfPrix;
	private JLabel lblNum;
	private final JTextField jtfNum;
	private JLabel lblMarque;
	private final JTextField jtfMarque;

	public PanneauAjoutClient(Fenetre fen){
		super(fen);

		lblClient = new JLabel("Données du client");
		lblClient.setPreferredSize(new Dimension(largeur, hauteur));
		lblClient.setHorizontalAlignment(JLabel.LEFT);

		lblNom = new JLabel("Nom : ");
		lblNom.setPreferredSize(new Dimension(largeur/3, hauteur));
		lblNom.setHorizontalAlignment(JLabel.RIGHT);

		jtfNom = new JTextField();
		jtfNom.setPreferredSize(new Dimension((largeur/3)*2, hauteur));

		lblPrenom = new JLabel("Prenom : ");
		lblPrenom.setPreferredSize(new Dimension(largeur/3, hauteur));
		lblPrenom.setHorizontalAlignment(JLabel.RIGHT);

		jtfPrenom = new JTextField();
		jtfPrenom.setPreferredSize(new Dimension(largeur/3*2, hauteur));

		lblTel = new JLabel("Données du téléphone");
		lblTel.setPreferredSize(new Dimension(largeur, hauteur));
		lblTel.setHorizontalAlignment(JLabel.LEFT);
		
		lblRef = new JLabel("Ref : ");
		lblRef.setPreferredSize(new Dimension(largeur/3, hauteur));
		lblRef.setHorizontalAlignment(JLabel.RIGHT);

		jtfRef = new JTextField();
		jtfRef.setPreferredSize(new Dimension((largeur/3)*2, hauteur));

		lblIntitule = new JLabel("Intitule : ");
		lblIntitule.setPreferredSize(new Dimension(largeur/3, hauteur));
		lblIntitule.setHorizontalAlignment(JLabel.RIGHT);

		jtfIntitule = new JTextField();
		jtfIntitule.setPreferredSize(new Dimension(largeur/3*2, hauteur));

		lblPrix = new JLabel("Prix : ");
		lblPrix.setPreferredSize(new Dimension(largeur/3, hauteur));
		lblPrix.setHorizontalAlignment(JLabel.RIGHT);

		jtfPrix = new JTextField();
		jtfPrix.setPreferredSize(new Dimension(largeur/3*2, hauteur));

		lblNum = new JLabel("Num : ");
		lblNum.setPreferredSize(new Dimension(largeur/3, hauteur));
		lblNum.setHorizontalAlignment(JLabel.RIGHT);

		jtfNum = new JTextField();
		jtfNum.setPreferredSize(new Dimension(largeur/3*2, hauteur));

		lblMarque = new JLabel("Marque : ");
		lblMarque.setPreferredSize(new Dimension(largeur/3, hauteur));
		lblMarque.setHorizontalAlignment(JLabel.RIGHT);

		jtfMarque = new JTextField();
		jtfMarque.setPreferredSize(new Dimension(largeur/3*2, hauteur));

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.insets.top = 0;
		panel.add(lblClient, gbc);
		//--------------------------------------------
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		panel.add(lblNom, gbc);

		gbc.gridx = 1;
		panel.add(jtfNom, gbc);
		//---------------------------------------------
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.insets.top = 3;
		panel.add(lblPrenom, gbc);

		gbc.gridx = 1;
		panel.add(jtfPrenom, gbc);
		//---------------------------------------------
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		panel.add(lblTel, gbc);
		//---------------------------------------------
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		panel.add(lblRef, gbc);

		gbc.gridx = 1;
		panel.add(jtfRef, gbc);
		//---------------------------------------------
		gbc.gridy++;
		gbc.gridx = 0;
		panel.add(lblIntitule, gbc);

		gbc.gridx = 1;
		panel.add(jtfIntitule, gbc);
		//---------------------------------------------
		gbc.gridy++;
		gbc.gridx = 0;
		panel.add(lblPrix, gbc);

		gbc.gridx = 1;
		panel.add(jtfPrix, gbc);
		//---------------------------------------------
		gbc.gridy++;
		gbc.gridx = 0;
		panel.add(lblNum, gbc);

		gbc.gridx = 1;
		panel.add(jtfNum, gbc);
		//---------------------------------------------
		gbc.gridy++;
		gbc.gridx = 0;
		panel.add(lblMarque, gbc);

		gbc.gridx = 1;
		panel.add(jtfMarque, gbc);
	}

	/**
	 * Affiche le menu de base
	 */
	public void menu() {
		initialiserChamps();

		lbl.setFont(police);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setVerticalAlignment(JLabel.CENTER);
		lbl.setText("Ajout d'un nouveau client");
		lbl.setPreferredSize(new Dimension(300, 70));

		jtfNom.setText("");
		jtfPrenom.setText("");
		jtfRef.setText("");
		jtfIntitule.setText("");
		jtfPrix.setText("");
		jtfNum.setText("");
		jtfMarque.setText("");

		btnVldr.setText("Créer client");
		btnVldr.removeActionListener(editer);
		btnVldr.removeActionListener(creer);
		btnVldr.addActionListener(creer);
	}

	/**
	 * Edite un client
	 * @param c le Client à éditer
	 */
	public void editer(){
		lbl.setText("Modifier client");

		initialiserChamps();

		jtfNom.setText(c.getNom());
		jtfPrenom.setText(c.getPrenom());
		jtfRef.setText(Integer.toString(c.getTel().getRef()));
		jtfIntitule.setText(c.getTel().getIntitule());
		jtfPrix.setText(Float.toString(c.getTel().getPrix()));
		jtfNum.setText(c.getTel().getNumero());
		jtfMarque.setText(c.getTel().getMarque().getNom());

		btnVldr.setText("Editer Client");
		btnVldr.removeActionListener(creer);
		btnVldr.removeActionListener(editer);
		btnVldr.addActionListener(editer);
	}

	/**
	 * Initialise la couleur de fond des champs de text
	 */
	public void initialiserChamps(){
		jtfNom.setBackground(Color.WHITE);
		jtfPrenom.setBackground(Color.WHITE);
		jtfRef.setBackground(Color.WHITE);
		jtfIntitule.setBackground(Color.WHITE);
		jtfPrix.setBackground(Color.WHITE);
		jtfNum.setBackground(Color.WHITE);
		jtfMarque.setBackground(Color.WHITE);
	}

	/**
	 * détecte les erreurs de saisie puis traite les données (sans vulgarités)
	 * @param creer si vrai créer un utilisateur sinon l'édite
	 */
	public void test(boolean creer){
		initialiserChamps();
		if(jtfNom.getText().length() != 0){
			if(jtfPrenom.getText().length() != 0){
				if(jtfRef.getText().length() != 0 && isNumeric(jtfRef.getText())){
					if(jtfIntitule.getText().length() != 0){
						if(jtfPrix.getText().length() != 0 && isNumeric(jtfPrix.getText())){
							if(jtfNum.getText().length() != 0){
								if(jtfMarque.getText().length() != 0){
									if(creer){
										fen.getClients().add(new Client(jtfNom.getText(), jtfPrenom.getText(),
												new Telephone(Integer.parseInt(jtfRef.getText()), jtfIntitule.getText(),
												Float.parseFloat(jtfPrix.getText()), jtfNum.getText(), null, new Marque(jtfMarque.getText()))));
										fen.menu();
									}
									else{
										c.setNom(jtfNom.getText());
										c.setPrenom(jtfPrenom.getText());
										c.getTel().setRef(Integer.parseInt(jtfRef.getText()));
										c.getTel().setIntitule(jtfIntitule.getText());
										c.getTel().setPrix(Float.parseFloat(jtfPrix.getText()));
										c.getTel().getMarque().setNom(jtfMarque.getText());
										fen.menu();
									}
								}
								else{
									jtfMarque.setBackground(Color.RED);
								}
							}
							else{
								jtfNum.setBackground(Color.RED);
							}
						}
						else{
							jtfPrix.setBackground(Color.RED);
						}
					}
					else{
						jtfIntitule.setBackground(Color.RED);
					}
				}
				else{
					jtfRef.setBackground(Color.RED);
				}
			}
			else{
				jtfPrenom.setBackground(Color.RED);
			}
		}
		else{
			jtfNom.setBackground(Color.RED);
		}
	}
	@Override
	public void actionListener() {
		creer = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				test(true);
			}
		};
		editer = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				test(false);
			}
		};
	}
}
