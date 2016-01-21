package com.dooioo.samples.blog.service;

import com.dooioo.samples.blog.model.Article;
import com.dooioo.web.common.Paginate;
import com.dooioo.web.service.BaseService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-11-2
 * Time: 下午4:06
 */
@Service
public class ArticleService extends BaseService<Article> {

    public Paginate queryForPaginate(int pageNo) {
        return queryForPaginate(pageNo, null);
    }

    public Paginate queryForPaginate(int pageNo, Integer categoryId) {
        Article params = new Article();
        params.setColumns( " a.id, a.title, a.content, a.categoryId, a.createdAt, c.name as categoryName, u.name as username ");
        params.setTable(" article a left join category c on a.categoryId = c.id left join users u on u.id = a.userId ");
        params.setOrderBy( " a.id desc ");
        params.setPageNo(pageNo);
        if(categoryId == null || categoryId == 0) {
            params.setWhere(" a.status != -1 ");
        } else {
            params.setWhere(" a.status != -1 and a.categoryId = " + categoryId);
        }
        return queryForPaginate2(params);
    }
}
