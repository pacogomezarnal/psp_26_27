import java.io.BufferedReader;
import java.io.InputStreamReader;

public static void main(String[] args) {
    try {
        // Ejecuta un comando en la terminal y muestra la salida
        // cmd.exe /c dir ejecuta el comando dir en Windows
        Process process = new ProcessBuilder("cmd.exe", "/c", "dir").start();
        // Para el caso de Linux o macOS, puedes usar
        // val process = ProcessBuilder("ls").start()
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        reader.lines().forEach(System.out::println);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
