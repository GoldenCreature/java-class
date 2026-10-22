import  java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class ThrowsExample {
    static String readName() throws IOException{
        return Files.readString(Path.of("equpment.txt"));
    }

    public static void main(String[] args) {
        try{
            System.out.println(readName());
        } catch(IOException e){
            System.out.println("파일을 읽지 못했습니다.");
        }
    }
}
