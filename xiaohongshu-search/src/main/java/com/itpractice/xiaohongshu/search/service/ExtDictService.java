package com.itpractice.xiaohongshu.search.service;

import org.springframework.http.ResponseEntity;

/**
 * @author cyb
 *
 * 扩展词典
 */
public interface ExtDictService {

    /**
     * 获取热更新词典
     * @return
     */
    ResponseEntity<String> getHotUpdateExtDict();
}
