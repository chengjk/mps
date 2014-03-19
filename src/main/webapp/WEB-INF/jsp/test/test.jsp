<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<jsp:include page="../menu/header.jsp" />
<body>
	<div class="span12 offset0 well">
		<a target="_blank" href="./location/add/one" class="btn btn-primary">添加一条记录</a>
		<a target="_blank" href="./location/add/random?size=20" class="btn btn-primary">随机添加20条记录</a>
		<a target="_blank" href="./location/findall" class="btn btn-primary">查看全部</a>
		<a target="_blank" href="./location/deleteall" class="btn btn-danger">删除全部</a>
		
	</div>
	
	<div class="span5 offset0 well">
  		<form class="form-horizontal" action="./location/add" method="post" target="_blank">
		  <legend>添加位置</legend>
		  <div class="control-group">
		    <label class="control-label" >key</label>
		    <div class="controls">
		      <input type="text"  name="key" placeholder="key" value="mykey">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" >lng</label>
		    <div class="controls">
		      <input type="text"  name="lng" placeholder="lng" value="66">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" >lat</label>
		    <div class="controls">
		      <input type="text"  name="lat" placeholder="lat"  value="66">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" >alt</label>
		    <div class="controls">
		      <input type="text"  name="alt" placeholder="alt"  value="66">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" >speed</label>
		    <div class="controls">
		      <input type="text"  name="speed" placeholder="speed"  value="66">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" >direction</label>
		    <div class="controls">
		      <input type="text"  name="direction" placeholder="direction"  value="66">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" >loctype</label>
		    <div class="controls">
		      <select name="loctype">
				<option value="1">基站</option>
				<option selected="selected" value="2">GPS</option>
				<option value="3">AGPS</option>
				<option value="4">北斗</option>
				<option value="5">其他</option>
			 </select>
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" >locacc</label>
		    <div class="controls">
		      <input type="text"  name="locacc" placeholder="locacc"  value="50">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <div class="controls">
		      <button type="submit" class="btn btn-primary">提交</button>
		      <button type="reset" class="btn btn-danger">重置</button>
		    </div>
		  </div>
		</form>
 	</div>
 	<div class="span5 offset0 well">
  		<form class="form-horizontal" action="./location/nearby" method="post" target="_blank">
		  <legend>周边</legend>
		  <div class="control-group">
		    <label class="control-label" >key</label>
		    <div class="controls">
		      <input type="text"  name="key" placeholder="key" value="mykey">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" >type</label>
		    <div class="controls">
		      <select name="type">
				<option selected="selected" value="0">所有</option>
				<option value="1">快递员</option>
				<option value="2">司机</option>
				<option value="3">公共用户</option>
			</select>
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" >lng</label>
		    <div class="controls">
		      <input type="text"  name="lng" placeholder="lng" value="70">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" >lat</label>
		    <div class="controls">
		      <input type="text"  name="lat" placeholder="lat"  value="30">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" >query</label>
		    <div class="controls">
		      <select name="query">
				<option value="1">周边</option>
				<option selected="selected" value="2">矩形</option>
			</select>
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <label class="control-label" >r</label>
		    <div class="controls">
		      <input type="text"  name="r" placeholder="r" value="30">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" >w</label>
		    <div class="controls">
		      <input type="text"  name="w" placeholder="w"  value="30">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label">h</label>
		    <div class="controls">
		      <input type="text"  name="h" placeholder="h"  value="30">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label">datetime</label>
		    <div class="controls">
		      <input type="text"  name="h" placeholder="h"  value="20140318223344">
		    </div>
		  </div>
		  <div class="control-group">
		    <div class="controls">
		      <button type="submit" class="btn btn-primary">提交</button>
		      <button type="reset" class="btn btn-danger">重置</button>
		    </div>
		  </div>
		</form>
 	</div>
 	<div class="span5 offset0 well">
  		<form class="form-horizontal" action="./location/user" method="post" target="_blank">
		  <legend>用户</legend>
		  <div class="control-group">
		    <label class="control-label" >key</label>
		    <div class="controls">
		      <input type="text"  name="key" placeholder="key" value="testkey1">
		    </div>
		  </div>
		  
		  
		  
		  <div class="control-group">
		    <label class="control-label" >usercode</label>
		    <div class="controls">
		      <input type="text"  name="usercode" placeholder="usercode"  value="usercode">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" >fdt</label>
		    <div class="controls">
		      <input type="text"  name="fdt" placeholder="fdt"  value="20140319212121">
		    </div>
		  </div>
		  <div class="control-group">
		    <label class="control-label" >edt</label>
		    <div class="controls">
		      <input type="text"  name="edt" placeholder="edt" value="20240319212121">
		    </div>
		  </div>
		  
		  <div class="control-group">
		    <div class="controls">
		      <button type="submit" class="btn btn-primary">提交</button>
		      <button type="reset" class="btn btn-danger">重置</button>
		    </div>
		  </div>
		</form>
 	</div>
	<jsp:include page="../menu/includeScripts.jsp" />
</body>
</html>