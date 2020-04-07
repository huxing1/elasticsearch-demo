package com.hyzs.essearch.server.impl;

import com.hyzs.essearch.server.SearchHandle;
import com.hyzs.essearch.utils.ElasticSearchUtils;
import com.hyzs.essearch.vos.SearchResultPageVO;
import com.hyzs.essearch.vos.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: es-search
 * @description:
 * @author: hux
 * @create: 2020-04-03 09:47
 **/
@Service
public class SearchHandleImpl implements SearchHandle {
    @Autowired
    private ElasticSearchUtils elasticSearchUtils;

    @Override
    public SearchResultPageVO searchList(SearchVO vo) {
        String sortField=vo.getSortField();
        String sortType=vo.getSortType();
        String query=vo.getText();
        int start = (vo.getCurrentPage().intValue() - 1) * vo.getPageSize();
        SearchResultPageVO resultPageVO = elasticSearchUtils.queryByFilter(vo,"judicialdocument","xsyspj", "document",query, start, vo.getPageSize(),sortField,sortType);
        return resultPageVO;

    }
}
