package pl.pk.testing.qc.tools;

import com.google.common.reflect.ClassPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassAnalisysMain {

    private static final File TEST_DIR = new File("C:\\Users\\user\\Desktop\\Java programowanie\\testing\\src\\main\\java\\pl\\pk\\testing\\qc\\module2");

    private static final String PRIVATE_METHOD = "private";
    private static final String PROTECTED_METHOD = "protected";
    private static final String PUBLIC_METHOD = "public";
    private static final String[] charsSugestingMethod = new String[]{"{", "(", ")"};


    public static void main(String[] args) {


        File[] files = TEST_DIR.listFiles();
        HashMap<String, Long> lineInFileMap = new HashMap<>();

        for(File file: files) {

            HashMap<String, Integer> map = new HashMap<>();

            if (file.isFile() && file.getName().contains(".java")) {
                try {
                    lineInFileMap.put(file.getName(), Files
                            .lines(file.toPath())
                            .filter(line -> !line.isEmpty())
                            .count());
                } catch (IOException e) {
                    System.out.println("Can't load file: " + file.getName());
                }
                printValueFile(file);

            }
        }

        printValueMap(lineInFileMap);


    }



    private static void printValueMap(HashMap<String, Long> lines) {
        if (lines != null && lines.size() > 0) {
            for (Map.Entry<String, Long> file: lines.entrySet()) {
                System.out.println(file.getKey() + " | " + file.getValue());

            }
        }
    }

    private static void  printValueFile(File file) {


        try {
            Files.lines(file.toPath()).filter(line -> !line.isEmpty()).forEach(System.out::println);
            countAndPrintMethod(file);
        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku: " + file.getName());
        }
    }

    private static void countAndPrintMethod(File file) throws IOException {

        HashMap<String, Integer> methodMap = new HashMap<>();
        Files.lines(file.toPath()).filter(line -> !line.isEmpty())
                .filter(ClassAnalisysMain::isMethodStartLine)
                .map(line -> getWhatKindOfMethod(line))
                .forEach(method -> countMethods(methodMap, method));

        for (Map.Entry<String, Integer> method: methodMap.entrySet()) {
            System.out.println(method.getKey() + " | " + method.getValue());
        };
    }

    private static String getWhatKindOfMethod(String line) {
        if (line.contains(PRIVATE_METHOD)) return PRIVATE_METHOD;
        if (line.contains(PUBLIC_METHOD)) return PUBLIC_METHOD;
        if (line.contains(PROTECTED_METHOD)) return PROTECTED_METHOD;
        return null;
    }

    private static boolean isMethodStartLine(String line) {
        if (line != null) return false;

        boolean isMethod = false;

        return (line.contains(PRIVATE_METHOD) || line.contains(PROTECTED_METHOD) || line.contains(PUBLIC_METHOD));
    }

    private static HashMap<String, Integer> countMethods(HashMap<String, Integer> map, String method) {
        if (map.containsKey(method)) {
            map.put(method, map.get(method) + 1);
        } else {
            map.put(method, 1);
        }

        return map;
    }

}
