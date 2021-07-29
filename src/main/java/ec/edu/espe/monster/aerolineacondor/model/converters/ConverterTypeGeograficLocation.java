package ec.edu.espe.monster.aerolineacondor.model.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.util.stream.Stream;

import ec.edu.espe.monster.aerolineacondor.model.constants.TypeGeograficLocation;

@Converter(autoApply = true)
public class ConverterTypeGeograficLocation implements AttributeConverter<TypeGeograficLocation, String> {

	@Override
	public String convertToDatabaseColumn(TypeGeograficLocation attribute) {
		if(attribute == null) {
			return null;
		}
		return attribute.getCode();
	}

	@Override
	public TypeGeograficLocation convertToEntityAttribute(String dbData) {
		if(dbData == null) {
			return null;
		}

		return Stream.of(TypeGeograficLocation.values()).filter(state -> state.getCode().equals(dbData))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);

	}

}
