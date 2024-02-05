package com.klix.financing.domain.bankapplication.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.klix.financing.domain.bankapplication.BankApplicationService;

@Component
public class DraftApplicationScheduler {

    private final BankApplicationService bankApplicationService;

    public DraftApplicationScheduler(BankApplicationService bankApplicationService) {
        this.bankApplicationService = bankApplicationService;
    }
    
    @Scheduled(fixedDelayString = "${integrations.jobs.draft-application-status-check-ms}")
    public void checkDraftApplicationStatus() {
        bankApplicationService.revisitDraftApplications();
    }
}
