import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class Panel_Plat extends JPanel implements ActionListener{

	private JLabel lblNb;
	private JTable tableau;
	private JButton boutonAjouter;
	private JPanel panelHaut;
	private JPanel panelBas;
	
	public Panel_Plat(int nbPlat, ArrayList<Plat> lesPlats, JFrame fenetre){

		this.setLayout(new BorderLayout());
		
		this.boutonAjouter = new JButton("Ajouter un plat");
		this.boutonAjouter.addActionListener( new ActionBoutonPlat(fenetre, lesPlats, nbPlat));
		
		this.panelHaut = new JPanel();
		this.panelBas = new JPanel();
		this.panelHaut.setLayout(new BorderLayout());
		
		lblNb = new JLabel("Nombre de plats : " + nbPlat);
		
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
		
		this.panelBas.add(scrollPane);
		
		/*GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.panelHaut.add(lblNb, c);
		c.gridx = 1;
		c.gridy = 0;
		this.panelHaut.add(boutonAjouter, c);*/
		
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
