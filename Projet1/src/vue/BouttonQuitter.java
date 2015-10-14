package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class BouttonQuitter extends JButton implements ActionListener{

	BouttonQuitter(String str){
		super(str);
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
}
