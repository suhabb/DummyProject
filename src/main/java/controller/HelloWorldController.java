package controller;

import application_service.LoginService;
import application_service.PersonApplicationService;
import data_transfer.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class HelloWorldController {
	
	@Autowired
	protected LoginService loginService;
	
	@Autowired
	protected PersonApplicationService personApplicationService;
	

	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(Model model) throws Exception{	
		
		PersonDTO personDTO = personApplicationService.findByName("Dawn Keith");
		model.addAttribute("name",personDTO.getName());
		return "hello";
	}

	@RequestMapping(value="/basic",method=RequestMethod.GET)
	public String basic(Model model) throws Exception{

		PersonDTO personDTO = personApplicationService.findByName("Dawn Keith");
		model.addAttribute("person",personDTO);
		loginService.loggin();
		return "basic";
	}

	@RequestMapping(value="/allusers/{renderview}",method=RequestMethod.GET)
	public ModelAndView getAllUsers(Model model,@PathVariable("renderview") String renderView) throws Exception{
        ModelAndView modelAndView = new ModelAndView(renderView);
		List<PersonDTO> personDTOList = personApplicationService.findAll();
        modelAndView.addObject("personList", personDTOList);
		return modelAndView;
	}

    @RequestMapping(value="/processdata",method=RequestMethod.POST)
    public String processFormData(@RequestParam Map<String,String> requestParams,HttpServletRequest request) throws Exception{
        Map<String, String[]> parameters = request.getParameterMap();
        System.out.println("MongoController.processFormData1"+requestParams.toString());
        System.out.println("MongoController.processFormData2"+parameters.toString());

        return "hello";
    }

    @RequestMapping(value="/formdata",method=RequestMethod.GET)
    public String formData() throws Exception{
        return "form";
    }

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home() throws Exception{
		return "ecom/home";
	}

}
