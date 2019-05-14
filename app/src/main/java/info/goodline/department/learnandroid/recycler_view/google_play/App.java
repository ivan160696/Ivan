package info.goodline.department.learnandroid.recycler_view.google_play;

public class App {
    private String iconUrl;
    private String name;
    private int size;

    public App(String iconUrl, String name, int size) {
        this.iconUrl = iconUrl;
        this.name = name;
        this.size = size;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
