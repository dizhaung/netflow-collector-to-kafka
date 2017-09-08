package com.netflow.bean.V5;

import java.util.ArrayList;
import java.util.List;


public class NetFlowV5Packet {
	private NetFlowV5Header header;
	private List<NetFlowV5Record> records = new ArrayList<NetFlowV5Record>(50);
	private long dataLength;

	public NetFlowV5Packet() {
	}

	public NetFlowV5Packet(NetFlowV5Header header, List<NetFlowV5Record> records, long dataLength) {
		this.header = header;
		this.records = records;
		this.dataLength = dataLength;
	}

	public NetFlowV5Header getHeader() {
		return header;
	}

	public void setHeader(NetFlowV5Header header) {
		this.header = header;
	}

	public List<NetFlowV5Record> getRecords() {
		return records;
	}

	public void setRecords(List<NetFlowV5Record> records) {
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
