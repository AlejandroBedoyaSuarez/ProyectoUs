package GUI;

import javax.swing.*;
import java.awt.*;

public class RegistroProductoGUI extends JFrame {
    public RegistroProductoGUI(JFrame parent) {
        setTitle("Registrar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5, 2, 10, 10));
        setResizable(false);

        // Componentes del formulario
        JLabel lblNombreProducto = new JLabel("Nombre Producto:");
        JTextField txtNombreProducto = new JTextField();
        JLabel lblCodigo = new JLabel("Código:");
        JTextField txtCodigo = new JTextField();
        JLabel lblCantidad = new JLabel("Cantidad:");
        JTextField txtCantidad = new JTextField();
        JLabel lblStock = new JLabel("Stock:");
        JTextField txtStock = new JTextField();

        JButton btnSalir = new JButton("Salir");

        // Acción del botón "Salir"
        btnSalir.addActionListener(e -> dispose());

        // Añadir componentes al formulario
        add(lblNombreProducto);
        add(txtNombreProducto);
        add(lblCodigo);
        add(txtCodigo);
        add(lblCantidad);
        add(txtCantidad);
        add(lblStock);
        add(txtStock);
        add(new JLabel()); // Espacio vacío
        add(btnSalir);

        setVisible(true);
    }
}