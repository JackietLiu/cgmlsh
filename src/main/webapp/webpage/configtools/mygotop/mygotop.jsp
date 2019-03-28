	<link href="webpage/configtools/mygotop/css/style.css" rel="stylesheet" type="text/css">
	
	<div class="izl-rmenu">
	    <a class="consult" target="_blank"><div class="phone" style="display:none;">028-68637561</div></a>    
	    <a class="cart"><div class="pic"></div></a>   
	    <a href="javascript:void(0)" class="btn_top" style="display: block;"></a>
	</div>
	<a target="_blank"  href="http://wpa.qq.com/msgrd?v=3&uin=123456&site=qq&menu=yes" id="udesk-feedback-tab" class="udesk-feedback-tab-left" style="display: block; background-color: black;"></a>
	<!--qq聊天代码部分end-->
 
	<script src="/plug-in/jquery/jquery.min.1.11.js" type="text/javascript"></script>  
<script type="text/javascript">
		 /*---------返回顶部----------*/
		   $(function() {
			    $(".btn_top").hide();
				$(".btn_top").on("click",function(){
					$('html, body').animate({scrollTop: 0},300);return false;
				})
				$(window).bind('scroll resize',function(){
					if($(window).scrollTop()<=300){
						$(".btn_top").hide();
					}else{
						$(".btn_top").show();
					}
				})
		   })
		   /*---------返回顶部 end----------*/
	</script>
 