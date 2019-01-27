package com.fangbo.spring.struct2.actions;

import com.fangbo.spring.struct2.services.PersonService;

public class PersonAction {

    private PersonService personService;

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public String execute(){
        System.out.println("execute....");
        personService.save();
        return "success";
    }

}
