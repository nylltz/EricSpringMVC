package com.websystique.springmvc.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Share;
import com.websystique.springmvc.service.ShareService;



@Controller
@RequestMapping("/")
public class AppController {
	final String URL_BASE = "http://finance.yahoo.com/webservice/v1/symbols/###/quote?format=json";
	final String regEx = "[^0-9.]";
	
	@Autowired
	ShareService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing shares.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listShares(ModelMap model) {

		List<Share> shares = service.findAllShares();
		model.addAttribute("shares", shares);
		return "allshares";
	}

	/*
	 * This method will provide the medium to add a new share.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newShare(ModelMap model) {
		Share share = new Share();
		model.addAttribute("share", share);
		model.addAttribute("edit", false);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving share in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveShare(@Valid Share share, BindingResult result,
			ModelMap model) {
		
		if (share.getSymbol() == null | share.getQuantity() <= 0) {
			return "registration";
		}
		String url = URL_BASE.replace("###", share.getSymbol());
		Pattern p = Pattern.compile(regEx);
		try{
			URL yahoofinance = new URL(url);
	        URLConnection data = yahoofinance.openConnection();
	        Scanner input = new Scanner(data.getInputStream());
	        if(input.hasNext()){
	        	input.nextLine();
	        }
	        while(input.hasNextLine()){
	        	String line = input.nextLine();
	        	if (line.contains("price")){
	        		Matcher m = p.matcher(line.split(":")[1]);
	        		BigDecimal price = BigDecimal.valueOf(Double.parseDouble(m.replaceAll("").trim()));
	        		share.setPrice(price);
	        		share.getQuantity();
	        		share.setValue(BigDecimal.valueOf(price.doubleValue() * share.getQuantity()));
	        		}
	            }
	        }catch(Exception e){
	            System.err.println(e);
	        }
		share.setJoiningDate(new LocalDate());
		service.saveShare(share);

		model.addAttribute("success", "Share " + share.getSymbol() + " registered successfully");
		return "success";
	}

}
