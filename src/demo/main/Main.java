package demo.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String args[]) {
		Path path = Paths.get("/Users/bju/Documents/rawdata.txt");
		Path outputPath = Paths.get("/Users/bju/Documents/output.txt");
		Charset charset = StandardCharsets.UTF_8;

		String content;
		try {
			content = new String(Files.readAllBytes(path), charset);

			String contentUp = content.substring(0, content.indexOf("*TS01"));
			String contentDown = reverseString(
					reverseString(content).substring(0, reverseString(content).indexOf("#")));

			content = content.replace(contentUp, "");
			content = content.replace(contentDown, "");

			content = content.replaceAll("#", "#\n");
			content = content.replaceAll("\\#\n(.*?)\\*", "#\n*");

			Files.write(outputPath, content.getBytes(charset));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String reverseString(String s) {
		return (new StringBuffer(s)).reverse().toString();
	}

}
