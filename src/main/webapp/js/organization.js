var editItemIDSize = 0 ;
var tempOrgCount=0;
var orgCount=1;	
var orgNumber=1;
var removedOrg=[];
var tempOrgNumber = editItemIDSize;
$(document).ready(function() {	
	
	$('input[type="text"]').each(function(){
		 
	    this.value = $(this).attr('title');
	    $(this).addClass('text-label');
	 
	    $(this).focus(function(){
	        if(this.value == $(this).attr('title')) {
	            this.value = '';
	            $(this).removeClass('text-label');
	        }
	    });
	 
	    $(this).blur(function(){
	        if(this.value == '') {
	            this.value = $(this).attr('title');
	            $(this).addClass('text-label');
	        }
	    });
	});    
	
});

function getResourcePath(){
	return getContextRoot()+"/resources";
}

function saveOrganization(){
	var reqErr = false;
	var isMethodSuccessfull = false;
	removeErrorMessage();
	reqErr = !isRequiredFieldsCompleted();
	if (reqErr) {
		showErrorMessage('organizationForm',null);
		return false;
	}
	
	$.ajax({
		  type    : 'POST',
		  url     : getContextRoot() + "/organization",
		  data 	  : 'userAction=save&'+$('#organizationForm').serialize(),
		  success: function(response) {
			    $.ajaxSetup({ cache: true });
	        	$('#organizationWizard').html(response);
			    isMethodSuccessfull = true;
	    	},
			error : function(data) {
				isMethodSuccessfull = false;
			}
		});
	
	return isMethodSuccessfull;
}

function saveEmployee() {
	var reqErr = false;
	var isMethodSuccessfull = false;
	removeErrorMessage();
	reqErr = !isRequiredFieldsCompleted();
	if (reqErr) {
		showErrorMessage('employeeForm', null);
		return false;
	}

	$.ajax({
		type : 'GET',
		url : getContextRoot() + "/employee",
		data : 'userAction=login&' + $('#employeeForm').serialize(),
		async : false,
		success : function(data) {
			 loadContent('body',getContextRoot() + '/getWizardPage','epatBody');
		},
		error : function(data) {
			isMethodSuccessfull = false;
		}
	});

	return isMethodSuccessfull;
}


function addTextBox(id, selectedValues){
		switch (id){
		case "orgGroup":
			tempOrgCount++;
			orgNumber++;
		    var orgValNumber = tempOrgCount;
		 	elementnumber='number'+orgValNumber;
			elementname='name'+orgValNumber;		
			elementName=id+orgValNumber;
			var temp="<tr class='txtLabel' id='"+elementName+"'>";
			    temp+="<td align='left'> Name: </td>";
				temp+="<td><input  type='text' id='"+elementnumber+"' name='organizationGroupForms["+orgValNumber+"].orgGroupName' class='required'/></td>";
				temp+="<td>&nbsp;<img src='"+getResourcePath()+"/delete.gif' onclick='removeTextBox(\""+id+"\", \""+elementName+"\");'/></td>";
				temp+="</tr>";
				orgCount=orgCount+1;
			  $('#organizationGroupTable tr:last').after(temp);
		  break;
		default:
		 break;
		}

	}	

function removeTextBox(tableId,id){
	switch (tableId)
	{
		case "orgGroup":
			removedOrg.push(id);
		  		orgCount=orgCount-1;
		  		break;
		default:
		  break;
	}
	$('#'+id).remove();
}	