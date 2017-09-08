package com.netflow.bean.V9;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 0.1.0
 * @author xeraph
 */
public class NetFlowV9Packet {
	private NetFlowV9Header header;
	private List<NetFlowV9Template> templates = new ArrayList<NetFlowV9Template>();
	private NetFlowV9OptionTemplate optionTemplate;
	private List<NetFlowV9Record> records = new ArrayList<NetFlowV9Record>();
	private long dataLength;

	public NetFlowV9Header getHeader() {
		return header;
	}

	public void setHeader(NetFlowV9Header header) {
		this.header = header;
	}

	public List<NetFlowV9Template> getTemplates() {
		return templates;
	}

	public void setTemplates(List<NetFlowV9Template> templates) {
		this.templates = templates;
	}

	public NetFlowV9OptionTemplate getOptionTemplate() {
		return optionTemplate;
	}

	public void setOptionTemplate(NetFlowV9OptionTemplate optionTemplate) {
		this.optionTemplate = optionTemplate;
	}

	public List<NetFlowV9Record> getRecords() {
		return records;
	}

	public void setRecords(List<NetFlowV9Record> records) {
		this.records = records;
	}

	public long getDataLength() {
		return dataLength;
	}

	public void setDataLength(long dataLength) {
		this.dataLength = dataLength;
	}

	@Override
	public String toString() {
		return header.toString();
	}
}
