package com.hyzs.essearch.server.impl;

import com.hyzs.essearch.server.SearchHandle;
import com.hyzs.essearch.server.SearchService;
import com.hyzs.essearch.vos.SearchResultPageVO;
import com.hyzs.essearch.vos.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: es-search
 * @description:
 * @author: hux
 * @create: 2020-04-03 10:00
 **/
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchHandle searchHandle;
    @Override
    public SearchResultPageVO search(SearchVO vo) {
        if(vo.getCurrentPage()==null||vo.getCurrentPage()==0)vo.setCurrentPage(1L);
        if(vo.getPageSize()==null||vo.getPageSize()==0)vo.setCurrentPage(10L);
        return searchHandle.searchList(vo);
    }
}
