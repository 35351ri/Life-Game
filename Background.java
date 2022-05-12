import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Background extends JFrame implements ActionListener{
	private GUI gui;
	private ImageIcon background;
	private JLabel label;
	private JButton button;
	
	//main����
	public static void main(String[] args) {
		new Background();
	}
	
	public Background()
	{
		JPanel myPanel;
		myPanel = new JPanel();
		button = new JButton("��ʼ��Ϸ");
		myPanel.add(button);
		
		background = new ImageIcon("jpg_1plus.jpg");	//����һ������ͼƬ
		label = new JLabel(background);		//�ѱ���ͼƬ��ӵ���ǩ��
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	//�ѱ�ǩ����Ϊ��ͼƬ�ȸߵȿ�
		myPanel = (JPanel)this.getContentPane();		//���ҵ��������Ϊ�������
		myPanel.setOpaque(false);					//���ҵ��������Ϊ������
		myPanel.setLayout(new FlowLayout());		//���ҵ��������Ϊ��������
		this.getLayeredPane().setLayout(null);		//�ѷֲ����Ĳ����ÿ�
		myPanel.add(button);						//�Ѱ�ť��ӵ��ҵ������
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));		//�ѱ�ǩ��ӵ��ֲ�������ײ�
		
		//���ý�������
		this.setTitle("Life Game");
		this.setBounds(300, 300, background.getIconWidth(), background.getIconHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // �ô�������Ļ����
		this.setVisible(true);
		
		//���ü�����
		this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
		button.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			gui = new GUI("������Ϸ");
			gui.fake_main();
			
		}
		
	}
}