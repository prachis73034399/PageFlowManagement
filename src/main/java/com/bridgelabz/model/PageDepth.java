package com.bridgelabz.model;

public class PageDepth 
{

	private int depthId;
	private int start;
	private int next;
	private int count;
	
	public PageDepth(int depthId, int start, int next)
	{
		super();
		this.depthId = depthId;
		this.start = start;
		this.next = next;
		this.count = 0;
	}
	
	
	public int getDepthId() {
		return depthId;
	}


	public void setDepthId(int depthId) {
		this.depthId = depthId;
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getNext() {
		return next;
	}


	public void setNext(int next) {
		this.next = next;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public int hashCode() {

		return (depthId+":"+start+":"+next).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		PageDepth pd = (PageDepth)obj;
		return (depthId+":"+start+":"+next).equalsIgnoreCase(pd.depthId+":"+pd.start+":"+pd.next);
	}
}
