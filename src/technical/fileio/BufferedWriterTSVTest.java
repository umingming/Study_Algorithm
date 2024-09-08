package technical.fileio;

import java.io.*;
import java.nio.file.*;

public class BufferedWriterTSVTest {
    public static void main(String[] args) throws IOException {
        Path csvFile = Paths.get("/Users/developseop/Downloads/dummy_data.csv");
        Path tsvFile8KB = Paths.get("/Users/developseop/Downloads/output_bufferedwriter_8kb.tsv");
        Path tsvFile16KB = Paths.get("/Users/developseop/Downloads/output_bufferedwriter_16kb.tsv");

        // 8KB 버퍼 테스트
        long startTime8KB = System.currentTimeMillis();
        try (BufferedWriter writer = new BufferedWriter(
                Files.newBufferedWriter(tsvFile8KB, StandardOpenOption.CREATE, StandardOpenOption.WRITE), 8192)) { // 8KB 버퍼
            Files.lines(csvFile).forEach(line -> {
                try {
                    writer.write(line.replace(",", "\t"));
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        long endTime8KB = System.currentTimeMillis();
        System.out.println("BufferedWriter with 8KB buffer: " + (endTime8KB - startTime8KB) + "ms");

        // 16KB 버퍼 테스트
        long startTime16KB = System.currentTimeMillis();
        try (BufferedWriter writer = new BufferedWriter(
                Files.newBufferedWriter(tsvFile16KB, StandardOpenOption.CREATE, StandardOpenOption.WRITE), 8192 * 10000)) { // 16KB 버퍼
            Files.lines(csvFile).forEach(line -> {
                try {
                    writer.write(line.replace(",", "\t"));
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        long endTime16KB = System.currentTimeMillis();
        System.out.println("BufferedWriter with 80MB buffer: " + (endTime16KB - startTime16KB) + "ms");
    }
}
