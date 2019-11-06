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
		
		Object data[][] = new Object[lesMenus.size()][3];
		for(Menu menu : lesMenus){
			prix = 0;
			data[i][0] = menu.getIdMenu();
			data[i][2] = menu.getPlatM().getNomP();
			prix = menu.getPlatM().getPrixP();
			data[i][3] = menu.getDessertM().getNomD();
			prix = menu.getDessertM().getPrixD();
			if(menu.getAlcoolM() == null){
				data[i][4] = menu.getAlcoolM().getNomB();
				prix = menu.getAlcoolM().getPrixB();
			}
			else{
				data[i][4] = menu.getSoftM().getNomB();
				prix = menu.getSoftM().getPrixB();
			}
			data[i][5] = prix + "€";
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
