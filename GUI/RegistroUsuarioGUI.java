package GUI;

import javax.swing.*;
import java.awt.*;
import Project.Usuario;

public class RegistroUsuarioGUI extends JFrame {
    public RegistroUsuarioGUI(MainGUI mainGUI) {
        setTitle("Registro para el Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(mainGUI);
        setLayout(new GridLayout(6, 2, 10, 10));
        setResizable(false);

        // Componentes del formulario
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        JLabel lblTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnSalir = new JButton("Salir");

        // Acción del botón "Guardar"
        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String email = txtEmail.getText().trim();
            String telefono = txtTelefono.getText().trim();

            if (nombre.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Usuario.esEmailValido(email) && Usuario.esTelefonoValido(telefono)) {
                Usuario usuario = new Usuario(nombre, email, telefono);
                mainGUI.agregarRegistroUsuario("Usuario registrado:\n" + usuario);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Datos inválidos. Verifique el correo y el teléfono.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción del botón "Salir"
        btnSalir.addActionListener(e -> dispose());

        // Añadir componentes al formulario
        add(lblNombre);
        add(txtNombre);
        add(lblEmail);
        add(txtEmail);
        add(lblTelefono);
        add(txtTelefono);
        add(new JLabel()); // Espacio vacío
        add(btnGuardar);
        add(new JLabel()); // Espacio vacío
        add(btnSalir);

        setVisible(true);
    }
}