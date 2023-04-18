package com.pritam.demorest;



import java.util.ArrayList;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("Aliens")
public class AlienResource {
	AlienRepository AlienRepo=new AlienRepository();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ArrayList<Alien> getAliens() {
		
		System.out.println("get alien is getting called .....");
		return AlienRepo.getAllAliens();
	}
	
	@GET
	@Path("Alien/{age}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ArrayList<Alien> getAlien(@PathParam("age") int age) {
		
		System.out.println("get alien is getting called .....");
		return AlienRepo.getAlien(age);
	}
	
	
	@POST
	@Path("Alien")
	public Alien createAlien(Alien al) {
		AlienRepo.createAlien(al);
		return al;
		
	}

}
