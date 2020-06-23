package sv.hawklibrary.com.ORM.MySQLConverter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import sv.hawklibrary.com.ORM.TablesDataProperties;
import sv.hawklibrary.com.ORM.QueryOperations.IConstructortSelect;
import sv.hawklibrary.com.ORM.QueryOperations.IFind;
import sv.hawklibrary.com.ORM.QueryOperations.IJsonConvert;
import sv.hawklibrary.com.validators.NotFoundException;

public class Find extends JsonConvert implements IFind {


	private static Find find;
	protected IConstructortSelect constructorSelect = new ConstructorSelect();
	protected IJsonConvert jsonConvert =new JsonConvert();
	
	private Find() {
		
	}
	
	public static Find getInstance() {
		
		if (find == null) {
			find = new Find();
		}
		return find;
	}
	
	@Override
	public Object find(Integer id, Object object) throws NullPointerException, FileNotFoundException, SQLException, IOException  {
		
		Object[][] conditions= {{"id","=",id,null}};
		String query=constructorSelect.finalQuery(object, null, conditions, null);
		return this.convertToObject(object, query);
	}
	
	@Override
	public Object find(Integer id, Object object, String[] fields) throws NullPointerException, FileNotFoundException, SQLException, IOException {
		
		Object[][] conditions= {{"id","=",id,null}};
		String query=constructorSelect.finalQuery(object, fields, conditions, null);
		
		return this.convertToObject(object, query);
	}
	@Override
	public Object find(Object[][] conditions, Object object) throws NullPointerException, FileNotFoundException, SQLException, IOException {
	
		String query=constructorSelect.finalQuery(object,null, conditions,null);
		return this.convertToObject(object, query);
	}
	@Override
	public Object find(Object[][] conditions, Object object, String[] fields) throws NullPointerException, FileNotFoundException, SQLException, IOException {
		
		String query=constructorSelect.finalQuery(object, fields, conditions, null);
		return this.convertToObject(object, query);
	}
	
	
	private Object convertToObject(Object object,String query) throws NullPointerException, SQLException, FileNotFoundException, IOException, 
	NotFoundException {
	
		
		Object objectFind=null;
		String jsonObject;
		
		jsonObject = jsonConvert.getArrayStringJson(query, object)[0];
		if (jsonObject==null){
			String message;
			message="No se encontró lo que buscaba en los registros";
			NotFoundException ex=new NotFoundException(message+" "+TablesDataProperties.getTableName(object));
			throw ex;
		}
		
		
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	    objectFind=gson.fromJson(jsonObject, object.getClass());
		return objectFind;

	}
		
	
	


}
