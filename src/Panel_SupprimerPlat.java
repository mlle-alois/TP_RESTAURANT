import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.*;

public class Panel_SupprimerPlat extends JPanel{
	
	private JLabel lblErreur, lbl;
	private JTextField jtf;
	private JButton boutonSupprimerPlat, boutonAnnulerPlat;

	public Panel_SupprimerPlat(JFrame fenetre, ArrayList<Plat> lesPlats, int nbPlat){
		
		this.setLayout(new GridBagLayout());
		
		lblErreur = new JLabel();
		lbl = new JLabel("Num�ro du plat � supprimer : ");
		
		jtf = new JTextField();
		
		jtf.setPreferredSize(new Dimension(150,30));
		
		boutonSupprimerPlat = new JButton("Supprimer");
		boutonSupprimerPlat.setName("Plat");
		this.boutonSupprimerPlat.addActionListener(new ActionSupprimer(boutonSupprimerPlat, fenetre, lesPlats, nbPlat, jtf, lblErreur));
		
		this.boutonAnnulerPlat = new JButton("Annuler");
		this.boutonAnnulerPlat.setName("Plat");
		this.boutonAnnulerPlat.addActionListener(new ActionAnnulerAjout(boutonAnnulerPlat, fenetre, lesPlats, nbPlat));
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(lbl, c);
		c.gridx = 1;
		c.gridy = 0;
		this.add(jtf, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(boutonAnnulerPlat, c);
		c.gridx = 1;
		c.gridy = 1;
		this.add(boutonSupprimerPlat, c);
		c.gridx = 1;
		c.gridy = 2;
		this.add(lblErreur, c);
	}
	
}
