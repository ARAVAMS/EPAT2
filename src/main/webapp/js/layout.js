$(document).ready(function() {
	setupUserDetails();
	alignFooter();
	loadContent('body',getContextRoot() + '/eceHome','eceBody');
	
});

window.onresize=function(){
	if (typeof resizeDatatable == 'function') { 
		resizeDatatable(); 
	}
	alignFooter();
};

function alignFooter(){
	var headerHeight = $("#eceHeader").height();
	var userDetailsHeaderHeight = $("#userDetailsHeader").height();
	var window_size = window.innerHeight;
	var footerHeight = $("#eceFooter").height();
	$("#eceBody").css('height',(window_size - ((headerHeight)+userDetailsHeaderHeight+(1.8*footerHeight))) + "px");
	$("#vert_line").css('height',(window_size - ((headerHeight)+userDetailsHeaderHeight+(2*footerHeight))) + "px");
}

function setupUserDetails(){
	$(".userContextDetails").hide();
	
	$(".userContext").on("hover", function(){
		$(".userContextDetails").toggle().position({
			  my: "left top",
			  at: "left bottom",
			  of: ".userContext"
		});	
	});
	
	$(".logout").on("click", function(){
		 logOff();
	});
	
	$(".configGroups").on("click", function(){
		 showUserConfigDetails();
	});
}
