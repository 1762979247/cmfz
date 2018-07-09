package com.baizhi.cmfz.bo;

import java.io.Serializable;

/**
 * @Description:    analyze的实体类
 * @Author zhy
 * @Date 2018-07-09 16:14
 */
public class AnalyzeData implements Serializable{
    private String name;
    private Integer value;

    public AnalyzeData(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "AnalyzeData{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public AnalyzeData() {

    }
}
