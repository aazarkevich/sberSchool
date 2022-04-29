package sberSchool.homeWork7.task1;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sberSchool.homeWork7.task1.plugins.Plugin;

import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=========JSON========");
        PropertyPlugin propertyPlugin = parseJson("C:\\Users\\Артем\\IdeaProjects\\sberSchool\\src\\main\\java\\sberSchool\\homeWork7\\task1\\plugins\\plugins.json");
        System.out.println(propertyPlugin);
        System.out.println("====================");
        runPlugins(propertyPlugin);

    }

    static PropertyPlugin parseJson(String pathJson) throws Exception {
        JSONObject jsonObject = (JSONObject) readJson(pathJson);
        PropertyPlugin propertyPlugin = new PropertyPlugin(
                (String) jsonObject.get("path"),
                (List) jsonObject.get("pluginsName"),
                (String) jsonObject.get("entryPoint"),
                (List) jsonObject.get("pluginsClassName")
                );
        return propertyPlugin;
    }

    static Object readJson(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }

    static void runPlugins(PropertyPlugin propertyPlugin) throws MalformedURLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PluginManager pluginManager = new PluginManager(propertyPlugin.getPath());
        List<Plugin> plugins = new ArrayList<>();
        for (int i = 0; i < propertyPlugin.getPluginsName().size(); i++) {
             plugins.add(
                     pluginManager.load(
                             (String)propertyPlugin.getPluginsName().get(i),
                             propertyPlugin.getPluginsClassName().get(i)));

        }
        for (Plugin plugin: plugins) {
            System.out.println(plugin.getClass().getName() + ": ");
            Method declaredMethod = plugin.getClass().getDeclaredMethod(propertyPlugin.getEntryPoint());
            declaredMethod.invoke(plugin);

        }
    }
}
