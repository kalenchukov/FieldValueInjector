package dev.kalenchukov.fieldvalueinjector.converters.sets;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.converters.arrays.ArrayOfBooleanConverter;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Set;
import java.util.Objects;

/**
 * Класс конвертирует тип данных {@code String[]} в {@code Set} из {@code Boolean}.
 */
public final class SetBooleanConverter implements Converting<Set<Boolean>>
{
	/**
	 * @see Converting#convertValueToType(String[])
	 */
	@Override
	@Nullable
	public Set<@NotNull Boolean> convertValueToType(@Nullable final String @Nullable [] value)
		throws UnableConverterFieldValueInjectorException
	{
		Boolean[] convertValue = new ArrayOfBooleanConverter().convertValueToType(value);

		if (convertValue == null) {
			return null;
		}

		boolean has = Arrays.stream(convertValue).anyMatch(Objects::isNull);

		if (has) {
			throw new UnableConverterFieldValueInjectorException();
		}

		return Set.of(convertValue);
	}
}
