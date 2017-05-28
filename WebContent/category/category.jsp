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


<br><br><br>
 <!-- Page Heading -->
        <div class="row">
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

            <div class="col-6">
           
                   <h1 class="page-header">${Name}
                </h1>
            </div>
        </div>
        <!-- /.row -->
	<c:forEach items="${List}" var="Product">
	  <!-- Project One -->
        <div class="row">
        
            <div class="col-md-7">
                <a href="ViewProduct?id=${Product.id}">
                    <img class="img-responsive" src="getImage.jsp?id=${Product.id }" alt="">
                </a>
            </div>
            <div class="col-md-5">
                <h3>	${Product.title}</h3>
                <h4>Price : ${Product.price } $</h4>
                <p>${Product.description }</p>
                <a class="btn btn-primary" href="ViewProduct?id=${Product.id}">View Product <span class="glyphicon glyphicon-chevron-right"></span></a><br><br>
                      <form action="addtocart">
              <input type="hidden" name="name" value="${Product.id }">
               <button type="submit"  class="btn btn-success " value="Add to cart">Buy</button>
            </form>
            </div>
        </div>
      
        <!-- /.row -->
	


		

					        
			
			
			</c:forEach>
	

	

</div>
<jsp:include page="/WEB-INF/ViewHellper/footer.jsp"></jsp:include>