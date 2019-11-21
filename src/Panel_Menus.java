import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_Menus extends JPanel{
	
	private JLabel lblNb;
	private JTable tableau;
	private JButton boutonRechercher;
	private JButton boutonXML;
	private JPanel panelHaut;
	private JPanel panelMilieu;
	private JPanel panelBas;

	/**
	 * Constructeur du panel des menus
	 * @param nbMenus
	 * @param lesMenus
	 * @param fenetre
	 */
	public Panel_Menus(int nbMenus, ArrayList<Menu> lesMenus, JFrame fenetre){

		this.setLayout(new BorderLayout());

		//définition, nommage et action des boutons
		this.boutonRechercher = new JButton("Rechercher les menus d'un jour");
		this.boutonRechercher.setName("Menu");
		this.boutonXML = new JButton("Voir XML");
		this.boutonXML.setName("Menu");
		this.boutonRechercher.addActionListener( new ActionBouton(boutonRechercher, lesMenus, fenetre, nbMenus, -1));
		this.boutonXML.addActionListener( new ActionBoutonXML(fenetre, nbMenus, lesMenus, boutonXML));
		
		//définition des panels
		this.panelHaut = new JPanel();
		this.panelMilieu = new JPanel();
		this.panelBas = new JPanel();
		
		
		//définition du label
		lblNb = new JLabel("Nombre de menus : " + nbMenus);
		
		this.add(lblNb);
		
		int i = 0;
		float prix;
		
		//tableau des menus
		Object data[][] = new Object[nbMenus][5];
		for(Menu menu : lesMenus){
			prix = 0;
			data[i][0] = menu.getIdMenu();
			data[i][1] = menu.getPlatM().getNomP();
			prix = prix + menu.getPlatM().getPrixP();
			data[i][2] = menu.getDessertM().getNomD();
			prix = prix + menu.getDessertM().getPrixD();
			if(menu.getAlcoolM() == null){
				data[i][3] = menu.getSoftM().getNomB();
				prix = prix + menu.getSoftM().getPrixB();
			}
			else{
				data[i][3] = menu.getAlcoolM().getNomB();
				prix = prix + menu.getAlcoolM().getPrixB();
			}
			data[i][4] = prix + "€";
			i += 1;
		}
		String [] title = {"Id", "Plat", "Dessert", "Boisson", "Prix"};
		this.tableau = new JTable(data,title);
		JScrollPane scrollPane = new JScrollPane(tableau);
		
		this.panelMilieu.add(scrollPane);
		
		//ajout des éléments aux panels
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		panelBas.add(boutonXML, c);

		this.panelHaut.add(lblNb, BorderLayout.WEST);
		this.panelHaut.add(boutonRechercher, BorderLayout.EAST);
		
		this.add(panelHaut, BorderLayout.NORTH);
		this.add(panelMilieu, BorderLayout.CENTER);
		this.add(panelBas, BorderLayout.SOUTH);
		
		
		
	}
	
}
