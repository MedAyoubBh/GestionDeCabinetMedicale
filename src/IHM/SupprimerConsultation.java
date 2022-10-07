package IHM;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO.ConsultationDAO;
import OO.Consultation;

@SuppressWarnings("serial")
public class SupprimerConsultation extends JFrame implements ActionListener{
	
	JPanel p1,p2,p3;
	JLabel cin,id;
	JTextField cintxt,idtxt;
	JTextArea info;
	JButton rech,supp;
	
	public SupprimerConsultation() {
		// TODO Auto-generated constructor stub
		//Creation d'interface
		this.setTitle("Supprimer Consultation");
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		p1 = new  JPanel(new GridLayout(3, 1));
		p2 = new JPanel(new GridLayout(1, 3));
		p3 = new JPanel(new GridLayout(1, 3));
		
		cin = new JLabel("CIN : ");
		cintxt = new JTextField();
		rech = new JButton("Rechercher");
		info = new JTextArea("id 		codePatient		date		type		remarque		\n");
		id = new JLabel("Id consultation : ");
		idtxt = new JTextField();
		supp = new JButton("Supprimer");
		
		p1.add(p2);
		p1.add(info);
		info.setEnabled(false);
		p1.add(p3);
		p2.add(cin);
		p2.add(cintxt);
		p2.add(rech);
		rech.addActionListener(this);
		p3.add(id);
		p3.add(idtxt);
		idtxt.setEnabled(false);
		p3.add(supp);
		supp.setEnabled(false);
		supp.addActionListener(this);
		
		this.add(p1);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==rech) {
			LinkedList<Consultation> lc = ConsultationDAO.RechercherConsultation(Integer.parseInt(cintxt.getText()));
			Consultation c = null;
			info.setEnabled(true);
			idtxt.setEnabled(true);
			supp.setEnabled(true);
			while(!(lc.isEmpty())) {
				c = lc.poll();
				info.setText(info.getText()+c.getId()+"		"+c.getCodePatient()+"		"+c.getDate()+"		"+c.getType()+"		"+c.getRemarque()+"\n");
			}
		}
		if(e.getSource()==supp) {
			ConsultationDAO.SupprimerConsultation(Integer.parseInt(idtxt.getText()));
		}
	}

}
