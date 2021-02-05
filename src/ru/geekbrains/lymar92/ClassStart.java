package ru.geekbrains.lymar92;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ClassStart {
       private static int before = 0;
       private static int after = 0;
       private static Map<Integer, ArrayList<Method>> mapMethod = new HashMap<>();

    public static void start(Class<?> testClass) {
        Method[] method = testClass.getDeclaredMethods();
        if (method != null) {
            for (int i = 0; i < method.length; i++) {
                if (method[i].getAnnotation(BeforeSuite.class) != null) {
                    before++;
                    if (before != 1) {
                        throw new RuntimeException("В классе " + testClass.getName() + " не может быть больше одного метода с анотацией @BeforeSuite");
                    }
                    BeforeSuite annotation = method[i].getAnnotation(BeforeSuite.class);
                    sort(annotation.value(), method[i]);
                }
                if (method[i].getAnnotation(AfterSuite.class) != null) {
                    after++;
                    if (after != 1) {
                        throw new RuntimeException("В классе " + testClass.getName() + " не может быть больше одного метода с анотацией @BAfterSuite");
                    }
                    AfterSuite annotation = method[i].getAnnotation(AfterSuite.class);
                    sort(annotation.value(), method[i]);
                }

                if (method[i].getAnnotation(Test.class) != null) {
                    Test annotation = method[i].getAnnotation(Test.class);
                    sort(annotation.value(), method[i]);
                }

            }
            System.out.println("Тестирование класса: " + testClass.getName());
            printResult(mapMethod, testClass);
        }
        else System.out.println("В классе " + testClass.getName() + " нет методов");
    }

    private static void sort(int priority, Method method) {
        if (!mapMethod.containsKey(priority)) {
            mapMethod.put(priority, new ArrayList<>(Arrays.asList(method)));
        } else {
            ArrayList<Method> list = mapMethod.get(priority);
            list.add(method);
        }
    }

    private static void printResult(Map map, Class<?> classTest) {

        for (Integer key : mapMethod.keySet()) {
            ArrayList<Method> list = mapMethod.get(key);
            printResult(list, classTest);
        }
    }

    private static void printResult(ArrayList<Method> list, Class<?> classTest) {
        try {
            Object testCase = classTest.newInstance();
            for(Method method : list) {
                System.out.print(method.getName() + ": ");
                method.invoke(testCase);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
