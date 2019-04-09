import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class FrameRiscattaPremio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public FrameRiscattaPremio(String codFisc) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 26, 414, 179);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		ArrayList<String> tmp = Connectors.getListaPremi();
		for(String s : tmp){
			textArea.append(s+"\n");
		}
		
		JLabel lblListaPremi = new JLabel("Lista premi");
		lblListaPremi.setBounds(10, 11, 74, 14);
		contentPane.add(lblListaPremi);
		
		JLabel lblCodice = new JLabel("codice premio da riscattare");
		lblCodice.setBounds(10, 215, 171, 14);
		contentPane.add(lblCodice);
		
		textField = new JTextField();
		textField.setBounds(10, 230, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Riscatta");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String codice = textField.getText();
				System.out.println(codice);
				int puntiCli = Connectors.getPuntiCliente(codFisc);
				System.out.println(puntiCli);
				int puntiPr = Connectors.getValorePuntiPremio(codice);
				System.out.println(puntiPr);
				if(puntiCli>=puntiPr){
					Connectors.addRiscatta(UtilityMethods.ritornaDataCorrente(), codice, codFisc);
					Connectors.updatePunti( (puntiCli-puntiPr) , codFisc);
					dispose();
					FrameClienteLog frp = new FrameClienteLog(codFisc);
					frp.setVisible(true);
				}else System.out.println("Errore");
			}
		});
		
		btnNewButton.setBounds(209, 229, 203, 23);
		contentPane.add(btnNewButton);
	}

}
