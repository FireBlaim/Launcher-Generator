package fr.fireblaim.launcher_generator.launcher.file;

import fr.fireblaim.launcher_generator.App;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    private App app;

    public FileManager() {
        this.app = App.getInstance();
    }

    public void createFolder(String path, String folderName) throws IOException {
        Path folderPath = Paths.get(path + "/" + folderName);
        Files.createDirectories(folderPath);
    }

}
