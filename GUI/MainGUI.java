package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainGUI extends JFrame {
    private JTextArea areaRegistros; // Área de texto para mostrar registros
    private ArrayList<String> registros = new ArrayList<>(); // Lista para almacenar los registros

    // Estilos globales
    private Font fuenteTitulo = new Font("Tahoma", Font.BOLD, 22);
    private Font fuenteTexto = new Font("Arial", Font.PLAIN, 14);
    private Color colorPrimario = Color.RED;
    private Color colorTexto = new Color(0,0,0);

    public MainGUI() {
        // Configuración de la ventana principal
        setTitle("WOF-Shop Register");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setIconImage(new ImageIcon("GUI/img/perrito.jpeg").getImage());

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

    @SuppressWarnings("unused")
    private void crearBarraDeMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Intro");

        // Submenú Creadores con íconos
        JMenu subMenuCreadores = new JMenu("Equipo");

        JMenuItem creador1 = new JMenuItem("Creador", new ImageIcon("GUI/img/Alejologo.jpg"));
        creador1.addActionListener(
                e -> mostrarInformacionCreador("Creador Código General y Funciones: Alejandro Bedoya"));

        JMenuItem creador2 = new JMenuItem("Gerente", new ImageIcon("GUI/img/Martinlogo.jpg"));
        creador2.addActionListener(
                e -> mostrarInformacionCreador("Ayudante Clases Principales: Martín Rodriguez"));

        JMenuItem creador3 = new JMenuItem("Junior", new ImageIcon("GUI/img/Alanlogo.jpg"));
        creador3.addActionListener(
                e -> mostrarInformacionCreador("Ayudante en crear código base: Alan Velasco"));

        JMenuItem creador4 = new JMenuItem("Diseñador", new ImageIcon("GUI/img/Maiccollogo.jpg"));
        creador4.addActionListener(
                e -> mostrarInformacionCreador("Organizador de Diseño: Maiccol Zurita"));

        // Añadir los creadores al submenú con margen
        subMenuCreadores.add(creador1);
        subMenuCreadores.addSeparator(); // Margen visual
        subMenuCreadores.add(creador2);
        subMenuCreadores.addSeparator();
        subMenuCreadores.add(creador3);
        subMenuCreadores.addSeparator();
        subMenuCreadores.add(creador4);

        // Añadir el submenú a Archivo
        menuArchivo.add(subMenuCreadores);

        // Opción Salir
        JMenuItem itemSalir = new JMenuItem("Salir", new ImageIcon("GUI/img/salida.png"));
        itemSalir.addActionListener(e -> System.exit(0));
        menuArchivo.add(itemSalir);

        // Menú Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAcercaDe = new JMenuItem("Acerca de", new ImageIcon("GUI/img/ayuda.png"));
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

    @SuppressWarnings("unused")
    private JPanel crearPanelCentral() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes globales

        // Título
        JLabel lblTitulo = crearEtiquetaTitulo("Bienvenido al Registro de WofStore", fuenteTitulo, colorPrimario);

        // Introducción
        JPanel panelIntroduccion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIntroduccion1 = crearEtiquetaTexto(
                "Le damos la bienvenida al sistema de registro de la tienda WofStore", fuenteTexto, colorTexto);
        panelIntroduccion.add(lblIntroduccion1);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnRegistroUsuario = new JButton("Registrar Usuario");
        JButton btnRegistrarProducto = new JButton("Registrar Producto");

        btnRegistroUsuario.addActionListener(e -> abrirRegistroUsuario());
        btnRegistrarProducto.addActionListener(e -> abrirRegistroProducto());
        BotonGoti(btnRegistroUsuario);
        BotonGoti(btnRegistrarProducto);

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

    public void agregarRegistro(String registro) {
        registros.add(registro); // Añadir el registro a la lista
        areaRegistros.setText(""); // Limpiar el área de texto
        for (String r : registros) {
            areaRegistros.append(r + "\n"); // Mostrar todos los registros en el área de texto
        }
    }

    private void abrirRegistroUsuario() {
        new RegistroUsuarioGUI(this); // Pasar la referencia de MainGUI a RegistroUsuarioGUI
    }

    private void abrirRegistroProducto() {
        new RegistroProductoGUI(this); // Pasar la referencia de MainGUI a RegistroProductoGUI
    }

    private void mostrarInformacionCreador(String mensaje) {
        JFrame ventanaCreador = new JFrame("Información");
        ventanaCreador.setSize(400, 200);
        ventanaCreador.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventanaCreador.setLocationRelativeTo(this);

        JLabel lblMensaje = new JLabel("<html><center>" + mensaje + "</center></html>", SwingConstants.CENTER);
        lblMensaje.setFont(new Font("Roboto", Font.PLAIN, 16));

        ventanaCreador.add(lblMensaje);
        ventanaCreador.setVisible(true);
    }

    private void BotonGoti(JButton boton) {
        boton.setFocusPainted(false); // Quita el borde de enfoque
        boton.setBackground(new Color(200, 0, 0));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Roboto", Font.BOLD, 14));

        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(new Color(255, 50, 50)); // Cambia color al pasar el mouse
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(new Color(200, 0, 0)); // Restaura el color original
            }

        });

    }

}
