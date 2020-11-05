<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle Report</title>

	<style>
		table, th, td {
		  border: 1px solid black;
		  border-collapse: collapse;
		}
	</style>
</head>
<body>
	<table style="width:100%">
	  <tr>
		<th>Vehicle No</th>
		<th>Engine No</th>
		<th>Chassis No</th>
		<th>Manufactured Year</th>
		<th>Registered Year</th>
		<th>Engine Capacity</th>
		<th>Vehicle Image</th>
		<th>Vehicle Class</th>
		<th>Vehicle Make</th>
		<th>Vehicle Model</th>
		<th>Fuel Type</th>
	  </tr>
	  
		<c:forEach items="${masterList}" var="vmaster">
			<tr>
				<td>${vmaster.vehicleID}</td>
				<td>${vmaster.engineNo}</td>
				<td>${vmaster.chassisNo}</td>
				<td>${vmaster.manufactureYear}</td>
				<td>${vmaster.registeredYear}</td>
				<td>${vmaster.engineCapacity}</td>
				<td>
		
					<c:if test = "${vmaster.vehicleImg != null}">
						<img src="data:image/jpg;base64,${vmaster.vehicleImgView}" width="80" height="60"/>
					</c:if>
										
				</td>
				<td>${vmaster.vmodel.vehicleClass.vehicleClass}</td>
				<td>${vmaster.vmodel.vehicleMakeID.vehicleMake}</td>
				<td>${vmaster.vmodel.vehicleModel}</td>
				<td>${vmaster.ftype.fuel}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>