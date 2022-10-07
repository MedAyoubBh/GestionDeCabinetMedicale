package IHM;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{
	
	JLabel log;
	JButton med,sec;
	JPanel p;
	
	public Login() {
		//Creation d'interface
				this.setTitle("Gestion de cabinet médicale");
				this.setSize(1000,700);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setLayout(new FlowLayout());
				
				log = new JLabel("Login as :");
				med = new JButton("Médecin");
				sec = new JButton("Secrétaire");
				p = new JPanel(new GridLayout(1,3));
				p.setPreferredSize(new Dimension(400, 100));
				
				p.add(log);
				p.add(med);
				med.addActionListener(this);
				p.add(sec);
				sec.addActionListener(this);
				this.add(p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==med) {
			AccueilMédecin x = new AccueilMédecin();
			x.setVisible(true);
		}
		if(e.getSource()==sec) {
			AccueilSecrétaire x = new AccueilSecrétaire();
			x.setVisible(true);
		}
	}
}
