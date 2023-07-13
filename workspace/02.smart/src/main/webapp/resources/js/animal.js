/**
 * 
 */
 
 //사진 크게 보기
 $(document).on('click','.popfile img',function(){
	$('#modal-image .modal-body').html($(this).clone());
	$('#modal-image .modal-body img').removeAttr('style');
	new bootstrap.Modal($('#modal-image')).show();
	
	
	
	page.curPage = pageNo;
	var animal = page;
	animal.sido = $('#sido').length==0?'':$('#sido').val();
	
})





//시도 조회
	function animal_sido(){
		$.ajax({
			url:'animal/sido',
		}).done(function(response){
			$('.animal-top').append(response);
		})
	}
 
 //유기동물 목록 조회
function animal_list(pageNo){
	$('.pharmacy-top').addClass('d-none');
	$('#data-list').empty();
	$('.pagination').closest('nav').remove(); 
	$('.loading').show();
	
	if($('#sido').length==0) animal_sido(); //시도 조회
	
	
	
	page.curPage = pageNo;
	var animal = page;
	animal.sido = $("#sido").length ==0? '':$("#sido").val();
	
	
	
	$.ajax({
		url:'animal/list',
		data : JSON.stringify(animal),
		type:'post',
		contentType:'application/json',
		//data:{pageNo:pageNo, rows:page.pageList},
		async: false,
	}).done(function(response){
		$('#data-list').html(response);
		
		
	})
	
	setTimeout(function(){ $('.loading').hide()},500);
	
	
}