package com.example.springboot6.springboot6.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Art {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String lot_title;
	private String artist; 
	private String yop;

	public Art() {
	}

	public Art(String lot_title, String artist, String yop) {
		this.lot_title = lot_title;
		this.artist = artist;
		this.yop = yop;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getLot_title() {
		return lot_title;
	}

	public void setLot_title(String lot_title) {
		this.lot_title = lot_title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getYop() {
		return yop;
	}

	public void setYop(String yop) {
		this.yop = yop;
	}
}
