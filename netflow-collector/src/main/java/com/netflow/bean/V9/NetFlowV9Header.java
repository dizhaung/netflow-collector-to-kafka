package com.netflow.bean.V9;

public class NetFlowV9Header {
	// 2bytes, 9
	private int version;

	// 2bytes, both template and flow count
	private int count;

	// 4bytes
	private long sysUptime;

	// 4bytes, seconds since 0000 Coordinated Universal Time (UTC) 1970
	private long unixSecs;

	// 4bytes, Incremental sequence counter of all export packets sent by this
	// export device; this value is cumulative, and it can be used to identify
	// whether any export packets have been missed
	private long sequence;

	// 4bytes
	private long sourceId;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getSysUptime() {
		return sysUptime;
	}

	public void setSysUptime(long sysUptime) {
		this.sysUptime = sysUptime;
	}

	public long getUnixSecs() {
		return unixSecs;
	}

	public void setUnixSecs(long unixSecs) {
		this.unixSecs = unixSecs;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public long getSourceId() {
		return sourceId;
	}

	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}

	@Override
	public String toString() {
		return "ver=" + version + ", count=" + count + ", sys_uptime=" + sysUptime + ", unixsecs=" + unixSecs + ", seq="
				+ sequence + ", source=" + sourceId;
	}
}
