package by.dulik.recordbook.validate;

import by.dulik.recordbook.entity.Role;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Before;
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
        assertTrue(Validate.checkEmail("123@gmail.by"));
        assertFalse(Validate.checkEmail("qwe-qwe@mail.by"));
        assertFalse(Validate.checkEmail("qwe_qwe@gmail.by"));
        assertFalse(Validate.checkEmail("qwe.qwe@mail.by"));
        assertFalse(Validate.checkEmail("qwe@@mail.by"));
        assertFalse(Validate.checkEmail("qwe.qwe@@.mail.by"));
        assertFalse(Validate.checkEmail("qwe@mail..by"));
        assertFalse(Validate.checkEmail("qwe@mail.by."));
        assertFalse(Validate.checkEmail("qwe@mailby"));
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
        assertTrue(Validate.checkPhone("37512 1234567"));
        assertFalse(Validate.checkName(""));
        assertFalse(Validate.checkName(" "));
        assertFalse(Validate.checkName("_"));
        assertFalse(Validate.checkName("1"));
        assertFalse(Validate.checkName("a"));
        assertFalse(Validate.checkName("asdqw-asdfqwer"));
        assertFalse(Validate.checkPhone("3751291234567"));
        assertFalse(Validate.checkPhone("375 1291234567"));
        assertFalse(Validate.checkPhone("17512 1234567"));
        assertFalse(Validate.checkPhone("31512 1234567"));
        assertFalse(Validate.checkPhone("37112 1234567"));
    }

}
