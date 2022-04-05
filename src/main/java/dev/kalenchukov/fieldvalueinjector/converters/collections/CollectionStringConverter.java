package dev.kalenchukov.fieldvalueinjector.converters.collections;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.arrays.ArrayOfStringConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Collection} из {@code String}.
 */
public final class CollectionStringConverter implements Converting<Collection<String>>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Collection<@NotNull String> convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterFieldValueInjectorException
	{
		String[] convertValue = new ArrayOfStringConverter().convertValueToType(value);

		if (convertValue == null) {
			return null;
		}

		boolean has = Arrays.stream(convertValue).anyMatch(Objects::isNull);

		if (has) {
			throw new UnableConverterFieldValueInjectorException();
		}

		return List.of(convertValue);
	}
}
