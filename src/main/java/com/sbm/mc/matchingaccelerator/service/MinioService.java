package com.sbm.mc.matchingaccelerator.service;

import io.minio.MinioClient;
import io.minio.errors.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MinioService {

    private static final String BUCKET_NAME = "dev";
    private static final String MINIO_URL = "http://localhost:9000";
    private static final String ACCESS_KEY = "minioadmin";
    private static final String SECRET_KEY = "minioadminpass";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void processFile(String fileName) throws Exception {
        MinioClient minioClient = MinioClient.builder().endpoint(MINIO_URL).credentials(ACCESS_KEY, SECRET_KEY).build();

        try (InputStream stream = minioClient.getObject(io.minio.GetObjectArgs.builder().bucket(BUCKET_NAME).object(fileName).build())) {
            List<String> lines = new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.toList());
            importDataToPostgres(lines);
        }
    }

    private void importDataToPostgres(List<String> lines) {
        // Example CSV parsing and insertion, adjust based on your CSV format
        for (String line : lines) {
            String[] values = line.split(",");
            String sql = "INSERT INTO svr_api_resv (col1, col2, col3) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, values[0], values[1], values[2]);
        }
    }
}
