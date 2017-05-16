package se.kth.ict.nextgenpos.controller;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * 
 * code copy pasted from school resources
 * also implemented singleton pattern 
 * purpose of having just one log
 *
 */
public class LogHandler {
	
	/**
	 * Loghandler singleton pattern. Made private to just hand out one loghandler to everyone. Avoiding that we have multiple 
	 * loghandler active at the same time.
	 */
	
	private static LogHandler LOG_HANDLER = new LogHandler();
	private static final String LOG_FILE_NAME = "supermarketsales-log.txt";
	private PrintWriter logFile;
	
	public static LogHandler getInstance(){
		return LOG_HANDLER;
    }
	
	private LogHandler(){
		try {
			logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
		} catch (IOException e) {
			// Fatal Error
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Writes log entries.
	 *
	 * @param entry
	 *            The log entry.
	 */

	public void logException(Exception exception) {
		StringBuilder logMsgBuilder = new StringBuilder();
		logMsgBuilder.append(createTime());
		logMsgBuilder.append(", Exception was thrown: ");
		logMsgBuilder.append(exception.getMessage());
		logFile.println(logMsgBuilder);
		exception.printStackTrace(logFile);
	}

	private String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		return now.format(formatter);
	}

}
