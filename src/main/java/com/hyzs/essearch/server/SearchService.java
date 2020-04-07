package com.hyzs.essearch.server;

import com.hyzs.essearch.vos.SearchResultPageVO;
import com.hyzs.essearch.vos.SearchVO;

/**
 * @program: es-search
 * @description:
 * @author: hux
 * @create: 2020-04-03 09:59
 **/
public interface SearchService {
    SearchResultPageVO search(SearchVO vo) ;}
