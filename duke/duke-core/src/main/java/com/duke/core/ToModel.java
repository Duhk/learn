package com.duke.core;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.jdbc.core.RowMapper;

public class ToModel<T> implements RowMapper{
	Class<T> clazz;
	@Override
	public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		setValues(arg0, arg1);
		return clazz;
	}
	public static Object setValues(HashMap<String, Object> map, Object entity) {  
        Field[] fields = entity.getClass().getDeclaredFields();  
        for (Field field : fields) {  
	        try {
                Object value = map.get(field.getName());
                if (value != null) {
                    field.setAccessible(true);  
                    field.set(entity, value);  
                }
	        } catch (IllegalArgumentException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (IllegalAccessException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
        }  
        return entity;  
    }  
  
    public void setValues(ResultSet rs, Object entity) {  
        Field[] fields = clazz.getDeclaredFields();  
        try {  
            for (Field field : fields) {  
                Object value = rs.getObject(field.getName());  
                field.setAccessible(true);  
                field.set(entity, value);  
            }  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IllegalArgumentException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IllegalAccessException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
      
}
