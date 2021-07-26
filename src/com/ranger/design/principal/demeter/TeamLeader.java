package com.ranger.design.principal.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ranger
 * @Date 2020/11/15 19:46
 **/
public class TeamLeader {

    public void checkCorseNum(){
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            courseList.add(new Course());
        }
        System.out.println("课程数量："+courseList.size());
    }
}
