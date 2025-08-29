package Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FileLoggerConfiguration implements LoggerConfiguration {

    private final String directoryPath; //a directory with logs
    private final String filePath; //a concrete file with logs
    private final LoggingLevel level;
    private final int fileSizeLimitInBytes;

    public FileLoggerConfiguration(String directoryPath, String filePath, LoggingLevel level, int fileLimitInBytes) {
        this.directoryPath = directoryPath;
        this.filePath = filePath;
        this.level = level;
        this.fileSizeLimitInBytes = fileLimitInBytes;
    }

    @Override
    public LoggingLevel level() {
        return level;
    }

    @Override
    public String pattern() {
        Date now = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
        return "[" + dateFormatter.format(now) + "][" + "%s" + "]Message: ";
    }

    public int getFileSizeLimitInBytes() {
        return fileSizeLimitInBytes;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

}
