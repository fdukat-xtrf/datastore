package com.example.demo.controller;

import com.example.demo.model.BREPEntry;
import com.example.demo.model.OperationSystem;
import com.example.demo.service.BREPEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BREPController {
    private final BREPEntryService brepEntryService;

    @PostMapping
    public void createBREPEntry(@RequestBody BREPEntry brepEntry) {
        brepEntryService.createBREPEntry(brepEntry);
    }

    @GetMapping("/entries")
    public List<BREPEntry> getEntriesByOperationSystem(@RequestParam OperationSystem operationSystem) {
        return brepEntryService.getBREPEntriesByOperationSystem(operationSystem);
    }
}
