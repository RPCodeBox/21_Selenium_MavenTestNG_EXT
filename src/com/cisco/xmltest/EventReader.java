package com.cisco.xmltest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class EventReader {
	
	private static String filename = "C:\\david\\xmlparser\\TC_7_response.xml";
	   private static void printUsage() {
	    System.out.println("usage: java examples.event.Parse <xmlfile>");
	  }
	   public static void main(String[] args) throws Exception {
	    
		   //ReadEvent();
		   streamRead();
	   }
	   
	   public static void ReadEvent()throws Exception
	   {
		   XMLInputFactory factory = XMLInputFactory.newInstance();
		    XMLEventReader r = 
		      factory.createXMLEventReader(new FileReader(filename));
		    while(r.hasNext()) {
		      XMLEvent e = r.nextEvent();
		      System.out.println("ID:"+e.hashCode()+"["+e+"]");
		    }   
	   }
	   
	   public static void streamRead() throws Exception
	   {
		   XMLInputFactory xmlif = XMLInputFactory.newInstance();
		    System.out.println("FACTORY: " + xmlif);
		    XMLStreamReader xmlr = xmlif.createXMLStreamReader(new FileReader(filename));
		    System.out.println("READER:  " + xmlr + "\n");
		    while(xmlr.hasNext()){
		      printEvent(xmlr);
		      xmlr.next();
		    }
		    xmlr.close();
	   }
	   
	   
	   private static void printEvent(XMLStreamReader xmlr) {
		     System.out.print("EVENT:["+xmlr.getLocation().getLineNumber()+"]["+
		                     xmlr.getLocation().getColumnNumber()+"] ");
		     System.out.print(" [");
		     switch (xmlr.getEventType()) {
		     case XMLStreamConstants.START_ELEMENT:
		      System.out.print("Its a START_ELEMENT <");
		      printName(xmlr);
		      System.out.print("Printing Namespaces ");
		      printNamespaces(xmlr);
		      System.out.print("Printing ATTRS");
		      printAttributes(xmlr);
		      System.out.print(">");
		      break;
		     case XMLStreamConstants.END_ELEMENT:
		      System.out.print("Its a  END Element</");
		      printName(xmlr);
		      System.out.print(">");
		      break;
		     case XMLStreamConstants.SPACE:
		     case XMLStreamConstants.CHARACTERS:
		      int start = xmlr.getTextStart();
		      int length = xmlr.getTextLength();
		      System.out.print(new String(xmlr.getTextCharacters(),
		                                  start,
		                                  length));
		      break;
		     case XMLStreamConstants.PROCESSING_INSTRUCTION:
		      System.out.print("Processing Instructions <?");
		      if (xmlr.hasText())
		        System.out.print(xmlr.getText());
		      System.out.print("?>");
		      break;
		     case XMLStreamConstants.CDATA:
		      System.out.print("<![CDATA[");
		      start = xmlr.getTextStart();
		      length = xmlr.getTextLength();
		      System.out.print(new String(xmlr.getTextCharacters(),
		                                  start,
		                                  length));
		      System.out.print("]]>");
		      break;
		     case XMLStreamConstants.COMMENT:
		      System.out.print("Its a Comment <!--");
		      if (xmlr.hasText())
		        System.out.print(xmlr.getText());
		      System.out.print("-->");
		      break;
		     case XMLStreamConstants.ENTITY_REFERENCE:
		      System.out.print(xmlr.getLocalName()+"=");
		      if (xmlr.hasText())
		        System.out.print("["+xmlr.getText()+"]");
		      break;
		     case XMLStreamConstants.START_DOCUMENT:
		      System.out.print("<?xml");
		      System.out.print(" version='"+xmlr.getVersion()+"'");
		      System.out.print(" encoding='"+xmlr.getCharacterEncodingScheme()+"'");
		      if (xmlr.isStandalone())
		        System.out.print(" standalone='yes'");
		      else
		        System.out.print(" standalone='no'");
		      System.out.print("?>");
		      break;
		     }
		    System.out.println("]");
		  }
		   private static void printName(XMLStreamReader xmlr){
		    if(xmlr.hasName()){
		      String prefix = xmlr.getPrefix();
		      String uri = xmlr.getNamespaceURI();
		      String localName = xmlr.getLocalName();
		      System.out.println("Prefix is " + prefix + " localname is " + localName );
		      printName(prefix,uri,localName);
		    }
		  }
		   private static void printName(String prefix,
		                                String uri,
		                                String localName) {
		    if (uri != null && !("".equals(uri)) ) System.out.print("['"+uri+"']:");
		    if (prefix != null) System.out.print(prefix+":");
		    if (localName != null) System.out.print(localName);
		  }
		   private static void printAttributes(XMLStreamReader xmlr){
			   System.out.println("Printing the arrtibutes for the attribute...." );
		    for (int i=0; i < xmlr.getAttributeCount(); i++) {
		      printAttribute(xmlr,i);
		    }
		  }
		   private static void printAttribute(XMLStreamReader xmlr, int index) {
		    String prefix = xmlr.getAttributePrefix(index);
		    String namespace = xmlr.getAttributeNamespace(index);
		    String localName = xmlr.getAttributeLocalName(index);
		    
		    String value = xmlr.getAttributeValue(index);
		    
		    System.out.print(" ");
		    printName(prefix,namespace,localName);
		    System.out.print("='"+value+"'");
		  }
		   private static void printNamespaces(XMLStreamReader xmlr){
		    for (int i=0; i < xmlr.getNamespaceCount(); i++) {
		      printNamespace(xmlr,i);
		    }
		  }
		   private static void printNamespace(XMLStreamReader xmlr, int index) {
		    String prefix = xmlr.getNamespacePrefix(index);
		    String uri = xmlr.getNamespaceURI(index);
		    System.out.print(" ");
		    if (prefix == null)
		      System.out.print("xmlns='"+uri+"'");
		    else
		      System.out.print("xmlns:"+prefix+"='"+uri+"'");
		  }

}
