package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainGUI extends JFrame {
    private JTextArea areaRegistros;  // Área de texto para mostrar registros
    private ArrayList<String> registros = new ArrayList<>();  // Lista para almacenar los registros

    public MainGUI() {
        // Configuración de la ventana principal
        setTitle("WOF-Shop");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Barra de Menú
        crearBarraDeMenu();

        // Panel Central
        JPanel panelCentral = crearPanelCentral();
        add(panelCentral, BorderLayout.CENTER);

        // Mostrar la ventana
        setVisible(true);
    }

    private void crearBarraDeMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Intro");

        // Submenú Creadores
        JMenu subMenuCreadores = new JMenu("Creadores");

        // Creadores
        JMenuItem creador1 = new JMenuItem("Creador 1");
        creador1.addActionListener(e -> mostrarInformacionCreador("Este usuario fue el creador de la GUI: Alejandro Bedoya"));

        JMenuItem creador2 = new JMenuItem("Creador 2");
        creador2.addActionListener(e -> mostrarInformacionCreador("Este fue el creador de las clases principales: Martín Rodriguez"));

        JMenuItem creador3 = new JMenuItem("Creador 3");
        creador3.addActionListener(e -> mostrarInformacionCreador("Este fue el creador de la interfaz de usuario: Alan Velasco"));

        JMenuItem creador4 = new JMenuItem("Creador 4");
        creador4.addActionListener(e -> mostrarInformacionCreador("Este fue el creador que organizó el diseño: Maiccol Zurita"));

        // Añadir los creadores al submenú
        subMenuCreadores.add(creador1);
        subMenuCreadores.add(creador2);
        subMenuCreadores.add(creador3);
        subMenuCreadores.add(creador4);

        // Añadir el submenú a Archivo
        menuArchivo.add(subMenuCreadores);

        // Opción Salir (Ahora al final)
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(e -> System.exit(0)); // Acción: Cerrar programa
        menuArchivo.add(itemSalir);

        // Menú Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
        itemAcercaDe.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "WofStore\nVersión Beta\nDesarrollado por Alejandro Bedoya",
                "Acerca de",
                JOptionPane.INFORMATION_MESSAGE));
        menuAyuda.add(itemAcercaDe);

        // Añadir menús a la barra
        menuBar.add(menuArchivo);
        menuBar.add(menuAyuda);

        // Establecer la barra de menú
        setJMenuBar(menuBar);
    }

    private JPanel crearPanelCentral() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Cambiado a BoxLayout para organizar verticalmente

        // Título de bienvenida (centrado)
        JLabel lblTitulo = new JLabel("Bienvenido a WofStore");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));  // Cambiar tamaño a 16
        lblTitulo.setForeground(Color.RED);  // Cambiar color a rojo
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrado

        // Panel para la introducción (alineado a la izquierda)
        JPanel panelIntroduccion = new JPanel();
        panelIntroduccion.setLayout(new FlowLayout(FlowLayout.LEFT)); // Usamos FlowLayout con alineación a la izquierda

        // Introducción (alineado a la izquierda)
        JLabel lblIntroduccion1 = new JLabel("Bienvenido al sistema de registro de la tienda WofStore, aquí podrás registrar al usuario y");
        lblIntroduccion1.setFont(new Font("Arial", Font.PLAIN, 13));  // Cambiar tamaño a 13
        lblIntroduccion1.setForeground(Color.BLACK);  // Cambiar color a negro

        JLabel lblIntroduccion2 = new JLabel("el producto de lo que necesites.");
        lblIntroduccion2.setFont(new Font("Arial", Font.PLAIN, 13));  // Cambiar tamaño a 13
        lblIntroduccion2.setForeground(Color.BLACK);  // Cambiar color a negro

        // Añadir los labels al panel de la introducción
        panelIntroduccion.add(lblIntroduccion1);
        panelIntroduccion.add(lblIntroduccion2);

        // Botones (más arriba de la mitad)
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnRegistroUsuario = new JButton("Registrar Usuario");
        JButton btnRegistrarProducto = new JButton("Registrar Producto");

        // Acción del botón "Registro Usuario"
        btnRegistroUsuario.addActionListener(e -> abrirRegistroUsuario());

        // Acción del botón "Registrar Producto"
        btnRegistrarProducto.addActionListener(e -> abrirRegistroProducto());

        panelBotones.add(btnRegistroUsuario);
        panelBotones.add(btnRegistrarProducto);

        // Área de texto para mostrar los registros
        areaRegistros = new JTextArea(5, 30);
        areaRegistros.setEditable(false);  // Hacer el área de texto no editable
        areaRegistros.setFont(new Font("Arial", Font.PLAIN, 12)); // Establecer la fuente

        JScrollPane scrollPane = new JScrollPane(areaRegistros);  // Añadir el área de texto a un JScrollPane para el desplazamiento

        // Añadir los componentes al panel principal
        panel.add(lblTitulo);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre título y la introducción
        panel.add(panelIntroduccion); // Añadir el panel de introducción
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre la introducción y los botones
        panel.add(panelBotones);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre los botones y el área de registros
        panel.add(scrollPane);  // Añadir el área de registros al panel

        return panel;
    }

    // Método para actualizar el área de registros
    public void agregarRegistro(String registro) {
        registros.add(registro); // Añadir el registro a la lista
        areaRegistros.setText("");  // Limpiar el área de texto
        for (String r : registros) {
            areaRegistros.append(r + "\n");  // Mostrar todos los registros en el área de texto
        }
    }

    // Método para abrir la ventana de Registro Usuario
    private void abrirRegistroUsuario() {
        new RegistroUsuarioGUI(this);  // Pasar la referencia de MainGUI a RegistroUsuarioGUI
    }

    // Método para abrir la ventana de Registro Producto
    private void abrirRegistroProducto() {
        new RegistroProductoGUI(this);  // Pasar la referencia de MainGUI a RegistroProductoGUI
    }

    private void mostrarInformacionCreador(String mensaje) {
        JFrame ventanaCreador = new JFrame("Información del Creador");
        ventanaCreador.setSize(400, 200);
        ventanaCreador.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventanaCreador.setLocationRelativeTo(this);

        JLabel lblMensaje = new JLabel("<html><center>" + mensaje + "</center></html>", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Arial", Font.PLAIN, 16));

        ventanaCreador.add(lblMensaje);
        ventanaCreador.setVisible(true);
    }

    public static void main(String[] args) {
        // Aplicar LookAndFeel moderno
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear la GUI principal
        SwingUtilities.invokeLater(() -> new MainGUI());  // Llamada correcta al constructor
    }
}