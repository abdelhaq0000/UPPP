package com.example.bracelet.service;

import java.util.Map;

public interface DataService {
    String receiveData(String idbracelet, String tempStr, int ps, int pd, int fc);
    Map<String, Object> getCurrentData(String idbracelet);
}