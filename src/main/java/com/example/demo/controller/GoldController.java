package com.example.demo.controller;

import com.example.demo.Model.MetalPrice;
import com.example.demo.service.GoldPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "https://web-scraping-front.vercel.app")
@RestController
public class GoldController {

    @Autowired
    private GoldPriceService service;

    @GetMapping("/metal")
    public Map<String, MetalPrice> getGoldPrices() {

        Map<String, MetalPrice> map = new HashMap<>();

        map.put("gold24", service.getGoldPrice());
        System.out.printf(service.getGoldPrice().toString());
        map.put("silver", service.getSilverPrice());
        map.put("copper", service.getCopperPrice());
        map.put("lead", service.getLeadPrice());

        return map;
    }
}
