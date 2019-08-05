package com.database;

import java.util.List;

import com.lumar.mp3extractor.MP3;

public abstract class MP3DAO {

	
	public abstract boolean dataExists(MP3 mp3);
	
	public abstract void addData(MP3 mp3);
	
	public abstract void removeData(MP3 mp3);

	public abstract List getData();
	
	
}
