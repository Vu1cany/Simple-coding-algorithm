import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidParameterException;

public class Main {
    public static void main(String[] args) {
        try {
            String fileInputPath = args[1];
            String fileOutputPath = args[2];
            int key = 12345;

            try (FileInputStream fileInputStream = new FileInputStream(fileInputPath);
                 FileOutputStream fileOutputStream = new FileOutputStream(fileOutputPath)){

                switch (args[0]){
                    case "-e":
                    case "-d":

                        while (fileInputStream.available() > 0){
                            int inputByte = fileInputStream.read();
                            int outpurByte = inputByte ^ key;
                            fileOutputStream.write(outpurByte);
                        }

                        break;
                    default:
                        throw new InvalidParameterException("Введен неверный ключ");
                }
            }
        } catch (IndexOutOfBoundsException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}