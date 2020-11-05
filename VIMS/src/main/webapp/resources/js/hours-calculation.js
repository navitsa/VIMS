/**
 * 
 */

function append(dl, dtTxt, ddTxt) {
	var dt = document.createElement("dt");
	var dd = document.createElement("dd");
	dt.textContent = dtTxt;
	dd.textContent = ddTxt;
	dl.appendChild(dt);
	dl.appendChild(dd);
}

$(document).ready(
		function() {

			var today = new Date();
			$('#d1').val(
					today.getFullYear() + "-"
							+ ('0' + (today.getMonth() + 1)).slice(-2) + "-"
							+ ('0' + (today.getDate() + 1)).slice(-2));
			$('#d2').val($('#d1').val());
			$('#openTime').val('00:00');
			$('#closeTime').val('12:00');
			//
			// $('#d1 #d2 #t1 #t2').
			$('#d1, #d2, #openTime, #closeTime').on(
					'change',
					function(ev) {
						var dl = document.getElementById("diff");
						while (dl.hasChildNodes()) {
							dl.removeChild(dl.lastChild);
						}

						var date1 = new Date($('#d1').val() + " "
								+ $('#openTime').val()).getTime();
						var date2 = new Date($('#d2').val() + " "
								+ $('#closeTime').val()).getTime();
						var msec = date2 - date1;
						var mins = Math.floor(msec / 60000);
						var hrs = Math.floor(mins / 60);
						var days = Math.floor(hrs / 24);
						var yrs = Math.floor(days / 365);

						mins = mins % 60;
						append(dl, hrs + " hours, " + mins + " minutes");
						hrs = hrs % 24;

					});

			// trigger change
			$('#openTime').change();

		});
