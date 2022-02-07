<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Reports: Init as View</title>
		<!-- Webix Library -->
		<script type="text/javascript" src="https://cdn.webix.com/site/webix.js"></script>
		<link
			rel="stylesheet"
			type="text/css"
			href="https://cdn.webix.com/site/webix.css"
		/>
		<!-- App -->
		<script type="text/javascript" src="https://cdn.webix.com/site/reports/reports.js"></script>
		<link rel="stylesheet" type="text/css" href="https://cdn.webix.com/site/reports/reports.css" />
	</head>
	<body>
		<script>
			webix.ready(function() {
				if (webix.env.touch) webix.ui.fullScreen();
				else if (webix.env.scrollSize) webix.CustomScroll.init();

				webix.ui({
					view: "reports",
					url: "https://docs.webix.com/reports-backend/",
				});
			});
		</script>
	<script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');  ga('create', 'UA-41866635-1', 'auto'); ga('send', 'pageview');</script>
<script src="https://cdn.ravenjs.com/3.19.1/raven.min.js" crossorigin="anonymous"></script>
<script>Raven.config('https://docs.webix.com/reports-backend/11',{ release:'8.1.2'}).install();</script>
</body>
</html>
