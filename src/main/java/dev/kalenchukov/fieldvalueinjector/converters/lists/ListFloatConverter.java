package dev.kalenchukov.fieldvalueinjector.converters.lists;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.arrays.ArrayOfFloatConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code List} из {@code Float}.
 */
public final class ListFloatConverter implements Converting<List<Float>>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public List<@NotNull Float> convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		Float[] convertValue = new ArrayOfFloatConverter().convertValueToType(value);

		if (convertValue == null) {
			return null;
		}

		boolean has = Arrays.stream(convertValue).anyMatch(Objects::isNull);

		if (has) {
			throw new UnableConverterException();
		}

		return List.of(convertValue);
	}
}
