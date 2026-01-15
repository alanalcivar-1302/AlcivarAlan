import App.DesktopApp.Forms.SplashScreen;

public class App {
    // Colores para consola
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        // Mostrar Splash Screen
        new SplashScreen();

        // Login con CMDInput
        if (login()) {
            System.out.println("\nBienvenido.");
            System.out.println("Cédula: 1754918637");
            System.out.println("Nombre: Alan Alcivar");

            // ETL Process using aaEntomologo
            BusinessLogic.aaEntomologo aaEntomologo = new BusinessLogic.aaEntomologo();
            aaEntomologo.etlAntNest();
            aaEntomologo.etlAntFood();

            // Iniciar experimento con Entomólogo y HRastreadora
            startAntExperiment();
        } else {
            System.out.println("Has excedido el número máximo de intentos. Cerrando sistema.");
        }
    }

    private static boolean login() {
        int aaIntentos = 0;
        final int aaMaxIntentos = 3;

        while (aaIntentos < aaMaxIntentos) {
            // Usando CMDInput para captura de datos
            String aaUsuario = Infrastructure.Tools.CMDInput.getCaracteres("Usuario: ");
            String aaPassword = Infrastructure.Tools.CMDInput.getCaracteres("Contraseña: ");

            // Credenciales asignadas
            if ("patmic".equals(aaUsuario) && "123".equals(aaPassword)) {
                return true;
            } else {
                aaIntentos++;
                int aaRestantes = aaMaxIntentos - aaIntentos;
                System.out.println("Credenciales incorrectas. Intentos restantes: " + aaRestantes);
            }
        }
        return false;
    }

    private static void startAntExperiment() {
        System.out.println("\n--- Iniciando Experimento de Entomólogo ---");
        BusinessLogic.aaEntomologo aaEntomologo = new BusinessLogic.aaEntomologo();
        BusinessLogic.Entities.HRastreadora aaRastreadora = new BusinessLogic.Entities.HRastreadora();

        // 1. Preparar alimento
        String aaAlimento = "Insectívoro";
        aaEntomologo.preparar(aaAlimento);

        // 2. Alimentar hormiga
        // Caso Correcto
        System.out.println("Prueba 1: Alimentando con " + aaAlimento);
        aaEntomologo.alimentarAnt(aaRastreadora, aaAlimento);

        // Caso Incorrecto
        System.out.println("\nPrueba 2: Alimentando con alimento incorrecto");
        aaEntomologo.alimentarAnt(aaRastreadora, "Nectarívoros");
    }
}