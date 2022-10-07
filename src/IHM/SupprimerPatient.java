package IHM;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import DAO.PatientDAO;

@SuppressWarnings("serial")
public class SupprimerPatient extends JFrame implements ActionListener {
	
	//declaration des variables
	JLabel Cin,empty;
	JTextField Cintxt;
	JButton supprimer,annuler;
	JPanel p1,p2;
	
	public SupprimerPatient() {
		//Creation d'interface
		this.setTitle("Supprimer Patient");
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//creation des labels
		Cin = new JLabel("CIN : ");
		empty = new JLabel("");
		
		//creations des boutons
		supprimer = new JButton("Supprimer");
		supprimer.addActionListener(this);
		annuler = new JButton("Annuler");
		annuler.addActionListener(this);
		
		//creation des les fields
		Cintxt = new JTextField();
		
		//creation de pannel 
		p1 = new JPanel();
		p1.setLayout(new GridLayout(2,2,4,4));
		p2 = new JPanel();
		p2.setLayout(new GridLayout(1,2,4,4));
		//ajout des attributs :
		p1.add(Cin);
		p1.add(Cintxt);
		p1.add(empty);
		p2.add(annuler);
		p2.add(supprimer);
		p1.add(p2);
		this.add(p1);
		
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==supprimer) {
			PatientDAO.SupprimerPatient(Integer.parseInt(Cintxt.getText()));
		}
		if(e.getSource()==annuler) {
			this.dispose();
		}
	}

}
