package com.hyzs.essearch.vos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @program: es-search
 * @description:
 * @author: hux
 * @create: 2020-04-03 09:20
 **/
@ApiModel("翻页")
public class SearchResultPageVO {
    //当前页页码
    @ApiModelProperty(value = "当前页页码")
    private Long currentPage;

    //结果总页数
    @ApiModelProperty(value = "结果总页数")
    private Long totalPage;

    //每一页的数量
    @ApiModelProperty(value = "每一页的数量")
    private Integer pageSize =10;

    //结果总数量
    @ApiModelProperty(value = "结果总数量")
    private Long total;

    //结果列表
    @ApiModelProperty(value = "结果列表")
    private List<Result> results;


    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public static class Result{

        private String docId;
        //文本
        private String content;
        //判决时间
        private String judgementDate;

        public String getDocId() {
            return docId;
        }

        public void setDocId(String docId) {
            this.docId = docId;
        }


        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getJudgementDate() {
            return judgementDate;
        }

        public void setJudgementDate(String judgementDate) {
            this.judgementDate = judgementDate;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "docId='" + docId + '\'' +
                    ", content='" + content + '\'' +
                    ", judgementDate='" + judgementDate + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SearchResultPageVO{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", results=" + results +
                '}';
    }
}