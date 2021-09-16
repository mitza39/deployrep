package projectfordeploy.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
 
	  @GetMapping("/deploy")
	    public String welcome(){
	        return "This app is deployed on Cloud";
	    
	}
 
}
