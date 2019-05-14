package info.goodline.department.learnandroid.recycler_view.google_play;

import java.util.List;

public class Category {
    private String name;
    private List<App> apps;

    public Category(String name, List<App> apps) {
        this.name = name;
        this.apps = apps;
    }

    public String getName() {
        return name;
    }

    public List<App> getApps() {
        return apps;
    }
}
