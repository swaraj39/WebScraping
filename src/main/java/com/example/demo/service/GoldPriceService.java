package com.example.demo.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class GoldPriceService {

    private static final String URL =
            "https://commoditiescontrol.com/eagritrader/revamp/long_short_details.php";

    public String getGoldPrice() {
        try {
            Document doc = Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0")
                    .timeout(20000)
                    .get();

            Element row = doc.selectFirst("tr:has(p.m-0.element:matchesOwn(^Gold$))");
            if (row == null) return "Gold not found";

            String expiry = row.selectFirst("p.m-0.expiration").text();
            String current = row.selectFirst("span.startDate").text();
            String previous = row.selectFirst("span.endDate").text();

            return "Gold | Current: ₹" + current +
                    " | Previous: ₹" + previous +
                    " | " + expiry;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching Gold price";
        }
    }

    public String getSilverPrice() {
        try {
            Document doc = Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0")
                    .timeout(20000)
                    .get();

            Element row = doc.selectFirst("tr:has(p.m-0.element:matchesOwn(^Silver$))");
            if (row == null) return "Silver not found";

            String expiry = row.selectFirst("p.m-0.expiration").text();
            String current = row.selectFirst("span.startDate").text();
            String previous = row.selectFirst("span.endDate").text();

            return "Silver | Current: ₹" + current +
                    " | Previous: ₹" + previous +
                    " | " + expiry;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching Silver price";
        }
    }

    public String getCopperPrice() {
        try {
            Document doc = Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0")
                    .timeout(20000)
                    .get();

            Element row = doc.selectFirst("tr:has(p.m-0.element:matchesOwn(^Copper$))");
            if (row == null) return "Copper not found";

            String expiry = row.selectFirst("p.m-0.expiration").text();
            String current = row.selectFirst("span.startDate").text();
            String previous = row.selectFirst("span.endDate").text();

            return "Copper | Current: ₹" + current +
                    " | Previous: ₹" + previous +
                    " | " + expiry;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching Copper price";
        }
    }

    public String getLeadPrice() {
        try {
            Document doc = Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0")
                    .timeout(20000)
                    .get();

            Element row = doc.selectFirst("tr:has(p.m-0.element:matchesOwn(^Lead$))");
            if (row == null) return "Lead not found";

            String expiry = row.selectFirst("p.m-0.expiration").text();
            String current = row.selectFirst("span.startDate").text();
            String previous = row.selectFirst("span.endDate").text();

            return "Lead | Current: ₹" + current +
                    " | Previous: ₹" + previous +
                    " | " + expiry;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching Lead price";
        }
    }

    public String getAluminiumPrice() {
        try {
            Document doc = Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0")
                    .timeout(20000)
                    .get();

            Element row = doc.selectFirst("tr:has(p.m-0.element:matchesOwn(^Aluminium$))");
            if (row == null) return "Aluminium not found";

            String expiry = row.selectFirst("p.m-0.expiration").text();
            String current = row.selectFirst("span.startDate").text();
            String previous = row.selectFirst("span.endDate").text();

            return "Aluminium | Current: ₹" + current +
                    " | Previous: ₹" + previous +
                    " | " + expiry;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching Aluminium price";
        }
    }

    public String getPlatinnumPrice() {

        try {

            String url = "https://www.goodreturns.in/platinum-price.html";

            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .header("Accept-Language", "en-US,en;q=0.9")
                    .header("Referer", "https://www.google.com/")
                    .timeout(20000)
                    .get();

            // ✅ Correct selector (ID)
            String price = doc.select("#platinum-1g-price").text();

            return price;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching price";
        }
    }


}
