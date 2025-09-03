package com.itpractice.xiaohongshu.search.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyb
 *
 * 重建笔记文档请求参数
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RebuildNoteDocumentReqDTO {

    @NotNull(message = "笔记 ID 不能为空")
    private Long id;
}
