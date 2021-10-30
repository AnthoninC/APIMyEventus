package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Evenement;
import model.EvenementRepository;
import model.EvenementRowMapper;

@RestController
@RequestMapping(path = "/evenement")
public class EvenementController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    @GetMapping("/all")
    public String all() {
        return "Liste de tous les event";
    }
    
    /*
    @GetMapping("/allevents")
    public String listAll(Model model) {
        List<Evenement> listStudents = eventRepo.findAll();
        model.addAttribute("listStudents", listStudents);
           
        return "allevents";
    }
    */
    
    @GetMapping("/testReturnCountEvenement")
    public int returnAllEvent() {
    	int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM evenement", Integer.class);
    	return result;
    }
    
    
    @GetMapping("/testReturnEvenementById/{id}")
    public String returnAllEvent(@PathVariable("id") int id) {
    	
    	String query = "SELECT * FROM evenement WHERE uid = ?";
    	/*
    	Evenement employee = jdbcTemplate.queryForObject(
    	  query, 
    	  new Object[] { id },
    	  new EvenementRowMapper()
    	);
    	*/
    	try 
    	{
        	//jdbcTemplate.queryForObject("select * from student_id = ?", studentRowMapper, studentId)
        	Evenement event = jdbcTemplate.queryForObject(query, new EvenementRowMapper(), id);

        	return event.toString();
    	}catch(Exception ex){
    		if(ex instanceof EmptyResultDataAccessException) {
    			return "[]"; //TODO method qui return un json indiquant un retour vide ( {code:200, data: []} )
    		}else {
    			return "error";
    		}
    		
    	}
    	
    	
    	
    	/*
    	jdbcTemplate.query(
    	        "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", 
    	        new Object[] { "Josh" },
    	        (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
    	    )
    	*/
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
    public String getArea(@RequestParam("long") double longitude, @RequestParam("lat") double latitude ){
        return "Liste des events pour la position :"+ longitude + "    "+ latitude; 
    }
    
}

