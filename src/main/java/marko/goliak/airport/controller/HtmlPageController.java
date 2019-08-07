package marko.goliak.airport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlPageController {
    @RequestMapping("/countries")
    public String counties(){
        return "countries.html";
    }

    @RequestMapping("/cities")
    public String cities(){ return "cities.html"; }

    @RequestMapping("/addresses")
    public String address(){ return "addresses.html"; }

    @RequestMapping("/airports")
    public String airport(){ return "airports.html"; }

    @RequestMapping("/statuses")
    public String status(){return "statuses.html";}

    @RequestMapping("/stops")
    public String stop(){return "stops.html";}

    @RequestMapping("/flights")
    public String flight(){return "flights.html";}

    @RequestMapping("/types")
    public String type(){return "types.html";}

    @RequestMapping("/tickets")
    public String ticket(){return "tickets.html";}

    @RequestMapping("/ticketShop")
    public String ticketShop(){return "ticketShop.html";}
}