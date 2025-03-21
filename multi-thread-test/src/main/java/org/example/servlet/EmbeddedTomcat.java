package org.example.servlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import java.io.File;

public class EmbeddedTomcat {
    public static void main(String[] args) throws LifecycleException {
        System.setProperty("java.security.egd", "file:/dev/./urandom");

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Connector connector = tomcat.getConnector();
        connector.setProperty("bindOnInit", "false");

        String contextPath = "";
        Context context = tomcat.addContext(contextPath, new File(".").getAbsolutePath());

        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello", "HelloServlet");

        Tomcat.addServlet(context, "JsonServlet", new JsonServlet());
        context.addServletMappingDecoded("/json", "JsonServlet");

        tomcat.start();

        tomcat.getServer().await();
    }
}
