package com.epam.kharkiv.vet.rest.groups;

import com.epam.kharkiv.vet.api.test.SuccessfulScenarioTestGroup;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The class SuccessfulTestsGroup.
 *
 * @author Maksym_Nebliienko
 */

@RunWith(Categories.class)
@IncludeCategory(SuccessfulScenarioTestGroup.class)
@SuiteClasses({ServiceTestsGroup.class, RepositoryTestsGroup.class})
public class SuccessfulTestsGroup {
}
