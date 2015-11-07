import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		JMenuItem mntmEquation = new JMenuItem("Equation");
		mntmEquation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				new EquationWizard().ShowWindow();
			}
		});
		mnView.add(mntmEquation);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		frame.getContentPane().setLayout(null);

		final TextField textField = new TextField();
		textField.setBounds(10, 10, 206, 61);
		frame.getContentPane().add(textField);

		JButton button = new JButton("0");
		button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button.setBounds(55, 216, 39, 24);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "0");
			}
		});
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("1");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_1.setBounds(10, 187, 39, 23);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "1");
			}
		});
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("2");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_2.setBounds(55, 187, 39, 23);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "2");
			}
		});
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("3");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_3.setBounds(100, 187, 39, 23);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "3");
			}
		});
		frame.getContentPane().add(button_3);

		JButton button_4 = new JButton("4");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_4.setBounds(10, 158, 39, 23);
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "4");
			}
		});
		frame.getContentPane().add(button_4);

		JButton button_5 = new JButton("5");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_5.setBounds(55, 158, 39, 23);
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "5");
			}
		});
		frame.getContentPane().add(button_5);

		JButton button_6 = new JButton("6");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_6.setBounds(100, 158, 39, 23);
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "6");
			}
		});
		frame.getContentPane().add(button_6);

		JButton button_7 = new JButton("7");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_7.setBounds(10, 129, 39, 23);
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "7");
			}
		});
		frame.getContentPane().add(button_7);

		JButton button_8 = new JButton("8");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_8.setBounds(55, 129, 39, 23);
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "8");
			}
		});
		frame.getContentPane().add(button_8);

		JButton button_9 = new JButton("9");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_9.setBounds(100, 129, 39, 23);
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "9");
			}
		});
		frame.getContentPane().add(button_9);

		JButton button_10 = new JButton(".");
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_10.setBounds(10, 216, 39, 24);
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + ".");
			}
		});
		frame.getContentPane().add(button_10);

		final JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(244, 11, 190, 60);
		frame.getContentPane().add(textPane);

		final Mathematics_adv math = new Mathematics_adv(textPane);

		final JRadioButton rdbtnDegrees = new JRadioButton("Degrees");
		rdbtnDegrees.setBounds(10, 77, 84, 23);
		final JRadioButton rdbtnRadians = new JRadioButton("Radians");
		rdbtnRadians.setBounds(100, 77, 84, 23);

		rdbtnDegrees.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				rdbtnRadians.setSelected(!rdbtnDegrees.isSelected());
				math.curr_mode = Mode.Degree;

			}
		});

		rdbtnRadians.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				rdbtnDegrees.setSelected(!rdbtnRadians.isSelected());
				math.curr_mode = Mode.Radians;
			}
		});

		rdbtnDegrees.setSelected(true);
		frame.getContentPane().add(rdbtnDegrees);
		frame.getContentPane().add(rdbtnRadians);

		JButton button_11 = new JButton("+");
		button_11.setBounds(145, 158, 51, 23);
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "+");
			}
		});
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(button_11);

		JButton button_12 = new JButton("-");
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_12.setBounds(145, 187, 51, 23);
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "-");
			}
		});
		frame.getContentPane().add(button_12);

		JButton btnNewButton = new JButton("x");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(145, 129, 51, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "x");
			}
		});
		frame.getContentPane().add(btnNewButton);

		JButton button_13 = new JButton("\u00F7");
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_13.setBounds(145, 216, 51, 23);
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "/");
			}
		});
		frame.getContentPane().add(button_13);

		JButton btnSin = new JButton("sin");
		btnSin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSin.setBounds(244, 100, 63, 23);
		btnSin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "sin(");
			}
		});
		frame.getContentPane().add(btnSin);

		JButton btnCos = new JButton("cos");
		btnCos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCos.setBounds(244, 129, 63, 23);
		btnCos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "cos(");
			}
		});
		frame.getContentPane().add(btnCos);

		JButton btnTan = new JButton("tan");
		btnTan.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTan.setBounds(244, 158, 63, 23);
		btnTan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "tan(");
			}
		});
		frame.getContentPane().add(btnTan);

		JButton btnLog = new JButton("log");
		btnLog.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLog.setBounds(244, 187, 63, 23);
		btnLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "log(");
			}
		});
		frame.getContentPane().add(btnLog);

		JButton btnLn = new JButton("ln");
		btnLn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLn.setBounds(244, 216, 63, 23);
		btnLn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "ln(");
			}
		});
		frame.getContentPane().add(btnLn);

		JButton btnNewButton_1 = new JButton("(");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setBounds(313, 100, 57, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "(");
			}
		});
		frame.getContentPane().add(btnNewButton_1);

		JButton button_14 = new JButton(")");
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_14.setBounds(313, 129, 57, 23);
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + ")");
			}
		});
		frame.getContentPane().add(button_14);

		JButton button_15 = new JButton("<html>x<sup>y</sup></html>");
		button_15.setBounds(313, 158, 57, 23);
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_15.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "^");
			}
		});
		frame.getContentPane().add(button_15);

		JButton button_16 = new JButton("sqrt");
		button_16.setBounds(313, 187, 57, 23);
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + "sqrt(");
			}
		});
		frame.getContentPane().add(button_16);

		final JCheckBox chckbxUseSignificantFigures = new JCheckBox(
				"Use Significant Figures");
		chckbxUseSignificantFigures.setBounds(10, 99, 133, 23);
		frame.getContentPane().add(chckbxUseSignificantFigures);

		JButton button_17 = new JButton("=");
		button_17.setBounds(100, 216, 39, 24);
		button_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Print out the Answer
				// System.out.print(parser.Parse(textField.getText()));
				if (chckbxUseSignificantFigures.isSelected()) {
					textField.setText(String.valueOf(parser.Parse(
							textField.getText(), true, math)));
				}

				textField.setText(String.valueOf(parser.Parse(
						textField.getText(), false, math)));
			}
		});
		button_17.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().add(button_17);

		JButton btnClear = new JButton("C");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnClear.setBounds(376, 100, 58, 23);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textPane.setText("");
			}
		});
		frame.getContentPane().add(btnClear);

		JButton button_18 = new JButton("bksp");
		button_18.setBounds(376, 129, 58, 23);
		button_18.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DONE: backspace
				if (textField.getText().length() > 0) {
					textField.setText(textField.getText().substring(0,
							textField.getText().length() - 1));
				}
			}
		});
		frame.getContentPane().add(button_18);

		JButton button_19 = new JButton("pi");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_19.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_19.setBounds(313, 216, 58, 23);
		button_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + Math.PI);
			}
		});
		frame.getContentPane().add(button_19);

		JButton btnE = new JButton("e");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnE.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnE.setBounds(376, 158, 58, 23);
		btnE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(textField.getText() + Math.E);
			}
		});
		frame.getContentPane().add(btnE);

	}
}
