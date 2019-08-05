package com.database;

import static org.junit.Assert.assertEquals;

import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.config.RootConfig;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.lumar.mp3extractor.MP3;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("/sampleData.xml")
public class MP3DaoTest {

	
	@Autowired
   private MP3DaoImpl mp3Dao;
	
	@Test
	public void testDataExists() throws Exception{

		MP3 mp3 = new MP3();
		mp3.setTitle("Anyway you want it");
		mp3.setArtist("Journey");
		mp3.setYear(1980);
		
		boolean dataExists = mp3Dao.dataExists(mp3);
		assertEquals(true, dataExists);
	
		
	}

	 protected DatabaseOperation getSetUpOperation() throws Exception {
	        return DatabaseOperation.REFRESH;
	    }
	 
	    protected DatabaseOperation getTearDownOperation() throws Exception {
	        return DatabaseOperation.NONE;
	    }
}
