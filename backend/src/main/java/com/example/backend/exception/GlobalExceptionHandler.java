package com.example.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // IllegalArgumentException が発生したときに自動で呼ばれるメソッド
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {

        // フロントエンドに返すJSONの中身を組み立てる
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value()); // 400
        errorResponse.put("error", "Bad Request");
        errorResponse.put("message", ex.getMessage()); // Serviceで書いたエラーメッセージが入る

        // HTTPステータスコード 400 と一緒にJSONを返す
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
