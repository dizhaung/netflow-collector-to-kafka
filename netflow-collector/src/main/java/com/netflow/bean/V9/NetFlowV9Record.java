package com.netflow.bean.V9;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 0.1.0
 * @author xeraph
 */
public class NetFlowV9Record {
	private Map<String, Object> fields = new HashMap<String, Object>();

	public Map<String, Object> getFields() {
		return fields;
	}

	public void setFields(Map<String, Object> fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "record " + fields;
	}
}
