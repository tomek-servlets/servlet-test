<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<c:if test="${empty userName}">

<jsp:include page="/WEB-INF/ViewHellper/header.jsp" flush="true"></jsp:include>
</c:if>
<c:if test="${not empty userName}" >
<jsp:include page="/WEB-INF/ViewHellper/headerforLogged.jsp" flush="true"></jsp:include>
</c:if>
<!-- Page Content -->


<div class="container">


	<div class="row">

		<div class="col-md-3">
			<p class="lead">Shop Name</p>
			<div class="list-group">
				<a href="GetAllProductsWithValue?tag=cpu" class="list-group-item">Cpu</a>
				<a href="GetAllProductsWithValue?tag=motherboard"
					class="list-group-item">Motherboards</a> <a
					href="GetAllProductsWithValue?tag=graphic_card"
					class="list-group-item">GPU</a> <a
					href="GetAllProductsWithValue?tag=ram" class="list-group-item">MM
					RAM</a> <a href="GetAllProductsWithValue?tag=ac"
					class="list-group-item">AC</a> <a
					href="GetAllProductsWithValue?tag=harddrive"
					class="list-group-item">HardDrives</a> <a
					href="GetAllProductsWithValue?tag=body" class="list-group-item">Body</a>

			</div>
		</div>
		<br>
		<br>
		<br>

		<div class="col-md-9">
		<div class="alert alert-warning">
	<c:if test="${empty Message}">	
<c:if test="${empty userName}">
Hello <strong>Guest</strong>
</c:if>
<c:if test="${not empty userName}" >
    Welcome <strong>${userName.name} </strong>
</c:if>
<c:if test="${empty admin}">

</c:if>
<c:if test="${not empty admin}" >
 You are admin :<a href="admin/newproduct.html">  <button class="btn btn-large btn-primary" type="submit">Add product</button> </a> 
</c:if>

</c:if>
			<c:if test="${not empty Message}" >
			<strong>${Message} </strong>
		</c:if>	
</div>

<br><br><br>

<div class="row carousel-holder">

				<div class="col-md-12">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img class="slide-image" src="images/computer3.jpg"
									style="width: 800px; height: 450px;">
							</div>
							<div class="item">
								<img class="slide-image" src="images/computer2.jpg"
									style="width: 800px; height: 450px;">
							</div>
							<div class="item">
								<img class="slide-image" src="images/computer1.jpg"
									style="width: 800px; height: 450px;">
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
<br>
			</div>
			<br><br>
				<div class="row">
				  <form action="SearchProduct"  method="GET">
           <div id="custom-search-input">
                <div class="input-group col-md-12">
               
                    <input type="text" name="search" class="  search-query form-control" placeholder="Search" />
                    <span class="input-group-btn">
                        <button class="btn btn-danger" type="submit">
                            <span class=" glyphicon glyphicon-search"></span>
                        </button>
                
                    </span>
                           
                </div>
            </div>
             </form>
	</div>
			<br>
			<br>
<h4>CPU</h4>
	<hr>
			<div class="row">
	<c:forEach items="${Cpu}" var="Cpu">
				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="getImage.jsp?id=${Cpu.id }"  class="img-responsive" style="width: 100px; height:150px;">
						<div class="caption">
							<h4 class="pull-right">$ ${ Cpu.price}</h4>
							<h4>
							   <a class="btn btn-primary" href="ViewProduct?id=${Cpu.id}">View Product <span class="glyphicon glyphicon-chevron-right"></span></a><br><br>
							</h4>
							        <form action="addtocart">
              <input type="hidden" name="name" value="${Cpu.id }">
               <button type="submit"  class="btn btn-success " value="Add to cart">Buy</button>
            </form>
							<p>
							${Cpu.title }
							</p>
						</div>

					</div>
				</div>
		</c:forEach>
			</div>
			
		
			<h4>GPU</h4>
			<hr>
				<div class="row">
	<c:forEach items="${Gpu}" var="Gpu">
				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="getImage.jsp?id=${Gpu.id }" >
						<div class="caption">
							<h4 class="pull-right">$ ${ Gpu.price}</h4>
							<h4>
							   <a class="btn btn-primary" href="ViewProduct?id=${Gpu.id}">View Product <span class="glyphicon glyphicon-chevron-right"></span></a><br><br>
							</h4>
							        <form action="addtocart">
              <input type="hidden" name="name" value="${Gpu.id }">
               <button type="submit"  class="btn btn-success " value="Add to cart">Buy</button>
            </form>
							<p>
							${Gpu.title }
							</p>
						</div>

					</div>
				</div>
		</c:forEach>
			</div>
			
			
			
					<h4>Body</h4>
			<hr>
				<div class="row">
	<c:forEach items="${Body}" var="Gpu">
				<div class="col-sm-4 col-lg-4 col-md-4">
					<div class="thumbnail">
						<img src="getImage.jsp?id=${Gpu.id }" >
						<div class="caption">
							<h4 class="pull-right">$ ${ Gpu.price}</h4>
							<h4>
							   <a class="btn btn-primary" href="ViewProduct?id=${Gpu.id}">View Product <span class="glyphicon glyphicon-chevron-right"></span></a><br><br>
							</h4>
							        <form action="addtocart">
              <input type="hidden" name="name" value="${Gpu.id }">
               <button type="submit"  class="btn btn-success " value="Add to cart">Buy</button>
            </form>
							<p>
							${Gpu.title }
							</p>
						</div>

					</div>
				</div>
		</c:forEach>
			</div>
			
			
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/ViewHellper/footer.jsp"></jsp:include>
