package epat2;

public class Service {

	Dao dao;
	
	public String getNameById(Integer id){		
		String name = dao.getNameById(id);
		return name;
	}
}
