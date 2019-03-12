<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link rel="stylesheet" href="Resource/css/pages/import.css" />
<link href="/Eoullim/user/member/style.css" rel="stylesheet"
	type="text/css">

	<script src="Resource/js/common/libs/modernizr.custom.js"></script>
	<script src="Resource/js/common/libs/greensock/TweenMax.min.js"></script>
	<script src="Resource/js/common/libs/greensock/easing/EasePack.min.js"></script>
	<script src="Resource/js/common/libs/jquery-1.9.1.min.js"></script>

	<script src="Resource/js/common/libs/slick.min.js"></script>
	<script src="Resource/js/common/libs/jquery.event.move.js"></script>
	<script src="Resource/js/common/libs/jquery.rwdImageMaps.min.js"></script>

	<script src="Resource/js/common/styleship/mighty.base.1.5.5.min.js"></script>
	<script src="Resource/js/common/styleship/mighty.slide.4.2.2.min.js"></script>
	<script src="Resource/js/common/styleship/matizResizeMap.1.0.0.min.js"></script>
	<script src="Resource/js/common/styleship/matizCoverLayer.3.1.0.min.js"></script>
	<script src="Resource/js/common/styleship/mighty.sort.1.2.1.min.js"></script>
	<script
		src="Resource/js/common/libs/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="Resource/js/common/styleship/matizResizeMap.1.0.0.min.js"></script>
	<script src="Resource/js/pages/jquery.youtubebackground.js"></script>

	<script src="Resource/js/common/default.js"></script>
	<script src="Resource/js/common/cookie.js"></script>

	<script type="text/javascript" src="//wcs.naver.net/wcslog.js">
		
	</script>
	<link rel="stylesheet" href="Resource/css/pages/member.css">
		<script src="Resource/js/pages/login.js"></script>
		<script src="Resource/js/pages/member.js"></script>
		<link rel="stylesheet" href="Resource/css/common/jquery-ui.css">
			<link rel="stylesheet" href="Resource/css/pages/table.css">
				<link rel="stylesheet" href="Resource/css/pages/mypage.css">
					<link rel="stylesheet" href="Resource/css/pages/customer.css">
						<script src="Resource/js/pages/mypage.js"></script>
						<link rel="stylesheet" href="Resource/css/pages/list.css">
							<script src="Resource/js/pages/list.js"></script>
							<script src="Resource/js/pages/faq.js"></script>
							<meta charset="utf-8">
								<title>Q&A 상세보기</title> <!-- <link rel="stylesheet" href="?.css" type="text/css"></link> CSS설정-->
								<script type="text/javascript">
									function open_win_noresizable(url, name) {
										var oWin = window
												.open(url, name,
														"scrollbars=no,status=no,resizable=no,width=300,height=150");
									}
								</script>
</head>

<body>
	<center>

		<!-- start of :: contents -->
		<div id="contents">
			<div class="mypage_wrap">
				<div class="lnb_wrap">

					<h2 class="title_style">
						<a href=adminqnalist.action">QNA게시판</a>
					</h2>
					<ul>
						<li><a href="adminqnalist.action">목록으로</a></li>
					</ul>

				</div>
				<!-- //lnb_wrap -->
				<!-- con_wrap -->
				<div class="con_wrap">
					<div class="select_box m_lnb no_over d_hidden">


						<a href="#">Q&A</a>

					</div>

					<h2 class="title_style2">Q&A</h2>
					<div class="customer_view">
						<h2 class="tit">
							<s:property value="resultClass.qna_sub" />
						</h2>
						<div class="view_box">
							<div>
								 <s:if test="%{resultClass.img_file == null}"></s:if> 
								 	<s:else>
										<img src="/Eoullim/upload/<s:property value="resultClass.img_file"/>" width="700px">
									</s:else>
								<div>
									<s:property value="resultClass.qna_content" />
								</div>							
							</div>
						</div>
					</div>
					<!--view_sns_box-->
					<div class="view_sns_box"></div>
					<div class="view_top_box bottom">
						<td align="right" colspan="2"><s:url id="modifyURL"
								action="modifyForm">
								<s:param name="qna_no">
									<s:property value="qna_no" />
								</s:param>
							</s:url> <s:url id="deleteURL" action="deleteAction">
								<s:param name="no">
									<s:property value="no" />
								</s:param>
							</s:url> <s:if test="%{member_id == resultClass.qna_name}">
								<input name="list" type="button" value="삭제" class="hreflink"
									onClick="javascript:location.href='adminqnadelete.action?qna_no=<s:property value="qna_no"/>&currentPage=<s:property value="currentPage" />'" />
							</s:if> <s:else>
								<input name="list" type="button" value="답글달기" class="hreflink"
									onClick="javascript:location.href='adminqnareply.action?qna_no=<s:property value="qna_no"/>&currentPage=<s:property value="currentPage" />'" />
							</s:else> <input name="list" type="button" value="목록" class="hreflink"
							onClick="javascript:location.href='adminqnalist.action?currentPage=<s:property value="currentPage" />'"></td>
							
					</div>
					<!-- //view_sns_box -->
				</div>
			</div>
			<!-- //con_wrap -->
		</div>
		<!--//customer_wrap-->

		</div>

		</tr>
		</table>
</body>
</center>
</html>

