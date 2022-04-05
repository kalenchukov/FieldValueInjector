/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvalueinjector.supports;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterFieldValueInjectorException;
import org.jetbrains.annotations.Nullable;

public class SingleGenderConverter implements Converting<Gender>
{
    @Nullable
    @Override
    public Gender convertValueToType(@Nullable String @Nullable [] value)
		throws UnableConverterFieldValueInjectorException
    {
        if (value == null || value[0] == null) {
            return null;
        }

        try
        {
            return Gender.valueOf(value[0]);
        }
        catch (IllegalArgumentException exception)
        {
            throw new UnableConverterFieldValueInjectorException();
        }

    }
}
