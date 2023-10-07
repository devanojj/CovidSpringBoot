package com.example.springboot6.springboot6.Controller;



import com.example.springboot6.springboot6.Models.Week;
import com.example.springboot6.springboot6.Repo.WeekRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@RestController
public class WeekControllers {

    @Autowired
    private WeekRepo weekRepo;

    @GetMapping(value = "/week")
    public String week() {

        int finalInt = 0;
        Document doc;

        try {
            doc = Jsoup.connect("https://www.epochconverter.com/weeks/2022").get();
            // Gets B tag in website
            Elements TagB = doc.getElementsByTag("b");

            for(Element b : TagB) {
                if(b.toString().contains("week")){
                    String oldString = b.text().toString();
                    String newString = oldString.replace("week ", "");

                    int intoInt = Integer.parseInt(newString);
                    int minus10 = 10;
                    finalInt = intoInt - minus10;
                    //System.out.print(finalInt);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Changes int to StringBuilder, adds 2022-W then changes to normal String
        StringBuilder sb = new StringBuilder(String.valueOf(finalInt));
        sb.insert(0, "2022-W");
        System.out.println(sb);
        String sb1 = sb.toString();
        Week w1 = new Week(sb1);

        weekRepo.save(w1);

        return sb1;
    }


    @GetMapping(value = "/weekDB")
    public String getUsers() {
        //String x = weekRepo.findAll().get(0).toString();
        /*Week row;

        for(int i=0; i<weekRepo.count(); i++){
            row = weekRepo.findAll().get(i);
            row.getWeekNumber();
        } */


        Week x = weekRepo.findAll().get(0);
        String y = x.getWeekNumber().toString();
        //List
        return y;
    }
}


/*
This code goes into the internet and gets the Week - 10 and then tests it
 */