<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script type="text/javascript">
	window.onload = function(){
			var vm1 = new Vue({
				el:"#test1",
				data : {
					a1 : 100
				},
				// Vue 객체가 관리할 요소들이 만들어지기 전에 호출되는 함수
				beforeCreate: function(){
					console.log("Vue 객체가 관리할 요소들이 만들어지기 전 입니다.")
					console.log("a1 : "+ this.a1)
				},
				created : function(){
					console.log("Vue 객체가 관리할 요소들이 만들어진 후 입니다.")
					console.log("a1 :" +this.a1)
				},
				//Vue 객체가 관리할 HTML 태그 객체가 할당 되기 전
				beforeMount: function(){
					console.log("Vue 객체가 관리할 태그가 할당 되기 전 입니다.")
				},
				//Vue 객체가 관리할 HTML 태그 객체가 할당 된 후
				mounted : function(){
					console.log("Vue 객체가 관리할 태그가 할당 된 이후 입니다.")
				},
				beforeUpdate : function(){
					console.log("관리하고 있는 HTML 요소 내부가 변경되기 전 입니다.")
				},
				updated : function(){
					console.log("관리하고 있는 HTML 요소 내부가 변경된 후 입니다.")
				},
				beforeDestory: function(){
					console.log("Vue 객체의 기능이 소멸되기 전입니다.")
				},
				destroyed: function(){
					console.log("Vue 객체의 기능이 소멸된 후 입니다.")
				}
				methods: {
					setValue : function(){
						this.a1 = 200
					}
				}
			})
			
		vm1.$mount("#test1")
		vm1.$destroy()
	
	}
</script>
</head>
<body>
	<div id="test1">
			<h3>{{a1}}</h3>
			<button type="button" v-on:click="setValue">값 변경</button>
	</div>
	
</body>
</html>