<!DOCTYPE html>
<html lang="en">
<head>
   <#include "classpath:com/cloudcode/framework/common/ftl/head.ftl"/>
</head>
<style>
#updateButton{
	width:80px;
	margin: 2px;
}
</style>
<body data-spy="scroll" data-target=".bs-docs-sidebar" data-twttr-rendered="true"> 
<div id="dialogDiv">
<div class="container" id="layout">
<form role="form" class="form-horizontal" id="myFormId" action="${request.getContextPath()}/menus/createMenu" method="post">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
       <button type="button" id="updateButton" name="num" class="btn btn-primary" value="1">1</button>
       <button type="button" id="updateButton" name="num" class="btn btn-primary" value="2">2</button>
       <button type="button" id="updateButton" name="num" class="btn btn-primary" value="3">3</button>
       <button type="button" id="updateButton" name="num" class="btn btn-primary" value="4">4</button>
       <button type="button" id="updateButton" name="num" class="btn btn-primary" value="5">5</button>
       <button type="button" id="updateButton" name="num" class="btn btn-primary" value="6">6</button>
    </div>
     <div class="col-sm-offset-2 col-sm-10">
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="7">7</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="8">8</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="9">9</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="10">10</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="11">11</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="12">12</button>
     </div>
      <div class="col-sm-offset-2 col-sm-10">
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="13">13</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="14">14</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="15">15</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="16">16</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="17">17</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="18">18</button>
     </div>
     <div class="col-sm-offset-2 col-sm-10">
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="19">19</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="20">20</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="21">21</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="22">22</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="23">23</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="24">24</button>
     </div>
     <div class="col-sm-offset-2 col-sm-10">
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="25">25</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="26">26</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="27">27</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="28">28</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="29">29</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="30">30</button>
     </div>
     <div class="col-sm-offset-2 col-sm-10">
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="31">31</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="32">32</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="33">33</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="34">34</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="35">35</button>
     	<button type="button" id="updateButton" name="num" class="btn btn-primary" value="36">36</button>
     </div>
      <div class="col-sm-offset-2   col-sm-10">
     	<button type="button" id="updateButton" name="calc" class="btn btn-primary" >计算</button>
     	<button type="button" id="updateButton" name="random" class="btn btn-primary" >随机</button>
     	
     </div>
  </div>
</form>

</div>
<#include "classpath:com/cloudcode/framework/common/ftl/vendor.ftl"/>
<script type="text/javascript">
 $('button[name="num"]').click( function() {
 	 if($(this).hasClass("btn-primary")){
 	 	$(this).removeClass("btn-primary").addClass("btn-danger");
 	 }else{
 	 	$(this).removeClass("btn-danger").addClass("btn-primary");
 	 }
 });
  $('button[name="calc"]').click( function() {
  	  var str='';
      $('button[name="num"]').each( function() {
 	 	if($(this).hasClass("btn-danger")){
 	 		str+=$(this).val()+",";
 	 	}
 	 });
 	 window.location.href='${request.getContextPath()}/lottery/view?num='+str;
 	 console.log(str);
  });
  $('button[name="random"]').click( function() {
       
  });
</script>
</div>
</body>
</html>