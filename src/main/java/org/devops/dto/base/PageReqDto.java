package org.devops.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageReqDto {
    private Integer pageNumber = 1;
    private Integer pageSize = 10;
}
