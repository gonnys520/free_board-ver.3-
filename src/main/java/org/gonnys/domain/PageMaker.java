package org.gonnys.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {

    private int total;

    @Override
    public String toString() {
        return "PageMaker{" +
                "total=" + total +
                ", pageDTO=" + pageDTO +
                ", start=" + start +
                ", end=" + end +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }

    private PageDTO pageDTO;

    private int start, end;
    private boolean prev, next;

    public int getTotal() {
        return total;
    }

    public PageDTO getPageDTO() {
        return pageDTO;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    public PageMaker(int total, PageDTO pageDTO) {
        this.total = total;
        this.pageDTO = pageDTO;

        int tempEnd = (int)Math.ceil(pageDTO.getPage()/10.0) * 10;
        this.start = tempEnd - 9;

        int realEnd = (int)(Math.ceil(total/(double)pageDTO.getSize()));
        this.end = realEnd < tempEnd ? realEnd:tempEnd;

        this.prev = this.start != 1;
        this.next = (this.end * pageDTO.getSize()) < total;



    }
}
