package com.lumar.mp3extractor;

import java.io.*;

import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.metadata.XMPDM;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.database.MP3DAO;
import com.lumar.validation.DirectoryPath;

//this class extracts data from the mp3 and then places that data in an MP3 list.
@Component
public class MP3Extractor {

	public MP3Extractor() {

	}

	@DirectoryPath
	private String path;
	    
  
	private List<MP3>mp3List = new ArrayList<MP3>();

	//takes an mp3 file that was passed to it and parses its data. 
	public void extract(File file) throws IOException, SAXException, TikaException  {
		 //detecting the file type
	      BodyContentHandler handler = new BodyContentHandler();
	      Metadata metadata = new Metadata();
	      FileInputStream inputstream = new FileInputStream(file);
	      ParseContext pContext = new ParseContext();
	      
	      //Mp3 parser
	      Mp3Parser  Mp3Parser = new  Mp3Parser();
	      Mp3Parser.parse(inputstream, handler, metadata, pContext);
	      
	    
	      String title = metadata.get(TikaCoreProperties.TITLE);
	      System.out.println(title);
	      String artist = metadata.get(TikaCoreProperties.CREATOR);
	      int year = Integer.parseInt(metadata.get(XMPDM.RELEASE_DATE));

	      mp3List.add(new MP3(title,artist,year));
		
	}
	
	//collects mp3 files from the given path property and then extracts their metadata 
	public void selectMP3Files() {
		File dir = new File(path);
		String[] extensions = new String[] {"mp3"};
		List<File> files = (List<File>) FileUtils.listFiles(dir,extensions,true);
		
		for(File file:files) {
			try {
		    extract(file);
			} catch(Exception e) {e.printStackTrace();}
		}
	
	}
	
	public List getAllMP3s(MP3DAO mp3Dao) {
	   
		return mp3Dao.getData();
		
		
	}
	
	//saves MP3 metadata to database table if it doesn't already exist 
	public void saveMp3Data(MP3DAO mp3Dao) {

		for(MP3 mp3:mp3List) {
						
			if(!mp3Dao.dataExists(mp3)){
				mp3Dao.addData(mp3);
			}
		}
		
	}
	
	
	public String getPath() {
		return this.path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public List<MP3> getMP3List() {
		return mp3List;
	}

	public  MP3DAO getMp3Dao() {
		return null;
	}
	
	public List<MP3> getMp3List() {
		return null;
		//return mp3Dao.getData();
	}

	
}
