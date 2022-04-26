package sberSchool.homeWork5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {

    public static void assign(Object to, Object from) {
        Class<?> classFrom = from.getClass();
        Map<String, Method> gettersFrom = getters(classFrom);
        Class<?> classTo = to.getClass();
        Map<String, Method> settersTo = setters(classTo);

        for (String keyGet : gettersFrom.keySet()) {
            if (settersTo.containsKey(keyGet)) {

                Method methodGetFrom = gettersFrom.get(keyGet);
                Method methodSetTo = settersTo.get(keyGet);
                if (methodGetFrom.getReturnType().isAssignableFrom(methodSetTo.getParameterTypes()[0])) {
                    try {
                        Object valueGetFrom = methodGetFrom.invoke(from);
                        methodSetTo.invoke(to, valueGetFrom);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static Map<String, Method> getters(Class clazz) {
        Map<String, Method> rezult = new HashMap<>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") &&
                    method.getParameterTypes().length == 0 &&
                    !void.class.equals(method.getReturnType())) {
                rezult.put(method.getName().replace("get", ""), method);
            }
        }
        return rezult;
    }

    private static Map<String, Method> setters(Class clazz) {
        Map<String, Method> rezult = new HashMap<>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set") &&
                    method.getParameterTypes().length == 1) {
                rezult.put(method.getName().replace("set", ""), method);
            }
        }
        return rezult;
    }
}
