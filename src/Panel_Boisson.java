import java.util.ArrayList;

import javax.swing.*;


public class Panel_Boisson extends JPanel{

	private JLabel lblNb;
	private JTable tableau;
	
	public Panel_Boisson(int nbBoissons, ArrayList<Boisson> lesBoissons){
		
		lblNb = new JLabel("Nombre de boissons : " + nbBoissons);
		
		this.add(lblNb);
		
		int i = 0;
		
		Object data[][] = new Object[lesBoissons.size()][5];
		for(Boisson boisson : lesBoissons){
			data[i][0] = boisson.getIdBoisson();
			data[i][1] = boisson.getNomB();
			data[i][2] = boisson.getPrixB()+"€";
			data[i][3] = boisson.getQteB();
			if(boisson instanceof Soft){
				data[i][4] = ((Soft) boisson).getTauxSucre()+"g";
			}
			else{
				data[i][4] = ((Alcool) boisson).getDegreAlcool()+"°";
			}
			
			i += 1;
		}
		String [] title = {"Id", "Nom", "Prix", "Quantité", "Tx sucre/° alcool"};
		this.tableau = new JTable(data,title);
		JScrollPane scrollPane = new JScrollPane(tableau);
		this.add(scrollPane);
	}
}
