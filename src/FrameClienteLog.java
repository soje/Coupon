import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameClienteLog extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	/**
	 * Create the frame.
	 */
	public FrameClienteLog(String codFisc) {
		setTitle("Area Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 664, 322);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		ArrayList<String> tmp = Connectors.getListaCoupon();
		for(String s : tmp){
			textArea.append(s+"\n");
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 359, 664, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Acquista o recensisci un coupon");
		lblNewLabel.setBounds(10, 344, 276, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 396, 400, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAcquista = new JButton("Acquista");
		btnAcquista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String codice = textField.getText();
				Connectors.acquistatoDa(UtilityMethods.ritornaDataCorrente(), UtilityMethods.ritornaDataScadenza(), codice, codFisc);
			}
		});
		
		btnAcquista.setBounds(10, 427, 140, 23);
		contentPane.add(btnAcquista);
		
		JLabel lblRiscattaUnPremio = new JLabel("Riscatta un premio");
		lblRiscattaUnPremio.setBounds(488, 344, 127, 14);
		contentPane.add(lblRiscattaUnPremio);
		
		JButton btnRecensisci = new JButton("Recensisci");
		btnRecensisci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				String codice = textField.getText();
				if(Connectors.checkRecensioneCliente(codFisc, codice)){
					FrameAggiungiRecensione far = new FrameAggiungiRecensione(codice, codFisc);
					far.setVisible(true);
					dispose();
				}
			}
		});
		btnRecensisci.setBounds(270, 427, 140, 23);
		contentPane.add(btnRecensisci);
		
		JLabel lblInserisciIlCodice = new JLabel("Inserisci il codice del coupon");
		lblInserisciIlCodice.setBounds(10, 371, 246, 14);
		contentPane.add(lblInserisciIlCodice);
		
		JButton btnNewButton = new JButton("Riscatta");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameRiscattaPremio frp = new FrameRiscattaPremio(codFisc);
				frp.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setBounds(488, 427, 140, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblITuoiPunti = new JLabel("I tuoi punti: ");
		lblITuoiPunti.setBounds(488, 371, 88, 14);
		contentPane.add(lblITuoiPunti);
		
		int punti = Connectors.getPuntiCliente(codFisc);
		JLabel lblNewLabel_1 = new JLabel(String.valueOf(punti));
		lblNewLabel_1.setBounds(488, 399, 140, 14);
		contentPane.add(lblNewLabel_1);
		
	}
}
