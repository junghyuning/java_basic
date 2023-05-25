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
import java.util.List;

public class Popup extends JDialog {

	private JPanel contentPane;
	private JTextField searchField;
	private String selectedCValue;
	private String selectedPValue;
	private String storeName;
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getSelectedCValue() {
		return selectedCValue;
	}

	public void setSelectedCValue(String selectedCValue) {
		this.selectedCValue = selectedCValue;
	}


	public String getSelectedPValue() {
		return selectedPValue;
	}

	public void setSelectedPValue(String selectedPValue) {
		this.selectedPValue = selectedPValue;
	}

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
		JComboBox<String> categoryCombo = new JComboBox<>();
		JComboBox<String> productCombo = new JComboBox<>();
		List<Team01DTO> cList = Team01DAOImpl.getDAO().cList();
		for (Team01DTO category : cList) {
		    categoryCombo.addItem(category.getCategories());
		}
		categoryCombo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String selectedCategory = (String) categoryCombo.getSelectedItem();
//		        System.out.println("Selected category: " + selectedCategory);
		        List<Team01DTO> pList = Team01DAOImpl.getDAO().pList(selectedCategory);
		        
		        // 카테고리 바꿔 누를시, 이전 아이템들을 제거하고 재검색함.
		        productCombo.removeAllItems();
		        productCombo.addItem(" ");
		        for (Team01DTO product : pList) {
		            productCombo.addItem(product.getProducts());
		        }
		    }
		});

		categoryCombo.setBounds(33, 76, 95, 23);
		panel.add(categoryCombo);

		productCombo.setBounds(132, 76, 95, 23);
		panel.add(productCombo);

		searchField = new JTextField();
		searchField.setBounds(230, 77, 169, 21);
		panel.add(searchField);
		searchField.setColumns(10);
		setStoreName(searchField.getText());
		JButton searchButton = new JButton("검색");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedCategory = (String) categoryCombo.getSelectedItem();
				String selectedProduct = (String) productCombo.getSelectedItem();
				String storeName =searchField.getText();
				if(storeName.length()!=0) {
					setSelectedCValue(null);
					setSelectedPValue(null);
					setStoreName(storeName);
				} else if(selectedProduct.equals(" ")) {
					setSelectedPValue(null);
					setStoreName(null);
					setSelectedCValue(selectedCategory);
				}else {
					setSelectedCValue(null);
					setStoreName(null);
					setSelectedPValue(selectedProduct);
				}
				
				dispose();	
			}
		});
		searchButton.setBounds(401, 76, 97, 23);
		panel.add(searchButton);

		JLabel searchPageText = new JLabel("검색 조건을 선택하세요.");
		searchPageText.setFont(new Font("굴림", Font.PLAIN, 18));
		searchPageText.setHorizontalAlignment(SwingConstants.CENTER);
		searchPageText.setBounds(148, 29, 251, 33);
		panel.add(searchPageText);
	}

}