package top.yigege.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName:  PageVo   
 * @Description:分页对象
 * @author: yigege
 * @date:   2018年12月16日 上午10:48:43
 */
public class PageVo {

    //总记录数
    private Integer totalCount = 0;

    //总页数
    private Integer totalPage;

    //每页大小
    private Integer pageSize = 10;

    //当前页码
    private Integer pageNumber = 1;

    //查询结果
    private Map<String, Object> results = new HashMap<>();

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Map<String, Object> getResults() {
        return results;
    }

    public void setResults(Map<String, Object> results) {
        this.results = results;
    }

    public Integer getFirstResult() {
        return (this.pageNumber - 1) * this.pageSize;
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", results=" + results +
                '}';
    }
}
