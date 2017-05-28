package epat2;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


public class ServiceTest {
	
	@InjectMocks
	Service service = new Service();
	
	@Mock
	Dao dao = new Dao();
	
	@Test
	public void testGetCanEventById(){
		String expectedValue = "Name";
		String returnValue = service.getNameById(1);
		verify(dao,times(1)).getNameById(Mockito.any(Integer.class));
		assertEquals(expectedValue, returnValue);
	} 
}
