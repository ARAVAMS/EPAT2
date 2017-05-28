package epat2;

import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.context.request.WebRequest;

import org.junit.Test;


/*
 * Note: This should be our First class of development.
 * Create different scenario(positive and negative) of your test cases.
 * pass your test cases one by one.
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
	
	@InjectMocks
	Controller controller = new Controller();
	
	@Mock
	private Service service;

	Model mockedModel = Mockito.mock(Model.class);
	
	// Ist test to Create instance/Controller
    @Test
	void getInstance(){
    	Controller controller = new Controller();
    	Assert.assertNotNull(controller);
	}
    
    // Then write all scenarios
    @Test
	public void should_Get_LandingPage(){
		String returnView = controller.getLandingPage(mockedModel);
		assertEquals("Returned view should be landingPage ", "landingPage", returnView);
	}
    
    @Test
	public void  should_Get_Name(){
    	String expectedValue = "Name";
		Mockito.when(service.getNameById(Mockito.anyInt())).thenReturn("Name");
		String returnValue  = controller.getName();
		assertEquals(expectedValue, returnValue);
	}
	
}
