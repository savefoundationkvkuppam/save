package com.example.backend.controller;

import com.example.backend.entity.MemberJournal;
import com.example.backend.entity.OtherJournal;
import com.example.backend.repository.MemberJournalRepository;
import com.example.backend.repository.OtherJournalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/opening-balance")
@CrossOrigin(origins = "*")
public class OpeningBalanceController {

    private final MemberJournalRepository memberJournalRepository;
    private final OtherJournalRepository otherJournalRepository;

    public OpeningBalanceController(
            MemberJournalRepository memberJournalRepository,
            OtherJournalRepository otherJournalRepository) {

        this.memberJournalRepository = memberJournalRepository;
        this.otherJournalRepository = otherJournalRepository;
    }

    @GetMapping("/ob02")
    public List<Map<String, Object>> getOB02() {

        Map<String, Map<String, Object>> ledgerMap =
                new LinkedHashMap<>();

        for (MemberJournal journal : memberJournalRepository.findAll()) {

            addLedger(
                    ledgerMap,
                    journal.getGenLedger(),
                    journal.getSubLed1(),
                    journal.getType1(),
                    journal.getAmt1()
            );

            addLedger(
                    ledgerMap,
                    journal.getGenLedger(),
                    journal.getSubLed2(),
                    journal.getType2(),
                    journal.getAmt2()
            );

            addLedger(
                    ledgerMap,
                    journal.getGenLedger(),
                    journal.getSubLed3(),
                    journal.getType3(),
                    journal.getAmt3()
            );

            addLedger(
                    ledgerMap,
                    journal.getGenLedger(),
                    journal.getSubLed4(),
                    journal.getType4(),
                    journal.getAmt4()
            );

            addLedger(
                    ledgerMap,
                    journal.getGenLedger(),
                    journal.getSubLed5(),
                    journal.getType5(),
                    journal.getAmt5()
            );

            addLedger(
                    ledgerMap,
                    journal.getGenLedger(),
                    journal.getSubLed6(),
                    journal.getType6(),
                    journal.getAmt6()
            );
        }

        for (OtherJournal journal : otherJournalRepository.findAll()) {

            addLedger(
                    ledgerMap,
                    journal.getGeneralLedger(),
                    journal.getSubLedgerMain(),
                    journal.getDebitCredit(),
                    journal.getAmountMain()
            );
        }

        return new ArrayList<>(ledgerMap.values());
    }

    private void addLedger(
            Map<String, Map<String, Object>> ledgerMap,
            String generalLedger,
            String subLedger,
            String type,
            String amountText) {

        String ledger = clean(generalLedger);
        String sub = clean(subLedger);

        if (ledger.isEmpty() && sub.isEmpty()) {
            return;
        }

        String key = ledger + "|" + sub;

        Map<String, Object> row =
                ledgerMap.computeIfAbsent(
                        key,
                        k -> {

                            Map<String, Object> map =
                                    new LinkedHashMap<>();

                            map.put(
                                    "generalLedger",
                                    ledger
                            );

                            map.put(
                                    "subLedger",
                                    sub
                            );

                            map.put(
                                    "debit",
                                    0.0
                            );

                            map.put(
                                    "credit",
                                    0.0
                            );

                            return map;
                        }
                );

        double amount = number(amountText);

        String transactionType =
                clean(type).toLowerCase();

        if (
                transactionType.contains("debit") ||
                transactionType.equals("dr")
        ) {

            double old =
                    ((Number) row.get("debit"))
                            .doubleValue();

            row.put(
                    "debit",
                    old + amount
            );

        } else {

            double old =
                    ((Number) row.get("credit"))
                            .doubleValue();

            row.put(
                    "credit",
                    old + amount
            );
        }

        double debit =
                ((Number) row.get("debit"))
                        .doubleValue();

        double credit =
                ((Number) row.get("credit"))
                        .doubleValue();

        row.put(
                "balance",
                debit - credit
        );
    }

    private String clean(String value) {

        return value == null
                ? ""
                : value.trim();
    }

    private double number(String value) {

        if (value == null) {
            return 0;
        }

        try {

            return Double.parseDouble(
                    value
                            .replace(",", "")
                            .replace("₹", "")
                            .trim()
            );

        } catch (Exception e) {

            return 0;
        }
    }
}
