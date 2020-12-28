package com.codefarmEquipment.config;

import javax.persistence.AttributeConverter;

public class DeviceConverter implements AttributeConverter<DeviceConverter, String> {

	@Override
	public String convertToDatabaseColumn(DeviceConverter attribute) {
		if(attribute == null) {
			return "올인원";
		}else {
			return "집가고싶다";
		}
	}

	@Override
	public DeviceConverter convertToEntityAttribute(String dbData) {
		return null;
	}
	

}
