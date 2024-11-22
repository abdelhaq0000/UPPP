package com.example.bracelet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bracelet.model.User;
import com.example.bracelet.model.HealthRecord;
import com.example.bracelet.repository.UserRepository;
import com.example.bracelet.repository.HealthRecordRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {

    private final UserRepository userRepository;
    private final HealthRecordRepository healthRecordRepository;

    @Autowired
    public DataServiceImpl(UserRepository userRepository, HealthRecordRepository healthRecordRepository) {
        this.userRepository = userRepository;
        this.healthRecordRepository = healthRecordRepository;
    }

    @Override
    public String receiveData(String idbracelet, String tempStr, int ps, int pd, int fc) {
        try {
            double temp = Double.parseDouble(tempStr);

            User user = userRepository.findByIdbracelet(idbracelet);
            if (user == null) {
                return "User not found for idbracelet: " + idbracelet;
            }



            // Create a new HealthRecord with the formatted date
            HealthRecord healthRecord = new HealthRecord(user, temp, ps, pd, fc, LocalDateTime.now());

            healthRecordRepository.save(healthRecord);

            System.out.println("Health record created and associated with user: " + user);

            return "Data received and associated with user successfully";
        } catch (NumberFormatException | NullPointerException e) {
            System.err.println("Error processing data: " + e.getMessage());
            return "Error processing data: " + e.getMessage();
        }
    }

    @Override
    public Map<String, Object> getCurrentData(String idbracelet) {
        User user = userRepository.findByIdbracelet(idbracelet);
        if (user == null) {
            throw new IllegalArgumentException("User not found for idbracelet: " + idbracelet);
        }

        HealthRecord latestHealthRecord = healthRecordRepository.findFirstByUserOrderByRecordedAtDesc(user);
        if (latestHealthRecord == null) {
            throw new IllegalArgumentException("No health record found for user: " + user.getIdbracelet());
        }

        Map<String, Object> healthRecordData = new HashMap<>();
        healthRecordData.put("temp", latestHealthRecord.getTemp());
        healthRecordData.put("ps", latestHealthRecord.getPs());
        healthRecordData.put("pd", latestHealthRecord.getPd());
        healthRecordData.put("fc", latestHealthRecord.getFc());
        healthRecordData.put("recordedAt", latestHealthRecord.getRecordedAt());

        return healthRecordData;
    }
}

