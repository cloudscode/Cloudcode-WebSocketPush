<!DOCTYPE html>
<html lang="en">
<head>
    <#include "classpath:com/cloudcode/framework/common/ftl/head.ftl"/>
</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar" data-twttr-rendered="true">
<div id="dialogDiv">
<div class="container" id="layout">
<div class="col-lg-9 col-sm-9" id="article">
<section id="button">
        <button id="openwindow" class="ui-button-success">添加</button>
        <button id="edit" class="ui-button-primary">编辑</button>
        <button id="view" class="ui-button-warning">查看</button>
        <button id="delete" class="ui-button-danger">删除</button>
        <button id="refresh" class="ui-button-info">刷新</button>
</section></div></div>
<div class="row">
    <div class="col-lg-12 col-sm-12">
        <table id="jqGrid01" style="width:100%;"></table>
        <div id="jqGridPager01"></div>
    </div>
</div>
<#include "classpath:com/cloudcode/framework/common/ftl/vendor.ftl"/>
<!--jqGrid-->
<script src="${request.getContextPath()}/static/jquery/ui/bootstrap/third-party/jqGrid/jqGrid/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/static/jquery/ui/bootstrap/third-party/jqGrid/jqGrid/js/jquery.jqGrid.js" type="text/javascript"></script>
<!--end jqGrid-->
<script type="text/javascript">
var grid = null;
$(function(){
    if ($.fn.jqGrid){
       grid =  $("#jqGrid01").jqGrid({
           url:"${request.getContextPath()}/remindInf/query",
            datatype: "json",
            height: 250,
            rowNum: 10,
            rowList: [10,20,30],
            colNames:['Id', 'a','b','c','d','e','f','g'],
            colModel:[
                {name:'id',index:'id', width:60, hidden:true},
                {name:'a',index:'exchange', width:100,render:function(){
                	return "123";
                }},
                {name:'b',index:'groupType', width:90},
                {name:'c',index:'code', width:90},
                {name:'d',index:'code', width:90},
                {name:'e',index:'code', width:90},
                {name:'f',index:'code', width:90},
                {name:'g',index:'code', width:90}
                
            ],
            autowidth: true,
            height: "auto",            
            pager: "#jqGridPager01",
            viewrecords: true,
            caption: "Sample jqGrid Table",
            hidegrid:false,
            multiselect: true,
            altRows: true
        });
        jQuery("#jqGrid01").jqGrid('navGrid','#pager2',{edit:true,add:false,del:false});
    }

$( "#openwindow" ).click(function(){
	$( "#divInDialog" ).dialog({
	 	 modal: true,
	 	 width:800,
		open: function(event, ui) {
  			 $('#divInDialog').load('${request.getContextPath()}/remindInf/create', function() {
   				
 		 	 });
	 	 },	   
	    close: function (event, ui) {  
	       grid.trigger("reloadGrid");
	    }  
	});
});
$( "#edit" ).click(function(){
	var id; 
	id = grid.jqGrid('getGridParam','selarrrow');
	$( "#divInDialog" ).dialog({
	 	 modal: true,
	 	 width:800,
		open: function(event, ui) {
  			$('#divInDialog').load('${request.getContextPath()}/remindInf/'+id+'/update', function() {
 		 	 });
	  },	   
    close: function (event, ui) {  
       grid.trigger("reloadGrid");
    }  
	});
}); 
$( "#delete" ).click(function(){
var id;
	     id = grid.jqGrid('getGridParam','selrow');
	     if(id.toString() != null && id.toString() != ""){
		    $.ajax({
			        url: '${request.getContextPath()}/remindInf/deleteAll',
			        type: 'post',
			        dataType: 'json',
			        data: {'ids':id.toString()},
			        success: function(data) {
 						grid.trigger("reloadGrid");
			                 }
			    });
			    }else{
			    	ajaxframework.createDialog("操作提示！","请选择要删除的数据！",{});
			    }
	});
	$( "#view" ).click(function(){
		grid.trigger('reloadGrid');
	});
	$( "#refresh" ).click(function(){
		grid.trigger('reloadGrid');
	});
	 $("#layout button,.button,#sampleButton").button();
}); 
</script>
<div id="divInDialog" style="display:none"></div>
</div>
</body>
</html>