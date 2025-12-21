package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verification-logs")
public class VerificationLogController {

    private final VerificationLogService verificationLogService;

    public VerificationLogController(VerificationLogService verificationLogService) {
        this.verificationLogService = verificationLogService;
    }

    @PostMapping
    public VerificationLog createLog(@RequestBody VerificationLog log) {
        return verificationLogService.createLog(log);
    }

    @GetMapping("/{id}")
    public VerificationLog getLog(@PathVariable Long id) {
        return verificationLogService.getLogById(id);
    }

    @GetMapping("/entry/{entryId}")
    public List<VerificationLog> getLogsForEntry(@PathVariable Long entryId) {
        return verificationLogService.getLogsForEntry(entryId);
    }
}
