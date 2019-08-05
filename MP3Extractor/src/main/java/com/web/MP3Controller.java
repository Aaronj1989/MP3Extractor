package com.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
//this is eccentially a servlet
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.database.MP3DaoImpl;
import com.lumar.mp3extractor.MP3;
import com.lumar.mp3extractor.MP3Extractor;

@Controller
@RequestMapping("/")
public class MP3Controller {

	@Autowired
	MP3DaoImpl mp3Dao;
	@Autowired
	MP3Extractor mp3Extractor;
	

	public MP3Controller() {

	}

	// returns submit path view
	@RequestMapping(method = GET)
	public String getPathSubmition(Model model) {
		MP3Extractor mp3Extractor = new MP3Extractor();
		
		model.addAttribute("mp3Extractor", mp3Extractor);

		return "submitpath";
	}

	// user submits path to be processed for extracting mp3 data in a table
	@RequestMapping(method = POST)

	public String processUserPath(RedirectAttributes model,@Valid @ModelAttribute("mp3Extractor") MP3Extractor mp3Extractor,BindingResult errors
			) {

		if (errors.hasErrors()) {
   
			return "submitpath";
		}

		
		mp3Extractor.selectMP3Files();
		mp3Extractor.saveMp3Data(mp3Dao);
		List<MP3> mp3List = mp3Extractor.getMP3List();
		
		model.addFlashAttribute("mp3List", mp3List);

		return "redirect:/mp3data";
	}
//might have to use flash attribute to get the redirect. 
	// returns view mp3ListView.jsp
	@RequestMapping(value = "/mp3data", method = GET)
	public String showMP3List(Model m) {
       
		m.addAttribute("mp3Extractor",mp3Extractor);
	
		return "mp3ListView";
	}
	
	
	//user hits show all link and this calls the showmp3List method
	@RequestMapping(value ="/showAllMp3Data", method = GET)
	public String showAllMp3s(Model m) {
		
		
	List<MP3> mp3List = mp3Extractor.getAllMP3s(mp3Dao);

    m.addAttribute("mp3Extractor", mp3Extractor);
	m.addAttribute("mp3List", mp3List);
	System.out.println(mp3List.size());
     return "mp3ListView";
	}
	
}
