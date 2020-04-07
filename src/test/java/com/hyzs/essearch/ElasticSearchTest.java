package com.hyzs.essearch;

import com.hyzs.essearch.config.ElasticSearchConnector;
import com.hyzs.essearch.server.impl.SearchHandleImpl;
import com.hyzs.essearch.server.impl.SearchServiceImpl;
import com.hyzs.essearch.utils.ElasticSearchUtils;
import com.hyzs.essearch.vos.SearchResultPageVO;
import com.hyzs.essearch.vos.SearchVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: es-search
 * @description:
 * @author: hux
 * @create: 2020-04-03 10:07
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EsSearchApplication.class)
public class ElasticSearchTest {
    @Autowired
    private ElasticSearchConnector elasticSearchConnector;

    @Autowired
    private ElasticSearchUtils elasticSearchUtils;
    @Autowired
    private SearchServiceImpl searchServiceImpl;

    @Autowired
    private SearchHandleImpl searchHandleImpl;
    @Test
    public void esTestMehtod(){
        SearchVO vo = new SearchVO();
        vo.setCurrentPage(1L);
//        vo.setText("JDN:（2019）浙0683刑初524号,charge_enforcement_type:刑事拘留,charge_enforcement_time:2019年7月12日,charge_enforcement_organ:嵊州市公安局,charge_enforcement_type:逮捕,charge_enforcement_time:同年8月12日,BD:1983年10月15日,S:男,E:初中,defendant_name:向道海,defendant_occupation:职工,DR:贵州省德江县,JA:寻衅滋事罪,penalty_duration:自二○一九年七月十二日起至二○二○年六月十一日止,inPrison:现羁押,inPrison_place:嵊州市看守所,accusation_reference:嵊检公诉刑诉[2019]518号,accusation_procurator:浙江省嵊州市人民检察院,accusation_time:2019年9月10日,accusation_type:提起公诉,law_name:《中华人民共和国刑法》,article_names:第二百九十三条第一款,article_names:第六十五条第一款,article_names:第六十七条第三款,judgement_date:二〇一九年九月十七日,judges:刘安琳,clerks:俞燕,appeal_due:接到判决书的第二日起十日内,appeal_courts:本院,appeal_courts:浙江省绍兴市中级人民法院,affirm_content:寻衅滋事罪,document_category:刑事,document_producer:浙江省嵊州市人民法院,hear_way:独任审判,hear_isPublic:公开开庭审理,hear_defendant_names:向道海,hear_prosecutor_occupation:检察员,hear_prosecutor_name:徐美芳,document_type:判决书");
        vo.setText("云南省曲靖市中级人民法院");
        vo.setPageSize(10);
        vo.setSortField("_score");
        vo.setSortType("desc");

        SearchResultPageVO searchResultPageVO= searchServiceImpl.search(vo);
        System.out.println(searchResultPageVO.toString());
    }
}
