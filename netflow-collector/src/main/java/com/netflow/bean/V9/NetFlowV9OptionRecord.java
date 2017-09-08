package com.netflow.bean.V9;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 0.1.0
 * @author xeraph
 */
public class NetFlowV9OptionRecord extends NetFlowV9Record {
	private Map<Integer, Object> scopes = new HashMap<Integer, Object>();

	public Map<Integer, Object> getScopes() {
		return scopes;
	}

	public void setScopes(Map<Integer, Object> scopes) {
		this.scopes = scopes;
	}
}
