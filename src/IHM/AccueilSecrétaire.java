package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class AccueilSecrétaire extends JFrame implements ActionListener{
	
	JMenuBar mb;
	JMenu ajouter,supprimer;
	JMenuItem patient1,fiche1,cons1,ord1,patient2,fiche2,cons2,ord2;
	
	public AccueilSecrétaire() {
		// TODO Auto-generated constructor stub
		
		//Creation d'interface
		this.setTitle("Accueil Secrétaire");
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		
		mb = new JMenuBar();
		ajouter = new JMenu("Ajouter");
		patient1 = new JMenuItem("Patient");
		fiche1 = new JMenuItem("Fiche Patient");
		cons1 = new JMenuItem("Consultation");
		ord1 = new JMenuItem("Ordonnance");
		
		mb.add(ajouter);
		ajouter.add(patient1);
		patient1.addActionListener(this);
		ajouter.add(fiche1);
		fiche1.addActionListener(this);
		ajouter.add(cons1);
		cons1.addActionListener(this);
		ajouter.add(ord1);
		ord1.addActionListener(this);
		
		this.setJMenuBar(mb);
	}
	
	public static void main(String[] args) {
		AccueilMédecin x = new AccueilMédecin();
		x.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==patient1) {
			AjouterPatient x = new AjouterPatient();
			x.setVisible(true);
		}
		if(e.getSource()==fiche1) {
			AjouterFichePatient x = new AjouterFichePatient();
			x.setVisible(true);
		}
		if(e.getSource()==cons1) {
			AjouterConsultation x = new AjouterConsultation();
			x.setVisible(true);
		}
		if(e.getSource()==ord1) {
			AjouterOrdonnance x = new AjouterOrdonnance();
			x.setVisible(true);
		}
	}

}
