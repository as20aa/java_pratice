package org.example;

import org.springframework.stereotype.Component;

/***
 * 入参测试类
 */
public class Hero {
    private String no;
    private String name;
    //作为出参时为test1
    public String getTest1() {return no;}
    //作为出参时为test2
    public String getTest2() {return name;}
    //入参需为first
    public void setFirst(String A) {this.no = A;}
    //入参需为second
    public void setSecond(String B) {this.name=B;}

    @Override
    public String toString() {
        return "Hero{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
