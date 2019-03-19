package com.kwok.ibatis.util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

public class XPathParse {
    private final Document document;
    private boolean validation;
    private EntityResolver entityResolver;
    private XPath xPath;

    public XPathParse(InputStream inputStream, boolean validation, EntityResolver entityResolver){
        this.validation = validation;
        this.entityResolver = entityResolver;
        XPathFactory factory = XPathFactory.newInstance();
        this.xPath = factory.newXPath();
        this.document = createDocument(new InputSource(inputStream));
    }

    public Document createDocument(InputSource inputSource){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(this.validation);
            factory.setNamespaceAware(false);
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(false);
            factory.setCoalescing(false);
            factory.setExpandEntityReferences(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(this.entityResolver);
            builder.setErrorHandler(new ErrorHandler() {
                public void warning(SAXParseException exception) throws SAXException {
                }

                public void error(SAXParseException exception) throws SAXException {
                    throw exception;
                }

                public void fatalError(SAXParseException exception) throws SAXException {
                    throw  exception;
                }
            });
            return builder.parse(inputSource);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error creating document instance.  Cause:" + e.getCause());
        }
    }

    public XNode evalNode(String expression) {
        return this.evalNode(this.document, expression);
    }

    private XNode evalNode(Document document,String expression){
        Object node = null;
        try {
            node = this.xPath.evaluate(expression,document, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            throw new RuntimeException("Error evaluating XPath.  Cause:"+e.getCause());
        }
        return (node == null)?null:new XNode(this,(Node)node);
    }
}
