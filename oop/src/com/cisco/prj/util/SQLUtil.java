package com.cisco.prj.util;

import java.lang.reflect.Method;

import com.cisco.prj.annotations.Column;
import com.cisco.prj.annotations.Table;

public class SQLUtil {
	// Product.class
	public static String generateCreateSQL(Class<?> clazz) {
		StringBuilder builder = new StringBuilder();
			Table table = clazz.getAnnotation(Table.class);
			if(table != null) {
				builder.append("create table ");
				builder.append(table.name());
				builder.append("(");
				Method[] methods = clazz.getDeclaredMethods();
				for(Method m : methods) {
					if(m.getName().startsWith("get")) {
						Column col = m.getAnnotation(Column.class);
						if( col != null) {
							builder.append(col.name());
							builder.append(" ");
							builder.append(col.type());
							builder.append(",");
						}
					}
				}
				builder.setCharAt(builder.lastIndexOf(","), ')');
			}
		
		return builder.toString();  // create table products(prd_id NUMERIC(10), prd_name VARCHAR(255),
	}
}
