package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frames extends JFrame implements ActionListener{
	private JPanel bodyPanel = null;
	private JLabel titleJLabel = null;
	private JLabel userJLabel = null;
	private JLabel passwordJLabel = null;
	private JTextField uaerfield = null;
	private JPasswordField passwordField  = null;
	//��ѡ��
	private JPanel rJPanel= null;
	private JLabel seJLabel = null;
	private JRadioButton boysButton = null;
	private JRadioButton girlsButton = null;
	//��ѡ��
	private JPanel fpanel= null;
	private JLabel hobbyJLabel = null;
	private JCheckBox sCheckBox = null;
	private JCheckBox bCheckBox = null;
	private JCheckBox pCheckBox = null;
	//����
	private JPanel xpanel= null;
	private JLabel cityJLabel = null;
	private JComboBox box = null;
	//�ı���
	private JLabel disJLabel= null;
	private JTextArea textArea = null;
	private JScrollPane scrollPane = null;
	//��ť
	private JPanel bJPanel= null;
	private JButton subbButton = null;
	private JButton restButton = null;
	
	private void init(){
		this.bodyPanel = (JPanel)this.getContentPane();
		this.bodyPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.titleJLabel = new JLabel("ѧ����¼");
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.bodyPanel.add(this.titleJLabel,gbc);
		gbc.anchor = GridBagConstraints.EAST;
		this.userJLabel = new JLabel("�û���:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.bodyPanel.add(this.userJLabel,gbc);
		this.uaerfield = new JTextField(16);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.bodyPanel.add(this.uaerfield,gbc);
		this.passwordJLabel = new JLabel("��     ��:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.bodyPanel.add(this.passwordJLabel,gbc);
		this.passwordField = new JPasswordField(16);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.bodyPanel.add(this.passwordField,gbc);
		this.seJLabel = new JLabel("��     ��:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.bodyPanel.add(this.seJLabel,gbc);
		this.boysButton = new JRadioButton("��",true);
		this.girlsButton = new JRadioButton("Ů");
		ButtonGroup group = new ButtonGroup();
		group.add(this.boysButton);
		group.add(this.girlsButton);
		this.rJPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 35, 0));
		this.rJPanel.add(boysButton);
		this.rJPanel.add(girlsButton);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.bodyPanel.add(this.rJPanel,gbc);
		this.hobbyJLabel = new JLabel("��     ��:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.bodyPanel.add(this.hobbyJLabel,gbc);
		this.sCheckBox = new JCheckBox("��    ��");
		this.bCheckBox = new JCheckBox("��    ��");
		this.pCheckBox = new JCheckBox("��    ��");
		this.fpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		this.fpanel.add(this.sCheckBox);
		this.fpanel.add(this.bCheckBox);
		this.fpanel.add(this.pCheckBox);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.bodyPanel.add(this.fpanel,gbc);
		this.cityJLabel = new JLabel("��    ��:");
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.bodyPanel.add(this.cityJLabel ,gbc);
		this.xpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		String[] jiuan = new String[]{"����","����","�Ϻ�","����"}; 
		gbc.gridx = 1;
		gbc.gridy = 5;
		this.box = new JComboBox(jiuan);
		this.box.setPreferredSize(new Dimension(180, 25));
		this.bodyPanel.add(this.box ,gbc);
		this.disJLabel = new JLabel("��    ��:");
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.bodyPanel.add(this.disJLabel ,gbc);
		
		this.textArea = new JTextArea("����д����",10, 16);
		//this.scrollPaneû��add����
		this.scrollPane = new JScrollPane(this.textArea);
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.bodyPanel.add(this.scrollPane ,gbc);
		this.bJPanel = new JPanel();
		this.subbButton = new JButton("�ύ");
		this.subbButton.addActionListener(this);
		this.restButton = new JButton("����");
		this.restButton.addActionListener(this);
		this.bJPanel.add(this.subbButton);
		this.bJPanel.add(this.restButton);
		gbc.gridx = 1;
		gbc.gridy = 7;
		this.bJPanel.setPreferredSize(new Dimension(180, 25));
		this.bodyPanel.add(this.bJPanel ,gbc);
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public Frames() {
		this.init();
	}
	public static void main(String[] args) {
		Frames frames = new Frames();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.subbButton) {
			String userName = this.uaerfield.getText();
			String pwd = new String(this.passwordField.getPassword());
			if (userName.length() <= 0|| pwd.length()<=0) {
				JOptionPane.showMessageDialog(this, "�û������벻��Ϊ��");
				return;
			}
			//����û�������Ϊ�մ����򲻻�����ִ�У�ͣ�����ϱߡ�
			String sex = null;
			if (this.boysButton.isSelected()) {
				sex = this.boysButton.getText();
			}else {
				sex = this.girlsButton.getText();
			}
			List<String> like = new ArrayList<String>();
			if (this.sCheckBox.isSelected()) {
				like.add(this.sCheckBox.getText());
			}if (this.bCheckBox.isSelected()) {
				like.add(this.bCheckBox.getText());
			}if (this.pCheckBox.isSelected()) {
				like.add(this.pCheckBox.getText());
			}
			
			String xiala = this.box.getSelectedItem().toString();
			String dis = this.textArea.getText();
			System.out.println(userName +" "+ pwd+" " +sex+" "+like+" "+xiala+" "+dis);
		}else if (e.getSource() == this.restButton) {
			System.out.println("�����");
		}
		
	}
}
