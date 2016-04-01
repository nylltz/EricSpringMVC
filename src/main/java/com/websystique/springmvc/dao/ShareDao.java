package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Share;

public interface ShareDao {

	Share findById(int id);

	void saveShare(Share employee);
	
	List<Share> findAllShares();


}
