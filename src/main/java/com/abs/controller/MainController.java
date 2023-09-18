package com.abs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController  implements ServletContextAware {
	private static final String APPLICATION_PDF = "application/pdf";

	
@RequestMapping(value="/")
public ModelAndView  loadHomePage(HttpServletRequest request,HttpServletResponse response) {
	
	return new ModelAndView("defaultHomePage");

}


@RequestMapping(value="/downloadImage", method = RequestMethod.GET, produces = APPLICATION_PDF)
public @ResponseBody void downloadImage(HttpServletResponse response) { 
	try{
		File file = new File("D:\\ABS\\src\\main\\webapp\\WEB-INF\\resources\\images\\band1.jpg");
	    InputStream in = new FileInputStream(file);
	    response.setContentType(APPLICATION_PDF);
	    response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
	    response.setHeader("Content-Length", String.valueOf(file.length()));
	    FileCopyUtils.copy(in, response.getOutputStream());

      } catch(IOException e) {
         System.out.println("Exception: " + e.getMessage());
      }
	
}











@Override
public void setServletContext(ServletContext servletContext) {
	try 
	{
//		generateMenuXmlRoleWise(servletContext);
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
}


	
}




