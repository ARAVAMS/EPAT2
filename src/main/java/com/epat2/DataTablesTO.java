package com.epat2;

import java.util.List;

public class DataTablesTO<T> implements java.io.Serializable{

	private static final long serialVersionUID = -8220588043068200705L;
	private List<T> aaData;
	private int sEcho;
	private Integer iTotalRecords;
	private Integer iTotalDisplayRecords;
	private Integer sLimit ;
	private Integer iDisplayStart;
	private Integer iDisplayLength;
	private Integer iSortingCols;
	private Integer asSorting;
	
	public Integer getAsSorting() {
		return asSorting;
	}
	public void setAsSorting(Integer asSorting) {
		this.asSorting = asSorting;
	}
	public List<T> getAaData() {
		return aaData;
	}
	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}
	public int getsEcho() {
		return sEcho;
	}
	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}
	public Integer getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public Integer getsLimit() {
		return sLimit;
	}
	public void setsLimit(Integer sLimit) {
		this.sLimit = sLimit;
	}
	public Integer getiDisplayStart() {
		return iDisplayStart;
	}
	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	public Integer getiDisplayLength() {
		return iDisplayLength;
	}
	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	public Integer getiSortingCols() {
		return iSortingCols;
	}
	public void setiSortingCols(Integer iSortingCols) {
		this.iSortingCols = iSortingCols;
	}
	
	}
