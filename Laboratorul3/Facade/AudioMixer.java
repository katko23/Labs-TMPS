package Facade;
import java.io.File;

public class AudioMixer {
    public File fix(TvVideoFile result){
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}
