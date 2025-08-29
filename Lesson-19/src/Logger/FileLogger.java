package Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements Logger {

    private final FileLoggerConfiguration configuration;
    private final File directory;
    private File logFile;

    public FileLogger(FileLoggerConfiguration configuration) throws IOException {
        this.configuration = configuration;
        directory = verifyDirectoryExistence(configuration.getDirectoryPath());
        logFile = createNewFile(new File(configuration.getFilePath())); // create the first file
    }

    public void writeLog(String message) throws IOException {
        // Check if current logFile can hold this message
        if (!checkSize(logFile, message.getBytes(StandardCharsets.UTF_8).length)) {
            logFile = createNewFile(new File(configuration.getFilePath()));
        }

        if (configuration.level() == LoggingLevel.DEBUG) {
            debug(message);
        }
        info(message);
    }

    private File verifyDirectoryExistence(String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        return directory;
    }

    private File createNewFile(File file) throws IOException {
        File newFile = new File(fileNameGenerator(file));
        newFile.createNewFile();
        return newFile;
    }

    private String fileNameGenerator(File file) {
        String fileParent = file.getParent();
        String originalName = file.getName();
        String fileExtension = "";

        int dotIndex = originalName.lastIndexOf('.');
        if (dotIndex != -1) {
            fileExtension = originalName.substring(dotIndex);
            originalName = originalName.substring(0, dotIndex);
        }

        return fileParent +
                File.separator +
                originalName + "_Log_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS").format(new Date()) +
                fileExtension;
    }

    private boolean checkSize(File file, int messageInBytes) {
        return file.length() + messageInBytes <= configuration.getFileSizeLimitInBytes();
    }

    @Override
    public void debug(String message) {
        String log = String.format(configuration.pattern() + message + "\n", LoggingLevel.DEBUG);
        writerHelper(log.getBytes(StandardCharsets.UTF_8), new byte[1024]);
    }

    @Override
    public void info(String message) {
        String log = String.format(configuration.pattern() + message + "\n", LoggingLevel.INFO);
        writerHelper(log.getBytes(StandardCharsets.UTF_8), new byte[1024]);
    }

    private void writerHelper(byte[] logInBytes, byte[] buffer) {
        try (BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(logInBytes));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(logFile, true))) {
            int bytesRead;
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        FileLogger logger = new FileLogger(
                new FileLoggerConfiguration(
                        "/Users/nikitasemendjajevs/JavaEnterprise/JavaEnterprise/Lesson-19/LogDirectory",
                        "/Users/nikitasemendjajevs/JavaEnterprise/JavaEnterprise/Lesson-19/LogDirectory/log_test",
                        LoggingLevel.DEBUG,
                        1_000_000)
        );

        logger.writeLog("My name is Nikita!");
        logger.writeLog("I'm testing this program.");
        logger.writeLog("This is my first log message.");
        logger.writeLog("Testing log rotation with a larger message.");
        logger.writeLog("Hello from the FileLogger implementation!");
        logger.writeLog("Checking if INFO and DEBUG modes behave correctly.");
        logger.writeLog("Another line to push the file closer to its size limit.");
        logger.writeLog("Logs should create a new file once the limit is exceeded.");
        logger.writeLog("The logging system is now under stress test.");
        logger.writeLog("Creating multiple entries to see file growth.");
        logger.writeLog("Rotation should happen smoothly without errors.");
        logger.writeLog("Each message is written with UTF-8 encoding.");
        logger.writeLog("Final test entry for this run of the program.");
        logger.writeLog("Adding more logs to simulate a real application run.");
        logger.writeLog("Error handling is also important to test later.");
        logger.writeLog("File rotation count should increase consistently.");
        logger.writeLog("We expect log_test_1 to appear after the first file is full.");
        logger.writeLog("Message size impacts how quickly the file rotates.");
        logger.writeLog("Testing very short messages.");
        logger.writeLog("Testing very long messages that might fill the file faster than expected.");
        logger.writeLog("Consistency is crucial for debugging production code.");
        logger.writeLog("Developers rely on logs to trace issues.");
        logger.writeLog("Performance impact of logging should be minimal.");
        logger.writeLog("UTF-8 encoding ensures international characters work: Привет!");
        logger.writeLog("Time-based rotation can be added as a future improvement.");
        logger.writeLog("Currently, rotation is based only on file size.");
        logger.writeLog("We are logging at INFO level now.");
        logger.writeLog("Switching to DEBUG should include both INFO and DEBUG outputs.");
        logger.writeLog("This message should appear in both log levels when DEBUG is set.");
        logger.writeLog("End of the 30 test log messages.");
    }
}
