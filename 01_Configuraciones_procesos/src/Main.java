//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //Captura del directorio del usuario logado
    String userHome = System.getProperty("user.home");
    String userDir = System.getProperty("user.dir");
    System.out.println("Directorio del usuario logado: " + userHome);
    System.out.println("Directorio de trabajo: " + userDir);
    try {
        // Ejecuta listado de archivos en la terminal y muestra la salida
        // en el directorio de usuario logado
        //ProcessBuilder processBuilder = new ProcessBuilder("ls","-l");
        //Windows
        ProcessBuilder processBuilder  = new ProcessBuilder("cmd.exe", "/c", "dir");
        processBuilder.directory(new java.io.File(userHome));
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        reader.lines().forEach(System.out::println);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
