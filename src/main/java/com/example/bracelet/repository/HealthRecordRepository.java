package com.example.bracelet.repository;


import com.example.bracelet.model.HealthRecord;
import com.example.bracelet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {
    HealthRecord findFirstByUserOrderByRecordedAtDesc(User user);
}
