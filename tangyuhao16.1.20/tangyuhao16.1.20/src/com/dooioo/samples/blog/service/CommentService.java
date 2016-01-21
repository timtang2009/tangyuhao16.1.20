package com.dooioo.samples.blog.service;

import com.dooioo.samples.blog.model.Comment;
import com.dooioo.web.common.Paginate;
import com.dooioo.web.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: kuang
 * Date: 12-11-28
 * Time: 下午4:59
 */
@Service
public class CommentService extends BaseService<Comment> {

    public Paginate queryForPaginate(int pageNo, Integer articleId) {
        Comment params = new Comment();
        params.setColumns( " c.*, u.name ");
        params.setTable(" comment c left join users u on u.id = c.userId ");
        params.setOrderBy( " c.id desc ");
        params.setPageNo(pageNo);
        params.setPageSize(5);
        params.setWhere(" c.articleId = " + articleId);
        return super.queryForPaginate2(params);
    }
}
