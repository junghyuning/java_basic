package departmentGuide;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JMenu;
import java.awt.Dimension;
import java.awt.CardLayout;

public class jdbc_team01APP extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	Popup p = new Popup(this);
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jdbc_team01APP frame = new jdbc_team01APP();
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
	public jdbc_team01APP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel Wpanel = new JPanel();
		Wpanel.setBounds(5, 105, 97, 378);
		contentPane.add(Wpanel);
		Wpanel.setLayout(new GridLayout(0, 1, 0, 0));

		JButton floor6 = new JButton("6층");
		Wpanel.add(floor6);
		

		JButton floor5 = new JButton("5층");
//		floor5.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		Wpanel.add(floor5);

		JButton floor4 = new JButton("4층");
		Wpanel.add(floor4);

		JButton floor3 = new JButton("3층");
		Wpanel.add(floor3);

		JButton floor2 = new JButton("2층");
		Wpanel.add(floor2);

		JButton floor1 = new JButton("1층");
		Wpanel.add(floor1);
		floor1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		JButton floorB1 = new JButton("B1층");
		Wpanel.add(floorB1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 5, 164, 93);
		contentPane.add(panel_1);

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_4.setBounds(-14, 0, 121, 91);
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\KakaoTalk_20230519_102611257_01.jpg"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnNewButton_4);

		JPanel Cpanel = new JPanel();
		Cpanel.setBounds(107, 5, 549, 477);
		contentPane.add(Cpanel);
		Cpanel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 99, 539, 346);
		Cpanel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 539, 374);
		panel_3.add(scrollPane);
		
		Object[] title = { "상품", "상호", "층", "전화번호" };
		table = new JTable(new DefaultTableModel(title, 0));
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(table);
		displayAllStore();


		JPanel panel_7 = new JPanel();
		panel_7.setBounds(61, 0, 488, 51);
		Cpanel.add(panel_7);
		panel_7.setLayout(null);

		JButton floor = new JButton("층검색");
		floor.setBounds(24, 10, 97, 44);
		panel_7.add(floor);

		JButton categories = new JButton("카테고리");
		categories.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p.setVisible(true);
			}
		});
		categories.setToolTipText("");
		categories.setBounds(133, 10, 97, 44);
		panel_7.add(categories);

		JButton road = new JButton("찾아오는길");
		road.setBounds(242, 10, 97, 44);
		panel_7.add(road);

		JButton reservation = new JButton("예약");
		reservation.setBounds(351, 10, 97, 44);
		panel_7.add(reservation);

		textField_2 = new JTextField();
		textField_2.setBounds(421, 61, 116, 21);
		Cpanel.add(textField_2);
		textField_2.setColumns(10);
	}

	private void displayAllStore() {
		List<Team01DTO> storeList = Team01DAOImpl.getDAO().selectAllStore();
		if (storeList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "정보가 없습니다.");
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (Team01DTO student : storeList) {
			Vector<Object> rowData = new Vector<>();

			rowData.add(student.getProducts());
			rowData.add(student.getName());
			rowData.add(student.getFloor());
			rowData.add(student.getPhone());

			model.addRow(rowData);
		}
	}
}
