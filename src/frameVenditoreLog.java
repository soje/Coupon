import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class frameVenditoreLog extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public frameVenditoreLog(String pIva) {
		setTitle("Area Venditore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 499);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 714, 326);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 366, 714, 2);
		contentPane.add(separator);
		
		JLabel lblRimuoviCoupon = new JLabel("Rimuovi Coupon");
		lblRimuoviCoupon.setBounds(10, 348, 142, 14);
		contentPane.add(lblRimuoviCoupon);
		
		JLabel lblInserireIlCodice = new JLabel("Inserire il codice  ");
		lblInserireIlCodice.setBounds(10, 379, 115, 14);
		contentPane.add(lblInserireIlCodice);
		
		textField = new JTextField();
		textField.setBounds(10, 396, 199, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRimuovi = new JButton("Rimuovi");
		btnRimuovi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				String codice = textField.getText();
				Connectors.removeCoupon(codice, pIva);
				textArea.setText(null);
				ArrayList<String> tmp = Connectors.getListaCouponVenditore(pIva);
				for(String s : tmp){
					textArea.append(s+"\n");
				}
			}
		});
		btnRimuovi.setBounds(94, 427, 115, 23);
		contentPane.add(btnRimuovi);
		
		JLabel lblAggiungiCoupon = new JLabel("Aggiungi Coupon");
		lblAggiungiCoupon.setBounds(568, 348, 127, 14);
		contentPane.add(lblAggiungiCoupon);
		
		JButton btnInserisci = new JButton("Inserisci");
		btnInserisci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrameAggiungiCoupon fac = new FrameAggiungiCoupon(pIva);
				fac.setVisible(true);
				dispose();
			}
		});
		btnInserisci.setBounds(569, 395, 115, 23);
		contentPane.add(btnInserisci);
		
		ArrayList<String> tmp = Connectors.getListaCouponVenditore(pIva);
		for(String s : tmp){
			textArea.append(s+"\n");
		}
		
	}
}
