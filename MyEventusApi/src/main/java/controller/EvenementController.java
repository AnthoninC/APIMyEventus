package controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/evenement")
public class EvenementController {

    @GetMapping("/all")
    public String all() {
        return "Liste de tous les event";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id) {
        return "Evenement avec l'id : " + id;
    }

    @GetMapping("/getByDate")
    public String getByDate(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        return "Liste des events pour la date :"+ date.toString(); 
    }

    @GetMapping("/getArea")
    public String getArea(@RequestParam("long") double longitide, @RequestParam("lat") double latitude ){
        return "Liste des events pour la position :"+ longitide + "    "+ latitude; 
    }
    
}

