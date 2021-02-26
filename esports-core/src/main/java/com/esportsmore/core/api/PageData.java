package com.esportsmore.core.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageData<T> {

    private int cnt;

    private List<T> list;

}
