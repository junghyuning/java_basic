package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import javax.swing.JTextPane;

public class WindowBuilderApp extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderApp frame = new WindowBuilderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowBuilderApp() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 0, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton red = new JButton("빨간색");
		red.setHorizontalAlignment(SwingConstants.LEFT);
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		red.setForeground(new Color(255, 0, 0));
		red.setFont(new Font("굴림", Font.PLAIN, 18));
		panel.add(red);
		
		JButton green = new JButton("초록색");
		green.setFont(new Font("굴림", Font.PLAIN, 18));
		green.setForeground(new Color(0, 255, 128));
		panel.add(green);
		
		JButton blue = new JButton("파란색");
		blue.setForeground(new Color(0, 128, 255));
		blue.setFont(new Font("굴림", Font.PLAIN, 18));
		panel.add(blue);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.EAST);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
	}

}
