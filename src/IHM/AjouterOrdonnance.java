package IHM;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO.OrdonnanceDAO;

@SuppressWarnings("serial")
public class AjouterOrdonnance extends JFrame implements ActionListener{

	
	JLabel ordonnance,nomMed,nbPrix,nbBoites,empty;
	JTextArea ordonnanceta;
	JComboBox<String> nomMedCb;
	JTextField nbprixtf,nbBoitestf;
	JButton annuler,ajouter,terminer;
	JPanel p1,p2;
	
	public AjouterOrdonnance() {
		this.setTitle("Ajout Ordonnance");
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ordonnance = new JLabel("Ordonnance");
		ordonnanceta = new JTextArea();
		nomMed = new JLabel("Nom Médicament");
		nomMedCb = new JComboBox<>(new String[] {"DULCIPHAK COLLYRE","DUPHALAK","DUPHASTON","DUSPATALIN","DUSPATALIN 200","DUXIL","ECAZIDE 50"});
		nbPrix = new JLabel("nombre prix par jour");
		nbprixtf = new JTextField();
		nbBoites = new JLabel("nombre de boites");
		nbBoitestf = new JTextField();
		annuler = new JButton("Annuler");
		annuler.addActionListener(this);
		ajouter = new JButton("Ajouter");
		ajouter.addActionListener(this);
		terminer = new JButton("Terminer");
		terminer.addActionListener(this);
		empty = new JLabel("");
		p1 = new JPanel();
		p2 = new JPanel();
		p1.setLayout(new GridLayout(5, 2));
		p2.setLayout(new GridLayout(1, 3));
		p1.add(ordonnance);
		p1.add(ordonnanceta);
		p1.add(nomMed);
		p1.add(nomMedCb);
		p1.add(nbPrix);
		p1.add(nbprixtf);
		p1.add(nbBoites);
		p1.add(nbBoitestf);
		p2.add(annuler);
		p2.add(ajouter);
		p2.add(terminer);
		p1.add(empty);
		p1.add(p2);
		this.add(p1);
		
		this.setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ajouter) {
			ordonnanceta.setText(ordonnanceta.getText()+"\n"+(String)nomMedCb.getSelectedItem()+"	"+nbprixtf.getText()+"	"+nbBoitestf.getText());
		}
		if (e.getSource()==terminer) {
			OrdonnanceDAO.AjoutOrdonnance(ordonnanceta.getText());
		}
		if(e.getSource()==annuler) {
			this.dispose();
		}
	}

}
