// Code is life, life is code
package Infrastructure;

import java.net.URL;

public abstract class AppConfig {
    // Root Path Detection
    public static final String ROOT_PATH;
    static {
        if (new java.io.File("storage").exists()) {
            ROOT_PATH = "";
        } else if (new java.io.File("wsAntDron/storage").exists()) {
            ROOT_PATH = "wsAntDron/";
        } else {
            ROOT_PATH = ""; // Default fallback
        }
    }

    // Paths Storage
    public static final String DATABASE = "jdbc:sqlite:" + ROOT_PATH + "storage\\Databases\\antCiberDron.sqlite";
    public static final String DATAFILE = ROOT_PATH + "storage\\DataFiles\\pat_mic.csv";
    public static final String LOGFILE = ROOT_PATH + "storage\\Logs\\AppErrors.log";

    // Resources
    public static final URL URL_MAIN = AppConfig.class.getResource("Resource/logo.png");
    public static final URL URL_LOGO = AppConfig.class.getResource("Resource/logo.png");
    public static final URL URL_SPLASH = AppConfig.class.getResource("/Infrastructure/Assets/Img/Splash.png");

    // AppMSGs
    public static final String MSG_DEFAULT_ERROR = "Ups! Error inesperado. Por favor, contacte al administrador del sistema.";
    public static final String MSG_DEFAULT_CLASS = "undefined";
    public static final String MSG_DEFAULT_METHOD = "undefined";

    private AppConfig() {
    }
}
