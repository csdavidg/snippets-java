package com.example.snippets.demo.java11;

import java.io.*;

public class IOStreamsExamples {

    public static void main(String[] args) throws IOException {
        String fileName = "c:\\data_IO\\LION.txt";
        var fileInputStream = new BufferedInputStream(new FileInputStream(fileName));
        readData(fileInputStream);

        outputStreamCharacterA(fileName);

        String newFileName = "c:\\data_IO\\LION2.txt";
        copyFileWithBuffer(new File(fileName), new File(newFileName));

        String charFile = "c:\\data_IO\\LION3.txt";
        copyTextFile(new File(fileName), new File(charFile));

        String buffCharFile = "c:\\data_IO\\LION4.txt";
        copyTextFileWithBuffer(new File(fileName), new File(buffCharFile));

    }

    public static void readData(InputStream is) throws IOException {
        System.out.print((char) is.read());     // L
        if (is.markSupported()) {
            System.out.print((char) is.read());  // I
            is.mark(100);  // Marks up to 100 bytes
            System.out.print((char) is.read());  // O
            is.reset();    // Resets stream to position before I
        }
        System.out.print((char) is.read());    // I
        System.out.print((char) is.read());    // O
//        System.out.print((char) is.read());    // N
    }

    public static void outputStreamCharacterA(String fileName) throws IOException {
        try (var fos = new FileOutputStream(fileName)) {
            for (int i = 0; i < 2078; i++) {
                fos.write('a');
                if (i % 100 == 0) {
                    fos.flush();
                }
            }
        }
    }

    private static void copyFileWithBuffer(File src, File dest) throws IOException {
        try (var in = new BufferedInputStream(
                new FileInputStream(src));
             var out = new BufferedOutputStream(
                     new FileOutputStream(dest))) {
            var buffer = new byte[1024];
            int lengthRead = 0;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
    }

    private static void copyTextFile(File src, File dest) throws IOException {
        try (var reader = new FileReader(src);
             var writer = new FileWriter(dest)) {
            int b;
            while ((b = reader.read()) != -1) {
                writer.write(b);
                writer.flush();
            }
        }
    }

    private static void copyTextFileWithBuffer(File src, File dest) throws IOException {
        try (var reader = new BufferedReader(new FileReader(src));
             var writer = new BufferedWriter(new FileWriter(dest))) {
            String s;
            while ((s = reader.readLine()) != null) {
                writer.write(s);
                writer.newLine();
                writer.newLine();
            }
        }
    }


}
