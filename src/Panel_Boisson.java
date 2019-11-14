import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.*;


public class Panel_Boisson extends JPanel{

	private JLabel lblNb;
	private JTable tableau;
	private JButton boutonXML;
	private JPanel panelHaut;
	private JPanel panelMilieu;
	private JPanel panelBas;
	
	public Panel_Boisson(int nbBoissons, ArrayList<Boisson> lesBoissons, JFrame fenetre){

		this.setLayout(new BorderLayout());
		
		this.boutonXML = new JButton("Voir XML");
		this.boutonXML.setName("Boisson");
		this.boutonXML.addActionListener( new ActionBoutonXML(lesBoissons, boutonXML, nbBoissons, fenetre));
		
		this.panelHaut = new JPanel();
		this.panelMilieu = new JPanel();
		this.panelBas = new JPanel();
		this.panelBas.setLayout(new GridBagLayout());
		
		lblNb = new JLabel("Nombre de boissons : " + nbBoissons);
		
		this.add(lblNb);
		
		int i = 0;
		
		Object data[][] = new Object[lesBoissons.size()][5];
		for(Boisson boisson : lesBoissons){
			data[i][0] = boisson.getIdBoisson();
			data[i][1] = boisson.getNomB();
			data[i][2] = boisson.getPrixB()+"�";
			data[i][3] = boisson.getQteB();
			if(boisson instanceof Soft){
				data[i][4] = ((Soft) boisson).getTauxSucre()+"g";
			}
			else{
				data[i][4] = ((Alcool) boisson).getDegreAlcool()+"�";
			}
			
			i += 1;
		}
		String [] title = {"Id", "Nom", "Prix", "Quantit�", "Tx sucre/� alcool"};
		this.tableau = new JTable(data,title);
		JScrollPane scrollPane = new JScrollPane(tableau);
		
		this.panelMilieu.add(scrollPane);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		panelBas.add(boutonXML, c);
		
		this.panelHaut.add(lblNb);
		
		this.add(panelHaut, BorderLayout.NORTH);
		this.add(panelMilieu, BorderLayout.CENTER);
		this.add(panelBas, BorderLayout.SOUTH);
	}
}
