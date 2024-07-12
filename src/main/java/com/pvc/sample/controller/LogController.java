package com.pvc.sample.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
	
	private static final String LOG_FILE_PATH = "/app/logs/app.log";
	
	@GetMapping("/")
	public String index() {
		
		return "<html>"
				+ "<body>"
				+ "<h1><center>Hello human!</center></h1>"
				+ "</body>"
				+ "</html>";
	}
	
    @GetMapping("/log")
    public String logMessage() {
        String logMessage = "Log entry at " + LocalDateTime.now() + "\n";
        try (FileWriter writer = new FileWriter(LOG_FILE_PATH, true)) {
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error logging message";
        }
        return "Logged message: " + logMessage;
    }
}