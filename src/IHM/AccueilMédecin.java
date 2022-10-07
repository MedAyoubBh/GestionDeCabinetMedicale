package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class AccueilMédecin extends JFrame implements ActionListener{
	
	JMenuBar mb;
	JMenu ajouter,supprimer;
	JMenuItem patient1,fiche1,cons1,ord1,patient2,fiche2,cons2,ord2;
	
	public AccueilMédecin() {
		// TODO Auto-generated constructor stub
		
		//Creation d'interface
		this.setTitle("Accueil Médecin");
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		
		mb = new JMenuBar();
		ajouter = new JMenu("Ajouter");
		supprimer = new JMenu("Supprimer");
		patient1 = new JMenuItem("Patient");
		fiche1 = new JMenuItem("Fiche Patient");
		cons1 = new JMenuItem("Consultation");
		ord1 = new JMenuItem("Ordonnance");
		patient2 = new JMenuItem("Patient");
		fiche2 = new JMenuItem("Fiche Patient");
		cons2 = new JMenuItem("Consultation");
		ord2 = new JMenuItem("Ordonnance");
		
		mb.add(ajouter);
		mb.add(supprimer);
		ajouter.add(patient1);
		patient1.addActionListener(this);
		ajouter.add(fiche1);
		fiche1.addActionListener(this);
		ajouter.add(cons1);
		cons1.addActionListener(this);
		ajouter.add(ord1);
		ord1.addActionListener(this);
		supprimer.add(patient2);
		patient2.addActionListener(this);
		supprimer.add(fiche2);
		fiche2.addActionListener(this);
		supprimer.add(cons2);
		cons2.addActionListener(this);
		supprimer.add(ord2);
		ord2.addActionListener(this);
		
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
		if(e.getSource()==patient2) {
			SupprimerPatient x = new SupprimerPatient();
			x.setVisible(true);
		}
		if(e.getSource()==fiche2) {
			SupprimerFichePatient x = new SupprimerFichePatient();
			x.setVisible(true);
		}
		if(e.getSource()==cons2) {
			SupprimerConsultation x = new SupprimerConsultation();
			x.setVisible(true);
		}
		if(e.getSource()==ord2) {
			SupprimerOrdonnance x = new SupprimerOrdonnance();
			x.setVisible(true);
		}
	}

}
