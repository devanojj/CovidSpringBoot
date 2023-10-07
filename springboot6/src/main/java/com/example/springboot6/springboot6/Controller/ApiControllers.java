package com.example.springboot6.springboot6.Controller;

import com.example.springboot6.springboot6.Models.Art;
import com.example.springboot6.springboot6.Models.Country;
import com.example.springboot6.springboot6.Models.Week;
import com.example.springboot6.springboot6.Repo.ArtRepo;
import com.example.springboot6.springboot6.Repo.CountryRepo;

import com.example.springboot6.springboot6.Repo.WeekRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;


import java.util.HashMap;

@RestController
public class ApiControllers {


    @Autowired
    private ArtRepo artRepo;
    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private WeekRepo weekRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome devano";
    }




    @GetMapping(value = "/artTest")
    public String art() {
         {


            for (int j=0; j<2; j++){
                String i = "test2";
                Art art7 = new Art(
                        i,
                        i,
                        i
                );
                artRepo.save(art7);
                j++;
            }
        }

        return "Added Art";
    }


    @GetMapping(value = "/getInfo")
    public String covidInfo() throws SAXException, IOException, ParserConfigurationException {

        HashMap<String, String> countryCodes = new HashMap<>();

        DocumentBuilderFactory factory0 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder0 = factory0.newDocumentBuilder();
        Document doc0 = builder0.parse(new File("country_code.xml"));
        NodeList users0 = doc0.getElementsByTagName("fme:Sheet");

        for (int i=0; i<users0.getLength(); i++) {
            Node user0 = users0.item(i);
            if(user0.getNodeType() == Node.ELEMENT_NODE) {
                Element elem0 = (Element) user0;

                Node country0 = elem0.getElementsByTagName("fme:country").item(0);
                Node code0 = elem0.getElementsByTagName("fme:country_code").item(0);

                countryCodes.put(country0.getTextContent(), code0.getTextContent());
            }
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("covid_data.xml"));
        NodeList users = doc.getElementsByTagName("fme:Sheet");

        for (int i=0; i<users.getLength(); i++) {
            Node user = users.item(i);

            if(user.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) user;



                Node indicator = elem.getElementsByTagName("fme:indicator").item(0);
                String ind = indicator.getTextContent();

                Node date1 = elem.getElementsByTagName("fme:year_week").item(0);
                String compareWeek = date1.getTextContent();
                String dateFromCallWeek = "2022-W40"; // input needs changed
                Week x = weekRepo.findAll().get(0);
                String z1 = x.getWeekNumber().toString();


                Node country = elem.getElementsByTagName("fme:country").item(0);
                Node date = elem.getElementsByTagName("fme:date").item(0);
                Node value = elem.getElementsByTagName("fme:value").item(0);
                Node yearWeek = elem.getElementsByTagName("fme:year_week").item(0);
                //Node yearWeek1 = elem.getElementsByTagName("fme:year_week").item(1);

                if(ind.equals("Daily hospital occupancy") && compareWeek.equals(z1)) {

                    //System.out.println("\n\nCountry: " + country.getTextContent());
                    String c = country.getTextContent();

                    //System.out.println("Date: " + date.getTextContent());
                    String d = date.getTextContent();

                    //System.out.println("Daily addmissions: " + value.getTextContent());
                    String v = value.getTextContent();

                    //System.out.println("Week and year: " + yearWeek.getTextContent());
                    String y = yearWeek.getTextContent();

                    String co;

                    if(countryCodes.get(country.getTextContent()) !=null) {
                        //System.out.println("Country code: " + countryCodes.get(country.getTextContent()));
                        co = countryCodes.get(country.getTextContent());
                    } else {
                        //System.out.println("Country code: Country code not found");
                        co = "Country code: Country code not found";
                    }

                    //Random random = new Random();
                    //int x = random.nextInt(100);
                    //String z = Integer.toString(x);

                    Country c1 = new Country(
                            c, 
                            d, 
                            v, 
                            y, 
                            co);

                    //List<Country> c2 = new ArrayList<Country>();
                    //c2.add(c1);
                    //System.out.println("ArrayList: " + c2.get(0));


                    countryRepo.save(c1);
                }

            }
        }


        return "Success";
    }



}
/*
Main Function, reads xml files, puts country into database
 */