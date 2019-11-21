import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_Dessert extends JPanel{

	private JLabel lblNb;
	private JTable tableau;
	private JPanel panelHaut;
	private JPanel panelMilieu;
	private JPanel panelBas;
	private JButton boutonJSon;
	private JButton boutonXML;
	
	/**
	 * Constructeur du panel des desserts
	 * @param nbDesserts
	 * @param lesDesserts
	 * @param fenetre
	 */
	public Panel_Dessert(int nbDesserts, ArrayList<Dessert> lesDesserts, JFrame fenetre){

		this.setLayout(new BorderLayout());

		//définition, nommage et action des boutons
		this.boutonXML = new JButton("Voir XML");
		this.boutonXML.setName("Dessert");
		this.boutonJSon = new JButton("Voir JSon");
		this.boutonJSon.addActionListener( new ActionBoutonJSon(fenetre, lesDesserts, nbDesserts, boutonJSon));
		this.boutonXML.addActionListener( new ActionBoutonXML(fenetre, lesDesserts, boutonXML, nbDesserts));
		
		//définition des panels
		this.panelHaut = new JPanel();
		this.panelMilieu = new JPanel();
		this.panelBas = new JPanel();
		this.panelBas.setLayout(new GridBagLayout());
		
		//définition du label
		lblNb = new JLabel("Nombre de desserts : " + nbDesserts);
		
		this.add(lblNb);
		
		int i = 0;
		//tableau des desserts
		Object data[][] = new Object[lesDesserts.size()][3];
		for(Dessert dessert : lesDesserts){
			data[i][0] = dessert.getIdDessert();
			data[i][1] = dessert.getNomD();
			data[i][2] = dessert.getPrixD()+"€";
			i += 1;
		}
		String [] title = {"Id", "Nom", "Prix"};
		this.tableau = new JTable(data,title);
		JScrollPane scrollPane = new JScrollPane(tableau);

		this.panelMilieu.add(scrollPane);
		
		//ajout des éléments aux panels
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		panelBas.add(boutonXML, c);
		c.gridx = 1;
		c.gridy = 0;
		panelBas.add(boutonJSon, c);
		
		this.panelHaut.add(lblNb);
		
		this.add(panelHaut, BorderLayout.NORTH);
		this.add(panelMilieu, BorderLayout.CENTER);
		this.add(panelBas, BorderLayout.SOUTH);
	}
}
