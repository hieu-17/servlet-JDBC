package com.example.service;

import java.util.List;

import com.example.model.NewModel;
import com.example.paging.Pageble;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel updateNew);
	void delete(Long[] ids);
	List<NewModel> findAll(Pageble pageble);
	int getTotalItem();
}
