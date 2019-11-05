import java.util.ArrayList;

import javax.swing.*;


public class Panel_Dessert extends JPanel{

	private JLabel lblNb;
	private JTable tableau;
	
	public Panel_Dessert(int nbDesserts, ArrayList<Dessert> lesDesserts){
		
		lblNb = new JLabel("Nombre de desserts : " + nbDesserts);
		
		this.add(lblNb);
		
		int i = 0;
		
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
		this.add(scrollPane);
	}
}
