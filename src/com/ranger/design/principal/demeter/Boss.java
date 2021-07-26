package com.ranger.design.principal.demeter;

/**
 * @Author ranger
 * @Date 2020/11/15 19:46
 **/
public class Boss {

    public void checkNumber(TeamLeader leader){
        leader.checkCorseNum();
    }
}
