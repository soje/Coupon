import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameAggiungiRecensione extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrameAggiungiRecensione(String codice, String codFisc) {
		setTitle("Recensione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAggiungiLaRecensione = new JLabel("Aggiungi  la recensione del coupon numero: "+codice);
		lblAggiungiLaRecensione.setBounds(10, 11, 399, 14);
		contentPane.add(lblAggiungiLaRecensione);
		
		JLabel lblEsprimiIlTuo = new JLabel("Esprimi il tuo parere:");
		lblEsprimiIlTuo.setBounds(10, 46, 172, 14);
		contentPane.add(lblEsprimiIlTuo);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 76, 414, 122);
		textArea.setLineWrap(true);
		contentPane.add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(53, 221, 45, 20);
		contentPane.add(comboBox);
		
		JLabel lblVoto = new JLabel("Voto:");
		lblVoto.setBounds(10, 224, 46, 14);
		contentPane.add(lblVoto);
		
		JButton btnNewButton = new JButton("Inserisci");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String desc = textArea.getText();
				int voto = Integer.parseInt(comboBox.getSelectedItem().toString());
				Connectors.recensitoDa(voto, UtilityMethods.ritornaDataCorrente(), codice, codFisc, desc);
				int valutazione = Connectors.calcolaMediaValutazioneVenditore(Connectors.getPivaVenditore(codice));
				Connectors.updateValutazione(valutazione, Connectors.getPivaVenditore(codice));
				dispose();
				FrameClienteLog fcl = new FrameClienteLog(codFisc);
				fcl.setVisible(true);
			}
		});
		
		btnNewButton.setBounds(267, 220, 157, 23);
		contentPane.add(btnNewButton);
	}
}
