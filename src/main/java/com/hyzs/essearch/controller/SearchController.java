package com.hyzs.essearch.controller;

import com.hyzs.essearch.server.SearchService;
import com.hyzs.essearch.vos.ResultVO;
import com.hyzs.essearch.vos.SearchResultPageVO;
import com.hyzs.essearch.vos.SearchVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: es-search
 * @description:
 * @author: hux
 * @create: 2020-04-03 10:02
 **/
@Api(description = "查询接口")
@RequestMapping("/api")
@RestController
public class SearchController {
    @Autowired
    private SearchService searchService;

    @ApiOperation("搜索翻页列表")
    @ApiResponses({@ApiResponse(code = 0, message = "成功", response = SearchResultPageVO.class)})
    @PostMapping("/search")
    public ResultVO search(@RequestBody SearchVO vo) {
        SearchResultPageVO pageVO = searchService.search(vo);
        return ResultVO.ok( pageVO);
    }

}
