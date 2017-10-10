package com.example.designpatterns;

import java.io.Closeable;
import java.io.IOException;

/**
 * 接口隔离原则
 * @author car
 *
 */
public class CloseUtils {

	public static void close(Closeable closeable) {
		try {
			closeable.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
