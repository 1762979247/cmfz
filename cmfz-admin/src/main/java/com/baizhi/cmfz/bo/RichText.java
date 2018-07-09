package com.baizhi.cmfz.bo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:    富文本编辑器的实体类，主要用于返回控制器给与富文本编辑器返回值，以在编辑器中回显已上传的图片
 * @Author zhy
 * @Date 2018-07-08 20:01
 */
public class RichText implements Serializable {
    private Integer errno;
    private List<String> data;

    @Override
    public String toString() {
        return "RichText{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public RichText(Integer errno, List<String> data) {

        this.errno = errno;
        this.data = data;
    }

    public RichText() {

    }
}
