(function ($) {

$('#allUserDelete').click(function(){
	alert("12");
	var numMac = $('#numMac').text();
	if(!confirm('해당 계정 삭제하시겠어요?')) return;
	$.ajax({
		url:'/admin/userDeleted/'+numMac,
		method:'get',
		cache:false,
		dataType:'json',
		success:function(res){
			alert(res.result ? '삭제 성공':'삭제 실패');
			location.href="/admin/allUser";
		},
		error:function(xhr,status, err){
			alert('에러:'+err);
		}
	});
	return false;
	
});
    



$('#allFreeBoardDelete').click(function(){
	alert("12");
	var numMac = $('#numMac').text();
	alert(numMac)
	if(!confirm('해당 게시물을 삭제하시겠어요?')) return;
	$.ajax({
	    url:'/admin/freeBoardDeleted/'+numMac,
		method:'get',
		cache:false,
		dataType:'json',
		success:function(res){
			alert(res.result ? '삭제 성공':'삭제 실패');
			location.href="/admin/allFreeBoard";
		},
		error:function(xhr,status, err){
			alert('에러:'+err);
		}
	});
	return false;
	
});

$('#allAdsBoardDelete').click(function(){
	var numMac = $('#numMac').text();
	if(!confirm('해당 게시물 삭제하시겠어요?')) return;
	$.ajax({
		url:'/admin/adsBoardDeleted/'+numMac,
		method:'get',
		cache:false,
		dataType:'json',
		success:function(res){
			alert(res.result ? '삭제 성공':'삭제 실패');
			location.href="/admin/allAdsBoard";
		},
		error:function(xhr,status, err){
			alert('에러:'+err);
		}
	});
	return false;
	
});

$('#allCommentDelete').click(function(){
	var numMac = $('#numMac').text();
	if(!confirm('해당 게시물 삭제하시겠어요?')) return;
	$.ajax({
		url:'/admin/commentDeleted/'+numMac,
		method:'get',
		cache:false,
		dataType:'json',
		success:function(res){
			alert(res.result ? '삭제 성공':'삭제 실패');
			location.href="/admin/allComment";
		},
		error:function(xhr,status, err){
			alert('에러:'+err);
		}
	});
	return false;
	
});




})(jQuery);