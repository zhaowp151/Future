<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<script type="text/javascript" src="<%=basePath %>plugins/layui-v2.2.5/layui/layui.js"></script>
<link rel="stylesheet" href="<%=basePath %>plugins/layui-v2.2.5/layui/css/layui.css" media="all" />
</head>
<body>
<form class="layui-form" action="">
		<div class="layui-tab-item layui-show layui-form-table_Z">
			<table class="layui-table">
				<tbody>
					<tr>
						<td align="right" style="width: 30%"><div class="layui-form-item layui-inline">
								<label class="layui-form-label">字典名称：</label>
							</div></td>
						<td>
							<div class="layui-input-inline">
								<input type="text" name="id" lay-verify="required"
									autocomplete="off" class="layui-input">
							</div>
						</td>
					</tr>
					<tr>
						<td align="right"><div class="layui-form-item layui-inline">
								<label class="layui-form-label">字典代码：</label>
							</div></td>
						<td>
							<div class="layui-input-inline">
								<input type="text" name="flg" lay-verify="required"
									autocomplete="off" class="layui-input">
							</div>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<button class="layui-btn layui-btn-small"
								lay-submit="" lay-filter="submit">保存</button>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		layui.use([ 'form', 'laydate' ], function() {
			var form = layui.form, laydate = layui.laydate;
			var $ = layui.jquery;
			//监听提交
			
			
			form.on('submit(submit)', function(data) {
				$.ajax({
					async:false,
					url : "wpMain/core/WpFunction/add",
					data: data.field,
					type : 'post'
				});
				return false;
			});
		});
	</script>




</body>
</html>
