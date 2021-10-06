package io.javabrains.springbootconfigs;

import io.javabrains.springbootconfigs.model.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingsController {
// 3 different ways to use @Value
    @Value("${my.greetings}")
    private String greetingsMessage;

//    @Value("${my.greetings : Hi from default value}")
//    private String greetingsMessage;

//    @Value("Hi from hardcoded values}")
//    private String greetingsMessage;

    //get values from bean & Autowiring
    @Autowired
    private DbSettings dbSettings;

    //get configs in list
    @Value("${multiple.values}")
    private List<String> multiValue;

    //get configs in key val pair..i.e map
    @Value("#{${dbValues}}")
    private Map<String,String> dbvalues;

    @GetMapping("/greetings")
    public String getGreetings(){

//        return greetingsMessage+" multiple values: "+multiValue+" dbvaluesin key pair: "+dbvalues;
        return "connectionUrl: "+dbSettings.getUrl()+" username: "+dbSettings.getUsername() +" password : "+dbSettings.getPassword();

    }


}
