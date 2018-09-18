package org.gonnys.domain;

import lombok.Data;

@Data
public class MemberVO {
    @Override
    public String toString() {
        return "MemberVO{" +
                "mid='" + mid + '\'' +
                ", mpw='" + mpw + '\'' +
                ", mname='" + mname + '\'' +
                '}';
    }

    private String mid, mpw, mname;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMpw() {
        return mpw;
    }

    public void setMpw(String mpw) {
        this.mpw = mpw;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
