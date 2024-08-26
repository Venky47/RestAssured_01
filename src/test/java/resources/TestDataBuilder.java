package resources;

import pojo.AddPlace_POJO;
import pojo.Location_POJO;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {

    public AddPlace_POJO addPlacePayload(String name,String language,String address){
        AddPlace_POJO p =new AddPlace_POJO();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhone_number("(+91) 983 893 3937");
        p.setWebsite("https://rahulshettyacademy.com");
        p.setName(name);
        List<String> myList =new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");
        p.setTypes(myList);
        Location_POJO l =new Location_POJO();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }

    public AddPlace_POJO addPlacePayload(){
        AddPlace_POJO p =new AddPlace_POJO();
        p.setAccuracy(50);
        p.setAddress("side layout, cohen 09");
        p.setLanguage("Kannada");
        p.setPhone_number("(+91) 983 893 3937");
        p.setWebsite("https://rahulshettyacademy.com");
        p.setName("Venkat");
        List<String> myList =new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");
        p.setTypes(myList);
        Location_POJO l =new Location_POJO();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }

    //place id dynamically handled
    public String deletePlacePayload(String placeId)
    {
        return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
    }
}
