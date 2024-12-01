package Project;
// se usará para verificar si la dirección de correo electrónico cumple con el formato válido.
import java.util.regex.Pattern;

public class Usuario {
    private String nombre; //Almacena el nombre del usuario.
    private String email; //Almacena el e-mail del usuario.
    private String telefono; //Almacena el teléfono del usuario.

    // Constructor
    public Usuario(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // Métodos de validación
    public static boolean esEmailValido(String email) {
                            //letras, números, puntos, guiones bajos, etc + @ + extensión de 2 a 6 caracteres como la primera (com, net o algún dominio propio como ec, itq, adri, etc)
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        //Aquí se usa Pattern.matches() para comparar el correo proporcionado (email) con la regex (emailRegex). Si coincide, devuelve true; si no, false.
        return Pattern.matches(emailRegex, email);
    }

    public static boolean esTelefonoValido(String telefono) {
        //Verifica si un número de teléfono contiene solo números usando matches("\\d+").
        //\d+: Significa "una o más cifras".
        return telefono.matches("\\d+");  // Solo números
    }

    //Método
    @Override
    //Si quitamos el toString, se verá : Usuario@1a2b3c y no es un formato que se desea para el usuario
    public String toString() {
        return "Nombre: " + nombre + "\nEmail: " + email + "\nTeléfono: " + telefono;
    }
}