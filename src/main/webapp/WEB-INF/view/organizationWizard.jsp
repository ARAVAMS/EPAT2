<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta charset='utf-8' />
<title>Registration form</title>
 	 <link href="${pageContext.request.contextPath}/css/rt3.css" rel="stylesheet" type="text/css" />
 	 <link href="${pageContext.request.contextPath}/css/organization.css" rel="stylesheet" type="text/css" />
	 <link href="${pageContext.request.contextPath}/css/jquery-ui.css" rel="stylesheet" type="text/css" />	
	 <link href="${pageContext.request.contextPath}/css/jquery.roadmap.css" rel="stylesheet" type="text/css" />	
	 <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />	
	 <script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery/jquery.min.js'></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.watermarkinput.js"> </script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/rt3.js"> </script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/organization.js"> </script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.roadmap.js"> </script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"> </script>
	 
	
</head>

<body>
    <script>
        var userData = {
            login: "",
            email: "",
            initials: "",
            phone: "",
            birth: "",
            workplace: "",
            liveplace: "",
            workpost: "",
            groups: []
        };

        $(function () {

            var rmp = $("#rmp").Roadmap({
                width: 650,                         
                allowJump: false,                    
                formsContainer: "#rmp_forms",     
                checkpoints: [                      
                    {
                        text: "Create Organization",                        
                        form: "div.account"
                       
                    },
                    
                    {
                        text: "Setup Project",
                        form: "div.personal"
                    },
                    
                    {
                        text: "Configure Setting",
                        form: "div.confirm",
                    },
                    {
                        text: "Invite Members",
                        form: "div.finished",
                        hndl: function (i) {
                            var d = [];
                            $(userData.groups).each(function (i, o) {
                                d.push(o.d + "<br/>");
                            });
                            $("div.finished div.dgroups").html(d.join(""));

                            if (userData.login.length > 0 &&
                                userData.email.length > 0 &&
                                userData.initials.length > 0 &&
                                userData.groups.length > 0) {
                                $("div.finished")
                                    .find("[name=dinit]").val(userData.initials).end()
                                    .find("[name=dlogin]").val(userData.login).end()
                                    .find("[name=demail]").val(userData.email).end()
                                    .find("div.buttons input").removeClass("disabled");
                            }
                            else $("div.finished").find("div.buttons input").addClass("disabled");
                        }
                    }],
                voyagerPosition: 0,                 										
                onInit: null,                       												
                ckeckpointNext: function (i) { console.log("voyager pos:" + i); },               	
                ckeckpointPrev: function (i) { console.log("voyager pos:" + i); },               	
            });

            $("input[prev]").click(function () {
                rmp.MovePrev();
            });

            $("input[next]").click(function () {
                var waypoint = rmp.CurrentPosition();
                
                switch (waypoint) {
                    case 0:                        
                        userData.login = $("div.account input[name=login]").val();
                        break;

                       
                    case 1:
                        userData.initials = $("div.personal input[name=init]").val();
                        break;

                    case 2:
                        userData.groups = [];
                        $("div.confirm input[type=checkbox]:checked").each(function (i, o) {
                            userData.groups.push({ i: $(o).val(), d: $(o).attr("d") });
                        });
                        if (userData.groups.length == 0) {
                            var chk = $("div.confirm input[type=checkbox]:first").attr("checked", "checked");
                            userData.groups.push({
                                i: chk.val(),
                                d: chk.attr("d")
                            });
                        }                
                        break;
                }

                rmp.MoveNext();
            });

            $("#finishEM").click(function () {
                if (!$(this).hasClass("disabled")) {
                    alert("Registration completed, redirecting...");
                    document.location.reload();
                }
            })

            $("span#v").html(rmp.Version());
        });
    </script>
    <form:form id="organizationForm" name="organizationForm" modelAttribute="organizationForm" >
    <div class="content">
    <h1>
    Welcome to EPAT2 set up project page
    </h1>
        <div id="rmp"></div>
        <div id="rmp_forms">
            <div class="form account" role="form">
                <h1>Create Organization</h1>
                <span class="label">Organization Name</span>
                <input type="text" name="login" title="Enter an organization name">
                <div class="buttons">
                    <input type="button" next value="NEXT &gt;">
                </div>
            </div>

            <div class="form personal" role="form">
                <h1>Create project for your organization</h1>
                <span class="label">Project Name</span>
                <input type="text" name="init" title="Enter an project name">
                <div class="buttons">
                    <input type="button" next value="NEXT &gt;">
                </div>
            </div>

            <div class="form confirm" role="form">
                <h1>TBD</h1>
                <div style="font-size:13px; color:#313131">
                    <div><input type="checkbox" value="2" d="A" />a</div>
                    <div><input type="checkbox" value="3" d="B" />b</div>
                    <div><input type="checkbox" value="4" d="C" />c</div>
                    <div><input type="checkbox" value="5" d="D" />d</div>
                </div>
                <div class="buttons">
                    <input type="button" next value="NEXT &gt;">
                </div>
            </div>

            <div class="form finished" role="form">
                <h1>TBD</h1>
                <span class="label">tbd</span>
                <input type="text" name="dinit" disabled>
                <span class="label">tbd</span>
                <input type="text" name="dlogin" disabled>
                <span class="label">tbd</span>
                <input type="text" name="demail" disabled>
                <span class="label">tbd</span>
                <div class="dgroups"></div>
                <div class="buttons">
                    <input type="button" value="SAVE" id="finishEM" class="disabled" />
                </div>
            </div>
        </div>
        <br><br><br><br> <br><br>
     </div>
     </form:form>
    
</body>
</html>