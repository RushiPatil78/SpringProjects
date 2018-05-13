package com.rushikesh.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext applicationContext;
    
    public static ApplicationContext getApplicationContext(){
        if(applicationContext==null){
            applicationContext = new ClassPathXmlApplicationContext("springbeans.xml");
        }
        return applicationContext;
    }

}
