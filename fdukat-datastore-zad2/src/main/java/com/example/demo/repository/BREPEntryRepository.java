package com.example.demo.repository;

import com.example.demo.model.BREPEntry;
import com.example.demo.model.OperationSystem;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import java.util.List;

public interface BREPEntryRepository extends DatastoreRepository<BREPEntry, Long> {
    List<BREPEntry> findByOperationSystem(OperationSystem operationSystem);
    List<BREPEntry> findByBambooGoalsDonePercentIntegerGreaterThan(Integer bambooGoalsDonePercentInteger);
}
