import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class frameVenditore extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public frameVenditore() {
		setTitle("Registra Venditore");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 280);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 404, 241);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Registrazione nuovo venditore");
		label.setBounds(10, 11, 163, 14);
		panel.add(label);
		
		JLabel lblNome = new JLabel("Nome ");
		lblNome.setBounds(10, 60, 73, 14);
		panel.add(lblNome);
		
		JLabel label_3 = new JLabel("Partita IVA");
		label_3.setBounds(10, 84, 93, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Via");
		label_4.setBounds(10, 108, 46, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("N\u00B0Civico");
		label_5.setBounds(10, 132, 73, 14);
		panel.add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 57, 250, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 81, 250, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(97, 105, 250, 20);
		panel.add(textField_3);
		
		JButton button = new JButton("Conferma");
		
		button.setBounds(233, 194, 114, 23);
		panel.add(button);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(97, 129, 250, 20);
		panel.add(textField_4);
		
		JLabel label_6 = new JLabel("CAP");
		label_6.setBounds(10, 156, 46, 14);
		panel.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(97, 153, 250, 20);
		panel.add(textField_5);
		
		JRadioButton radioButton = new JRadioButton("Azienda");
		radioButton.setBounds(97, 27, 109, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Privato");
		radioButton_1.setBounds(231, 27, 109, 23);
		panel.add(radioButton_1);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_1);
	
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pIva = textField_2.getText();
				String via = textField_3.getText();
				String nc = textField_4.getText();
				String cap = textField_5.getText();
				String nome = textField_1.getText();
				if(radioButton.isSelected()){
					Connectors.addAzienda(pIva, nome, via, Integer.parseInt(nc), Integer.parseInt(cap));
					dispose();
				}else{
					Connectors.addPrivato(pIva, nome, via, Integer.parseInt(nc), Integer.parseInt(cap));
					dispose();
				}
			}
		});
		
	}
}