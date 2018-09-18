package org.gonnys.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

    private int page = 1, size = 10;

    @Override
    public String toString() {
        return "PageDTO{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public static PageDTO of(){
        return new PageDTO();
    }


    public PageDTO setPage(int page) {
        this.page = page;
        return this;
    }

    public PageDTO setSize(int size) {
        this.size = size;
        return this;
    }
}