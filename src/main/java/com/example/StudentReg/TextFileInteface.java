package com.example.StudentReg;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface TextFileInteface {

        public default void createEmptyFile(String filename) {
            try {
                File file = new File(filename);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public default void createFileWithContent(String filename, List<String> content) {
            try {
                FileWriter writer = new FileWriter(filename);
                for (String line : content) {
                    writer.write(line + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public default List<String> readFile(String filename) {
            List<String> lines = new ArrayList<>();
            String line;

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла: " + e.getMessage());
                return lines;
            }
            return lines;
        }


        public default void updateLine(String filename, int lineIndex, String newLine) {
            List<String> lines = readFile(filename);
            if (lineIndex >= 0 && lineIndex < lines.size()) {
                lines.set(lineIndex, newLine);
                createFileWithContent(filename, lines);
            } else {
                System.out.println("Invalid line index");
            }
        }

        public default void deleteLine(String filename, int lineIndex) {
            List<String> lines = readFile(filename);
            if (lineIndex >= 0 && lineIndex < lines.size()) {
                lines.remove(lineIndex);
                createFileWithContent(filename, lines);
            } else {
                System.out.println("Invalid line index");
            }
        }

        public default void deleteFile(String filename) {
            File file = new File(filename);
            file.delete();
        }

        public default void appendLine(String filename, String line) {
            try {
                FileWriter writer = new FileWriter(filename, true);
                writer.write(line + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public default List<String> getLinesContainingSubstring(String filename, String substring) {
            List<String> result = new ArrayList<>();
            List<String> lines = readFile(filename);

            for (String line : lines) {
                if (line.contains(substring)) {
                    result.add(line);
                }
            }

            return result;
        }

    }


