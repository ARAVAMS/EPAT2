var contextRoot = "/EPAT2";
var _errorDialog = null;
var asterisk = '<font class="asterisk">&nbsp;*</font>';
var reqErrorMsg = 'One or more required fields must be completed before saving.';


function getContextRoot(){
	return contextRoot;
}

function showErrorMessage(insertBeforeElementId,msg){
	if(msg == null){
		msg = reqErrorMsg;
	}
	var errorDiv ='<div id="error_Msg" class="error_msg" align="center" style="white-space: pre-wrap;">'+msg+'</div>';
	$("#"+insertBeforeElementId).before(errorDiv);
}

function removeErrorMessage(){
	 $('.asterisk').each(function () {
	        $(this).hide();
	    });
	$(".error_msg").each(function () {
       val = $(this).remove();
   });
}


function isRequiredFieldsCompleted(_elementId) {
    var isComplete = true;
    var elementToBeProcessed = '.required';
    if (_elementId != null) {
        elementToBeProcessed = '#' + _elementId + ' ' + elementToBeProcessed;
    }
    $(elementToBeProcessed).each(function () {
        val = $(this).val();
        if (val == null || $.trim(val) == "") {
            $(this).after(asterisk);
            isComplete = false;
        }
    });
    return isComplete;
}

function isRequiredFieldsCompleted() {
    isRequiredFieldsCompleted(null);
}

function isRequiredFieldsCompleted(_elementId) {
    var isComplete = true;
    var elementToBeProcessed = '.required';
    if (_elementId != null) {
        elementToBeProcessed = '#' + _elementId + ' ' + elementToBeProcessed;
    }
    $(elementToBeProcessed).each(function () {
        val = $(this).val();
        if (val == null || $.trim(val) == "") {
            $(this).after(asterisk);
            isComplete = false;
        }
    });
    return isComplete;
}

function isRequiredDropdownsSelected() {
	isRequiredDropdownsSelected(null);
}

function isRequiredDropdownsSelected(_elementId) {
    var isComplete = true;
    var elementToBeProcessed = '.requiredDropDown';
    if (_elementId != null) {
        elementToBeProcessed = '#' + _elementId + ' ' + elementToBeProcessed;
    }
    $(elementToBeProcessed).each(function () {
        val = $(this).val();
        if (val == null || val == "-1") {
            $(this).after(asterisk);
            isComplete = false;
        }
    });
    return isComplete;
}


function loadContent(_fragment,_url,responseContainer,_data,_async,_needUpdateInContext){
	var fragment = "fragments="+_fragment;
	if(arguments.length == 3){
		_data =null;
		_async = true;
		_needUpdateInContext = true;
	}else if(arguments.length == 4){
		_async = true;
		_needUpdateInContext = true;
	}else if(arguments.length == 5){
		_needUpdateInContext = true;
	}
	
	/*if(_needUpdateInContext){
		serializeAndSaveContext();
	}*/
	
	if(_data != null){
		_data = fragment+'&'+_data;
	}else{
		_data = fragment;
	}
	$.ajax({
        type : "GET",
        beforeSend : function(req) {
            req.setRequestHeader("Accept", "text/html;type=ajax");
        },
        async : _async,
        url : _url,
        data : _data,
        cache : true,
        success : function(response) {
        	$.ajaxSetup({ cache: true });
        	$('#'+responseContainer).html(response);
        }
    });
}

function loadContentLargeData(_fragment,_url,responseContainer,_data,_async,_needUpdateInContext){
	var fragment = "fragments="+_fragment;
	_blockUI();
	if(arguments.length == 3){
		_data =null;
		_async = true;
		_needUpdateInContext = true;
	}else if(arguments.length == 4){
		_async = true;
		_needUpdateInContext = true;
	}else if(arguments.length == 5){
		_needUpdateInContext = true;
	}
	
	if(_needUpdateInContext){
		serializeAndSaveContext();
	}
	
	if(_data != null){
		_data = fragment+'&'+_data;
	}else{
		_data = fragment;
	}
	//_blockUI();
	$.ajax({
        type : "POST",
        beforeSend : function(req) {
            req.setRequestHeader("Accept", "text/html;type=ajax");
        },
        async : _async,
        url : _url,
        data : _data,
        cache : true,
        success : function(response) {
        	$.ajaxSetup({ cache: true });
        	$('#'+responseContainer).html(response);
        }
    });
}

