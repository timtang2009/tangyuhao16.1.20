<%@ include file="/WEB-INF/jsp/common/includes.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../common/header.jsp">
    <jsp:param name="title" value="列表"/>
</jsp:include>

<div class="container clearfix">
    <tags:sidebar categories="${categories}" currentCateId="${param.cateId}"/>

    <div class="contentRight">
        <h2 class="mt_15 f14">文章列表</h2>
        <div class="navTab2th mt_15 clearfix">
            <a href="#" class="current">最新的<span class="num numRed">${paginate.totalCount}</span></a>
            <a href="#">最受欢迎的</a>
            <a href="#">我的文章</a>
        </div>
        <table width="100%" cellspacing="0" class="tableListNew mt_10">
            <tr class="trHead">
                <td width="380">标题</td>
                <td width="100">作者</td>
                <td width="100">类别</td>
                <td width="80">创建时间</td>
                <td width="80">更新时间</td>
            </tr>
            <c:forEach var="article" items="${paginate.pageList}">
                <tr class="tr">
                    <td><a href="/article/${article.id}">${article.title}</a></td>
                    <td>${article.username}</td>
                    <td>${article.categoryName}</td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${article.createdAt}"/></td>
                    <td><c:if test="${not empty article.createdAt}"><fmt:formatDate pattern="yyyy-MM-dd" value="${article.createdAt}"/></c:if></td>
                </tr>
            </c:forEach>
        </table>
        <app:paginate/>
    </div>
</div>
<jsp:include page="../common/footer.jsp"/>
