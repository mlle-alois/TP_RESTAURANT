import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;


public class Panel_Menus extends JPanel{
	
	private JLabel lblNb;
	private JTable tableau;
	private JPanel panelHaut;
	private JPanel panelBas;

	public Panel_Menus(int nbMenus, ArrayList<Menu> lesMenus, JFrame fenetre){

		this.setLayout(new BorderLayout());
		
		this.panelHaut = new JPanel();
		this.panelBas = new JPanel();
		
		lblNb = new JLabel("Nombre de menus : " + nbMenus);
		
		this.add(lblNb);
		
		int i = 0;
		float prix;
		
		Object data[][] = new Object[nbMenus][5];
		for(Menu menu : lesMenus){
			prix = 0;
			data[i][0] = menu.getIdMenu();
			data[i][1] = menu.getPlatM().getNomP();
			prix = prix + menu.getPlatM().getPrixP();
			data[i][2] = menu.getDessertM().getNomD();
			prix = prix + menu.getDessertM().getPrixD();
			data[i][3] = menu.getBoissonM().getNomB();
			prix = prix + menu.getBoissonM().getPrixB();
			data[i][4] = prix + "€";
			i += 1;
		}
		String [] title = {"Id", "Plat", "Dessert", "Boisson", "Prix"};
		this.tableau = new JTable(data,title);
		JScrollPane scrollPane = new JScrollPane(tableau);
		
		this.panelBas.add(scrollPane);
		
		this.panelHaut.add(lblNb);
		
		this.add(panelHaut, BorderLayout.NORTH);
		this.add(panelBas, BorderLayout.CENTER);
	}
	
}
