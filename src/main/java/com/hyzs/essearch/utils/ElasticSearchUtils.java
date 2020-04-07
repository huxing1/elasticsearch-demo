package com.hyzs.essearch.utils;

import com.hyzs.essearch.vos.SearchResultPageVO;
import com.hyzs.essearch.vos.SearchVO;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: es-search
 * @description:
 * @author: hux
 * @create: 2020-04-03 09:15
 **/
@Component
public class ElasticSearchUtils {
    @Autowired
    private TransportClient transportClient;

    public SearchResultPageVO queryByFilter(SearchVO vo, String index, String type, String field, String query, int start, int size, String sortField, String sortType) {

        SortOrder sortOrder = SortOrder.DESC;
        if (sortType.equals("ASC")) {
            sortOrder = SortOrder.ASC;
        } else if (sortType.equals("DESC")) {
            sortOrder = SortOrder.DESC;
        }

        SearchResponse response = new SearchResponse();
        if (sortField.equals("_score")) {
            response = transportClient.prepareSearch(index)
                    .setTypes(type)
                    .setQuery(QueryBuilders.matchQuery(field, query))
                    .setFrom(start)
                    .setSize(size)
                    .addSort(sortField, sortOrder)
                    .setExplain(false)
                    .execute()
                    .actionGet();
        } else if (sortField.equals("judgementDate")) {
            response = transportClient.prepareSearch(index)
                    .setTypes(type)
                    .setQuery(QueryBuilders.matchQuery(field, query))
                    .setFrom(start)
                    .setSize(size)
                    .addSort(sortField, sortOrder)
                    .addSort("_score", SortOrder.DESC)
                    .setExplain(false)
                    .execute()
                    .actionGet();
        }

        List<SearchResultPageVO.Result> resultList = new ArrayList<>();

        for (SearchHit hit : response.getHits()) {
//            System.out.println("result:" + hit.toString());
            String content = (String) hit.getSourceAsMap().get("document");
            String doc_id = (String) hit.getSourceAsMap().get("doc_id");
            String judgementDate = (String) hit.getSourceAsMap().get("judgementDate");


            //组装每个docid的结果
            SearchResultPageVO.Result result = new SearchResultPageVO.Result();
            result.setDocId(doc_id);
            result.setContent(content);
            result.setJudgementDate(judgementDate);
            resultList.add(result);

        }

        //计算Page
        Long hitsNum = response.getHits().totalHits;
        Long totalPage = hitsNum / size;
        if (hitsNum % size != 0) {
            totalPage++;
        }

        SearchResultPageVO searchResultPageVO = new SearchResultPageVO();
        searchResultPageVO.setCurrentPage(vo.getCurrentPage());
        searchResultPageVO.setResults(resultList);
        searchResultPageVO.setTotal(hitsNum);
        searchResultPageVO.setTotalPage(totalPage);
        return searchResultPageVO;
    }
}
