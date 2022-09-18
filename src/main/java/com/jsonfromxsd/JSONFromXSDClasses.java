package com.jsonfromxsd;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.MarshallerProperties;

public class JSONFromXSDClasses {

	public static void main(String[] args) throws JAXBException {

		System.setProperty("javax.xml.bind.JAXBContextFactory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

		Address address = new Address("Bapatla", 12);
		Student student = new Student(address, 1, "Sai Manoj");

		JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
		Marshaller marshaller = jaxbContext.createMarshaller();

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		/*
		 * marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		 * marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		 * marshaller.marshal(student, System.out);
		 */
		
		xmlProducer(marshaller, student);
		System.out.println("=============================================");		
		jsonProducer(marshaller, student);

	}

	public static void xmlProducer(Marshaller marshaller, Student student) throws JAXBException {

		marshaller.marshal(student, System.out);
	}

	public static void jsonProducer(Marshaller marshaller, Student student) throws JAXBException {
		
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		marshaller.marshal(student, System.out);

	}

}
