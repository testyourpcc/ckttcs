<%@ page pageEncoding="utf-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>MD CENTER</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<tiles:insertAttribute name="head" />
<!-- DataTables CSS -->
<link href="/static/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">
<!-- DataTables Responsive CSS -->
<link href="/static/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

</head>

<script>
        $(document).ready(function() {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
</script>

<body>



	<tiles:insertAttribute name="header" />


	<tiles:insertAttribute name="menu" />

<div class="container-fluid" style="margin-top: -15px; padding: 0px 80px 0px 80px">
		<tiles:insertAttribute name="body" />
</div>
	<div class="row">
		<tiles:insertAttribute name="aside" />
	</div>


	<tiles:insertAttribute name="footer" />


</body>
</html>