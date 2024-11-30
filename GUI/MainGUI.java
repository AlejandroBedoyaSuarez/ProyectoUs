package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainGUI extends JFrame {
    private JTextArea areaRegistros; // Área de texto para mostrar registros
    private ArrayList<String> registros = new ArrayList<>(); // Lista para almacenar los registros

    // Estilos globales
    private Font fuenteTitulo = new Font("Arial", Font.BOLD, 16);
    private Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);
    private Color colorPrimario = Color.RED;

    public MainGUI() {
        // Configuración de la ventana principal
        setTitle("WOF-Shop");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setIconImage(new ImageIcon("GUI/perrito.jpeg").getImage());

        // Barra de Menú
        crearBarraDeMenu();

        // Panel Central
        JPanel panelCentral = crearPanelCentral();
        add(panelCentral, BorderLayout.CENTER);

        // Mostrar la ventana
        setVisible(true);
    }

    private JLabel crearEtiquetaTitulo(String texto, Font fuente, Color color) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(fuente);
        etiqueta.setForeground(color);
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        return etiqueta;
    }

    private JLabel crearEtiquetaTexto(String texto, Font fuente, Color color) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(fuente);
        etiqueta.setForeground(color);
        etiqueta.setAlignmentX(Component.LEFT_ALIGNMENT);
        return etiqueta;
    }

    @SuppressWarnings("unused") //Para que no salgan alertas
    
    private void crearBarraDeMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Intro");

        // Submenú Creadores
        JMenu subMenuCreadores = new JMenu("Creadores");

        // Creadores
        JMenuItem creador1 = new JMenuItem("Creador 1");
        creador1.addActionListener(
                e -> mostrarInformacionCreador("Este usuario fue el creador de la GUI: Alejandro Bedoya"));

        JMenuItem creador2 = new JMenuItem("Creador 2");
        creador2.addActionListener(
                e -> mostrarInformacionCreador("Este fue el creador de las clases principales: Martín Rodriguez"));

        JMenuItem creador3 = new JMenuItem("Creador 3");
        creador3.addActionListener(
                e -> mostrarInformacionCreador("Este fue el creador de la interfaz de usuario: Alan Velasco"));

        JMenuItem creador4 = new JMenuItem("Creador 4");
        creador4.addActionListener(
                e -> mostrarInformacionCreador("Este fue el creador que organizó el diseño: Maiccol Zurita"));

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

    @SuppressWarnings("unused") // Solo es para quitar las alertas, se ve feo

    private JPanel crearPanelCentral() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes globales

        // Título
        JLabel lblTitulo = crearEtiquetaTitulo("Bienvenido a WofStore", fuenteTitulo, colorPrimario);

        // Introducción
        JPanel panelIntroduccion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIntroduccion1 = new JLabel("Le damos la bienvenida al sistema de registro de la tienda WofStore");
        panelIntroduccion.add(lblIntroduccion1);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnRegistroUsuario = new JButton("Registrar Usuario");
        JButton btnRegistrarProducto = new JButton("Registrar Producto");

        btnRegistroUsuario.addActionListener(e -> abrirRegistroUsuario());
        btnRegistrarProducto.addActionListener(e -> abrirRegistroProducto());

        panelBotones.add(btnRegistroUsuario);
        panelBotones.add(btnRegistrarProducto);

        // Área de registros
        JLabel lblRegistros = new JLabel("Registros:");
        lblRegistros.setAlignmentX(Component.CENTER_ALIGNMENT);
        areaRegistros = new JTextArea(10, 40);
        areaRegistros.setEditable(false);
        areaRegistros.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borde
        areaRegistros.setBackground(Color.WHITE); // Fondo
        areaRegistros.setForeground(Color.DARK_GRAY); // Texto

        JScrollPane scrollPane = new JScrollPane(areaRegistros);

        // Añadir todo al panel
        panel.add(lblTitulo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(panelIntroduccion);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(panelBotones);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(lblRegistros); // Label "Registros"
        panel.add(scrollPane); // Área de registros

        return panel;
    }

    // Método para actualizar el área de registros
    public void agregarRegistro(String registro) {
        registros.add(registro); // Añadir el registro a la lista
        areaRegistros.setText(""); // Limpiar el área de texto
        for (String r : registros) {
            areaRegistros.append(r + "\n"); // Mostrar todos los registros en el área de texto
        }
    }

    // Método para abrir la ventana de Registro Usuario
    private void abrirRegistroUsuario() {
        new RegistroUsuarioGUI(this); // Pasar la referencia de MainGUI a RegistroUsuarioGUI
    }

    // Método para abrir la ventana de Registro Producto
    private void abrirRegistroProducto() {
        new RegistroProductoGUI(this); // Pasar la referencia de MainGUI a RegistroProductoGUI
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

}