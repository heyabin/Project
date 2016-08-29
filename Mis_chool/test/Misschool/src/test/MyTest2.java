package test;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyTest2 extends JFrame{
	private JPanel bodyPanel = null;
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JLabel label = null;
	private JButton button = null;
	private JTextField field = null;
	private JPasswordField field2 = null;
	private JTextArea area = null;
	private ScrollPane scrollPane = null;
	private JScrollPane jScrollPane = null;
	private void init(){
		Container container =  this.getContentPane();
		this.bodyPanel = new JPanel(new GridLayout(2, 1));
		container.add(bodyPanel);
		this.panel1 = new JPanel();
		this.panel1.setBackground(Color.RED);
		this.label = new JLabel("我是标签", new ImageIcon("./img/5.jpg"), JLabel.LEFT);
		this.label.setFont(new Font("楷体", Font.PLAIN, 19));
		this.label.setForeground(Color.white);
		this.label.setVerticalTextPosition(JLabel.TOP);
		this.label.setHorizontalTextPosition(JLabel.CENTER);
		this.panel1.add(this.label);
		this.bodyPanel.add(panel1);
		this.panel2 = new JPanel();
		this.panel2.setBackground(Color.GREEN);
		this.button = new JButton("我是button", new ImageIcon("./img/3.png"));
		this.button.setForeground(Color.YELLOW);
		this.button.setFont(new Font("楷体", Font.PLAIN, 19));
		this.button.setVerticalTextPosition(JLabel.BOTTOM);
		this.button.setHorizontalTextPosition(JLabel.CENTER);
		this.field = new JTextField(16);
		this.field2 = new JPasswordField(16);
		this.panel2.add(this.field);
		this.panel2.add(this.field2);
		this.area = new JTextArea("我是area", 2, 3);
		//this.scrollPane = new ScrollPane();
		this.jScrollPane = new JScrollPane();
		this.jScrollPane.getViewport().add(this.area);
		//this.scrollPane.add(area);
		this.panel2.add(this.jScrollPane);
		this.panel2.add(button);
		this.bodyPanel.add(panel2);
		//this.frame.setBounds(100, 100, 220, 220);
		this.setLocation(100, 100);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	public MyTest2() {
		this.init();
	}
	public static void main(String[] args) {
		MyTest2 myTest2 = new MyTest2();
	}
}
