package IHM;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.*;

import DAO.ConsultationDAO;
import DAO.PatientDAO;
import OO.Consultation;
import OO.Patient;

@SuppressWarnings("serial")
public class AjouterConsultation extends JFrame implements ActionListener{
	//declaration des variable
	JLabel title,cin,Fname,Lname,stype,consu,EMPTY;
	JTextArea Cons;
	JTextField Cint,fnametxt,lnametxt,stypetxt;
	JPanel p1,p2,p3,p4,p5,p6;
	JButton save,quit,search;
	JComboBox<String> consut;
	String[] TabJ = new String[] {"Consultation","Controle"};
	public AjouterConsultation(){
		//Creation d'interface
		this.setTitle("Ajouter Consultation");
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//creation des labels
		cin = new JLabel("Cin :");
		Fname = new JLabel("Nom :");
		Lname = new JLabel("Prénom :");
		fnametxt = new JTextField();
		lnametxt = new JTextField();
		stype = new JLabel("Type Sang :");
		stypetxt = new JTextField();
		consu = new JLabel("Consultation : ");
		consut = new JComboBox<>(TabJ);
		EMPTY = new JLabel("");
		title = new JLabel("Consultation :");
		
		//creations des boutons
		save = new JButton("Entregister");
		quit = new JButton("Annuler");
		search = new JButton("Rechercher");
		//creation des les textarea
		Cons=new JTextArea();
		Cint=new JTextField();
		//creation de pannel 
		p1 = new JPanel(new GridLayout(3, 1));
		p2 = new JPanel(new GridLayout(3, 1));
		p3 = new JPanel(new GridLayout(1, 3));
		p4 = new JPanel(new GridLayout(1, 6));
		p5 = new JPanel(new GridLayout(1, 2));
		p6 = new JPanel(new GridLayout(1, 2));

		
		//ajout des attributs :
		
		p1.add(p2);
		p1.add(Cons);
		p1.add(p6);
		p2.add(p3);
		p2.add(p4);
		p2.add(p5);
		p3.add(cin);
		p3.add(Cint);
		p3.add(search);
		p4.add(Fname);
		p4.add(fnametxt);
		p4.add(Lname);
		p4.add(lnametxt);
		p4.add(stype);
		p4.add(stypetxt);
		p5.add(consu);
		p5.add(consut);
		p6.add(quit);
		p6.add(save);
		
		search.addActionListener(this);
		save.addActionListener(this);
		quit.addActionListener(this);
		
		fnametxt.setEnabled(false);
		lnametxt.setEnabled(false);
		stypetxt.setEnabled(false);
		Cons.setEnabled(false);
		consut.setEnabled(false);
		save.setEnabled(false);
		quit.setEnabled(false);
		
		this.add(p1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==search) {
			Patient p = PatientDAO.RechercherPatient(Integer.parseInt(Cint.getText()));
			
			if(p==null) {
				System.out.println("Patient introuvable");
			}else {
				fnametxt.setEnabled(true);
				lnametxt.setEnabled(true);
				stypetxt.setEnabled(true);
				Cons.setEnabled(true);
				consut.setEnabled(true);
				save.setEnabled(true);
				quit.setEnabled(true);
				fnametxt.setText(p.getFname());
				lnametxt.setText(p.getLname());
				stypetxt.setText(p.getSgrp());
			}
		}
		if(e.getSource()==save) {
			Consultation c = new Consultation(0,Integer.parseInt(Cint.getText()),Date.valueOf(LocalDate.now()),(String)consut.getSelectedItem(),Cons.getText());
			ConsultationDAO.AjoutConsultation(c);
		}
		if(e.getSource()==quit) {
			this.dispose();
		}

	}
}
