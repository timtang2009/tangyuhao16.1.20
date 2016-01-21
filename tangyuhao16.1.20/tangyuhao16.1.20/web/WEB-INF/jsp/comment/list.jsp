<%@ include file="/WEB-INF/jsp/common/includes.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../common/header.jsp">
    <jsp:param name="title" value="列表"/>
</jsp:include>

<div class="container clearfix">
    <tags:sidebar categories="${categories}" currentCateId="${param.cateId}"/>

    <div class="contentRight">
        <h2 class="mt_15 f14">评论列表</h2>
        <div class="mv_10 grey666">
            <c:forEach items="${paginate.pageList}" var="comment">
                <div class="r mt_10">
                    <p><a href="http://130.dooioo.com/home/85318" target="_blank" class="bold">雷磊</a> <span class="grey999">2012-11-02 13:25:37</span></p>
                    <div class="mt_15">
                        <p>${comment.content}</p>
                        <p class="mt_5"><a href="comment_edit.html">编辑</a><a href="#" class="red ml_10">删除</a></p>
                    </div>
                </div>
            </c:forEach>
        </div>
        <app:paginate/>
    </div>
</div>
<!--begin: footer-->
<div class="footer clearFix">©2011 德佑地产 </div>
<!--end: footer-->
</body>
</html>
