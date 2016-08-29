package Swing4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class Tables extends JFrame implements ActionListener{
	//�˵���
	private JMenuBar menuBar = null;
	private JMenu filemenu = null;
	private JMenuItem newItem = null;
	private JMenuItem openItem = null;
	private JMenu edimemenu = null;
	private JMenuItem undoItem = null;
	//������
	private JToolBar toolBar = null;
	private JButton button1= null;
	private JButton button2 = null;
	private JPanel panel = null;
	private JTable table = null;
	private DefaultTableModel tableModel = null;
	private JScrollPane scrollPane = null;
	private String[] title = {"����", "����", "�Ա�"};
	private String[][] data = {
			{"001", "����", "��"},
			{"002", "����", "��"}, 
			{"003", "����", "Ů"}
			};
	private JButton B1= null;
	private JButton B2= null;
	private JPanel buttonJPanel = null;
	//��ǩ���
	private JTabbedPane tabbedPane = null;
	private JPanel Panel1 = null;
	private JPanel Panel2 = null;
	
	
	private void init(){
		//�˵���frame����������������
		this.menuBar = new JMenuBar();
		this.filemenu = new JMenu("file");
		this.filemenu.setMnemonic('f');
		this.newItem = new JMenuItem("new");
		this.newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		this.newItem.addActionListener(this);
		this.openItem = new JMenuItem("open");
		this.filemenu.add(this.newItem);
		this.filemenu.add(new JSeparator());
		this.filemenu.add(this.openItem);
		this.menuBar.add(this.filemenu);
		this.edimemenu = new JMenu("edio");
		this.undoItem = new JMenuItem("undo");
		this.edimemenu.add(this.undoItem);
		this.menuBar.add(this.undoItem);
		this.setJMenuBar(this.menuBar);
		//������ֱ��λ�ڲ˵����±�
		this.Panel1 = new JPanel(new BorderLayout());
		this.Panel2 = new JPanel();
		this.button1 = new JButton("button1");
		this.button2 = new JButton("button2");
		this.toolBar = new JToolBar();
		this.toolBar.setFloatable(false);
		this.toolBar.add(this.button1);
		this.toolBar.add(this.button2);
		//��������ContentPane()��
		this.panel =(JPanel)this.getContentPane();
		this.panel.setLayout(new BorderLayout());
		this.Panel1.add(this.toolBar,new BorderLayout().NORTH);
		this.tableModel = new DefaultTableModel(this.data, this.title);
		this.table = new JTable(this.tableModel);
		this.table.setPreferredScrollableViewportSize(new Dimension(100, 200));
		this.scrollPane = new JScrollPane(this.table);
//		this.scrollPane = new JScrollPane();
//		JViewport viewport = scrollPane.getViewport();
//		viewport.add(this.table);
		this.panel.add(this.scrollPane);
		this.buttonJPanel = new JPanel();
		this.B1 = new JButton("�ύ");
		this.B1.addActionListener(this);
		this.B2 = new JButton("����");
		this.B2.addActionListener(this);
		this.buttonJPanel.add(this.B1);
		this.buttonJPanel.add(this.B2);
		this.Panel1.add(this.buttonJPanel,BorderLayout.SOUTH);
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.Panel2.setBackground(Color.BLUE);
		
		this.tabbedPane.add("ҵ��",this.Panel1);
		this.tabbedPane.add("Ļ��",this.Panel2);
		this.panel.add(this.tabbedPane,BorderLayout.CENTER);
		
		
		
	}
	public Tables() {
		this.init();
	}
	public static void main(String[] args) {
		Tables tables = new Tables();
		tables.setBounds(100, 100, 400, 600);
		tables.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.B1) {
//			System.out.println(this.tableModel.getColumnName(1));
//			System.out.println(this.tableModel.getColumnCount());
//			String id =this.tableModel.getValueAt(this.table.getSelectedRow(), 0).toString();
//			System.out.println(id);
//			this.tableModel.removeRow(this.table.getSelectedRow());
			
		}else if (e.getSource() == this.B2) {
//			this.tableModel.addRow(new String[]{"004","С��","��"} );
//			this.tableModel.addRow(new String[]{"005","С��","Ů"} );
			
		}else if (e.getSource() == this.newItem) {
			System.out.println("new");
		}
		
	}
}
