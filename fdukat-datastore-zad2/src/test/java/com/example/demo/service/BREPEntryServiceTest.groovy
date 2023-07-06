package com.example.demo.service

import com.example.demo.model.BREPEntry
import com.example.demo.model.OperationSystem
import com.example.demo.repository.BREPEntryRepository
import spock.lang.Specification

class BREPEntryServiceTest extends Specification {
    private BREPEntryRepository brepEntryRepository
    private BREPEntryService brepEntryService

    def "createBREPEntry"() {
        given:
        brepEntryRepository = Mock(BREPEntryRepository)
        brepEntryService = new BREPEntryService(brepEntryRepository)
        def brepEntry1 = new BREPEntry(
                id: 1L,
                fullName: "John Doe",
                operationSystem: OperationSystem.UBUNTU,
                yearsInXTRF: 10,
                bambooGoalsDonePercent: 55.0,
                bambooGoalsDonePercentInteger: 55
        )

        def brepEntry2 = new BREPEntry(
                id: 2L,
                fullName: "Jane Doe",
                operationSystem: OperationSystem.WINDOWS,
                yearsInXTRF: 2,
                bambooGoalsDonePercent: 60.0,
                bambooGoalsDonePercentInteger: 60
        )

        when:
        brepEntryService.createBREPEntry(brepEntry1)
        brepEntryService.createBREPEntry(brepEntry2)

        then:
        noExceptionThrown()
        2 * brepEntryRepository.save(_)
    }

    def "getBREPEntriesByBambooGoalsDonePercentGreaterThan"() {
        brepEntryRepository = Mock(BREPEntryRepository)
        brepEntryService = new BREPEntryService(brepEntryRepository)
        given:
        def brepEntry1 = new BREPEntry(
                id: 1L,
                fullName: "John Doe",
                operationSystem: OperationSystem.UBUNTU,
                yearsInXTRF: 10,
                bambooGoalsDonePercent: 55.0,
                bambooGoalsDonePercentInteger: 55
        )

        def brepEntry2 = new BREPEntry(
                id: 2L,
                fullName: "Jane Doe",
                operationSystem: OperationSystem.WINDOWS,
                yearsInXTRF: 2,
                bambooGoalsDonePercent: 60.0,
                bambooGoalsDonePercentInteger: 60
        )
        brepEntryRepository.findByOperationSystem(OperationSystem.UBUNTU) >> [brepEntry1]
        brepEntryRepository.findByOperationSystem(OperationSystem.WINDOWS) >> [brepEntry2]

        when:
        List<BREPEntry> brepEntryUbuntu = brepEntryService.getBREPEntriesByOperationSystem(OperationSystem.UBUNTU)
        List<BREPEntry> brepEntryWindows = brepEntryService.getBREPEntriesByOperationSystem(OperationSystem.WINDOWS)

        then:
        noExceptionThrown()
        brepEntryUbuntu == [brepEntry1]
        brepEntryWindows == [brepEntry2]
    }


}
