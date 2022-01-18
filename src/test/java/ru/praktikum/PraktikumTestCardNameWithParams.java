package ru.praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PraktikumTestCardNameWithParams {
    private final String name;
    private final boolean expectedValidationResult;

    public PraktikumTestCardNameWithParams(String name, boolean expectedValidationResult) {
        this.name = name;
        this.expectedValidationResult = expectedValidationResult;
    }

    @Parameterized.Parameters
    public static Object[] getNameData() {
        return new Object[][] {
                { null, false },
                { "", false },//граница диапазона 0-2 символов
                { "Ф", false },//шаг внутрь границы диапазона 0-2 символов
                { "ФИ", false },//шаг за границы диапазона 3-19 символов
                { "Ф И", true },//граница диапазона 3-19 символов
                { "ФИ О", true },//шаг внутрь границы диапазона 3-19 символов
                { "Бенедикт Камбербэтч", true },//граница диапазона 3-19 символов
                { "Бенедикт Камбербэтча", false },//шаг за границы диапазона 3-19 символов
                { "Бенедикта Камбербэтча", false },//шаг за границы диапазона >=20 символов
                { "Тимоти  Шаламе", false },//>1 пробела
                { "ТимотиШаламе", false },//нет пробела
                { "Тимоти ", false },//пробел в конце
                { " Тимоти", false },//пробел в начале
        };
    }

    @Test
    public void testNameIsValidToEmboss() {
        Account account = new Account(name);
        boolean actualValidationResult = account.checkNameToEmboss();
        assertEquals(expectedValidationResult, actualValidationResult);
    }
}
