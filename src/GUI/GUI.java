package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.ChessClock;

public class GUI extends JFrame {

	private final int WINDOW_HEIGHT = 500;
	private final int WINDOW_WIDTH = 750;
	private final int XPOS = 525;
	private final int YPOS = 125;

	private JPanel framePanel, body, playerButtonGrid, bodyButtonGrid;
	private JTextArea whiteClock, blackClock;
	private JPanel f1, f2, f3, f4, f5, f6, bottomFiller, bbf1, bbf2, bbf3, bbf4;
	private JPanel[] playerButtonFillers = { f1, f2, f3, f4, f5, f6 };
	private JPanel[] bodyButtonFillers = {bbf1, bbf2, bbf3, bbf4};
	private JButton resetButton, whiteButton, blackButton;
	private Color brown = new Color(201, 142, 91);
	private GridBagConstraints gbc = new GridBagConstraints();
	private Dimension fillerDimension = new Dimension(2, 50);
	private Font timeFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);
	ChessClock chessclock = new ChessClock();
	
	public GUI() {
		gbc.fill = GridBagConstraints.BOTH;
		
		createButtons();
		createComponents();
		createClock();
		addActionListeners();
		addToBody();
		addToFrame();

		setBounds(XPOS, YPOS, WINDOW_WIDTH, WINDOW_HEIGHT);
		setLayout(new GridBagLayout());
		//setResizable(false);
		setVisible(true);
	}

	private void createComponents() {
		body = new JPanel(new GridBagLayout());
		body.setBackground(brown);
		body.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));

		bottomFiller = new JPanel();
		bottomFiller.setPreferredSize(fillerDimension);
		bottomFiller.setBackground(brown);
		
		framePanel = new JPanel(new GridBagLayout());

		playerButtonGrid = new JPanel(new GridLayout(1, 8));
		int fillerCounter = 0;
		for (int i = 0; i < 8; i++) {
			if (i == 2)
				playerButtonGrid.add(whiteButton);
			else if (i == 5)
				playerButtonGrid.add(blackButton);
			else {
				playerButtonFillers[fillerCounter] = new JPanel();
				playerButtonGrid.add(playerButtonFillers[fillerCounter]);
				fillerCounter++;
			}
		}
		
		bodyButtonGrid = new JPanel(new GridLayout(1, 1, 0, 10));
		bodyButtonGrid.setBackground(brown);
		bodyButtonGrid.add(resetButton);
	}

	private void createClock() {
		whiteClock = new JTextArea(1,1);
		blackClock = new JTextArea(1,1);
		whiteClock.setText("TIME1");
		blackClock.setText("Time2");
		whiteClock.setBackground(Color.LIGHT_GRAY);
		blackClock.setBackground(Color.LIGHT_GRAY);
		whiteClock.setBorder(BorderFactory.createLineBorder(Color.WHITE, 15));
		blackClock.setBorder(BorderFactory.createLineBorder(Color.BLACK, 15));
		whiteClock.setEditable(false);
		blackClock.setEditable(false);
		whiteClock.setFont(timeFont);
		blackClock.setFont(timeFont);

	}

	private void addActionListeners() {
		
		whiteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chessclock.switchTurns();
				whiteButton.setEnabled(false);
				blackButton.setEnabled(true);
			}
		});
		
		
		blackButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chessclock.switchTurns();
				blackButton.setEnabled(false);
				whiteButton.setEnabled(true);
			}
		});
		
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chessclock.ResetClocks();
				blackButton.setEnabled(false);
				whiteButton.setEnabled(true);
				update();
				}
		});
		
	}

	private void createButtons() {
		whiteButton = new JButton("_____________");
		blackButton = new JButton("_____________");
		resetButton = new JButton("Reset");

		blackButton.setEnabled(false);
		
		whiteButton.setBackground(Color.WHITE);
		blackButton.setBackground(Color.WHITE);
		resetButton.setBackground(Color.WHITE);
		whiteButton.setForeground(Color.WHITE);
		blackButton.setForeground(Color.WHITE);
		whiteButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		blackButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		resetButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	private void addToBody() {
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 100;
		gbc.gridwidth = 1;
		body.add(bodyButtonGrid, gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.ipady = 100;
		gbc.gridx = 0;
		gbc.gridy = 1;
		body.add(whiteClock, gbc);
		
		gbc.gridx = 2;
		body.add(blackClock, gbc);
		gbc.ipady = 0;
		gbc.ipadx = 0;
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 2;
		body.add(bottomFiller, gbc);
	}
	
	private void addToFrame() {
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 8;
		gbc.gridheight = 1;
		framePanel.add(playerButtonGrid, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 8;
		gbc.gridheight = 2;
		framePanel.add(body, gbc);

		add(framePanel, BorderLayout.CENTER);
	}

	public void update() {
		int [] wt = chessclock.getWhiteTime();
		int [] bt = chessclock.getBlackTime();
		whiteClock.setText(wt[0] + ":" + wt[1] + ":" + wt[2]);
		blackClock.setText(bt[0] + ":" + bt[1] + ":" + bt[2]);
		revalidate();
		repaint();
	}
}
