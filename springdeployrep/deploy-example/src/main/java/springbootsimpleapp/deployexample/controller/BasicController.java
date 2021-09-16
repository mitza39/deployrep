package springbootsimpleapp.deployexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
	
	    @GetMapping("/deploy")
	    public String welcome(){
	        return "This app is deployed on Cloud";
	    
	}

}
