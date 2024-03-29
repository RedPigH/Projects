<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="ko">

<head>
<script src="/moviecube/resources/js_test/jquery-1.12.4.min.js"></script>
<%@ include file="/WEB-INF/views/main/head.jspf"%>
<link rel="stylesheet" type="text/css"
	href="/moviecube/resources/css/member.css" />
<script type="text/javascript"
	src="/moviecube/resources/js/init.controls.js"></script>
<script>
function deleteRes(res_no) {
	Swal.fire({
		title: "예매를 취소하시겠습니까?",
		showCloseButton: true,
        showCancelButton: true,
        focusConfirm: false,
        confirmButtonText:
          '<a style="all: unset;" href="/moviecube/reserve_delete.do?res_no='+ res_no +'">확인</div>',
        cancelButtonText:
          '취소',
	})	
}
</script>


<script type="text/javascript">
function viewReply(qna_no) {
	/* 선택된 좌석 정보 */
	
	var data = {
		"qna_no" : qna_no
	};
	
	$.ajax({
				type : "POST",
				url : "<c:url value='/qnaAdminDetail.do'/>",
				dataType : "json",
				data : data,
				
				success : function(data) {
					var img_url = "";
					var qna_sub = "제목  <br/>" + data.adminMap.QNA_SUB;
					var qna_content = '<br/><br/> <div class="p-b-15">' + data.adminMap.QNA_CONTENT + '</div>';
					
					if(data.qna_savname != null) {
						img_url = data.qna_savname;
						Swal.fire({
				    		  title: qna_sub,
				    		  html: qna_content,
				    		  showCloseButton: true,
				    		  focusConfirm: false,
				    		  imageUrl: '/moviecube/resources/upload/qna/' + img_url,
					    	  imageHeight: 250,
				    		})
					} else {
						Swal.fire({
							  title: qna_sub,
				    		  html: qna_content,
				    		  showCloseButton: true,
				    		  focusConfirm: false,
				    		})
					}
					
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("오류가 발생하였습니다.");
				}
			}); 
	
}
</script>

</head>

<body class="animsition">
	<%@ include file="/WEB-INF/views/main/body_header.jspf"%>
	<%@ include file="/WEB-INF/views/main/wishList.jspf"%>
	<%@ include file="/WEB-INF/views/member/loginForm.jspf"%>

	<c:if test="${empty sessionScope.userLoginInfo}">
		<script type="text/javascript">
			history.go(-1);
		</script>
	</c:if>


	<c:if test="${not empty sessionScope.userLoginInfo}">
		<section class="bg0 p-t-140 p-b-80">
			<div class="container">
				<div class="flex-w flex-tr">
					<div class="size-217 w-full-md">
						<div class="flex-w flex-sb-m p-t-18 p-b-30 p-lr-50 p-lr-15-sm">
								<h4 class="mtext-109 cl2 p-b-30" style="padding-left: 150px; padding-bottom: 0px">마이페이지</h4>
							</div>
						<div class="row" style="margin: auto; justify-content: center;">
							<div class="cols col1">
								<!-- 개인정보 -->
								<div id="myPageMainUser" class="mypage_myInfo">
									<div class="h3_wrap mb20">
										<h3>
											<img
												src="http://image2.megabox.co.kr/mop/home/mypage/main_title3.png"
												alt="개인정보">
										</h3>
										<a href="/moviecube/member/updateMemberForm.do"
											style="display: block;"
											class="flex-c-m stext-107 cl13 float-r size-301 bor21 p-lr-15 hov-tag2 trans-04">정보수정</a>
									</div>

									<ul>
										<c:if test="${profile_savname != '0' }">
											<li>
												<img src="/moviecube/resources/upload/mypage/${profile_savname}" width="100px" height="100px" />
											</li>
										</c:if>
										<c:if test="${profile_savname == '0' }">
											<img src="/moviecube/resources/images/icons/default_profile.png" width="100px" height="100px" />
										</c:if>
										<li><strong>이름</strong> <span>${sessionScope.userLoginInfo.MEMBER_NAME}님</span>
										</li>
										<li><strong>휴대폰</strong> <span>${sessionScope.userLoginInfo.MEMBER_PHONE}</span>
										</li>
									</ul>


									<script type="text/javascript">
										$('span.btn_sms')
												.children('button')
												.click(
														function() {
															$('span.btn_sms')
																	.children(
																			'button')
																	.removeClass(
																			'active');
															$('span.btn_sms')
																	.children(
																			'button')
																	.each(
																			function() {
																				$(
																						this)
																						.attr(
																								"title",
																								$(
																										this)
																										.val());
																			});
															$(this).addClass(
																	'active');
															$(this)
																	.attr(
																			'title',
																			$(
																					this)
																					.val()
																					+ ' 선택됨');
														});
									</script>
									<script>
										
									</script>
								</div>


								<!-- 나의 무비스토리 -->
								<div id="myPageMainMovieStory" class="mypage_main_box"
									style="height: 242px;">
									<div class="h3_wrap p-l-20 p-r-20 m10">
										<h3 style="height: 23px;">
											<img
												src="http://image2.megabox.co.kr/mop/home/mypage/main_title7.png"
												alt="나의 무비스토리">
										</h3>
									</div>

									<ul class="mypage_main_moviestory m-t-30">
										<li><a href="javascript:void(0)" class="js-show-cart"
											data-notify="0" title="보고싶어 보기"> <span><img
													src="http://image2.megabox.co.kr/mop/home/mypage/main_icon1.png"
													alt=""></span> <strong class="ml10">보고싶어</strong> <strong
												class="c_red pull-right">${fn:length(sessionScope.WishList)}</strong>
										</a></li>
										<li><a href="javascript:void(0)"
											onclick="showMenu('mypage-moviestory', 'seen')"
											title="본영화 보기"> <span><img
													src="http://image2.megabox.co.kr/mop/home/mypage/main_icon2.png"
													alt=""></span> <strong class="ml10">본영화</strong> <strong
												class="c_red pull-right">${res_count }</strong>
										</a></li>
									</ul>
									<script>
										
									</script>
								</div>
							</div>

							<div id="myPageMyBooking" class="cols col2">
								<!-- 나의 예매내역 -->
								<div class="mypage_main_box" style="height: 505px;">
									<div class="h3_wrap pb38 bor22">
										<h3>
											<img
												src="http://image2.megabox.co.kr/mop/home/mypage/main_title4.png"
												alt="최근 예매 내역">
										</h3>
									</div>
									<c:choose>
            							<c:when test="${fn:length(resList) > 0 }">
               								<c:forEach items="${resList}" var="row">
               									<c:set var="resdate" value="${row.RES_DATE }"/>
               									<ul class="type2">
               										<li id="res_moviename" class="no_data text-left pa20" style="margin-top:10px; margin-bottom:8px;">영화제목 :  ${row.MOVIE_NAME } </li>
               											<a href="javascript:deleteRes(${row.RES_NO })" class="flex-c-m stext-101 cl0 size-reserve-button bg10 bor23 hov-btn2 p-lr-5 trans-04 m-b-2"
               											onclick="deleteRes(${row.RES_NO})" style="float:right; border-radius:5px">예매취소</a>
               										<li class="no_data text-left pa20"> (${fn:substring(resdate,0,10)})</li>
               										<hr style="margin-bottom:8px; margin-top:10px;">
               									</ul>
               								</c:forEach>
               							</c:when>
               							<c:otherwise>
               								<ul class="type2">
												<li class="no_data text-center pa30">조회된 내역이 없습니다</li>
											</ul>
               							</c:otherwise>
               						</c:choose>
								</div>
							</div>

							<div class="cols col3">
								<div id="myPageMyQuestion" class="mypage_main_box"
									style="height: 505px;">
									<div class="positionR">
										<div class="h3_wrap pb38 bor22">
											<h3>
												<img src="http://image2.megabox.co.kr/mop/home/mypage/main_title8.png" alt="나의문의내역">
											</h3>
										</div>
										<ul class="type1"></ul>

									<c:choose>
            							<c:when test="${fn:length(qnaList) > 0 }">
               								<c:forEach items="${qnaList}" var="row">
               									<c:set var="regdate" value="${row.QNA_REGDATE }"/>
               									<c:set var="qnasub" value="${row.QNA_SUB }"/>
               								
               									<ul class="type2">
               										<c:if test="${fn:length(qnasub) < 10 }">
               											<li id="res_moviename" class="no_data text-left pa20">제목 :  ${row.QNA_SUB } </li>
               										</c:if>
               										<c:if test="${fn:length(qnasub) > 10 }">
               											<li id="res_moviename" class="no_data text-left pa20">제목 :  ${fn:substring(qnasub,0,10)}... </li>
               										</c:if>
               										
               										<c:if test="${row.QNA_STATUS == 0 }">
               											<p class="flex-c-m stext-101 cl0 size-reserve-button bg11 bor23 p-lr-5 trans-04 m-b-2"
               											style="float:right; border-radius:5px;">대기중</p>
               										</c:if>
               										<c:if test="${row.QNA_STATUS == 1 }">
               											<button onclick="viewReply(${row.QNA_NO})" class="flex-c-m stext-101 cl0 size-reserve-button bg10 bor23 p-lr-5 trans-04 m-b-2"
               											style="float:right; border-radius:5px;">답변완료</button>
               										</c:if>
               										<li class="no_data text-left pa20"> ${fn:substring(regdate,0,19)}</li>
               										<hr style="margin-bottom:8px; margin-top:8px;">
               									</ul>
               								</c:forEach>
               							</c:when>
               							<c:otherwise>
               								<ul class="type2">
												<li class="no_data text-center pa30">조회된 내역이 없습니다</li>
											</ul>
               							</c:otherwise>
               						</c:choose>



									</div>
								</div>
							</div>



						</div>
					</div>
				</div>
			</div>
		</section>
	</c:if>
<%@ include file="/WEB-INF/views/main/body_footer.jspf"%>
	<%@ include file="/WEB-INF/views/main/script.jspf"%>

</body>
</html>