package com.kwok.ibatis.core;

import com.kwok.ibatis.util.MapperEntityResolver;
import com.kwok.ibatis.util.XNode;
import com.kwok.ibatis.util.XPathParse;
import org.w3c.dom.Document;

import java.io.InputStream;

public class XmlConfigBuilder {
    private Configuration configuration;
    private XPathParse xParse;
    private boolean isParsed = false;

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public XPathParse getxParse() {
        return xParse;
    }

    public void setxParse(XPathParse xParse) {
        this.xParse = xParse;
    }

    public XmlConfigBuilder(InputStream inputStream) {
        this.xParse = new XPathParse(inputStream,true,new MapperEntityResolver());
    }

    public Configuration parse(){
        //解析xml生成配置类
        if(this.isParsed){
            throw  new RuntimeException("正在解析");
        }else{
            this.isParsed = true;
            this.parseConfiguration(this.xParse.evalNode("/configarution"));
        }
        return this.configuration;
    }

    public Configuration parseConfiguration(XNode root){
        //TODO:根据配置文件进行创建
        return null;
    }
}
