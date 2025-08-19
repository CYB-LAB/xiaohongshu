package com.itpractice.xiaohongshu.kv.dto.rsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author cyb
 *
 * 笔记内容查询返回结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindNoteContentRspDTO {

    /**
     * 笔记 UUID
     */
    private UUID uuid;

    /**
     * 笔记内容
     */
    private String content;
}
