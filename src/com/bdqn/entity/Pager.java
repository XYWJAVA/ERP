package com.bdqn.entity;

public class Pager {
	
	private int currPage=1;//当前页数
	
	private int pageSize=5;//每页大小
	
	private int totalCounts;//总记录数
	
	private int totalPages;//总页数

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCounts() {
		return totalCounts;
	}
    //设置总记录数时，自动计算出总页数
	public void setTotalCounts(int totalCounts) {
		this.totalCounts = totalCounts;
		if(totalCounts==0){
			this.totalPages=0;//没有记录直接为0页
		}else{
			this.totalPages=(this.totalCounts-1)/this.pageSize+1;//计算总页数
		}
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
	

}
