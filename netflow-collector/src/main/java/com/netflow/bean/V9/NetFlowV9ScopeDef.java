package com.netflow.bean.V9;

/**
 * @since 0.1.0
 * @author xeraph
 */
public class NetFlowV9ScopeDef {
	public static final int SYSTEM = 1;
	public static final int INTERFACE = 2;
	public static final int LINECARD = 3;
	public static final int NETFLOW_CACHE = 4;
	public static final int TEMPLATE = 5;

	private int type;
	private int length;

	public NetFlowV9ScopeDef(int type, int length) {
		this.type = type;
		this.length = length;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
