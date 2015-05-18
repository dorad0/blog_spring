package blog.controller.impl;

import blog.service.ArticleService;
import blog.service.impl.ArticleServiceImpl;
import blog.web.controller.ArticleController;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by alex on 5/8/2015.
 */
public class ArticleControllerTest {


//    @Test
//    public void testGetArticles() {
//
//        ArticleService articleService = mock(ArticleServiceImpl.class);
//        ArticleController articleController = new ArticleController(articleService);
//
//        String viewName = articleController.createArticle(new Model() {
//            @Override
//            public Model addAttribute(String attributeName, Object attributeValue) {
//                return null;
//            }
//
//            @Override
//            public Model addAttribute(Object attributeValue) {
//                return null;
//            }
//
//            @Override
//            public Model addAllAttributes(Collection<?> attributeValues) {
//                return null;
//            }
//
//            @Override
//            public Model addAllAttributes(Map<String, ?> attributes) {
//                return null;
//            }
//
//            @Override
//            public Model mergeAttributes(Map<String, ?> attributes) {
//                return null;
//            }
//
//            @Override
//            public boolean containsAttribute(String attributeName) {
//                return false;
//            }
//
//            @Override
//            public Map<String, Object> asMap() {
//                return null;
//            }
//        });
//
//        assertEquals("createArticleForm", viewName);
//    }
}
