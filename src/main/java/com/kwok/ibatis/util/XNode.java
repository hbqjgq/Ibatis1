package com.kwok.ibatis.util;

import org.w3c.dom.Node;

public class XNode {
    private Node node;
    private XPathParse parse;

    public XNode(XPathParse parse,Node node) {
        this.node = node;
        this.parse = parse;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public XPathParse getParse() {
        return parse;
    }

    public void setParse(XPathParse parse) {
        this.parse = parse;
    }
}
