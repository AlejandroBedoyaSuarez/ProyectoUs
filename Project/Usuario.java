package Project;

import java.util.regex.Pattern;

public class Usuario {
    private String nombre;
    private String email;
    private String telefono;

    // Constructor
    public Usuario(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // Métodos de validación
    public static boolean esEmailValido(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    public static boolean esTelefonoValido(String telefono) {
        return telefono.matches("\\d+");  // Solo números
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEmail: " + email + "\nTeléfono: " + telefono;
    }
}