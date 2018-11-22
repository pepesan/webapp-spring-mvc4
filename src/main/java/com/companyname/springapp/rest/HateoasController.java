package com.companyname.springapp.rest;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


//TODO: Pendiente de corrección
@RestController
public class HateoasController {
    @RequestMapping("/hateoas/uno")
    Resource<Dato> one() {

        Dato dato= new Dato();

        return new Resource<Dato>(dato,
                linkTo(methodOn(HateoasController.class).one()).withSelfRel(),
                linkTo(methodOn(HateoasController.class).all()).withRel("employees"));
    }
    @RequestMapping("/hateoas/")
    Resources<Resource<Dato>> all() {
        List<Resource<Dato>> listado = new ArrayList<Resource<Dato>>();
        for (int i = 0; i < 10; i++) {
            Dato dato= new Dato();
            dato.setCadena("Mi cadena "+i);
            Resource<Dato> recurso=new Resource<Dato>(dato);
            listado.add(recurso);
        }


        return new Resources<>(listado
                //,linkTo(methodOn(HateoasController.class).all()).withSelfRel()
        );
    }

}
