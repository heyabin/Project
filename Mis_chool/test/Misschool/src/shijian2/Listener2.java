package shijian2;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


public class Listener2 extends MouseAdapter{
	@Override
	public void mouseEntered(MouseEvent e) {
		//�������Listener����MouseListener��Ϊ���ǲ���ͬһƬ�ռ�
		//eΪ��ǰ��������
		JButton B3 = (JButton)e.getSource();
		B3.setBackground(Color.RED);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	 JButton B3 = (JButton)e.getSource();
		B3.setBackground(Color.GREEN);
		
	}

}
