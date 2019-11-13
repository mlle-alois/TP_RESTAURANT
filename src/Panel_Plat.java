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
	private JButton boutonSupprimer;
	private JButton boutonXML;
	private JButton boutonCSV;
	private JPanel panelHaut;
	private JPanel panelDroite;
	private JPanel panelMilieu;
	private JPanel panelBas;
	
	public Panel_Plat(int nbPlat, ArrayList<Plat> lesPlats, JFrame fenetre){

		this.setLayout(new BorderLayout());
		
		this.boutonAjouter = new JButton("Ajouter un plat");
		this.boutonSupprimer = new JButton("Supprimer un plat");
		this.boutonXML = new JButton("Voir XML");
		this.boutonCSV = new JButton("Voir CSV");
		this.boutonAjouter.setName("Plat");
		this.boutonSupprimer.setName("PlatS");
		this.boutonXML.setName("Plat");
		this.boutonAjouter.addActionListener( new ActionBouton(fenetre, lesPlats, nbPlat, boutonAjouter));
		this.boutonSupprimer.addActionListener( new ActionBouton(fenetre, lesPlats, nbPlat, boutonSupprimer));
		this.boutonXML.addActionListener( new ActionBoutonXML(fenetre, lesPlats, nbPlat, boutonXML));
		this.boutonCSV.addActionListener( new ActionBoutonCSV(fenetre, lesPlats, nbPlat, boutonCSV));
		
		this.panelHaut = new JPanel();
		this.panelDroite = new JPanel();
		this.panelMilieu = new JPanel();
		this.panelBas = new JPanel();
		this.panelDroite.setLayout(new GridBagLayout());
		this.panelBas.setLayout(new GridBagLayout());
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
		
		this.panelMilieu.add(scrollPane);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		panelDroite.add(boutonAjouter, c);
		panelBas.add(boutonXML, c);
		c.gridx = 1;
		c.gridy = 0;
		panelBas.add(boutonCSV, c);
		c.gridx = 0;
		c.gridy = 1;
		panelDroite.add(boutonSupprimer, c);
		
		this.panelHaut.add(lblNb, BorderLayout.WEST);
		this.panelHaut.add(panelDroite, BorderLayout.EAST);
		this.panelBas.add(boutonXML);
		
		this.add(panelHaut, BorderLayout.NORTH);
		this.add(panelMilieu, BorderLayout.CENTER);
		this.add(panelBas, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
