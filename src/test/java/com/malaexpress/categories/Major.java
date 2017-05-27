package com.malaexpress.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 2017/5/27 0027.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory({Major.class})
public interface Major {
}
