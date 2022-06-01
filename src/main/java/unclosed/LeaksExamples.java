package unclosed;


import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeaksExamples {

    public static @NotNull List<int[]> getListOfIntsCorrect() {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var firstArray = new int[n];
        for (var i = 0; i < n; ++i) firstArray[i] = scanner.nextInt();
        for (var i = 0; i < n / 2; ++i) firstArray[i] *= firstArray[n - 1 - i];
        var secondArray = new int[n];
        for (var i = 0; i < n; ++i) secondArray[i] = scanner.nextInt() + firstArray[n - 1 - i] / 5;
        //scanner.close();
        var sumOfTwoArrays = new int[n];
        for (var i = 0; i < n; ++i) sumOfTwoArrays[i] = firstArray[i] + secondArray[n - 1 - i];
        var list = new ArrayList<int[]>();
        list.add(firstArray);
        list.add(secondArray);
        list.add(sumOfTwoArrays);
        return list;
    }

    private void readTheFile(String fileName, Charset charset) throws IOException {
        Path path = Paths.get(fileName);
        BufferedReader reader = Files.newBufferedReader(path, charset);
        // some actions
        reader.close();
        // some actions
        Files.lines(Path.of("input.txt")).forEach(System.out::println);
    }

    public void process1() throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("out.txt", true)));
        out.println("the text");
        out.close();
    }
}