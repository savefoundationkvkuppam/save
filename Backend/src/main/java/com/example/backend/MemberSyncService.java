package com.example.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MemberSyncService {

    private static final Logger log = LoggerFactory.getLogger(MemberSyncService.class);

    // The secondary connection is optional: services without SECONDARY_DB_* settings
    // still start, and simply skip copying members.
    private final ObjectProvider<JdbcTemplate> secondaryJdbcProvider;
    private boolean warnedNoSecondary = false;

    public MemberSyncService(
            @Qualifier("secondaryJdbcTemplate") ObjectProvider<JdbcTemplate> secondaryJdbcProvider) {
        this.secondaryJdbcProvider = secondaryJdbcProvider;
    }

    public void syncMember(
            String memberCode,
            String memberName,
            String regionalMemberName,
            String clusterName,
            String vazhvathramName,
            String designation,
            String date,
            String dateOfJoining,
            String yearOfBirth,
            String maritalStatus,
            String husbandFatherName,
            String aliveStatus,
            String category,
            String familyCategory,
            String caste,
            String rationCard,
            String rationCardNo,
            String voterId,
            String spouseVoterId,
            String aadhaarId,
            String spouseAadhaarId,
            String mobileNumber,
            String spouseMobileNumber,
            String jobCardNo,
            String panCardNo,
            String regularSavings,
            String specialSavings,
            String houseOwnership,
            boolean locked) {

        JdbcTemplate targetJdbc = secondaryJdbcProvider.getIfAvailable();
        if (targetJdbc == null) {
            if (!warnedNoSecondary) {
                log.info("MemberSyncService: no secondary database configured, member copy is skipped.");
                warnedNoSecondary = true;
            }
            return;
        }

        String sql = """
            INSERT INTO public.members (
                member_code, member_name, regional_member_name,
                cluster_name, vazhvathram_name, designation,
                date, date_of_joining, year_of_birth, marital_status,
                husband_father_name, alive_status, category,
                family_category, caste, ration_card, ration_card_no,
                voter_id, spouse_voter_id, aadhaar_id, spouse_aadhaar_id,
                mobile_number, spouse_mobile_number, job_card_no,
                pan_card_no, regular_savings, special_savings,
                house_ownership, locked
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            ON CONFLICT (member_code) DO UPDATE SET
                member_name = EXCLUDED.member_name,
                regional_member_name = EXCLUDED.regional_member_name,
                cluster_name = EXCLUDED.cluster_name,
                vazhvathram_name = EXCLUDED.vazhvathram_name
            """;

        targetJdbc.update(sql,
                memberCode, memberName, regionalMemberName,
                clusterName, vazhvathramName, designation,
                date, dateOfJoining, yearOfBirth, maritalStatus,
                husbandFatherName, aliveStatus, category,
                familyCategory, caste, rationCard, rationCardNo,
                voterId, spouseVoterId, aadhaarId, spouseAadhaarId,
                mobileNumber, spouseMobileNumber, jobCardNo,
                panCardNo, regularSavings, specialSavings,
                houseOwnership, locked);
    }
}
