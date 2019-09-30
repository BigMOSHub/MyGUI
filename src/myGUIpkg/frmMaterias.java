package myGUIpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class frmMaterias {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMaterias window = new frmMaterias();
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
	public frmMaterias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JLabel lblMantenimientoDeMaterias = new JLabel("Mantenimiento de materias");
		lblMantenimientoDeMaterias.setBounds(0, 12, 338, 22);
		frame.getContentPane().add(lblMantenimientoDeMaterias);
		
		JLabel lblIdmateria = new JLabel("IdMateria");
		lblIdmateria.setBounds(12, 60, 192, 22);
		frame.getContentPane().add(lblIdmateria);
		
		JLabel lblNombremateria = new JLabel("NombreMateria");
		lblNombremateria.setBounds(12, 94, 150, 22);
		frame.getContentPane().add(lblNombremateria);
	}
}
