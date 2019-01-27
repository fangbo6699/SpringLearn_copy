package com.fangbo.spring.factory;

import java.util.HashMap;
import java.util.Map;

public class StaticCarFactory {
    public static Map<String,Car> cars=new HashMap<String, Car>();
     static {
        cars.put("baoma",new Car("baoma","300000"));
        cars.put("peichi",new Car("peichi","60000"));
    }
    public static Car getCar(String name){
         return cars.get(name);
    }
}
