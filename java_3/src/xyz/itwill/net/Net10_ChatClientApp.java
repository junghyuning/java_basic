package xyz.itwill.net;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


//Gui로 만들것.. 
//=> 서버에서 보내온 메세지를 전달받아 JtextArea 컴포넌트에 출력 - 무한루프
//=> JtextField 컴포넌트에서 입력된 메세지를 서버에 전달함 -> 이벤트 처리 메서드.
public class Net10_ChatClientApp extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JTextArea jTextArea; // 출력 컴포넌트
	private JTextField jTextField; // 입력컴포넌트
	
	//서버와 연결된 소켓객체 저장
	private Socket socket;
	
	
	//서버에서 보내온 메세지 전달받기위한 입력스트림을 저장.
	private BufferedReader in;
	
	//서버에게 메세지를 봬기위한 출력스트림을 저장하기 위한 필드.
	private PrintWriter out;
	
	//대화명 저장 필드.
	private String aliasName;
	
	public Net10_ChatClientApp(String title) {
		super(title);
		
		jTextArea = new JTextArea();
		jTextField = new JTextField();
		
		
		jTextArea.setFont(new Font("나눔고딕코딩",Font.BOLD,20));
		jTextField.setFont(new Font("나눔고딕코딩",Font.BOLD,20));
		
		jTextArea.setFocusable(false);
		
		JScrollPane jScrollPane = new JScrollPane(jTextArea);
		
		
		getContentPane().add(jScrollPane,BorderLayout.CENTER);
		getContentPane().add(jTextField,BorderLayout.SOUTH);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700,200,400,500);
		setVisible(true);
		
		//JTextField  컴포넌트에서 발생된  action Event를 처리하기위한 ActionListener 객체를 추가하여 이벤트 처리.
		jTextField.addActionListener(this);
		
		
		try {
			socket = new Socket("192.168.13.3",5000); // 소켓객체 생성하여 필드에 저장.
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
		} catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"서버에 접속할 수 없습니다.","접속오류",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		while (true) {
			aliasName = JOptionPane.showInputDialog(this, "대화명을 입력해 주세요.","대화명 입력",JOptionPane.QUESTION_MESSAGE);
			String regEx = "^[가-힣]{2,6}$"; //정규표현식 저장
			//입력값과 정규표현식의 패턴이 일치할 경우 break
			if(Pattern.matches(regEx, aliasName)) break;
			//일치하지 않았을 시, 메세지 출력 후  while문 입력받음.
			JOptionPane.showMessageDialog(this, "정상적인 대화명을 입력해주세요","입력오류", JOptionPane.ERROR_MESSAGE);
		}
		
		out.println(aliasName);
		
		//서버에 보내온 메세지를 반환받아 jTextArea 컴포넌트에 추가 출력 => 프로그램 종료 전까지 무한 반복.
		while(true) {
			try {
				jTextArea.append(in.readLine() + "\n");
				
				jTextArea.setCaretPosition(jTextArea.getText().length());
			} catch (Exception e) {//서버프로그램이 종료된 경우 발생.
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "서버와 연결이 끊어졌스비낟. ", "접속오류",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public static void main(String[] args) {
		new Net10_ChatClientApp("java chatting");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			String message=jTextField.getText();
			
			if(!message.equals("")) {//입력된메세지가 전제될경우
				out.println(message);//메세지 전달
				jTextField.setText(""); //초기화
			}
		
	}
}
