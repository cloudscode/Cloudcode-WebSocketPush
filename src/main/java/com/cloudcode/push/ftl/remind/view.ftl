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
    <label for="inputEmail3" class="col-sm-2 control-label">号码</label>
    <div class="col-sm-4">
      ${lottery.strnum}
    </div>
    </div>
</form>

</div>
<#include "classpath:com/cloudcode/framework/common/ftl/vendor.ftl"/>
<script type="text/javascript">
 
</script>
</div>
</body>
</html>