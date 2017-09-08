package com.netflow.bean.V9;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 0.1.0
 * @author xeraph
 */
public class NetFlowV9OptionTemplate {
	private int templateId;

	private List<NetFlowV9ScopeDef> scopeDefs = new ArrayList<NetFlowV9ScopeDef>();
	private List<NetFlowV9FieldDef> optionDefs = new ArrayList<NetFlowV9FieldDef>();

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public List<NetFlowV9ScopeDef> getScopeDefs() {
		return scopeDefs;
	}

	public void setScopeDefs(List<NetFlowV9ScopeDef> scopeDefs) {
		this.scopeDefs = scopeDefs;
	}

	public List<NetFlowV9FieldDef> getOptionDefs() {
		return optionDefs;
	}

	public void setOptionDefs(List<NetFlowV9FieldDef> optionDefs) {
		this.optionDefs = optionDefs;
	}
}
