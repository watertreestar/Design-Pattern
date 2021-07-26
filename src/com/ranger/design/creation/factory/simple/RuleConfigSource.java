package com.ranger.design.creation.factory.simple;

/**
 * @Author ranger
 * @Date 2020/11/15 21:36
 *
 * 我们根据配置文件(json,xml,yaml,properties)，然后创建不同的配置文件解析器(XMLRUleConfigParser,JSONRUleConfigParse,...)来
 * 读取配置RuleConfig.
 **/
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigPath){
        return null;
    }

    private String fileType(String filePath){
        return "yaml";
    }
}
