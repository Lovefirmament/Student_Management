package pers.ssm.po.utils;

import java.util.List;

public class PageUtil<T> {
	private int pageNumber;
	private int pageCount;
	private int pageCurrent;
	private int pageBefore;
	private int pageAfter;
	private int pagesize;
    private List<T> list;
	public PageUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageUtil(int pageNumber, int pageCount, int pageCurrent, int pageBefore, int pageAfter, int pagesize,
			List<T> list) {
		super();
		this.pageNumber = pageNumber;
		this.pageCount = pageCount;
		this.pageCurrent = pageCurrent;
		this.pageBefore = pageBefore;
		this.pageAfter = pageAfter;
		this.pagesize = pagesize;
		this.list = list;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getPageBefore() {
		return pageBefore;
	}
	public void setPageBefore(int pageBefore) {
		this.pageBefore = pageBefore;
	}
	public int getPageAfter() {
		return pageAfter;
	}
	public void setPageAfter(int pageAfter) {
		this.pageAfter = pageAfter;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
    
}
