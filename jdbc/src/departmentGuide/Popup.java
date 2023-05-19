package departmentGuide;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Popup extends JDialog {

	private JPanel contentPane;
	private JTextField searchField;

	
	/**
	 * Create the frame.
	 */
	public Popup(JFrame frame) {
		super(frame, true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 554, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 538, 142);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox categoryCombo = new JComboBox();
		categoryCombo.setBounds(33, 76, 95, 23);
		categoryCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//
			}
		});
		panel.add(categoryCombo);
		
		JComboBox productCombo = new JComboBox();
		productCombo.setBounds(132, 76, 95, 23);
		panel.add(productCombo);
		
		searchField = new JTextField();
		searchField.setBounds(230, 77, 169, 21);
		panel.add(searchField);
		searchField.setColumns(10);
		
		JButton searchButton = new JButton("검색");
		searchButton.setBounds(401, 76, 97, 23);
		panel.add(searchButton);
		
		JLabel searchPageText = new JLabel("검색 조건을 선택하세요.");
		searchPageText.setFont(new Font("굴림", Font.PLAIN, 18));
		searchPageText.setHorizontalAlignment(SwingConstants.CENTER);
		searchPageText.setBounds(148, 29, 251, 33);
		panel.add(searchPageText);
	}
}
