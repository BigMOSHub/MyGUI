package myGUIpkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmMaterias {

	private JFrame frame;
	private JTextField txtIdMateria;
	private JTextField txtNombreMateria;

	/**
	 * Launch the application.
	 */
	
	Connection conexion = null;
	PreparedStatement preparedStatement= null;
	ResultSet resultSet= null;
	
	private void limpiarCuadrosDeTexto() {
		// TODO Auto-generated method stub
	txtIdMateria.setText(null);
	txtNombreMateria.setText(null);
	
	}
			
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
		lblIdmateria.setBounds(12, 60, 118, 22);
		frame.getContentPane().add(lblIdmateria);
		
		JLabel lblNombremateria = new JLabel("NombreMateria");
		lblNombremateria.setBounds(12, 94, 150, 22);
		frame.getContentPane().add(lblNombremateria);
		
		txtIdMateria = new JTextField();
		txtIdMateria.setBounds(145, 62, 124, 19);
		frame.getContentPane().add(txtIdMateria);
		txtIdMateria.setColumns(10);
		
		txtNombreMateria = new JTextField();
		txtNombreMateria.setBounds(145, 96, 124, 19);
		frame.getContentPane().add(txtNombreMateria);
		txtNombreMateria.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(349, 57, 114, 25);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conexion = Conexion.conectar();
				try {
					preparedStatement = conexion
							.prepareStatement("Insert into materias (id_materia,nombre_materia) values (?,?)");
					preparedStatement.setString(1,txtIdMateria.getText());
					preparedStatement.setString(2,txtNombreMateria.getText());
					
					int resultado = preparedStatement.executeUpdate();
					if (resultado>0) {
						JOptionPane.showMessageDialog(null,"Registro agregado correctamente");
						limpiarCuadrosDeTexto();
						conexion.close();
						
					}else {
						JOptionPane.showMessageDialog(null,"No se pudo agregar");
					}
					
				}catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Error acceso a BD en agregar");
				}
				
			}

			
		});
		btnAgregar.setBounds(16, 191, 114, 25);
		frame.getContentPane().add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(155, 191, 114, 25);
		frame.getContentPane().add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBorrar.setBounds(296, 191, 114, 25);
		frame.getContentPane().add(btnBorrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(447, 191, 114, 25);
		frame.getContentPane().add(btnSalir);
	}
}
