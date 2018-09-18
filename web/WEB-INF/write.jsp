<%--
  Created by IntelliJ IDEA.
  User: 5CLASS-184
  Date: 2018-09-13
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/header.jsp" %>

<div id="page-wrapper">
    <table width="100%">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Write</h1>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <form action="write" method="post">
                            <label>제목</label>
                            <input class="form-control" placeholder="Enter Title" name="title">
                            <label>작성자</label>
                            <input class="form-control" placeholder="Enter Your Name" name="mname">
                            <div class="form-group" size="height: 350px; max-width: 1080px" style=" text-align: left">
                                <label>내용</label>
                                <textarea class="form-control" rows="3" placeholder="Enter Text"
                                          name="content"></textarea>
                                <button class="btn btn-outline btn-primary btn-sm" style="position: absolute; left: 0;">
                                    등록
                                </button>
                            </div>
                        </form>
                        <form action="list">
                            <button class="btn btn-outline btn-primary btn-sm" style="position: absolute; right: 0;">
                                취소
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </table>
</div>


<%--<form action="/write" method="post">--%>

<%--<div class="form-group">--%>
<%--<label>제목</label>--%>
<%--<input class="form-control" name="title">--%>
<%--<label>작성자</label>--%>
<%--<input class="form-control" placeholder="Enter text" name="mname">--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<div style="height: 350px; max-width: 1080px; text-align: left">--%>
<%--<label>내용</label>--%>
<%--<input class="form-control" placeholder="Enter text" name="content">--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="panel-footer">--%>
<%--<div style="height: auto; max-width: 1080px; text-align: right;">--%>
<%--<button class="btn btn-outline btn-primary btn-sm">등록</button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</form>--%>
<%--<div class="panel-footer">--%>
<%--<div style="height: auto; max-width: 1080px; text-align: right;">--%>
<%--<form action="/list">--%>
<%--<button class="btn btn-outline btn-primary btn-sm">취소</button>--%>


<%@ include file="includes/footer.jsp" %>