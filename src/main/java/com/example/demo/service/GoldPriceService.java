package com.example.demo.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import com.example.demo.Model.MetalPrice;
@Service
public class GoldPriceService {

    // url to hit
    private static final String URL =
            "https://commoditiescontrol.com/eagritrader/revamp/long_short_details.php";

    // method to fetch the data
    private MetalPrice getMetalData(String metalName) {
        try {
            Document doc = Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0")
                    .timeout(20000)
                    .get();

            Element row = doc.selectFirst(
                    "tr:has(p.m-0.element:matchesOwn(^" + metalName + "$))");

            if (row == null) return new MetalPrice(metalName, "N/A", "N/A", "Not found");
            // data of expiry, current rate and revious rate
            String expiry = row.selectFirst("p.m-0.expiration").text();
            String current = row.selectFirst("span.startDate").text();
            String previous = row.selectFirst("span.endDate").text();

            return new MetalPrice(metalName, current, previous, expiry);

        } catch (Exception e) {
            return new MetalPrice(metalName, "Error", "Error", "Error");
        }
    }
    // gold method
    public MetalPrice getGoldPrice() { return getMetalData("Gold"); }
    // silver method
    public MetalPrice getSilverPrice() { return getMetalData("Silver"); }
    // copper method
    public MetalPrice getCopperPrice() { return getMetalData("Copper"); }
    // lead method
    public MetalPrice getLeadPrice() { return getMetalData("Lead"); }
    // gold method
    // public MetalPrice getAluminiumPrice() { return getMetalData("Aluminium"); }



}
