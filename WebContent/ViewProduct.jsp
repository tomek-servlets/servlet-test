<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty userName}">

<jsp:include page="/WEB-INF/ViewHellper/header.jsp" flush="true"></jsp:include>
</c:if>
<c:if test="${not empty userName}" >
<jsp:include page="/WEB-INF/ViewHellper/headerforLogged.jsp" flush="true"></jsp:include>
</c:if>

<div class="container">

	<div class="row">

		<div class="col-lg-12">


<br><br><br>
			<h1>${Value.title }</h1>


			<hr>
              <h1>Cost: ${Value.price} $</h1>
                 <form action="addtocart">
              <input type="hidden" name="name" value="${Value.id }">
               <button type="submit"  class="btn btn-success " value="Add to cart">Buy</button>
            </form>
			<!-- Preview Image -->
			<img class="img-responsive center-block" width="500" src="getImage.jsp?id=${Value.id }" alt="">
        
			<hr>

			<!-- Post Content -->
			<p class="lead">${Value.descMore}</p>
            

		</div>
	</div>
</div>










<jsp:include page="/WEB-INF/ViewHellper/footer.jsp"></jsp:include>