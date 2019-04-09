import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frameCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public frameCliente() {
		setTitle("Registra Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 390, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrazioneNuovoCliente = new JLabel("Registrazione nuovo cliente");
		lblRegistrazioneNuovoCliente.setBounds(10, 11, 163, 14);
		contentPane.add(lblRegistrazioneNuovoCliente);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 36, 73, 14);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(10, 60, 73, 14);
		contentPane.add(lblCognome);
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		lblCodiceFiscale.setBounds(10, 84, 93, 14);
		contentPane.add(lblCodiceFiscale);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 108, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPreferenza = new JLabel("Preferenza");
		lblPreferenza.setBounds(10, 128, 73, 14);
		contentPane.add(lblPreferenza);
		
		textField = new JTextField();
		textField.setBounds(97, 33, 250, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 57, 250, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 81, 250, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(97, 105, 250, 20);
		contentPane.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sportivo ", "Oggettistica", "Ristorazione"}));
		comboBox.setBounds(97, 128, 130, 20);
		contentPane.add(comboBox);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = textField.getText();
				String cognome = textField_1.getText();
				String codFisc = textField_2.getText();
				String email = textField_3.getText();
				String pref = comboBox.getSelectedItem().toString();
				Connectors.addClienti(codFisc.toUpperCase(), nome, cognome, email, pref);
				dispose();
			}
		});
		btnConferma.setBounds(233, 177, 114, 23);
		contentPane.add(btnConferma);
	}
}
