package com.testre;

import com.remote.api.RemoteApi;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ray on 2017/6/23.
 */
public class RemoteTest {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:customer.xml"});
        context.start();
        RemoteApi remoteApi=(RemoteApi)context.getBean("remoteApi");
        System.out.print(remoteApi.say("Hello"));
    }
}
