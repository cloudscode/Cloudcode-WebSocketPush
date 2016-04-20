package com.cloudcode.push.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cloudcode.framework.model.BaseModelObject;
import com.cloudcode.push.ProjectConfig;

@Entity(name = ProjectConfig.NAME + "remind")
@Table(name = ProjectConfig.NAME + "_remind")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class RemindInf extends BaseModelObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5252306475971118021L;
	private String name;
	private String contents;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
