package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Clock;

public class Dummy extends JFrame {

	Clock c = new Clock("s");
	JButton start, pause, reset;
	JPanel buttonpanel;

	public Dummy() {
		buttonpanel = new JPanel(new GridLayout(3, 1));
		start = new JButton("START");
		pause = new JButton("PAUSE");
		reset = new JButton("RESET");
		buttonpanel.add(start);
		buttonpanel.add(pause);
		buttonpanel.add(reset);
		
		start.setEnabled(false);
		addListeners();

		add(buttonpanel);

		setBounds(200, 200, 200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addListeners() {

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.start();
			}
		});

		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.reset();
			}
		});

		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.pause();
			}
		});

	}

}
