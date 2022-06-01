package dev.kalenchukov.fieldvalueinjector.converters.sets;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.arrays.ArrayOfShortConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Set;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Set} из {@code Short}.
 */
public final class SetShortConverter implements Converting<Set<Short>>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Set<@NotNull Short> convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterException
	{
		Short[] convertValue = new ArrayOfShortConverter().convertValueToType(value);

		if (convertValue == null) {
			return null;
		}

		boolean has = Arrays.stream(convertValue).anyMatch(Objects::isNull);

		if (has) {
			throw new UnableConverterException();
		}

		return Set.of(convertValue);
	}
}
