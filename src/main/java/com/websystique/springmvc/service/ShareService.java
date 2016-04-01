package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Share;

public interface ShareService {

	Share findById(int id);
	
	void saveShare(Share employee);
	

	List<Share> findAllShares(); 
	

	
}
