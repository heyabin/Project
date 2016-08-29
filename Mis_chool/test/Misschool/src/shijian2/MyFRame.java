package shijian2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFRame extends JFrame implements MouseListener{
	private JButton B1= null;
	private JButton B2= null;
	private JButton B3= null;
	private JButton B4= null;
	private JPanel bodyJPanel = null;
	
	private void init(){
	this.bodyJPanel = (JPanel)this.getContentPane();
	this.bodyJPanel.setLayout(new GridLayout(2, 2));
	this.B1 = new JButton("�Լ�ʵ��");
	//ʵ��,�¼�Դ�ӿڵ�ʵ��
	this.B1.addMouseListener(this);
	this.bodyJPanel.add(this.B1);
	this.B2 = new JButton("����ʵ��");
	Listener listener = new Listener();
	this.B2.addMouseListener(listener);
	this.bodyJPanel.add(this.B2);
	this.B3 = new JButton("ʹ��������");
	//Listener2 listener2 = new Listener2();
	//this.B3.addMouseListener(listener2);
	//������Ӳ�����һ�ξͲ�����
	this.B3.addMouseListener(new Listener2());
	this.bodyJPanel.add(this.B3);
	this.B4 = new JButton("����������");
	this.B4.addMouseListener(new MouseAdapter() {
		//new MouseAdapter()new�Ĺ���
		//MouseAdapter{}������Ĺ���
		@Override
		public void mouseEntered(MouseEvent e) {
			B4.setBackground(Color.RED);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			B4.setBackground(Color.GREEN);
		}
	});
    this.bodyJPanel.add(this.B4);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public MyFRame() {
		this.init();
	}
	public static void main(String[] args) {
		MyFRame fRame = new MyFRame();
		fRame.setBounds(100, 100, 400, 600);
		fRame.setVisible(true);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == this.B1) {
			this.B1.setBackground(Color.RED);
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == this.B1) {
			this.B1.setBackground(Color.GREEN);
		}	
	}
}
