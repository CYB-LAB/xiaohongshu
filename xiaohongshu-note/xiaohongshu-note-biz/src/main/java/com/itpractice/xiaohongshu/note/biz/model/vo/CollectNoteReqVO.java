package com.itpractice.xiaohongshu.note.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyb
 *
 * 收藏笔记请求参数  入参
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CollectNoteReqVO {

    @NotNull(message = "笔记 ID 不能为空")
    private Long id;
}
