package simple_client_server_app.log;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyLog {
    private static String LOG_FILE = "D:\\java\\Java_Core\\JavaJunior\\src\\main\\java\\simple_client_server_app\\log\\log.txt";

    public static void write(String tetLog) {
        String content = "Hello, world!";
        Path path = Paths.get(LOG_FILE);
        try (FileWriter fileWriter = new FileWriter(LOG_FILE, true)) {
            fileWriter.write(tetLog);
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



