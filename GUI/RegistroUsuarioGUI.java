package GUI;

import javax.swing.*;
import java.awt.*;

public class RegistroUsuarioGUI extends JFrame {
    public RegistroUsuarioGUI(JFrame parent) {
        setTitle("Registrar Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5, 2, 10, 10));
        setResizable(false);

        // Componentes del formulario
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        JLabel lblTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField();
        JLabel lblCedula = new JLabel("Cédula:");
        JTextField txtCedula = new JTextField();

        JButton btnSalir = new JButton("Salir");

        // Acción del botón "Salir"
        btnSalir.addActionListener(e -> dispose());

        // Añadir componentes al formulario
        add(lblNombre);
        add(txtNombre);
        add(lblEmail);
        add(txtEmail);
        add(lblTelefono);
        add(txtTelefono);
        add(lblCedula);
        add(txtCedula);
        add(new JLabel()); // Espacio vacío
        add(btnSalir);

        setVisible(true);
    }
}