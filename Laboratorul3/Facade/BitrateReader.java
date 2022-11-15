package Facade;

public class BitrateReader {
    public static TvVideoFile read(TvVideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static TvVideoFile convert(TvVideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}
