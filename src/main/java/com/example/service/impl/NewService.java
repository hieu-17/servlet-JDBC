package com.example.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.example.dao.INewDAO;
import com.example.model.NewModel;
import com.example.paging.Pageble;
import com.example.service.INewService;

public class NewService implements INewService{
	@Inject
	private INewDAO newDAO;
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDAO.findByCategoryId(categoryId);
	}
	@Override 
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		Long newId = newDAO.save(newModel);
		return newDAO.findOne(newId);
	}
	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew =  newDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}
	@Override
	public void delete(Long[] ids) {
		for(long id:ids) {
			//delete comment(for)
			//delete news
			newDAO.delete(id);
		}
		
	}
	@Override
	public List<NewModel> findAll(Pageble pageble) {
		return newDAO.findAll(pageble);
	}
	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
		
	}
	

}
