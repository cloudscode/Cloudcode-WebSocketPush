package com.cloudcode.push.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudcode.framework.dao.BaseModelObjectDao;
import com.cloudcode.framework.dao.ModelObjectDao;
import com.cloudcode.framework.utils.HQLParamList;
import com.cloudcode.framework.utils.PageRange;
import com.cloudcode.framework.utils.PaginationSupport;
import com.cloudcode.push.ProjectConfig;
import com.cloudcode.push.model.RemindInf;

@Repository
public class RemindInfDao extends BaseModelObjectDao<RemindInf> {
	
	@Resource(name = ProjectConfig.PREFIX + "remindInfDao")
	private ModelObjectDao<RemindInf> remindInfDao;
	
	@Transactional
	public void addRemindInf(RemindInf entity) {
		remindInfDao.createObject(entity);
	}
	public PaginationSupport<RemindInf> queryPagingData(RemindInf hhXtCd, PageRange pageRange) {
		HQLParamList hqlParamList = new HQLParamList();
		List<Object> list=null;
		return this.queryPaginationSupport(RemindInf.class, hqlParamList, pageRange);
	}
}
