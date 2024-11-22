package com.example.bracelet.Controller;

import com.example.bracelet.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/api/data")
    public String receiveData(
            @RequestParam("idbracelet") String idbracelet,
            @RequestParam("temp") String tempStr,
            @RequestParam("ps") int ps,
            @RequestParam("pd") int pd,
            @RequestParam("fc") int fc
    ) {
        return dataService.receiveData(idbracelet, tempStr, ps, pd, fc);
    }

    @GetMapping("/api/getCurrentData")
    public Map<String, Object> getCurrentData(@RequestParam("idbracelet") String idbracelet) {
        return dataService.getCurrentData(idbracelet);
    }
}