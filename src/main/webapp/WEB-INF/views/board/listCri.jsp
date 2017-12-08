<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<script>
var result = '${msg}';

if(result == 'SUCCESS'){
	alert("처리가 완료되었습니다.")
}
</script>

    <!-- Main content -->
    <section class="content">
        <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box">
                <table class="table table-bordered">
                    <tr>
                        <th style="width:10px">BNO</th>
                        <th>Title</th>
                        <th>Writer</th>
                        <th>Regdate</th>
                        <th style="width:40px">ViewCnt</th>
                    </tr>
                    
                    <c:forEach items="${list}" var="boardVO">
                        <tr>
                            <td>${boardVO.bno}</td>
                            <td><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a></td>
                            <td>${boardVO.writer}</td>
                            <td><fmt:formatDate pattern="yyyy-mm-dd HH:mm" value="${boardVO.regdate}"/></td>
                            <td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
                        </tr>
                    </c:forEach>
                    
                </table>
            </div>
        </div> <!-- /.col (left) -->
        </div> <!-- /.row -->
    </section> <!-- /.content -->

<%@include file="../include/footer.jsp" %>
