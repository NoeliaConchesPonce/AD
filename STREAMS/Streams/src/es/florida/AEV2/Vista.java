package es.florida.AEV2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Vista {

	private JFrame frame;
	private JTextField textField_Buscar;
	private JTextField textField_Reemplazar;
	private JButton btnBuscar;
	private JButton btnReemplazar;
	private JTextArea textArea_Original;
	private JTextArea textArea_Modificado;

	/*Métode: Vista
	 * Descripció: inicialitza la clase vista
	 * Paràmetres d'entrada: no
	 * Paràmetres d'eixida: interficie gràfica
	 * */
	public Vista() {
		initialize();
	}
	
	/*Métode: initialize
	 * Descripció: executa tots els objectes de la interficie
	 * Paràmetres d'entrada: no
	 * Paràmetres d'eixida: no
	 * */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_Original = new JScrollPane();
		scrollPane_Original.setBounds(22, 20, 743, 222);
		frame.getContentPane().add(scrollPane_Original);
		
		textArea_Original = new JTextArea();
		textArea_Original.setLineWrap(true);
		textArea_Original.setRows(12);
		scrollPane_Original.setColumnHeaderView(textArea_Original);
		scrollPane_Original.getViewport().setView(textArea_Original);
		
		textField_Buscar = new JTextField();
		textField_Buscar.setBounds(32, 252, 177, 27);
		frame.getContentPane().add(textField_Buscar);
		textField_Buscar.setColumns(10);
		
		textField_Reemplazar = new JTextField();
		textField_Reemplazar.setColumns(10);
		textField_Reemplazar.setBounds(421, 252, 177, 27);
		frame.getContentPane().add(textField_Reemplazar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscar.setBounds(219, 252, 120, 27);
		frame.getContentPane().add(btnBuscar);
		
		btnReemplazar = new JButton("Reemplazar");
		btnReemplazar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReemplazar.setBounds(608, 252, 120, 27);
		frame.getContentPane().add(btnReemplazar);
		
		JScrollPane scrollPane_Modificado = new JScrollPane();
		scrollPane_Modificado.setBounds(22, 300, 743, 222);
		frame.getContentPane().add(scrollPane_Modificado);
		
		textArea_Modificado = new JTextArea();
		textArea_Modificado.setLineWrap(true);
		textArea_Modificado.setRows(12);
		scrollPane_Modificado.setColumnHeaderView(textArea_Modificado);
		scrollPane_Modificado.getViewport().setView(textArea_Modificado);
		
		this.frame.setVisible(true);
	}
	/*Métode: getBtnBuscar
	 * Descripció: mostra el objecte btnBuscar
	 * Paràmetres d'entrada: no
	 * Paràmetres d'eixida: btnBuscar
	 * */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	/*Métode: getBtnReemplazar
	 * Descripció: mostra el objecte btnReemplazar
	 * Paràmetres d'entrada: no
	 * Paràmetres d'eixida: btnReemplazar
	 * */
	public JButton getBtnReemplazar() {
		return btnReemplazar;
	}
	/*Métode: getTextFieldBuscar
	 * Descripció: mostra el objecte textfield
	 * Paràmetres d'entrada: no
	 * Paràmetres d'eixida: textField_Buscar
	 * */
	public JTextField getTextFieldBuscar() {
		return textField_Buscar;
	}
	/*Métode: getTextFieldReemplazar
	 * Descripció: mostra el objecte textField
	 * Paràmetres d'entrada: no
	 * Paràmetres d'eixida: textField_Reemplazar
	 * */
	public JTextField getTextFieldReemplazar() {
		return textField_Reemplazar;
	}
	/*Métode: getTextAreaOriginal
	 * Descripció: mostra el objecte textArea_original
	 * Paràmetres d'entrada: no
	 * Paràmetres d'eixida: textArea_Original
	 * */
	public JTextArea getTextAreaOriginal() {
		return textArea_Original;
	}
	/*Métode: getTextAreaModificado
	 * Descripció: mostra el objecte textArea_Modificado
	 * Paràmetres d'entrada: no
	 * Paràmetres d'eixida: textArea_Modificado
	 * */
	public JTextArea getTextAreaModificado() {
		return textArea_Modificado;
	}
	/*Métode: mensajeBuscarPalabra
	 * Descripció: mostra el missatge que apareix cuan polses el btnBuscar
	 * Paràmetres d'entrada: String mensaje
	 * Paràmetres d'eixida: no
	 * */
	public void  mensajeBucarPalabra(String mensaje) {
		JOptionPane.showMessageDialog(new JFrame(), mensaje, "INFO", JOptionPane.INFORMATION_MESSAGE);

	}

}

