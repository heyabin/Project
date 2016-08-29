package test;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mytest {
	private JFrame frame = null;
	private JPanel bodyPanel = null;
	private JPanel panel1 = null;
	private JPanel panel2 = null;

	private void init(){
		this.frame = new JFrame("Mytest");
		this.bodyPanel = new JPanel(new GridLayout(2, 1));
		Container container = this.frame.getContentPane();
		container.add(bodyPanel);
		this.panel1 = new JPanel();
		this.panel1.setBackground(Color.RED);
		this.bodyPanel.add(panel1);
		this.panel2 = new JPanel();
		this.panel2.setBackground(Color.GREEN);
		this.bodyPanel.add(panel2);
		
		
		//this.frame.setBounds(100, 100, 1000, 800);
		this.frame.setLocation(100, 100);
		this.frame.pack();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
	}
	public Mytest() {
		this.init();
	}
	public static void main(String[] args) {
		Mytest mytest = new Mytest();
	}
}
