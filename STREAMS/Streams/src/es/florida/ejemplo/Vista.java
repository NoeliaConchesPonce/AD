package es.florida.ejemplo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista {

	private JFrame frame;
	private JButton btn1;//sirve para invocar a los metodos en el controlador*/
	private JButton btn2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vista window = new Vista();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Vista() {
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
		
		btn1 = new JButton("Boton 1");
		btn1.setBounds(151, 72, 116, 40);
		frame.getContentPane().add(btn1);
		
		btn2 = new JButton("Boton 2");
		btn2.setBounds(151, 139, 116, 40);
		frame.getContentPane().add(btn2);
		
		
		
		frame.setVisible(true);
	}
	
	public JButton getBtn1() {
		return btn1;
	}
	
	public JButton getBtn2() {
		return btn2;
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(new JFrame(), mensaje, "INFO", JOptionPane.INFORMATION_MESSAGE);
	}
}
