package test.util;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 *  Util class for testing pojo classes. 
 */
public class PojoTestUtil {

    private String[] pojoPackages;
    private Set<PojoClass> pojoClasses = new HashSet<>();
    private PojoValidator pojoValidator;

    public void setPojoPackages(String[] pojoPackages) {
        this.pojoPackages = pojoPackages;
    }

    private void preparePojoValidator() {
        pojoValidator = new PojoValidator();
        // Create Testers to validate behaviour for POJO_PACKAGE
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
    }

    private void preparePojoClasses() {
        for (String pojoPackage : pojoPackages) {
            pojoClasses.addAll(PojoClassFactory.getPojoClassesRecursively(pojoPackage, null));
        }
    }

    public void testPojos() {
        preparePojoClasses();
        preparePojoValidator();
        for (PojoClass pojoClass : pojoClasses) {
            pojoValidator.runValidation(pojoClass);
            enumTest(pojoClass);
        }
    }

    private <T extends Enum<T>> void enumTest(PojoClass pojoClass) {
        if (pojoClass.isEnum()) {
            Class<T> classToTest = (Class<T>) pojoClass.getClazz();
            for (T value : EnumSet.allOf(classToTest)) {
                String v = StringUtils.replaceChars(value.toString(), "_", "");
                // Assert.assertTrue(StringUtils.isAllUpperCase(v));
                Assert.assertTrue(StringUtils.isAlpha(v));
            }
        }
    }
}
