package com.netflow.bean.V9;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @since 0.1.0
 * @author xeraph
 */
public class NetFlowV9TemplateCache {
	private Map<Integer, NetFlowV9Template> templates = new ConcurrentHashMap<Integer, NetFlowV9Template>();
	private NetFlowV9OptionTemplate optionTemplate;

	public Map<Integer, NetFlowV9Template> getTemplates() {
		return templates;
	}

	public void setTemplates(Map<Integer, NetFlowV9Template> templates) {
		this.templates = templates;
	}

	public NetFlowV9OptionTemplate getOptionTemplate() {
		return optionTemplate;
	}

	public void setOptionTemplate(NetFlowV9OptionTemplate optionTemplate) {
		this.optionTemplate = optionTemplate;
	}

}
