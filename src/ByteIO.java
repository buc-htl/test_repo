import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteIO {


    public static void main(String[] args) {
        String inputPath = "resources/message.txt";
        String outputPath = "resources/secret.txt";
        int key = 123; // Example key for encoding

        encode(inputPath, outputPath, key,10);

        decode(outputPath, "resources/decoded_message.txt", key,10);
    }

    public static void encode(String inputPath, String outputPath, int key, int offset) {
        try {
            byte[] data = Files.readAllBytes(Path.of(inputPath));
            
            for (int i = offset; i < data.length; i++) {
                data[i] = (byte) (data[i] ^ key);
            }
            
            Files.write(Path.of(outputPath), data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void decode(String inputPath, String outputPath, int key, int offset) {
        try {
            byte[] data = Files.readAllBytes(Path.of(inputPath));

            for (int i = offset; i < data.length; i++) {
                data[i] = (byte) (data[i] ^ key);
            }

            Files.write(Path.of(outputPath), data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
