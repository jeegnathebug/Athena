import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class EquationWizard {
	private JFrame frmEquationwizard;
	private JButton btnNewButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	
	public Form ontab = Form.Linear;
	public JTextField txt;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextPane textPane;
	private JTextPane textPane_1 = new JTextPane();
	private String unkn = "";
	private JTextField textField_17;
	private JTextField textField_18;
	
	Mathematics_adv math = new Mathematics_adv(textPane_1);
	
	EquationWizard()
	{
		initialize();
	}
	
	enum Form{
		Linear,Quadratic,Absolute,Squareroot
	}
	
	public void ShowWindow()
	{
		frmEquationwizard.setVisible(true);
	}
	
	private void initialize() {
		frmEquationwizard = new JFrame();
		frmEquationwizard.setTitle("EquationWizard");
		frmEquationwizard.setResizable(false);
		frmEquationwizard.setBounds(100, 100, 575, 400);
		frmEquationwizard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEquationwizard.getContentPane().setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				switch(tabbedPane.getSelectedIndex()){
				case 0:{
					ontab = Form.Linear;
					break;
				}
				case 2:{
					ontab = Form.Quadratic;
					break;
				}
				case 1:{
					ontab = Form.Squareroot;
					break;
				}
				case 3:{
					ontab = Form.Absolute;
					break;
				}
				}
			}
			
		});

		tabbedPane.setBounds(237, 11, 322, 177);
		frmEquationwizard.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Linear", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setName("y");
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField;
			}
		});
		textField.setBounds(30, 15, 50, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setName("x");
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_1;
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(30, 45, 50, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setName("a");
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_2;
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(30, 75, 50, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setName("b");
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_3;
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(30, 105, 50, 20);
		panel.add(textField_3);
		
		JLabel lblY = new JLabel("y");
		lblY.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblY.setBounds(15, 15, 15, 15);
		panel.add(lblY);
		
		JLabel lblX = new JLabel("x");
		lblX.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblX.setBounds(15, 45, 15, 15);
		panel.add(lblX);
		
		JLabel lblA = new JLabel("a");
		lblA.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblA.setBounds(15, 75, 15, 15);
		panel.add(lblA);
		
		JLabel lblB = new JLabel("b");
		lblB.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblB.setBounds(15, 105, 15, 15);
		panel.add(lblB);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Sqrt", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("y");
		label.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label.setBounds(15, 15, 15, 15);
		panel_3.add(label);
		
		JLabel lblX_3 = new JLabel("x");
		lblX_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblX_3.setBounds(15, 45, 15, 15);
		panel_3.add(lblX_3);
		
		JLabel lblH_1 = new JLabel("h");
		lblH_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblH_1.setBounds(15, 75, 15, 15);
		panel_3.add(lblH_1);
		
		JLabel lblK_1 = new JLabel("k");
		lblK_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblK_1.setBounds(15, 105, 15, 15);
		panel_3.add(lblK_1);
		
		textField_13 = new JTextField();
		textField_13.setName("y");
		textField_13.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_13;
			}
		});
		textField_13.setColumns(10);
		textField_13.setBounds(30, 15, 50, 20);
		panel_3.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setName("x");
		textField_14.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_14;
			}
		});
		textField_14.setColumns(10);
		textField_14.setBounds(30, 45, 50, 20);
		panel_3.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setName("h");
		textField_15.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_15;
			}
		});
		textField_15.setColumns(10);
		textField_15.setBounds(30, 75, 50, 20);
		panel_3.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setName("k");
		textField_16.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_16;
			}
		});
		textField_16.setColumns(10);
		textField_16.setBounds(30, 105, 50, 20);
		panel_3.add(textField_16);
		
		textField_18 = new JTextField();
		textField_18.setName("a");
		textField_18.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_18;
			}
		});
		textField_18.setColumns(10);
		textField_18.setBounds(107, 15, 50, 20);
		panel_3.add(textField_18);
		
		JLabel lblA_3 = new JLabel("a");
		lblA_3.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblA_3.setBounds(92, 15, 15, 15);
		panel_3.add(lblA_3);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Quadratic", null, panel_1, null);
		tabbedPane.setEnabledAt(2, false);
		panel_1.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txt = textField_4;
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(19, 11, 48, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_5;
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(19, 42, 48, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_6;
			}
		});
		textField_6.setColumns(10);
		textField_6.setBounds(19, 73, 48, 20);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_7;
			}
		});
		textField_7.setColumns(10);
		textField_7.setBounds(19, 104, 48, 20);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_8;
			}
		});
		textField_8.setColumns(10);
		textField_8.setBounds(87, 11, 48, 20);
		panel_1.add(textField_8);
		
		JLabel lblA_1 = new JLabel("a");
		lblA_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblA_1.setBounds(9, 14, 46, 14);
		panel_1.add(lblA_1);
		
		JLabel lblB_1 = new JLabel("b");
		lblB_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblB_1.setBounds(9, 45, 46, 14);
		panel_1.add(lblB_1);
		
		JLabel lblC = new JLabel("c");
		lblC.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblC.setBounds(9, 76, 46, 14);
		panel_1.add(lblC);
		
		JLabel lblY_1 = new JLabel("y");
		lblY_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblY_1.setBounds(9, 107, 46, 14);
		panel_1.add(lblY_1);
		
		JLabel lblX_1 = new JLabel("x");
		lblX_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblX_1.setBounds(77, 14, 46, 14);
		panel_1.add(lblX_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Abs. Value", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblY_2 = new JLabel("y");
		lblY_2.setBounds(15, 15, 15, 15);
		lblY_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panel_2.add(lblY_2);
		
		JLabel lblX_2 = new JLabel("x");
		lblX_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblX_2.setBounds(15, 45, 15, 15);
		panel_2.add(lblX_2);
		
		JLabel lblH = new JLabel("h");
		lblH.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblH.setBounds(15, 75, 15, 15);
		panel_2.add(lblH);
		
		JLabel lblK = new JLabel("k");
		lblK.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblK.setBounds(15, 105, 15, 15);
		panel_2.add(lblK);
		
		textField_9 = new JTextField();
		textField_9.setName("y");
		textField_9.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_9;
			}
		});
		textField_9.setColumns(10);
		textField_9.setBounds(30, 15, 50, 20);
		panel_2.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setName("x");
		textField_10.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_10;
			}
		});
		textField_10.setColumns(10);
		textField_10.setBounds(30, 45, 50, 20);
		panel_2.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setName("h");
		textField_11.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_11;
			}
		});
		textField_11.setColumns(10);
		textField_11.setBounds(30, 75, 50, 20);
		panel_2.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setName("k");
		textField_12.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_12;
			}
		});
		textField_12.setColumns(10);
		textField_12.setBounds(30, 105, 50, 20);
		panel_2.add(textField_12);
		
		textField_17 = new JTextField();
		textField_17.setName("a");
		textField_17.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txt = textField_17;
			}
		});
		textField_17.setColumns(10);
		textField_17.setBounds(107, 15, 50, 20);
		panel_2.add(textField_17);
		
		JLabel lblA_2 = new JLabel("a");
		lblA_2.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblA_2.setBounds(92, 15, 15, 15);
		panel_2.add(lblA_2);
		
		btnNewButton = new JButton("Solve");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				switch(ontab){
					case Linear:{
						//y=1, x=2, a=3, b=4
						String ans = EquationSolver.Linear(new String[]{unkn, textField.getText(), textField_1.getText(),textField_2.getText(),textField_3.getText()}, math);
						textPane.setText(ans);
						break;
					}
					case Quadratic:{
						EquationSolver.Quadratic(new String[]{""});
						break;
					}
					case Absolute:{
						//y=1, x=2, a=3, h=4, k=5
						String ans = EquationSolver.Absolute_Value(new String[]{unkn,textField_9.getText(),textField_10.getText(),textField_17.getText(),textField_11.getText(),textField_12.getText()}, math);
						textPane.setText(ans);
						break;
					}
					case Squareroot:{
						
						String ans = EquationSolver.SquareRoot(new String[]{unkn,textField_13.getText(),textField_14.getText(),textField_18.getText(),textField_15.getText(),textField_16.getText()}, math);
						textPane.setText(ans);
						break;
					}
				}
			}
		});
		btnNewButton.setBounds(10, 305, 89, 23);
		frmEquationwizard.getContentPane().add(btnNewButton);
		
		JButton button_7 = new JButton("7");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				txt.setText(txt.getText() + "7");
			}
		});
		button_7.setBounds(10, 49, 48, 23);
		frmEquationwizard.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				txt.setText(txt.getText() + "8");
			}
		});
		button_8.setBounds(68, 49, 48, 23);
		frmEquationwizard.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				txt.setText(txt.getText() + "9");
			}
		});
		button_9.setBounds(126, 49, 48, 23);
		frmEquationwizard.getContentPane().add(button_9);
		
		JButton button_4 = new JButton("4");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				txt.setText(txt.getText() + "4");
			}
		});
		button_4.setBounds(10, 83, 48, 23);
		frmEquationwizard.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				txt.setText(txt.getText() + "5");
			}
		});
		button_5.setBounds(68, 83, 48, 23);
		frmEquationwizard.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				txt.setText(txt.getText() + "6");
			}
		});
		button_6.setBounds(126, 83, 48, 23);
		frmEquationwizard.getContentPane().add(button_6);
		
		JButton button_1 = new JButton("1");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				txt.setText(txt.getText() + "1");
			}
		});
		button_1.setBounds(10, 117, 48, 23);
		frmEquationwizard.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				txt.setText(txt.getText() + "2");
			}
		});
		button_2.setBounds(68, 117, 48, 23);
		frmEquationwizard.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				txt.setText(txt.getText() + "3");
			}
		});
		button_3.setBounds(126, 117, 48, 23);
		frmEquationwizard.getContentPane().add(button_3);
		
		JButton button = new JButton("0");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				txt.setText(txt.getText() + "0");
			}
		});
		button.setBounds(68, 151, 48, 23);
		frmEquationwizard.getContentPane().add(button);
		
		JButton button_10 = new JButton(".");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				txt.setText(txt.getText() + ".");
			}
		});
		button_10.setBounds(126, 151, 48, 23);
		frmEquationwizard.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("-/+");
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				txt.setText(txt.getText() + "-");
			}
		});
		button_11.setBounds(10, 151, 48, 23);
		frmEquationwizard.getContentPane().add(button_11);
		
		JButton btnUnknown = new JButton("Unknown");
		btnUnknown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				txt.setText("unkn");
				unkn = txt.getName();				
			}
		});
		btnUnknown.setBounds(48, 185, 89, 23);
		frmEquationwizard.getContentPane().add(btnUnknown);
		
		textPane = new JTextPane();
		textPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPane.setBounds(10, 340, 215, 23);
		frmEquationwizard.getContentPane().add(textPane);
		textPane.setEditable(false);
		textPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		

		textPane_1.setEditable(false);
		textPane_1.setBounds(237, 200, 322, 163);
		frmEquationwizard.getContentPane().add(textPane_1);
	}
}