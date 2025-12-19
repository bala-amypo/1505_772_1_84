package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verification-logs") // ✅ base path per spec
public class VerificationLogController {

    private final VerificationLogService verificationLogService;

    // ✅ Constructor DI
    public VerificationLogController(VerificationLogService verificationLogService) {
        this.verificationLogService = verificationLogService;
    }

    // ✅ Create a new verification log
    @PostMapping
    public VerificationLog createLog(@Valid @RequestBody VerificationLog log) {
        return verificationLogService.createLog(log);
    }
}
