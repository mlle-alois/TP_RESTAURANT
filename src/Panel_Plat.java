import java.util.ArrayList;

import javax.swing.*;


public class Panel_Plat extends JPanel{

	private JLabel lblNb;
	private JTable tableau;
	
	public Panel_Plat(int nbPlat, ArrayList<Plat> lesPlats){
		
		lblNb = new JLabel("Nombre de plats : " + nbPlat);
		
		this.add(lblNb);
		
		int i = 0;
		
		Object data[][] = new Object[lesPlats.size()][3];
		for(Plat plat : lesPlats){
			data[i][0] = plat.getIdPlat();
			data[i][1] = plat.getNomP();
			data[i][2] = plat.getPrixP()+"€";
			i += 1;
		}
		String [] title = {"Id", "Nom", "Prix"};
		this.tableau = new JTable(data,title);
		JScrollPane scrollPane = new JScrollPane(tableau);
		this.add(scrollPane);
	}
}
