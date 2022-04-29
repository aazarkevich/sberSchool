package sberSchool.homeWork7.task1;

import sberSchool.homeWork7.task1.plugins.Plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager extends ClassLoader {
    private final String pluginRootDirectory;
    private ClassLoader loader;


    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws MalformedURLException {
        File file = new File(pluginRootDirectory + "/" + pluginName);
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{file.toURL()});
        Plugin plugin = null;
        try {
            plugin = (Plugin) urlClassLoader.loadClass(pluginClassName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return plugin;
    }
}
