<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Tester</title>
</head>
<body>
	<hr>
	添加位置
	<form action="location/add">
		<p>
			key <input name="key" />
		</p>
		<p>
			lng <input name="lng" />
		</p>
		<p>
			lat <input name="lat" />
		</p>
		<p>
			alt <input name="alt" />
		</p>
		<p>
			speed <input name="speed" />
		</p>
		<p>
			direction <input name="direction" />
		</p>
		<p>
			datetime <input name="datetime" value="20130205081407" />
		</p>
		<p>
			loctype <select name="loctype">
				<option value="1">基站</option>
				<option value="2">GPS</option>
				<option value="3">AGPS</option>
				<option value="4">北斗</option>
				<option value="5">其他</option>
			</select>
		</p>
		<p>
			locacc <input name="locacc" /> <input type="submit" value="submit">
		</p>
	</form>
	<hr>
	<h2>周边</h2>
	<form action="loction/nearby">
		<p>
			key <input name="key" />
		</p>
		<p>
			type <select name="type">
				<option value="0">所有</option>
				<option value="1">快递员</option>
				<option value="2">司机</option>
				<option value="3">公共用户</option>
			</select>
		</p>
		<p>
			lng <input name="lng" />
		</p>
		<p>
			lat <input name="lat" />
		</p>
		<p>
			query <select name="query">
				<option value="1">周边</option>
				<option value="2">矩形</option>
			</select>
		</p>
		<p>
			r <input name="r" />
		</p>
		<p>
			w <input name="w" />
		</p>
		<p>
			h <input name="h" />
		</p>
		<p>
			dt <input name="dt" />
		</p>
		<input type="submit" value="submit">
	</form>
	<hr>
	<h2>用户</h2>
	<form action="loction/user">
		<p>
			key <input name="key" />
		</p>
		<p>
			usercode <input name="usercode" />
		</p>
		<p>
			fdt <input name="fdt" />
		</p>
		<p>
			edt <input name="edt" />
		</p>
		<input type="submit" value="submit">

	</form>
</body>
</html>