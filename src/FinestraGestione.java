import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FinestraGestione extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FinestraGestione() {
		setTitle("Gestione");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 150, 664, 300);
		contentPane.add(textArea);
		
		JButton btnNumeroAcquistiSingolo = new JButton("Numero acquisti singolo coupon");
		btnNumeroAcquistiSingolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText(null);
				al = Connectors.getNumeroCouponVenduti();
				for(String s : al){
					textArea.append(s+"\n");
				}
			}
		});
		btnNumeroAcquistiSingolo.setBounds(30, 11, 210, 23);
		contentPane.add(btnNumeroAcquistiSingolo);
		
		JButton btnTopVenditori = new JButton("Top 3 Venditori per Valutazione");
		btnTopVenditori.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText(null);
				al = Connectors.getTopVenditori();
				for(String s : al){
					textArea.append(s+"\n");
				}
			}
		});
		btnTopVenditori.setBounds(30, 48, 210, 23);
		contentPane.add(btnTopVenditori);
		
		JButton btnNewButton = new JButton("Top 5 Clienti per Recensione");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				textArea.setText(null);
				al = Connectors.getTopClientiRecensioni();
				for(String s : al){
					textArea.append(s+"\n");
				}
			}
		});
		btnNewButton.setBounds(30, 82, 210, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Top 10 Clienti per numero punti");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText(null);
				al = Connectors.getTopClientiPunti();
				for(String s : al){
					textArea.append(s+"\n");
				}
			}
		});
		btnNewButton_1.setBounds(30, 116, 210, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblClientiCheNon = new JLabel("Clienti che non hannpo acquistato una particolare categoria");
		lblClientiCheNon.setBounds(364, 15, 310, 14);
		contentPane.add(lblClientiCheNon);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sportivo ", "Oggettistica", "Ristorazione"}));
		comboBox.setBounds(520, 40, 130, 20);
		contentPane.add(comboBox);
		
		JLabel lblSelezionaPreferenza = new JLabel("Seleziona preferenza:");
		lblSelezionaPreferenza.setBounds(364, 43, 130, 14);
		contentPane.add(lblSelezionaPreferenza);
		
		JButton btnNewButton_2 = new JButton("Conferma");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText(null);
				al = Connectors.getCouponNonAcquistatiPerCategoriaDaClienti(comboBox.getSelectedItem().toString());
				for(String s : al){
					textArea.append(s+"\n");
				}
			}
		});
		btnNewButton_2.setBounds(520, 71, 130, 23);
		contentPane.add(btnNewButton_2);
	}
	
	private ArrayList<String> al;
}
