package app;

import GUI.GUI;

public class Main {
	public static void main(String[] args) {
		GUI g = new GUI();
		while (true)
			g.update();
	}
}
