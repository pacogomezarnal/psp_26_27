import java.io.BufferedReader;
import java.io.InputStreamReader;

public static void main(String[] args) {
    // Linux
    ProcessBuilder processBuilder = new ProcessBuilder("ls","-");
    // ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "di");
    Process process = null;
    try {
        // Ejecuta un comando en la terminal y muestra la salida
        // cmd.exe /c dir ejecuta el comando dir en Windows
        process = processBuilder.start();
        BufferedReader stdOut  = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdErr  = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        System.out.println("------- Salida estándar -------");
        stdOut.lines().forEach(System.out::println);
        System.out.println("------- Errores -------");
        stdErr.lines().forEach(System.out::println);
    } catch (Exception e) {
        System.out.println("------- ERROR -------");
        e.printStackTrace();
    }
}
