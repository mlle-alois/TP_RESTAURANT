import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_connexion extends JPanel{

	private JLabel lblMail;
	private JLabel lblMdp;
	private JLabel lblErreur;
	private JTextField jtfMail;
	private JPasswordField jpfMdp;
	private JButton boutonConnexion;
	
	/**
	 * Constructeur du panel de la connexion
	 * @param menu
	 * @param fenetre
	 */
	public Panel_connexion(JMenuBar menu, JFrame fenetre){
		
		this.setLayout(new GridBagLayout());
		
		//définition des labels
		this.lblMail = new JLabel("Mail : ");
		this.lblMdp = new JLabel("Mot de passe : ");
		this.lblErreur = new JLabel();

		//définition des zones de textes (préremplies)
		this.jtfMail = new JTextField("alois.zimmermann45@gmail.com");
		this.jpfMdp = new JPasswordField("123456");
		
		//dimension des zones de texte
		this.jtfMail.setPreferredSize(new Dimension(150, 30));
		this.jpfMdp.setPreferredSize(new Dimension(150, 30));

		//définition, nommage et action des boutons
		this.boutonConnexion = new JButton("Connexion !");
		this.boutonConnexion.setName("Connexion");
		this.boutonConnexion.addActionListener(new ActionBouton(menu, fenetre, jtfMail, jpfMdp, boutonConnexion, lblErreur));
		
		//ajout des éléments au panel
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
