package com.fangbo.spring.factory;

import java.util.HashMap;
import java.util.Map;
//通过实力化工厂的方法来返回bean实例，
// 先要实例化工厂对象实列，然后调用工厂实例的方法来返回bean对象
public class InstanceCarFactory {
    private Map<String,Car> cars=null;
    public InstanceCarFactory(){
        cars=new HashMap<String, Car>();
        cars.put("aotuo",new Car("aotuo","65000"));
        cars.put("yatuo",new Car("yatuo","96000"));
    }
    public Car getCar(String brand){
        return  cars.get(brand);
    }

}
