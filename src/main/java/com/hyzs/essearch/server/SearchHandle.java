package com.hyzs.essearch.server;

import com.hyzs.essearch.vos.SearchResultPageVO;
import com.hyzs.essearch.vos.SearchVO;

/**
 * @program: es-search
 * @description:
 * @author: hux
 * @create: 2020-04-03 09:46
 **/

public interface SearchHandle {
    //列表
    SearchResultPageVO searchList(SearchVO vo);
}
