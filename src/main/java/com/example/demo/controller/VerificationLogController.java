package com.example.demo.controller;
import jakarta.validation.Valid;
import com.example.demo.model.VerificationLogEntity;
import com.example.demo.service.VerificationLogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/verification-logs")
public class VerificationLogController {

    private final VerificationLogService service;

    public VerificationLogController(VerificationLogService service) {
        this.service = service;
    }

    @PostMapping
    public VerificationLogEntity create(@Valid @RequestBody VerificationLogEntity log) {
        return service.createLog(log);
    }

    @GetMapping("/{id}")
    public VerificationLogEntity get(@PathVariable Long id) {
        return service.getLogById(id);
    }

    @GetMapping("/entry/{entryId}")
    public List<VerificationLogEntity> byEntry(@PathVariable Long entryId) {
        return service.getLogsForEntry(entryId);
    }
}
