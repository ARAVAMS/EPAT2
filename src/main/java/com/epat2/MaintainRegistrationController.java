package com.epat2;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.epat2.service.OrganizationService;
import com.google.gson.Gson;

@Controller
public class MaintainRegistrationController {
	
	@Resource(name = EPAT2Constants.ORGANIZATION_SERVICE)
	private OrganizationService organizationService;
	
	@RequestMapping(value = "/getRegistrationPage", method = RequestMethod.GET)
	public String getRegistrationPage(ModelMap model) {
		OrganizationForm organizationForm = new OrganizationForm();
		EmployeeForm employeeForm = new EmployeeForm();
		model.addAttribute(EPAT2Constants.ORGANIZATION_FORM, organizationForm);
		model.addAttribute(EPAT2Constants.EMPLOYEE_FORM, employeeForm);
		return "registrationPage";

	}
	
	
	@RequestMapping(value = "/organization", method = RequestMethod.POST, params = EPAT2Constants.USERACTION_SAVE)
	public String saveOrganization(@ModelAttribute(value=EPAT2Constants.ORGANIZATION_FORM)OrganizationForm form) {
		OrganizationForm organizationForm = form;
		organizationService.saveOrganization(organizationForm);
		return "organizationWizard";
	}
	
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET, params = EPAT2Constants.USERACTION_LOGIN)
	public @ResponseBody String saveEmployee(HttpServletResponse response, @ModelAttribute(value=EPAT2Constants.EMPLOYEE_FORM)EmployeeForm employeeForm) {
		boolean isLoginExist=  organizationService.loginEmployee(employeeForm);
		String json = new Gson().toJson(isLoginExist);
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8"); 
		return json;
	}
	
	@RequestMapping(value = "/getWizardPage", method = RequestMethod.GET)
	public String getWizardPage(ModelMap model) {
		return "organizationWizard";

	}
	
}
