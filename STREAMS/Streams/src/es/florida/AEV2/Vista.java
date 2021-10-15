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

	/*M�tode: Vista
	 * Descripci�: inicialitza la clase vista
	 * Par�metres d'entrada: no
	 * Par�metres d'eixida: interficie gr�fica
	 * */
	public Vista() {
		initialize();
	}
	
	/*M�tode: initialize
	 * Descripci�: executa tots els objectes de la interficie
	 * Par�metres d'entrada: no
	 * Par�metres d'eixida: no
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
	/*M�tode: getBtnBuscar
	 * Descripci�: mostra el objecte btnBuscar
	 * Par�metres d'entrada: no
	 * Par�metres d'eixida: btnBuscar
	 * */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	/*M�tode: getBtnReemplazar
	 * Descripci�: mostra el objecte btnReemplazar
	 * Par�metres d'entrada: no
	 * Par�metres d'eixida: btnReemplazar
	 * */
	public JButton getBtnReemplazar() {
		return btnReemplazar;
	}
	/*M�tode: getTextFieldBuscar
	 * Descripci�: mostra el objecte textfield
	 * Par�metres d'entrada: no
	 * Par�metres d'eixida: textField_Buscar
	 * */
	public JTextField getTextFieldBuscar() {
		return textField_Buscar;
	}
	/*M�tode: getTextFieldReemplazar
	 * Descripci�: mostra el objecte textField
	 * Par�metres d'entrada: no
	 * Par�metres d'eixida: textField_Reemplazar
	 * */
	public JTextField getTextFieldReemplazar() {
		return textField_Reemplazar;
	}
	/*M�tode: getTextAreaOriginal
	 * Descripci�: mostra el objecte textArea_original
	 * Par�metres d'entrada: no
	 * Par�metres d'eixida: textArea_Original
	 * */
	public JTextArea getTextAreaOriginal() {
		return textArea_Original;
	}
	/*M�tode: getTextAreaModificado
	 * Descripci�: mostra el objecte textArea_Modificado
	 * Par�metres d'entrada: no
	 * Par�metres d'eixida: textArea_Modificado
	 * */
	public JTextArea getTextAreaModificado() {
		return textArea_Modificado;
	}
	/*M�tode: mensajeBuscarPalabra
	 * Descripci�: mostra el missatge que apareix cuan polses el btnBuscar
	 * Par�metres d'entrada: String mensaje
	 * Par�metres d'eixida: no
	 * */
	public void  mensajeBucarPalabra(String mensaje) {
		JOptionPane.showMessageDialog(new JFrame(), mensaje, "INFO", JOptionPane.INFORMATION_MESSAGE);

	}

}

