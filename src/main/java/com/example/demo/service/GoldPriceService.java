package com.example.demo.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import com.example.demo.Model.MetalPrice;
@Service
public class GoldPriceService {

    private static final String URL =
            "https://commoditiescontrol.com/eagritrader/revamp/long_short_details.php";

    private MetalPrice getMetalData(String metalName) {
        try {
            Document doc = Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0")
                    .timeout(20000)
                    .get();

            Element row = doc.selectFirst(
                    "tr:has(p.m-0.element:matchesOwn(^" + metalName + "$))");

            if (row == null) return new MetalPrice(metalName, "N/A", "N/A", "Not found");

            String expiry = row.selectFirst("p.m-0.expiration").text();
            String current = row.selectFirst("span.startDate").text();
            String previous = row.selectFirst("span.endDate").text();

            return new MetalPrice(metalName, current, previous, expiry);

        } catch (Exception e) {
            return new MetalPrice(metalName, "Error", "Error", "Error");
        }
    }

    public MetalPrice getGoldPrice() { return getMetalData("Gold"); }
    public MetalPrice getSilverPrice() { return getMetalData("Silver"); }
    public MetalPrice getCopperPrice() { return getMetalData("Copper"); }
    public MetalPrice getLeadPrice() { return getMetalData("Lead"); }
    public MetalPrice getAluminiumPrice() { return getMetalData("Aluminium"); }



}
