$(document).ready(function() {
var currentLangCode = 'en';

// build the language selector's options
$.each($.fullCalendar.langs, function(langCode) {
	$('#lang-selector').append(
		$('<option/>')
			.attr('value', langCode)
			.prop('selected', langCode == currentLangCode)
			.text(langCode)
	);
});

// rerender the calendar when the selected option changes
$('#lang-selector').on('change', function() {
	if (this.value) {
		currentLangCode = this.value;
		$('#calendar').fullCalendar('destroy');
		renderCalendar();
	}
});

function renderCalendar() {
	var calendar =  $.getJSON('/EPAT2/getWorkingTime1', function (data) {
		alert('sss');
	$('#calendar').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		defaultDate: '2017-05-05',
		lang: currentLangCode,
		buttonIcons: false, // show the prev/next text
		weekNumbers: true,
		editable: true,
		eventLimit: true, // allow "more" link when too many events
		select: function(start
				, end, allDay) {
            var title = prompt('Event Title:');
            if (title) {
                calendar.fullCalendar('renderEvent',
                {
                    title: title,
                    start: start,
                    end: end,
                    allDay: allDay
                },
                        true // make the event "stick"
                        );
            }
            calendar.fullCalendar('unselect');
        },
        editable: true,
        events : data
		
	});
	
	 });
}

renderCalendar();
});
	 


function getResourcePath(){
	return getContextRoot();
}

