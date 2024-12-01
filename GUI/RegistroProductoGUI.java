package GUI;

import javax.swing.*;
import java.awt.*;
import Project.Producto;

public class RegistroProductoGUI extends JFrame {
    public RegistroProductoGUI(MainGUI mainGUI) {
        setTitle("Registrar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(mainGUI);
        setLayout(new GridLayout(6, 2, 10, 10));
        setResizable(false);

        // Componentes del formulario
        JLabel lblNombre = new JLabel("Nombre del Producto:");
        JTextField txtNombre = new JTextField();
        JLabel lblPrecio = new JLabel("Precio Unitario:");
        JTextField txtPrecio = new JTextField();
        JLabel lblCantidad = new JLabel("Cantidad:");
        JTextField txtCantidad = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnSalir = new JButton("Salir");

        // Acción del botón "Guardar"
        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String precioStr = txtPrecio.getText().trim();
            String cantidadStr = txtCantidad.getText().trim();

            if (nombre.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double precio = Double.parseDouble(precioStr);
                int cantidad = Integer.parseInt(cantidadStr);

                if (precio > 0 && cantidad > 0) {
                    Producto producto = new Producto(nombre, precio, cantidad);
                    mainGUI.agregarRegistro("Producto registrado:\n" + producto.getNombre() + ", Precio: $" + producto.getPrecioUnitario() + ", Cantidad: " + producto.getCantidad());
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "El precio y la cantidad deben ser mayores a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese valores válidos para el precio y la cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción del botón "Salir"
        btnSalir.addActionListener(e -> dispose());

        // Añadir componentes al formulario
        add(lblNombre);
        add(txtNombre);
        add(lblPrecio);
        add(txtPrecio);
        add(lblCantidad);
        add(txtCantidad);
        add(new JLabel()); // Espacio vacío
        add(btnGuardar);
        add(new JLabel()); // Espacio vacío
        add(btnSalir);

        setVisible(true);
    }
}