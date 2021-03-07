$(document).ready(function() {

    $.get("http://localhost:8080/api/personnes",function(resp){
    	$.each(resp, function(index, item) {
    		console.log(item);
    		$('#list').append('<li id="personne-'+item.id+'" class="list-group-item">'+item.prenom+' '+item.age+' <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></li>');
    	});
    });
    
    $('#list').delegate("li button", "click", function() {
    	console.log(this);
    	var elemid = $(this).parent().attr('id');
    	
    	$.ajax({
		    type: "DELETE",
		    url: "http://localhost:8080/api/personnes/" + elemid.replace('personne-',''),
		    dataType: "json",
		    success: function(data){
		    	$("#"+elemid).remove();
		    }
		});	
    });
    
    $('#addbtn').click(function(){
		var prenom = $('#prenom-input').val();
		var age = $('#age-input').val();
		
		$.ajax({
		    type: "POST",
		    url: "http://localhost:8080/api/personnes",
		    data: JSON.stringify({ "prenom": prenom, "age" : age }),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		    	console.log(data);
		    	$('#list').append('<li id="personne-'+data.id+'" class="list-group-item">'+prenom+' '+age+' <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></li>');
		    }
		});
		
		
		$('#prenom-input').val('');
		$('#age-input').val('');
		return false;
	});
});