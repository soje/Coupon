import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class windowsFrame {

	private JFrame frmCoupon;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowsFrame window = new windowsFrame();
					window.frmCoupon.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public windowsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoupon = new JFrame();
		frmCoupon.setTitle("Coupon");
		frmCoupon.setBounds(100, 100, 450, 270);
		frmCoupon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoupon.getContentPane().setLayout(null);
		frmCoupon.setLocationRelativeTo(null);
		
		JLabel lblBenvenuto = new JLabel("Benvenuto!");
		lblBenvenuto.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblBenvenuto.setBounds(10, 11, 313, 38);
		frmCoupon.getContentPane().add(lblBenvenuto);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 93, 139, 20);
		frmCoupon.getContentPane().add(textField);
		
		JLabel label = new JLabel("Codice Fiscale");
		label.setBounds(17, 77, 86, 14);
		frmCoupon.getContentPane().add(label);
		
		JButton button = new JButton("Nuovo cliente?");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameCliente fc = new frameCliente();
				fc.setVisible(true);
			}
		});
		button.setBounds(10, 124, 139, 23);
		frmCoupon.getContentPane().add(button);
		
		JButton button_1 = new JButton("Ok");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String codFisc = textField.getText();
				if(UtilityMethods.checkCodFisc(codFisc)){
					FrameClienteLog fcl = new FrameClienteLog(codFisc);
					fcl.setVisible(true);
					frmCoupon.dispose();
				}else
					System.out.println("Errore");
					
			}
		});
		button_1.setBounds(151, 93, 55, 20);
		frmCoupon.getContentPane().add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(228, 93, 139, 20);
		frmCoupon.getContentPane().add(textField_1);
		
		JLabel label_1 = new JLabel("Partita IVA");
		label_1.setBounds(228, 77, 66, 14);
		frmCoupon.getContentPane().add(label_1);
		
		JButton button_2 = new JButton("Nuovo venditore?");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameVenditore fv = new frameVenditore();
				fv.setVisible(true);
			}
		});
		button_2.setBounds(228, 124, 139, 23);
		frmCoupon.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Ok");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pIva = textField_1.getText();
				if(UtilityMethods.checkPiva(pIva)){
					frameVenditoreLog fvl = new frameVenditoreLog(pIva);
					fvl.setVisible(true);
					frmCoupon.dispose();
				}else {
					System.out.println("Erorre");
				}
			}
		});
		button_3.setBounds(369, 93, 55, 20);
		frmCoupon.getContentPane().add(button_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 184, 414, 2);
		frmCoupon.getContentPane().add(separator);
		
		JLabel lblProgettoBasiDi = new JLabel("Progetto Basi di Dati ");
		lblProgettoBasiDi.setBounds(10, 168, 144, 14);
		frmCoupon.getContentPane().add(lblProgettoBasiDi);
		
		JLabel lblDarioGaliani = new JLabel("Dario Galiani");
		lblDarioGaliani.setBounds(10, 197, 93, 14);
		frmCoupon.getContentPane().add(lblDarioGaliani);
		
		JLabel lblCarmineVincenzoRusso = new JLabel("Carmine Vincenzo Russo");
		lblCarmineVincenzoRusso.setBounds(268, 197, 156, 14);
		frmCoupon.getContentPane().add(lblCarmineVincenzoRusso);
		
		JLabel label_2 = new JLabel("2014/2015");
		label_2.setBounds(343, 168, 81, 14);
		frmCoupon.getContentPane().add(label_2);
		
		JButton btnGestione = new JButton("Gestione");
		btnGestione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FinestraGestione fg = new FinestraGestione();
				fg.setVisible(true);
				frmCoupon.dispose();
			}
		});
		btnGestione.setBounds(331, 0, 103, 23);
		frmCoupon.getContentPane().add(btnGestione);
		
		
	}
}
