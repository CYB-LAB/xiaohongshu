package com.itpractice.xiaohongshu.comment.biz.domain.mapper;

import com.itpractice.xiaohongshu.comment.biz.domain.dataobject.MqFailedMessageDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MqFailedMessageMapper {

    // 插入失败消息
    int insert(MqFailedMessageDO message);

}
