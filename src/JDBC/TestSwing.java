package JDBC;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class TestSwing extends JFrame{
    boolean idFlag,passwordFlag,passCheckFlag,mailFlag;
    boolean passwordFlag2,passCheckFlag2;
    
	private JPanel contentPane;
	private CardLayout cardLayoutSet;
	private JTextField loginIdTextField;
	private JPasswordField loginPasswordField;
	private JPasswordField signupPasswordField;
	private JPasswordField signupPassCheckField;
	private JTextField signupIdField;
	private JTextField signupNameField;
	private JTextField signupNicknameField;
	private JTextField signupMailField;
	private JTextField idfounderNameField;
	private JTextField idfounderMailField;
	private JTextField passchangeMailField;
	private JPasswordField passchangeCurrentPassword;
	private JTextField passchangeNameField;
	private JTextField passchangeIdField;
	private JPasswordField passchangeChangePassword;
	private JPasswordField passchangePasswordCheck;
	
	public TestSwing() {
		setTitle("poketmon");
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 740);
		
		idFlag = false;
		passwordFlag = false;
		passCheckFlag = false;
		mailFlag = false;
		ImageIcon iconlogo = new ImageIcon("resource/poketlogo.jpg");
		ImageIcon iconcomponent = new ImageIcon("resource/component.jpg");
		ImageIcon iconwhite = new ImageIcon("resource/white.jpg");
		ImageIcon icon1 = new ImageIcon("resource/pikachu.jpg"); 
		ImageIcon icon2 = new ImageIcon("resource/bulbasaur.jpg");
		ImageIcon icon3 = new ImageIcon("resource/charmander.jpg");
		ImageIcon icon4 = new ImageIcon("resource/squirtle.jpg");
		
		cardLayoutSet = new CardLayout();
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(cardLayoutSet);
		setContentPane(contentPane);
		
		JPanel mainPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(iconlogo.getImage(),0,0,null);
			}
		};
		JPanel loginPanel = new JPanel(){
			public void paintComponent(Graphics g) {
				g.drawImage(iconcomponent.getImage(),0,0,null);
			}
		};
		JPanel signupPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(iconcomponent.getImage(),0,0,null);
			}
		};
		JPanel idfounderPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(iconcomponent.getImage(),0,0,null);
			}
		};
		idfounderPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});
		JPanel passchangePanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(iconcomponent.getImage(),0,0,null);
			}
		};
		//main 패널
		JButton loginButton = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon1.getImage(),0,0,null);
			}
		};
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutSet.show(contentPane, "loginPanel");
			}
		});
		loginButton.setBounds(182, 314, 100, 100);
		
		
		JButton SignupButton = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon2.getImage(),0,0,null);
			}
		};
		SignupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutSet.show(contentPane, "signupPanel");
			}
		});
		SignupButton.setBounds(552, 314, 100, 100);
		
		JButton idfoundButton = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon3.getImage(),0,0,null);
			}
		};
		idfoundButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutSet.show(contentPane, "idfounderPanel");
			}
		});
		idfoundButton.setBounds(182, 507, 100, 100);
		
		JButton passchangeButton = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon4.getImage(),0,0,null);
			}
		};
		passchangeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutSet.show(contentPane, "passchangePanel");
			}
		});
		passchangeButton.setBounds(552, 507, 100, 100);
		
		JLabel lblNewLabel = new JLabel("로그인");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setBounds(196, 434, 72, 30);
		
		JLabel lblNewLabel_1 = new JLabel("아이디찾기");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(171, 629, 120, 30);
		
		JLabel lblNewLabel_2 = new JLabel("회원가입");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(552, 434, 96, 30);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호 변경");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(522, 629, 152, 30);
		
		//login패널
		JLabel loginStateLabel = new JLabel();
		loginStateLabel.setBounds(342, 408, 210, 69);
		
		loginIdTextField = new JTextField();
		loginIdTextField.setBounds(342, 298, 210, 32);
		loginIdTextField.setColumns(10);
		
		loginPasswordField = new JPasswordField();
		loginPasswordField.setBounds(342, 366, 210, 32);
		
		JLabel loginIdLabel = new JLabel("ID");
		loginIdLabel.setBounds(311, 306, 19, 15);
		
		JLabel loginPasswordLabel = new JLabel("비밀번호");
		loginPasswordLabel.setBounds(273, 374, 57, 15);
		JButton loginBackButton = new JButton("뒤로 가기");
		loginBackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutSet.show(contentPane, "mainPanel");
			}
		});
		loginBackButton.setBounds(377, 551, 144, 32);
		
		JButton loginLoginButton = new JButton("로그인");
		loginLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(UserDAO.logIn(loginIdTextField.getText(),loginPasswordField.getText())) {
					loginStateLabel.setText("로그인 성공");
				}else {
					loginStateLabel.setText("<html>아이디가 없거나<br>비밀번호가 틀렸습니다.</html>");
				}
			}
		});
		loginLoginButton.setBounds(377, 487, 144, 32);
		
		//signup 패널
		JLabel signupPasswordLabel = new JLabel("<html>비밀번호는 문자 숫자 특수문자의 조합으로 <br>8자 이상으로 입력해주세요.</html>");
		signupPasswordLabel.setBounds(564, 209, 318, 72);
		
		JLabel signupPassCheckLabel = new JLabel("");
		signupPassCheckLabel.setBounds(564, 278, 196, 15);
		
		JLabel signupMailLabel = new JLabel("");
		signupMailLabel.setBounds(564, 435, 196, 15);
		
		JLabel lblNewLabel_10 = new JLabel("성별");
		lblNewLabel_10.setBounds(300, 354, 30, 15);
		
		JLabel lblNewLabel_11 = new JLabel("닉네임");
		lblNewLabel_11.setBounds(286, 393, 44, 15);
		
		JLabel lblNewLabel_12 = new JLabel("이메일");
		lblNewLabel_12.setBounds(286, 435, 44, 15);
		
		signupPasswordField = new JPasswordField();
		signupPassCheckField = new JPasswordField();
		
		signupPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(PatternCheck.patternCheck(signupPasswordField.getText(),PatternCheck.passwordPattern)) {
					signupPasswordLabel.setText("사용 가능합니다.");
					passwordFlag = true;
				}else {
					signupPasswordLabel.setText("<html>비밀번호는 문자 숫자 특수문자의 조합으로 <br>8자 이상으로 입력해주세요.</html>");
					passwordFlag = false;
				}
				if(signupPasswordField.getText().equals(signupPassCheckField.getText())) {
					signupPassCheckLabel.setText("일치합니다.");
					passCheckFlag = true;
				}else {
					signupPassCheckLabel.setText("비밀번호가 다릅니다.");
					passCheckFlag = false;
				}
			}
		});
		signupPasswordField.setBounds(342, 228, 210, 32);
		
		signupPassCheckField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(signupPasswordField.getText().equals(signupPassCheckField.getText())) {
					signupPassCheckLabel.setText("일치합니다.");
					passCheckFlag = true;
				}else {
					signupPassCheckLabel.setText("비밀번호가 다릅니다.");
					passCheckFlag = false;
				}
			}
		});
		signupPassCheckField.setBounds(342, 270, 210, 32);
		
		signupIdField = new JTextField();
		signupIdField.setBounds(342, 186, 210, 32);
		signupIdField.setColumns(10);
		
		signupNameField = new JTextField();
		signupNameField.setBounds(342, 312, 210, 32);
		signupNameField.setColumns(10);
		
		signupNicknameField = new JTextField();
		signupNicknameField.setBounds(342, 385, 210, 32);
		signupNicknameField.setColumns(10);
		
		signupMailField = new JTextField();
		signupMailField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(PatternCheck.patternCheck(signupMailField.getText(), PatternCheck.mailPattern)) {
					signupMailLabel.setText("사용 가능합니다.");
					mailFlag = true;
				}else {
					signupMailLabel.setText("올바른 메일 형식이 아닙니다.");
					mailFlag = false;
				}
			}
		});
		signupMailField.setBounds(342, 427, 210, 32);
		signupMailField.setColumns(10);
		
		JRadioButton signupManRadioButton = new JRadioButton("남자");
		signupManRadioButton.setFont(new Font("굴림", Font.PLAIN, 15));
		signupManRadioButton.setBounds(363, 350, 55, 23);
		
		JRadioButton signupWomanRadioButton = new JRadioButton("여자");
		signupWomanRadioButton.setFont(new Font("굴림", Font.PLAIN, 15));
		signupWomanRadioButton.setBounds(470, 350, 55, 23);
		
		JButton btnNewButton = new JButton("회원 가입");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane aa=new JOptionPane();
				if(!idFlag) {
					aa.showMessageDialog(null, "아이디 중복확인 해주세요.");
				}else if(!passwordFlag||!passCheckFlag) {
					aa.showMessageDialog(null, "비밀번호를 확인해주세요.");
				}else if(!mailFlag) {
					aa.showMessageDialog(null, "메일을 확인해주세요.");
				}else if(signupNameField.getText().equals("")) {
					aa.showMessageDialog(null, "이름을 입력해주세요.");
				}else if(signupNicknameField.getText().equals("")) {
					aa.showMessageDialog(null, "닉네임을 입력해주세요.");
				}else if(!signupManRadioButton.isSelected()&&!signupWomanRadioButton.isSelected()) {
					aa.showMessageDialog(null, "성별을 선택해주세요.");					
				}else {
					String gender;
					if(signupManRadioButton.isSelected()) gender = "M";
					else gender = "W";
					UserDAO.SignUp(signupIdField.getText(), signupPasswordField.getText(), signupNameField.getText(),
							gender, signupNicknameField.getText(), signupMailField.getText());;
					aa.showMessageDialog(null, "회원가입이 완료되었습니다.");
					cardLayoutSet.show(contentPane, "mainPanel");
					signupIdField.enable(true);
					idFlag = false;
				}
			}
		});
		btnNewButton.setBounds(377, 495, 144, 32);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(319, 194, 11, 15);
		
		JLabel lblNewLabel_5 = new JLabel("비밀번호");
		lblNewLabel_5.setBounds(275, 236, 55, 15);
		
		JLabel lblNewLabel_6 = new JLabel("비밀번호 확인");
		lblNewLabel_6.setBounds(247, 278, 83, 15);
		
		JLabel lblNewLabel_7 = new JLabel("이름");
		lblNewLabel_7.setBounds(300, 320, 30, 15);
		
		JButton signupBackButton = new JButton("뒤로 가기");
		signupBackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutSet.show(contentPane, "mainPanel");
				signupIdField.enable(true);
				idFlag = false;
			}
		});
		signupBackButton.setBounds(377, 551, 144, 32);
		
		JButton signupDoublecheckButton = new JButton("중복확인");
		signupDoublecheckButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(PatternCheck.patternCheck(signupIdField.getText(),PatternCheck.idPattern)) {
					
					if(UserDAO.doublecheck(signupIdField.getText())) {
						JOptionPane aa=new JOptionPane();
						aa.showMessageDialog(null, "이미 존재하는 아이디입니다.");
					}else {
						JOptionPane aa=new JOptionPane();
						aa.showMessageDialog(null, "사용 가능합니다.");
						idFlag = true;
						signupIdField.enable(false);
					}
				}else {
					JOptionPane aa=new JOptionPane();
					aa.showMessageDialog(null, "아이디는 첫문자는 영어로,\n6~20사이의 영문자와 숫자만 사용 가능합니다.");
				}
			}
		});
		signupDoublecheckButton.setBounds(564, 190, 98, 23);
		// idfounder패널
		JButton idfounderBackButton = new JButton("뒤로 가기");
		idfounderBackButton.setBounds(new Rectangle(377, 551, 144, 32));
		idfounderBackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutSet.show(contentPane, "mainPanel");
			}
		});
		idfounderBackButton.setBounds(377, 551, 144, 32);
		

		idfounderNameField = new JTextField();
		idfounderNameField.setColumns(10);
		idfounderNameField.setBounds(342, 295, 210, 32);
		
		idfounderMailField = new JTextField();
		idfounderMailField.setBounds(342, 385, 210, 32);
		idfounderMailField.setColumns(10);
		
		JButton idfounderFoundButton = new JButton("아이디 찾기");
		idfounderFoundButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane aa=new JOptionPane();
				if(UserDAO.FindId(idfounderNameField.getText(),idfounderMailField.getText())!=null) {
					String str = String.format("아이디는 %s입니다.", UserDAO.FindId(idfounderNameField.getText(),idfounderMailField.getText()));
					aa.showMessageDialog(null, str);
				}else {
					aa.showMessageDialog(null, "회원정보가 없습니다.");
				}
			}
		});
		idfounderFoundButton.setBounds(377, 484, 144, 32);
		
		JLabel lblNewLabel_8 = new JLabel("이름");
		lblNewLabel_8.setBounds(297, 303, 33, 15);
		
		JLabel lblNewLabel_9 = new JLabel("메일");
		lblNewLabel_9.setBounds(297, 393, 33, 15);
		/////
		passchangeMailField = new JTextField();
		passchangeMailField.setBounds(342, 320, 210, 32);
		passchangeMailField.setColumns(10);
		
		passchangeCurrentPassword = new JPasswordField();
		passchangeCurrentPassword.setBounds(342, 431, 210, 32);
		
		passchangeNameField = new JTextField();
		passchangeNameField.setBounds(342, 267, 210, 32);
		passchangeNameField.setColumns(10);
		
		passchangeIdField = new JTextField();
		passchangeIdField.setBounds(342, 218, 210, 32);
		
		JLabel passchangePasswordLabel = new JLabel("<html>비밀번호는 문자 숫자 특수문자의 조합으로 <br>8자 이상으로 입력해주세요.</html>");
		passchangePasswordLabel.setBounds(564, 464, 281, 62);
		
		JLabel lblNewLabel_17 = new JLabel("변경할 비밀번호");
		lblNewLabel_17.setBounds(235, 481, 95, 15);
		
		JLabel lblNewLabel_18 = new JLabel("비밀번호 확인");
		lblNewLabel_18.setBounds(248, 523, 82, 15);
		
		JLabel passchangePasscheckLabel = new JLabel("");
		passchangePasscheckLabel.setBounds(564, 523, 168, 15);
		
		passchangeChangePassword = new JPasswordField();
		passchangeChangePassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(PatternCheck.patternCheck(passchangeChangePassword.getText(),PatternCheck.passwordPattern)) {
					passchangePasswordLabel.setText("사용 가능합니다.");
					passwordFlag2 = true;
				}else {
					passchangePasswordLabel.setText("<html>비밀번호는 문자 숫자 특수문자의 조합으로 <br>8자 이상으로 입력해주세요.</html>");
					passwordFlag2 = false;
				}
				if(passchangePasswordCheck.getText().equals(passchangeChangePassword.getText())) {
					passchangePasscheckLabel.setText("일치합니다.");
					passCheckFlag2 = true;
				}else {
					passchangePasscheckLabel.setText("비밀번호가 다릅니다.");
					passCheckFlag2 = false;
				}
			}
		});
		passchangeChangePassword.setBounds(342, 473, 210, 32);
		
		passchangePasswordCheck = new JPasswordField();
		passchangePasswordCheck.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(passchangePasswordCheck.getText().equals(passchangeChangePassword.getText())) {
					passchangePasscheckLabel.setText("일치합니다.");
					passCheckFlag2 = true;
				}else {
					passchangePasscheckLabel.setText("비밀번호가 다릅니다.");
					passCheckFlag2 = false;
				}
			}
		});
		passchangePasswordCheck.setBounds(342, 515, 210, 32);
		
		
		
		JButton passchangeBackButton = new JButton("뒤로 가기");
		passchangeBackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayoutSet.show(contentPane, "mainPanel");	
			}
		});
		passchangeBackButton.setBounds(new Rectangle(377, 551, 144, 32));
		passchangeBackButton.setBounds(377, 599, 144, 32);
		
		JButton passchangeChangeButton = new JButton("비밀번호 변경");
		passchangeChangeButton.setBounds(377, 557, 144, 32);
		
		JButton tempororyPasswordButton = new JButton("임시 비밀번호 발급");
		tempororyPasswordButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		tempororyPasswordButton.setBounds(377, 375, 144, 32);
		

		JLabel lblNewLabel_13 = new JLabel("ID");
		lblNewLabel_13.setBounds(312, 226, 18, 15);
		
		JLabel lblNewLabel_14 = new JLabel("이름");
		lblNewLabel_14.setBounds(298, 275, 32, 15);
		
		JLabel lblNewLabel_15 = new JLabel("메일");
		lblNewLabel_15.setBounds(298, 328, 32, 15);
		
		JLabel lblNewLabel_16 = new JLabel("현재 비밀번호");
		lblNewLabel_16.setBounds(248, 439, 82, 15);
		contentPane.add(passchangePanel, "passchangePanel");
		passchangePanel.setLayout(null);
		
		mainPanel.setLayout(null);
		mainPanel.add(loginButton);
		mainPanel.add(SignupButton);
		mainPanel.add(idfoundButton);
		mainPanel.add(passchangeButton);
		mainPanel.add(lblNewLabel);
		mainPanel.add(lblNewLabel_1);
		mainPanel.add(lblNewLabel_2);
		mainPanel.add(lblNewLabel_3);
		
		loginPanel.setLayout(null);
		loginPanel.add(loginBackButton);
		loginPanel.add(loginLoginButton);
		loginPanel.add(loginIdTextField);
		loginPanel.add(loginPasswordField);
		loginPanel.add(loginIdLabel);
		loginPanel.add(loginPasswordLabel);
		loginPanel.add(loginStateLabel);
		
		ButtonGroup MWGroup = new ButtonGroup();
		MWGroup.add(signupManRadioButton);
		MWGroup.add(signupWomanRadioButton);
		
		signupPanel.setLayout(null);
		signupPanel.add(signupWomanRadioButton);
		signupPanel.add(signupManRadioButton);
		signupPanel.add(btnNewButton);
		signupPanel.add(lblNewLabel_4);
		signupPanel.add(lblNewLabel_5);
		signupPanel.add(lblNewLabel_6);
		signupPanel.add(lblNewLabel_7);
		signupPanel.add(signupDoublecheckButton);
		signupPanel.add(signupPasswordLabel);
		signupPanel.add(signupPassCheckLabel);
		signupPanel.add(lblNewLabel_10);
		signupPanel.add(lblNewLabel_11);
		signupPanel.add(lblNewLabel_12);
		signupPanel.add(signupMailLabel);
		signupPanel.add(signupBackButton);
		signupPanel.add(signupMailField);
		signupPanel.add(signupNicknameField);
		signupPanel.add(signupIdField);
		signupPanel.add(signupPasswordField);
		signupPanel.add(signupPassCheckField);
		signupPanel.add(signupNameField);
		
		idfounderPanel.setLayout(null);
		idfounderPanel.add(idfounderNameField);
		idfounderPanel.add(idfounderMailField);
		idfounderPanel.add(idfounderFoundButton);
		idfounderPanel.add(lblNewLabel_8);
		idfounderPanel.add(lblNewLabel_9);
		idfounderPanel.add(idfounderBackButton);
		
		contentPane.add(mainPanel, "mainPanel");
		contentPane.add(loginPanel, "loginPanel");
		contentPane.add(signupPanel, "signupPanel");
		contentPane.add(idfounderPanel, "idfounderPanel");
		passchangePanel.add(passchangeBackButton);
		passchangePanel.add(passchangeChangeButton);
		passchangePanel.add(tempororyPasswordButton);
		passchangePanel.add(passchangeMailField);
		passchangePanel.add(passchangeCurrentPassword);
		passchangePanel.add(passchangeNameField);
		passchangePanel.add(passchangeIdField);
		passchangePanel.add(lblNewLabel_13);
		passchangePanel.add(lblNewLabel_14);
		passchangePanel.add(lblNewLabel_15);
		passchangePanel.add(lblNewLabel_16);
		passchangePanel.add(passchangeChangePassword);
		passchangePanel.add(passchangePasswordCheck);
		passchangePanel.add(lblNewLabel_17);
		passchangePanel.add(lblNewLabel_18);
		passchangePanel.add(passchangePasscheckLabel);
		passchangePanel.add(passchangePasswordLabel);
				
		cardLayoutSet.show(contentPane, "mainPanel");	
	}
}
		
	
