package com.customers;

import com.remote.api.RemoteApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ray on 2017/6/23.
 */
@Controller
public class Customer {

    @Autowired
    private RemoteApi remoteApi;

    @RequestMapping(value="/say",
            method= RequestMethod.GET,
            produces={"application/json"}
    )
    @ResponseBody
    public String say(String word){
        return remoteApi.say(word);
    }
}
