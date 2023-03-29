<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #main{
            float: left;
            width: 100%;
            height: 100%;
            border: 1px;
            background-color: yellow;
            padding: 10px;
            margin: 10px;
        }
        #left{
            float: left;
            width: 48%;
            height: 100%;
            border: 1px;
            background-color: aquamarine;
            padding: 10px;
        }
        #right{
            float: right;
            width: 48%;
            height: 100%;
            border: 1px;
            background-color: aquamarine;
            padding: 10px;
        }
        .content{
            margin-top: 45px;
            background-color:lavender;
            padding: 20px;
        }
    </style>
    <script type="text/javascript" src="jquery/jquery-3.1.1.js"></script>
    <script>
        $(function(){

            $("#insert").click( function () {

                var data = {
                    name: $("#name_i").val(),
                    age: $("#age_i").val()
                };

                $.ajax({
                    type: 'post',
                    url: '/insert',
                    contentType: 'application/json;charset:utf-8',
                    data: JSON.stringify(data),
                    success: function (data) {
                        alert(data);
                    }

                })
            })



            $("#delete").click( function () {

                var data={
                    name_d:$("#name_d").val(),
                    age_d:$("#age_d").val()
                };

                $.ajax({
                    type:'post',
                    url:'/delete',
                    contentType:'application/json;charset:utf-8',
                    data:JSON.stringify(data),
                    success:function (data) {
                        alert(data);
                    }

                })

            })


            $("#update").click( function () {

                var data={
                    name_c:$("#name_c").val(),
                    age_c:$("#age_c").val(),
                    name_n:$("#name_n").val(),
                    age_n:$("#age_n").val()

                };

                $.ajax({
                    type:'post',
                    url:'/update',
                    contentType:'application/json;charset:utf-8',
                    data:JSON.stringify(data),
                    success:function (data) {
                        alert(data);
                    }

                })

            })




            $("#query").click( function () {

                var data={
                    name:$("#name_q").val(),
                    age:$("#age_q").val()
                };

                $.ajax({
                    type:'post',
                    url:'/query',
                    contentType:'application/json;charset:utf-8',
                    data:JSON.stringify(data),
                    success:function (data) {
                       $("#rbody tr").remove();//清除数据区
                        var body= $("#rbody");
                        for(var i=0;i<data.length;i++){
                            var tr=$("<tr ></tr>");
                            tr.appendTo(body);
                          var name=data[i].name.toString();
                          var age=data[i].age.toString();
                          $("<td>"+name+"</td>").appendTo(tr);
                          $("<td>"+age+"</td>").appendTo(tr);

                        }






                    }

                })

            })


        })
    </script>


</head>
<body>
<div id="main" class="content">

    <div id="left">
        <div  class="content">
            <div style="color: red">插入数据</div>
            <div>
                </br>姓名：<input id="name_i" type="text" placeholder="name" style="margin-right: 20px"/>
                年龄：<input id="age_i" type="text" placeholder="age" />
                <button  id="insert" class="btn btn-deflaut" style="margin-left: 50px" > 插入</button>
            </div>
        </div>

        <div  class="content">
            <div style="color: red">删除数据</div>
            <div>
                </br> 姓名：<input id="name_d" type="text" placeholder="name"  style="margin-right: 20px"/>
                年龄：<input id="age_d" type="text" placeholder="age" />
                <button id="delete" class="btn btn-deflaut" style="margin-left: 50px" > 删除</button>
            </div>
        </div>


        <div  class="content">
            <div style="color: red">修改数据</div>
            <div>
                <br/>修改条件：<br/>
                姓名：<input id="name_c" type="text" placeholder="name" style="margin-right: 20px" />
                年龄：<input id="age_c" type="text" placeholder="age" />
                <br> 修改为：<br/>
                姓名：<input id="name_n" type="text" placeholder="name" style="margin-right: 20px" />
                年龄：<input id="age_n" type="text" placeholder="age" />
                <button id="update" class="btn btn-deflaut" style="margin-left: 50px" > 修改</button>
            </div>
        </div>

    </div>



    <div  id="right" >
        <div class="content">
            <div ><font color="#FF0000">查询数据</font></div><br/>
            <div class="panel panel-body">
                姓名：<input id="name_q" type="text" placeholder="name" style="margin-right: 20px" />
                年龄：<input id="age_q" type="text" placeholder="age" />
                <button id="query" class="btn btn-deflaut" style="margin-left: 50px" > 查询</button>
                <table id="rtable" style="width:80% ;border: 5px; solid:black">
                    <thead >
                    <tr>
                        <td class="col-xs-2"  style="margin-right: 5px">姓名</th>
                        <td class="col-xs-2"   style="margin-left: 30px">年龄</td>
                    </tr>
                    </thead>
                    <tbody id="rbody">
                    <tr></tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</div>


</body>
</html>
