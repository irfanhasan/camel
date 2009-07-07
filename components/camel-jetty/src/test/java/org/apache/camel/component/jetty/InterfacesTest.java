/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.jetty;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Enumeration;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class InterfacesTest extends CamelTestSupport {
    private static boolean isMacOS = System.getProperty("os.name").startsWith("Mac");
    private String remoteInterfaceAddress;
   
    
    public InterfacesTest() throws IOException {
        // Retrieve an address of some remote network interface
        Enumeration<NetworkInterface> interfaces =  NetworkInterface.getNetworkInterfaces();
        
        while (remoteInterfaceAddress == null && interfaces.hasMoreElements()) {
            NetworkInterface interfaze = interfaces.nextElement();
            Enumeration<InetAddress> addresses =  interfaze.getInetAddresses();
            if (addresses.hasMoreElements()) {
                InetAddress nextAddress = addresses.nextElement();
                if (nextAddress.isLoopbackAddress() || !nextAddress.isReachable(2000)) {
                    continue;
                }
                if (nextAddress instanceof Inet6Address) {
                    continue;
                } else {
                    remoteInterfaceAddress = nextAddress.getHostAddress();
                }
            }
        }
    }
    
    @Test
    public void testLocalInterfaceHandled() throws IOException, InterruptedException {
        int expectedMessages = (remoteInterfaceAddress != null) ? 3 : 2;
        getMockEndpoint("mock:endpoint").expectedMessageCount(expectedMessages);
        
        URL localUrl = new URL("http://localhost:4567/testRoute");
        String localResponse = context.getTypeConverter().convertTo(String.class, localUrl.openStream());
        assertEquals("local", localResponse);
       
        if (!isMacOS) {
            localUrl = new URL("http://127.0.0.1:4568/testRoute");
        } else {
            localUrl = new URL("http://localhost:4568/testRoute");
        }
        localResponse = context.getTypeConverter().convertTo(String.class, localUrl.openStream());
        assertEquals("local-differentPort", localResponse);
        
        if (remoteInterfaceAddress != null) {            
            URL url = new URL("http://" + remoteInterfaceAddress + ":4560/testRoute");
            String remoteResponse = context.getTypeConverter().convertTo(String.class, url.openStream());
            assertEquals("remote", remoteResponse);
        }
        
        assertMockEndpointsSatisfied();
    }    
      
    @Test
    public void testAllInterfaces() throws Exception {
        int expectedMessages = (remoteInterfaceAddress != null) ? 2 : 1;
        getMockEndpoint("mock:endpoint").expectedMessageCount(expectedMessages);
        
        URL localUrl = new URL("http://localhost:4569/allInterfaces");
        String localResponse = context.getTypeConverter().convertTo(String.class, localUrl.openStream());
        assertEquals("allInterfaces", localResponse);
        
        if (remoteInterfaceAddress != null) {
            URL url = new URL("http://" + remoteInterfaceAddress + ":4569/allInterfaces");
            String remoteResponse = context.getTypeConverter().convertTo(String.class, url.openStream());
            assertEquals("allInterfaces", remoteResponse);
        }
        
        assertMockEndpointsSatisfied();
    }
    
    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
        
            @Override
            public void configure() throws Exception {
                from("jetty:http://localhost:4567/testRoute")
                    .setBody().constant("local")
                    .to("mock:endpoint");
                
                from("jetty:http://localhost:4568/testRoute")
                    .setBody().constant("local-differentPort")
                    .to("mock:endpoint");
                
                if (remoteInterfaceAddress != null) {
                    from("jetty:http://" + remoteInterfaceAddress + ":4560/testRoute")
                        .setBody().constant("remote")
                        .to("mock:endpoint");
                }
                
                from("jetty:http://0.0.0.0:4569/allInterfaces")
                    .setBody().constant("allInterfaces")
                    .to("mock:endpoint");
                
            }
        };
    }
}
