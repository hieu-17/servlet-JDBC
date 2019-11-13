package com.example.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.NewModel;
import com.example.service.INewService;
import com.example.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet{
	@Inject
	private INewService newService;
	private static final long serialVersionUID = -8525723921004852926L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		NewModel newModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);//convert json to model
		newModel =  newService.save(newModel);
		mapper.writeValue(res.getOutputStream(), newModel);//model to json
		
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();res.setContentType("application/json");
		NewModel updateNew = HttpUtil.of(req.getReader()).toModel(NewModel.class);//convert json to model
		updateNew = newService.update(updateNew);
		mapper.writeValue(res.getOutputStream(), updateNew);//model to json
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		NewModel newModel = HttpUtil.of(req.getReader()).toModel(NewModel.class);//convert json to model
		newService.delete(newModel.getIds());
		mapper.writeValue(res.getOutputStream(), "{}");//model to json
	}

}
