package com.cloudcode.push.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.cloudcode.framework.controller.CrudController;
import com.cloudcode.framework.rest.ReturnResult;
import com.cloudcode.framework.service.ServiceResult;
import com.cloudcode.framework.utils.BeanUpdater;
import com.cloudcode.framework.utils.PageRange;
import com.cloudcode.framework.utils.PaginationSupport;
import com.cloudcode.framework.utils.UUID;
import com.cloudcode.push.dao.RemindInfDao;
import com.cloudcode.push.hndler.SystemWebSocketHandler;
import com.cloudcode.push.model.RemindInf;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@Controller
@RequestMapping({ "/remindInf" })
public class RemindInfController extends CrudController<RemindInf> {
	@Autowired
	private RemindInfDao remindInfDao;
	@Autowired
	private SystemWebSocketHandler systemWebSocketHandler;
	
	@RequestMapping(value = "/loadAll", method = RequestMethod.POST)
	public List<RemindInf> LoadAll() {
		return remindInfDao.loadAll();
	}

	@RequestMapping(value = "RemindInfslist.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Object getRemindInfList() {
		Gson gson = new Gson();
		JSONObject jsonObject = new JSONObject();
		JsonArray js = new JsonArray();
		try {
			jsonObject.put("page", 1);
			jsonObject.put("records", 1);
			jsonObject.put("total", 1);
			jsonObject.put("rows","{\"action\":\"e32324\",\"id\":\"cfbbd713ee3e4d90aeda010ae4f3f075\"}"
					);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		TextMessage returnMessage = new TextMessage(""
				+ "测试成功！！！"+jsonObject.toString());
		systemWebSocketHandler.sendMessageToUsers(returnMessage);
		//wss.sendMessage(returnMessage);
		//System.out.println(gson.toJson(remindInfDao.getAll()));
		return jsonObject.toString();
	}

	@RequestMapping(value = "/addRemindInf", method = RequestMethod.POST)
	public @ResponseBody
	void addRemindInf(@RequestBody RemindInf futuresType) {
		futuresType.setId(UUID.generateUUID());
		//remindInfDao.addRemindInf(futuresType);
	}


	@RequestMapping(value = "/createRemindInf", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody
	void createRemindInf(@ModelAttribute  @Valid RemindInf futuresType, HttpServletRequest request) {
		String text = request.getParameter("text");
		futuresType.setId(UUID.generateUUID());
		//remindInfDao.addRemindInf(futuresType);
	}

	@RequestMapping(value = "/{id}/updateRemindInf", method = { RequestMethod.POST,
			RequestMethod.GET })
	public @ResponseBody
	Object updateRemindInf(@PathVariable("id") String id,
			@ModelAttribute RemindInf updateObject, HttpServletRequest request) {
		RemindInf futuresType = null;//remindInfDao.loadObject(id);
		if (futuresType != null) {
			BeanUpdater.copyProperties(updateObject, futuresType);
			// org.springframework.beans.BeanUtils.copyProperties(updateObject,
			// futuresType);
			//remindInfDao.updateObject(futuresType);
			return new ServiceResult(ReturnResult.SUCCESS);
		}
		return null;
	}

	@RequestMapping(value = "toRemindInf")
	public ModelAndView toRemindInf() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("classpath:com/cloudcode/push/ftl/remind/list.ftl");
		modelAndView.addObject("result", "cloudcode");
		return modelAndView;
	}

	@RequestMapping(value = "create")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("classpath:com/cloudcode/push/ftl/remind/detail.ftl");
		modelAndView.addObject("result", "cloudcode");
		modelAndView.addObject("entityAction", "create");
		return modelAndView;
	}

	@RequestMapping(value = "/{id}/update")
	public ModelAndView update(@PathVariable("id") String id) {
		RemindInf futuresType =null;// remindInfDao.loadObject(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("classpath:com/cloudcode/push/ftl/remind/detail.ftl");
		modelAndView.addObject("futuresType", futuresType);
		modelAndView.addObject("result", "cloudcode");
		modelAndView.addObject("entityAction", "update");
		return modelAndView;
	}
	
	@RequestMapping(value = "query", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	PaginationSupport<RemindInf> query(RemindInf futuresType, PageRange pageRange) {
		PaginationSupport<RemindInf> futuresTypes = remindInfDao
				.queryPagingData(futuresType, pageRange);
		return futuresTypes;
	}
	@RequestMapping(value = "/deleteAll")
	public @ResponseBody Object deleteAll(HttpServletRequest request) {
		String ids = request.getParameter("ids");
		String[] arrayId = ids.split(",");
		for(String id:arrayId){
			 remindInfDao.deleteObject(id);
		}
		return new ServiceResult(ReturnResult.SUCCESS);
	}
	@RequestMapping(value = "queryData", method = {
			RequestMethod.POST, RequestMethod.GET }, produces = "application/json")
	public @ResponseBody
	PaginationSupport<RemindInf> queryData(HttpServletRequest request) {
		String exchange = request.getParameter("exchange");
		String groupType = request.getParameter("groupType");
		RemindInf futuresType = new RemindInf();
		PageRange pageRange = new PageRange(0,0,100);
		PaginationSupport<RemindInf> futuresTypes = remindInfDao.queryPagingData(futuresType, pageRange);
		return futuresTypes;
	}
}
