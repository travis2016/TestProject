/**
 *获取用户数据 
 */
function lodaUserData(){
	var url = window.location.href+"/selectAction";
	$.ajax( {
		type : "get",
		url : url,
		contentType: "application/json",
		success : function(data) {
			//data为后台返回的Json信息
			if(data && data.status == "1"){
                var tr = $("#dataString");  //获取dataString的表格参数
				$.each(data.data, function(index,item){ 
						//产生新的tr
						 var clonedTr = tr.clone(true).attr("id","userinfo"+index).insertAfter($("#dataString")); 
						 clonedTr.children("td").each(function(inner_index){  
                           switch(inner_index){  
                                 case(0): 
                                    $(this).html(data.data[index].username);  
                                    break;  
                                 case(1):  
                                	 if(data.data[index].sex==0){
                                		 $(this).html("男");
                                	 }else{
                                		 $(this).html("女");
                                	 }
                                    //$(this).html(data.data[index].sex);  
                                    break;  
                                case(2):  
                                    $(this).html(data.data[index].usernickname);  
                                    break;  
                                case(3): 
                                	if(data.data[index].group==1){
                                		$(this).html("管理组");
                                	}else if(data.data[index].group==2){
                                		$(this).html("测试组");
                                	}else if(data.data[index].group==3){
                                		$(this).html("普通组");
                                	}
                                    //$(this).html(data.data[index].group);  
                                    break;  
                                case(4):  
                                    $(this).html("<button type=\"button\" class=\"btn btn-success\">修改</button>&nbsp;&nbsp;&nbsp;<button type=\"button\" class=\"btn btn-success\" id = \"deleteUser\">删除</button>");  
                                    break;  
               
                          }
				});
				//把克隆好的tr追加原来的tr后面  
                clonedTr.insertAfter(tr);
			});
				$("#dataString").hide();
				//alert(data.data);
			}else if(data.status == 0 && data.error_code.equal('20001')){
				//20001：参数格式错误
				alert("发生错误");
			}
		},
		 error: function(error){ 
	            ///请求出错处理 	             
	            alert('错误信息：'+error.status);
	     } 
	})
}
