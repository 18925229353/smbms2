package com.szxs.utils;

import java.util.List;

public class PageUtil<T> {
    private Integer currentPageNo;//当前页码
    private Integer pageSize;//页大小
    private Integer totalRows;//总行数
    private  Integer totalPage;//总页数
    private List<T> dateList;//分页查询后的数据集合

    public Integer getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(Integer currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDateList() {
        return dateList;
    }

    public void setDateList(List<T> dateList) {
        this.dateList = dateList;
    }
}
