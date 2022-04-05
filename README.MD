# FieldValueInjector
Внедрение значений в поля классов.

### Поддерживаемые типы данных полей

```java
Integer, Short, Float, Double, Long, String, Character, Boolean, Byte
```
```java
Integer[], Short[], Float[], Double[], Long[], String[], Character[],
Boolean[], Byte[]
```
```java
Collection<Integer>, Collection<Short>, Collection<Float>, Collection<Double>, 
Collection<Long>, Collection<String>, Collection<Character>, Collection<Boolean>,
Collection<Byte>
```
```java
List<Integer>, List<Short>, List<Float>, List<Double>, List<Long>, List<String>,
List<Character>, List<Boolean>, List<Byte>
```
```java
Set<Integer>, Set<Short>, Set<Float>, Set<Double>, Set<Long>, Set<String>,
Set<Character>, Set<Boolean>, Set<Byte>
```

Для других типов данных необходимо создавать свои конвертеры.

Примитивные типы данных не поддерживаются.

### Внедрение значений в поля класса
Класс, в поля которого необходимо внедрить значения:
```java
public class Experimental
{
    private String varOne;
    
    private Integer varTwo;
    
    public String getVarOne()
    {
        return this.varOne;
    }

    public Integer getVarTwo()
    {
        return this.varTwo;
    }
}
```

Данные которые необходимо внедрить в поля.
```java
Map<String, String[]> data = new HashMap<>();
data.put("varOne", new String[]{"Значение первого поля"});
data.put("varTwo", new String[]{"13"});
```

Вызов инжектора:
```java
Experimental experimental = new Experimental();

FieldValueInjectable fieldValueInjector = new FieldValueInjector(experimental);
fieldValueInjector.inject(data);

experimental.getVarOne();
/*
Результат выполнения: Значение первого поля
*/

experimental.getVarTwo();
/*
Результат выполнения: 13
*/
```

### Создание конвертера типа данных
Свой тип данных.
```java
public enum Gender
{
    M,
    F;
}
```

Для создания конвертера типа данных необходимо создать класс реализующий интерфейс "Converting".

```java
import dev.kalenchukov.fieldvalueinjector.Converting;

public final class GenderConverter implements Converting<Gender>
{
    @Override
    public @Nullable Gender convertValueToType(@Nullable String @Nullable [] value) 
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
```

Класс для поля которого необходим конвертер:

```java
import dev.kalenchukov.fieldvalueinjector.annotations.Converter;

public class Experimental
{
    @Converter(converter = GenderConverter.class)
    private Gender gender;

    public Gender getGender()
    {
        return this.gender;
    }
}
```

Данные для внедрения:
```java
Map<String, String[]> data = new HashMap<>();
data.put("gender", new String[]{"F"});
```

Вызов инжектора:
```java
Experimental experimental = new Experimental();

FieldValueInjectable fieldValueInjector = new FieldValueInjector(experimental);
fieldValueInjector.inject(data);

experimental.getGender();
/*
Результат выполнения: F
*/
```