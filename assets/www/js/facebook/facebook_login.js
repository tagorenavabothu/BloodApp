function fbInit(){
		document.addEventListener('deviceready', function() {
		try {
				FB.init({
					appId : "1632254333687368",
					nativeInterface : CDV.FB,
					useCachedDialogs : false
				});
				login();
			} catch (e) {
				alert(e);
			}
		}, false);
 }

//appId : "1494574784111358",


function profile() {
	FB.api('/me',{fields:'first_name,last_name,gender,id,name,email,birthday'},function(response) {
		
		
		alert(response.first_name);
		//localStorage.setItem("facebook",1);
		//localStorage.setItem("first_name", response.first_name);
		//localStorage.setItem("last_name", response.last_name);
		//localStorage.setItem("gender", response.gender);
		//localStorage.setItem("email", response.email);
		//localStorage.setItem("name",response.name);
		//localStorage.setItem("fb_id", response.id);
		//var pic="http://graph.facebook.com/"+response.id+"/picture?width=200&height=200";
	//	console.log("picture url    "+pic);
		//localStorage.setItem("profilePic",pic);
		//location.reload();
		navigator.notification.activityStop();
		//getLoginDetails();
	});
	/*FB.api('/me/picture?width=200&height=200',function(response) {
		localStorage.setItem("picture", response.data.url);
		
	});*/
}
function login() {
	FB.login(function(response) {
		if (response.authResponse) {
			profile();
		} else {
			alert('not logged in');
		}
	}, {
		scope : "email,public_profile ,user_birthday"
	});
}


