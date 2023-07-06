package com.example.demo.service;

import com.example.demo.model.BREPEntry;
import com.example.demo.model.OperationSystem;
import com.example.demo.repository.BREPEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BREPEntryService {
    private final BREPEntryRepository brepEntryRepository;

    public void createBREPEntry(BREPEntry brepEntry) {
        brepEntryRepository.save(brepEntry);
    }

    public List<BREPEntry> getBREPEntriesByOperationSystem(OperationSystem operationSystem) {
        return  brepEntryRepository.findByOperationSystem(operationSystem);
    }
}
