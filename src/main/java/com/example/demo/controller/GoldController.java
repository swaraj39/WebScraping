package com.example.demo.controller;

import com.example.demo.service.GoldPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "https://web-scraping-front.vercel.app/")
@RestController
public class GoldController {

    @Autowired
    private GoldPriceService service;

    @GetMapping("/metal")
    public Map<String, String> getGoldPrices() {

        Map<String, String> map = new HashMap<>();
        map.put("gold24", service.getGoldPrice());
        map.put("silver", service.getSilverPrice());
        map.put("platinum", service.getPlatinnumPrice());
        map.put("copper", service.getCopperPrice());
        map.put("Lead", service.getLeadPrice());
        return map;
    }
}
