<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit"/><!-- 让360浏览器默认选择webkit内核 -->
    <title>诚信回收-手机选择</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/mint-ui/lib/style.css">
</head>
<body>
<div id="app">
    <mt-button @click.native="handleClick">按钮</mt-button>
</div>
</body>
<!-- 先引入 Vue -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- 引入组件库 -->
<script src="https://unpkg.com/mint-ui/lib/index.js"></script>
<script>
    new Vue({
        el: '#app',
        methods: {
            handleClick: function() {
                this.$toast('${test1}')
                <#--this.$toast('${test2}')-->
                <#--this.$toast('${test3}')-->
                <#--this.$toast('${test4}')-->
            }
        }
    })
</script>
</html>