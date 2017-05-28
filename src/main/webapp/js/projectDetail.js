var projectDetailsTable;
$(document).ready(function() {  
	// DataTables init
	projectDetailsTable = $("#projectDetail").dataTable({
		"bProcesing"     : true,
		"bServerSide"    : true,
		"bLenthChange"   : false,
		"iDisplayLength" : 10,
		"sScrollY"       : "300px",
		"bSort"			 : false,
		"sAjaxSource"    : "/EPAT2" + "/projectDetails",
		"bFilter"        : false,
		"aoColumns" : [

					    
	                    { 
	                    	"sTitle"  : "Project Id",
	                    	"mData"   : "projectId",
	                    	"bVisible": false

	                    }, 
	                    {
							"sTitle" : "Project Name",
							"mData" : "projectName",
							"sWidth" : "20%",
							"sType" : "title-string"
			
						}, {
							"sTitle" : "task",
							"mData" : "task",
							"sWidth" : "40%",
							"sType" : "title-string"
						},
			
						{
							"sTitle" : "Totla hours",
							"mData" : "totalHours",
							"sWidth" : "20%",
							"sType" : "title-string"
						},
			
						{
							"mData" : null,
							"sClass" : "left",
							"sWidth" : "20%",
							"sDefaultContent" : '<a href="" class="show">IMAGES</a>'
						}
			
					],
		               
		               "fnServerParams" : function(aoData) {
			       			aoData.push({
			       				"name" : "userAction",
			       				"value" : "getAll"
			       			});
		       			},
		               
		               "fnServerData" : function(sSource, aoData, fnCallback) {
		            	   $.ajax({
		            		   "dataType" : 'json',
		            		   "type" : "GET",
		            		   "url" : sSource,
		            		   "data" : aoData,
		            		   "success" :function(json) {
		            			   fnCallback(json);

		            		   }
		            	   });
		               },
		               "sPaginationType" : "full_numbers"

	});
	
	

	$('#projectDetail').on('click', 'a.show', function (e){
		var sData = projectDetailsTable.fnGetData($(this).parents('tr')[0]);
		$.ajax({
			type    : 'GET',
			url     : "/EPAT2" + "/getImages",
			success : function (data) {
				alert(data);
				 $('#imageDetail').html(data);
			}
		});
		return false;
		
		
	} );

	/*
	$('#projectDetail').on('click', 'a.show', function (e){
		var sData = projectDetailsTable.fnGetData($(this).parents('tr')[0]);
		var projectId = sData['projectId'];
		var srcUrl = "/EPAT2" + "/getImages?projectId="+projectId;
		var titleName = 'View';
		var iframe = "imageIFrame";
		var buttonsToAdd = {
				"CLOSE": function() {
		              $( this ).dialog( "close" );
		            }
		          };
		
		createOrEditDomainString(iframe, titleName, srcUrl, buttonsToAdd);
		return false;
	}); */
	
	function createOrEditDomainString(iframe, titleName, srcUrl, buttonsToAdd) {
		var wid = ($(window).width()) * (0.95);
	    var heg = ($(window).height()) * (0.95);
		$('#' + iframe).attr('src',srcUrl);
	    $('#' + iframe).dialog({
	        title: titleName,
	        autoOpen: true,
	        width: wid,
	        height: heg,
	        modal: true,
	        draggable: true,
	        resizable: true,
	        autoResize: true,
	        beforeClose: function (ev, ui) {
	            confirmCancelDialog($(this));
	            return false;
	        },
	        buttons: buttonsToAdd,
	        close: function (ev, ui) {
	        	$('#' + iframe).attr('src', "about:blank");
	            $(this).dialog('destroy');
	        }
	    }).width(wid).height(heg);
	}
	
	function confirmCancelDialog(dialogToClose) {
	    var temp = "<div id='dialog-confirm' title='Confirm'>" +
	        "<font size=2><p align='left' style='padding-left:2em;'>Are you sure you want to cancel?</p></font>" +
	        "</div>";

	    $(temp).dialog({
	        autoOpen: true,
	        maxWidth: 600,
	        maxHeight: 500,
	        width: 450,
	        height: 200,
	        modal: true,
	        resizable: false,
	        buttons: {
	            "NO": function () {
	                $(this).dialog("close");
	                return false;
	            },
	            "YES": function () {
	                $(this).dialog("close");
	                dialogToClose.dialog('option', 'beforeClose', null);
	                dialogToClose.dialog("close");
	            }
	        },
	     });

	}
	
});

