package pl.pk.testing.qc.module2;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Module2MainClass {

    public static void main(String[] args) {
        classesInPackage().stream()
                .map(Class::getName)
                .forEach(System.out::println);
    }

    public static void twoTwoExercise() {
        System.out.println("PK");
        System.out.println("P");
        System.out.println(34);
        System.out.println("K");
    }

    public static Object[] twoThreeExercise() {
        String someString = "text";
        Integer someInt = 5;
        Long someLong = 3L;

        Object[] variables = {someString, someInt, someLong};
        return variables;
    }

    public static void twoNineExercise() {
        Notebook notebook = new Notebook(600, 1000, 2018);
        Notebook goodNotebook = new Notebook(2000, 1500, 2019);
        System.out.println(notebook.prepareOpinion());
        System.out.println(goodNotebook.checkPrice());
    }

    public static Set<Class<?>> classesInPackage() {
        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("pl.pk.testing"))));

//        Set<Class<? extends Object>> allClasses =
//                reflections.getSubTypesOf(Object.class);

        return reflections.getSubTypesOf(Object.class);
    }
}
