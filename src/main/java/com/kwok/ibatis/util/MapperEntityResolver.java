package com.kwok.ibatis.util;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class MapperEntityResolver implements EntityResolver {

    private static final String IBATIS_CONFIG_SYSTEM = "ibatis-3-config.dtd";
    private static final String IBATIS_MAPPER_SYSTEM = "ibatis-3-mapper.dtd";
    private static final String MYBATIS_CONFIG_SYSTEM = "mybatis-3-config.dtd";
    private static final String MYBATIS_MAPPER_SYSTEM = "mybatis-3-mapper.dtd";
    private static final String MYBATIS_CONFIG_DTD = "com/kwok/ibatis/dtd/mybatis-3-config.dtd";
    private static final String MYBATIS_MAPPER_DTD = "com/kwok/ibatis/dtd/mybatis-3-mapper.dtd";

    public MapperEntityResolver() {
    }

    public InputSource resolveEntity(String publicId, String systemId) throws SAXException {
        try {
            if (systemId != null) {
                String lowerCaseSystemId = systemId.toLowerCase(Locale.ENGLISH);
                if (lowerCaseSystemId.contains("mybatis-3-config.dtd") || lowerCaseSystemId.contains("ibatis-3-config.dtd")) {
                    return this.getInputSource(MYBATIS_CONFIG_DTD, publicId, systemId);
                }

                if (lowerCaseSystemId.contains("mybatis-3-mapper.dtd") || lowerCaseSystemId.contains("ibatis-3-mapper.dtd")) {
                    return this.getInputSource(MYBATIS_MAPPER_DTD, publicId, systemId);
                }
            }

            return null;
        } catch (Exception var4) {
            throw new SAXException(var4.toString());
        }
    }

    private InputSource getInputSource(String path, String publicId, String systemId) {
        InputSource source = null;
        if (path != null) {
            try {
                InputStream in = Resources.getResourceAsStream(path);
                source = new InputSource(in);
                source.setPublicId(publicId);
                source.setSystemId(systemId);
            } catch (Exception var6) {
                var6.printStackTrace();
            }
        }

        return source;
    }
}
