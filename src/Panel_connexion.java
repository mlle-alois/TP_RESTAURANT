import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;


public class Panel_connexion extends JPanel{

	private JLabel lblMail;
	private JLabel lblMdp;
	private JLabel lblErreur;
	private JTextField jtfMail;
	private JPasswordField jpfMdp;
	private JButton boutonConnexion;
	
	public Panel_connexion(JMenuBar menu, JFrame fenetre){
		
		this.setLayout(new GridBagLayout());
		
		this.lblMail = new JLabel("Mail : ");
		this.lblMdp = new JLabel("Mot de passe : ");
		this.lblErreur = new JLabel();

		this.jtfMail = new JTextField();
		this.jpfMdp = new JPasswordField();
		
		this.jtfMail.setPreferredSize(new Dimension(150, 30));
		this.jpfMdp.setPreferredSize(new Dimension(150, 30));
		
		this.boutonConnexion = new JButton("Connexion !");
		this.boutonConnexion.addActionListener(new ActionBouton(menu, fenetre, jtfMail, jpfMdp, boutonConnexion, lblErreur));
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(lblMail, c);
		c.gridx = 1;
		c.gridy = 0;
		this.add(jtfMail, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(lblMdp, c);
		c.gridx = 1;
		c.gridy = 1;
		this.add(jpfMdp, c);
		c.gridx = 1;
		c.gridy = 2;
		this.add(boutonConnexion, c);
		c.gridx = 1;
		c.gridy = 3;
		this.add(lblErreur, c);
		
	}
}
