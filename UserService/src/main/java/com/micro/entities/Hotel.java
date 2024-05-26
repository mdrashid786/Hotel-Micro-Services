package com.micro.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Hotel {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String name;

	    private String location;

	    private String about;

		public Hotel() {
			super();
		}

		public Hotel(Long id, String name, String location, String about) {
			super();
			this.id = id;
			this.name = name;
			this.location = location;
			this.about = about;
		}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getLocation() {
			return location;
		}



		public void setLocation(String location) {
			this.location = location;
		}



		public String getAbout() {
			return about;
		}



		public void setAbout(String about) {
			this.about = about;
		}
	    
		
	    

}
