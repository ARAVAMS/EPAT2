<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
 
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <title>jQuery Wookmark Plug-in Example</title>
  <meta name="description" content="An very basic example of how to use the Wookmark jQuery plug-in.">
  <meta name="author" content="Christoph Ono, Sebastian Helzle">
  <meta name="viewport" content="width=device-width,initial-scale=1">

  
    <!-- <link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet" type="text/css" />     -->
    <!--<link href="${pageContext.request.contextPath}/css/magnific-popup.css" rel="stylesheet" type="text/css" />   -->     
    <!--<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />	-->
    <link href="${pageContext.request.contextPath}/css/stylesheet.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/jquery.fancybox.min.css" rel="stylesheet" type="text/css" />	
    
    <script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery/jquery.js"></script>
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
	<script type="text/javascript"	src="${pageContext.request.contextPath}/js/jquery/jquery.fancybox.min.js"></script>
<!-- 
<script src="jquery.min.js"></script>
<script src="jquery.js"></script>
<link rel="stylesheet" href="jquery.fancybox.min.css" />
<script src="jquery.fancybox.min.js"></script>  -->

</head>

<body>

  <div id="container">
    <div id="main" class="gallery">
      <ul id="tiles">
        <!-- These are our grid blocks  
         <li>
          <a data-fancybox="gallery" href="https://s3-ap-southeast-1.amazonaws.com/aravamtest/test.png?X-Amz-Date=20150628T153651Z&X-Amz-Expires=300&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Signature=b236dff32d6a9e519c7b227bd840be54ea3a74f16b70aac71db91fa6a2dc02da&X-Amz-Credential=ASIAIYPLMCQNG3GJ7PUA/20150628/ap-southeast-1/s3/aws4_request&X-Amz-SignedHeaders=Host&x-amz-security-token=AQoDYXdzEEkakAKZ0dHEUHKBjFnZLSJbflJo9G8kjReZC7jF1HrxdvLmk8TJmbAU05z6l8%2B9COAIhI%2BGvch92ydpLFbJY7bIYy2xIH2C1U8HfSPT2YAqVcl2LeskDJaDLEucM1xB4luohquetjd4VBshFJ4SaWJBIXG8diKMimJ5Nu7/8KMXb2pYnk7agQAwro8fkwPELx1C68K%2B9XGWpEL83ULIDPlwuck3aWZxZnil9g4gz/Ehy7ISBZeUWLk4vvPRHcAUaOL9aVWYsKNrTYOsu5p5Bj4pmwancgFJNxijqnUVlqeWpISgx%2B5jM4d5diwcn%2Bm0PLAbqTAjIRqH6dgdiXKgknSS5VQaSIahdLBTp09umh76gmf1ZiD9qMCsBQ%3D%3D">
            <img src="https://s3-ap-southeast-1.amazonaws.com/aravamtest/test.png?X-Amz-Date=20150628T153651Z&X-Amz-Expires=300&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Signature=b236dff32d6a9e519c7b227bd840be54ea3a74f16b70aac71db91fa6a2dc02da&X-Amz-Credential=ASIAIYPLMCQNG3GJ7PUA/20150628/ap-southeast-1/s3/aws4_request&X-Amz-SignedHeaders=Host&x-amz-security-token=AQoDYXdzEEkakAKZ0dHEUHKBjFnZLSJbflJo9G8kjReZC7jF1HrxdvLmk8TJmbAU05z6l8%2B9COAIhI%2BGvch92ydpLFbJY7bIYy2xIH2C1U8HfSPT2YAqVcl2LeskDJaDLEucM1xB4luohquetjd4VBshFJ4SaWJBIXG8diKMimJ5Nu7/8KMXb2pYnk7agQAwro8fkwPELx1C68K%2B9XGWpEL83ULIDPlwuck3aWZxZnil9g4gz/Ehy7ISBZeUWLk4vvPRHcAUaOL9aVWYsKNrTYOsu5p5Bj4pmwancgFJNxijqnUVlqeWpISgx%2B5jM4d5diwcn%2Bm0PLAbqTAjIRqH6dgdiXKgknSS5VQaSIahdLBTp09umh76gmf1ZiD9qMCsBQ%3D%3D" width="200" height="252">
          </a>
          <p>1</p>
        </li> -->
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_2_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_2.png" width="150" height="211">
          </a>
          <p>2</p>
        </li>
      	<li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_3_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_3.png" width="150" height="211">
          </a>
          <p>3</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_4_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_4.png" width="150" height="211">
          </a>
          <p>4</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_5_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_5.png" width="150" height="211">
          </a>
          <p>5</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_6_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_6.png" width="150" height="211">
          </a>
          <p>6</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_7_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_7.png" width="150" height="211">
          </a>
          <p>7</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_8_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_8.png" width="150" height="211">
          </a>
          <p>8</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_9_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_9.png" width="150" height="211">
          </a>
          <p>9</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_10_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_10.png" width="150" height="211">
          </a>
          <p>10</p>
        </li> 
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_1_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_1.png" width="150" height="211">
          </a>
          <p>11</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_2_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_2.png" width="150" height="211">
          </a>
          <p>12</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_3_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_3.png" width="150" height="211">
          </a>
          <p>13</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_4_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_4.png" width="150" height="211">
          </a>
          <p>14</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_5_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_5.png" width="150" height="211">
          </a>
          <p>15</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_6_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_6.png" width="150" height="211">
          </a>
          <p>16</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_7_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_7.png" width="150" height="211">
          </a>
          <p>17</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_8_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_8.png" width="150" height="211">
          </a>
          <p>18</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_9_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_9.png" width="150" height="211">
          </a>
          <p>19</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_10_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_10.png" width="150" height="211">
          </a>
          <p>20</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_1_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_1.png" width="150" height="211">
          </a>
          <p>21</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_2_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_2.png" width="150" height="211">
          </a>
          <p>22</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_3_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_3.png" width="150" height="211">
          </a>
          <p>23</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_4_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_4.png" width="150" height="211">
          </a>
          <p>24</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_5_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_5.png" width="150" height="211">
          </a>
          <p>25</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_6_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_6.png" width="150" height="211">
          </a>
          <p>26</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_7_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_7.png" width="150" height="211">
          </a>
          <p>27</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_8_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_8.png" width="150" height="211">
          </a>
          <p>28</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_9_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_9.png" width="150" height="211">
          </a>
          <p>29</p>
        </li>
        <li>
          <a data-fancybox="gallery" href="${pageContext.request.contextPath}/sample-images/image_10_big.png">
            <img src="${pageContext.request.contextPath}/sample-images/image_10.png" width="150" height="211">
          </a>
          <p>30</p>
        </li> 
        <!-- End of grid blocks -->
      </ul>

    </div>
  </div>

</body>
</html>
