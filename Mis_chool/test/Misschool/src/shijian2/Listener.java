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
		//现在如何Listener操作MouseListener因为他们不在同一片空间
		//e为当前操作对象
		JButton B2 = (JButton)e.getSource();
		B2.setBackground(Color.RED);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	 JButton B2 = (JButton)e.getSource();
		B2.setBackground(Color.GREEN);
		
	}

}
