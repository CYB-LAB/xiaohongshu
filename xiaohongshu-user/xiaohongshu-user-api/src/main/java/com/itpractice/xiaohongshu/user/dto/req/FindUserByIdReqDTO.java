package com.itpractice.xiaohongshu.user.dto.req;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyb
 *
 * 根据id查询用户信息  入参
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindUserByIdReqDTO {
    /**
     * 手机号
     */
    @NotNull(message = "用户 ID 不能为空")
    private Long id;

}
