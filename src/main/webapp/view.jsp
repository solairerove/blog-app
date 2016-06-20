<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects/>
<head>
    <script> var URL_PATH = "<%=request.getContextPath()%>"</script>
    <script>document.write('<base href="' + document.location + '" />');</script>
    <title>Angular 2</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <script src="https://npmcdn.com/core-js/client/shim.min.js"></script>
    <script src="https://npmcdn.com/zone.js@0.6.12?main=browser"></script>
    <script src="https://npmcdn.com/reflect-metadata@0.1.3"></script>
    <script src="https://npmcdn.com/systemjs@0.19.27/dist/system.src.js"></script>

    <script src="<%=request.getContextPath()%>/systemjs.config.js"></script>

    <script>
        System.import('app').catch(function (err) {
            console.error(err);
        });
    </script>
</head>

<body>
<my-app>Loading...</my-app>
</body>