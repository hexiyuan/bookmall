package core.domain;

import java.util.List;

/**
 * 该po类用来封装分页的查询结果
 * @author user
 */
public class PageBean {
	
	private List<Book> list;	//list中存放book的相关信息（数据库取）
	private int totalrecord;	//总记录数（数据库取）
	
	private int pagesize ;	//页面大小（页面获得）
	private int currentpage;	//当前页（页面获得）
	
	private int previouspage;	//前一页（计算获得：当前页-1）
	private int nextpage;		//后一页（计算获得：当前页+1）
	private int totalpage;		//总页数(计算获得：)
	private int[] pagebar;		//页码数组（计算得出：）
	
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalpage() {
		
		if(this.totalrecord%this.pagesize==0){
			this.totalpage = this.totalrecord/this.pagesize;
		}else{
			this.totalpage = this.totalrecord/this.pagesize + 1;
		}
		return totalpage;
	}
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPreviouspage() {
		if(this.currentpage-1>1){
			this.previouspage = this.currentpage-1;
		}else{
			this.previouspage = 1;
		}
		return previouspage;
	}
	
	public int getNextpage() {
		if(this.currentpage+1>this.totalpage){
			this.nextpage = this.totalpage;
		}else{
			this.nextpage = this.currentpage+1;
		}
		return nextpage;
	}
	
	public int[] getPagebar() {
		
		int startpage;
		int endpage;
		if(this.totalpage<=10){
			startpage = 1;
			endpage = this.totalpage;
		}else{
			startpage = this.currentpage -4;
			endpage = this.currentpage + 5;
			
			if(startpage<1){
				startpage = 1;
				endpage = 10;
			}
			if(endpage>totalpage){
				endpage = totalpage;
				startpage = totalpage -9;
			}
		}
		
		this.pagebar = new int[endpage-startpage+1];  //1  3
		int index = 0;
		for(int i=startpage;i<=endpage;i++){
			this.pagebar[index++] = i;
		}
		return pagebar;
	}

}
