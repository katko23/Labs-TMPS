package Facade;

public class TvVideoFile {
    private String name;
    private String codecType;

    public TvVideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }

    public String getCodecType() {
        return codecType;
    }

    public String getName() {
        return name;
    }
}
