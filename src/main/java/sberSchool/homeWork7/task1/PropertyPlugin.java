package sberSchool.homeWork7.task1;

import java.util.List;

public class PropertyPlugin {
    private String path;
    private List<String> pluginsName;
    private String entryPoint;
    private List<String> pluginsClassName;


    public PropertyPlugin(String path, List pluginsName, String entryPoint, List pluginsClassName) {
        this.path = path;
        this.pluginsName = pluginsName;
        this.entryPoint = entryPoint;
        this.pluginsClassName = pluginsClassName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List getPluginsName() {
        return pluginsName;
    }

    public void setPluginsName(List pluginsName) {
        this.pluginsName = pluginsName;
    }

    public String getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(String entryPoint) {
        this.entryPoint = entryPoint;
    }

    public List<String> getPluginsClassName() {
        return pluginsClassName;
    }

    public void setPluginsClassName(List<String> pluginsClassName) {
        this.pluginsClassName = pluginsClassName;
    }

    @Override
    public String toString() {
        return "PropertyPlugin{" +
                "path='" + path +
                ",\n pluginsName=" + pluginsName +
                ",\n entryPoint='" + entryPoint +
                ",\n pluginsClassName=" + pluginsClassName +
                '}';
    }
}
