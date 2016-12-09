$(document).ready(function(){
	var moviesJson =$.parseJSON(json);
	$(moviesJson).each(function(i,val){
			console.log(val);
			$("#movieTitle").attr("src",val.Poster);
	});
});
