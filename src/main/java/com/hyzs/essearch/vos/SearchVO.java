package com.hyzs.essearch.vos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @program: es-search
 * @description:
 * @author: hux
 * @create: 2020-04-03 09:36
 **/
@ApiModel("检索输入类")
public class SearchVO {
    //原文本
    @ApiModelProperty(value = "检索文本")
    private String text;
    //需要查询的页
    @ApiModelProperty(value = "需要查询的页")
    private Long currentPage =1L;
    //每一页的数量
    @ApiModelProperty(value = "每一页的数量 默认为10")
    private Integer pageSize =10;
    //排序字段
    @ApiModelProperty(value = "排序字段 默认按照相关性排序 审理时间: judgementDate 相关性: _score")
    private String sortField ="_score";
    //排序类型
    @ApiModelProperty(value = "排序类型 ASC/DESC")
    private String sortType ="DESC" ;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

}
