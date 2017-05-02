package com.bdqn.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * SpringMVC日期转换器
 * @author weishi
 *
 */
public class DateConverter implements Converter<String,Date>{

	private SimpleDateFormat[] sdf=
			{new SimpleDateFormat("yyyy-MM-dd"),
			 new SimpleDateFormat("yyyy/MM/dd"),
			 new SimpleDateFormat("yyyy年MM月dd日")
			};
	
	@Override
	public Date convert(String str) {
		for (int i = 0; i < sdf.length; i++) {
			try{
				return sdf[i].parse(str);
			}catch(Exception ex){
				continue;
			}
		}
		return null;
	}

}
