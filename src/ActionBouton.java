import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ActionBouton implements ActionListener{

	private JMenuBar menu;
	private JFrame fenetre;
	private JTextField jtfMail;
	private JPasswordField jpfMdp;
	private JButton boutonConnexion;
	private JLabel lblErreur;
	
	public ActionBouton(JMenuBar menu, JFrame fenetre, JTextField jtfMail, JPasswordField jpfMdp, JButton boutonConnexion, JLabel lblErreur) {
		this.menu = menu;
		this.fenetre = fenetre;
		this.jtfMail = jtfMail;
		this.jpfMdp = jpfMdp;
		this.boutonConnexion = boutonConnexion;
		this.lblErreur = lblErreur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boutonConnexion){
			char[] c = jpfMdp.getPassword();
			String mdp = new String(c).trim();
			String mail = jtfMail.getText().trim();
			if(mail.equals("") || mdp.equals("")){
				this.lblErreur.setText("Veuillez saisir tous les champs");
			}
			else{
				this.lblErreur.setText("");
				boolean bool = Modele.connecterUser(mail, mdp);
				if(bool == true){
					fenetre.setContentPane(new Panel_Restaurant(menu, fenetre));
					fenetre.revalidate();
				}
				else{
					this.lblErreur.setText("Identifiants incorrects");
				}
			}
		}
	}

}
