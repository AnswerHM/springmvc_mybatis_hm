<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json交互测试</title>
<script src="${pageContext.request.contextPath}/static/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	// 请求json 输出是json
	function requestJson(){
		$.ajax({
			type:'POST',
			url:'${pageContext.request.contextPath}/requestJson.action',
			contentType:'application/json;charset=utf-8',
			//数据格式是json串
			data:'{"name":"手机","price":999}',
			success:function(data){
				alert(data);
			}
		})
	}
	// 请求key/value,输出是json
	function responseJson(){
		$.ajax({
			type:'POST',
			url:'${pageContext.request.contextPath}/responseJson.action',
			// 请求的是key/value 这里不需要指定contentType，因为默认就是key/value类型
		//	contentType:'application/json;charset=utf-8',
			//数据格式是json串
			data:'name=手机&price=999',
			success:function(data){
				alert(data);
			}
		})
	}
</script>
</head>
<body>
	<input type="button" onclick="requestJson()" value="请求json 输出是json"/>
	<input type="button" onclick="responseJson()" value="请求key/value,输出是json"/>
<canvas id="matrixBG" width="2560" height="1440"></canvas>
<script type="text/javascript">
$(document).ready(function(){
//var s=window.screen;
var width = matrixBG.width = window.screen.width;
var height = matrixBG.height = window.screen.height;
var yPositions = Array(300).join(0).split('');
var ctx=matrixBG.getContext('2d');

var draw = function () {
  ctx.fillStyle='rgba(0,0,0,.05)';
  ctx.fillRect(0,0,width,height);
  ctx.fillStyle='#0F0';
  ctx.font = '10pt Georgia';
  yPositions.map(function(y, index){
    text = String.fromCharCode(30+Math.floor( Math.random()*95 ));
    x = (index * 10)+10;
    matrixBG.getContext('2d').fillText(text, x, y);
    if(y > 100 + Math.random()*1e4)
    {
      yPositions[index]=0;
    }
    else
    {
      yPositions[index] = y + 10;
    }
  });
};
RunMatrix();
function RunMatrix()
{
    if(typeof Game_Interval != "undefined") clearInterval(Game_Interval);
            Game_Interval = setInterval(draw, 33);
}
function StopMatrix()
{
    clearInterval(Game_Interval);
}
/**
//setInterval(draw, 33);
$("button#pause").click(function(){
StopMatrix();});
$("button#play").click(function(){RunMatrix();});
*/
});
</script>
<!-- <script src="https://files.cnblogs.com/files/SimonHu1993/code.js"></script> -->
</body>
</html>