package paquete1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;


import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MiConversor1 {

	private JFrame frame;
	private JTextField text;
	private JButton btn;
	private JComboBox cmb;
	private JLabel lbl;
	
	public enum Moneda{
		soles_dolar,
		soles_eur,
		soles_libra,
		soles_yen,
		soles_won,
		dolar_soles,
		eur_soles,
		libra_soles,
		yen_soles,
		won_soles,
		ºCen_ºFar,
		ºFar_ºCen
		
	}
	
	public double dolar   = 3.65;
	public double eur     = 4.03;
	public double libra   = 4.68;
	public double yen     = 0.03;
	public double won     = 0.01;
	public double gcen    = 1.8;
	public double constc  = 32.0;
	
	public double valorInput = 0.00;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiConversor1 window = new MiConversor1();
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
	public MiConversor1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		text = new JTextField();
		text.setBackground(new Color(0, 255, 255));
		text.setFont(new Font("Tahoma", Font.BOLD, 12));
		text.setBounds(30, 31, 115, 19);
		frame.getContentPane().add(text);
		text.setColumns(10);
		
	
		cmb = new JComboBox<Moneda>();
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setFont(new Font("Times New Roman Uni", Font.PLAIN, 12));
		cmb.setBounds(30, 83, 115, 19);
		frame.getContentPane().add(cmb);
		
		
		
		// evento boton
		btn = new JButton("Convertir");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn.setBounds(195, 82, 139, 21);
		frame.getContentPane().add(btn);
		
		lbl = new JLabel("00.00");
		lbl.setForeground(new Color(0, 0, 0));
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(195, 34, 139, 19);
		frame.getContentPane().add(lbl);
	}
	public void Convertir() {
		if(Validar(text.getText())) {
			
			Moneda moneda = (Moneda) cmb.getSelectedItem();
			
			switch (moneda) {
			case soles_dolar: 
				SolesAMoneda(dolar);
				break;
			case soles_eur: 
				SolesAMoneda(eur);
				break;
			case soles_libra: 
				SolesAMoneda(libra);
				break;
			case soles_yen: 
				SolesAMoneda(yen);
				break;
			case soles_won: 
				SolesAMoneda(won);
				break;
			case dolar_soles: 
				MonedaASoles(dolar);
				break;
			case eur_soles: 
				MonedaASoles(eur);
				break;
			case libra_soles: 
				MonedaASoles(libra);
				break;
			case yen_soles: 
				MonedaASoles(yen);
				break;
			case won_soles: 
				MonedaASoles(won);
				break;
			case ºCen_ºFar:
				GradoCAGradoF(gcen);
				break;
			case ºFar_ºCen:
				GradoFAGradoC(gcen);
				break;
							
			default:
				throw new IllegalArgumentException("Unexpect value: "+ moneda);
			
		}

		}
			
	}
	
	public void SolesAMoneda(double moneda) {
		double res  = valorInput / moneda;
		lbl.setText(Redondear(res));
	}
	public void MonedaASoles(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(Redondear(res));
	}
	public void GradoCAGradoF(double moneda) {
		double res1 = valorInput * moneda;
		double res = res1 + constc;
		lbl.setText(Redondear(res));
	}
	public void GradoFAGradoC(double moneda) {
		double res1 = valorInput - constc;
		double res = res1 / moneda;
		lbl.setText(Redondear(res));
	}
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if(x > 0);
			valorInput = x;
			return true;
		}catch(NumberFormatException e) {
			lbl.setText("Solamente Números !!");
			return false;
		}
	}
	                                                                                	
}
	
	
	
	
	
	

