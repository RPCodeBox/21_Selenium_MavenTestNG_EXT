package com.cisco.xmltest;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class NamespaceReader {

	public static void main(String args[])
	{
		try {
			
		
		File file = new File("C:\\david\\xmlparser\\TC_7_response.xml");
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLStreamReader reader = inputFactory.createXMLStreamReader(new FileInputStream(file));
		Set<String> namespaces = new HashSet<String>();
	
		while (reader.hasNext()) {
	      int evt = reader.next();
	      
	      if (evt == XMLStreamConstants.START_ELEMENT) {
	        QName qName = reader.getName();
	        
	        if(qName != null){
	            if(qName.getPrefix() != null && qName.getPrefix().compareTo("")!=0)
	                namespaces.add(String.format("%s, %s, %s",
	                    qName.getLocalPart(), qName.getPrefix(), qName.getNamespaceURI()));
	        }
	      }
	}

	for(String namespace : namespaces){
	    System.out.println(namespace);              
	}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}


