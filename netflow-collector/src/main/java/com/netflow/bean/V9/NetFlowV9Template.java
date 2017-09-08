package com.netflow.bean.V9;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 0.1.0
 * @author xeraph
 */
public class NetFlowV9Template {
	private int templateId;
	private int fieldCount;
	private List<NetFlowV9FieldDef> definitions = new ArrayList<NetFlowV9FieldDef>();

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public int getFieldCount() {
		return fieldCount;
	}

	public void setFieldCount(int fieldCount) {
		this.fieldCount = fieldCount;
	}

	public List<NetFlowV9FieldDef> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<NetFlowV9FieldDef> definitions) {
		this.definitions = definitions;
	}

	@Override
	public String toString() {
		return "template " + templateId + ", field count=" + fieldCount + ", definitions=" + definitions;
	}

}
