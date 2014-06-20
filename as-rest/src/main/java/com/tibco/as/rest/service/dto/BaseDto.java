package com.tibco.as.rest.service.dto;

import java.beans.PropertyDescriptor;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.beanutils.PropertyUtils;

@XmlRootElement
public abstract class BaseDto {

	public String toString() {
		StringBuffer strToReturn = new StringBuffer();
		PropertyDescriptor[] propDescs = PropertyUtils.getPropertyDescriptors(this);

		for (int i = 0; i < propDescs.length; i++) {
		String propName = propDescs[i].getName();
		
		    if ( PropertyUtils.isReadable(this, propName)
		             && PropertyUtils.isWriteable(this, propName) ) {

		      strToReturn.append( System.getProperty("line.separator") + " ==> " + propName + ": " );
		      try {
		          Object value = PropertyUtils.getProperty(this, propName);
		          strToReturn.append( value );
		      } catch (Exception e) {
		          strToReturn.append("");
		      }
		    }
		  }
		return strToReturn.toString();
	}
}
