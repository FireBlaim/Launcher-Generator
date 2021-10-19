package fr.fireblaim.launcher_generator;

import fr.fireblaim.launcher_generator.launcher.file.FileManager;
import fr.fireblaim.launcher_generator.ui.PanelManager;
import fr.fireblaim.launcher_generator.utils.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static String VERSION = "0.1";

    private static App instance;

    private Logger logger;

    private FileManager fileManager;
    private PanelManager panelManager;

    public App() {
        instance = this;

        logger = new Logger("[Launcher Generator]");
    }

    @Override
    public void start(Stage stage) throws Exception {
        logger.info("Starting the App !");

        fileManager = new FileManager();

        panelManager = new PanelManager(instance, stage);
        panelManager.init();
    }

    public Logger getLogger() {
        return logger;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public PanelManager getPanelManager() {
        return panelManager;
    }

    public static App getInstance() {
        return instance;
    }
}
