<%@ include file="/WEB-INF/jsp/common/includes.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../common/header.jsp">
    <jsp:param name="title" value="${article.title}"/>
</jsp:include>

<div class="container clearfix">
    <input id="articleId" value="${article.id}"/>
    <tags:sidebar categories="${categories}" currentCateId="${param.cateId}"/>
    <div class="contentRight">
        <h2 class="mt_15 f14">文章详情</h2>
        <input type="hidden" id="articleId" value="${article.id}"/>
        <div class="mv_10 grey666">
            <a href="/article">首页</a> &gt;&nbsp;&nbsp;<a href="/article?cateId=${article.categoryId}">${article.categoryName}</a> &gt;&nbsp;&nbsp;${article.title}
            <div class="mv_10">
                <div class="mb_20 clearfix">
                    <h3 class="left lineH180"><a href="#" target="_blank" class="f14 bold ">${article.title}</a></h3>
                    <p class="right">
                        <a href="/article/${article.id}/edit" class="btnOpH24 h24Silver in_block ml_5">编辑</a>
                        <a href="javascript:void(0);" class="btnOpH24 h24Silver in_block ml_5" id="btnDel">删除</a></p>
                </div>
                <p class="grey666 lineH180 In24 f14">${article.content}</p>
                <div class="clearfix mt_20">
                    <div class="right grey999">编辑于
                        <c:if test="${not empty article.updatedAt}"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${article.updatedAt}"/></c:if>
                        <c:if test="${empty article.updatedAt}"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${article.createdAt}"/></c:if>
                    </div>
                </div>
            </div>
        </div>

        <c:forEach items="${comments}" var="comment">
            <div class="r mt_10">
                <p><a href="#" target="_blank" class="bold">xx</a> <span class="grey999 ml_10">2012-11-02 13:25:37</span></p>
                <div class="mt_15">
                    <p>${comment.content}</p>
                    <p class="mt_5"><a href="#">编辑</a><a href="#" class="red ml_10">删除</a></p>

                </div>
            </div>
        </c:forEach>
        <div class="txtRight">
            <a href="/article/${article.id}/comment/list">全部评论>></a>
        </div>

        <div id="rdiv">
            <div class="bg_eee pd_20 mt_20">
                <p class="bold pd_10">回复：</p>
                <input type="textarea" path="content" rows="10" cols="95"/>
                <p class="mt_20"><a href="#" class="btnOpH24 h24Blue in_block" id="submit_comment">提交</a></p>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
$(function(){
    $("#btnDel").click(function(){
        if(!confirm("确定删除吗？")) {
            return false;
        }

        var url = '/article/' + $("#articleId").val();
        ajaxDelete({
               url:url,
               ok: function(data) {
                   alert("删除成功");
                   window.location.href = "/article";
               },

               fail: function(data){
                    alert(data.message);
               }
            }
        );

    });

    $("#submit_comment").click(function(){
        ajaxPost({
            url:'/article/'+ $("#articleId").val() +'/comment/add',
            data:JSON.stringify('{"content":"dddd", "articleId":42}'),
            contentType: 'application/json;charset=utf-8',
            ok: function(data){
                alert(data.status);
                window.location.reload();
            },
            fail:function(data){
                alert(data.message);
            }
        });
    });

    $("#getJson").click(function() {
        window.open('/article/' + $("#articleId").val() + '/getJson3');
    });

    $("#tttt").click(function() {
        ajaxGet({
            url:'/testJson',
            ok:function(data) {
                alert("ok1");
            },
            fail:function(data) {

            }
        });
        alert("ok2");
    });
});
</script>
<jsp:include page="../common/footer.jsp"/>