package departmentGuide;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JTextPane;

public class jdbc_team01APP extends JFrame {

	private JPanel contentPane;

	Popup p = new Popup(this);
	private JTable table;
	JLabel resultLabel;

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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel Wpanel = new JPanel();
		Wpanel.setBackground(new Color(255, 255, 255));
		Wpanel.setBounds(5, 105, 97, 378);
		contentPane.add(Wpanel);
		Wpanel.setLayout(new GridLayout(0, 1, 0, 0));

		JButton floor6 = new JButton("6층");
		floor6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayFloor("6");
			}
		});
		Wpanel.add(floor6);

		JButton floor5 = new JButton("5층");
		floor5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayFloor("5");
			}
		});
		Wpanel.add(floor5);

		JButton floor4 = new JButton("4층");
		floor4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayFloor("4");
			}
		});
		Wpanel.add(floor4);

		JButton floor3 = new JButton("3층");
		floor3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayFloor("3");
			}
		});
		Wpanel.add(floor3);

		JButton floor2 = new JButton("2층");
		floor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayFloor("2");
			}
		});

		Wpanel.add(floor2);

		JButton floor1 = new JButton("1층");
		Wpanel.add(floor1);
		floor1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayFloor("1");
			}
		});
		JButton floorB1 = new JButton("B1층");
		floorB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayFloor("B1");
			}
		});
		Wpanel.add(floorB1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(12, 5, 164, 93);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnAkPlaza = new JTextPane();
		txtpnAkPlaza.setBackground(new Color(0, 0, 168));
		txtpnAkPlaza.setForeground(new Color(255, 255, 255));
		txtpnAkPlaza.setFont(new Font("새굴림", Font.BOLD, 29));
		txtpnAkPlaza.setText("AK PLAZA");
		txtpnAkPlaza.setBounds(0, 0, 101, 93);
		panel_1.add(txtpnAkPlaza);

		JPanel Cpanel = new JPanel();
		Cpanel.setBackground(new Color(255, 255, 255));
		Cpanel.setBounds(107, 5, 549, 477);
		contentPane.add(Cpanel);
		Cpanel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
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
		//displayAllStore();

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(61, 0, 488, 51);
		Cpanel.add(panel_7);
		panel_7.setLayout(null);

		JButton floor = new JButton("층검색");
		floor.setBounds(24, 10, 97, 44);
		panel_7.add(floor);

		// 검색창 팝업을 띄울 수 있는 버튼
		JButton categories = new JButton("카테고리");
		categories.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p.setVisible(true);
				String category = p.getSelectedCValue();
				String products = p.getSelectedPValue();
				String name = p.getStoreName();
				if(name != null) {
					displaySName(name);
				}	else if (category == null) {
					displayProducts(products);
				} else {
					displayCategories(category);
				}
				
			}
		});
		categories.setBounds(133, 10, 97, 44);
		panel_7.add(categories);

		JButton road = new JButton("찾아오는길");
		road.setBounds(242, 10, 97, 44);
		panel_7.add(road);

		JButton reservation = new JButton("예약");
		reservation.setBounds(351, 10, 97, 44);
		panel_7.add(reservation);

		resultLabel = new JLabel("검색결과");
		resultLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 18));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setBounds(416, 61, 123, 28);
		Cpanel.add(resultLabel);
	}

	protected void displayFloor(String floor) {
		List<Team01DTO> storeList = Team01DAOImpl.getDAO().pushFButton(floor);
		resultLabel.setText(floor+"층");	
		display(storeList);

	}

	protected void displaySName(String name) {
		List<Team01DTO> storeList = Team01DAOImpl.getDAO().searchSNameList(name);
		resultLabel.setText(name);	
		display(storeList);
	}

	protected void displayCategories(String category) {
		List<Team01DTO> storeList = Team01DAOImpl.getDAO().selectCategoriesList(category);
		resultLabel.setText(category);
		display(storeList);
	}

	protected void displayProducts(String products) {
		resultLabel.setText(products);	
		List<Team01DTO> storeList = Team01DAOImpl.getDAO().selectPstoreList(products);
		display(storeList);
	}

	private void displayAllStore() {
		List<Team01DTO> storeList = Team01DAOImpl.getDAO().selectAllStore();
		display(storeList);
	}

	private void display(List<Team01DTO> storeList) {
		if (storeList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "상점 정보가 없습니다.");
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);// JTable 컴퍼넌트의 첫번째 행을 제거
		}
		for (Team01DTO store : storeList) {
			Vector<Object> rowData = new Vector<>();

			rowData.add(store.getProducts());
			rowData.add(store.getName());
			rowData.add(store.getFloor() + " 층");
			rowData.add(store.getPhone());

			model.addRow(rowData);
		}
	}
}