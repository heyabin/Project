package shijian2;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Listener implements MouseListener{

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
		//�������Listener����MouseListener��Ϊ���ǲ���ͬһƬ�ռ�
		//eΪ��ǰ��������
		JButton B2 = (JButton)e.getSource();
		B2.setBackground(Color.RED);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	 JButton B2 = (JButton)e.getSource();
		B2.setBackground(Color.GREEN);
		
	}

}
