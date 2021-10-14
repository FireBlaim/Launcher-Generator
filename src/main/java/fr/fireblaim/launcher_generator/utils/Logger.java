package fr.fireblaim.launcher_generator.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private String prefix;

    public Logger(String prefix) {
        this.prefix = prefix + " ";
    }

    public void info(String message) {
        System.out.println("\u001B[0m" + String.format("[%s] ", new SimpleDateFormat("hh:mm:ss").format(new Date())) + prefix + "[INFO] " + message);
    }

    public void err(String message) {
        System.out.println("\u001B[31m" + String.format("[%s] ", new SimpleDateFormat("hh:mm:ss").format(new Date())) + prefix + "[ERROR] " + message + "\u001B[0m");
    }

    public void warn(String message) {
        System.out.println("\u001B[33m" + String.format("[%s] ", new SimpleDateFormat("hh:mm:ss").format(new Date())) + prefix + "[WARNING] " + message + "\u001B[0m");
    }

    public void fatal(String message) {
        System.out.println(String.format("\u001B[1m" + "\u001B[31m" + "[%s] ", new SimpleDateFormat("hh:mm:ss").format(new Date())) + prefix + "[FATAL] " + message + "\u001B[0m");
        System.exit(1);
    }

}
