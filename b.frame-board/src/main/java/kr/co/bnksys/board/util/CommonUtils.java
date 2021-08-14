package kr.co.bnksys.board.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtils {

	public static String getCurrentTimestamp() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
	}
	
}
