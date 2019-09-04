package cn.itcast.pojo;

import java.util.List;

/**
 * @Author: badbad
 * @Date: 2019/9/4 14:05
 * @Version 1.0
 */
public class PageBean<T> {
    private int currPage;
    private int pageSize;
    private int totalPage;
    private int totalCount;
    private List<T> list;

    public PageBean() {
    }

    /**
     * 提供四个参数的构造
     * @param currPage
     * @param pageSize
     * @param totalCount
     * @param list
     */
    public PageBean(int currPage, int pageSize, int totalCount, List<T> list) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.list = list;
    }

    /**
     * get方法计算总页数
     * @return
     */
    public int getTotalPage() {
        return (int) Math.ceil((totalCount*1.0)/pageSize);
    }

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

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
