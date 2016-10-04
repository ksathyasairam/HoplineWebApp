package com.hopline.WebApp.rest.framework;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConversionUtil {

	private static final Logger log = LogManager.getLogger(ConversionUtil.class);

	
	public static final List<Long> parseCommaSeparatedLongs(String value) {
		return parseDelimitedLongs(value, ",");

	}

	public static final List<String> parseCommaSeparatedStrings(String value) {
		return parseDelimitedStrings(value, ",");

	}

	public static final List<Long> parseDelimitedLongs(String value, String delimiter) {
		if (StringUtils.isBlank(value)) {
			return Collections.emptyList();
		}

		List<Long> numbers = new ArrayList<Long>();
		String[] parsed = value.split(",");

		for (String aNumber : parsed) {
			numbers.add(Long.parseLong(StringUtils.trimToEmpty(aNumber)));
		}

		return numbers;
	}

	public static final List<String> parseDelimitedStrings(String value, String delimiter) {
		if (StringUtils.isBlank(value)) {
			return Collections.emptyList();
		}

		List<String> values = new ArrayList<String>();
		String[] parsed = value.split(",");

		for (String aNumber : parsed) {
			values.add(StringUtils.trimToEmpty(aNumber));
		}

		return values;
	}

	public static final String buildDelimitedLongs(List<Long> numbers) {
		if (numbers == null || numbers.size() == 0) {
			return null;
		}

		StringBuilder str = new StringBuilder();
		int count = 1;
		for (Long aNumber : numbers) {
			str.append(aNumber.longValue());
			if ((count++) < numbers.size()) {
				str.append(",");
			}
		}
		return str.toString();
	}

	public static final String buildCommaDelimitedStrings(Set<String> numbers) {
		return buildDelimitedStrings(numbers, ",");
	}

	public static final String buildDelimitedStrings(Set<String> numbers, String delimiter) {
		if (numbers == null || numbers.size() == 0) {
			return null;
		}

		StringBuilder str = new StringBuilder();
		int count = 1;
		for (String aNumber : numbers) {
			str.append(aNumber);
			if ((count++) < numbers.size()) {
				str.append(delimiter);
			}
		}
		return str.toString();
	}

	

	public static String toString(Long nbr) {
		if (nbr != null) {
			return nbr.toString();
		}
		return "";
	}
	
	 public static String toString( Serializable o ) throws IOException {
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ObjectOutputStream oos = new ObjectOutputStream( baos );
	        oos.writeObject( o );
	        oos.close();
	        return baos.toString("UTF-8"); 
	    }
	
	public static String toString(Integer nbr) {
		if (nbr != null) {
			return nbr.toString();
		}
		return "";
	}
	
	public static String toString(Double nbr) {
		if (nbr != null) {
			return nbr.toString();
		}
		return "";
	}




	public static void shallowCopy(Object sourceObj, Object destObj, String[] fields) {
		int srcIndex = 0;
		int destIndex = 1;

		for (String fieldEntry : fields) {
			String[] split = fieldEntry.split(" ");
			String srcProperty;
			String destProperty;
			if (split.length == 2) {
				srcProperty = split[srcIndex];
				destProperty = split[destIndex];
			} else {
				srcProperty = fieldEntry;
				destProperty = fieldEntry;
			}
			try {
				BeanUtils.setProperty(destObj, destProperty, BeanUtils.getProperty(sourceObj, srcProperty));
			} catch (IllegalAccessException e) {
				log.debug("Exception while processing property ::: " + srcProperty);
				log.debug("Exception ::: " + e);
			} catch (InvocationTargetException e) {
				log.debug("Exception while processing property ::: " + srcProperty);
				log.debug("Exception ::: " + e);
			} catch (NoSuchMethodException e) {
				log.debug("Exception while processing property ::: " + srcProperty);
				log.debug("Exception ::: " + e);
			}
		}
	}

	public static void shallowCopyMatchingFields(Object src, Object target) {
		try {
			BeanUtils.copyProperties(target, src);
		} catch (IllegalAccessException e) {
			log.debug("Exception while processing shallow copy ::: ", e);
		} catch (InvocationTargetException e) {
			log.debug("Exception while processing shallow copy ::: ", e);
			log.debug("Exception ::: " + e);
		}
	}

	

	public static String dollarStringToAmount(String str) {
		if (str.startsWith("$")) {
			return str.substring(1).trim();
		}
		return str;
	}

	public static String toString(BigDecimal amount) {
		if (amount == null) {
			return "";
		}
		return amount.toString();
	}
	
	public static BigDecimal toBigDecimal(String string){
		if(StringUtils.isEmpty(string)){
			 return new BigDecimal(0);
		}
		return new BigDecimal(string);
	}

		
	public static String truncateString(String val, int limit) {
		if (val == null) {
			return "";
		}
		if (val.length() <= limit) {
			return val;
		}
		int end = limit > val.length() ? val.length() : limit;
		return val.substring(0, end);
	}
}
