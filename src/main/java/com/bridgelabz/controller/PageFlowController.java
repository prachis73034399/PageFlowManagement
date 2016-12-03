package com.bridgelabz.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.csvRead.CSVReader;
import com.bridgelabz.pageRoute.PageRouteDepth;

@Controller
@RestController
public class PageFlowController
{
	// Creating object of HashMap for SessionId with List of PageId
	HashMap<String, List<String>> sessionWithPageIdHashMap= new HashMap<String, List<String>>();
	HashMap<String, Integer> pageRouteDepthHashMap= new HashMap<String, Integer>();
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public ModelAndView signup(Model model) 
	{	
		return new ModelAndView("upload");
	}
	
	@RequestMapping(value = "savefile", method = RequestMethod.POST)
   	public ModelAndView saveFile(@RequestParam MultipartFile file,Model model) throws FileNotFoundException, IOException
   	{
		PageRouteDepth pageRouteDepthObject= new PageRouteDepth();
		// creating object of CSVReader class`
		CSVReader csvReaderObject = new CSVReader();
		// initializing variable for storing csv file at specific location
		String UPLOAD_DIRECTORY= "/home/bridgeit/Documents/csvUpload";

		// original file path is stored in csvfilePath
		String csvfilePath = UPLOAD_DIRECTORY + "/" + file.getOriginalFilename();
		// uploaded file will be copying in given file path
		FileCopyUtils.copy(file.getBytes(), new FileOutputStream(csvfilePath));
		
		// passing the csvfilePath in csvReadMethod 
		sessionWithPageIdHashMap= csvReaderObject.csvReadMethod(csvfilePath); 

		// using object of Model class adding attribute having attribute name and value
		model.addAttribute("sessionWithPageIdHashMap",sessionWithPageIdHashMap);
		
		return new ModelAndView("session");
	}
	@RequestMapping(value = "pagedepthIdcount", method = RequestMethod.GET)
   	public ModelAndView pagedepthIdcount(Model model) throws FileNotFoundException, IOException
   	{
		// creating object of PageRouteDepth class
		PageRouteDepth pageRouteDepthObject= new PageRouteDepth();
		// creating object of pageRouteDepthHashMap and passing sessionWithPageIdHashMap in the pageDepthIdCount method
		HashMap<String,Integer> depthIdWithPageDepthCount= pageRouteDepthObject.pageDepthIdCount(sessionWithPageIdHashMap);
		System.out.println("Inside The main   "+depthIdWithPageDepthCount);
		// using object of Model class adding attribute having attribute name and value
		model.addAttribute("depthIdWithPageDepthCount",depthIdWithPageDepthCount);
		
		return new ModelAndView("pagejump");
	}

}
