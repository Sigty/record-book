package by.dulik.recordbook.validate;

import static org.junit.Assert.*;
import org.junit.Test;

public class ValidateTest {

    @Test
    public void checkNameTest() {
        assertTrue(Validate.checkName("Dulik"));
        assertTrue(Validate.checkName("Dima"));
        assertTrue(Validate.checkName("Dulik-Dima"));
        assertFalse(Validate.checkName(""));
        assertFalse(Validate.checkName(" "));
        assertFalse(Validate.checkName("_"));
        assertFalse(Validate.checkName("1"));
        assertFalse(Validate.checkName("dima"));
    }

    @Test
    public void checkEmailTest() {
        assertTrue(Validate.checkEmail("qwe@mail.com"));
        assertTrue(Validate.checkEmail("qwe-qwe@mail.by"));
        assertTrue(Validate.checkEmail("qwe_qwe@gmail.by"));
        assertTrue(Validate.checkEmail("123@gmail.by"));
        assertFalse(Validate.checkName(""));
        assertFalse(Validate.checkName(" "));
        assertFalse(Validate.checkName("_"));
        assertFalse(Validate.checkName("1"));
        assertFalse(Validate.checkEmail("qwe,qwe@mail.by"));
        assertFalse(Validate.checkEmail("qwe?qwe@mail.by"));
        assertFalse(Validate.checkEmail("qwe qwe@mail.by"));
        assertFalse(Validate.checkEmail(" qwe qwe@mail.by"));

    }

    @Test
    public void checkPhoneTest() {
        assertTrue(Validate.checkPhone("8-123-1234567"));
        assertTrue(Validate.checkPhone("+375-12-1234567"));
        assertTrue(Validate.checkPhone("375-12-1234567"));
        assertFalse(Validate.checkName(""));
        assertFalse(Validate.checkName(" "));
        assertFalse(Validate.checkName("_"));
        assertFalse(Validate.checkName("1"));
        assertFalse(Validate.checkName("a"));
        assertFalse(Validate.checkName("asdqw-asdfqwer"));
        assertFalse(Validate.checkPhone("8-123-123456"));
        assertFalse(Validate.checkPhone("8123-1234567"));
        assertFalse(Validate.checkPhone("8-123-12345678"));
        assertFalse(Validate.checkPhone("37512-1234567"));
        assertFalse(Validate.checkPhone("+37512-1234567"));
    }
}
