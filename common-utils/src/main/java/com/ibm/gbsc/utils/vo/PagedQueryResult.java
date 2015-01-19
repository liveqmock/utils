package com.ibm.gbsc.utils.vo;

import java.util.List;

/**
 * 查询结果基类.
 * 
 * @author Johnny
 * 
 * @param <T>
 *            要返回的对象类型
 */
public class PagedQueryResult<T> {
	private List<T> datas;

	private Boolean isLastPage;

	private Integer recordCount;

	private int pageNumber = 1;

	private int pageSize = 10;

	private Integer pageCount;

	private int indexNumber;

	/**
	 * @param totalDataCount
	 *            总数据件数
	 * @param pageSize
	 *            每页显示条数
	 * @param pageNumber
	 *            当前的页数
	 */
	public PagedQueryResult(int totalDataCount, int pageSize, int pageNumber) {
		super();
		this.recordCount = totalDataCount;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		if (this.pageNumber < 1) {
			this.pageNumber = 1;
		}
		if (this.recordCount <= 0) {
			return;
		}
		// 如果查询页数大于总页数，则取最后一页
		if (this.recordCount <= (this.pageNumber - 1) * this.pageSize) {
			this.pageNumber = (this.recordCount + this.pageSize - 1) / this.pageSize;
		}
		this.indexNumber = (this.pageNumber - 1) * this.pageSize;
		// 总页数
		this.pageCount = (this.recordCount + this.pageSize - 1) / this.pageSize;
		// 是否为最后一页
		this.isLastPage = (this.pageNumber == this.pageCount ? true : false);
	}

	/**
	 * 
	 */
	public PagedQueryResult() {
		super();
	}

	/**
	 * 返回的数据集.
	 * 
	 * @return the datas
	 */
	public List<T> getDatas() {
		return datas;
	}

	/**
	 * @param datas
	 *            the datas to set
	 */
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	/**
	 * 满足查询条件的总记录数， null 意味着未知。注：只在查询第一页时返回正确的总记录数，其它页码时，返回-1.
	 * 
	 * @return the totalDataCount
	 */
	public Integer getRecordCount() {
		return recordCount;
	}

	/**
	 * @param totalDataCount
	 *            the totalDataCount to set
	 */
	public void setRecordCount(Integer totalDataCount) {
		this.recordCount = totalDataCount;
	}

	/**
	 * 页码,从1开始.
	 * 
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber
	 *            the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * 满足查询条件的总页数， null 意味着未知。注：只在查询第一页时返回正确的总记录数，其它页码时，返回-1.
	 * 
	 * @return the pageCount
	 */
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount
	 *            the pageCount to set
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * 每页大小，缺省为10条记录/页.
	 * 
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 标志是否最后一页，True: 是最后一页，False: 不是，null：未知.
	 * 
	 * @return the lastPage
	 */
	public Boolean getIsLastPage() {
		return isLastPage;
	}

	/**
	 * @param lastPage
	 *            the lastPage to set
	 */
	public void setIsLastPage(Boolean lastPage) {
		this.isLastPage = lastPage;
	}

	/**
	 * 计算开始数.
	 * 
	 * @return the indexNumber
	 */
	public int getIndexNumber() {
		return indexNumber;
	}
}
