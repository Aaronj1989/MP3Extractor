package com.lumar.mp3extractor;

public class MP3 {

	
	public MP3(String title, String artist, int year) {
		this.title = title;
		this.artist = artist;
		this.year = year;
	}
	
	public MP3() {}
	
	private String title;
	private String artist;
	private int year;
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}





