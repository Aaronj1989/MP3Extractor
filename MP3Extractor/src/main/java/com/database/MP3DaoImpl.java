package com.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.lumar.mp3extractor.MP3;
@Repository
public class MP3DaoImpl extends MP3DAO {

	
	//need jdbcTemplate to reduce code
@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	//if data exists in mp3data table return true else return false.
	public boolean dataExists(MP3 mp3) {
	boolean exists =  false;
	
	String artist = mp3.getArtist();
	String title = mp3.getTitle();
	
	String checkDataQuery = "Select count(*) from mp3data where artist = ? and title = ?";
	
	if(jdbcTemplate.queryForObject(checkDataQuery, new Object[] {artist,title},Integer.class) >=1) {
		exists = true;
	}
		return exists;
	}

	//add extracted mp3 metadata to database
	@Override
	public void addData(MP3 mp3) {
		String title = mp3.getTitle();
		String artist = mp3.getArtist();
		int year = mp3.getYear(); 
		
		System.out.println(title);
		
		String addMp3Query = "INSERT into mp3data (title,artist,year) values(?,?,?)";
	     
		jdbcTemplate.update(addMp3Query,title,artist,year);
	}
          //remove data from database
	@Override
	public void removeData(MP3 mp3) {
		String title = mp3.getTitle();
		String artist = mp3.getArtist();
		
		String deleteMp3Query = "DELETE from mp3data where title = ? and artist = ?";
		
		jdbcTemplate.update(deleteMp3Query, title, artist);
	}
	
	//returns a list of MP3 objects. 
	public List<MP3> getData() {
		System.out.println(jdbcTemplate);
	 String getMp3Query = "Select * from mp3data";
	 
	 List <MP3> mp3List = jdbcTemplate.query(getMp3Query, new BeanPropertyRowMapper<MP3>(MP3.class));
	 
	return mp3List;	
		
		
	}
	
	
	
}
