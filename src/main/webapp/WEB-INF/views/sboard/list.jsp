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
                <!-- 검색 조 -->
                <div class="box">
                    <div class="box-header with-border">
                        <h3 class="box-title">Board List</h3>
                    </div>
                    <div class="box-body">
                        <select name="searchType">
                            <option value="n" <c:out value="${cri.searchType == null ?'selected' : '' }"/>>---</option>
                            <option value="t" <c:out value="${cri.searchType eq 't' ? 'selected' : '' }"/>>Title</option>
                            <option value="c" <c:out value="${cri.searchType eq 'c' ? 'selected' : '' }"/>>Content</option>
                            <option value="w" <c:out value="${cri.searchType eq 'w' ? 'selected' : '' }"/>>Writer</option>
                            <option value="tc" <c:out value="${cri.searchType eq 'tc' ? 'selected' : '' }"/>>Title Or Content</option>
                            <option value="cw" <c:out value="${cri.searchType eq 'cw' ? 'selected' : '' }"/>>Content Or Writer</option>
                            <option value="tcw" <c:out value="${cri.searchType eq 'tcw' ? 'selected' : '' }"/>>Title Or Content Or Writer</option>
                        </select>
                        <input type="text" name="keyword" id="keywordInput" value="${cri.keyword}">
                        <button id="searchBtn">Search</button>
                        <button id="newBtn">New Board</button>
                    </div>
                </div>
                
                <div class="box">
                    <div class="box-header with-border">
                        <h3 class="box-title">LIST PAGING</h3>
                    </div>
                    <div class="box-body">
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
                                    <td><a href="/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${boardVO.bno}">${boardVO.title} <strong>[ ${boardVO.replycnt} ]</</strong></a></td>
                                    <td>${boardVO.writer}</td>
                                    <td><fmt:formatDate pattern="yyyy-mm-dd HH:mm" value="${boardVO.regdate}"/></td>
                                    <td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">
                            <ul class="pagination">
                                <c:if test="${pageMaker.prev}">
                                    <li><a href="list${pageMaker.makeSearch(pageMaker.startPage -1) }">&laquo;</a></li>
                                </c:if>
                                <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
                                    <li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
                                        <a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
                                    </li>
                                </c:forEach>
                                <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                                    <li><a href="list${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
                                </c:if>
                            </ul>
                    </div>
                </div>
            </div> <!-- /.col (left) -->
        </div> <!-- /.row -->
    </section> <!-- /.content -->
    <script>
    <!-- 조회조건 관련 script -->
    $(document).ready(function(){
    		
    		$("#searchBtn").on("click", function(event){
    			self.location = "list"
    					+ "${pageMaker.makeQuery(1)}"
    					+ "&searchType="
    					+ $("select option:selected").val()
    					+ "&keyword=" + encodeURIComponent($("#keywordInput").val());
    		});
    		
    		$("#newBtn").on("click", function(event){
    			self.location = "register";
    		});
    });
    
    </script>
<%@include file="../include/footer.jsp" %>
