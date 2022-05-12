import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Background extends JFrame implements ActionListener{
	private GUI gui;
	private ImageIcon background;
	private JLabel label;
	private JButton button;
	
	//main函数
	public static void main(String[] args) {
		new Background();
	}
	
	public Background()
	{
		JPanel myPanel;
		myPanel = new JPanel();
		button = new JButton("开始游戏");
		myPanel.add(button);
		
		background = new ImageIcon("jpg_1plus.jpg");	//创建一个背景图片
		label = new JLabel(background);		//把背景图片添加到标签里
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	//把标签设置为和图片等高等宽
		myPanel = (JPanel)this.getContentPane();		//把我的面板设置为内容面板
		myPanel.setOpaque(false);					//把我的面板设置为不可视
		myPanel.setLayout(new FlowLayout());		//把我的面板设置为流动布局
		this.getLayeredPane().setLayout(null);		//把分层面板的布局置空
		myPanel.add(button);						//把按钮添加到我的面板里
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));		//把标签添加到分层面板的最底层
		
		//设置界面属性
		this.setTitle("Life Game");
		this.setBounds(300, 300, background.getIconWidth(), background.getIconHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // 让窗口在屏幕居中
		this.setVisible(true);
		
		//设置监听器
		this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
		button.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			gui = new GUI("生命游戏");
			gui.fake_main();
			
		}
		
	}
}