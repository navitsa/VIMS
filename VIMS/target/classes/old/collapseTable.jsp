<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width">
    <style>
     #container{
        margin:0 auto;
        width:80%;
        overflow:auto;
    }
    table.gridtable {
                margin:0 auto;
                width:95%;
                overflow:auto;
                font-family: helvetica,arial,sans-serif;
                font-size:14px;
                color:#333333;
                border-width: 1px;
                border-color: #666666;
                border-collapse: collapse;
                text-align: center;
        }
        table.gridtable th {
                border-width: 1px;
                padding: 8px;
                border-style: solid;
                border-color: #666666;
                background-color: #F6B4A5;
        }
        table.gridtable td {
                border-width: 1px;
                padding: 8px;
                border-style: solid;
                border-color: #666666;
        }
        .breakrow{
        	background-color: #F6B4A5;
        }
    </style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
    <script>
        $( document ).ready(function() {
            //collapse and expand sections

            //$('.breakrow').click(function(){
			$('#tableMain').on('click', 'tr.breakrow',function(){
                $(this).nextUntil('tr.breakrow').slideToggle(200);
            });
        });
        	
       function getRemarks(str)
		{
			alert(str);
			if (str=="") {
	    		var slctSubcat=$('#cmbRemark'), option="";
	            slctSubcat.empty();
	    	return;
	  		}
	  		else{
				$.ajax({
		        	type: 'GET',
		        	url: "getRemaksforCombo",
		        	data: {"statusID" : str},
		        	success: function(data){
		        
		            	var slctSubcat=$('#cmbRemark'), option="";
		            	slctSubcat.empty();
		            	
		           		selected_option = "<option value='' selected>Select remark...</option>"
		            	slctSubcat.append(selected_option);
		
			            for(var i=0; i<data.length; i++){
			                option = option + "<option value='"+data[i].remarksID + "'>"+data[i].remarks + "</option>";
			            }
		            	slctSubcat.append(option);
		        	},
		        	
		       	 	error:function(){
		            alert("error");
		        	}
		
		    	});
	    	}
		}
    </script>
</head>
<body>
<div class="container" id="container">
        <table class="gridtable" id="tableMain">
            <thead>
                <tr class="tableheader">
                  <th>Item</th>
                  <th>Status</th>
                  <th>Remark</th>
                  <th>Input</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach items="${remark}" var="remark">
					<c:if test = "${remark.is.item.stage.stage != stage}">
                		<tr class="breakrow"><td>${remark.is.item.stage.stage}</td><td></td><td></td><td></td></tr>
                	</c:if>
                	<c:if test = "${remark.is.item.itemName != item}">
                		<c:set var = "test"  value = "${remark.is.item.itemName}"/>
	                		<tr class="datarow">
	                				<td>${remark.is.item.itemName}</td>
	                				<td>
	                					<select onchange="getRemarks(this.value)">
	                						<c:forEach items="${rm}" var="abc">
	                							<c:if test = "${abc.is.item.itemName ==test }">
	                								<option value="${abc.is.profileItemStatusID}">${abc.is.vprofileItemStatus}</option>
	                							</c:if>
	                						</c:forEach>
	                					</select>
	                				</td>
	                				<td>
	                					<select id="cmbRemark" class="cmbRemark">
	                						<c:forEach items="${rem}" var="abcd">
	                							<c:if test = "${abcd.is.item.itemName ==test }">
	                								<option>${abcd.remarks}</option>
	                							</c:if>
	                						</c:forEach>
	                					</select>
	                				</td>
	                				<td>634.50</td>
	                		</tr>
                	</c:if>
                			
                		<c:set var = "stage"  value = "${remark.is.item.stage.stage}"/>
                		<c:set var = "item"  value = "${remark.is.item.itemName}"/>
             	</c:forEach>
            </tbody>
        </table>
    </div>

<!-- 	<button id = "button1" type="button">Load</button> -->

</body>
</html>