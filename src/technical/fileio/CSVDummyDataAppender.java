import java.io.*;
import java.nio.file.*;
import java.util.Random;

public class CSVDummyDataAppender {

    private Path filePath;
    private int numRows;
    private int numColumns;

    // Constructor
    public CSVDummyDataAppender(String filePath, int numRows, int numColumns) {
        this.filePath = Paths.get(filePath);
        this.numRows = numRows;
        this.numColumns = numColumns;
    }

    // 더미 데이터 생성 메서드
    private String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + random.nextInt(26));
            builder.append(c);
        }
        return builder.toString();
    }

    // CSV 파일에 더미 데이터 추가
    public void appendDummyData() throws IOException {
        long startTime = System.currentTimeMillis();
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            for (int i = 0; i < numRows; i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < numColumns; j++) {
                    row.append(generateRandomString(10));
                    if (j < numColumns - 1) {
                        row.append(",");
                    }
                }
                writer.write(row.toString());
                writer.newLine();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(numRows + " rows of dummy data added to " + filePath);
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) throws IOException {
        // CSV 파일 경로
        String csvFilePath = "/Users/developseop/Downloads/dummy_data.csv";

        // 추가할 행과 열의 수
        int rowsToAdd = 10000000;
        int columns = 5;

        // 더미 데이터 추가기
        CSVDummyDataAppender appender = new CSVDummyDataAppender(csvFilePath, rowsToAdd, columns);
        appender.appendDummyData();
    }
}
