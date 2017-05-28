package epat2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class Controller {	
	
	private static final Integer Integer = null;
	//service layer 
	Service service ;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET )
	public String getLandingPage(Model model) {		
		model.addAttribute("","");
		return "landingPage";
	}
	
	public String getName() {
		String name = service.getNameById(4);
		return name;
	}
}
