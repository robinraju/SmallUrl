$(document).ready(function() {
	$('#result-box').hide();
	$('#copy-alert').hide();
	$('#url_text').focus();
	
	$('#url_button').click(function() {
		var longurl = $('#url_text').val().trim();
		if (longurl == '') {
			$('#url_text').addClass("error");
			$('#url_text').effect("shake");
		} else {
			$.ajax({
				data : {
					'longUrl' : longurl
				},
				url : 'ShortenUrl',
				type : 'POST',
				success : function(response) {
					$('#result-box').slideDown().fadeIn();	
					$('#longurl').html(longurl);
					$('#smallurl').html(response);
					console.log(response);
				}
			});
		}
	});
	
	$('#url_text').focus(function() {
		$('#url_text').removeClass("error");
	});
	/*
	 * Copy to clipboard
	 * */
	$('#btn-copy').click(function(){
		console.log("......");
		var clipBoard = new Clipboard('#btn-copy',{
			target: function(){
				return document.querySelector('#smallurl');
			}
		});
		clipBoard.on('success', function(e) {
		    $('#copy-alert').delay(200).fadeIn().delay(3000).fadeOut();   
			console.log(e);
		});

		clipBoard.on('error', function(e) {
			console.log(e);
		});
	});
	
	/*
	 * Reset on button click
	 * */
	$('#btn-reset').click(function(){
		$('#result-box').slideUp().fadeOut();
		$('#url_text').val('');
	});
	$(document).on({
		ajaxStart: function(){
			$('#url_button').empty();
			$('#url_button').html("<span id='loader' class='ajax-loader'></span>");
		},
		ajaxComplete: function(){
			$('#url_button').remove('#loader');
			$('#url_button').html("Shorten");
		}
	});
});
