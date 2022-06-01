/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.fieldvalueinjector.supports;

import dev.kalenchukov.fieldvalueinjector.Converting;
import dev.kalenchukov.fieldvalueinjector.exceptions.UnableConverterException;
import org.jetbrains.annotations.Nullable;

public class ArrayOfGenderConverter implements Converting<Gender[]>
{
    @Nullable
    @Override
    public Gender @Nullable [] convertValueToType(@Nullable String @Nullable [] value)
		throws UnableConverterException
    {
        if (value == null) {
            return null;
        }

        Gender[] convertValue = new Gender[value.length];

        for (int elm = 0; elm < value.length; elm++)
        {
            convertValue[elm] = new SingleGenderConverter().convertValueToType(new String[]{value[elm]});
        }

        return convertValue;
    }
}
