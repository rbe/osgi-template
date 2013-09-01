package eu.artofcoding.myservice.impl;

import eu.artofcoding.myservice.api.MyData;
import eu.artofcoding.myservice.api.MyService;

public class MyServiceImpl implements MyService {

    @Override
    public String sayHello(MyData myData) {
        String s = String.format("Hello from %s#sayHello(), %s %s", this, myData.getFirstname(), myData.getLastname());
        return s;
    }

}
