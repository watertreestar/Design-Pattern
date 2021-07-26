package com.ranger.design.principal.demeter;

/**
 * @Author ranger
 * @Date 2020/11/15 19:49
 **/
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.checkNumber(teamLeader);
    }
}
