package org.devops.dto.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageDto<T> {
    private int total;
    private List<T> data = new ArrayList<>();
}
