<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/mypage/my-comunity.css" />
</head>
<%@ include file="/header.jsp"%>
<body>
   <main>
      <!-- 목록 -->
      <div class="my-comunityBox">
         <div class="my-leftbox">
            <div class="my-hello">
               <div class="my-wellcome">반가워요!</div>
               <div class="my-nickname">"${sessionScope.member.memberName}"님</div>
            </div>
            <div class="my-category">
               <div class="my-category-menu">메뉴</div>
               <div class="my-line"></div>
               <a
                  href="${pageContext.request.contextPath}/app/mypage/my-passcheck.jsp">
                  <div class="my-category-menu">개인정보수정</div>
               </a> <a
                  href="${pageContext.request.contextPath}/app/mypage/my-comunity.my">
                  <div class="my-category-menu">내가 작성한 글</div>
               </a> <a href="${pageContext.request.contextPath}/app/mypage/my-pick.my">
                  <div class="my-category-menu">찜목록</div>
               </a> <a
                  href="${pageContext.request.contextPath}/app/mypage/my-quit.jsp">
                  <div class="my-category-menu">회원탈퇴</div>
               </a>
            </div>
         </div>

         <!-- 게시글 조회 -->
         <div class="my-rightbox">
            <div class="my-comunity">
               <div class="my-comunity-title">게시글 조회</div>
               <div class="my-line"></div>

               <div class="my-comunity-center">

                  <h3>${sessionScope.member.memberName}님이작성한글 조회</h3>
                  <div class="my-comunity-info">
                     <div class="my-comunity-info-title">제목</div>
                     <div class="my-comunity-info-author">닉네임</div>
                     <div class="my-comunity-info-date">날짜</div>
                  </div>

                  <ul class="my-comunity-ul">
                     <c:forEach var="item" items="${mywritepage}">

                        <li><a href="${pageContext.request.contextPath}/community/comu-detail.cm?boardNumber=${item.boardNumber}" class="my-comunity-info-list">

                              <div class="my-comunity-info-list">
                                 <div class="my-comunity-info-title">[${item.boardCate}]
                                    ${item.boardTitle}</div>
                                 <div class="my-comunity-info-author">
                                    ${sessionScope.member.memberName}</div>
                                 <div class="my-comunity-info-date">
                                    ${item.boardRegistDate}</div>
                                    
                              </div>
                        </a></li>
                     </c:forEach>
                  </ul>

               </div>

               <!--     <div class="info-bg2">
            <div class="bottom-list">
              <a class="prev" onfocus="blur()" href="#"></a>
              <a class="num on" onfocus="blur()" href="#">1</a>
              <a class="num" onfocus="blur()" href="#">2</a>
              <a class="num" onfocus="blur()" href="#">3</a>
              <a class="num" onfocus="blur()" href="#">4</a>
              <a class="num" onfocus="blur()" href="#">5</a>
              <a class="next" onfocus="blur()" href="#"></a>
            </div>
          </div>    -->

            </div>

         </div>
      </div>
      </div>

   </main>
</body>
<%@ include file="/footer.jsp"%>
</html>