package com.epam.kharkiv.vet.rest.groups;

import com.epam.kharkiv.vet.api.test.FailScenarioTestGroup;
import org.junit.Ignore;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The class SuccessfulTestsGroup.
 *
 * @author Maksym_Nebliienko
 */
@Ignore
@RunWith(Categories.class)
@IncludeCategory(FailScenarioTestGroup.class)
@SuiteClasses({ServiceTestsGroup.class, RepositoryTestsGroup.class})
public class FailTestsGroup {
}
