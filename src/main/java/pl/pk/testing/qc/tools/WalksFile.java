package pl.pk.testing.qc.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WalksFile {

    public static void main(String[] args) throws IOException {
        Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\user\\Desktop\\Java programowanie\\3Labs-Script-application\\src"));
        List<File> result = walk.filter(Files::isRegularFile)
                //.filter(p -> p.endsWith(".java"))
                //.map(p -> p.toFile().getName())
                .filter(p -> p.toFile().getName().contains(".java"))
                .map(Path::toFile)
                .collect(Collectors.toList());

        Long counterLine = 0L;

        for (File file: result) {
            counterLine = counterLine + Files.lines(file.toPath()).filter(line -> !line.isEmpty()).count();
        }

        System.out.println("Liczba kodu w projekcie: " + counterLine);
    }

}
