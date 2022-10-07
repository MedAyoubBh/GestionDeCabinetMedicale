package IHM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.*;

import DAO.FichePatientDAO;
import IHM.AjouterFichePatient;
import OO.FichePatient;

@SuppressWarnings("serial")
public class AjouterFichePatient extends JFrame implements ActionListener {
	//declaration des variable
	JLabel Fname,Lname,Cin,Dnes,Adr,Postal,Vill,Email,Phonenum,Profession,Sexe,Sgrp,Civility,EMPTY;
	JButton save,quit;
	JRadioButton male,female,Other;
	JTextField Fnametxt,Lnametxt,Cintxt,Adrtxt,Postaltxt,Villtxt,Emailtxt,Phonenumtxt,Professiontxt,Civtxt;
	String[] TabJ = new String[] {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] TabM = new String[] {"01","02","03","04","05","06","07","08","09","10","11","12"};
	String[] TabA = new String[] {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021"};
	String[] TabS = new String[] {"A","A+","A-","B","B+","B-","AB","AB","AB+","AB-","O","O+","O-"};
	JComboBox<String> DnessJ;
	JComboBox<String> DnessA;
	JComboBox<String> DnessM;
	JComboBox<String> GRSN;
	ButtonGroup grsexe;
	JPanel pannel,ness,sx,fin;
	public AjouterFichePatient () {
		//Creation d'interface
		this.setTitle("Ajouter Fiche Patient");
		this.setSize(1000,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//creation des labels
		Fname = new JLabel("Nom :");
		Lname = new JLabel("Prénom :");
		Cin = new JLabel("CIN : ");
		Dnes = new JLabel("Né(e) le :");
		Adr = new JLabel("Adresse :");
		Postal = new JLabel("Code postal :");
		Vill = new JLabel("Ville :");
		Email = new JLabel("Email :");
		Phonenum = new JLabel("Portable :");
		Profession = new JLabel("Profession :");
		Sexe = new JLabel("Sexe :");
		Sgrp = new JLabel("Groupe de Sang :");
		Civility = new JLabel("Civilité :");
		EMPTY = new JLabel("");
		//creations des boutons
		save = new JButton("Entregister");
		quit = new JButton("Annuler");
		fin=new JPanel(new GridLayout(1,2,3,3));
		//creation des les fields
		Fnametxt = new JTextField();
		Lnametxt = new JTextField();
		Cintxt = new JTextField();
		Adrtxt = new JTextField();
		Postaltxt = new JTextField();
		Villtxt = new JTextField();
		Emailtxt = new JTextField();
		Phonenumtxt = new JTextField();
		Professiontxt = new JTextField();
		Civtxt =new JTextField();
		//creation des boutons : 
		save = new JButton("Enregistrer");
		quit = new JButton("Annuler");
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		Other = new JRadioButton("Other");
		grsexe=new ButtonGroup();
		grsexe.add(male);
		grsexe.add(female);
		grsexe.add(Other);
		
		
		//creation des combo boxes:
		DnessJ=new JComboBox<>(TabJ);
		DnessM=new JComboBox<>(TabM);
		DnessA=new JComboBox<>(TabA);
		GRSN=new JComboBox<>(TabS);
		//creation de pannel 
		pannel = new JPanel();
		pannel.setLayout(new GridLayout(14,2,4,4));
		ness = new JPanel(new GridLayout(1,3,3,3));
		sx=new JPanel(new GridLayout(1,3,3,3));
		//modif
		Fnametxt.setPreferredSize(new Dimension(250,20));
		Lnametxt.setPreferredSize(new Dimension(250,20));
		Adrtxt.setPreferredSize(new Dimension(250,20));
		Postaltxt.setPreferredSize(new Dimension(250,20));
		Villtxt.setPreferredSize(new Dimension(250,20));
		Phonenumtxt.setPreferredSize(new Dimension(250,20));
		Professiontxt.setPreferredSize(new Dimension(250,20));
		Sexe.setPreferredSize(new Dimension(250,20));
		Sgrp.setPreferredSize(new Dimension(250,20));
		Civtxt.setPreferredSize(new Dimension(250,20));
		//ajout des attributs :
		pannel.add(Fname);
		pannel.add(Fnametxt);
		pannel.add(Lname);
		pannel.add(Lnametxt);
		pannel.add(Cin);
		pannel.add(Cintxt);
		pannel.add(Adr);
		pannel.add(Adrtxt);
		pannel.add(Dnes);
		ness.add(DnessJ);
		ness.add(DnessM);
		ness.add(DnessA);
		pannel.add(ness);
		pannel.add(Postal);
		pannel.add(Postaltxt);
		pannel.add(Vill);
		pannel.add(Villtxt);
		pannel.add(Email);
		pannel.add(Emailtxt);
		pannel.add(Phonenum);
		pannel.add(Phonenumtxt);
		pannel.add(Profession);
		pannel.add(Professiontxt);
		pannel.add(Sexe);
		sx.add(male);
		sx.add(female);
		sx.add(Other);
		pannel.add(sx);
		pannel.add(Sgrp);
		pannel.add(GRSN);
		pannel.add(Civility);
		pannel.add(Civtxt);
		pannel.add(EMPTY);
		fin.add(save);
		save.addActionListener(this);
		fin.add(quit);
		quit.addActionListener(this);
		pannel.add(fin);
		this.add(pannel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==save) {
			String sexe = "other" ;
			if(male.isSelected())sexe="male";
			if(female.isSelected())sexe="female";
			@SuppressWarnings("deprecation")
			Date d = new Date(Integer.parseInt(((String)DnessA.getSelectedItem())), Integer.parseInt(((String)DnessM.getSelectedItem())), Integer.parseInt(((String)DnessJ.getSelectedItem())));
			FichePatient fp = new FichePatient(Integer.parseInt(Cintxt.getText()),Fnametxt.getText(), Lnametxt.getText(), Adrtxt.getText(), Postaltxt.getText(), Emailtxt.getText(), Villtxt.getText(), Phonenumtxt.getText(), Professiontxt.getText(), sexe , (String)GRSN.getSelectedItem(), Civtxt.getText(), d);
			FichePatientDAO.AjoutFichePatient(fp);
		}
		if(e.getSource()==quit) {
			this.dispose();
		}
	}

}
