package com.epat2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epat2.fileManagement.domain.DayProjectTaskActivity;
import com.epat2.fileManagement.domain.Employe;
import com.epat2.fileManagement.domain.WeekAttendance;
import com.epat2.util.DateUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class MaintainEPAT2Controller {

	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	public String hello(ModelMap model) {
		model.addAttribute("name", "JCG Hello World!");
		//return new ModelAndView("helloWorld");
		return "helloWorld";

	}


	@RequestMapping(value = "/getResourceDetail", method = RequestMethod.GET)
	public String getResourceDetail(ModelMap model) {
		return "resourceDetail";

	}
	@RequestMapping(value = "/getWorkingTime1", method = RequestMethod.GET)
	@ResponseBody
	public String getWorkingHours(HttpServletResponse response,HttpServletRequest request )  {
		List<Form> forms = new ArrayList<Form>();
		Map<Integer, Employe> employeMap = new HashMap<Integer, Employe>();
		try {
			employeMap = getEmpAttendance(DateUtil.getCurrentMonth(TimeZone.getDefault()),DateUtil.getCurrentYear(TimeZone.getDefault()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Employe employe;
		for (Integer week : employeMap.keySet()) {
			employe = employeMap.get(week);
			List<WeekAttendance> weekAttendances = employe.getWeekAttendance();

			for (WeekAttendance weekAttendance : weekAttendances) {

				Form form1 = new Form();
				form1.setStart(weekAttendance.getDate().replace("_","-"));
				form1.setTitle(weekAttendance.getHours()+" Hours");
				form1.setUrl("/EPAT2/getDatTable?time="+3);
				forms.add(form1);
				List<DayProjectTaskActivity> dayProjectTaskActivities = employe.getDayProjectTask().get(weekAttendance.getWeekDay());
				if(dayProjectTaskActivities!=null){
					for (DayProjectTaskActivity dayProjectTaskActivity : dayProjectTaskActivities) {
						System.out.println(dayProjectTaskActivity.getStartTime());
						form1 = new Form();
						form1.setStart(weekAttendance.getDate().replace("_","-")+dayProjectTaskActivity.getStartTime());
						form1.setEnd(weekAttendance.getDate().replace("_", "-") + dayProjectTaskActivity.getEndTime());
						form1.setTitle(dayProjectTaskActivity.getProjectName() + "::" + dayProjectTaskActivity.getTask());
						//form1.setUrl("/RT3/getDatTable?time="+3);
						form1.setUrl("/EPAT2/getImages?projectId="+3);
						forms.add(form1);
					}
				}
			}
		}

		// Convert to JSON string.

		String json = new Gson().toJson(forms);
		System.out.println(json);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return json; //Try simply return =ing the json
	}

	protected Map<Integer,Employe> getEmpAttendance(int month, int year) throws FileNotFoundException {
		Integer[] weeksofMonth = DateUtil.getWeeksOfMonth(month,year);
		Map<Integer,Employe> employeMap = new HashMap<Integer,Employe>();
		try{
			for (Integer week : weeksofMonth) {
				System.out.println("selected week "+week);
				InputStream inputStream = new FileInputStream("C:\\epat2\\ServerSide\\textFile\\ap50864\\2015\\"+week+".json");
				Reader reader      = new InputStreamReader(inputStream);
				Gson gson = new GsonBuilder().create();

				Employe employe = gson.fromJson(reader, Employe.class);
				employeMap.put(week,employe);
			}
		}catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		return employeMap;
	}
	@RequestMapping(value = "/getWorkingTime", method = RequestMethod.GET)
	@ResponseBody
	public String getVacation(HttpServletResponse response) {
		List<Form> forms = new ArrayList<Form>();
		Form form1 = new Form();
		form1.setId(1);
		form1.setStart("2014-09-28"); 
		form1.setTitle("2Hours");
		form1.setUrl("http://yahoo.com/");	

		Form form2 = new Form();
		form2.setId(2); 
		form2.setStart("2014-09-09");
		form2.setTitle("3Hours");
		form2.setUrl("/EPAT2/getDatTable?time="+3);

		Form form3 = new Form();
		form3.setId(3);
		form3.setStart("2013-09-26");
		form3.setTitle("4Hours");
		form3.setUrl("http://yahoo.com/");

		Form form4 = new Form();
		form4.setId(3);
		form4.setStart("2014-10-01");
		form4.setTitle("4Hours");
		form4.setUrl("http://yahoo.com/");

		forms.add(form1); 
		forms.add(form2);
		forms.add(form3);
		forms.add(form4);

		// Convert to JSON string.
		String json = new Gson().toJson(forms);

		// Write JSON string.
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");  
		return json; //Try simply returning the json
	}


	@RequestMapping(value = "/getDatTable", method = RequestMethod.GET)
	public String getDatTable(ModelMap model, @RequestParam(value = "time", required = true) Integer time) {
		Integer timweee= time;
		return "projectDetail";

	}


	@RequestMapping(value = "/projectDetails", params = "userAction=getAll", method = RequestMethod.GET )
	public @ResponseBody
	String getDisplayTitle(@RequestParam int iDisplayStart,
			@RequestParam int iDisplayLength, @RequestParam int sEcho, HttpServletResponse response) {
		DataTablesTO<ResourceDetailForm> dt = new DataTablesTO<ResourceDetailForm>();
		//Integer displayTitleSize = domainTableStringService.getCountOfDisplayTitles(sSearch);
		//List<UIBlockText> displayTitleListPage = domainTableStringService.getDisplayTitles(iDisplayStart,iDisplayLength,sSearch);
		//List<UIBlockTextForm> uiBlockTextFormList =DozerUtility.mapList(displayTitleListPage, UIBlockTextForm.class, dozerBeanMapper);
		List<ResourceDetailForm> detailForms= new ArrayList<ResourceDetailForm>();
		ResourceDetailForm detailForm1 = new ResourceDetailForm();
		ResourceDetailForm detailForm2 = new ResourceDetailForm();
		ResourceDetailForm detailForm3 = new ResourceDetailForm();			
		detailForm1.setProjectId(1);	
		detailForm1.setProjectName("P1");
		detailForm1.setTask("T1");
		detailForm1.setTotalHours("1");

		detailForm2.setProjectId(2);
		detailForm2.setProjectName("P2");
		detailForm2.setTask("T2");
		detailForm2.setTotalHours("2");

		detailForm3.setProjectId(3);
		detailForm3.setProjectName("P3");
		detailForm3.setTask("T3");
		detailForm3.setTotalHours("3");

		detailForms.add(detailForm1);
		detailForms.add(detailForm2);
		detailForms.add(detailForm3);

		dt.setAaData(detailForms);
		dt.setiTotalDisplayRecords(10);
		dt.setiTotalRecords(10);
		dt.setsEcho(sEcho);
		String json = new Gson().toJson(dt);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		return json;
	}

	@RequestMapping(value = "/getImages", method = RequestMethod.GET)
	public String getImages(@RequestParam(value = "projectId", required = true) Integer projectId, ModelMap model) {
		Integer hh =projectId;
		return "imageDetail";

	}

} 
