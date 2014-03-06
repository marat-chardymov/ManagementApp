<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title></title>
    <link href="css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="css/app.css" rel="stylesheet">
    <meta charset="utf-8">

    <script src="js/lib/jquery-1.11.0.min.js"
            type="text/javascript"></script>
    <script src="js/lib/jquery_validation/jquery.validate.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type='text/javascript' src="js/lib/ie_support/html5shiv.js"></script>
    <script type='text/javascript' src="js/lib/ie_support/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<tiles:insert attribute="header"/>
<tiles:insert attribute="menu"/>
<tiles:insert attribute="body"/>
<tiles:insert attribute="footer"/>
</body>
</html>