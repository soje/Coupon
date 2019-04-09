import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class FrameAggiungiCoupon extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public FrameAggiungiCoupon(String pIva) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAggiugniNuovoCoupon = new JLabel("Aggiugni nuovo coupon");
		lblAggiugniNuovoCoupon.setBounds(20, 11, 190, 14);
		contentPane.add(lblAggiugniNuovoCoupon);
		
		JLabel lblCodice = new JLabel("Codice:");
		lblCodice.setBounds(20, 46, 46, 14);
		contentPane.add(lblCodice);
		
		JLabel lblPrezzoEffettivo = new JLabel("Prezzo Effettivo:");
		lblPrezzoEffettivo.setBounds(20, 71, 97, 14);
		contentPane.add(lblPrezzoEffettivo);
		
		JLabel lblPrezzoScontato = new JLabel("Prezzo Scontato:");
		lblPrezzoScontato.setBounds(20, 97, 97, 14);
		contentPane.add(lblPrezzoScontato);
		
		JLabel lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setBounds(20, 122, 82, 14);
		contentPane.add(lblDescrizione);
		
		textField = new JTextField();
		textField.setBounds(120, 43, 304, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 67, 304, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 91, 304, 20);
		contentPane.add(textField_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(120, 117, 304, 148);
		textArea.setLineWrap(true);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String codice = textField.getText();
				double preEff = Double.parseDouble(textField_1.getText());
				double preSco = Double.parseDouble(textField_2.getText());
				String desc = textArea.getText();
				if(UtilityMethods.checkPrezzoValido(preEff, preSco)){
					Connectors.addCoupon(codice, desc, preEff, preSco, UtilityMethods.CalcolaValorePunti(preEff), pIva);
					dispose();
					frameVenditoreLog fvl = new frameVenditoreLog(pIva);
					fvl.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(249, 273, 175, 23);
		contentPane.add(btnNewButton);

	}
}
