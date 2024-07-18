package com.sbm.mc.matchingaccelerator.web.rest;

import com.sbm.mc.matchingaccelerator.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebhookController {

    @Autowired
    private MinioService minioService;

    @PostMapping("/webhook")
    public String handleWebhook(@RequestBody String eventJson) {
        try {
            System.out.printf("jeni message");
            // Extract filename from event JSON (simple extraction, adjust as needed)
            String fileName = extractFileNameFromJson(eventJson);
            minioService.processFile(fileName);
            return "Success";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    private String extractFileNameFromJson(String json) {
        // Simplistic JSON parsing to extract the filename
        // You can use a proper JSON library like Jackson or Gson
        String keyMarker = "\"key\":\"";
        int startIndex = json.indexOf(keyMarker) + keyMarker.length();
        int endIndex = json.indexOf("\"", startIndex);
        System.out.println(json);
        return json.substring(startIndex, endIndex);
    }
}
