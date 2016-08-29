package shijian2;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


public class Listener2 extends MouseAdapter{
	@Override
	public void mouseEntered(MouseEvent e) {
		//现在如何Listener操作MouseListener因为他们不在同一片空间
		//e为当前操作对象
		JButton B3 = (JButton)e.getSource();
		B3.setBackground(Color.RED);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	 JButton B3 = (JButton)e.getSource();
		B3.setBackground(Color.GREEN);
		
	}

}
