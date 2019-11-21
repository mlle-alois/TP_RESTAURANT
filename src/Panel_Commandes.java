import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_Commandes extends JPanel implements ActionListener{

	private JLabel lblNb;
	private JTable tableau;
	private JButton boutonAjouter;
	private JPanel panelHaut;
	private JPanel panelBas;
	
	/**
	 * Constructeur du panel des commandes
	 * @param fenetre
	 * @param lesCommandes
	 * @param nbCommandes
	 */
	public Panel_Commandes(JFrame fenetre, ArrayList<Commande> lesCommandes, int nbCommandes){

		this.setLayout(new BorderLayout());

		//définition, nommage et action des boutons
		this.boutonAjouter = new JButton("Passer une commande");
		this.boutonAjouter.setName("Commande");
		this.boutonAjouter.addActionListener( new ActionBouton(lesCommandes, fenetre, nbCommandes, boutonAjouter));
		
		//définition des panels
		this.panelHaut = new JPanel();
		this.panelBas = new JPanel();
		this.panelHaut.setLayout(new BorderLayout());
		
		//définition du label
		lblNb = new JLabel("Nombre de commandes : " + nbCommandes);
		
		//tableau des commandes
		int i = 0;
		Object data[][] = new Object[nbCommandes][3];
		for(Commande commande : lesCommandes){
			data[i][0] = commande.getIdCommande();
			data[i][1] = commande.getNbCouverts();
			data[i][2] = commande.getDateCommande();
			i += 1;
		}
		String [] title = {"Numéro de commande", "Nombre de couverts", "Date de la commande"};
		this.tableau = new JTable(data,title);
		JScrollPane scrollPane = new JScrollPane(tableau);
		
		//ajout des élements aux panels
		this.panelBas.add(scrollPane);
		
		this.panelHaut.add(lblNb, BorderLayout.WEST);
		this.panelHaut.add(boutonAjouter, BorderLayout.EAST);
		
		this.add(panelHaut, BorderLayout.NORTH);
		this.add(panelBas, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
